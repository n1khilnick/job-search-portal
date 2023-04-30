package com.geekster.jobsearchportal.repository;

import com.geekster.jobsearchportal.enums.JobType;
import com.geekster.jobsearchportal.model.Jobs;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobDao extends CrudRepository<Jobs,Long> {
   List<Jobs> findAllById(Long id);


   @Modifying
   @Query(value = "Update Jobs set JOB_TYPE = :jobType where ID = :id",nativeQuery = true)
   void updateJobTypeById(Long id, String jobType);

   @Modifying
   @Query(value ="Select * from Jobs where JOB_TYPE = :jobType",nativeQuery = true)
   Iterable<Jobs> findJobsByJobType(String jobType);


   Iterable<Jobs> findByTitleAndDescription(String title, String description);
}
