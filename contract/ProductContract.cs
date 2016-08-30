// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductContract.proto
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
namespace Google.Protobuf.products {

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public static partial class ProductContract {

    #region Descriptor
    public static pbr::FileDescriptor Descriptor {
      get { return descriptor; }
    }
    private static pbr::FileDescriptor descriptor;

    static ProductContract() {
      byte[] descriptorData = global::System.Convert.FromBase64String(
          string.Concat(
            "ChVQcm9kdWN0Q29udHJhY3QucHJvdG8SCHByb2R1Y3RzIlkKB1Byb2R1Y3QS", 
            "CgoCSWQYASABKAMSDAoETmFtZRgCIAEoCRITCgtEZXNjcmlwdGlvbhgDIAEo", 
            "CRIPCgdCYXJjb2RlGAQgASgJEg4KBkJpdG1hcBgFIAEoDCJUChFBZGRQcm9k", 
            "dWN0UmVxdWVzdBIMCgROYW1lGAIgASgJEhMKC0Rlc2NyaXB0aW9uGAMgASgJ", 
            "EgwKBENvZGUYBCABKAkSDgoGQml0bWFwGAUgASgMIjcKEFByb2R1Y3RzUmVz", 
            "cG9uc2USIwoIUHJvZHVjdHMYASADKAsyES5wcm9kdWN0cy5Qcm9kdWN0IjIK", 
            "DlJlc3VsdFJlc3BvbnNlEiAKBlN0YXR1cxgBIAEoDjIQLnByb2R1Y3RzLlN0", 
            "YXR1cyIRCg9Qcm9kdWN0c1JlcXVlc3QiIgoUUmVtb3ZlUHJvZHVjdFJlcXVl", 
            "c3QSCgoCSWQYASABKAMqHAoGU3RhdHVzEgYKAk9rEAASCgoGRmFpbGVkEAEy", 
            "kgIKDlByb2R1Y3RTZXJ2aWNlEj4KA0FkZBIbLnByb2R1Y3RzLkFkZFByb2R1", 
            "Y3RSZXF1ZXN0GhgucHJvZHVjdHMuUmVzdWx0UmVzcG9uc2UiABI3CgZVcGRh", 
            "dGUSES5wcm9kdWN0cy5Qcm9kdWN0GhgucHJvZHVjdHMuUmVzdWx0UmVzcG9u", 
            "c2UiABJECgZEZWxldGUSHi5wcm9kdWN0cy5SZW1vdmVQcm9kdWN0UmVxdWVz", 
            "dBoYLnByb2R1Y3RzLlJlc3VsdFJlc3BvbnNlIgASQQoGR2V0QWxsEhkucHJv", 
            "ZHVjdHMuUHJvZHVjdHNSZXF1ZXN0GhoucHJvZHVjdHMuUHJvZHVjdHNSZXNw", 
            "b25zZSIAQj0KEGlvLmdycGMuZXhhbXBsZXNaCHByb2R1Y3RzogIDSExXqgIY", 
            "R29vZ2xlLlByb3RvYnVmLnByb2R1Y3RzYgZwcm90bzM="));
      descriptor = pbr::FileDescriptor.InternalBuildGeneratedFileFrom(descriptorData,
          new pbr::FileDescriptor[] { },
          new pbr::GeneratedCodeInfo(new[] {typeof(global::Google.Protobuf.products.Status), }, new pbr::GeneratedCodeInfo[] {
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.products.Product), new[]{ "Id", "Name", "Description", "Barcode", "Bitmap" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.products.AddProductRequest), new[]{ "Name", "Description", "Code", "Bitmap" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.products.ProductsResponse), new[]{ "Products" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.products.ResultResponse), new[]{ "Status" }, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.products.ProductsRequest), null, null, null, null),
            new pbr::GeneratedCodeInfo(typeof(global::Google.Protobuf.products.RemoveProductRequest), new[]{ "Id" }, null, null, null)
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
  public sealed partial class Product : pb::IMessage<Product> {
    private static readonly pb::MessageParser<Product> _parser = new pb::MessageParser<Product>(() => new Product());
    public static pb::MessageParser<Product> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.MessageTypes[0]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public Product() {
      OnConstruction();
    }

    partial void OnConstruction();

    public Product(Product other) : this() {
      id_ = other.id_;
      name_ = other.name_;
      description_ = other.description_;
      barcode_ = other.barcode_;
      bitmap_ = other.bitmap_;
    }

    public Product Clone() {
      return new Product(this);
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

    public const int DescriptionFieldNumber = 3;
    private string description_ = "";
    public string Description {
      get { return description_; }
      set {
        description_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public const int BarcodeFieldNumber = 4;
    private string barcode_ = "";
    public string Barcode {
      get { return barcode_; }
      set {
        barcode_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public const int BitmapFieldNumber = 5;
    private pb::ByteString bitmap_ = pb::ByteString.Empty;
    public pb::ByteString Bitmap {
      get { return bitmap_; }
      set {
        bitmap_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public override bool Equals(object other) {
      return Equals(other as Product);
    }

    public bool Equals(Product other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Id != other.Id) return false;
      if (Name != other.Name) return false;
      if (Description != other.Description) return false;
      if (Barcode != other.Barcode) return false;
      if (Bitmap != other.Bitmap) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      if (Id != 0L) hash ^= Id.GetHashCode();
      if (Name.Length != 0) hash ^= Name.GetHashCode();
      if (Description.Length != 0) hash ^= Description.GetHashCode();
      if (Barcode.Length != 0) hash ^= Barcode.GetHashCode();
      if (Bitmap.Length != 0) hash ^= Bitmap.GetHashCode();
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
      if (Description.Length != 0) {
        output.WriteRawTag(26);
        output.WriteString(Description);
      }
      if (Barcode.Length != 0) {
        output.WriteRawTag(34);
        output.WriteString(Barcode);
      }
      if (Bitmap.Length != 0) {
        output.WriteRawTag(42);
        output.WriteBytes(Bitmap);
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
      if (Description.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Description);
      }
      if (Barcode.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Barcode);
      }
      if (Bitmap.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeBytesSize(Bitmap);
      }
      return size;
    }

    public void MergeFrom(Product other) {
      if (other == null) {
        return;
      }
      if (other.Id != 0L) {
        Id = other.Id;
      }
      if (other.Name.Length != 0) {
        Name = other.Name;
      }
      if (other.Description.Length != 0) {
        Description = other.Description;
      }
      if (other.Barcode.Length != 0) {
        Barcode = other.Barcode;
      }
      if (other.Bitmap.Length != 0) {
        Bitmap = other.Bitmap;
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
            Description = input.ReadString();
            break;
          }
          case 34: {
            Barcode = input.ReadString();
            break;
          }
          case 42: {
            Bitmap = input.ReadBytes();
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class AddProductRequest : pb::IMessage<AddProductRequest> {
    private static readonly pb::MessageParser<AddProductRequest> _parser = new pb::MessageParser<AddProductRequest>(() => new AddProductRequest());
    public static pb::MessageParser<AddProductRequest> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.MessageTypes[1]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public AddProductRequest() {
      OnConstruction();
    }

    partial void OnConstruction();

    public AddProductRequest(AddProductRequest other) : this() {
      name_ = other.name_;
      description_ = other.description_;
      code_ = other.code_;
      bitmap_ = other.bitmap_;
    }

    public AddProductRequest Clone() {
      return new AddProductRequest(this);
    }

    public const int NameFieldNumber = 2;
    private string name_ = "";
    public string Name {
      get { return name_; }
      set {
        name_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public const int DescriptionFieldNumber = 3;
    private string description_ = "";
    public string Description {
      get { return description_; }
      set {
        description_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public const int CodeFieldNumber = 4;
    private string code_ = "";
    public string Code {
      get { return code_; }
      set {
        code_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public const int BitmapFieldNumber = 5;
    private pb::ByteString bitmap_ = pb::ByteString.Empty;
    public pb::ByteString Bitmap {
      get { return bitmap_; }
      set {
        bitmap_ = pb::Preconditions.CheckNotNull(value, "value");
      }
    }

    public override bool Equals(object other) {
      return Equals(other as AddProductRequest);
    }

    public bool Equals(AddProductRequest other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Name != other.Name) return false;
      if (Description != other.Description) return false;
      if (Code != other.Code) return false;
      if (Bitmap != other.Bitmap) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      if (Name.Length != 0) hash ^= Name.GetHashCode();
      if (Description.Length != 0) hash ^= Description.GetHashCode();
      if (Code.Length != 0) hash ^= Code.GetHashCode();
      if (Bitmap.Length != 0) hash ^= Bitmap.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      if (Name.Length != 0) {
        output.WriteRawTag(18);
        output.WriteString(Name);
      }
      if (Description.Length != 0) {
        output.WriteRawTag(26);
        output.WriteString(Description);
      }
      if (Code.Length != 0) {
        output.WriteRawTag(34);
        output.WriteString(Code);
      }
      if (Bitmap.Length != 0) {
        output.WriteRawTag(42);
        output.WriteBytes(Bitmap);
      }
    }

    public int CalculateSize() {
      int size = 0;
      if (Name.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Name);
      }
      if (Description.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Description);
      }
      if (Code.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeStringSize(Code);
      }
      if (Bitmap.Length != 0) {
        size += 1 + pb::CodedOutputStream.ComputeBytesSize(Bitmap);
      }
      return size;
    }

    public void MergeFrom(AddProductRequest other) {
      if (other == null) {
        return;
      }
      if (other.Name.Length != 0) {
        Name = other.Name;
      }
      if (other.Description.Length != 0) {
        Description = other.Description;
      }
      if (other.Code.Length != 0) {
        Code = other.Code;
      }
      if (other.Bitmap.Length != 0) {
        Bitmap = other.Bitmap;
      }
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 18: {
            Name = input.ReadString();
            break;
          }
          case 26: {
            Description = input.ReadString();
            break;
          }
          case 34: {
            Code = input.ReadString();
            break;
          }
          case 42: {
            Bitmap = input.ReadBytes();
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class ProductsResponse : pb::IMessage<ProductsResponse> {
    private static readonly pb::MessageParser<ProductsResponse> _parser = new pb::MessageParser<ProductsResponse>(() => new ProductsResponse());
    public static pb::MessageParser<ProductsResponse> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.MessageTypes[2]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public ProductsResponse() {
      OnConstruction();
    }

    partial void OnConstruction();

    public ProductsResponse(ProductsResponse other) : this() {
      products_ = other.products_.Clone();
    }

    public ProductsResponse Clone() {
      return new ProductsResponse(this);
    }

    public const int ProductsFieldNumber = 1;
    private static readonly pb::FieldCodec<global::Google.Protobuf.products.Product> _repeated_products_codec
        = pb::FieldCodec.ForMessage(10, global::Google.Protobuf.products.Product.Parser);
    private readonly pbc::RepeatedField<global::Google.Protobuf.products.Product> products_ = new pbc::RepeatedField<global::Google.Protobuf.products.Product>();
    public pbc::RepeatedField<global::Google.Protobuf.products.Product> Products {
      get { return products_; }
    }

    public override bool Equals(object other) {
      return Equals(other as ProductsResponse);
    }

    public bool Equals(ProductsResponse other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if(!products_.Equals(other.products_)) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      hash ^= products_.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      products_.WriteTo(output, _repeated_products_codec);
    }

    public int CalculateSize() {
      int size = 0;
      size += products_.CalculateSize(_repeated_products_codec);
      return size;
    }

    public void MergeFrom(ProductsResponse other) {
      if (other == null) {
        return;
      }
      products_.Add(other.products_);
    }

    public void MergeFrom(pb::CodedInputStream input) {
      uint tag;
      while ((tag = input.ReadTag()) != 0) {
        switch(tag) {
          default:
            input.SkipLastField();
            break;
          case 10: {
            products_.AddEntriesFrom(input, _repeated_products_codec);
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
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.MessageTypes[3]; }
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
    private global::Google.Protobuf.products.Status status_ = global::Google.Protobuf.products.Status.Ok;
    public global::Google.Protobuf.products.Status Status {
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
      if (Status != global::Google.Protobuf.products.Status.Ok) hash ^= Status.GetHashCode();
      return hash;
    }

    public override string ToString() {
      return pb::JsonFormatter.Default.Format(this);
    }

    public void WriteTo(pb::CodedOutputStream output) {
      if (Status != global::Google.Protobuf.products.Status.Ok) {
        output.WriteRawTag(8);
        output.WriteEnum((int) Status);
      }
    }

    public int CalculateSize() {
      int size = 0;
      if (Status != global::Google.Protobuf.products.Status.Ok) {
        size += 1 + pb::CodedOutputStream.ComputeEnumSize((int) Status);
      }
      return size;
    }

    public void MergeFrom(ResultResponse other) {
      if (other == null) {
        return;
      }
      if (other.Status != global::Google.Protobuf.products.Status.Ok) {
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
            status_ = (global::Google.Protobuf.products.Status) input.ReadEnum();
            break;
          }
        }
      }
    }

  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class ProductsRequest : pb::IMessage<ProductsRequest> {
    private static readonly pb::MessageParser<ProductsRequest> _parser = new pb::MessageParser<ProductsRequest>(() => new ProductsRequest());
    public static pb::MessageParser<ProductsRequest> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.MessageTypes[4]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public ProductsRequest() {
      OnConstruction();
    }

    partial void OnConstruction();

    public ProductsRequest(ProductsRequest other) : this() {
    }

    public ProductsRequest Clone() {
      return new ProductsRequest(this);
    }

    public override bool Equals(object other) {
      return Equals(other as ProductsRequest);
    }

    public bool Equals(ProductsRequest other) {
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

    public void MergeFrom(ProductsRequest other) {
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

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
  public sealed partial class RemoveProductRequest : pb::IMessage<RemoveProductRequest> {
    private static readonly pb::MessageParser<RemoveProductRequest> _parser = new pb::MessageParser<RemoveProductRequest>(() => new RemoveProductRequest());
    public static pb::MessageParser<RemoveProductRequest> Parser { get { return _parser; } }

    public static pbr::MessageDescriptor Descriptor {
      get { return global::Google.Protobuf.products.ProductContract.Descriptor.MessageTypes[5]; }
    }

    pbr::MessageDescriptor pb::IMessage.Descriptor {
      get { return Descriptor; }
    }

    public RemoveProductRequest() {
      OnConstruction();
    }

    partial void OnConstruction();

    public RemoveProductRequest(RemoveProductRequest other) : this() {
      id_ = other.id_;
    }

    public RemoveProductRequest Clone() {
      return new RemoveProductRequest(this);
    }

    public const int IdFieldNumber = 1;
    private long id_;
    public long Id {
      get { return id_; }
      set {
        id_ = value;
      }
    }

    public override bool Equals(object other) {
      return Equals(other as RemoveProductRequest);
    }

    public bool Equals(RemoveProductRequest other) {
      if (ReferenceEquals(other, null)) {
        return false;
      }
      if (ReferenceEquals(other, this)) {
        return true;
      }
      if (Id != other.Id) return false;
      return true;
    }

    public override int GetHashCode() {
      int hash = 1;
      if (Id != 0L) hash ^= Id.GetHashCode();
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
    }

    public int CalculateSize() {
      int size = 0;
      if (Id != 0L) {
        size += 1 + pb::CodedOutputStream.ComputeInt64Size(Id);
      }
      return size;
    }

    public void MergeFrom(RemoveProductRequest other) {
      if (other == null) {
        return;
      }
      if (other.Id != 0L) {
        Id = other.Id;
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
        }
      }
    }

  }

  #endregion

}

#endregion Designer generated code
