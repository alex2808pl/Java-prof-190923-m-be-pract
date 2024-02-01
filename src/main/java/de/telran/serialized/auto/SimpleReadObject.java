package de.telran.serialized.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("vasya.dat");
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            Person read = (Person) ois.readObject();
            System.out.printf("Read person: %s", read);
        }
    }
}
