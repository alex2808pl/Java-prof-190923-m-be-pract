package de.telran.diplom.repository;

import com.fasterxml.jackson.databind.JsonMappingException;

public interface DataRepository <T> {
    boolean save(T item);
    T read();
    default String getRepositoryStr() {
        return "";
    } //временно
}
