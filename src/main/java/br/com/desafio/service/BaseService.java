package br.com.desafio.service;

import org.modelmapper.ModelMapper;

public class BaseService {

    ModelMapper getConverter() {
        return new ModelMapper();
    }
}
