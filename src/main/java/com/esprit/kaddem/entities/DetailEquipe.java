package com.esprit.kaddem.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DetailEquipe")
@Data
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailEquipe", nullable = false)
    private Integer idDetailEquipe;

    @Column(name = "salle")
    private Integer salle;

    @Column(name = "thematique")
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;


}