package callmanager;

import callmanager.exceptions.ContactAlreadyExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserCanAddNewContact(){
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact("0801", "susan", "eze");

        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());
    }

//    @Test
//    void throwsException_UserTriesToAddTheSameContactTwice(){
//        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");
//
//        user.addContact("0801", "susan", "eze");
//
//        assertThrows(ContactAlreadyExists.class, ()->user.addContact("0801", "susan", "eze"));
//    }


    @Test
    void testUserCanAddNewMoreThanOneContact(){
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact("0801", "susan", "eze");
        user.addContact("0802", "cynthia", "eze");
        user.addContact("0803", "helen", "eze");

        assertEquals(3, user.getNumberOfContacts());
    }

    @Test
    void testUserCanEditContact(){
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact("0801", "susan", "eze");
        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());

        user.editContact("0801", "helen", "okafor");
        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());

    }

    @Test
    void throwsException_UserTriesToEditContactWithWrong() {
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact("0801", "susan", "eze");
        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());

        user.editContact("0801", "helen", "okafor");
    }

    @Test
    void testUserCanDeleteContact() {
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact("0801", "susan", "eze");
        user.addContact("0802", "cynthia", "eze");
        user.addContact("0803", "helen", "eze");

        assertEquals(3, user.getNumberOfContacts());

        user.deleteContact("0802");
        assertEquals(2, user.getNumberOfContacts());
    }

    @Test
    void testUserCanSearchForContact() {
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        Contact susan = user.addContact("0801", "susan", "eze");
        Contact cynthia = user.addContact("0802", "cynthia", "eze");
        Contact helen = user.addContact("0803", "helen", "eze");

        assertEquals(helen, user.searchContactBy("0803"));
        assertEquals(susan, user.searchContactBy("0801"));
        assertEquals(cynthia, user.searchContactBy("0802"));

    }



    }