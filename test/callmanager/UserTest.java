package callmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    @BeforeEach
    void setUser(){
        user = new User("Nigeria +234", "Vera", "Ezeagu", "07049027507", "Vera@yahoo.com");
    }

    @Test
    void testUserCanAddNewContact(){
        user.addContact("0801", "susan", "eze");
        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());
    }

}