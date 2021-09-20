package com.example.demo.api;

import com.example.demo.pojos.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeesRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(EmployeesRunner .class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();
        Employee employee1 = new Employee(null,"Nasri","Khalid",LocalDate.of(1980,1,1),"M",
                LocalDate.of(2015,1,1),null,"Paris",null,null,"PDG",null,null);

        employeeRepository.save(employee1);

        Employee employee2 = new Employee(null,"Bradai","Mohammed",LocalDate.of(1983,1,1),"M",
                LocalDate.of(2021,9,20),null,"Paris",employee1,null,"Directeur des SI",null,null);

        employeeRepository.save(employee2);

    }
}
