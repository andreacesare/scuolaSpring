package com.example.scuolaSpring.DTO;

import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Docente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GitaDTOstring {
    private Integer id;
    private String nome;
    private LocalDate data;

    private String docente;
    private List<String> classi=new ArrayList<>();

    public Integer getId(){return id;}
    public String getNome(){return nome;}
    public LocalDate getData(){return data;}
    public String getDocente(){return docente;}
    public List<String> getClassi(){return classi;}
    public void setId(Integer id){this.id=id;}
    public void setNome(String nome){this.nome=nome;}
    public void setData(LocalDate data){this.data=data;}
    public void setDocente(String docente){this.docente=docente;}
    public void setClassi(List<String> classi){this.classi=classi;}

}
