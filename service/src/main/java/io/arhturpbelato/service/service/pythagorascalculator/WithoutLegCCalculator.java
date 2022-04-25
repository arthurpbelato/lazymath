package io.arhturpbelato.service.service.pythagorascalculator;

import org.springframework.stereotype.Component;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.arthurcalculator.Calculator;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WithoutLegCCalculator implements PythagorasCalculator {

    private final Calculator calculator;

    @Override
    public boolean isEligible(PythagoreanTheorem theorem) {
        return theorem.getC() == null;
    }

    @Override
    public PythagoreanTheorem calculate(PythagoreanTheorem theorem) {
        theorem.setC(Math.sqrt(calculator.square(theorem.getA()) + calculator.square(theorem.getB())));
        return theorem;
    }
}
