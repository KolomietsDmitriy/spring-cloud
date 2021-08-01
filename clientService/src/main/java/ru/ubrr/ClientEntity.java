package ru.ubrr;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Setter
public class ClientEntity implements Client {

    @Id
    @GeneratedValue(strategy = AUTO)
    Integer id;
    String name;


    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
