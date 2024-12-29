package com.backend.Controllers;


import com.backend.Entity.Etudiant;
import com.backend.Entity.Note;
import com.backend.Repository.EtudiantRepository;
import com.backend.Repository.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MainController {
    private final EtudiantRepository etudiant;
    private final NoteRepository note;

    public MainController(EtudiantRepository etudiant, NoteRepository note) {
        this.etudiant = etudiant;
        this.note = note;
    }


    @GetMapping("/etudiants")
    public List<Etudiant> lireTousEtudiants(){
        return etudiant.lireTous();

    }
    @GetMapping("/etudiants/{id}")
    public Etudiant lireEtudiant(@PathVariable Long id){
        return etudiant.lire(id);
    }
    @PostMapping("/etudiants")
    public ResponseEntity<Etudiant> enregistrerEtudiant(@RequestBody Etudiant etudiant){
        this.etudiant.enregistrer(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(etudiant);
    }

    @GetMapping("/notes/{id}")
    public Note lireNote(@PathVariable Long id){
        return note.lire(id);
    }
    @GetMapping("/notes")
    public List<Note> lireNotes(){
        return note.lireTous();
    }
    @PostMapping("/notes")
    public ResponseEntity<Note> enregistrerNote(@RequestBody Note note){
        Etudiant newEtudiant = etudiant.lire(note.getEtudiant().getId());

        //TO RETURN THE HOLE ETUDIANT OBJECT IN THE RESPONSE
        Note newNote = new Note();
        newNote.setEtudiant(newEtudiant);
        newNote.setNomDuCours(note.getNomDuCours());
        newNote.setValeurDeNote(note.getValeurDeNote());
        this.note.enregistrer(newNote);
        return ResponseEntity.ok(newNote);
    }

    @GetMapping("notes/e/{etudiantId}")
    public List<Note> lireNoteEtudiantId(@PathVariable Long etudiantId){
        return note.lireNoteDeEtudiantId(etudiantId);
    }

}
