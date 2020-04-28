/*
 * @(#)BatchConfig.java
 */
package com.example.hrms.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.example.hrms.dao.EmployeeDao;
import com.example.hrms.model.Employee;
import com.example.hrms.step.Listener;
import com.example.hrms.step.Processor;
import com.example.hrms.step.Writer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.PostgresPagingQueryProvider;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * Configure the Batch Job.
 * 
 * @author Su Su Paing
 *
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfig {

    /**
     * Creates a job builder Factory and initializes its job repository.
     */
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    /**
     * Creates a step builder and initializes its job repository and transaction
     * manager.
     */
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    /**
     * DAO of the Employee.
     */
    @Autowired
    public EmployeeDao dao;

    /**
    * 
    */
    @Autowired
    DataSource datasource;

    /**
     * Job For Employee Management System.
     * 
     * @return Job
     * @throws UnexpectedInputException
     * @throws ParseException
     * @throws Exception
     */
    @Bean
    public Job job() throws UnexpectedInputException, ParseException, Exception {
        return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(dao))
                .start(step1()).next(step2()).build();
    }

    /**
     * Step for the Read Excel and Insert data into the database.
     * 
     * @return Step
     * @throws UnexpectedInputException
     * @throws ParseException
     * @throws Exception
     */
    @Bean
    public Step step1() throws UnexpectedInputException, ParseException, Exception {
        return stepBuilderFactory.get("step1").<Employee, Employee>chunk(13).reader(excelEmployeeReader())
                .processor(new Processor()).writer(new Writer(dao)).build();
    }

    /**
     * Step for the Select data from the database and insert into the CSV File.
     * 
     * @return Step
     * @throws UnexpectedInputException
     * @throws ParseException
     * @throws Exception
     */
    @Bean
    Step step2() throws UnexpectedInputException, ParseException, Exception {
        return stepBuilderFactory.get("step2").<Employee, Employee>chunk(13).reader(databaseCsvItemReader())
                .processor(new Processor()).writer(databaseCsvItemWriter()).build();
    }

    /**
     * Read data from the database.
     * 
     * @return ItemReader<Employee>
     */
    @Bean
    ItemReader<Employee> databaseCsvItemReader() {
        JdbcPagingItemReader<Employee> databaseReader = new JdbcPagingItemReader<>();

        databaseReader.setDataSource(datasource);
        databaseReader.setPageSize(100);
        databaseReader.setRowMapper(new BeanPropertyRowMapper<>(Employee.class));

        PagingQueryProvider queryProvider = createQueryProvider();
        databaseReader.setQueryProvider(queryProvider);

        return databaseReader;
    }

    /**
     * Sort By DepartmentId.
     * 
     * @return Map<String, Order>
     */
    private Map<String, Order> sortByDepartmentId() {
        Map<String, Order> sortConfiguration = new HashMap<>();
        sortConfiguration.put("department_id", Order.ASCENDING);
        return sortConfiguration;
    }

    /**
     * Select data from database.
     * 
     * @return PagingQueryProvider
     */
    private PagingQueryProvider createQueryProvider() {
        PostgresPagingQueryProvider queryProvider = new PostgresPagingQueryProvider();
        queryProvider.setSelectClause(
                "SELECT employee_id,jp_level_id,department_id,position_id,employee_name,date_of_birth,gender,join_date,material_status,email,phone_number,start_time,end_time");
        queryProvider.setFromClause("FROM employee");
        queryProvider.setSortKeys(sortByDepartmentId());
        return queryProvider;
    }

    /**
     * Write data into the CSV File.
     * 
     * @return ItemWriter<Employee>
     */
    @Bean
    FlatFileItemWriter<Employee> databaseCsvItemWriter() {
        FlatFileItemWriter<Employee> csvFileWriter = new FlatFileItemWriter<>();

        String exportFileHeader = "employee_id,jp_level_id,department_id,position_id,employee_name,date_of_birth,gender,join_date,material_status,email,phone_number,start_time,end_time";
        StringHeaderWriter headerWriter = new StringHeaderWriter(exportFileHeader);
        csvFileWriter.setHeaderCallback(headerWriter);

        String exportFilePath = "/tmp/employee.csv";
        csvFileWriter.setResource(new FileSystemResource(exportFilePath));

        LineAggregator<Employee> lineAggregator = createEmployeeLineAggregator();
        csvFileWriter.setLineAggregator(lineAggregator);
        return csvFileWriter;
    }

    /**
     * Create Employee Line Aggregator.
     * 
     * @return LineAggregator<Employee>
     */
    private LineAggregator<Employee> createEmployeeLineAggregator() {
        DelimitedLineAggregator<Employee> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        FieldExtractor<Employee> fieldExtractor = createEmployeeFieldExtractor();
        lineAggregator.setFieldExtractor(fieldExtractor);

        return lineAggregator;
    }

    /**
     * Create Field Extractor.
     * 
     * @return FieldExtractor<Employee>
     */
    private FieldExtractor<Employee> createEmployeeFieldExtractor() {
        BeanWrapperFieldExtractor<Employee> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[] { "employee_id", "jp_level_id", "department_id", "position_id", "employee_name",
                "date_of_birth", "gender", "join_date", "material_status", "email", "phone_number", "start_time",
                "end_time" });
        return extractor;
    }

    /**
     * Read the Excel file.
     * 
     * @return Employee
     * @throws UnexpectedInputException
     * @throws ParseException
     * @throws Exception
     */
    @Bean
    ItemReader<Employee> excelEmployeeReader() throws UnexpectedInputException, ParseException, Exception {
        PoiItemReader<Employee> reader = new PoiItemReader<>();
        reader.setResource(new ClassPathResource("Employee-data.xlsx"));
        reader.setRowMapper(excelRowMapper());
        return reader;
    }

    /***
     * Map rows from an excel sheet to an object.
     * 
     * @return Employee
     */
    private RowMapper<Employee> excelRowMapper() {
        return new EmployeeExcelRowMapper();
    }
}