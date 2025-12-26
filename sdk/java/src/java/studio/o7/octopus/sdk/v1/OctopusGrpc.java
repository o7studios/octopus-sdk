package studio.o7.octopus.sdk.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class OctopusGrpc {

  private OctopusGrpc() {}

  public static final java.lang.String SERVICE_NAME = "octopus_sdk.v1.Octopus";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.GetRequest,
      studio.o7.octopus.sdk.v1.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = studio.o7.octopus.sdk.v1.GetRequest.class,
      responseType = studio.o7.octopus.sdk.v1.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.GetRequest,
      studio.o7.octopus.sdk.v1.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.GetRequest, studio.o7.octopus.sdk.v1.GetResponse> getGetMethod;
    if ((getGetMethod = OctopusGrpc.getGetMethod) == null) {
      synchronized (OctopusGrpc.class) {
        if ((getGetMethod = OctopusGrpc.getGetMethod) == null) {
          OctopusGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<studio.o7.octopus.sdk.v1.GetRequest, studio.o7.octopus.sdk.v1.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.GetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OctopusMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.Object,
      com.google.protobuf.Empty> getWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Write",
      requestType = studio.o7.octopus.sdk.v1.Object.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.Object,
      com.google.protobuf.Empty> getWriteMethod() {
    io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.Object, com.google.protobuf.Empty> getWriteMethod;
    if ((getWriteMethod = OctopusGrpc.getWriteMethod) == null) {
      synchronized (OctopusGrpc.class) {
        if ((getWriteMethod = OctopusGrpc.getWriteMethod) == null) {
          OctopusGrpc.getWriteMethod = getWriteMethod =
              io.grpc.MethodDescriptor.<studio.o7.octopus.sdk.v1.Object, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Write"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.Object.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OctopusMethodDescriptorSupplier("Write"))
              .build();
        }
      }
    }
    return getWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.Object,
      studio.o7.octopus.sdk.v1.Entry> getCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Call",
      requestType = studio.o7.octopus.sdk.v1.Object.class,
      responseType = studio.o7.octopus.sdk.v1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.Object,
      studio.o7.octopus.sdk.v1.Entry> getCallMethod() {
    io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.Object, studio.o7.octopus.sdk.v1.Entry> getCallMethod;
    if ((getCallMethod = OctopusGrpc.getCallMethod) == null) {
      synchronized (OctopusGrpc.class) {
        if ((getCallMethod = OctopusGrpc.getCallMethod) == null) {
          OctopusGrpc.getCallMethod = getCallMethod =
              io.grpc.MethodDescriptor.<studio.o7.octopus.sdk.v1.Object, studio.o7.octopus.sdk.v1.Entry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.Object.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.Entry.getDefaultInstance()))
              .setSchemaDescriptor(new OctopusMethodDescriptorSupplier("Call"))
              .build();
        }
      }
    }
    return getCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.ListenMessage,
      studio.o7.octopus.sdk.v1.EventCall> getListenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Listen",
      requestType = studio.o7.octopus.sdk.v1.ListenMessage.class,
      responseType = studio.o7.octopus.sdk.v1.EventCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.ListenMessage,
      studio.o7.octopus.sdk.v1.EventCall> getListenMethod() {
    io.grpc.MethodDescriptor<studio.o7.octopus.sdk.v1.ListenMessage, studio.o7.octopus.sdk.v1.EventCall> getListenMethod;
    if ((getListenMethod = OctopusGrpc.getListenMethod) == null) {
      synchronized (OctopusGrpc.class) {
        if ((getListenMethod = OctopusGrpc.getListenMethod) == null) {
          OctopusGrpc.getListenMethod = getListenMethod =
              io.grpc.MethodDescriptor.<studio.o7.octopus.sdk.v1.ListenMessage, studio.o7.octopus.sdk.v1.EventCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Listen"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.ListenMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.o7.octopus.sdk.v1.EventCall.getDefaultInstance()))
              .setSchemaDescriptor(new OctopusMethodDescriptorSupplier("Listen"))
              .build();
        }
      }
    }
    return getListenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OctopusStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OctopusStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OctopusStub>() {
        @java.lang.Override
        public OctopusStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OctopusStub(channel, callOptions);
        }
      };
    return OctopusStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static OctopusBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OctopusBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OctopusBlockingV2Stub>() {
        @java.lang.Override
        public OctopusBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OctopusBlockingV2Stub(channel, callOptions);
        }
      };
    return OctopusBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OctopusBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OctopusBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OctopusBlockingStub>() {
        @java.lang.Override
        public OctopusBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OctopusBlockingStub(channel, callOptions);
        }
      };
    return OctopusBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OctopusFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OctopusFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OctopusFutureStub>() {
        @java.lang.Override
        public OctopusFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OctopusFutureStub(channel, callOptions);
        }
      };
    return OctopusFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     **
     * Retrieves existing entries from the database matching a
     * key pattern. Can optionally include expired objects and
     * filter by revision creation time.
     * </pre>
     */
    default void get(studio.o7.octopus.sdk.v1.GetRequest request,
        io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.GetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database.
     * </pre>
     */
    default void write(studio.o7.octopus.sdk.v1.Object request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database
     * and returns the stored version, including the revision
     * and ID.
     * </pre>
     */
    default void call(studio.o7.octopus.sdk.v1.Object request,
        io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCallMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     * Bidirectional stream for real-time updates. Clients
     * register for key-patterns (ListenRegister) and receive
     * events (EventCall).
     * Step 1: Registration
     * The client must first send a `ListenRegister` message
     * to specify which key-pattern to listen to.
     * Step 2: Event Reception
     * After registration, the server sends `EventCall` messages
     * for objects matching the registered key-pattern.
     * Rules:
     * 1. Only one registration per stream is allowed.
     * 2. After registration, the server sends `EventCall` messages
     * which have to be sent back for acknowledgement
     * (and possibly modification).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.ListenMessage> listen(
        io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.EventCall> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getListenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Octopus.
   */
  public static abstract class OctopusImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OctopusGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Octopus.
   */
  public static final class OctopusStub
      extends io.grpc.stub.AbstractAsyncStub<OctopusStub> {
    private OctopusStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OctopusStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OctopusStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Retrieves existing entries from the database matching a
     * key pattern. Can optionally include expired objects and
     * filter by revision creation time.
     * </pre>
     */
    public void get(studio.o7.octopus.sdk.v1.GetRequest request,
        io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.GetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database.
     * </pre>
     */
    public void write(studio.o7.octopus.sdk.v1.Object request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database
     * and returns the stored version, including the revision
     * and ID.
     * </pre>
     */
    public void call(studio.o7.octopus.sdk.v1.Object request,
        io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Bidirectional stream for real-time updates. Clients
     * register for key-patterns (ListenRegister) and receive
     * events (EventCall).
     * Step 1: Registration
     * The client must first send a `ListenRegister` message
     * to specify which key-pattern to listen to.
     * Step 2: Event Reception
     * After registration, the server sends `EventCall` messages
     * for objects matching the registered key-pattern.
     * Rules:
     * 1. Only one registration per stream is allowed.
     * 2. After registration, the server sends `EventCall` messages
     * which have to be sent back for acknowledgement
     * (and possibly modification).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.ListenMessage> listen(
        io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.EventCall> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getListenMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Octopus.
   */
  public static final class OctopusBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OctopusBlockingV2Stub> {
    private OctopusBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OctopusBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OctopusBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Retrieves existing entries from the database matching a
     * key pattern. Can optionally include expired objects and
     * filter by revision creation time.
     * </pre>
     */
    public studio.o7.octopus.sdk.v1.GetResponse get(studio.o7.octopus.sdk.v1.GetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database.
     * </pre>
     */
    public com.google.protobuf.Empty write(studio.o7.octopus.sdk.v1.Object request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getWriteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database
     * and returns the stored version, including the revision
     * and ID.
     * </pre>
     */
    public studio.o7.octopus.sdk.v1.Entry call(studio.o7.octopus.sdk.v1.Object request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Bidirectional stream for real-time updates. Clients
     * register for key-patterns (ListenRegister) and receive
     * events (EventCall).
     * Step 1: Registration
     * The client must first send a `ListenRegister` message
     * to specify which key-pattern to listen to.
     * Step 2: Event Reception
     * After registration, the server sends `EventCall` messages
     * for objects matching the registered key-pattern.
     * Rules:
     * 1. Only one registration per stream is allowed.
     * 2. After registration, the server sends `EventCall` messages
     * which have to be sent back for acknowledgement
     * (and possibly modification).
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<studio.o7.octopus.sdk.v1.ListenMessage, studio.o7.octopus.sdk.v1.EventCall>
        listen() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getListenMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Octopus.
   */
  public static final class OctopusBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OctopusBlockingStub> {
    private OctopusBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OctopusBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OctopusBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Retrieves existing entries from the database matching a
     * key pattern. Can optionally include expired objects and
     * filter by revision creation time.
     * </pre>
     */
    public studio.o7.octopus.sdk.v1.GetResponse get(studio.o7.octopus.sdk.v1.GetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database.
     * </pre>
     */
    public com.google.protobuf.Empty write(studio.o7.octopus.sdk.v1.Object request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database
     * and returns the stored version, including the revision
     * and ID.
     * </pre>
     */
    public studio.o7.octopus.sdk.v1.Entry call(studio.o7.octopus.sdk.v1.Object request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCallMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Octopus.
   */
  public static final class OctopusFutureStub
      extends io.grpc.stub.AbstractFutureStub<OctopusFutureStub> {
    private OctopusFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OctopusFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OctopusFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Retrieves existing entries from the database matching a
     * key pattern. Can optionally include expired objects and
     * filter by revision creation time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<studio.o7.octopus.sdk.v1.GetResponse> get(
        studio.o7.octopus.sdk.v1.GetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> write(
        studio.o7.octopus.sdk.v1.Object request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Stores an object on key with new revision in the database
     * and returns the stored version, including the revision
     * and ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<studio.o7.octopus.sdk.v1.Entry> call(
        studio.o7.octopus.sdk.v1.Object request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_WRITE = 1;
  private static final int METHODID_CALL = 2;
  private static final int METHODID_LISTEN = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((studio.o7.octopus.sdk.v1.GetRequest) request,
              (io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.GetResponse>) responseObserver);
          break;
        case METHODID_WRITE:
          serviceImpl.write((studio.o7.octopus.sdk.v1.Object) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CALL:
          serviceImpl.call((studio.o7.octopus.sdk.v1.Object) request,
              (io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.Entry>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LISTEN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.listen(
              (io.grpc.stub.StreamObserver<studio.o7.octopus.sdk.v1.EventCall>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              studio.o7.octopus.sdk.v1.GetRequest,
              studio.o7.octopus.sdk.v1.GetResponse>(
                service, METHODID_GET)))
        .addMethod(
          getWriteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              studio.o7.octopus.sdk.v1.Object,
              com.google.protobuf.Empty>(
                service, METHODID_WRITE)))
        .addMethod(
          getCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              studio.o7.octopus.sdk.v1.Object,
              studio.o7.octopus.sdk.v1.Entry>(
                service, METHODID_CALL)))
        .addMethod(
          getListenMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              studio.o7.octopus.sdk.v1.ListenMessage,
              studio.o7.octopus.sdk.v1.EventCall>(
                service, METHODID_LISTEN)))
        .build();
  }

  private static abstract class OctopusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OctopusBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return studio.o7.octopus.sdk.v1.Api.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Octopus");
    }
  }

  private static final class OctopusFileDescriptorSupplier
      extends OctopusBaseDescriptorSupplier {
    OctopusFileDescriptorSupplier() {}
  }

  private static final class OctopusMethodDescriptorSupplier
      extends OctopusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OctopusMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OctopusGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OctopusFileDescriptorSupplier())
              .addMethod(getGetMethod())
              .addMethod(getWriteMethod())
              .addMethod(getCallMethod())
              .addMethod(getListenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
