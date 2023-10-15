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
@Table( name = "Universite")
public class Universite implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idUniv;
    private String nomUniv;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departement;

}
