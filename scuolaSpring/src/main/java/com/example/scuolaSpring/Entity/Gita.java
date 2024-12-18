package com.example.scuolaSpring.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="gita")
public class Gita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gita")
    private Integer id;
    private String nome;
    private LocalDate data;
    @OneToOne
    @JoinColumn(name = "id_doc",referencedColumnName = "id_doc",unique = true)
    private Docente docente;
    @ManyToMany(mappedBy = "gite")
    private List<Classe> classi=new ArrayList<>();

    public Integer getId(){return id;}
    public String getNome(){return nome;}
    public LocalDate getData(){return data;}
    public Docente getDocente(){return docente;}
    public List<Classe> getClassi(){return classi;}
    public void setId(Integer id){this.id=id;}
    public void setNome(String nome){this.nome=nome;}
    public void setData(LocalDate data){this.data=data;}
    public void setDocente(Docente docente){this.docente=docente;}
    public void setClassi(List<Classe> classi){this.classi=classi;}
    public void aggiungiClasse(Classe classe){
        classi.add(classe);
    }

    public String toString(){
        return nome+"\t"+data+"\t"+docente.getNome()+"\t"+docente.getCognome()+"\t"+classi;
    }
}
