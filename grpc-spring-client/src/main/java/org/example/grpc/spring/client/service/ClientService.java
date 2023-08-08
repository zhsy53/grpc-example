package org.example.grpc.spring.client.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloServiceGrpc.HelloServiceBlockingStub;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @GrpcClient("local-grpc-server")
    private HelloServiceBlockingStub helloServiceStub;

    public String test(HelloRequest request) {
        return helloServiceStub.hello(request).getGreeting();
    }
}
