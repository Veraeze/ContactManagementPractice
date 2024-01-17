package callmanager;

import callmanager.exceptions.CannotBeFound;

import java.util.ArrayList;

public class User {
    private String location;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String email;
    private int numberOfContacts;
    ArrayList<Contact> contacts;


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

}
