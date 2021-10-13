package fontys.crossyn;

import fontys.crossyn.service.IOService;
import fontys.crossyn.service.JSONReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrossynApplication {


    public static void main(String[] args) {

        //IOService ioService = new IOService();
        //ioService.convertTxtToJson();

        JSONReader reader = new JSONReader();
        reader.readJson();

        SpringApplication.run(CrossynApplication.class, args);
    }



}
