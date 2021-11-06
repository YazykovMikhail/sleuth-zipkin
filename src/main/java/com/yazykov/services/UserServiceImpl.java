package com.yazykov.services;

import brave.Span;
import brave.Tracer;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    java.util.logging.Logger logger = Logger.getLogger("UserServiceImpl");

    private final Tracer tracer;

    public UserServiceImpl(Tracer tracer) {
        this.tracer = tracer;
    }

    public String getUsers() {
        String user = "Mikhail";
        logger.info("Get " + user);
        return user;
    }

    public void manualCheckMethodWork() {
        logger.info("Starting");
        Span newSpan = tracer.nextSpan().name("new sleuth span").start();
        try {
            Tracer.SpanInScope span = tracer.withSpanInScope(newSpan.start());
            logger.info("Check (new span)");
        } finally {
            newSpan.finish();
        }
        logger.info("Finish");
    }
}
