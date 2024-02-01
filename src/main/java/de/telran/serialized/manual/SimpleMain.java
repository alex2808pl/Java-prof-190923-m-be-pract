package de.telran.serialized.manual;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleMain {
    public static void main(String[] args) throws Throwable {
        Path path = Paths.get("vasya.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(path))) {
                    Person person = new Person("Вася", "Пупкин",
                      new Address(7, "НашГород", "Бассейная", 1) //manual
            );
            oos.writeObject(person);
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
           Person read = (Person) ois.readObject();
            System.out.printf("Read person: %s", read);
        }
    }
}
