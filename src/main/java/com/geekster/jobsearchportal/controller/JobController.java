package com.geekster.jobsearchportal.controller;

import com.geekster.jobsearchportal.enums.JobType;
import com.geekster.jobsearchportal.model.Jobs;
import com.geekster.jobsearchportal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "jobs")
public class JobController {
    @Autowired
    JobService jobService;


    @PostMapping(value = "/save")
    public String saveJobs(@Valid @RequestBody List<Jobs> jobsList){
        jobService.addJobs(jobsList);
        return "Jobs added !";
    }

    @GetMapping(value = "/getAll")
    public Iterable<Jobs> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping(value = "/{id}")
    public Iterable<Jobs> getJobById (@PathVariable Long id){
        return jobService.fetchJobById(id);
    }

    @GetMapping(value = "/searchJobs/jobType/{jobType}")
    public Iterable<Jobs> getJobsByJobType(@PathVariable JobType jobType){
        return jobService.searchJobsByJobType(jobType);
    }

    @GetMapping(value = "/searchJobs/title/{title}/description/{description}")
    public Iterable<Jobs> getJobsByTitleAndDescription(@PathVariable String title,@PathVariable String description){
        return jobService.searchJobsByTitleAndDescription(title,description);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteJobById(@PathVariable Long id){
        return jobService.removeJobById(id);
    }

    @PutMapping(value = "/update/{id}/{jobType}")
    public String updateJobTypeById(@PathVariable Long id, @PathVariable JobType jobType){
        return jobService.modifyJobTypeById(id, jobType);
    }
}
