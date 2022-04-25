package io.arhturpbelato.service.pythagorascalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.PythagoreanTheoremBuilder;
import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.arthurcalculator.Calculator;
import io.arhturpbelato.service.service.pythagorascalculator.WithoutLegCCalculator;

class WithoutLegCCalculatorTest {

    private final WithoutLegCCalculator calculator = new WithoutLegCCalculator(new Calculator());

    @Test
    void isEligible_shouldReturnTrue_whenLegCIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegC().build();
        Assertions.assertTrue(calculator.isEligible(theorem));
    }

    @Test
    void calculate_shouldReturnFullObject_whenLegCIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegC().build();
        calculator.calculate(theorem);

        Assertions.assertNotNull(theorem.getC());
        Assertions.assertEquals(5.0, theorem.getC());
    }
}
