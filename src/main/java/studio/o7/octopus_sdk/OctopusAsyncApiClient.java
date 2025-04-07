package studio.o7.octopus_sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import studio.o7.octopus_sdk.client.AsyncApiClient;
import studio.o7.octopus_sdk.dto.ApiResponse;
import studio.o7.octopus_sdk.dto.attribute.AttributeCreateRequest;
import studio.o7.octopus_sdk.dto.attribute.AttributeQueryRequest;
import studio.o7.octopus_sdk.dto.attribute.AttributeResponse;
import studio.o7.octopus_sdk.dto.generic.GenericCreateRequest;
import studio.o7.octopus_sdk.dto.generic.GenericQueryRequest;
import studio.o7.octopus_sdk.dto.generic.GenericResponse;
import studio.o7.octopus_sdk.dto.log.LogCreateRequest;
import studio.o7.octopus_sdk.dto.log.LogQueryRequest;
import studio.o7.octopus_sdk.dto.log.LogResponse;
import studio.o7.octopus_sdk.dto.permission.PermissionCreateRequest;
import studio.o7.octopus_sdk.dto.permission.PermissionQueryRequest;
import studio.o7.octopus_sdk.dto.permission.PermissionResponse;
import studio.o7.octopus_sdk.dto.restore.RestoreRequest;
import studio.o7.octopus_sdk.dto.restore.RestoreResponse;
import studio.o7.octopus_sdk.dto.stat.StatCreateRequest;
import studio.o7.octopus_sdk.dto.stat.StatQueryRequest;
import studio.o7.octopus_sdk.dto.stat.StatResponse;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OctopusAsyncApiClient implements AsyncApiClient {

    private final String baseUrl;

    public OctopusAsyncApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public URI getURI(String suffix) {
        return URI.create(baseUrl + suffix);
    }

    @Override
    public <T, S> CompletableFuture<T> postAsync(S request, URI route, Type type) {
        HttpRequest httpRequest = newRequest(request, route);
        try (HttpClient client = HttpClient.newHttpClient()) {
            CompletableFuture<HttpResponse<String>> response = client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.thenApply(body -> new Gson().fromJson(body.body(), type));
        }
    }

    @Override
    public <T> HttpRequest newRequest(T request, URI route) {
        String json = new Gson().toJson(request);
        return HttpRequest.newBuilder().uri(route).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
    }

    @Override
    public CompletableFuture<ApiResponse<AttributeResponse>> createRoleAttributeAsync(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteRoleAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);    }

    @Override
    public CompletableFuture<ApiResponse<List<AttributeResponse>>> getRoleAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<PermissionResponse>> createRolePermissionAsync(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteRolePermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<PermissionResponse>>> getRolePermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<AttributeResponse>> createServerAttributeAsync(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteServerAttributeAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<AttributeResponse>>> getServerAttributeAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<StatResponse>> createServerStatAsync(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteServerStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<StatResponse>>> getServerStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<AttributeResponse>> createUserAttributeAsync(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<AttributeResponse>>> getUserAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<PermissionResponse>> createUserPermissionAsync(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserPermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<PermissionResponse>>> getUserPermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<StatResponse>> createUserStatAsync(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<StatResponse>>> getUserStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<LogResponse>> createUserLogAsync(LogCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, LogResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserLogAsync(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<LogResponse>>> getUserLogAsync(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, LogResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<RestoreResponse>> restoreServer(RestoreRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/restore");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, RestoreResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public <T> CompletableFuture<ApiResponse<GenericResponse<T>>> createGenericEntry(GenericCreateRequest<T> request) {
        URI route = URI.create(getBaseUrl() + "/generic/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, GenericResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteGenericEntry(GenericQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/generic/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public <T> CompletableFuture<ApiResponse<GenericResponse<T>>> queryGenericEntry(GenericQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/generic/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, GenericResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public <T> CompletableFuture<ApiResponse<List<GenericResponse<T>>>> findGenericEntries(GenericQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/generic/find");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, GenericResponse.class).getType();
        return postAsync(request, route, responseType);
    }
}
