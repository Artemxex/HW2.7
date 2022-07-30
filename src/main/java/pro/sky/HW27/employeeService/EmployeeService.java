package pro.sky.HW27.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.HW27.Employee;
import pro.sky.HW27.exeption.EmployeeAlreadyAddedExeption;
import pro.sky.HW27.exeption.EmployeeNotFoundExeption;
import pro.sky.HW27.exeption.EmployeeStorageFullExeption;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String,Employee> employees = new HashMap<>();

    public Employee addEmployee(String name) {
        Employee employee = new Employee(name);
        employees.put(name, employee);
        return employee;
    }

    public Employee findEmployee(String name) {
        Employee employee = new Employee(name);
        if (employees.containsKey(name)) {
            return employee;
        }else
            throw new EmployeeNotFoundExeption();

    }

    public Employee removeEmployee(String name) {
        Employee employee = new Employee(name);
        if (!employees.containsKey(name)) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(name);
        return employee;
    }

    public Map<String,Employee> getAll() {
        return new HashMap<>(employees);

    }
}
