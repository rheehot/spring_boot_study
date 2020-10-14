package com.yeonho.springinit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ArgumentsRunnerTest implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("fff");
        System.out.println("foo:" + args.containsOption("foo"));
        System.out.println("bar:" + args.containsOption("bar"));
    }
}
