package Models;


public class Contacts
{
  private String firstName, lastName, address, phone;
  private int contactID;
  
  public Contacts(String firstName, String lastName, String address, String phone) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setAddress(address);
    this.setPhone(phone);
  }
  
  public int getContactID() {
    return contactID;
  }
  
  public void setContactID(int contactID) {
    if (contactID >= 0)
      this.contactID = contactID;
    else
      throw new IllegalArgumentException("Contact ID cannot be less than 0");
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    if (!firstName.isEmpty() && firstName.length() <= 15)
      this.firstName = firstName;
    else
      throw new IllegalArgumentException("First name cannot be empty!");
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    if (!lastName.isEmpty() && lastName.length() <= 20)
      this.lastName = lastName;
    else
      throw new IllegalArgumentException("Last name cannot be empty!");
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    if (!address.isEmpty() && address.length() <= 60)
      this.address = address;
    else
      throw new IllegalArgumentException("Address cannot be empty!");
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    if ((!phone.isEmpty()) && (phone.length() <= 12))
      this.phone = phone;
    else {
      throw new IllegalArgumentException("Phone number cannot be empty!");
    }
  }
}

