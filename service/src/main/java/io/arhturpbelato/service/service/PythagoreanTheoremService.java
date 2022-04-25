package io.arhturpbelato.service.service;

import org.springframework.stereotype.Service;

import java.util.List;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.pythagorascalculator.PythagorasCalculator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PythagoreanTheoremService {

    private final List<PythagorasCalculator> calculators;

    public void solve(PythagoreanTheorem theorem) {
        calculators.stream().filter(c -> c.isEligible(theorem))
                .findFirst().orElseThrow(RuntimeException::new)
                .calculate(theorem);
    }

}
