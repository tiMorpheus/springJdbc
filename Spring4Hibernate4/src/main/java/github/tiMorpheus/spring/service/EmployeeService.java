package github.tiMorpheus.spring.service;

import github.tiMorpheus.spring.model.Employee;
import java.util.*;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
