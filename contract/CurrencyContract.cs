// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CurrencyContract.proto
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
namespace Google.Protobuf.currencies {

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public static partial class CurrencyContract {

    #region Descriptor
    public static pbr::FileDescriptor Descriptor {
      get { return descriptor; }
    }
    private static pbr::FileDescriptor descriptor;

    static CurrencyContract() {
      byte[] descriptorData = global::System.Convert.FromBase64String(
          string.Concat(
            "ChZDdXJyZW5jeUNvbnRyYWN0LnByb3RvEgpjdXJyZW5jaWVzIjIKCEN1cnJl", 
            "bmN5EgoKAklkGAEgASgDEgwKBE5hbWUYAiABKAkSDAoEQ29kZRgDIAEoCSI+", 
            "ChJDdXJyZW5jaWVzUmVzcG9uc2USKAoKQ3VycmVuY2llcxgBIAMoCzIULmN1", 
            "cnJlbmNpZXMuQ3VycmVuY3kiEwoRQ3VycmVuY2llc1JlcXVlc3QyXAoPQ3Vy", 
            "cmVuY3lTZXJ2aWNlEkkKBkdldEFsbBIdLmN1cnJlbmNpZXMuQ3VycmVuY2ll", 
            "c1JlcXVlc3QaHi5jdXJyZW5jaWVzLkN1cnJlbmNpZXNSZXNwb25zZSIAQkEK", 
            "EGlvLmdycGMuZXhhbXBsZXNaCmN1cnJlbmNpZXOiAgNITFeqAhpHb29nbGUu", 
            "UHJvdG9idWYuY3VycmVuY2llc2IGcHJvdG8z"));
      descriptor = pbr::FileDescriptor.InternalBuildGeneratedFileFrom(descriptorData,
          new pbr::FileDescriptor[] { },
          new pbr::GeneratedCodeInfo(null, new pbr::GeneratedCodeInfo[] {
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.currencies.Currency), new[]{ "Id", "Name", "Code" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.currencies.CurrenciesResponse), new[]{ "Currencies" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.currencies.CurrenciesRequest), null, null, null, null)
          }));
    }
    #endregion

  }
  #region Messages
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class Currency : pb::IMessage<Currency> {
    private static readonly pb::MessageParser<Currency> _parser = new pb::MessageParser<Currency>(() => new Currency());
    public static pb::MessageParser<Currency> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.currencies.CurrencyContract.Descriptor.MessageTypes[0]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public Currency() {
      OnConstruction();
    }

    partial void OnConstruction();

    public Currency(Currency other) : this() {
      id_ = other.id_;
      name_ = other.name_;
      code_ = other.code_;
    }

    public Currency Clone() {
      return new Currency(this);
    }

    public const int IdFieldNumber = 1;
    private long id_;
    public long Id {
      get { return id_; }
      set {
        id_ = value;
      }
    }

    public const int NameFieldNumber = 2;
    private string name_ = "";
    public string Name {
      get { return name_; }
      set {
        name_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public const int CodeFieldNumber = 3;
    private string code_ = "";
    public string Code {
      get { return code_; }
      set {
        code_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public override bool Equals(object other) {
      return Equals(other as Currency);
    }

    public bool Equals(Currency other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Id != other.Id) return false;
      if (Name != other.Name) return false;
      if (Code != other.Code) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      if (Id != 0L) hash ^= Id.GetHashCode();
      if (Name.Length != 0) hash ^= Name.GetHashCode();
      if (Code.Length != 0) hash ^= Code.GetHashCode();
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
      if (Name.Length != 0) {
        output.WriteRawTag(18);
        output.WriteString(Name);
      }
      if (Code.Length != 0) {
        output.WriteRawTag(26);
        output.WriteString(Code);
      }
    }

    public int CalculateSize() {
      int size = 0;
      if (Id != 0L) {
        size += 1 + pb::CodedOutputStream.ComputeInt64Size(Id);
      }
      if (Name.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Name);
      }
      if (Code.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Code);
      }
      return size;
    }

    public void MergeFrom(Currency other) {
      if (other == null) {
        return;
      }
      if (other.Id != 0L) {
        Id = other.Id;
      }
      if (other.Name.Length != 0) {
        Name = other.Name;
      }
      if (other.Code.Length != 0) {
        Code = other.Code;
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
          case 18: {
            Name = input.ReadString();
            break;
          }
          case 26: {
            Code = input.ReadString();
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class CurrenciesResponse : pb::IMessage<CurrenciesResponse> {
    private static readonly pb::MessageParser<CurrenciesResponse> _parser = new pb::MessageParser<CurrenciesResponse>(() => new CurrenciesResponse());
    public static pb::MessageParser<CurrenciesResponse> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.currencies.CurrencyContract.Descriptor.MessageTypes[1]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public CurrenciesResponse() {
      OnConstruction();
    }

    partial void OnConstruction();

    public CurrenciesResponse(CurrenciesResponse other) : this() {
      currencies_ = other.currencies_.Clone();
    }

    public CurrenciesResponse Clone() {
      return new CurrenciesResponse(this);
    }

    public const int CurrenciesFieldNumber = 1;
    private static readonly pb::FieldCodec<global::Google.Protobuf.currencies.Currency> _repeated_currencies_codec
        = pb::FieldCodec.ForMessage(10, global::Google.Protobuf.currencies.Currency.Parser);
    private readonly pbc::RepeatedField<global::Google.Protobuf.currencies.Currency> currencies_ = new pbc::RepeatedField<global::Google.Protobuf.currencies.Currency>();
    public pbc::RepeatedField<global::Google.Protobuf.currencies.Currency> Currencies {
      get { return currencies_; }
    }

    public override bool Equals(object other) {
      return Equals(other as CurrenciesResponse);
    }

    public bool Equals(CurrenciesResponse other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if(!currencies_.Equals(other.currencies_)) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      hash ^= currencies_.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      currencies_.WriteTo(output, _repeated_currencies_codec);
    }

    public int CalculateSize() {
      int size = 0;
      size += currencies_.CalculateSize(_repeated_currencies_codec);
      return size;
    }

    public void MergeFrom(CurrenciesResponse other) {
      if (other == null) {
        return;
      }
      currencies_.Add(other.currencies_);
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 10: {
            currencies_.AddEntriesFrom(input, _repeated_currencies_codec);
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class CurrenciesRequest : pb::IMessage<CurrenciesRequest> {
    private static readonly pb::MessageParser<CurrenciesRequest> _parser = new pb::MessageParser<CurrenciesRequest>(() => new CurrenciesRequest());
    public static pb::MessageParser<CurrenciesRequest> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.currencies.CurrencyContract.Descriptor.MessageTypes[2]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public CurrenciesRequest() {
      OnConstruction();
    }

    partial void OnConstruction();

    public CurrenciesRequest(CurrenciesRequest other) : this() {
    }

    public CurrenciesRequest Clone() {
      return new CurrenciesRequest(this);
    }

    public override bool Equals(object other) {
      return Equals(other as CurrenciesRequest);
    }

    public bool Equals(CurrenciesRequest other) {
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

    public void MergeFrom(CurrenciesRequest other) {
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
