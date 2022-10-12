package fr.epsi.groupe4.worshop.worshop.controllers;

import fr.epsi.groupe4.worshop.worshop.beans.Employee;
import fr.epsi.groupe4.worshop.worshop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/liste")
    public List<Employee> listeEmployee()
    {
        return employeeService.listeEmployee();
    }

    @PostMapping("/ajouter")
    public String ajouterEmployee(@Validated @RequestBody Employee employee)
    {
        employeeService.ajouterEmployee(employee);
        return "employee ajouter avec succes";
    }

    @PutMapping("/{id_employee}/update")
    public String updateEmployee(@Validated @PathVariable int id_employee, @RequestBody Employee employee)
    {
        employeeService.updateEmployee(id_employee, employee);
        return "mise à jour employee effectuer avec succes";
    }

    @DeleteMapping("/{id_employee}/delete")
    public String removeEmployee(@Validated @PathVariable int id_employee)
    {
        employeeService.removeEmployee(id_employee);
        return  "employee supprimer avec success";
    }

    @GetMapping("/{id_employee}/searchById")
    public Employee searchByIdEmployee(@Validated @PathVariable int id_employee)
    {
        return employeeService.searchByIdEmployee(id_employee);
    }
}
