package com.tickets.task;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask
{
    @PostConstruct
    private void init()
    {
        System.out.println("Test task init");
    }
    
    @Scheduled(fixedRate=500)
    public void doSomething() {
        System.out.println("aaaaaaaaaaaa");
    }
}
