package ru.ubrr.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ubrr.dao.ProcessingRepository;
import ru.ubrr.model.ProcessingEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProcessingRest {

    @Autowired
    ProcessingRepository repository;
    @Autowired
    AccountServiceClient account;
    @Autowired
    CardServiceClient card;

    @GetMapping("issue/{accountId}")
    public String issueNewCard(@PathVariable Integer accountId) {
        val cardNumber = card.createCard();

        repository.save(new ProcessingEntity(cardNumber, accountId));

        return cardNumber;
    }

    @GetMapping("/checkout/{card}")
    public boolean checkout(@PathVariable String card, @RequestParam BigDecimal sum) {
        ProcessingEntity processingEntity = repository.findByCard(card);

        if (processingEntity == null) return false;

        return account.checkout(processingEntity.getAccountId(), sum);

    }

    @GetMapping("get")
    public Map<Integer, String> getByAccount(@RequestParam("account_id") List<Integer> accountIdList) {
        return repository.findByAccountIdIn(accountIdList)
                .stream()
                .collect(Collectors.toMap(ProcessingEntity::getAccountId, ProcessingEntity::getCard));

    }

}
