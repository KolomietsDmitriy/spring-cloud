package ru.ubrr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ubrr.dao.AccountDAO;
import ru.ubrr.dao.AccountRepository;
import ru.ubrr.model.Account;
import ru.ubrr.model.AccountEntity;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountRest {

    @Autowired
    AccountDAO dao;

    @Autowired
    AccountRepository repository;

    @GetMapping("create")
    public Account create(@RequestParam Integer clientId) {
        return dao.create(clientId);
    }

    @RequestMapping("/fund/{clientId}")
    public boolean fund(@PathVariable int clientId, @RequestParam BigDecimal sum) {
        return dao.addBalance(clientId, sum.abs());
    }

    @RequestMapping("/checkout/{clientId}")
    public boolean checkout(@PathVariable int clientId, @RequestParam BigDecimal sum) {
        return dao.addBalance(clientId, sum.abs().negate());
    }

    @GetMapping
    public List<AccountEntity> get() {
        return repository.findAll();
    }

    @RequestMapping("/get/{clientId}")
    public List<? extends Account> getByClientId(@PathVariable Integer clientId) {

        return repository.findByClientId(clientId);
    }
}
