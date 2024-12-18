package com.example.scuolaSpring.Controller;

import com.example.scuolaSpring.DTO.ClasseDTO;
import com.example.scuolaSpring.DTO.ClasseDTOstring;
import com.example.scuolaSpring.Service.ClasseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {
    ClasseService classeService;
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping("/getClasseById/{id}")
    public ClasseDTOstring getClasseById(@PathVariable("id") Integer id) {
        return classeService.getClasseById(id);
    }

    @GetMapping("")
    public List<ClasseDTOstring> getAllClasse() {
        return classeService.getAllClasses();
    }

    @PostMapping("/saveClasse")
    public ClasseDTOstring saveClasse(@RequestBody ClasseDTO classeDTO) {
        return classeService.saveClasse(classeDTO);
    }

    @PutMapping("/updateClasse/{id}")
    public ClasseDTOstring updateClasse(@PathVariable("id") Integer id,@RequestBody ClasseDTO classeDTO) {
        return classeService.updateClasse(id, classeDTO);
    }

    @DeleteMapping("/deleteClasse/{id}")
    public ClasseDTOstring deleteClasse(@PathVariable("id") Integer id) {
        return classeService.deleteClasse(id);
    }


}
