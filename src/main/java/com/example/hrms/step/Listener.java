/*
 * @(#)Listener.java
 */
package com.example.hrms.step;

import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import com.example.hrms.dao.EmployeeDao;

/**
 * Callback the Job.
 * 
 * @author Su Su Paing
 *
 */
public class Listener extends JobExecutionListenerSupport {

    /**
     * DAO of the Employee.
     */
    private final EmployeeDao employeeDao;

    /**
     * Argument constructor of the Listener.
     * 
     * @param employeeDao
     */
    public Listener(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}