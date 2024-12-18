package com.example.scuolaSpring.DTO;

import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Gita;
import jakarta.persistence.*;

public class DocenteDTO {

        private Integer id;
        private String nome;
        private String cognome;

        private Classe classe;

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
