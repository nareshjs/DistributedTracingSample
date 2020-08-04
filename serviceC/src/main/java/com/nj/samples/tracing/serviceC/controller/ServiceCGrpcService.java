package com.nj.samples.tracing.serviceC.controller;

import com.nj.samples.tracing.model.ImportProjectRequest;
import com.nj.samples.tracing.model.ImportProjectResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
public class ServiceCGrpcService extends com.nj.samples.tracing.model.ProjectServiceGrpc.ProjectServiceImplBase {

    @Override
    public void importProject(ImportProjectRequest req, StreamObserver<ImportProjectResponse> responseObserver)
    {
        log.info("Processing GRPC rpc from Service B in Service C!");
        responseObserver.onNext(
                ImportProjectResponse.newBuilder().
                        setMessage(true ? "SUCCESS" : "FAILED").build());
        responseObserver.onCompleted();
    }
}
