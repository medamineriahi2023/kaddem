package com.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipe")
@Data
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe", nullable = false)
    private Integer idEquipe;


    @Column(name = "nomEquipe")
    private String nomEquipe;


    @Column(name = "niveau")
    @Enumerated(EnumType.STRING)
    private Niveau niveau;


    @OneToOne
    private DetailEquipe detailEquipe;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;


}
