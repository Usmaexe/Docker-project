package com.backend.Repository;

import com.backend.Entity.Etudiant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtudiantRepository implements EtudiantDao{
    private EntityManager entityManager;

    @Autowired
    public EtudiantRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void enregistrer(Etudiant etudiant) {
        entityManager.persist(etudiant);
    }


    @Override
    public Etudiant lire(Long etudiantId) {
        return entityManager.find(Etudiant.class,etudiantId);
    }

    @Override
    public List<Etudiant> lireTous() {
        TypedQuery<Etudiant> query = entityManager.createQuery("FROM Etudiant",Etudiant.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void supprimer(Long etudiantId) {

    }
}
