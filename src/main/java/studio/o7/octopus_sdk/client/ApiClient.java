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

public interface ApiClient {

    String getBaseUrl();

    URI getURI(String suffix);

    <T, S> T post(S request, URI route, Type type);

    <T> HttpRequest newRequest(T request, URI route);

    ApiResponse<AttributeResponse> createRoleAttribute(AttributeCreateRequest request);
    ApiResponse<Integer> deleteRoleAttributes(AttributeQueryRequest request);
    ApiResponse<List<AttributeResponse>> getRoleAttributes(AttributeQueryRequest request);

    ApiResponse<PermissionResponse> createRolePermission(PermissionCreateRequest request);
    ApiResponse<Integer> deleteRolePermission(PermissionQueryRequest request);
    ApiResponse<List<PermissionResponse>> getRolePermission(PermissionQueryRequest request);

    ApiResponse<AttributeResponse> createServerAttribute(AttributeCreateRequest request);
    ApiResponse<Integer> deleteServerAttribute(AttributeQueryRequest request);
    ApiResponse<List<AttributeResponse>> getServerAttribute(AttributeQueryRequest request);

    ApiResponse<StatResponse> createServerStat(StatCreateRequest request);
    ApiResponse<Integer> deleteServerStat(StatQueryRequest request);
    ApiResponse<List<StatResponse>> getServerStat(StatQueryRequest request);

    ApiResponse<AttributeResponse> createUserAttribute(AttributeCreateRequest request);
    ApiResponse<Integer> deleteUserAttributes(AttributeQueryRequest request);
    ApiResponse<List<AttributeResponse>> getUserAttributes(AttributeQueryRequest request);

    ApiResponse<PermissionResponse> createUserPermission(PermissionCreateRequest request);
    ApiResponse<Integer> deleteUserPermission(PermissionQueryRequest request);
    ApiResponse<List<PermissionResponse>> getUserPermission(PermissionQueryRequest request);

    ApiResponse<StatResponse> createUserStat(StatCreateRequest request);
    ApiResponse<Integer> deleteUserStat(StatQueryRequest request);
    ApiResponse<List<StatResponse>> getUserStat(StatQueryRequest request);

    ApiResponse<LogResponse> createUserLog(LogCreateRequest request);
    ApiResponse<Integer> deleteUserLog(LogQueryRequest request);
    ApiResponse<List<LogResponse>> getUserLog(LogQueryRequest request);

    ApiResponse<RestoreResponse> restoreServer(RestoreRequest request);

    <T> ApiResponse<GenericResponse<T>> createGenericEntry(GenericCreateRequest<T> request);
    ApiResponse<Integer> deleteGenericEntry(GenericQueryRequest request);
    <T> ApiResponse<GenericResponse<T>> queryGenericEntry(GenericQueryRequest request);
    <T> ApiResponse<List<GenericResponse<T>>> findGenericEntries(GenericQueryRequest request);
}

