package soto.diegosepu.basiccustomerapi.usecases;

import soto.diegosepu.basiccustomerapi.models.Customer;

public interface CustomerUseCaseI {
    Customer GetCustomer(String customerID);
}
