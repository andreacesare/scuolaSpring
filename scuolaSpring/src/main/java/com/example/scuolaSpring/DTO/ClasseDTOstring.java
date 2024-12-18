package com.example.scuolaSpring.DTO;

import java.util.ArrayList;
import java.util.List;

public class ClasseDTOstring {
    private Integer id;
    private String nome;
    private String docente;
    private List<String> gite=new ArrayList();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDocente() { return docente; }
    public void setDocente(String docente) { this.docente = docente; }
    public List<String> getGite() { return gite; }
    public void setGite(List<String> gite) { this.gite = gite; }
    public void aggiungiGita(String gita) {
        gite.add(gita);
    }
}
