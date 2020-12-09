package it.istat.mec.regedit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegEditApplication {

   

    public static void main(String[] args) {
        SpringApplication.run(RegEditApplication.class, args);
    }

    

}
