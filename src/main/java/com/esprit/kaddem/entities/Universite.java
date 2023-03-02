package com.esprit.kaddem.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "universite")
@Data
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniv", nullable = false)
    private Integer idUniv;

    @Column(name = "nomUniv")
    private String nomUniv;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;


}
