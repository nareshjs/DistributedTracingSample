package com.nj.samples.tracing.serviceA.grpc.client;

import com.nj.samples.tracing.model.ImportProjectRequest;
import com.nj.samples.tracing.model.ImportProjectResponse;
import com.nj.samples.tracing.model.ProjectServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.instrument.grpc.SpringAwareManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ServiceBGrpcClient {

    @Value("${serviceb.server}")
    private String dataStorageServiceServer;

    /**
     * variable which will be populated with persistence server port.
     * information.
     */
    @Value("${serviceb.port}")
    private Integer dataStorageServicePort;

    private ProjectServiceGrpc.ProjectServiceBlockingStub projectServiceBlockingStub;

    //SpringAwareManagedChannelBuilder is required instead of regular ManagedChannelBuild
    @Autowired
    SpringAwareManagedChannelBuilder managedChannelBuilder;

    @PostConstruct
    public void init() {
        ManagedChannel managedChannel = managedChannelBuilder
                .forAddress(dataStorageServiceServer, dataStorageServicePort)
                .usePlaintext().build();

        projectServiceBlockingStub =
                ProjectServiceGrpc.newBlockingStub(managedChannel);
    }

    public String fetchFromServiceB() {
        ImportProjectResponse response = projectServiceBlockingStub.importProject(ImportProjectRequest.newBuilder().build());
        return response.getMessage();
    }
}
