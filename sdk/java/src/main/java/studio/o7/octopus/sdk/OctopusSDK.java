package studio.o7.octopus.sdk;

import io.grpc.ManagedChannel;
import io.grpc.okhttp.OkHttpChannelBuilder;
import lombok.experimental.UtilityClass;
import studio.o7.octopus.sdk.gen.api.v1.OctopusServiceGrpc;

@UtilityClass
public class OctopusSDK {

    public OctopusServiceGrpc.OctopusServiceStub connect(String host, int port) {
        ManagedChannel channel = OkHttpChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        return OctopusServiceGrpc.newStub(channel);
    }

    public OctopusServiceGrpc.OctopusServiceStub connect() {
        var host = System.getProperty("octopus.host");
        var portString = System.getProperty("octopus.port");

        if (host.isEmpty()) {
            host = System.getenv("OCTOPUS_HOST");
            if (host.isEmpty())
                host = null;
        }

        if (portString.isEmpty()) {
            portString = System.getenv("OCTOPUS_PORT");
            if (portString.isEmpty())
                portString = null;
        }

        int port = 50051;

        if (portString != null) {
            try {
                port = Integer.parseInt(portString);
            } catch (Exception exception) {
                System.out.println("ERROR: Invalid OCTOPUS_PORT '" + portString + "'");
            }
        }

        if (host == null) {
            host = "octopus";
        }

        return connect(host, port);
    }
}
