package de.telran.generic.sender;

public interface Test {
    default void test1() {
        System.out.println("test1");
    };
    default void test2() {
        System.out.println("test2");
    }
}
