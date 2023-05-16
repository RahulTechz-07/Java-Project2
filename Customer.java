public class Customer extends Person {
    private String customerId;
    private String phoneNumber;

    private String address;
    private String email;

    Customer()
    {
        super();
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Customer(String name, String dob, String gender, String customerId, String phoneNumber, String address, String email) {
        super(name, dob, gender);
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return  customerId +"    " + super.toString()+"   "+phoneNumber+"     " +address+"   "+email+"   ";
    }
}
