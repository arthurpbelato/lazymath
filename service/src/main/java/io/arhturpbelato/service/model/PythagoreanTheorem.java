package io.arhturpbelato.service.model;

import io.arhturpbelato.service.model.enums.PythagoreanTheoremFieldsEnum;
import io.arhturpbelato.service.util.ReflectUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Slf4j
public class PythagoreanTheorem {
    private Double a;
    private Double b;
    private Double c;

    public void solve() {
        List<Field> fields = ReflectUtils.getFields(this);
        fields.forEach(field -> {
            try {
                if (Objects.isNull(field.get(this))) {
                    solveNullField(this, field);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
    }

    private static void solveNullField(PythagoreanTheorem dto, Field field)
            throws IllegalAccessException, InvocationTargetException {
        Method setter = ReflectUtils.getSetter(dto, field);
        PythagoreanTheoremFieldsEnum nullField = PythagoreanTheoremFieldsEnum.getField(field.getName());
        setter.invoke(dto, nullField.calculate(dto));
    }
}
