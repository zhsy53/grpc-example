package org.example.grpc.spring.server.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloResponse;
import org.example.grpc.HelloServiceGrpc;

@GrpcService
@Slf4j
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("{}", request);

        val response = HelloResponse.newBuilder().setGreeting("hello " + request.getFirstName() + "-" + request.getLastName()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
