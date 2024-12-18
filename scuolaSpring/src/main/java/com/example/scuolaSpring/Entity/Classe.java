package com.example.scuolaSpring.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_classe")
    private Integer id;
    private String nome;
    @OneToOne
    @JoinColumn(name="id_doc", referencedColumnName = "id_doc")
    private Docente docente;
    @ManyToMany()
    @JoinTable(name="partecipa",joinColumns = @JoinColumn(name="id_classe"),inverseJoinColumns = @JoinColumn(name="id_gita"))
    private List<Gita> gite=new ArrayList();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Docente getDocente() { return docente; }
    public void setDocente(Docente docente) { this.docente = docente; }
    public List<Gita> getGite() { return gite; }
    public void setGite(ArrayList<Gita> gite) { this.gite = gite; }
    public void aggiungiGita(Gita gita) {
        gite.add(gita);
    }


}
