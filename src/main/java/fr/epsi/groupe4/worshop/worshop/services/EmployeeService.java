package fr.epsi.groupe4.worshop.worshop.services;

import fr.epsi.groupe4.worshop.worshop.beans.Employee;
import fr.epsi.groupe4.worshop.worshop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> listeEmployee()
    {
        return this.employeeRepository.findAll();
    }

    public void ajouterEmployee(Employee employee)
    {
        this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id_employe, Employee employee)
    {

        return employeeRepository.findById(id_employe)
                .map(p->{
                    p.setNom(employee.getNom());
                    p.setPrenom(employee.getPrenom());
                    p.setSexe(employee.getSexe());
                    return employeeRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("employee non trouver"));



    }

    public void removeEmployee(int id_employee)
    {
        Employee employee = employeeRepository.findById(id_employee).orElseThrow();

        if(employee != null)
            employeeRepository.delete(employee);
    }

    public Employee searchByIdEmployee(int id_employee)
    {
        return employeeRepository.findById(id_employee).orElseThrow(()-> new RuntimeException("employee non trouveee "));
    }
}
