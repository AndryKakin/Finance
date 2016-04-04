// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PurchaseContract.proto
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
namespace Google.Protobuf.purchases {

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public static partial class PurchaseContract {

    #region Descriptor
    public static pbr::FileDescriptor Descriptor {
      get { return descriptor; }
    }
    private static pbr::FileDescriptor descriptor;

    static PurchaseContract() {
      byte[] descriptorData = global::System.Convert.FromBase64String(
          string.Concat(
            "ChZQdXJjaGFzZUNvbnRyYWN0LnByb3RvEglwdXJjaGFzZXMiKgoIUHVyY2hh", 
            "c2USCgoCSWQYASABKAMSEgoKRmtDdXJyZW5jeRgCIAEoAyI7ChFQdXJjaGFz", 
            "ZXNSZXNwb25zZRImCglQdXJjaGFzZXMYASADKAsyEy5wdXJjaGFzZXMuUHVy", 
            "Y2hhc2UiMwoOUmVzdWx0UmVzcG9uc2USIQoGU3RhdHVzGAEgASgOMhEucHVy", 
            "Y2hhc2VzLlN0YXR1cyIPCg1HZXRBbGxSZXF1ZXN0KhwKBlN0YXR1cxIGCgJP", 
            "axAAEgoKBkZhaWxlZBABMoMCCgxQcmljZVNlcnZpY2USNwoDQWRkEhMucHVy", 
            "Y2hhc2VzLlB1cmNoYXNlGhkucHVyY2hhc2VzLlJlc3VsdFJlc3BvbnNlIgAS", 
            "OgoGVXBkYXRlEhMucHVyY2hhc2VzLlB1cmNoYXNlGhkucHVyY2hhc2VzLlJl", 
            "c3VsdFJlc3BvbnNlIgASOgoGRGVsZXRlEhMucHVyY2hhc2VzLlB1cmNoYXNl", 
            "GhkucHVyY2hhc2VzLlJlc3VsdFJlc3BvbnNlIgASQgoGR2V0QWxsEhgucHVy", 
            "Y2hhc2VzLkdldEFsbFJlcXVlc3QaHC5wdXJjaGFzZXMuUHVyY2hhc2VzUmVz", 
            "cG9uc2UiAEI/ChBpby5ncnBjLmV4YW1wbGVzWglwdXJjaGFzZXOiAgNITFeq", 
            "AhlHb29nbGUuUHJvdG9idWYucHVyY2hhc2VzYgZwcm90bzM="));
      descriptor = pbr::FileDescriptor.InternalBuildGeneratedFileFrom(descriptorData,
          new pbr::FileDescriptor[] { },
          new pbr::GeneratedCodeInfo(new[] {typeof(global::Google.Protobuf.purchases.Status), }, new pbr::GeneratedCodeInfo[] {
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.purchases.Purchase), new[]{ "Id", "FkCurrency" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.purchases.PurchasesResponse), new[]{ "Purchases" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.purchases.ResultResponse), new[]{ "Status" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.purchases.GetAllRequest), null, null, null, null)
          }));
    }
    #endregion

  }
  #region Enums
  public enum Status {
    Ok = 0,
    Failed = 1,
  }

  #endregion

  #region Messages
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class Purchase : pb::IMessage<Purchase> {
    private static readonly pb::MessageParser<Purchase> _parser = new pb::MessageParser<Purchase>(() => new Purchase());
    public static pb::MessageParser<Purchase> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.purchases.PurchaseContract.Descriptor.MessageTypes[0]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public Purchase() {
      OnConstruction();
    }

    partial void OnConstruction();

    public Purchase(Purchase other) : this() {
      id_ = other.id_;
      fkCurrency_ = other.fkCurrency_;
    }

    public Purchase Clone() {
      return new Purchase(this);
    }

    public const int IdFieldNumber = 1;
    private long id_;
    public long Id {
      get { return id_; }
      set {
        id_ = value;
      }
    }

    public const int FkCurrencyFieldNumber = 2;
    private long fkCurrency_;
    public long FkCurrency {
      get { return fkCurrency_; }
      set {
        fkCurrency_ = value;
      }
    }

    public override bool Equals(object other) {
      return Equals(other as Purchase);
    }

    public bool Equals(Purchase other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Id != other.Id) return false;
      if (FkCurrency != other.FkCurrency) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      if (Id != 0L) hash ^= Id.GetHashCode();
      if (FkCurrency != 0L) hash ^= FkCurrency.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      if (Id != 0L) {
        output.WriteRawTag(8);
        output.WriteInt64(Id);
      }
      if (FkCurrency != 0L) {
        output.WriteRawTag(16);
        output.WriteInt64(FkCurrency);
      }
    }

    public int CalculateSize() {
      int size = 0;
      if (Id != 0L) {
        size += 1 + pb::CodedOutputStream.ComputeInt64Size(Id);
      }
      if (FkCurrency != 0L) {
        size += 1 + pb::CodedOutputStream.ComputeInt64Size(FkCurrency);
      }
      return size;
    }

    public void MergeFrom(Purchase other) {
      if (other == null) {
        return;
      }
      if (other.Id != 0L) {
        Id = other.Id;
      }
      if (other.FkCurrency != 0L) {
        FkCurrency = other.FkCurrency;
      }
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 8: {
            Id = input.ReadInt64();
            break;
          }
          case 16: {
            FkCurrency = input.ReadInt64();
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class PurchasesResponse : pb::IMessage<PurchasesResponse> {
    private static readonly pb::MessageParser<PurchasesResponse> _parser = new pb::MessageParser<PurchasesResponse>(() => new PurchasesResponse());
    public static pb::MessageParser<PurchasesResponse> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.purchases.PurchaseContract.Descriptor.MessageTypes[1]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public PurchasesResponse() {
      OnConstruction();
    }

    partial void OnConstruction();

    public PurchasesResponse(PurchasesResponse other) : this() {
      purchases_ = other.purchases_.Clone();
    }

    public PurchasesResponse Clone() {
      return new PurchasesResponse(this);
    }

    public const int PurchasesFieldNumber = 1;
    private static readonly pb::FieldCodec<global::Google.Protobuf.purchases.Purchase> _repeated_purchases_codec
        = pb::FieldCodec.ForMessage(10, global::Google.Protobuf.purchases.Purchase.Parser);
    private readonly pbc::RepeatedField<global::Google.Protobuf.purchases.Purchase> purchases_ = new pbc::RepeatedField<global::Google.Protobuf.purchases.Purchase>();
    public pbc::RepeatedField<global::Google.Protobuf.purchases.Purchase> Purchases {
      get { return purchases_; }
    }

    public override bool Equals(object other) {
      return Equals(other as PurchasesResponse);
    }

    public bool Equals(PurchasesResponse other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if(!purchases_.Equals(other.purchases_)) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      hash ^= purchases_.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      purchases_.WriteTo(output, _repeated_purchases_codec);
    }

    public int CalculateSize() {
      int size = 0;
      size += purchases_.CalculateSize(_repeated_purchases_codec);
      return size;
    }

    public void MergeFrom(PurchasesResponse other) {
      if (other == null) {
        return;
      }
      purchases_.Add(other.purchases_);
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 10: {
            purchases_.AddEntriesFrom(input, _repeated_purchases_codec);
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class ResultResponse : pb::IMessage<ResultResponse> {
    private static readonly pb::MessageParser<ResultResponse> _parser = new pb::MessageParser<ResultResponse>(() => new ResultResponse());
    public static pb::MessageParser<ResultResponse> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.purchases.PurchaseContract.Descriptor.MessageTypes[2]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public ResultResponse() {
      OnConstruction();
    }

    partial void OnConstruction();

    public ResultResponse(ResultResponse other) : this() {
      status_ = other.status_;
    }

    public ResultResponse Clone() {
      return new ResultResponse(this);
    }

    public const int StatusFieldNumber = 1;
    private global::Google.Protobuf.purchases.Status status_ = global::Google.Protobuf.purchases.Status.Ok;
    public global::Google.Protobuf.purchases.Status Status {
      get { return status_; }
      set {
        status_ = value;
      }
    }

    public override bool Equals(object other) {
      return Equals(other as ResultResponse);
    }

    public bool Equals(ResultResponse other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Status != other.Status) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      if (Status != global::Google.Protobuf.purchases.Status.Ok) hash ^= Status.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      if (Status != global::Google.Protobuf.purchases.Status.Ok) {
        output.WriteRawTag(8);
        output.WriteEnum((int) Status);
      }
    }

    public int CalculateSize() {
      int size = 0;
      if (Status != global::Google.Protobuf.purchases.Status.Ok) {
        size += 1 + pb::CodedOutputStream.ComputeEnumSize((int) Status);
      }
      return size;
    }

    public void MergeFrom(ResultResponse other) {
      if (other == null) {
        return;
      }
      if (other.Status != global::Google.Protobuf.purchases.Status.Ok) {
        Status = other.Status;
      }
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 8: {
            status_ = (global::Google.Protobuf.purchases.Status) input.ReadEnum();
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class GetAllRequest : pb::IMessage<GetAllRequest> {
    private static readonly pb::MessageParser<GetAllRequest> _parser = new pb::MessageParser<GetAllRequest>(() => new GetAllRequest());
    public static pb::MessageParser<GetAllRequest> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.purchases.PurchaseContract.Descriptor.MessageTypes[3]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public GetAllRequest() {
      OnConstruction();
    }

    partial void OnConstruction();

    public GetAllRequest(GetAllRequest other) : this() {
    }

    public GetAllRequest Clone() {
      return new GetAllRequest(this);
    }

    public override bool Equals(object other) {
      return Equals(other as GetAllRequest);
    }

    public bool Equals(GetAllRequest other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
    }

    public int CalculateSize() {
      int size = 0;
      return size;
    }

    public void MergeFrom(GetAllRequest other) {
      if (other == null) {
        return;
      }
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
        }
      }
    }

  }

  #endregion

}

#endregion Designer generated code
