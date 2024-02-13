package de.telran.diplom.run;

import de.telran.diplom.pojo.*;
import de.telran.diplom.repository.JsonTransactionalRepository;
import de.telran.diplom.service.TransactionalService;

import java.time.LocalDate;

public class SimpleAll {
    public static void main(String[] args) {

        Manager manager =  new Manager(1,"Дуся", "Менеджер", StatusManager.WORK, LocalDate.now(), LocalDate.now());

        Client client = new Client(1, "Василий", "Пупкин",StatusManager.WORK,
                LocalDate.now(), LocalDate.now(), "1234567890", "vasya@gmail.com",
                "Берлин, Блюменштрассе 5, 12345", "+4916012345678", manager
        );

        Account account1 = new Account(1, "Мой дебет счет", "Расчетный", StatusAccount.OPEN,
                LocalDate.now(), LocalDate.now(), 100.0, "EUR", client);

        Account account2 = new Account(2, "Мой кредит счет", "Расчетный", StatusAccount.OPEN,
                LocalDate.now(), LocalDate.now(), 100.0, "EUR", client);

        Transactional transactional1 = Transactional.builder()
                .id(1)
                .type("Зарплата")
                .createdAt(LocalDate.now())
                .amount(50.0)
                .debitAccountId(account1)
                .creditAccountId(account2)
                .build();

        TransactionalService tservice = new TransactionalService(new JsonTransactionalRepository());
        tservice.save(transactional1);
    }


}
