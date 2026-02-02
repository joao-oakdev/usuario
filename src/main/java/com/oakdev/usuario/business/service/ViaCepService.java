package com.oakdev.usuario.business.service;


import com.oakdev.usuario.infrastructure.clients.ViaCepClient;
import com.oakdev.usuario.infrastructure.clients.ViaCepDTO;
import com.oakdev.usuario.infrastructure.exceptions.IllegalArgumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepDTO buscarDadosEndereco(String cep){
            return viaCepClient.buscaDadosDeEndereco(processarCep(cep));
    }

    private String processarCep(String cep){
        String cepFormatado = cep.replace(" ", "")
                .replace("-", "");

        if(!cepFormatado.matches("\\d+")
                || !Objects.equals(cepFormatado.length(), 8)){
throw new IllegalArgumentException("O cep contém caracteres inválidos, favor verificar");
        }

        return cepFormatado;
    }
}
