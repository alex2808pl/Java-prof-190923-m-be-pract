package de.telran.diplom.pojo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimpleSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path path = Paths.get("client.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(path))) {

            Manager manager =  new Manager(1,"Дуся", "Менеджер",StatusManager.WORK,LocalDate.now(), LocalDate.now());

            Client client = new Client(1, "Василий", "Пупкин",StatusManager.WORK,
                    LocalDate.now(), LocalDate.now(), "1234567890", "vasya@gmail.com",
                    "Берлин, Блюменштрассе 5, 12345", "+4916012345678", manager
                   );

            Account account1 = new Account(1, "Мой дебет счет", "Расчетный", StatusAccount.OPEN,
                    LocalDate.now(), LocalDate.now(), 100.0, "EUR", client);

            Account account2 = new Account(2, "Мой кредит счет", "Расчетный", StatusAccount.OPEN,
                    LocalDate.now(), LocalDate.now(), 100.0, "EUR", client);

            Account account3 = new Account(2, "Мой кредит счет", null, null,
                    null, null, 0.0, null, null);

            Account account4 = Account.builder()
                            .id(3)
                            .name("Мой 2й кредит счет")
                    .client(client)
                    .build();
            System.out.println(account4);

            Transactional transactional1 = Transactional.builder()
                    .id(1)
                    .type("Зарплата")
                    .createdAt(LocalDate.now())
                    .amount(50.0)
                    .debitAccountId(account1)
                    .creditAccountId(account2)
                    .build();

            List<Account> accounts = new ArrayList<>();
            accounts.add(account1);
            accounts.add(account2);

            oos.writeObject(transactional1);
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
//            Client read = (Client) ois.readObject();
//            List<Account> accounts = (List<Account>) ois.readObject();

            Transactional read = (Transactional) ois.readObject();
            System.out.printf("Read person: %s", read);
        }





    }
}
