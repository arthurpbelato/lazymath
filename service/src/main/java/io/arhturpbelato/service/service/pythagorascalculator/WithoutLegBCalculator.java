package io.arhturpbelato.service.service.pythagorascalculator;

import org.springframework.stereotype.Component;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.arthurcalculator.Calculator;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WithoutLegBCalculator implements PythagorasCalculator {

    private final Calculator calculator;

    @Override
    public boolean isEligible(PythagoreanTheorem theorem) {
        return theorem.getB() == null;
    }

    @Override
    public PythagoreanTheorem calculate(PythagoreanTheorem theorem) {
        theorem.setB(Math.sqrt(calculator.square(theorem.getC()) - calculator.square(theorem.getA())));
        return theorem;
    }
}
