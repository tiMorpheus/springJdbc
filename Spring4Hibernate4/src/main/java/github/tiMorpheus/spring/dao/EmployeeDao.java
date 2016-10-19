package github.tiMorpheus.spring.dao;

import github.tiMorpheus.spring.model.Employee;
import java.util.*;

public interface EmployeeDao {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
