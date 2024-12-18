package com.example.scuolaSpring.Controller;

import com.example.scuolaSpring.DTO.GitaDTOstring;
import com.example.scuolaSpring.Service.GitaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gita")
public class GitaController {
    GitaService gitaService;
    public GitaController(GitaService gitaService) {
        this.gitaService = gitaService;
    }

    @GetMapping("/getGitaById/{id}")
    public GitaDTOstring getGitaById(@PathVariable("id") Integer id) {
        return gitaService.getGitaById(id);
    }

    @GetMapping("")
    public List<GitaDTOstring> getAllGita() {
        return gitaService.getAllGita();
    }
}
