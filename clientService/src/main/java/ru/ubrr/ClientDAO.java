package ru.ubrr;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDAO {
    @Autowired
    private ClientRepository repo;

    public ClientEntity create(String name) {
        val client = new ClientEntity();
        client.setName(name);
        return repo.save(client);
    }

    public boolean update(int id, String name) {
        val client = repo.findById(id).orElse(null);
        if (client == null) {
            return false;
        } else {
            client.setName(name);
            repo.save(client);
            return true;
        }
    }
}