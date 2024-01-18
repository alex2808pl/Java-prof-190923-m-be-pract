package de.telran.generic;

public class AriphmUtils {

    //добавление
    public static <T extends Number> T add(T arg1, T arg2) {
        return (T)Double.valueOf(arg1.doubleValue() + arg2.doubleValue());
    }

    public static <T extends Number,U extends Number> U div(T arg1, T arg2) {
        return (U)Double.valueOf(arg1.doubleValue() / arg2.doubleValue());
    }

}
