package example.account_controll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HemoController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
