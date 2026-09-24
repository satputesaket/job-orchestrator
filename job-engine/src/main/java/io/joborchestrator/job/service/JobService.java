package io.joborchestrator.job.service;

import io.joborchestrator.job.JobRepository;
import io.joborchestrator.job.Job;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(String name) {
        Job job = new Job();

        job.setName(name);
        job.setStatus("PENDING");

        return jobRepository.save(job);
    }
    
    public Job getJob(Long id) {
        return jobRepository.findById(id)
                .orElseThrow();
    }
    
}
