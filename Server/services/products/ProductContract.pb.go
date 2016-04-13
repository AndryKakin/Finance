// Code generated by protoc-gen-go.
// source: ProductContract.proto
// DO NOT EDIT!

/*
Package products is a generated protocol buffer package.

It is generated from these files:
	ProductContract.proto

It has these top-level messages:
	Product
	AddProductRequest
	ProductsResponse
	ResultResponse
	ProductsRequest
*/
package products

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"

import (
	context "golang.org/x/net/context"
	grpc "google.golang.org/grpc"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

type Status int32

const (
	Status_Ok     Status = 0
	Status_Failed Status = 1
)

var Status_name = map[int32]string{
	0: "Ok",
	1: "Failed",
}
var Status_value = map[string]int32{
	"Ok":     0,
	"Failed": 1,
}

func (x Status) String() string {
	return proto.EnumName(Status_name, int32(x))
}
func (Status) EnumDescriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

type Product struct {
	Id          int64  `protobuf:"varint,1,opt,name=Id" json:"Id,omitempty"`
	Name        string `protobuf:"bytes,2,opt,name=Name" json:"Name,omitempty"`
	Description string `protobuf:"bytes,3,opt,name=Description" json:"Description,omitempty"`
	Barcode     string `protobuf:"bytes,4,opt,name=Barcode" json:"Barcode,omitempty"`
	Bitmap      []byte `protobuf:"bytes,5,opt,name=Bitmap,proto3" json:"Bitmap,omitempty"`
}

func (m *Product) Reset()                    { *m = Product{} }
func (m *Product) String() string            { return proto.CompactTextString(m) }
func (*Product) ProtoMessage()               {}
func (*Product) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

type AddProductRequest struct {
	Name        string `protobuf:"bytes,2,opt,name=Name" json:"Name,omitempty"`
	Description string `protobuf:"bytes,3,opt,name=Description" json:"Description,omitempty"`
	Code        string `protobuf:"bytes,4,opt,name=Code" json:"Code,omitempty"`
	Bitmap      []byte `protobuf:"bytes,5,opt,name=Bitmap,proto3" json:"Bitmap,omitempty"`
}

func (m *AddProductRequest) Reset()                    { *m = AddProductRequest{} }
func (m *AddProductRequest) String() string            { return proto.CompactTextString(m) }
func (*AddProductRequest) ProtoMessage()               {}
func (*AddProductRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

type ProductsResponse struct {
	Products []*Product `protobuf:"bytes,1,rep,name=Products" json:"Products,omitempty"`
}

func (m *ProductsResponse) Reset()                    { *m = ProductsResponse{} }
func (m *ProductsResponse) String() string            { return proto.CompactTextString(m) }
func (*ProductsResponse) ProtoMessage()               {}
func (*ProductsResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *ProductsResponse) GetProducts() []*Product {
	if m != nil {
		return m.Products
	}
	return nil
}

type ResultResponse struct {
	Status Status `protobuf:"varint,1,opt,name=Status,enum=products.Status" json:"Status,omitempty"`
}

func (m *ResultResponse) Reset()                    { *m = ResultResponse{} }
func (m *ResultResponse) String() string            { return proto.CompactTextString(m) }
func (*ResultResponse) ProtoMessage()               {}
func (*ResultResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{3} }

type ProductsRequest struct {
}

func (m *ProductsRequest) Reset()                    { *m = ProductsRequest{} }
func (m *ProductsRequest) String() string            { return proto.CompactTextString(m) }
func (*ProductsRequest) ProtoMessage()               {}
func (*ProductsRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{4} }

func init() {
	proto.RegisterType((*Product)(nil), "products.Product")
	proto.RegisterType((*AddProductRequest)(nil), "products.AddProductRequest")
	proto.RegisterType((*ProductsResponse)(nil), "products.ProductsResponse")
	proto.RegisterType((*ResultResponse)(nil), "products.ResultResponse")
	proto.RegisterType((*ProductsRequest)(nil), "products.ProductsRequest")
	proto.RegisterEnum("products.Status", Status_name, Status_value)
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// Client API for ProductService service

type ProductServiceClient interface {
	Add(ctx context.Context, in *AddProductRequest, opts ...grpc.CallOption) (*ResultResponse, error)
	Update(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error)
	Delete(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error)
	GetAll(ctx context.Context, in *ProductsRequest, opts ...grpc.CallOption) (*ProductsResponse, error)
}

type productServiceClient struct {
	cc *grpc.ClientConn
}

func NewProductServiceClient(cc *grpc.ClientConn) ProductServiceClient {
	return &productServiceClient{cc}
}

func (c *productServiceClient) Add(ctx context.Context, in *AddProductRequest, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/Add", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *productServiceClient) Update(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/Update", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *productServiceClient) Delete(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/Delete", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *productServiceClient) GetAll(ctx context.Context, in *ProductsRequest, opts ...grpc.CallOption) (*ProductsResponse, error) {
	out := new(ProductsResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/GetAll", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for ProductService service

type ProductServiceServer interface {
	Add(context.Context, *AddProductRequest) (*ResultResponse, error)
	Update(context.Context, *Product) (*ResultResponse, error)
	Delete(context.Context, *Product) (*ResultResponse, error)
	GetAll(context.Context, *ProductsRequest) (*ProductsResponse, error)
}

func RegisterProductServiceServer(s *grpc.Server, srv ProductServiceServer) {
	s.RegisterService(&_ProductService_serviceDesc, srv)
}

func _ProductService_Add_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(AddProductRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).Add(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _ProductService_Update_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Product)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).Update(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _ProductService_Delete_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Product)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).Delete(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _ProductService_GetAll_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(ProductsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).GetAll(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

var _ProductService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "products.ProductService",
	HandlerType: (*ProductServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Add",
			Handler:    _ProductService_Add_Handler,
		},
		{
			MethodName: "Update",
			Handler:    _ProductService_Update_Handler,
		},
		{
			MethodName: "Delete",
			Handler:    _ProductService_Delete_Handler,
		},
		{
			MethodName: "GetAll",
			Handler:    _ProductService_GetAll_Handler,
		},
	},
	Streams: []grpc.StreamDesc{},
}

var fileDescriptor0 = []byte{
	// 366 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x94, 0x92, 0x4f, 0x4f, 0xea, 0x40,
	0x14, 0xc5, 0xa1, 0xe5, 0x15, 0xde, 0x85, 0x94, 0x32, 0x2f, 0x2f, 0xa9, 0xe8, 0x82, 0xd4, 0x0d,
	0x71, 0xd1, 0x45, 0x5d, 0xb0, 0xd2, 0x84, 0x3f, 0x11, 0x4d, 0x8c, 0x1a, 0xd0, 0x18, 0xdd, 0x0d,
	0xed, 0x95, 0x34, 0x16, 0x66, 0xec, 0x4c, 0x8d, 0x5f, 0xc0, 0x2f, 0xe2, 0xd2, 0x4f, 0xe9, 0x58,
	0x5a, 0x1a, 0x83, 0x46, 0x5d, 0xce, 0xb9, 0xf3, 0x3b, 0x33, 0xe7, 0xe4, 0xc2, 0xff, 0x8b, 0x98,
	0x05, 0x89, 0x2f, 0x87, 0x6c, 0x29, 0x63, 0xea, 0x4b, 0x97, 0xc7, 0x4c, 0x32, 0x52, 0xe3, 0x2b,
	0x59, 0x38, 0x37, 0x50, 0xcd, 0xae, 0x10, 0x00, 0xed, 0x24, 0xb0, 0xcb, 0x9d, 0x72, 0x57, 0x27,
	0x0d, 0xa8, 0x9c, 0xd1, 0x05, 0xda, 0x9a, 0x3a, 0xfd, 0x25, 0xff, 0xa0, 0x3e, 0x42, 0xe1, 0xc7,
	0x21, 0x97, 0x21, 0x5b, 0xda, 0x7a, 0x2a, 0x36, 0xa1, 0x3a, 0xa0, 0xb1, 0xcf, 0x02, 0xb4, 0x2b,
	0xa9, 0x60, 0x82, 0x31, 0x08, 0xe5, 0x82, 0x72, 0xfb, 0x8f, 0x3a, 0x37, 0x9c, 0x4b, 0x68, 0xf5,
	0x83, 0x20, 0x73, 0x9f, 0xe0, 0x43, 0x82, 0x42, 0xfe, 0xc4, 0x58, 0x5d, 0x19, 0x7e, 0xed, 0xda,
	0x03, 0x2b, 0xb3, 0x14, 0x13, 0x14, 0x9c, 0x2d, 0x05, 0x92, 0x5d, 0xa8, 0xe5, 0x9a, 0xfa, 0xbf,
	0xde, 0xad, 0x7b, 0x2d, 0x37, 0x4f, 0xe8, 0x66, 0x13, 0xc7, 0x03, 0x53, 0x01, 0x49, 0x24, 0xd7,
	0x58, 0x07, 0x8c, 0xa9, 0xa4, 0x32, 0x11, 0x69, 0x68, 0xd3, 0xb3, 0x0a, 0x68, 0xa5, 0x3b, 0x2d,
	0x68, 0x16, 0x8f, 0xa5, 0x01, 0xf6, 0x76, 0x72, 0x88, 0x18, 0xa0, 0x9d, 0xdf, 0x5b, 0x25, 0xd5,
	0x9b, 0x71, 0x44, 0xc3, 0x08, 0x03, 0xab, 0xec, 0x3d, 0x6b, 0x60, 0x66, 0xc4, 0x14, 0xe3, 0xc7,
	0xd0, 0x47, 0x72, 0x08, 0xba, 0xaa, 0x81, 0x6c, 0x17, 0xe6, 0x1b, 0xad, 0xb4, 0xed, 0x62, 0xf8,
	0xf1, 0x8f, 0x4e, 0x89, 0xf4, 0xc0, 0xb8, 0xe2, 0x01, 0x95, 0x48, 0x36, 0x43, 0x7d, 0x07, 0x8e,
	0x30, 0xc2, 0xdf, 0x83, 0x7d, 0x30, 0xc6, 0x28, 0xfb, 0x51, 0x44, 0xb6, 0x36, 0xc0, 0xbc, 0x87,
	0x76, 0xfb, 0xb3, 0x51, 0x6e, 0x31, 0x38, 0x00, 0x2b, 0x64, 0xee, 0x3c, 0xe6, 0xbe, 0x8b, 0x4f,
	0x74, 0xc1, 0x23, 0x14, 0xb7, 0xeb, 0xa5, 0x7b, 0xd1, 0xf4, 0xe3, 0xd3, 0xeb, 0x57, 0xcd, 0x1e,
	0x33, 0x36, 0x8f, 0xf0, 0x9d, 0x97, 0x6c, 0x96, 0xdc, 0xad, 0x1d, 0x67, 0x46, 0xba, 0xa6, 0xfb,
	0x6f, 0x01, 0x00, 0x00, 0xff, 0xff, 0xc8, 0x6a, 0x7e, 0xc7, 0xbf, 0x02, 0x00, 0x00,
}
