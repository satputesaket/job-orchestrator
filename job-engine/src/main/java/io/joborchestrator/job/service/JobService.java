package io.joborchestrator.job.service;

import io.joborchestrator.job.JobRepository;
import io.joborchestrator.job.dto.JobResponse;
import io.joborchestrator.job.exception.JobNotFoundException;
import io.joborchestrator.job.mapper.JobMapper;
import io.joborchestrator.job.Job;

import java.util.List;

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
    
    public JobResponse getJob(Long id) {
        return jobRepository.findById(id).map(JobMapper::toDto)
        		.orElseThrow(() -> new JobNotFoundException(id));
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
}
