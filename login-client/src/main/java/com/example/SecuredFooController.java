package com.example;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredFooController {

    @GetMapping(value = "/login/oauth2/code/auth-client-poc")
    public Map callNonSecured2(
        @RequestHeader Map headers,
        @RequestParam Map<String,String> allRequestParams
    ) {
//        System.out.println("codeValue:" + codeValue);
        System.out.println("headers:");
        headers.forEach((k, v) -> System.out.println("  " + k + " - " + v));
        System.out.println("query:");
        allRequestParams.forEach((k, v) -> System.out.println("  " + k + " - " + v));
        return Map.of("name", "non-secured");
    }


    @GetMapping(value = "/")
    public Map callNonSecured3(
        @RequestHeader Map headers,
        @RequestParam Map<String,String> allRequestParams
    ) {
        System.out.println("headers:");
        headers.forEach((k, v) -> System.out.println("  " + k + " - " + v));
        System.out.println("query:");
        allRequestParams.forEach((k, v) -> System.out.println("  " + k + " - " + v));
        return Map.of("name", "non-secured");
    }

}