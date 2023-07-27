package soto.diegosepu.basiccustomerapi.repository.http.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soto.diegosepu.basiccustomerapi.models.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/customer")
    public Customer getCustomerInfo(@RequestParam() String customerID) {
        try {
            long delay = 1000 + (long) (Math.random() * 1000);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            logger.error("error on delay: {}", e.toString());
            e.printStackTrace();
        }

        return new Customer("John", "Doe", customerID);
    }
}
