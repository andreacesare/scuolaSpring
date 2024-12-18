package com.example.scuolaSpring.Converter;

import com.example.scuolaSpring.DTO.ClasseDTO;
import com.example.scuolaSpring.DTO.ClasseDTOstring;
import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Docente;
import com.example.scuolaSpring.Repository.DocenteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ClasseConverter {
    DocenteRepository docenteRepository;
    public ClasseConverter(DocenteRepository docenteRepository) {
        this.docenteRepository=docenteRepository;
    }

    public static ClasseDTOstring toDTOstring(Classe classe) {
        ClasseDTOstring classDTOstring = new ClasseDTOstring();
        classDTOstring.setId(classe.getId());
        classDTOstring.setNome(classe.getNome());
        classDTOstring.setDocente(classe.getDocente().getNome()+" "+classe.getDocente().getCognome());
        if(classe.getGite()!=null) {
            List<String> gite = classe.getGite().stream()
                    .map(g -> g.getNome() + " " + g.getData())
                    .toList();
            classDTOstring.setGite(gite);
        }
        return classDTOstring;
    }

    public Classe toEntity(ClasseDTO classDTO) {
        Classe classe = new Classe();
        classe.setId(classDTO.getId());
        classe.setNome(classDTO.getNome());
        Docente docente=docenteRepository.findById(classDTO.getDocente().getId()).orElseThrow(()->new NoSuchElementException("Docente non trovato"));
        classe.setDocente(docente);
        return classe;

    }
}
