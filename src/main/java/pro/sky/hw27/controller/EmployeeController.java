package pro.sky.hw27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw27.Employee;
import pro.sky.hw27.employeeService.EmployeeService;


import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name) {
        return employeeService.findEmployee(name);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name) {
        return employeeService.removeEmployee(name);

    }


}
