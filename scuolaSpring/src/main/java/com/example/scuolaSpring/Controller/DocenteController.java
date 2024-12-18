package com.example.scuolaSpring.Controller;

import com.example.scuolaSpring.DTO.DocDTOstring;
import com.example.scuolaSpring.DTO.DocenteDTO;
import com.example.scuolaSpring.Service.DocenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {
    DocenteService docenteService;
    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping("/getDocenteById/{id}")
    public DocDTOstring getDocenteById(@PathVariable("id") Integer id) {
        return docenteService.getDocenteById(id);
    }

    @GetMapping("")
    public List<DocDTOstring> getAllDocente() {
        return docenteService.getAllDocentes();
    }

    @PostMapping("/saveDocente")
    public DocDTOstring saveDocente(@RequestBody DocenteDTO docenteDTO) {
        return docenteService.saveDocente(docenteDTO);
    }

    @DeleteMapping("/deleteDocente/{id}")
    public DocDTOstring deleteDocente(@PathVariable("id") Integer id) {
        return docenteService.deleteDocente(id);
    }

    @PutMapping("/updateDocente/{id}")
    public DocDTOstring updateDocente(@PathVariable("id") Integer id, @RequestBody DocenteDTO docenteDTO) {
        return docenteService.updateDocente(id, docenteDTO);
    }

}
