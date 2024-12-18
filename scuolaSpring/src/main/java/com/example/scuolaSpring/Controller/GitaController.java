package com.example.scuolaSpring.Controller;

import com.example.scuolaSpring.DTO.GitaDTO;
import com.example.scuolaSpring.DTO.GitaDTOstring;
import com.example.scuolaSpring.Service.GitaService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveGita")
    public GitaDTOstring saveGita(@RequestBody GitaDTO gitaDTO) {
        return gitaService.saveGita(gitaDTO);
    }

    @PutMapping("/updateGita/{id}")
    public GitaDTOstring updateGita(@PathVariable("id") Integer id, @RequestBody GitaDTO gitaDTO) {
        return gitaService.updateGita(id, gitaDTO);
    }

    @DeleteMapping("/deleteGita/{id}")
    public GitaDTOstring deleteGita(@PathVariable("id") Integer id) {
        return gitaService.deleteGita(id);
    }
}
