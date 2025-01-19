package org.web.gatewayservice.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web.domainservice.grpc.DomainServiceGrpc;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("domain-service", 8083)
                .usePlaintext()
                .build();
    }

    @Bean
    public DomainServiceGrpc.DomainServiceBlockingStub domainServiceStub(ManagedChannel channel) {
        return DomainServiceGrpc.newBlockingStub(channel);
    }
}