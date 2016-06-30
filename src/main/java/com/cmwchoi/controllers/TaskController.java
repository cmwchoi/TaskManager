package com.cmwchoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Christian on 5/27/16.
 */

@Controller
public class TaskController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/details")
    public String details() {
        return "details";
    }

}
