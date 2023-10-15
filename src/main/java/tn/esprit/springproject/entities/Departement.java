package tn.esprit.springproject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idDepart;
    private String nomDepart;

    @JsonIgnore
    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiant;





}
