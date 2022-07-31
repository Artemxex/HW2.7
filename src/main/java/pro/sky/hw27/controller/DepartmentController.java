package pro.sky.hw27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw27.Employee;
import pro.sky.hw27.employeeService.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public final EmployeeService employeeService;

    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all-by-dep")
    public List<Employee> getAllByDep(@RequestParam("id") int id) {
        return employeeService.getAllByDep(id);
    }

    @GetMapping("/all")
    public Map<Integer,List<Employee>> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("id") int id ) {
        return employeeService.minSalary(id);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("id") int id ) {
        return employeeService.maxSalary(id);

    }
}
