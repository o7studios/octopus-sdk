package studio.o7.dto.log;

public record LogCreateRequest(
   String namespace,
   String targetId,
   String level,
   String message
) {}
