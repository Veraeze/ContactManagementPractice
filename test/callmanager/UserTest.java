package callmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testUserCanAddNewContact(){
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact(new Contact("CM1", "fname ", "lname", "phone1"));

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

        user.addContact(new Contact("CM1", "fname ", "lname", "phone1"));
        user.addContact(new Contact("CM2", "fname ", "lname", "phone2"));
        user.addContact(new Contact("CM3", "fname ", "lname", "phone3"));

        assertEquals(3, user.getNumberOfContacts());
    }

    @Test
    void testUserCanEditContact(){
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        Contact contact1 = user.addContact(new Contact("CM1", "fname", "lname", "phone1"));

        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());

        user.editContact(contact1, "0801", "helen", "okafor");

        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());

    }

    @Test
    void throwsException_UserTriesToEditContactWithWrong() {
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        Contact contact = user.addContact(new Contact("CM1", "fname", "lname", "phone1"));

        assertEquals(1, user.getNumberOfContacts());
        assertEquals("CM1", user.generateID());

        user.editContact(contact, "0801", "helen", "okafor");
    }

    @Test
    void testUserCanDeleteContact() {
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        user.addContact(new Contact("CM1", "fname ", "lname", "phone1"));
        user.addContact(new Contact("CM2", "fname ", "lname", "phone2"));
        user.addContact(new Contact("CM3", "fname ", "lname", "phone3"));

        assertEquals(3, user.getNumberOfContacts());

        user.deleteContact("phone2");
        assertEquals(2, user.getNumberOfContacts());
    }

    @Test
    void testUserCanSearchForContact() {
        User user = new User("Nigeria +234", "Vera", "Ezeagu", "0704", "Vera@yahoo.com");

        Contact contact1 = user.addContact(new Contact("CM1", "fname ", "lname", "phone1"));
        Contact contact2 = user.addContact(new Contact("CM2", "fname ", "lname", "phone2"));
        Contact contact3 = user.addContact(new Contact("CM3", "fname ", "lname", "phone3"));

        assertEquals(contact3, user.searchContactBy("phone3"));
        assertEquals(contact1, user.searchContactBy("phone1"));
        assertEquals(contact2, user.searchContactBy("phone2"));

    }

}