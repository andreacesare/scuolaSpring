package com.example.scuolaSpring.Service;

import com.example.scuolaSpring.Converter.ClasseConverter;
import com.example.scuolaSpring.DTO.ClasseDTO;
import com.example.scuolaSpring.DTO.ClasseDTOstring;
import com.example.scuolaSpring.Entity.Classe;
import com.example.scuolaSpring.Repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ClasseService {
    ClasseRepository classeRepository;
    ClasseConverter classeConverter;
    public ClasseService(ClasseRepository classeRepository,ClasseConverter classeConverter) {
        this.classeRepository = classeRepository;
        this.classeConverter = classeConverter;
    }

    public ClasseDTOstring getClasseById(Integer id) {
        Classe classe=classeRepository.findById(id).orElseThrow(()->new NoSuchElementException("Classe not found"));
        return ClasseConverter.toDTOstring(classe);
    }

    public List<ClasseDTOstring> getAllClasses() {
        List<Classe> classes = classeRepository.findAll();
        List<ClasseDTOstring> lista=classes.stream()
                .map(ClasseConverter::toDTOstring)
                .toList();
        return lista;

    }

    public ClasseDTOstring saveClasse(ClasseDTO classeDTO) {
        Classe classe=classeConverter.toEntity(classeDTO);
        classeRepository.save(classe);
        return ClasseConverter.toDTOstring(classe);
    }
}
