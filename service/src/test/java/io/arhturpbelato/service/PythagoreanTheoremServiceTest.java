package io.arhturpbelato.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.LinkedList;
import java.util.List;

import builder.PythagoreanTheoremBuilder;
import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.PythagoreanTheoremService;
import io.arhturpbelato.service.service.pythagorascalculator.PythagorasCalculator;
import io.arhturpbelato.service.service.pythagorascalculator.WithoutLegACalculator;
import io.arhturpbelato.service.service.pythagorascalculator.WithoutLegBCalculator;
import io.arhturpbelato.service.service.pythagorascalculator.WithoutLegCCalculator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PythagoreanTheoremServiceTest {

    @Spy
    private List<PythagorasCalculator> pythagorasCalculators = new LinkedList<>();

    @Mock
    private WithoutLegACalculator withoutLegACalculator;

    @Mock
    private WithoutLegBCalculator withoutLegBCalculator;

    @Mock
    private WithoutLegCCalculator withoutLegCCalculator;

    @InjectMocks
    private PythagoreanTheoremService service;

    @BeforeEach
    private void setUp() {
        pythagorasCalculators.add(withoutLegACalculator);
        pythagorasCalculators.add(withoutLegBCalculator);
        pythagorasCalculators.add(withoutLegCCalculator);

        pythagorasCalculators.forEach(calculator -> Mockito.when(calculator.isEligible(Mockito.any())).thenReturn(true));
        pythagorasCalculators.forEach(calculator -> Mockito.when(calculator.calculate(Mockito.any())).thenReturn(null));
    }

    @Test
    void isEligible_shouldReturnTrue_whenLegAIsNull() {
        PythagoreanTheorem theorem = PythagoreanTheoremBuilder.getOne()
                .withoutLegB().build();
        service.solve(theorem);

        verify(withoutLegACalculator, times(1)).calculate(any());
    }
}
