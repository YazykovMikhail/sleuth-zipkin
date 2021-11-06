package com.yazykov.controllers;

import com.yazykov.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Endpoints {
    Logger logger = Logger.getLogger("Endpoints");

    private final UserService userService;

    public Endpoints(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/start")
    public String start() {
        String user = this.userService.getUsers();
        logger.info("Hello");
        return "Hello " + user;
    }

    @GetMapping("/manual")
    public String manualCheckMethodWork() {
        logger.info("Manual check method work");
        userService.manualCheckMethodWork();
        return "Success!";
    }
}
