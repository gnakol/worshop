package fr.epsi.groupe4.worshop.worshop.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_question;

    @Column(name = "Reponse")
    private String reponse;

    @Column(name = "NumeroSerieMontre")
    private String num_serie_montre;

    @Column(name = "date")
    private Date date;


}
