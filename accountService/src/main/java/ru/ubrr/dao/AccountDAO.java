package ru.ubrr.dao;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ubrr.model.AccountEntity;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.math.BigDecimal.ZERO;

@Component
@RequiredArgsConstructor
public class AccountDAO {
    private static Lock balanceLock = new ReentrantLock();

    @Autowired
    AccountRepository repository;

    public AccountEntity create(Integer clientId) {

        return repository.save(new AccountEntity(clientId, ZERO));
    }

    public boolean addBalance(Integer clientId, BigDecimal sum) {
        balanceLock.lock();

        try {
            val account = repository.findById(clientId).orElse(null);
            if (account != null) {
                account.setBalance(account.getBalance().add(sum));
                repository.save(account);
                return true;
            }
        } finally {
            balanceLock.unlock();
        }
        return false;

    }
}
