package ru.ubrr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ClientRest {

    @Autowired
    ClientDAO dao;

    @Autowired
    ClientRepository repo;

    @RequestMapping("/create")
    public Client create(@RequestParam String name) {
        return dao.create(name);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestParam String name) {
        if (dao.update(id, name)) {
            return new ResponseEntity(OK);
        } else {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @RequestMapping("/delete")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }

    @RequestMapping("/get")
    public List<ClientEntity> get() {
        return repo.findAll();
    }

    @RequestMapping("/get/{id}")
    public Client get(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
}
