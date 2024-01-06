package examenrecu.example.juegosdelhambre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}