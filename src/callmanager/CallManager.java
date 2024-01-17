package callmanager;

import callmanager.exceptions.CannotBeFound;
import callmanager.exceptions.UnknownCaller;
import callmanager.exceptions.WrongDetails;

import java.util.ArrayList;

public class CallManager {
    ArrayList<User> users = new ArrayList<>();
    public int numberOfUsers(){
        return users.size();
    }

    public User register(String location, String mobileNumber, String firstName, String lastName,
                         String email, String password){
        User user = new User(location, mobileNumber, firstName, lastName, email);
        user.setPassword(password);
        users.add(user);
        return user;
    }

    public void login(String email, String password){
        User user = searchUserBy(email);
        if (!user.getPassword().equals(password)) throw new WrongDetails("This email does not match this password");
        user.setLoggedIn(true);
    }

    private User searchUserBy(String email) {
        for (User user: users){
            if(user.getEmail().equals(email)) return user;
        }
        throw new CannotBeFound("User with this email cannot be found");
    }
    private void validateCall(String mobile) {

    }

    public User findUser(String phoneNumber){
        validateCall();
        for (User user : users) {
            if (user.searchContactBy(phoneNumber) != null) return user;
        }
        throw new UnknownCaller("No available information on this caller");
    }


}
