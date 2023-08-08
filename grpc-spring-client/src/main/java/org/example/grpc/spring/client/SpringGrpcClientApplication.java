package org.example.grpc.spring.client;

import lombok.val;
import org.example.grpc.HelloRequest;
import org.example.grpc.spring.client.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://github.com/yidongnan/grpc-spring-boot-starter
@SpringBootApplication
public class SpringGrpcClientApplication {
    public static void main(String[] args) {
        val context = SpringApplication.run(SpringGrpcClientApplication.class, args);
        val clientService = context.getBean(ClientService.class);
        val request = HelloRequest.newBuilder().setFirstName("first").setLastName("last").build();
        val response = clientService.test(request);
        System.out.println(response);
    }
}
