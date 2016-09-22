package bootworkshop.pivotal.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rhardt on 9/21/16.
 */
@RestController
@EnableConfigurationProperties(GreeterSettings.class)
public class HelloController {


    @Autowired
    private GreeterSettings greeterSettings;

    @RequestMapping("/")
    public String sayHello(){
        return String.format("Hello %s!", greeterSettings.getName());
    }

    @RequestMapping("/greeting")
    public Greeting greet(@RequestParam(value="n", required = false) String name) {
        if (name == null) {
            name = "DISH";
        }
        return new Greeting("Hello", name, true);
    }


}


class Greeting {
    private String message;
    private String greeting;
    private boolean happyToSeeYou;

    public Greeting(String message, String greeting, boolean happyToSeeYou) {
        this.message = message;
        this.greeting = greeting;
        this.happyToSeeYou = happyToSeeYou;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public boolean isHappyToSeeYou() {
        return happyToSeeYou;
    }

    public void setHappyToSeeYou(boolean happyToSeeYou) {
        this.happyToSeeYou = happyToSeeYou;
    }
}