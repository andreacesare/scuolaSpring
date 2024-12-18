package com.example.scuolaSpring.Service;

import com.example.scuolaSpring.Converter.GitaConverter;
import com.example.scuolaSpring.DTO.GitaDTO;
import com.example.scuolaSpring.DTO.GitaDTOstring;
import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Entity.Docente;
import com.example.scuolaSpring.Entity.Gita;
import com.example.scuolaSpring.Repository.ClasseRepository;
import com.example.scuolaSpring.Repository.DocenteRepository;
import com.example.scuolaSpring.Repository.GitaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GitaService {
    private final GitaConverter gitaConverter;
    private final DocenteRepository docenteRepository;
    private final ClasseRepository classeRepository;
    GitaRepository gitaRepository;
    public GitaService(GitaRepository gitaRepository, GitaConverter gitaConverter, DocenteRepository docenteRepository, ClasseRepository classeRepository) {
        this.gitaRepository = gitaRepository;
        this.gitaConverter = gitaConverter;
        this.docenteRepository = docenteRepository;
        this.classeRepository = classeRepository;
    }

    public GitaDTOstring getGitaById(Integer id) {
        Gita gita=gitaRepository.findById(id).orElseThrow(()->new NoSuchElementException("gita non trovata"));
        return GitaConverter.toDTOstring(gita);
    }

    public List<GitaDTOstring> getAllGita() {
        List<Gita> gite=gitaRepository.findAll();
        List<GitaDTOstring> giteDTOstring=gite.stream()
                .map(GitaConverter::toDTOstring)
                .toList();
        return giteDTOstring;
    }

    public GitaDTOstring saveGita(GitaDTO gitaDTO) {
        Gita gita=gitaConverter.toEntity(gitaDTO);
        gitaRepository.save(gita);
        return GitaConverter.toDTOstring(gita);
    }

    public GitaDTOstring updateGita(Integer id, GitaDTO gitaDTO) {
        Gita gita=gitaRepository.findById(id).orElseThrow(()->new NoSuchElementException("gita non trovata"));
        gita.setId(gitaDTO.getId());
        gita.setData(gitaDTO.getData()!=null?gitaDTO.getData():gita.getData());
        if(gitaDTO.getDocente()!=null){
            Docente docente=docenteRepository.findById(gitaDTO.getDocente().getId()).orElseThrow(()->new NoSuchElementException("docente non trovata"));
            gita.setDocente(docente);
        }
        if(gitaDTO.getClassi()!=null){
            for(Classe c:gitaDTO.getClassi()){
                Classe classe=classeRepository.findById(c.getId()).orElseThrow(()->new NoSuchElementException("classe non trovata"));
                gita.aggiungiClasse(classe);
            }
        }
        gitaRepository.save(gita);
        return GitaConverter.toDTOstring(gita);
    }


    public GitaDTOstring deleteGita(Integer id) {
        Gita gita=gitaRepository.findById(id).orElseThrow(()->new NoSuchElementException("gita non trovata"));
        GitaDTOstring gitaDTOstring=GitaConverter.toDTOstring(gita);
        if(gita.getClassi()!=null){
            for(Classe c:gita.getClassi()){
                c.removeGita(gita);
                c.getDocente().setClasse(null);
                docenteRepository.save(c.getDocente());
                classeRepository.save(c);

            }
            gita.getClassi().clear();
        }
        gita.getDocente().setGita(null);
        docenteRepository.save(gita.getDocente());

        gitaRepository.delete(gita);
        return gitaDTOstring;
    }
}
