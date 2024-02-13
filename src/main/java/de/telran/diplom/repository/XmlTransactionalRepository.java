package de.telran.diplom.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.telran.diplom.pojo.Transactional;
import lombok.Getter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public class XmlTransactionalRepository implements DataRepository<Transactional>{

    private String repositoryStr;
    private ObjectMapper om = new XmlMapper();
    @Override
    public boolean save(Transactional item) {
        try {
            repositoryStr = om.writeValueAsString(item);
            Files.writeString(Paths.get(
                    Arrays.stream(Transactional.class.getName().split("\\.")).collect(Collectors.toList()).getLast()+".xml"
            ), repositoryStr, StandardCharsets.UTF_8);
        } catch (IOException  e) {
            System.out.println("Ошибка сохранения");
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Transactional read() {
        Transactional read = null;
        try {
            repositoryStr = Files.readString(Paths.get(
                    Arrays.stream(Transactional.class.getName().split("\\.")).collect(Collectors.toList()).getLast()+".xml"
            ));
            read = om.readValue(repositoryStr, Transactional.class);
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
            throw new RuntimeException(e);
        }
//        System.out.printf("Read person: %s\n", read);
        return read;

    }
}
