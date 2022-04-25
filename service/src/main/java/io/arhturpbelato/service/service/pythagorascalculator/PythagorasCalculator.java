package io.arhturpbelato.service.service.pythagorascalculator;

import io.arhturpbelato.service.model.PythagoreanTheorem;

public interface PythagorasCalculator {

    boolean isEligible(PythagoreanTheorem theorem);

    PythagoreanTheorem calculate(PythagoreanTheorem theorem);
}
