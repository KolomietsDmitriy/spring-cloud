package ru.ubrr;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class ClientEntity implements Client {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    int id;
    String name;

//
//    public Integer getId() {
//        return id;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }

}
