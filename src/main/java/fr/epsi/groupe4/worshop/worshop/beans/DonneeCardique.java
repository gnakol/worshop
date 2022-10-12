package fr.epsi.groupe4.worshop.worshop.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "donneecardiaque")
public class DonneeCardique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_donnee;

    @Column(name = "RythmeCardiaque")
    private int rythme_cardiaque;

    @Column(name = "Jour")
    private Date date;

    @Column(name = "NumeroSerieMontre")
    private String numero_serie_montre;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_employee")
    @JsonIgnoreProperties({"donneeCardiques"})
    private Employee employee;
}
