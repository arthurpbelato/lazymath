package io.arhturpbelato.service.service.arthurcalculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Double square(Double number) {
        return Math.pow(number, 2);
    }
}
