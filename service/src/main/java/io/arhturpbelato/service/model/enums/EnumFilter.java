package io.arhturpbelato.service.model.enums;

import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Getter
public class EnumFilter<T extends Enum<T>> {

    private T field;

    public EnumFilter(Class<T> clazz, String fieldName)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getter = clazz.getDeclaredMethod("getFieldName");

        for (T option : clazz.getEnumConstants()) {
            if(String.valueOf(getter.invoke(option)).equals(fieldName)){
                this.field = option;
            }
        }
    }

}
