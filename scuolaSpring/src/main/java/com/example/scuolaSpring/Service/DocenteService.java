package com.example.scuolaSpring.Service;

import com.example.scuolaSpring.Converter.DocenteConverter;
import com.example.scuolaSpring.DTO.DocDTOstring;
import com.example.scuolaSpring.DTO.DocenteDTO;
import com.example.scuolaSpring.Entity.Docente;
import com.example.scuolaSpring.Repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DocenteService {
    DocenteRepository docenteRepository;
    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public DocDTOstring getDocenteById(int id) {
        Docente docente=docenteRepository.findById(id).orElseThrow(()->new NoSuchElementException("Docente non trovato"));
        return DocenteConverter.toDTOString(docente);
    }

    public List<DocDTOstring> getAllDocentes() {
        List<Docente> docenti=docenteRepository.findAll();
        List<DocDTOstring> lista=docenti.stream()
                .map(DocenteConverter::toDTOString)
                .toList();
        return lista;
    }

    public DocDTOstring saveDocente(DocenteDTO docenteDTO) {
        Docente docente=DocenteConverter.toEntity(docenteDTO);
        docenteRepository.save(docente);
        return DocenteConverter.toDTOString(docente);
    }

    public DocDTOstring deleteDocente(Integer id) {
        Docente docente=docenteRepository.findById(id).orElseThrow(()->new NoSuchElementException("Docente non trovato"));
        DocDTOstring docDTOstring=DocenteConverter.toDTOString(docente);
        docenteRepository.delete(docente);
        return docDTOstring;


    }

    public DocDTOstring updateDocente(Integer id,DocenteDTO docenteDTO) {
        Docente docente=docenteRepository.findById(id).orElseThrow(()->new NoSuchElementException("Docente non trovato"));
        docente.setNome(docenteDTO.getNome()!=null?docenteDTO.getNome():docente.getNome());
        docente.setCognome(docenteDTO.getCognome()!=null?docenteDTO.getCognome():docente.getCognome());
        docenteRepository.save(docente);
        return DocenteConverter.toDTOString(docente);
    }
}
