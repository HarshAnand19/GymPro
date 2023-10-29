package com.stackroute.productwebappservice.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public String webapp() {
        return "index.html";
    }
}
