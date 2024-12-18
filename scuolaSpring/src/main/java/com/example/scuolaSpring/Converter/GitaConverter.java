package com.example.scuolaSpring.Converter;

import com.example.scuolaSpring.DTO.ClasseDTOstring;
import com.example.scuolaSpring.DTO.GitaDTO;
import com.example.scuolaSpring.DTO.GitaDTOstring;
import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Docente;
import com.example.scuolaSpring.Entity.Gita;
import com.example.scuolaSpring.Repository.ClasseRepository;
import com.example.scuolaSpring.Repository.DocenteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class GitaConverter {

    private final DocenteRepository docenteRepository;
    private final ClasseRepository classeRepository;

    public GitaConverter(DocenteRepository docenteRepository, ClasseRepository classeRepository) {
        this.docenteRepository = docenteRepository;
        this.classeRepository = classeRepository;
    }

    public static GitaDTOstring toDTOstring(Gita gita) {
        GitaDTOstring gitastring = new GitaDTOstring();
        gitastring.setId(gita.getId());
        gitastring.setNome(gita.getNome());
        gitastring.setDocente(gita.getDocente().getNome()+" "+gita.getDocente().getCognome());
        List<String> classi=gita.getClassi().stream()
                        .map(c->c.getNome())
                                .toList();
        gitastring.setClassi(classi);

        gitastring.setData(gita.getData());
        return gitastring;
    }

    public Gita toEntity(GitaDTO gitaDTO) {
        Gita gita = new Gita();
        gita.setId(gitaDTO.getId()!=null?gitaDTO.getId():null);
        gita.setNome(gitaDTO.getNome());
        gita.setData(gitaDTO.getData()!=null?gitaDTO.getData():null);
        Docente docente = docenteRepository.findById(gitaDTO.getDocente().getId()).orElseThrow(()->new NoSuchElementException("Docente non trovato"));
        gita.setDocente(docente);
        for(Classe c:gitaDTO.getClassi()) {
            Classe classe = classeRepository.findById(c.getId()).orElseThrow(()->new NoSuchElementException("Classe non trovato"));
            gita.getClassi().add(classe);
            classe.aggiungiGita(gita);
        }
        return gita;
    }


}
