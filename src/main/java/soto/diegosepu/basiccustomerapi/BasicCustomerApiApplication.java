package soto.diegosepu.basiccustomerapi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicCustomerApiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BasicCustomerApiApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}