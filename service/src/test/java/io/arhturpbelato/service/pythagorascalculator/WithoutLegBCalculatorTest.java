package io.arhturpbelato.service.pythagorascalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.PythagoreanTheoremBuilder;
import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.arthurcalculator.Calculator;
import io.arhturpbelato.service.service.pythagorascalculator.WithoutLegBCalculator;

class WithoutLegBCalculatorTest {

    private final WithoutLegBCalculator calculator = new WithoutLegBCalculator(new Calculator());

    @Test
    void isEligible_shouldReturnTrue_whenLegBIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegB().build();
        Assertions.assertTrue(calculator.isEligible(theorem));
    }

    @Test
    void calculate_shouldReturnFullObject_whenLegBIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegB().build();
        calculator.calculate(theorem);

        Assertions.assertNotNull(theorem.getB());
        Assertions.assertEquals(4.0, theorem.getB());
    }
}
