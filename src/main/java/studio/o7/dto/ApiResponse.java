package studio.o7.dto;

public record ApiResponse<T>(Integer code, T body){}
