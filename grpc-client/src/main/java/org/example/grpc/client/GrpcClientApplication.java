package org.example.grpc.client;

import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloServiceGrpc;

@Slf4j
public class GrpcClientApplication {
    public static void main(String[] args) {
        val channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        val stub = HelloServiceGrpc.newBlockingStub(channel);

        val request = HelloRequest.newBuilder().setFirstName("done").setLastName("now").build();

        val response = stub.hello(request);
        log.info("{}", response);

        channel.shutdown();
    }
}
