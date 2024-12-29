package com.backend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Etudiant")
@EntityListeners(AuditingEntityListener.class)
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDeCreation", nullable = false, updatable = false)
    @CreatedDate
    private Date dateDeCreation;

    public Etudiant() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }
}
