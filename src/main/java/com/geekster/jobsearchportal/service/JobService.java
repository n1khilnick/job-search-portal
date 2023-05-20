package com.geekster.jobsearchportal.service;

import com.geekster.jobsearchportal.enums.JobType;
import com.geekster.jobsearchportal.model.Jobs;
import com.geekster.jobsearchportal.repository.IJobDao;
//import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobDao jobDao;


    public void addJobs(List<Jobs> jobsList) {
        Iterable<Jobs> addJobs = jobDao.saveAll(jobsList);
    }

    public Iterable<Jobs> getAllJobs() {
        return jobDao.findAll();
    }

    public Iterable<Jobs> fetchJobById(Long id) {
        if(id == null) return null;
        return jobDao.findAllById(id);
    }

    @Transactional
    public Iterable<Jobs> searchJobsByJobType(JobType jobType) {
        return jobDao.findJobsByJobType(jobType.toString());
    }

    @Transactional
    public Iterable<Jobs> searchJobsByTitleAndDescription(String title, String description) {
        if(title == null && description == null) return  null;
        else{
           return jobDao.findByTitleAndDescription(title,description);

        }
    }


    public String removeJobById(Long id) {
        if(id == null) return null;
        else{
            jobDao.deleteById(id);
            return "Job with id "+id+" is removed";
        }
    }


    @Transactional
    public String modifyJobTypeById(Long id, JobType jobType) {
        if(id == null && jobType ==null) return  null;
        else if(id != null) {
            jobDao.updateJobTypeById(id, jobType.toString());
            return "Job with id "+id+" is updated !!";
        }
        return "Id "+id+" doesn't exists !!";
    }


}
