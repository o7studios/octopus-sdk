package studio.o7.octopus.sdk;

import io.grpc.ManagedChannel;
import io.grpc.okhttp.OkHttpChannelBuilder;
import lombok.experimental.UtilityClass;
import studio.o7.octopus.sdk.gen.api.v1.OctopusGrpc;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@UtilityClass
public class OctopusSDK {
    private final System.Logger logger = System.getLogger("Octopus");

    private ManagedChannel channel;
    private OctopusGrpc.OctopusStub stub;
    private OctopusGrpc.OctopusBlockingStub blockingStub;
    private OctopusGrpc.OctopusFutureStub futureStub;

    public synchronized OctopusGrpc.OctopusStub stub() {
        if (stub != null) return stub;
        stub = OctopusGrpc.newStub(connect());
        return stub;
    }

    public synchronized OctopusGrpc.OctopusBlockingStub blockingStub() {
        if (blockingStub != null) return blockingStub;
        blockingStub = OctopusGrpc.newBlockingStub(connect());
        return blockingStub;
    }

    public synchronized OctopusGrpc.OctopusFutureStub futureStub() {
        if (futureStub != null) return futureStub;
        futureStub = OctopusGrpc.newFutureStub(connect());
        return futureStub;
    }

    private synchronized ManagedChannel connect() {
        if (channel != null) return channel;
        var host = System.getProperty("octopus.host", System.getenv("OCTOPUS_HOST"));
        var portString = System.getProperty("octopus.port", System.getenv("OCTOPUS_PORT"));

        if (host == null || host.isEmpty()) host = "octopus";

        int port = 50051;

        if (portString != null) {
            try {
                port = Integer.parseInt(portString);
            } catch (Exception exception) {
                logger.log(System.Logger.Level.ERROR, "Invalid OCTOPUS_PORT '" + portString + "'");
            }
        }

        String env = System.getProperty("octopus.env", System.getenv("OCTOPUS_ENVIRONMENT"));

        if ("dev".equals(env)) {
            channel = OkHttpChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();
        } else {
            try {
                String clientCert = System.getProperty("octopus.client.cert", System.getenv("OCTOPUS_CLIENT_CERT"));
                String clientKey = System.getProperty("octopus.client.key", System.getenv("OCTOPUS_CLIENT_KEY"));
                String caCert = System.getProperty("octopus.ca.cert", System.getenv("OCTOPUS_CA_CERT"));

                if (clientCert == null || clientKey == null || caCert == null) {
                    throw new IllegalStateException(
                            "In non-dev environments, `OCTOPUS_CLIENT_CERT`, `OCTOPUS_CLIENT_KEY` and `OCTOPUS_CA_CERT` must be set"
                    );
                }

                SSLContext sslContext = buildSslContext(clientCert, clientKey, caCert);

                channel = OkHttpChannelBuilder.forAddress(host, port)
                        .sslSocketFactory(sslContext.getSocketFactory())
                        .build();
            } catch (Exception exception) {
                throw new RuntimeException("Failed to setup gRPC TLS channel", exception);
            }
        }

        return channel;
    }

    public synchronized void close() {
        if (channel == null) return;
        channel.shutdownNow();
        channel = null;
        stub = null;
        blockingStub = null;
        futureStub = null;
    }

    private SSLContext buildSslContext(String clientCertPem, String clientKeyPem, String caCertPem) throws Exception {
        // CA
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate caCert = (X509Certificate) cf.generateCertificate(
                new ByteArrayInputStream(caCertPem.getBytes(StandardCharsets.UTF_8))
        );

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null);
        trustStore.setCertificateEntry("caCert", caCert);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Client Key/Cert
        X509Certificate clientCert = (X509Certificate) cf.generateCertificate(
                new ByteArrayInputStream(clientCertPem.getBytes(StandardCharsets.UTF_8))
        );

        String privateKeyPEM = clientKeyPem
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyPEM);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null);
        keyStore.setKeyEntry("client", privateKey, "".toCharArray(), new java.security.cert.Certificate[]{clientCert});

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return sslContext;
    }
}
