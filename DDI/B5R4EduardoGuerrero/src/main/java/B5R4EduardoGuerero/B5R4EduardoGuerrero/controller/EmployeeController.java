package B5R4EduardoGuerero.B5R4EduardoGuerrero.controller;

import java.util.List;

import B5R4EduardoGuerero.B5R4EduardoGuerrero.domain.Employee;
import B5R4EduardoGuerero.B5R4EduardoGuerrero.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @RequestMapping("home")
    public List<Employee> showData() {
        List<Employee> list = service.getAllEmployee();
        return list;
    }
}