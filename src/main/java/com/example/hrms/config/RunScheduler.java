/*
 * @(#)RunScheduler.java
 */
package com.example.hrms.config;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Schedule the Job.
 * 
 * @author Su Su Paing
 *
 */
@Component
public class RunScheduler {

    /**
     * JobLaucher starts the Job. It requires a Job and JobParameters, which may be
     * empty as in this case.
     */
    @Autowired
    JobLauncher jobLauncher;

    /**
     * Declare the Job.
     */
    @Autowired
    Job job;

    /**
     * Execute the Job at every 5 minutes.
     */
    @Scheduled(fixedRate = 300000)
    public void execute() {
        try {
            System.out.println("**********************Job Start**********************");
            String dateParam = new Date().toString();
            JobParameters jobParameters = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
            jobLauncher.run(job, jobParameters);
            System.out.println("Database are updated at " + dateParam);
            System.out.println("CSV File Exported");
            System.out.println("After 5 minutes, Job Will execute again...So, Please Wait...");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}