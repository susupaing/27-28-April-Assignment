/*
 * @(#)Writer.java
 */
package com.example.hrms.step;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import com.example.hrms.dao.EmployeeDao;
import com.example.hrms.model.Employee;

/**
 * Write data into the Database.
 * 
 * @author Su Su Paing
 *
 */
public class Writer implements ItemWriter<Employee> {

    /**
     * DAO of the Employee.
     */
    private final EmployeeDao EmployeeDao;

    /**
     * Argument Constructor of the Writer.
     * 
     * @param customerDao EmployeeDao
     */
    public Writer(EmployeeDao customerDao) {
        this.EmployeeDao = customerDao;
    }

    /**
     * Insert Employee Information into the Database.
     * 
     * @param employee
     */
    @Override
    public void write(List<? extends Employee> Employee) throws Exception {
        int totalCount = EmployeeDao.insertEmployee(Employee);
        System.out.println(totalCount + " rows are inserted or updated to Database.");
    }
}