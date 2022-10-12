package fr.epsi.groupe4.worshop.worshop.services;

import fr.epsi.groupe4.worshop.worshop.beans.Question;
import fr.epsi.groupe4.worshop.worshop.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> listeQuestion()
    {
        return this.questionRepository.findAll();
    }

    public void ajouterQuestion(Question question)
    {
        questionRepository.save(question);
    }

    public Question updateQuestion(int id_question, Question question)
    {
        return questionRepository.findById(id_question)
                .map(p->{
                    p.setDate(question.getDate());
                    p.setReponse(question.getReponse());
                    return questionRepository.save(p);
    }).orElseThrow(()-> new RuntimeException("desoler question non trouver"));
    }

    public void removeQuestion(int id_question)
    {
        
    }
}
