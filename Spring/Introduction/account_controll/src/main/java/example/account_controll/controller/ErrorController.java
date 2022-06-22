package example.account_controll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
    @GetMapping("/error")
    @ResponseBody
    public String errorReturn(){
        return "There's mo page";
    }
}
