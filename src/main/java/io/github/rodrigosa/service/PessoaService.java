package io.github.rodrigosa.service;

import io.github.rodrigosa.model.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    public void salvarPessoa(Pessoa pessoa){
        validarPessoa(pessoa);

    }

    public void validarPessoa(Pessoa pessoa){

        //aplicar validações

    }
}
