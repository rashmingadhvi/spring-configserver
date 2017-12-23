package rmk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClient2 {
    public static void main (String a[]){
        SpringApplication.run(ConfigClient2.class, a);
    }
}


@RefreshScope
@RestController
class ClientController {


    @Autowired
    Environment environment;

    @RequestMapping("/fullname")
    public String getFullName(){
        return "Full name: "+environment.getProperty("full.name")+"<b> Family Name: "+
                environment.getProperty("family.name");
    }

}