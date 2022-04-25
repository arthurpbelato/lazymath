package builder;

import io.arhturpbelato.service.model.PythagoreanTheorem;

public class PythagoreanTheoremBuilder {

    private PythagoreanTheorem theorem;

    public static PythagoreanTheoremBuilder getOne() {
        PythagoreanTheoremBuilder pythagoreanTheoremBuilder = new PythagoreanTheoremBuilder();
        pythagoreanTheoremBuilder.theorem = PythagoreanTheorem.builder()
                .a(3.0)
                .b(4.0)
                .c(5.0)
                .build();
        return pythagoreanTheoremBuilder;
    }

    public PythagoreanTheoremBuilder withoutLegA() {
        theorem.setA(null);
        return this;
    }

    public PythagoreanTheoremBuilder withoutLegB() {
        theorem.setB(null);
        return this;
    }

    public PythagoreanTheoremBuilder withoutLegC() {
        theorem.setC(null);
        return this;
    }

    public PythagoreanTheorem build() {
        return theorem;
    }
}
