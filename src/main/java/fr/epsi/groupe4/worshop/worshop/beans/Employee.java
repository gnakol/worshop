package fr.epsi.groupe4.worshop.worshop.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_employee;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "NumeroSerieMontre")
    private String num_serie;

    @Column(name = "sexe")
    private String sexe;
}
