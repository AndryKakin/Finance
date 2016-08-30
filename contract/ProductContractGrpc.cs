// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductContract.proto
#region Designer generated code

using System;
using System.Threading;
using System.Threading.Tasks;
using Grpc.Core;

namespace Google.Protobuf.products {
  public static class ProductService
  {
    static readonly string __ServiceName = "products.ProductService";

    static readonly Marshaller<global::Google.Protobuf.products.AddProductRequest> __Marshaller_AddProductRequest = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.products.AddProductRequest.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.products.ResultResponse> __Marshaller_ResultResponse = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.products.ResultResponse.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.products.Product> __Marshaller_Product = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.products.Product.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.products.RemoveProductRequest> __Marshaller_RemoveProductRequest = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.products.RemoveProductRequest.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.products.ProductsRequest> __Marshaller_ProductsRequest = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.products.ProductsRequest.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.products.ProductsResponse> __Marshaller_ProductsResponse = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.products.ProductsResponse.Parser.ParseFrom);

    static readonly Method<global::Google.Protobuf.products.AddProductRequest, global::Google.Protobuf.products.ResultResponse> __Method_Add = new Method<global::Google.Protobuf.products.AddProductRequest, global::Google.Protobuf.products.ResultResponse>(
        MethodType.Unary,
        __ServiceName,
        "Add",
        __Marshaller_AddProductRequest,
        __Marshaller_ResultResponse);

    static readonly Method<global::Google.Protobuf.products.Product, global::Google.Protobuf.products.ResultResponse> __Method_Update = new Method<global::Google.Protobuf.products.Product, global::Google.Protobuf.products.ResultResponse>(
        MethodType.Unary,
        __ServiceName,
        "Update",
        __Marshaller_Product,
        __Marshaller_ResultResponse);

    static readonly Method<global::Google.Protobuf.products.RemoveProductRequest, global::Google.Protobuf.products.ResultResponse> __Method_Delete = new Method<global::Google.Protobuf.products.RemoveProductRequest, global::Google.Protobuf.products.ResultResponse>(
        MethodType.Unary,
        __ServiceName,
        "Delete",
        __Marshaller_RemoveProductRequest,
        __Marshaller_ResultResponse);

    static readonly Method<global::Google.Protobuf.products.ProductsRequest, global::Google.Protobuf.products.ProductsResponse> __Method_GetAll = new Method<global::Google.Protobuf.products.ProductsRequest, global::Google.Protobuf.products.ProductsResponse>(
        MethodType.Unary,
        __ServiceName,
        "GetAll",
        __Marshaller_ProductsRequest,
        __Marshaller_ProductsResponse);

    // service descriptor
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.Services[0]; }
    }

    // client interface
    public interface IProductServiceClient
    {
      global::Google.Protobuf.products.ResultResponse Add(global::Google.Protobuf.products.AddProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.products.ResultResponse Add(global::Google.Protobuf.products.AddProductRequest request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> AddAsync(global::Google.Protobuf.products.AddProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> AddAsync(global::Google.Protobuf.products.AddProductRequest request, CallOptions options);
      global::Google.Protobuf.products.ResultResponse Update(global::Google.Protobuf.products.Product request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.products.ResultResponse Update(global::Google.Protobuf.products.Product request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> UpdateAsync(global::Google.Protobuf.products.Product request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> UpdateAsync(global::Google.Protobuf.products.Product request, CallOptions options);
      global::Google.Protobuf.products.ResultResponse Delete(global::Google.Protobuf.products.RemoveProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.products.ResultResponse Delete(global::Google.Protobuf.products.RemoveProductRequest request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> DeleteAsync(global::Google.Protobuf.products.RemoveProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> DeleteAsync(global::Google.Protobuf.products.RemoveProductRequest request, CallOptions options);
      global::Google.Protobuf.products.ProductsResponse GetAll(global::Google.Protobuf.products.ProductsRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.products.ProductsResponse GetAll(global::Google.Protobuf.products.ProductsRequest request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.products.ProductsResponse> GetAllAsync(global::Google.Protobuf.products.ProductsRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.products.ProductsResponse> GetAllAsync(global::Google.Protobuf.products.ProductsRequest request, CallOptions options);
    }

    // server-side interface
    public interface IProductService
    {
      Task<global::Google.Protobuf.products.ResultResponse> Add(global::Google.Protobuf.products.AddProductRequest request, ServerCallContext context);
      Task<global::Google.Protobuf.products.ResultResponse> Update(global::Google.Protobuf.products.Product request, ServerCallContext context);
      Task<global::Google.Protobuf.products.ResultResponse> Delete(global::Google.Protobuf.products.RemoveProductRequest request, ServerCallContext context);
      Task<global::Google.Protobuf.products.ProductsResponse> GetAll(global::Google.Protobuf.products.ProductsRequest request, ServerCallContext context);
    }

    // client stub
    public class ProductServiceClient : ClientBase, IProductServiceClient
    {
      public ProductServiceClient(Channel channel) : base(channel)
      {
      }
      public global::Google.Protobuf.products.ResultResponse Add(global::Google.Protobuf.products.AddProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Add, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ResultResponse Add(global::Google.Protobuf.products.AddProductRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_Add, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> AddAsync(global::Google.Protobuf.products.AddProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Add, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> AddAsync(global::Google.Protobuf.products.AddProductRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_Add, options);
        return Calls.AsyncUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ResultResponse Update(global::Google.Protobuf.products.Product request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Update, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ResultResponse Update(global::Google.Protobuf.products.Product request, CallOptions options)
      {
        var call = CreateCall(__Method_Update, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> UpdateAsync(global::Google.Protobuf.products.Product request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Update, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> UpdateAsync(global::Google.Protobuf.products.Product request, CallOptions options)
      {
        var call = CreateCall(__Method_Update, options);
        return Calls.AsyncUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ResultResponse Delete(global::Google.Protobuf.products.RemoveProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Delete, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ResultResponse Delete(global::Google.Protobuf.products.RemoveProductRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_Delete, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> DeleteAsync(global::Google.Protobuf.products.RemoveProductRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Delete, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ResultResponse> DeleteAsync(global::Google.Protobuf.products.RemoveProductRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_Delete, options);
        return Calls.AsyncUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ProductsResponse GetAll(global::Google.Protobuf.products.ProductsRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_GetAll, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.products.ProductsResponse GetAll(global::Google.Protobuf.products.ProductsRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_GetAll, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ProductsResponse> GetAllAsync(global::Google.Protobuf.products.ProductsRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_GetAll, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.products.ProductsResponse> GetAllAsync(global::Google.Protobuf.products.ProductsRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_GetAll, options);
        return Calls.AsyncUnaryCall(call, request);
      }
    }

    // creates service definition that can be registered with a server
    public static ServerServiceDefinition BindService(IProductService serviceImpl)
    {
      return ServerServiceDefinition.CreateBuilder(__ServiceName)
          .AddMethod(__Method_Add, serviceImpl.Add)
          .AddMethod(__Method_Update, serviceImpl.Update)
          .AddMethod(__Method_Delete, serviceImpl.Delete)
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
