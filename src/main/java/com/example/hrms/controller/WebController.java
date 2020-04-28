/*
 * @(#)WebController.java
 */
package com.example.hrms.controller;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hrms.config.RunScheduler;

/**
 * Simple Spring batch application to build a Restful controller.
 * 
 * @author Su Su Paing
 *
 */
@RestController
@EnableBatchProcessing
public class WebController {

    /**
    * Execute the Job.
    * 
    * @return String
    * @throws Exception
    */
    @RequestMapping("/runjob")
    public String handle() throws Exception {
        RunScheduler runScheduler = new RunScheduler();
        runScheduler.execute();
        return "Done! Check Console Window for more details";
    }
}