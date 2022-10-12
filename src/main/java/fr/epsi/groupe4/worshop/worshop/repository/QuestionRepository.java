package fr.epsi.groupe4.worshop.worshop.repository;

import fr.epsi.groupe4.worshop.worshop.beans.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
