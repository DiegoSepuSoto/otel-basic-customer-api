package soto.diegosepu.basiccustomerapi.usecases.customer;

import org.springframework.stereotype.Component;
import soto.diegosepu.basiccustomerapi.models.Customer;
import soto.diegosepu.basiccustomerapi.repositories.CustomerInfoI;
import soto.diegosepu.basiccustomerapi.usecases.CustomerUseCaseI;

@Component
public class CustomerUseCase implements CustomerUseCaseI {
    private final CustomerInfoI customerInfoRepository;

    public CustomerUseCase(CustomerInfoI customerInfoRepository) {
        this.customerInfoRepository = customerInfoRepository;
    }

    public Customer GetCustomer(String customerID) {
        return this.customerInfoRepository.GetCustomerInfo(customerID);
    }
}
