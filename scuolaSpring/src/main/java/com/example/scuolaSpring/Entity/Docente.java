package com.example.scuolaSpring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_doc")
    private Integer id;
    private String nome;
    private String cognome;
    @OneToOne(mappedBy = "docente",cascade = CascadeType.ALL,orphanRemoval = true)
    private Classe classe;
    @OneToOne(mappedBy = "docente",cascade = CascadeType.ALL,orphanRemoval = true)
    private Gita gita;

    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public Integer getId() {return id;}
    public Classe getClasse() {return classe;}
    public Gita getGita() {return gita;}
    public void setId(Integer id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public void setClasse(Classe classe) {this.classe = classe;}
    public void setGita(Gita gita) {this.gita = gita;}
}
