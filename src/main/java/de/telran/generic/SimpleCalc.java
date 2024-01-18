package de.telran.generic;

import java.net.InterfaceAddress;

public class SimpleCalc {
    public static void main(String[] args) {
        System.out.println(AriphmUtils.<Integer>add(5,2));
        System.out.println(AriphmUtils.add(6.0,8.0));
        System.out.println(AriphmUtils.add(6.0F,8.0F));
        System.out.println(AriphmUtils.add(50L,2L));

        System.out.println(AriphmUtils.<Double,Integer>div(10.0,2.0));

//        System.out.println(5F/0);

        Double arg1 = 22.0;
        Double arg2 = 2.0;
        System.out.println(Double.valueOf(arg1.doubleValue() / arg2.doubleValue()));


    }
}


//    T add(T arg1, T arg2) //добавление
//    T sub(T arg1, T arg2) //вычитание
//    T mult(T arg1, T arg2) //умножение
//    U div(T arg1, T arg2) //деление
//    T sqr(T arg) //получение квадрата