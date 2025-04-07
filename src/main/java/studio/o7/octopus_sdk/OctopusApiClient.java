package studio.o7.octopus_sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import studio.o7.octopus_sdk.client.ApiClient;
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

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class OctopusApiClient implements ApiClient {

    private final String baseUrl;

    public OctopusApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public URI getURI(String suffix) {
        return URI.create(baseUrl + suffix);
    }

    @Override
    public <T, S> T post(S request, URI route, Type type) {
        HttpRequest httpRequest = newRequest(request, route);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), type);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> HttpRequest newRequest(T request, URI route) {
        String json = new Gson().toJson(request);
        return HttpRequest.newBuilder().uri(route).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
    }

    @Override
    public ApiResponse<AttributeResponse> createRoleAttribute(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteRoleAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<AttributeResponse>> getRoleAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<PermissionResponse> createRolePermission(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteRolePermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<PermissionResponse>> getRolePermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<AttributeResponse> createServerAttribute(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteServerAttribute(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<AttributeResponse>> getServerAttribute(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<StatResponse> createServerStat(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteServerStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<StatResponse>> getServerStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<AttributeResponse> createUserAttribute(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<AttributeResponse>> getUserAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<PermissionResponse> createUserPermission(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserPermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<PermissionResponse>> getUserPermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<StatResponse> createUserStat(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<StatResponse>> getUserStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<LogResponse> createUserLog(LogCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, LogResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserLog(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<LogResponse>> getUserLog(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, LogResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<RestoreResponse> restoreServer(RestoreRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/restore");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, RestoreResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public <T> ApiResponse<GenericResponse<T>> createGenericEntry(GenericCreateRequest<T> request) {
        URI route = URI.create(getBaseUrl() + "/generic/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, GenericResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteGenericEntry(GenericQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/generic/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public <T> ApiResponse<GenericResponse<T>> queryGenericEntry(GenericQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/generic/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, GenericResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public <T> ApiResponse<List<GenericResponse<T>>> findGenericEntries(GenericQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/generic/find");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, GenericResponse.class).getType();
        return post(request, route, responseType);
    }
}