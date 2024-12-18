package com.example.scuolaSpring.DTO;

import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Docente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GitaDTO {

    private Integer id;
    private String nome;
    private LocalDate data;

    private Docente docente;
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
}
