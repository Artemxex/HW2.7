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
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String name) {
        Employee employee = new Employee(name);
        employees.put(name, employee);
        return employee;
    }

    public Employee addEmployee2(String name, int id, int salary) {
        Employee employee = new Employee(name, id, salary);
        employees.put(name, employee);
        return employee;
    }


    public Employee findEmployee(String name) {
        Employee employee = new Employee(name);
        if (employees.containsKey(name)) {
            return employee;
        } else
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

    public Map<String, Employee> getAll(int id) {
        return employees.values().stream().filter(e -> e.getEmployeeDepartment() == id).
                collect(Collectors.toMap(k -> k.getEmployeeName(), v -> new Employee(v.getEmployeeName(),v.getEmployeeDepartment(),v.getEmployeeSalary())));
    }
public Map<String,Employee> getAllByDep(){
        return employees.values().stream().sorted((e1,e2)->(e1.getEmployeeDepartment()-e2.getEmployeeDepartment())).
    collect(Collectors.toMap(k -> k.getEmployeeName(), v -> new Employee(v.getEmployeeName(),v.getEmployeeDepartment(),v.getEmployeeSalary())));
}
    public Employee minSalary(int i) {
        return employees.values().stream().filter(e -> e.getEmployeeDepartment() == i).min((e1, e2) -> {
            return e1.getEmployeeSalary() - e2.getEmployeeSalary();
        }).orElseThrow(() -> new RuntimeException("employee not found"));

    }

    public Employee maxSalary(int i) {
        return employees.values().stream().filter(e -> e.getEmployeeDepartment() == i).max((e1, e2) -> {
            return e1.getEmployeeSalary() - e2.getEmployeeSalary();
        }).orElseThrow(() -> new RuntimeException("employee not found"));

    }


    public static Employee max(Employee[] list) {
        double maxSalary = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getEmployeeSalary() > maxSalary) {
                maxSalary = list[i].getEmployeeSalary();
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].getEmployeeSalary() == maxSalary) {
                return list[i];
            }

        }
        return null;
    }
}
