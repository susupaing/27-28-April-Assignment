/*
 * @(#)Processor.java
 */
package com.example.hrms.step;

import org.springframework.batch.item.ItemProcessor;
import com.example.hrms.model.Employee;

/**
 * 
 * Processing the provided item.
 * 
 * @author Su Su Paing
 *
 */
public class Processor implements ItemProcessor<Employee, Employee> {

    /**
     * Process the provided item, returning a potentially modified or new item for
     * continued processing.
     * 
     * @param employee Employee
     * @return Employee
     */
    @Override
    public Employee process(Employee employee) throws Exception {
        final String employeeId = employee.getEmployee_id();
        final String jpLevelId = employee.getJp_level_id();
        final String departmentId = employee.getDepartment_id();
        final String positionId = employee.getPosition_id();
        final String employeeName = employee.getEmployee_name();
        final String dateOfBirth = employee.getDate_of_birth();
        final String gender = employee.getGender();
        final String joinDate = employee.getJoin_date();
        final String materialStatus = employee.getMaterial_status();
        final String email = employee.getEmail();
        final String phoneNumber = employee.getPhone_number();
        final String startTime = employee.getStart_time();
        final String endTime = employee.getEnd_time();
        final Employee fixedEmployee = new Employee(employeeId, jpLevelId, departmentId, positionId, employeeName,
                dateOfBirth, gender, joinDate, materialStatus, email, phoneNumber, startTime, endTime);
        return fixedEmployee;
    }
}