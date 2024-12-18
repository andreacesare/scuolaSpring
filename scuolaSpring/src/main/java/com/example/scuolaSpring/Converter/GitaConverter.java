package com.example.scuolaSpring.Converter;

import com.example.scuolaSpring.DTO.ClasseDTOstring;
import com.example.scuolaSpring.DTO.GitaDTO;
import com.example.scuolaSpring.DTO.GitaDTOstring;
import com.example.scuolaSpring.Entity.Gita;

import java.util.List;

public class GitaConverter {

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
}
