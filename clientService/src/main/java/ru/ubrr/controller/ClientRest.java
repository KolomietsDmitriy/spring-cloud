package ru.ubrr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ubrr.dao.ClientDAO;
import ru.ubrr.dao.ClientRepository;
import ru.ubrr.model.Client;
import ru.ubrr.model.ClientEntity;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
//@RequestMapping("clientService")
public class ClientRest {

    @Autowired
    ClientDAO dao;

    @Autowired
    ClientRepository repo;

    //    @RequestMapping("/create")
    @GetMapping("create")
    public Client create(@RequestParam String name) {
        return dao.create(name);
    }

    @RequestMapping("/update/{id}")
//    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestParam String name) {
        if (dao.update(id, name)) {
            return new ResponseEntity(OK);
//            return repo.findById(id).orElse(null);
        } else {
            return new ResponseEntity(NOT_FOUND);
//            return dao.create(name);
        }
    }

    @RequestMapping("/delete/{id}")
//    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }

    //    @RequestMapping("/get")
    @GetMapping
    public List<ClientEntity> get() {
        return repo.findAll();
    }

    //    @RequestMapping("/get/{id}")
    @GetMapping("{id}")
    public Client get(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }
}
