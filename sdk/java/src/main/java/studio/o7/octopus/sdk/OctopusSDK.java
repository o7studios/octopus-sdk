package studio.o7.octopus.sdk;

import io.grpc.ManagedChannel;
import io.grpc.okhttp.OkHttpChannelBuilder;
import lombok.experimental.UtilityClass;
import studio.o7.octopus.sdk.gen.api.v1.OctopusServiceGrpc;

@UtilityClass
public class OctopusSDK {
    private final System.Logger logger = System.getLogger("Octopus");
    private ManagedChannel channel;
    private OctopusServiceGrpc.OctopusServiceStub stub;

    private OctopusServiceGrpc.OctopusServiceStub connect(String host, int port) {
        if (stub != null) return stub;
        if (channel == null)
            channel = OkHttpChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

        stub = OctopusServiceGrpc.newStub(channel);
        return stub;
    }

    public OctopusServiceGrpc.OctopusServiceStub connect() {
        var host = System.getProperty("octopus.host");
        var portString = System.getProperty("octopus.port");

        if (host == null || host.isEmpty()) {
            host = System.getenv("OCTOPUS_HOST");
            if (host == null || host.isEmpty())
                host = null;
        }

        if (portString == null || portString.isEmpty()) {
            portString = System.getenv("OCTOPUS_PORT");
            if (portString == null || portString.isEmpty())
                portString = null;
        }

        int port = 50051;

        if (portString != null) {
            try {
                port = Integer.parseInt(portString);
            } catch (Exception exception) {
                logger.log(System.Logger.Level.ERROR, "Invalid OCTOPUS_PORT '" + portString + "'");
            }
        }

        if (host == null) {
            host = "octopus";
        }

        return connect(host, port);
    }

    public synchronized void close() {
        if (channel != null) {
            channel.shutdownNow();
            channel = null;
            stub = null;
        }
    }
}
