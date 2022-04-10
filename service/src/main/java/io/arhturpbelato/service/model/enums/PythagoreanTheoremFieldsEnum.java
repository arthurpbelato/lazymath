package io.arhturpbelato.service.model.enums;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.strategy.FormulaStrategy;
import io.arhturpbelato.service.util.MathUtils;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PythagoreanTheoremFieldsEnum implements FormulaStrategy<PythagoreanTheorem> {

    A("a") {
        @Override
        public Double calculate(PythagoreanTheorem obj) {
            return Math.sqrt(MathUtils.square(obj.getC()) - MathUtils.square(obj.getB()));
        }
    },
    B("b") {
        @Override
        public Double calculate(PythagoreanTheorem obj) {
            return Math.sqrt(MathUtils.square(obj.getC()) - MathUtils.square(obj.getA()));
        }
    },
    C("c") {
        @Override
        public Double calculate(PythagoreanTheorem obj) {
            return Math.sqrt(MathUtils.square(obj.getA()) + MathUtils.square(obj.getB()));
        }
    };

    private final String fieldName;

    PythagoreanTheoremFieldsEnum(String fieldName) {
        this.fieldName = fieldName;
    }

    public static PythagoreanTheoremFieldsEnum getField(String fieldName){
        return Arrays.stream(PythagoreanTheoremFieldsEnum.values())
                .filter(value -> value.getFieldName().equals(fieldName))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
