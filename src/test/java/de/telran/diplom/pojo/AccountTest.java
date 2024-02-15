package de.telran.diplom.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountTest {
    @Mock
    Client clientMock;

    @InjectMocks
    Account accountTest;

    @Test
    void getName() {
        String exp = "TestName";
        accountTest.setName(exp);
        assertEquals(exp, accountTest.getName());
    }

    @Test
    void setName() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}