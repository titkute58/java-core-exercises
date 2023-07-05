package bai13.service;

import bai13.model.Employee;
import bai13.model.Experienced;
import bai13.model.Fresher;
import bai13.model.Intern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {

    List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public Employee findById(String id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public void addEmployee(Employee newEmployee) {
        if (!isEmployeeExist(newEmployee.getId())) {
            employees.add(newEmployee);
            System.out.println("Successfully added employee");
        } else {
            System.out.println("Employee already exist");
        }
    }

    public void deleteEmployee(String id) {
        if (isEmployeeExist(id)) {
            employees.remove(employees.stream().filter(employee -> employee.getId().equals(id)).findFirst());
            System.out.println("Successfully removed employee");
        } else {
            System.out.println("Employee does not exist");
        }
    }

    // Another implementation would be changing the actual element instead of removing then adding again
    public void updateEmployee(Employee employeeToUpdate) {
        if (isEmployeeExist(employeeToUpdate.getId())) {
            int index = employees.indexOf(findById(employeeToUpdate.getId()));
            employees.set(index, employeeToUpdate);
            System.out.println("Successfully removed employee");
        } else {
            System.out.println("Employee does not exist");
        }
    }

    public boolean isEmployeeExist(String id) {
         return employees.stream().anyMatch(employee -> employee.getId().equals(id));
    }

    public List<Employee> findByType(int type) {
        return this.employees.stream()
                .filter(employee -> {
                    if (type == 0) {
                        return employee instanceof Experienced;
                    }
                    if (type == 1) {
                        return employee instanceof Fresher;
                    }
                    if (type == 2) {
                        return employee instanceof Intern;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
