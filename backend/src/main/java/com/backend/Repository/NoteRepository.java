package com.backend.Repository;

import com.backend.Entity.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository implements NoteDao {

    private EntityManager entityManager;

    @Autowired
    public NoteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void enregistrer(Note note) {
        entityManager.persist(note);
    }

    @Override
    public Note lire(Long noteId) {
        return entityManager.find(Note.class,noteId);
    }

    @Override
    public List<Note> lireTous() {
        TypedQuery<Note> query = entityManager.createQuery("From Note" , Note.class);
        return query.getResultList();
    }
    @Override
    public List<Note> lireNoteDeEtudiantId(Long etudiantId) {
        TypedQuery<Note> query = entityManager.createQuery("FROM Note n WHERE n.etudiant.id = :id", Note.class);
        query.setParameter("id", etudiantId);
        return query.getResultList();
    }


}
