package io.joborchestrator.job.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import io.joborchestrator.job.JobRepository;
import io.joborchestrator.job.Job;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    @Test
    void shouldCreateJob() {
        Job savedJob = new Job();
        savedJob.setName("Test Job");
        savedJob.setStatus("PENDING");

        when(jobRepository.save(any(Job.class)))
                .thenReturn(savedJob);

        Job result = jobService.createJob("Test Job");

        assertThat(result.getName()).isEqualTo("Test Job");
        assertThat(result.getStatus()).isEqualTo("PENDING");
    }
}