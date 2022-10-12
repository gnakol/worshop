package fr.epsi.groupe4.worshop.worshop.controllers;

import fr.epsi.groupe4.worshop.worshop.beans.Question;
import fr.epsi.groupe4.worshop.worshop.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/liste")
    public List<Question> listeQuestion()
    {
        return this.questionService.listeQuestion();
    }

    @PostMapping("/ajouter")
    public String ajouterQuestion(@Validated @RequestBody Question question)
    {
        this.questionService.ajouterQuestion(question);
        return "question ajouter avec success";
    }

    @PutMapping("/{id_question}/update")
    public String updateQuestion(@Validated @PathVariable int id_question, @RequestBody Question question)
    {
        question = this.questionService.updateQuestion(id_question, question);

        return "mise à jour question avec succes";
    }

    @DeleteMapping("/{id_question}/delete")
    public String dropQuestion(@Validated @PathVariable int id_question)
    {
        this.questionService.removeQuestion(id_question);
        return "question surpprimer avec succes";
    }

    @GetMapping("/{id_question}/searchById")
    public Question searchByIdQuestion(@Validated @PathVariable int id_question)
    {
        return this.questionService.searchByIdQuestion(id_question);
    }
}
