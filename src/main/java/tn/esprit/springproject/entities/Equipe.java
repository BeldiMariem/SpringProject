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
@Table( name = "Equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;


    @OneToOne(cascade = CascadeType.ALL)
    private DetailEquipe detailEquipe;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants; 
}
