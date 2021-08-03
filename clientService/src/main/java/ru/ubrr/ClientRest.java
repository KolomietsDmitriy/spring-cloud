package ru.ubrr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
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

    //    @RequestMapping("/update/{id}")
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable int id, @RequestParam String name) {
        if (dao.update(id, name)) {
            return new ResponseEntity(OK);
        } else {
            return new ResponseEntity(NOT_FOUND);
        }
    }

//    @RequestMapping("/delete")
    @DeleteMapping("{id}")
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
