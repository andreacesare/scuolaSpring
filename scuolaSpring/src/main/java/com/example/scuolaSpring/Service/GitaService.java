package com.example.scuolaSpring.Service;

import com.example.scuolaSpring.Converter.GitaConverter;
import com.example.scuolaSpring.DTO.GitaDTOstring;
import com.example.scuolaSpring.Entity.Gita;
import com.example.scuolaSpring.Repository.GitaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GitaService {
    GitaRepository gitaRepository;
    public GitaService(GitaRepository gitaRepository) {
        this.gitaRepository = gitaRepository;
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
}
