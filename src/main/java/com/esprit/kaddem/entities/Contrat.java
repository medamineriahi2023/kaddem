package com.esprit.kaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contrat")
@Data
public class Contrat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat")
    private Integer idContrat;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private Boolean archive;

    private Integer montantContrat;


    @ManyToOne
    private Etudiant etudiant;


}
