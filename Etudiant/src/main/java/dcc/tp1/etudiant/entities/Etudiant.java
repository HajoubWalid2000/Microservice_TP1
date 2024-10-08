package dcc.tp1.etudiant.entities;

import dcc.tp1.etudiant.Modele.Filiere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prennom")
    private String prenom;
    @Column(name = "id_f")
    private Long id_f;
    @Transient
    private Filiere filiere;





}
