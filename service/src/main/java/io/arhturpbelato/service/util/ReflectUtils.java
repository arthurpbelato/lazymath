package io.arhturpbelato.service.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectUtils {
    public static <T> List<Method> getMethods(T object) {
        return Arrays.stream(object.getClass().getDeclaredMethods()).toList();
    }

    public static <T> List<Field> getFields(T object) {
        return Arrays.stream(object.getClass().getDeclaredFields()).toList();
    }

    private static String getSetterName(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    public static <T> Method getSetter(T object, Field field) {
        List<Method> methods = getMethods(object);
        return methods.stream().filter(method -> method.getName().equals(getSetterName(field.getName())))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private ReflectUtils() {
    }
}
