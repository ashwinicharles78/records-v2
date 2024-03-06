package com.records.client.controller;

import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;


@RestController
public class HelloController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/api/hello")
    public String hello(Principal principal) {
        return "Hello " +principal.getName()+", This is a test!!";
    }

    @GetMapping("/api/users")
    public JSONArray users(
            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
                    OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/records")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(JSONArray.class)
                .block();
    }
}
