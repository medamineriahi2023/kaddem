package com.esprit.kaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDpart", nullable = false)
    private Integer idDpart;

    private String nomDepart;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "department")
    @JsonIgnore
    List<Etudiant> etudiants;
}
