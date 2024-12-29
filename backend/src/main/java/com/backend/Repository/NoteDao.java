package com.backend.Repository;

import com.backend.Entity.Note;

import java.util.List;

public interface NoteDao {
    void enregistrer(Note note);
    Note lire(Long noteId);
    List<Note> lireTous();
    List<Note> lireNoteDeEtudiantId(Long etudiantId);
}
