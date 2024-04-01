package org.example.service;
import lombok.extern.slf4j.Slf4j;

import org.example.interfaces.IService;
import org.example.model.Pessoa;

import org.example.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class PessoaService implements IService<Pessoa,Integer> {

    @Autowired //injeção de dependência
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public Pessoa create(Pessoa entity) {
        log.info("Acessando método AlunoService.create");
        log.debug("Valores recebidos: {}", entity);

        return pessoaRepository.save(entity);
    }

    @Override
    public List<Pessoa> read() {
        log.info("Acessando método AlunoResource.read()");

        List<Pessoa> pessoas = pessoaRepository.findAll();

        log.debug("Resultado da consulta: {} registros", pessoas.size());

        return pessoas;
    }

    @Override
    public Pessoa read(Integer id) {
        log.info("Acessando método AlunoResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Aluno alunoEncontrado = alunoRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public Pessoa update(Integer id, Pessoa entity) {
        log.info("Acessando método AlunoService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<Pessoa> alunoEncontrado = pessoaRepository.findById(id);
        if(alunoEncontrado.isPresent()){
            pessoaRepository.save(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.info("Acessando método delete");
        log.info("Valor recebido: {id}", id);

    }
}