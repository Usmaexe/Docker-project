package com.backend.Repository;

import com.backend.Entity.Etudiant;

import java.util.List;

public interface EtudiantDao {
    void enregistrer(Etudiant etudiant);
    Etudiant lire(Long etudiantId);
    List<Etudiant> lireTous();
    void supprimer(Long etudiantId);
}
