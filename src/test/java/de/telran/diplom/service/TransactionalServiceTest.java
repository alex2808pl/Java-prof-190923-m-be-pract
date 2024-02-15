package de.telran.diplom.service;

import de.telran.diplom.pojo.*;
import de.telran.diplom.repository.DataRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionalServiceTest {

    @Mock
    DataRepository<Transactional> repository;
    @InjectMocks
    TransactionalService service;

    Transactional testTransactional;

    @BeforeEach
    void before() {
        Manager manager =  new Manager(1,"Дуся", "Менеджер", StatusManager.WORK, LocalDate.now(), LocalDate.now());

        Client client = new Client(1, "Василий", "Пупкин",StatusManager.WORK,
                LocalDate.now(), LocalDate.now(), "1234567890", "vasya@gmail.com",
                "Берлин, Блюменштрассе 5, 12345", "+4916012345678", manager
        );

        Account account1 = new Account(1, "Мой дебет счет", "Расчетный", StatusAccount.OPEN,
                LocalDate.now(), LocalDate.now(), 100.0, "EUR", client);

        Account account2 = new Account(2, "Мой кредит счет", "Расчетный", StatusAccount.OPEN,
                LocalDate.now(), LocalDate.now(), 100.0, "EUR", client);

        testTransactional = Transactional.builder()
                .id(1)
                .type("Зарплата")
                .createdAt(LocalDate.now())
                .amount(50.0)
                .debitAccountId(account1)
                .creditAccountId(account2)
                .build();
    }

    @SneakyThrows
    @Test
    @DisplayName("Тестируем позитивный сценарий saveTest")
    void saveTest() {  //позитивный сценарий
        Mockito.when(repository.save(Mockito.any(Transactional.class))).thenReturn(true);
        assertTrue(service.save(testTransactional));
    }

    @Test
    void saveTestException() { //негативный сценарий
        Mockito.when(repository.save(Mockito.any(Transactional.class))).thenReturn(false);
        assertThrows(IOException.class,
                () -> service.save(testTransactional));
    }

    @Test
    void readTest() {
        Mockito.when(repository.read()).thenReturn(testTransactional);
        Transactional actual = service.read();
        assertEquals(testTransactional, actual);

    }
}