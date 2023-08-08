package org.example.grpc.server;

import io.grpc.ServerBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.example.grpc.server.service.HelloService;

@Slf4j
public class GrpcServerApplication {
    @SneakyThrows
    public static void main(String[] args) {
        val server = ServerBuilder.forPort(8080)
          .addService(new HelloService())
          .build()
          .start();

        log.info("ServerApplication running...");

        server.awaitTermination();
    }
}
