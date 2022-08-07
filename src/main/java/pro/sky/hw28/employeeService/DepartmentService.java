package pro.sky.hw28.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.hw28.Employee;
import pro.sky.hw28.exeption.EmployeeAlreadyAddedExeption;
import pro.sky.hw28.exeption.EmployeeNotFoundExeption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();
    public List<Employee> getAllByDep(int id) {
        return employees.values().stream().filter(e -> e.getEmployeeDepartment() == id).collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> getAll() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getEmployeeDepartment));
    }
    public Employee minSalary(int i) {
        return employees.values().stream().filter(e -> e.getEmployeeDepartment() == i).min((e1, e2) -> {
            return e1.getEmployeeSalary() - e2.getEmployeeSalary();
        }).orElseThrow(() ->  new EmployeeNotFoundExeption());

    }

    public Employee maxSalary(int i) {
        return employees.values().stream().filter(e -> e.getEmployeeDepartment() == i).max((e1, e2) -> {
            return e1.getEmployeeSalary() - e2.getEmployeeSalary();
        }).orElseThrow(() -> new EmployeeNotFoundExeption());

    }
    public Employee addEmployee(String name, int id, int salary) {
        Employee employee = new Employee(name, id, salary);
        if (employees.containsKey(name)){
            throw new EmployeeAlreadyAddedExeption();
        }
        else{
            employees.put(name, employee);
            return employee;
        }

    }
}
