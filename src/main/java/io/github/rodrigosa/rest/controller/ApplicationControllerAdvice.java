package io.github.rodrigosa.rest.controller;

import io.github.rodrigosa.exception.RegraNegocioException;
import io.github.rodrigosa.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex) {

        String menssagemErro = ex.getMessage();
        return new ApiErrors(menssagemErro);
    }
}
