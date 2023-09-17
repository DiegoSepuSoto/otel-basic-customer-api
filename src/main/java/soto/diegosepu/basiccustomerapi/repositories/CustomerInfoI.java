package soto.diegosepu.basiccustomerapi.repositories;

import soto.diegosepu.basiccustomerapi.models.Customer;

public interface CustomerInfoI {
    Customer GetCustomerInfo(String customerID);
}
