package org.example.grpc.server.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloResponse;
import org.example.grpc.HelloServiceGrpc;

@Slf4j
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("{}", request);

        val response = HelloResponse.newBuilder().setGreeting("hello").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
