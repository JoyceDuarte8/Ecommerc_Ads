package org.example.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class Telefone implements IService<Telefone,Integer>{

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Override
    @Transactional
    public Telefone create(Telefone entity) {
        log.info("Acessando método AlunoService.create");
        log.debug("Valores recebidos: {}", entity);
       return telefoneRepository.save(entity);
    }

    @Override
    public List<Telefone> read() {
        log.info("Acessando método TelefoneResource.read()");

        List<Telefone> telefoneList = telefoneRepository.findAll();
        log.debug("Resultado da consulta: {} registros", telefoneList.size());

        return telefoneList;
    }

    @Override
    public Telefone read(Integer id) {
        log.info("Acessando método TeleoneResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);

        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public Telefone update(Integer id, Telefone entity) {
        log.info("Acessando método TelefoneService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<Telefone> telefoneEncontrado = telefoneRepository.findById(id);
        if(telefoneEncontrado.isPresent()){
            telefoneRepository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
