package de.telran.diplom.run;

import com.fasterxml.jackson.databind.JsonMappingException;
import de.telran.diplom.pojo.*;
import de.telran.diplom.repository.DataRepository;
import de.telran.diplom.repository.XmlTransactionalRepository;

import java.time.LocalDate;

public class SimpleXml {
    public static void main(String[] args) throws JsonMappingException {
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


        DataRepository<Transactional> trRep = new XmlTransactionalRepository();
        trRep.save(transactional1);

        Transactional trRead = trRep.read();
        System.out.println(trRead);


    }
}
