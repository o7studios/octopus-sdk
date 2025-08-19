package studio.o7.octopus.sdk;

import io.grpc.ManagedChannel;
import io.grpc.okhttp.OkHttpChannelBuilder;
import lombok.experimental.UtilityClass;
import studio.o7.octopus.sdk.gen.api.v1.OctopusGrpc;

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

        channel = OkHttpChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

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
