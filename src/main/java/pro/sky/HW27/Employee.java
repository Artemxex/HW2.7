package pro.sky.HW27;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    @JsonProperty("FI")
    private String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;

    }

    public String getEmployeeName() {
        return this.employeeName;
    }


    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName);
    }

    @Override
    public String toString() {
        return "ФИО- " + employeeName;
    }
}