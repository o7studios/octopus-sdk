# Octopus SDK

## Create HTTP Requests

### Sync
```java
OctopusApiClient client = new OctopusApiClient("https://o7.studio/octopus/api/v1"); //or local -> http://127.0.0.1:8080/api/v1
AttributeCreateRequest request = new AttributeCreateRequest(
        "ghosthouse", 
        "7501a26e-f139-41a6-a089-0a403148f58c", 
        "favourite_map", 
        "mansion", 
        null
);
ApiResult<AttributeResponse> response = client.createRoleAttribute(request);

response.code(); //HTTP response code
response.body(); //Body --> in this example: AttributeResponse
```

### Async
```java        
OctopusAsyncApiClient asyncClient = new OctopusAsyncApiClient("https://o7.studio/octopus/api/v1"); //or local -> http://127.0.0.1:8080/api/v1
AttributeCreateRequest request = new AttributeCreateRequest(
        "ghosthouse",
        "7501a26e-f139-41a6-a089-0a403148f58c",
        "favourite_map",
        "mansion",
        null
);
asyncClient.createRoleAttributeAsync(request).thenAccept(response -> {
    response.code(); //HTTP response code
    response.body(); //Body --> in this example: AttributeResponse
});
```