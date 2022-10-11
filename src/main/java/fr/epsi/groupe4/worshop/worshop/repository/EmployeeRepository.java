package fr.epsi.groupe4.worshop.worshop.repository;

import fr.epsi.groupe4.worshop.worshop.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
