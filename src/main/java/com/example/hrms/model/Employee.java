/*
 * @(#)Employee.java
 */
package com.example.hrms.model;

/**
 * Employee Information Object.
 * 
 * @author Su Su Paing
 *
 */
public class Employee {

    /**
     * Employee Id of the Employee.
     */
    private String employee_id;

    /**
     * Japanese Level Id that concerned with the Employee Id.
     */
    private String jp_level_id;

    /**
     * Department Id that concerned with the Employee Id.
     */
    private String department_id;

    /**
     * Position Id that concerned with the Employee Id.
     */
    private String position_id;

    /**
     * Employee Name of the Employee.
     */
    private String employee_name;

    /**
     * Date Of Birth of the Employee.
     */
    private String date_of_birth;

    /**
     * Gender of the Employee.
     */
    private String gender;

    /**
     * Joining Date of the Employee.
     */
    private String join_date;

    /**
     * Material Status of the Employee.
     */
    private String material_status;

    /**
     * Email of the Employee.
     */
    private String email;

    /**
     * Phone Number of the Employee.
     */
    private String phone_number;

    /**
     * Start Job Time of the Employee.
     */
    private String start_time;

    /**
     * End Job Time of the Employee.
     */
    private String end_time;

    /**
     * Default Constructor of the Employee.
     */
    public Employee() {
    }

    /**
     * Argument Constructor of the Employee.
     * 
     * @param employee_id     String
     * @param jp_level_id     String
     * @param department_id   String
     * @param position_id     String
     * @param employee_name   String
     * @param date_of_birth   String
     * @param gender          String
     * @param join_date       String
     * @param material_status String
     * @param email           String
     * @param phone_number    String
     * @param start_time      String
     * @param end_time        String
     */
    public Employee(String employee_id, String jp_level_id, String department_id, String position_id,
            String employee_name, String date_of_birth, String gender, String join_date, String material_status,
            String email, String phone_number, String start_time, String end_time) {
        this.employee_id = employee_id;
        this.jp_level_id = jp_level_id;
        this.department_id = department_id;
        this.position_id = position_id;
        this.employee_name = employee_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.join_date = join_date;
        this.material_status = material_status;
        this.email = email;
        this.phone_number = phone_number;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    /**
     * Getter Method of the Employee Id.
     * 
     * @return String value of EmployeeId
     */
    public String getEmployee_id() {
        return employee_id;
    }

    /**
     * Setter Method of the Employee Id.
     * 
     * @param String value of EmployeeId
     */
    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    /**
     * Getter Method of the Japanese Level Id.
     * 
     * @return String value of jp_level_id
     */
    public String getJp_level_id() {
        return jp_level_id;
    }

    /**
     * Setter Method of the Japanese Level Id.
     * 
     * @param String value of jp_level_id
     */
    public void setJp_level_id(String jp_level_id) {
        this.jp_level_id = jp_level_id;
    }

    /**
     * Getter Method of the Department Id.
     * 
     * @return String value of departmentId
     */
    public String getDepartment_id() {
        return department_id;
    }

    /**
     * Setter Method of the Department Id.
     * 
     * @param String value of departmentId
     */
    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    /**
     * Getter Method of the Position Id.
     * 
     * @return String value of position_id
     */
    public String getPosition_id() {
        return position_id;
    }

    /**
     * Setter Method of the Position Id.
     * 
     * @param String value of position_id
     */
    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    /**
     * Getter Method of the Employee Name.
     * 
     * @return String value of employee_name
     */
    public String getEmployee_name() {
        return employee_name;
    }

    /**
     * Setter Method of the Employee Name.
     * 
     * @param String value of employee_name
     */
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    /**
     * Getter Method of the Date Of Birth.
     * 
     * @return String value of date_of_birth
     */
    public String getDate_of_birth() {
        return date_of_birth;
    }

    /**
     * Setter Method of the Date Of Birth.
     * 
     * @param String value of date_of_birth
     */
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * Getter Method of the Gender.
     * 
     * @return String value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setter Method of the Gender.
     * 
     * @param String value of gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Getter Method of the join_date.
     * 
     * @return String value of join_date
     */
    public String getJoin_date() {
        return join_date;
    }

    /**
     * Setter Method of the join_date.
     * 
     * @param String value of join_date
     */
    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    /**
     * Getter Method of the material_status.
     * 
     * @return String value of material_status
     */
    public String getMaterial_status() {
        return material_status;
    }

    /**
     * Setter Method of the material_status.
     * 
     * @param String value of material_status
     */
    public void setMaterial_status(String material_status) {
        this.material_status = material_status;
    }

    /**
     * Getter Method of the Email.
     * 
     * @return String value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter Method of the Email.
     * 
     * @param String value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter Method of the Phone Number.
     * 
     * @return String value of phone_number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Setter Method of the Phone Number.
     * 
     * @param String value of phone_number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Getter Method of the Start Time.
     * 
     * @return String value of start_time
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     * Setter Method of the Start Time.
     * 
     * @param String value of start_time
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    /**
     * Getter Method of the End Time.
     * 
     * @return String value of end_time
     */
    public String getEnd_time() {
        return end_time;
    }

    /**
     * Setter Method of the End Time.
     * 
     * @param String value of end_time
     */
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    /**
     * To String Method of the Employee.
     * 
     * @return String value of Employee Object
     */
    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id + ", jp_level_id=" + jp_level_id + ", department_id="
                + department_id + ", position_id=" + position_id + ", employee_name=" + employee_name
                + ", date_of_birth=" + date_of_birth + ", gender=" + gender + ", join_date=" + join_date
                + ", material_status=" + material_status + ", email=" + email + ", phone_number=" + phone_number
                + ", start_time=" + start_time + ", end_time=" + end_time + "]";
    }
}