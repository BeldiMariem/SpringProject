package tn.esprit.springproject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Transactional
@Table( name = "Etudiant")
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Departement departement;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL)
    private Set<Contrat> contrat;

    @JsonIgnore
    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    private Set<Equipe> equipes;



}
