package de.telran.diplom.pojo;

import de.telran.serialized.auto.Address;
import de.telran.serialized.auto.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SimpleTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path path = Paths.get("client.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(path))) {

            Client client = new Client(1, "Василий", "Пупкин",StatusManager.WORK,
                    LocalDate.now(), LocalDate.now(), "1234567890", "vasya@gmail.com",
                    "Берлин, Блюменштрассе 5, 12345", "+4916012345678",
                    new Manager(1,"Дуся", "Менеджер",StatusManager.WORK,LocalDate.now(), LocalDate.now()));

            oos.writeObject(client);
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            Client read = (Client) ois.readObject();
            System.out.printf("Read person: %s", read);
        }
    }
}
