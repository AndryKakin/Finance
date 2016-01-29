// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CurrencyContract.proto
#region Designer generated code

using System;
using System.Threading;
using System.Threading.Tasks;
using Grpc.Core;

namespace Google.Protobuf.services {
  public static class ProductService
  {
    static readonly string __ServiceName = "services.ProductService";

    static readonly Marshaller<global::Google.Protobuf.services.GetAllRequest> __Marshaller_GetAllRequest = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.services.GetAllRequest.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.services.CurrenciesResponse> __Marshaller_CurrenciesResponse = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.services.CurrenciesResponse.Parser.ParseFrom);

    static readonly Method<global::Google.Protobuf.services.GetAllRequest, global::Google.Protobuf.services.CurrenciesResponse> __Method_GetAll = new Method<global::Google.Protobuf.services.GetAllRequest, global::Google.Protobuf.services.CurrenciesResponse>(
        MethodType.Unary,
        __ServiceName,
        "GetAll",
        __Marshaller_GetAllRequest,
        __Marshaller_CurrenciesResponse);

    // service descriptor
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::Google.Protobuf.services.CurrencyContract.Descriptor.Services[0]; }
    }

    // client interface
    public interface IProductServiceClient
    {
      global::Google.Protobuf.services.CurrenciesResponse GetAll(global::Google.Protobuf.services.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.services.CurrenciesResponse GetAll(global::Google.Protobuf.services.GetAllRequest request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.services.CurrenciesResponse> GetAllAsync(global::Google.Protobuf.services.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.services.CurrenciesResponse> GetAllAsync(global::Google.Protobuf.services.GetAllRequest request, CallOptions options);
    }

    // server-side interface
    public interface IProductService
    {
      Task<global::Google.Protobuf.services.CurrenciesResponse> GetAll(global::Google.Protobuf.services.GetAllRequest request, ServerCallContext context);
    }

    // client stub
    public class ProductServiceClient : ClientBase, IProductServiceClient
    {
      public ProductServiceClient(Channel channel) : base(channel)
      {
      }
      public global::Google.Protobuf.services.CurrenciesResponse GetAll(global::Google.Protobuf.services.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_GetAll, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.services.CurrenciesResponse GetAll(global::Google.Protobuf.services.GetAllRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_GetAll, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.services.CurrenciesResponse> GetAllAsync(global::Google.Protobuf.services.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_GetAll, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.services.CurrenciesResponse> GetAllAsync(global::Google.Protobuf.services.GetAllRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_GetAll, options);
        return Calls.AsyncUnaryCall(call, request);
      }
    }

    // creates service definition that can be registered with a server
    public static ServerServiceDefinition BindService(IProductService serviceImpl)
    {
      return ServerServiceDefinition.CreateBuilder(__ServiceName)
          .AddMethod(__Method_GetAll, serviceImpl.GetAll).Build();
    }

    // creates a new client
    public static ProductServiceClient NewClient(Channel channel)
    {
      return new ProductServiceClient(channel);
    }

  }
}
#endregion
