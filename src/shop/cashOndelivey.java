package shop;


public class cashOndelivey implements Payment {
    private String Name;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "cashOndelivey{" + "Name=" + Name + ", phoneNumber=" + phoneNumber + '}';
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String paymentMethod() {
        return "Cash on delivery";
    }
    
}
