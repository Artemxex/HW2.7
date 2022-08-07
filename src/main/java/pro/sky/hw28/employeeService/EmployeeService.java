package pro.sky.hw28.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.hw28.Employee;
import pro.sky.hw28.exeption.EmployeeNotFoundExeption;


import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();




    public Employee findEmployee(String name) {
        Employee employee = new Employee(name);
        if (employees.containsKey(name)) {
            return employee;
        } else {
            throw new EmployeeNotFoundExeption();
        }

    }

    public Employee removeEmployee(String name) {
        Employee employee = new Employee(name);
        if (!employees.containsKey(name)) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(name);
        return employee;
    }


}
