package com.example.scuolaSpring.DTO;

public class DocDTOstring {
    private Integer id;
    private String nome;
    private String cognome;

    private String classe;

    private String gita;

    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public Integer getId() {return id;}
    public String getClasse() {return classe;}
    public String getGita() {return gita;}
    public void setId(Integer id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public void setClasse(String classe) {this.classe = classe;}
    public void setGita(String gita) {this.gita = gita;}
}
