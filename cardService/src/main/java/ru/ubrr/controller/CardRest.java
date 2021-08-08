package ru.ubrr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ubrr.dao.CardNumberGenerator;

@RestController
@RequiredArgsConstructor
public class CardRest {

    @Autowired
    CardNumberGenerator cardNumber;

    @RequestMapping("create")
    public String createNewCard() {
        return cardNumber.generate();
    }

}
