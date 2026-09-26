package io.joborchestrator.job.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateJobRequest(
        @NotBlank
        @Size(max = 255)
        String name
) {}
