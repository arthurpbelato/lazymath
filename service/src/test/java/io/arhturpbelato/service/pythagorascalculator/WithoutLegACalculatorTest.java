package io.arhturpbelato.service.pythagorascalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.PythagoreanTheoremBuilder;
import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.arthurcalculator.Calculator;
import io.arhturpbelato.service.service.pythagorascalculator.WithoutLegACalculator;

class WithoutLegACalculatorTest {

    private final WithoutLegACalculator calculator = new WithoutLegACalculator(new Calculator());

    @Test
    void isEligible_shouldReturnTrue_whenLegAIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegA().build();
        Assertions.assertTrue(calculator.isEligible(theorem));
    }

    @Test
    void calculate_shouldReturnFullObject_whenLegAIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegA().build();
        calculator.calculate(theorem);

        Assertions.assertNotNull(theorem.getA());
        Assertions.assertEquals(3.0, theorem.getA());
    }
}
