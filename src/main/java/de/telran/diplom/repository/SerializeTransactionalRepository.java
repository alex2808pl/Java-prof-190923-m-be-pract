package de.telran.diplom.repository;

import de.telran.diplom.pojo.Transactional;
import lombok.Getter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public class SerializeTransactionalRepository implements DataRepository<Transactional> {
    @Override
    public boolean save(Transactional item) {

        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        Files.newOutputStream(
                                Paths.get(Arrays.stream(Transactional.class.getName().split("\\.")).collect(Collectors.toList()).getLast() + ".ser")
                        ))) {
            oos.writeObject(item);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения");
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public Transactional read() {
        try (
                ObjectInputStream ois = new ObjectInputStream(
                        Files.newInputStream(
                                Paths.get(Arrays.stream(Transactional.class.getName().split("\\.")).collect(Collectors.toList()).getLast() + ".ser")
                        ))) {
            Transactional read = (Transactional) ois.readObject();
            return read;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка чтения");
            throw new RuntimeException(e);
        }
    }
}
