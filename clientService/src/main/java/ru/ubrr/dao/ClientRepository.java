package ru.ubrr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ubrr.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
