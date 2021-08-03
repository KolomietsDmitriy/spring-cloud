package ru.ubrr.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@ToString
@Setter
@RequiredArgsConstructor
//@NoArgsConstructor(access = PROTECTED)
public class ClientEntity implements Client {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;
    String name;

    @Override
//    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        return this == o || o != null
                && Hibernate.getClass(this) == Hibernate.getClass(o)
                && o instanceof ClientEntity clientEntity
                && Objects.equals(id, clientEntity.id);
    }

    @Override
    public int hashCode() {
        return 1225950929;
    }
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
