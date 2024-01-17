package callmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CallManagerTest {

    @Test
    void userCanRegisterUser() {
        CallManager callManager = new CallManager();
        callManager.register("location", "mobile", "fname", "lname", "email", "pin");
        assertEquals(1, callManager.numberOfUsers());
    }

    @Test
    void userCanRegisterUserMoreThanOneUser() {
        CallManager callManager = new CallManager();

        callManager.register("location", "mobile1", "fname", "lname", "email", "pin");
        callManager.register("location", "mobile2", "fname", "lname", "email", "pin");
        callManager.register("location", "mobile3", "fname", "lname", "email", "pin");

        assertEquals(3, callManager.numberOfUsers());
    }
    @Test
    void userCanLogin() {
        CallManager callManager = new CallManager();

        User user = callManager.register("location", "mobile1", "fname", "lname", "email", "pin");
        callManager.login("email", "pin");
        assertTrue(user.isLoggedIn());
    }

    @Test
    void testThatUserContactIsFoundWhenCallComesIn() {
        CallManager callManager = new CallManager();

        User user = callManager.register("location", "mobile1", "fname", "lname", "email", "pin");
        callManager.login("email", "pin");
        assertTrue(user.isLoggedIn());


    }
}