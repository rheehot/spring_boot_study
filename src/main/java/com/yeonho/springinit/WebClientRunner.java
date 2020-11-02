package com.yeonho.springinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientRunner implements ApplicationRunner {

    @Autowired
    WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebClient webClient = builder.build();

        StopWatch sw = new StopWatch();
        sw.start();

        // TODO /hello
        Mono<String> helloMono = webClient.get().uri("http://localhost:8080/hello")
                .retrieve()
                .bodyToMono(String.class);
        helloMono.subscribe(s -> {
            System.out.println(s);

            if (sw.isRunning()) {
                sw.stop();
            }

            System.out.println(sw.prettyPrint());
            sw.start();
        });

        // TODO /world
        Mono<String> worldMono = webClient.get().uri("http://localhost:8080/world")
                .retrieve()
                .bodyToMono(String.class);
        worldMono.subscribe(s -> {
            System.out.println(s);

            if (sw.isRunning()) {
                sw.stop();
            }

            System.out.println(sw.prettyPrint());
            sw.start();
        });

        sw.stop();
        System.out.println(sw.prettyPrint());
    }

}
