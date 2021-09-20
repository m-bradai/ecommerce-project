package com.example.demo.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String firstname;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private String gender;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate joiningDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate retiringDate;

    private String dept;

    @ManyToOne
    private Employee manager;

    // Prénom et nom de l'employé affiché dans l'organigramme
    @Transient
    private String title = this.firstname + " " + this.name;
    // Description du poste de travail
    private String description;
    // Identifiant du responsable emplyé
    @Transient
    private Long parent = this.manager==null? null: this.manager.getId();
    // Chemin de la photo de l'employé
    private String image;
}
