package io.joborchestrator.job.dto;

import java.time.LocalDateTime;

public record JobResponse(
        Long id,
        String name,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}