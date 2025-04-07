package studio.o7.octopus_sdk.client;

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
import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncApiClient {

    String getBaseUrl();

    URI getURI(String suffix);

    <T, S> CompletableFuture<T> postAsync(S request, URI route, Type type);

    <T> HttpRequest newRequest(T request, URI route);
    CompletableFuture<ApiResponse<AttributeResponse>> createRoleAttributeAsync(AttributeCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteRoleAttributesAsync(AttributeQueryRequest request);
    CompletableFuture<ApiResponse<List<AttributeResponse>>> getRoleAttributesAsync(AttributeQueryRequest request);

    CompletableFuture<ApiResponse<PermissionResponse>> createRolePermissionAsync(PermissionCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteRolePermissionAsync(PermissionQueryRequest request);
    CompletableFuture<ApiResponse<List<PermissionResponse>>> getRolePermissionAsync(PermissionQueryRequest request);

    CompletableFuture<ApiResponse<AttributeResponse>> createServerAttributeAsync(AttributeCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteServerAttributeAsync(AttributeQueryRequest request);
    CompletableFuture<ApiResponse<List<AttributeResponse>>> getServerAttributeAsync(AttributeQueryRequest request);

    CompletableFuture<ApiResponse<StatResponse>> createServerStatAsync(StatCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteServerStatAsync(StatQueryRequest request);
    CompletableFuture<ApiResponse<List<StatResponse>>> getServerStatAsync(StatQueryRequest request);

    CompletableFuture<ApiResponse<AttributeResponse>> createUserAttributeAsync(AttributeCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserAttributesAsync(AttributeQueryRequest request);
    CompletableFuture<ApiResponse<List<AttributeResponse>>> getUserAttributesAsync(AttributeQueryRequest request);

    CompletableFuture<ApiResponse<PermissionResponse>> createUserPermissionAsync(PermissionCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserPermissionAsync(PermissionQueryRequest request);
    CompletableFuture<ApiResponse<List<PermissionResponse>>> getUserPermissionAsync(PermissionQueryRequest request);

    CompletableFuture<ApiResponse<StatResponse>> createUserStatAsync(StatCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserStatAsync(StatQueryRequest request);
    CompletableFuture<ApiResponse<List<StatResponse>>> getUserStatAsync(StatQueryRequest request);

    CompletableFuture<ApiResponse<LogResponse>> createUserLogAsync(LogCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserLogAsync(LogQueryRequest request);
    CompletableFuture<ApiResponse<List<LogResponse>>> getUserLogAsync(LogQueryRequest request);

    CompletableFuture<ApiResponse<RestoreResponse>> restoreServer(RestoreRequest request);

    <T> CompletableFuture<ApiResponse<GenericResponse<T>>> createGenericEntry(GenericCreateRequest<T> request);
    CompletableFuture<ApiResponse<Integer>> deleteGenericEntry(GenericQueryRequest request);
    <T> CompletableFuture<ApiResponse<GenericResponse<T>>> queryGenericEntry(GenericQueryRequest request);
    <T> CompletableFuture<ApiResponse<List<GenericResponse<T>>>> findGenericEntries(GenericQueryRequest request);
}
