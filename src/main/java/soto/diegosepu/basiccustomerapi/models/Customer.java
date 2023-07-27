package soto.diegosepu.basiccustomerapi.models;

public class Customer {
    private String name;
    private String lastName;
    private String customerID;

    public Customer(String name, String lastName, String customerID) {
        this.name = name;
        this.lastName = lastName;
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
