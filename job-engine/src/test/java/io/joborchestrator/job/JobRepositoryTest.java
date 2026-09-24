package io.joborchestrator.job;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Test
    void shouldSaveAndRetrieveJob() {
        Job job = new Job();

        job.setName("Test Job");
        job.setStatus("PENDING");

        LocalDateTime now = LocalDateTime.now();
        job.setCreatedAt(now);
        job.setUpdatedAt(now);

        Job savedJob = jobRepository.save(job);

        assertThat(savedJob.getId()).isNotNull();

        Job retrievedJob = jobRepository.findById(savedJob.getId())
                .orElseThrow();

        assertThat(retrievedJob.getName()).isEqualTo("Test Job");
        assertThat(retrievedJob.getStatus()).isEqualTo("PENDING");
    }
}