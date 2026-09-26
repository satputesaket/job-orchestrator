package io.joborchestrator.job.mapper;

import org.springframework.stereotype.Component;

import io.joborchestrator.job.Job;
import io.joborchestrator.job.dto.JobResponse;

@Component
public class JobMapper {

	public static JobResponse toDto(Job job) {
		return new JobResponse(
				job.getId(),
				job.getName(),
				job.getStatus(),
				job.getCreatedAt(),
				job.getUpdatedAt());
	}
}