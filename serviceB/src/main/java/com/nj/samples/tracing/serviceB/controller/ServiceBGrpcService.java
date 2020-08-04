package com.nj.samples.tracing.serviceB.controller;

import com.nj.samples.tracing.model.ImportProjectRequest;
import com.nj.samples.tracing.model.ImportProjectResponse;
import com.nj.samples.tracing.serviceB.client.grpc.ServiceCGrpcClient;
import com.nj.samples.tracing.serviceB.client.rest.ServiceCRestClient;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GRpcService
public class ServiceBGrpcService extends com.nj.samples.tracing.model.ProjectServiceGrpc.ProjectServiceImplBase {

    @Autowired
    private ServiceCGrpcClient serviceCGrpcClient;

    @Autowired
    private ServiceCRestClient serviceCRestClient;

    @Override
    public void importProject(ImportProjectRequest req, StreamObserver<ImportProjectResponse> responseObserver)
    {
        log.info("Processing GRPC rpc from Service A in Service B!");
        responseObserver.onNext(
                ImportProjectResponse.newBuilder()
                        .setMessage(serviceCGrpcClient.fetchFromServiceC() + serviceCRestClient.fetchFromServiceC())
                        .build());
        responseObserver.onCompleted();
    }
}
