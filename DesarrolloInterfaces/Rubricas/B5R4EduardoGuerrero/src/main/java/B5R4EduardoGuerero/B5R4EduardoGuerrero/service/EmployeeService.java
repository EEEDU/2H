package B5R4EduardoGuerero.B5R4EduardoGuerrero.service;

import java.util.ArrayList;
import java.util.List;

import B5R4EduardoGuerero.B5R4EduardoGuerrero.domain.Employee;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Mahesh", "Varanasi"));
        list.add(new Employee(2, "Ram", "Ayodhya"));
        list.add(new Employee(3, "Krishna", "Mathura"));
        return list;
    }
}
