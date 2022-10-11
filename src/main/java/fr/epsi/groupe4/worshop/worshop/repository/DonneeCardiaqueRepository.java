package fr.epsi.groupe4.worshop.worshop.repository;

import fr.epsi.groupe4.worshop.worshop.beans.DonneeCardique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonneeCardiaqueRepository extends JpaRepository<DonneeCardique, Integer> {


}
