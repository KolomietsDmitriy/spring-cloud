package ru.ubrr.dao;

import lombok.val;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CardNumberGenerator {
    Random random = new Random(System.currentTimeMillis());

    public String generate() {
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, 15)
                .mapToObj(i -> (Integer) random.nextInt(10))
                .forEach(builder::append);

        builder.append(getCheckDigit(builder.toString()));
        return builder.toString();
    }

    private Integer getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, (i + 1)));
            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }
}