package com.luv2code.spring.cruddemo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.spring.cruddemo.entity.Employee;
import com.luv2code.spring.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.apache.tomcat.jni.SSLConf.apply;

@RestController
@RequestMapping ("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService,ObjectMapper objectMapper){
        this.employeeService=employeeService;
        this.objectMapper=objectMapper;
    }



    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);

        if(theEmployee==null){
            throw new RuntimeException("Employee id not found -"+employeeId);

        }
        return theEmployee;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee){
        newEmployee.setId(0);

        return employeeService.save(newEmployee);

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee newEmployee){
        Employee dbEmployee = employeeService.save(newEmployee);
        return dbEmployee;
    }


    //add mapping request method for Patch/employees/{employeeid} - patch employee partial emp id  .... partial update

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayLoad){
        Employee tempEmployee=employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body - "+employeeId);
        }
        Employee patchEmployee=apply(patchPayLoad,tempEmployee);

        Employee dbEmployee=employeeService.save(patchEmployee);

        return dbEmployee;

    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmployee) {

        ObjectNode employeeNode=objectMapper.convertValue(tempEmployee,ObjectNode.class);

        ObjectNode patchNode=objectMapper.convertValue(patchPayLoad,ObjectNode.class);

        employeeNode.setAll(patchNode);

        return  objectMapper.convertValue(employeeNode,Employee.class);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - "+employeeId;
    }


}
