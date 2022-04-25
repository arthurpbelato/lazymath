package io.arhturpbelato.service.service.pythagorascalculator;

import org.springframework.stereotype.Component;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.arthurcalculator.Calculator;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WithoutLegACalculator implements PythagorasCalculator {

    private final Calculator calculator;

    @Override
    public boolean isEligible(PythagoreanTheorem theorem) {
        return theorem.getA() == null;
    }

    @Override
    public PythagoreanTheorem calculate(PythagoreanTheorem theorem) {
        theorem.setA(Math.sqrt(calculator.square(theorem.getC()) - calculator.square(theorem.getB())));
        return theorem;
    }
}
