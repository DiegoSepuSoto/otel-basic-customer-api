package soto.diegosepu.basiccustomerapi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import soto.diegosepu.basiccustomerapi.repositories.db.sqlite.customerdb.CustomerInfoRepository;

@SpringBootApplication
public class BasicCustomerApiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BasicCustomerApiApplication.class);
        CustomerInfoRepository customerInfoRepository = new CustomerInfoRepository();

        customerInfoRepository.connect();
        customerInfoRepository.prepareTables();
        customerInfoRepository.prepareData();

        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}