package tn.esprit.springproject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Contrat")
public class Contrat implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archive;
    private int montantContrat;
    @ManyToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;
}
