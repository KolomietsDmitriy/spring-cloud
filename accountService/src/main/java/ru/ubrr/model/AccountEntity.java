package ru.ubrr.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

import static javax.persistence.GenerationType.*;

@Getter
@Entity
@ToString
@Setter
@RequiredArgsConstructor
public class AccountEntity implements Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;
    Integer clientId;
    BigDecimal balance;

    @Override
    public int hashCode() {
        return 1225950929;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null
                && Hibernate.getClass(this) == Hibernate.getClass(o)
                && o instanceof AccountEntity accountEntity
                && Objects.equals(id, accountEntity.id);
    }
}
