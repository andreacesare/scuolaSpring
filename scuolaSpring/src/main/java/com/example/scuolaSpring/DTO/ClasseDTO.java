package com.example.scuolaSpring.DTO;

import com.example.scuolaSpring.Entity.Docente;
import com.example.scuolaSpring.Entity.Gita;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ClasseDTO {

    private Integer id;
    private String nome;
    private DocenteDTO docente;
    private List<GitaDTO> gite=new ArrayList();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public DocenteDTO getDocente() { return docente; }
    public void setDocente(DocenteDTO docente) { this.docente = docente; }
    public List<GitaDTO> getGite() { return gite; }
    public void setGite(List<GitaDTO> gite) { this.gite = gite; }
    public void aggiungiGita(GitaDTO gita) {
        gite.add(gita);
    }
}
