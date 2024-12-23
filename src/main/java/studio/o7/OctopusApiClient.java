package studio.o7;

public class OctopusApiClient {

    private final String baseUrl;

    public OctopusApiClient(String baseUrl, String apiVersion) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
