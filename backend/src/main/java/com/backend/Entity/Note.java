package com.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Note")
public class Note {
    public Note() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idEtudiant",referencedColumnName = "id",nullable = false)
    private Etudiant etudiant;

    @Column(name = "nomDuCours")
    private String nomDuCours;

    @Column(name = "valeurDeNote")
    private Float valeurDeNote;

    public Long getId() {
        return id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public String getNomDuCours() {
        return nomDuCours;
    }

    public Float getValeurDeNote() {
        return valeurDeNote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setNomDuCours(String nomDuCours) {
        this.nomDuCours = nomDuCours;
    }

    public void setValeurDeNote(Float valeurDeNote) {
        this.valeurDeNote = valeurDeNote;
    }
}
