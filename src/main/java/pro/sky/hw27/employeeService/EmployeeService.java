package pro.sky.hw27.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.hw27.Employee;
import pro.sky.hw27.exeption.EmployeeAlreadyAddedExeption;
import pro.sky.hw27.exeption.EmployeeNotFoundExeption;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
