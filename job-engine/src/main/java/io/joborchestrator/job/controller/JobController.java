package io.joborchestrator.job.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.joborchestrator.job.Job;
import io.joborchestrator.job.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Job createJob(@RequestParam String name) {
        return jobService.createJob(name);
    }
    
    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) {
        return jobService.getJob(id);
    }
}