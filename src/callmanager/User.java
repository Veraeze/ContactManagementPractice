package callmanager;

import callmanager.exceptions.CannotBeFound;
import callmanager.exceptions.ContactAlreadyExists;

import java.util.ArrayList;

public class User {
    private String location;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    private String mobileNumber;
    private String firstName;
    private String lastName;
    private boolean isLoggedIn;
    private String password;
    private String email;
    private int numberOfContacts;
    ArrayList<Contact> contacts;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String location, String mobileNumber, String firstName, String lastName, String email){
        this.location = location;
        this.mobileNumber = mobileNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        contacts = new ArrayList<>();
    }

    public Contact addContact(String phoneNumber, String firstName, String lastName){
        numberOfContacts++;
        Contact newContact = new Contact(generateID(), firstName + " ", lastName, phoneNumber);
        contacts.add(newContact);

        return newContact;
    }
    public String generateID() {
        return "CM" +numberOfContacts;
    }

    public void editContact(String phoneNumber, String firstName, String lastName){
        Contact existingContact = searchContactBy(phoneNumber);

        existingContact.setFirstName(firstName);
        String editLastname = existingContact.getLastName() + " " + firstName;
        existingContact.setLastName(editLastname);
        String editNumber = existingContact.getPhoneNumber() + " " + phoneNumber;
        existingContact.setPhoneNumber(editNumber);
    }

    public Contact searchContactBy(String phoneNumber) {
        for (Contact contact: contacts){
            if(contact.getPhoneNumber().equals(phoneNumber)) return contact;
        }
        throw new CannotBeFound("Contact cannot be found");
    }

    public void deleteContact(String phoneNumber) {

        contacts.remove(searchContactBy(phoneNumber));
    }

    public int getNumberOfContacts(){
        return contacts.size();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
    public String call(String firstName, String lastName, String mobile){
        Contact contact = searchContactBy(mobile);
        return contact.call(mobile, firstName, lastName);
    }
}
