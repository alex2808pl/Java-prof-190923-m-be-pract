package de.telran.diplom.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.serialized.jackson.Person;
import lombok.Getter;

@Getter
public class JsonRepository<T> implements DataRepository<T>{

    public JsonRepository() {
//        om.registerModule(new JSR310Module());
//        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
    String repositoryStr;
    ObjectMapper om = new ObjectMapper();
    @Override
    public boolean save(T item) {
        try {
            repositoryStr = om.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка сохранения");
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public T read() {
        T read = null;
        try {
            read = (T) om.readValue(repositoryStr, Object.class);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка чтения");
            throw new RuntimeException(e);
        }

        System.out.printf("Read person: %s\n", read);
        return read;

    }
}
