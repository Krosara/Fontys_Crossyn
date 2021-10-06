package fontys.crossyn;

import fontys.crossyn.service.IOService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrossynApplication {


    public static void main(String[] args) {

        IOService ioService = new IOService();
        ioService.convertTxtToJson();

        SpringApplication.run(CrossynApplication.class, args);
    }



}
