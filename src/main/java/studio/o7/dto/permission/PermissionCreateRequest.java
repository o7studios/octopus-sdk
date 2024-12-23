package studio.o7.dto.permission;

import java.util.Date;

public record PermissionCreateRequest(
        String namespace,
        String targetId,
        String permissionNode,
        String permissionValue,
        Integer permissionPriority,
        Date expiresAt
) {
}
