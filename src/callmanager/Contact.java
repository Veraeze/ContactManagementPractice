package callmanager;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getID() {

        return id;
    }
    public String call(String phoneNumber, String firstName, String lastName){
        return firstName + " " + lastName;
    }

    public String toString() {
        return String.format("""
                ==========================
                Contact ID: %s
                full name: %s
                Phone Number: %s
                ==========================
                 """, id, firstName + "" + lastName, phoneNumber);
    }
}

