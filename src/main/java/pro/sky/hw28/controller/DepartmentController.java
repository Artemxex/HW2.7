package pro.sky.hw28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw28.Employee;
import pro.sky.hw28.employeeService.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String name,@RequestParam("id") int id,@RequestParam("salary") int salary) {
        return departmentService.addEmployee(name,id,salary);

    }

    @GetMapping("/all-by-dep")
    public List<Employee> getAllByDep(@RequestParam("id") int id) {
        return departmentService.getAllByDep(id);
    }

    @GetMapping("/all")
    public Map<Integer,List<Employee>> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("id") int id ) {
        return departmentService.minSalary(id);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("id") int id ) {
        return departmentService.maxSalary(id);

    }
}
