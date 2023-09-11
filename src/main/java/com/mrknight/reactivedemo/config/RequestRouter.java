package com.mrknight.reactivedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
@ComponentScan("com.mrknight")
public class RequestRouter {
  @Bean
  public RouterFunction<ServerResponse> routes(RequestHandler requestHandler) {
    return RouterFunctions.route()
        .GET("/weatherstream", requestHandler::streamWeather)
        .GET("/test", sr -> ServerResponse.ok().bodyValue("TEST"))
        .build();

  }
}
