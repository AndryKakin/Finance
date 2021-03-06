// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PurchaseContract.proto
#region Designer generated code

using System;
using System.Threading;
using System.Threading.Tasks;
using Grpc.Core;

namespace Google.Protobuf.purchases {
  public static class PurchaseService
  {
    static readonly string __ServiceName = "purchases.PurchaseService";

    static readonly Marshaller<global::Google.Protobuf.purchases.Purchase> __Marshaller_Purchase = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.purchases.Purchase.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.purchases.ResultResponse> __Marshaller_ResultResponse = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.purchases.ResultResponse.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.purchases.GetAllRequest> __Marshaller_GetAllRequest = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.purchases.GetAllRequest.Parser.ParseFrom);
    static readonly Marshaller<global::Google.Protobuf.purchases.PurchasesResponse> __Marshaller_PurchasesResponse = Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.purchases.PurchasesResponse.Parser.ParseFrom);

    static readonly Method<global::Google.Protobuf.purchases.Purchase, global::Google.Protobuf.purchases.ResultResponse> __Method_Add = new Method<global::Google.Protobuf.purchases.Purchase, global::Google.Protobuf.purchases.ResultResponse>(
        MethodType.Unary,
        __ServiceName,
        "Add",
        __Marshaller_Purchase,
        __Marshaller_ResultResponse);

    static readonly Method<global::Google.Protobuf.purchases.Purchase, global::Google.Protobuf.purchases.ResultResponse> __Method_Update = new Method<global::Google.Protobuf.purchases.Purchase, global::Google.Protobuf.purchases.ResultResponse>(
        MethodType.Unary,
        __ServiceName,
        "Update",
        __Marshaller_Purchase,
        __Marshaller_ResultResponse);

    static readonly Method<global::Google.Protobuf.purchases.Purchase, global::Google.Protobuf.purchases.ResultResponse> __Method_Delete = new Method<global::Google.Protobuf.purchases.Purchase, global::Google.Protobuf.purchases.ResultResponse>(
        MethodType.Unary,
        __ServiceName,
        "Delete",
        __Marshaller_Purchase,
        __Marshaller_ResultResponse);

    static readonly Method<global::Google.Protobuf.purchases.GetAllRequest, global::Google.Protobuf.purchases.PurchasesResponse> __Method_GetAll = new Method<global::Google.Protobuf.purchases.GetAllRequest, global::Google.Protobuf.purchases.PurchasesResponse>(
        MethodType.Unary,
        __ServiceName,
        "GetAll",
        __Marshaller_GetAllRequest,
        __Marshaller_PurchasesResponse);

    // service descriptor
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::Google.Protobuf.purchases.PurchaseContract.Descriptor.Services[0]; }
    }

    // client interface
    public interface IPurchaseServiceClient
    {
      global::Google.Protobuf.purchases.ResultResponse Add(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.purchases.ResultResponse Add(global::Google.Protobuf.purchases.Purchase request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> AddAsync(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> AddAsync(global::Google.Protobuf.purchases.Purchase request, CallOptions options);
      global::Google.Protobuf.purchases.ResultResponse Update(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.purchases.ResultResponse Update(global::Google.Protobuf.purchases.Purchase request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> UpdateAsync(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> UpdateAsync(global::Google.Protobuf.purchases.Purchase request, CallOptions options);
      global::Google.Protobuf.purchases.ResultResponse Delete(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.purchases.ResultResponse Delete(global::Google.Protobuf.purchases.Purchase request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> DeleteAsync(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> DeleteAsync(global::Google.Protobuf.purchases.Purchase request, CallOptions options);
      global::Google.Protobuf.purchases.PurchasesResponse GetAll(global::Google.Protobuf.purchases.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      global::Google.Protobuf.purchases.PurchasesResponse GetAll(global::Google.Protobuf.purchases.GetAllRequest request, CallOptions options);
      AsyncUnaryCall<global::Google.Protobuf.purchases.PurchasesResponse> GetAllAsync(global::Google.Protobuf.purchases.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken));
      AsyncUnaryCall<global::Google.Protobuf.purchases.PurchasesResponse> GetAllAsync(global::Google.Protobuf.purchases.GetAllRequest request, CallOptions options);
    }

    // server-side interface
    public interface IPurchaseService
    {
      Task<global::Google.Protobuf.purchases.ResultResponse> Add(global::Google.Protobuf.purchases.Purchase request, ServerCallContext context);
      Task<global::Google.Protobuf.purchases.ResultResponse> Update(global::Google.Protobuf.purchases.Purchase request, ServerCallContext context);
      Task<global::Google.Protobuf.purchases.ResultResponse> Delete(global::Google.Protobuf.purchases.Purchase request, ServerCallContext context);
      Task<global::Google.Protobuf.purchases.PurchasesResponse> GetAll(global::Google.Protobuf.purchases.GetAllRequest request, ServerCallContext context);
    }

    // client stub
    public class PurchaseServiceClient : ClientBase, IPurchaseServiceClient
    {
      public PurchaseServiceClient(Channel channel) : base(channel)
      {
      }
      public global::Google.Protobuf.purchases.ResultResponse Add(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Add, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.ResultResponse Add(global::Google.Protobuf.purchases.Purchase request, CallOptions options)
      {
        var call = CreateCall(__Method_Add, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> AddAsync(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Add, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> AddAsync(global::Google.Protobuf.purchases.Purchase request, CallOptions options)
      {
        var call = CreateCall(__Method_Add, options);
        return Calls.AsyncUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.ResultResponse Update(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Update, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.ResultResponse Update(global::Google.Protobuf.purchases.Purchase request, CallOptions options)
      {
        var call = CreateCall(__Method_Update, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> UpdateAsync(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Update, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> UpdateAsync(global::Google.Protobuf.purchases.Purchase request, CallOptions options)
      {
        var call = CreateCall(__Method_Update, options);
        return Calls.AsyncUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.ResultResponse Delete(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Delete, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.ResultResponse Delete(global::Google.Protobuf.purchases.Purchase request, CallOptions options)
      {
        var call = CreateCall(__Method_Delete, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> DeleteAsync(global::Google.Protobuf.purchases.Purchase request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_Delete, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.ResultResponse> DeleteAsync(global::Google.Protobuf.purchases.Purchase request, CallOptions options)
      {
        var call = CreateCall(__Method_Delete, options);
        return Calls.AsyncUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.PurchasesResponse GetAll(global::Google.Protobuf.purchases.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_GetAll, new CallOptions(headers, deadline, cancellationToken));
        return Calls.BlockingUnaryCall(call, request);
      }
      public global::Google.Protobuf.purchases.PurchasesResponse GetAll(global::Google.Protobuf.purchases.GetAllRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_GetAll, options);
        return Calls.BlockingUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.PurchasesResponse> GetAllAsync(global::Google.Protobuf.purchases.GetAllRequest request, Metadata headers = null, DateTime? deadline = null, CancellationToken cancellationToken = default(CancellationToken))
      {
        var call = CreateCall(__Method_GetAll, new CallOptions(headers, deadline, cancellationToken));
        return Calls.AsyncUnaryCall(call, request);
      }
      public AsyncUnaryCall<global::Google.Protobuf.purchases.PurchasesResponse> GetAllAsync(global::Google.Protobuf.purchases.GetAllRequest request, CallOptions options)
      {
        var call = CreateCall(__Method_GetAll, options);
        return Calls.AsyncUnaryCall(call, request);
      }
    }

    // creates service definition that can be registered with a server
    public static ServerServiceDefinition BindService(IPurchaseService serviceImpl)
    {
      return ServerServiceDefinition.CreateBuilder(__ServiceName)
          .AddMethod(__Method_Add, serviceImpl.Add)
          .AddMethod(__Method_Update, serviceImpl.Update)
          .AddMethod(__Method_Delete, serviceImpl.Delete)
          .AddMethod(__Method_GetAll, serviceImpl.GetAll).Build();
    }

    // creates a new client
    public static PurchaseServiceClient NewClient(Channel channel)
    {
      return new PurchaseServiceClient(channel);
    }

  }
}
#endregion
