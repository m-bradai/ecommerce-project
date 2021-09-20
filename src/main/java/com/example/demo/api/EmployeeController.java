package com.example.demo.api;

import com.example.demo.pojos.Employee;
import com.example.demo.pojos.OrgChartNode;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getAllEmloyees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/orgchartnodes")
    public List<Object> getAllChartNodes(){
        List<Object> objects = new ArrayList<>();

        objects.add(Arrays.asList("Name", "Manager", "ToolTip"));

        List<Employee> employees = employeeService.getAllEmployees();

        employees.forEach(employee->
                {
                    List<Object> node = new ArrayList<>();

                    OrgChartNode orgChartNode = new OrgChartNode();
                    orgChartNode.setF( employee.getId().toString());
                    orgChartNode.setV(employee.getFirstname() + " " + employee.getName()+ ":" + employee.getDescription());
                    node.add(orgChartNode);
                    node.add(employee.getManager()!=null?employee.getManager().getId().toString():null);
                    node.add("");

                    objects.add(node);
                }
                );

        return objects;
    }

}
