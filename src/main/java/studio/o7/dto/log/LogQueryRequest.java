package studio.o7.dto.log;

import java.util.Date;

public record LogQueryRequest(
   String namespace,
   String targetId,
   String level,
   Date after,
   Date before
) {}
