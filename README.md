# DistributedTracingSample
Multiple microservices which use spring cloud sleuth for distributed tracing and traces are also sent to zipkin (needs to be started locally seperately).

ServiceA exposes a rest interface to the user.

ServiceB exposes a grpc interface which is used by ServiceA.

ServiceC exposes a grpc and rest interface which is used by ServiceB.

A proto file is added which is required to generate grpc client/server stubs to be used across the services. The same proto is used for communication between A to B and B to C. A gradle task is added to build an artefact which is include in the other microservices as a dependency.

