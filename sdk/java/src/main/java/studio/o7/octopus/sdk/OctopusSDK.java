package studio.o7.octopus.sdk;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import lombok.experimental.UtilityClass;
import studio.o7.octopus.sdk.gen.api.v1.OctopusGrpc;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

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
            channel = NettyChannelBuilder.forAddress(host, port)
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

                var sslContext = GrpcSslContexts.forClient()
                        .trustManager(new ByteArrayInputStream(caCert.getBytes(StandardCharsets.UTF_8)))
                        .keyManager(
                                new ByteArrayInputStream(clientCert.getBytes(StandardCharsets.UTF_8)),
                                new ByteArrayInputStream(clientKey.getBytes(StandardCharsets.UTF_8))
                        )
                        .build();

                channel = NettyChannelBuilder.forAddress(host, port)
                        .sslContext(sslContext)
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
}
