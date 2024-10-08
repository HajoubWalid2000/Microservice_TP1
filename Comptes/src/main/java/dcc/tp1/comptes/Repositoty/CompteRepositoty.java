package dcc.tp1.comptes.Repositoty;

import dcc.tp1.comptes.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepositoty extends JpaRepository<Compte,Long> {

}
