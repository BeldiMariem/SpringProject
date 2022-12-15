package com.example.examen.entities;

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
@Table( name = "Project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "projectSet",cascade = CascadeType.ALL)
    private Set<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private Set<Sprint> sprints;

}
