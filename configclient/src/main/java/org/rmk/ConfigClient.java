package org.rmk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClient {
    public static void main (String a[]){
        SpringApplication.run(ConfigClient.class, a);
    }
}


@RefreshScope
@RestController
class ClientController {


    @Autowired
    Environment environment;

    @RequestMapping("/familyname")
    public String getFamilyName(){
        return environment.getProperty("family.name");
    }

}