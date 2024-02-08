package de.telran.diplom.pojo;

public interface DataRepository <T> {
    boolean save(T item);
    T read();
    String getRepositoryStr(); //временно
}
