package com.example.scuolaSpring.Converter;

import com.example.scuolaSpring.DTO.DocDTOstring;
import com.example.scuolaSpring.DTO.DocenteDTO;
import com.example.scuolaSpring.Entity.Docente;

import java.time.format.DateTimeFormatter;

public class DocenteConverter {

    public static DocenteDTO toDTO(Docente docente) {
        DocenteDTO docenteDTO = new DocenteDTO();
        docenteDTO.setId(docente.getId());
        docenteDTO.setNome(docente.getNome());
        docenteDTO.setCognome(docente.getCognome());
        docenteDTO.setClasse(docente.getClasse()!=null?docente.getClasse():null);
        docenteDTO.setGita(docente.getGita()!=null?docente.getGita():null);
        return docenteDTO;
    }

    public static DocDTOstring toDTOString(Docente docente) {
        DocDTOstring docDTOstring = new DocDTOstring();
        docDTOstring.setId(docente.getId());
        docDTOstring.setNome(docente.getNome());
        docDTOstring.setCognome(docente.getCognome());
        docDTOstring.setClasse(docente.getClasse()!=null?docente.getClasse().getNome():"");
        docDTOstring.setGita(docente.getGita()!=null?docente.getGita().getNome()+"  "+docente.getGita().getData():"");
        return docDTOstring;
    }

    public static Docente toEntity(DocenteDTO docenteDTO) {
        Docente docente = new Docente();
        docente.setId(docenteDTO.getId());
        docente.setNome(docenteDTO.getNome());
        docente.setCognome(docenteDTO.getCognome());
        docente.setClasse(docenteDTO.getClasse());
        docente.setGita(docenteDTO.getGita());
        return docente;
    }
}
