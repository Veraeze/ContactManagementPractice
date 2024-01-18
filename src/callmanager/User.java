package callmanager;

import callmanager.exceptions.CannotBeFound;

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

    public Contact addContact(Contact contact){
        numberOfContacts++;
        contact = new Contact(generateID(), contact.getFirstName() , contact.getLastName(), contact.getPhoneNumber());
        contacts.add(contact);

        return contact;
    }
    public String generateID() {
        return "CM" + numberOfContacts;
    }

    public void editContact(Contact contact, String firstName, String lastName, String phoneNumber){
        Contact existingContact = searchContactBy(contact.getPhoneNumber());

        existingContact.setFirstName(firstName);
        String editLastname = existingContact.getLastName() + " " + lastName;
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
    public String call(Contact contact){
        contact = searchContactBy(contact.getPhoneNumber());
        return contact.call(mobileNumber, firstName, lastName);
    }
}
