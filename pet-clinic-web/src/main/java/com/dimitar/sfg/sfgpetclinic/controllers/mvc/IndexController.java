package com.dimitar.sfg.sfgpetclinic.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "", "index", "index.html"})
    public String index() {
        return "index";
    }


    @RequestMapping({"/oups"})
    public String oups() {
        return "notimplemented";
    }
}
