package de.telran.diplom.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ManagerTest {
    @InjectMocks
    Manager managerTest;
    @Test
    void getSetFirstNameTest() {
        String exp = "TestName";
        managerTest.setFirstName(exp);
        assertEquals(exp, managerTest.getFirstName());
    }

    @Test
    void testToString() {
    }
}