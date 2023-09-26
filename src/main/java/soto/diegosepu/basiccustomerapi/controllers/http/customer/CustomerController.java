package soto.diegosepu.basiccustomerapi.controllers.http.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soto.diegosepu.basiccustomerapi.models.Customer;
import soto.diegosepu.basiccustomerapi.usecases.CustomerUseCaseI;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerUseCaseI customerUsecase;

    public CustomerController(CustomerUseCaseI customerUsecase) {
        this.customerUsecase = customerUsecase;
    }

    @GetMapping("/customer")
    public Customer getCustomerInfo(@RequestParam() String customerID) {
        double randomNumber = Math.random();

        if (randomNumber > 0.5) {
            throw new RuntimeException("internal service error");
        }

        return customerUsecase.GetCustomer(customerID);
    }
}
