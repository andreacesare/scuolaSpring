package com.example.scuolaSpring.Service;

import com.example.scuolaSpring.Converter.ClasseConverter;
import com.example.scuolaSpring.DTO.ClasseDTO;
import com.example.scuolaSpring.DTO.ClasseDTOstring;
import com.example.scuolaSpring.DTO.GitaDTO;
import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Docente;
import com.example.scuolaSpring.Entity.Gita;
import com.example.scuolaSpring.Repository.ClasseRepository;
import com.example.scuolaSpring.Repository.DocenteRepository;
import com.example.scuolaSpring.Repository.GitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClasseService {
    private final DocenteRepository docenteRepository;
    private final GitaRepository gitaRepository;
    ClasseRepository classeRepository;
    ClasseConverter classeConverter;

    public ClasseService(ClasseRepository classeRepository, ClasseConverter classeConverter, DocenteRepository docenteRepository, GitaRepository gitaRepository) {
        this.classeRepository = classeRepository;
        this.classeConverter = classeConverter;
        this.docenteRepository = docenteRepository;
        this.gitaRepository = gitaRepository;
    }

    public ClasseDTOstring getClasseById(Integer id) {
        Classe classe = classeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Classe not found"));
        return ClasseConverter.toDTOstring(classe);
    }

    public List<ClasseDTOstring> getAllClasses() {
        List<Classe> classes = classeRepository.findAll();
        List<ClasseDTOstring> lista = classes.stream()
                .map(ClasseConverter::toDTOstring)
                .toList();
        return lista;

    }

    public ClasseDTOstring saveClasse(ClasseDTO classeDTO) {
        Classe classe = classeConverter.toEntity(classeDTO);
        classeRepository.save(classe);
        return ClasseConverter.toDTOstring(classe);
    }

    public ClasseDTOstring updateClasse(Integer id, ClasseDTO classeDTO) {
        Classe classe = classeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Classe not found"));
        classe.setNome(classeDTO.getNome() != null ? classeDTO.getNome() : classe.getNome());
        if (classeDTO.getDocente() != null) {
            Docente docente = docenteRepository.findById(classeDTO.getDocente().getId()).orElseThrow(() -> new NoSuchElementException("Docente not found"));
            classe.setDocente(docente);
        }
            if (classeDTO.getGite() != null) {
                for (GitaDTO g : classeDTO.getGite()) {
                    Gita gita = gitaRepository.findById(g.getId()).orElseThrow(() -> new NoSuchElementException("Gite not found"));
                    classe.aggiungiGita(gita);
                    gita.getClassi().add(classe);
                }
            }
            classeRepository.save(classe);
            return ClasseConverter.toDTOstring(classe);
        }

    public ClasseDTOstring deleteClasse(Integer id) {
        Classe classe=classeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Classe not found"));
        ClasseDTOstring classeDTOstring = ClasseConverter.toDTOstring(classe);
        if(classe.getGite()!=null) {
            for (Gita g : classe.getGite()) {
                g.removeClasse(classe);
                gitaRepository.save(g);
            }
            classe.getGite().clear();
        }

        classe.getDocente().setClasse(null);
        docenteRepository.save(classe.getDocente());
        classeRepository.delete(classe);
        return classeDTOstring;
    }
    }

