// Code generated by protoc-gen-go.
// source: ProductContract.proto
// DO NOT EDIT!

/*
Package products is a generated protocol buffer package.

It is generated from these files:
	ProductContract.proto

It has these top-level messages:
	Product
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

type ProductsResponse struct {
	Products []*Product `protobuf:"bytes,1,rep,name=Products" json:"Products,omitempty"`
}

func (m *ProductsResponse) Reset()                    { *m = ProductsResponse{} }
func (m *ProductsResponse) String() string            { return proto.CompactTextString(m) }
func (*ProductsResponse) ProtoMessage()               {}
func (*ProductsResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

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
func (*ResultResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

type ProductsRequest struct {
}

func (m *ProductsRequest) Reset()                    { *m = ProductsRequest{} }
func (m *ProductsRequest) String() string            { return proto.CompactTextString(m) }
func (*ProductsRequest) ProtoMessage()               {}
func (*ProductsRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{3} }

func init() {
	proto.RegisterType((*Product)(nil), "products.Product")
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
	Add(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error)
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

func (c *productServiceClient) Add(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error) {
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
	Add(context.Context, *Product) (*ResultResponse, error)
	Update(context.Context, *Product) (*ResultResponse, error)
	Delete(context.Context, *Product) (*ResultResponse, error)
	GetAll(context.Context, *ProductsRequest) (*ProductsResponse, error)
}

func RegisterProductServiceServer(s *grpc.Server, srv ProductServiceServer) {
	s.RegisterService(&_ProductService_serviceDesc, srv)
}

func _ProductService_Add_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Product)
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
	// 338 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x9c, 0x92, 0xc1, 0x4e, 0xc2, 0x40,
	0x10, 0x86, 0x69, 0x8b, 0x05, 0x07, 0x52, 0xca, 0x1a, 0x93, 0x4a, 0x3c, 0x90, 0x7a, 0x21, 0x1e,
	0x7a, 0xa8, 0x26, 0x9c, 0x3c, 0x80, 0x44, 0x34, 0x31, 0x6a, 0x24, 0xc6, 0xe8, 0x6d, 0x69, 0x47,
	0xd2, 0xb8, 0xb0, 0xeb, 0xee, 0xd6, 0xf8, 0x3c, 0x1e, 0x7d, 0x45, 0x2f, 0xd6, 0xd2, 0x42, 0x0c,
	0x5e, 0xf4, 0xb8, 0xdf, 0xec, 0x37, 0xf3, 0x4f, 0x32, 0xb0, 0x7b, 0x23, 0x79, 0x9c, 0x46, 0xfa,
	0x94, 0x2f, 0xb4, 0xa4, 0x91, 0x0e, 0x84, 0xe4, 0x9a, 0x93, 0xba, 0x58, 0x62, 0xe5, 0x3f, 0x40,
	0xad, 0xf8, 0x42, 0x00, 0xcc, 0x8b, 0xd8, 0x33, 0xba, 0x46, 0xcf, 0x22, 0x4d, 0xa8, 0x5e, 0xd1,
	0x39, 0x7a, 0x66, 0xf6, 0xda, 0x26, 0x3b, 0xd0, 0x18, 0xa1, 0x8a, 0x64, 0x22, 0x74, 0xc2, 0x17,
	0x9e, 0x95, 0xc3, 0x16, 0xd4, 0x86, 0x54, 0x46, 0x3c, 0x46, 0xaf, 0x9a, 0x03, 0x07, 0xec, 0x61,
	0xa2, 0xe7, 0x54, 0x78, 0x5b, 0xd9, 0xbb, 0xe9, 0xf7, 0xc1, 0x2d, 0x5a, 0xab, 0x5b, 0x54, 0x82,
	0x2f, 0x14, 0x92, 0x03, 0xa8, 0x97, 0x2c, 0x9b, 0x64, 0xf5, 0x1a, 0x61, 0x3b, 0x28, 0xb3, 0x04,
	0x45, 0xc5, 0x0f, 0xc1, 0xc9, 0x84, 0x94, 0xe9, 0x95, 0xd6, 0x05, 0x7b, 0xa2, 0xa9, 0x4e, 0x55,
	0x1e, 0xcf, 0x09, 0xdd, 0xb5, 0xb4, 0xe4, 0x7e, 0x1b, 0x5a, 0xeb, 0x61, 0x2f, 0x29, 0x2a, 0x7d,
	0xb8, 0x5f, 0x4a, 0xc4, 0x06, 0xf3, 0xfa, 0xd9, 0xad, 0x64, 0x1b, 0xda, 0x67, 0x34, 0x61, 0x18,
	0xbb, 0x46, 0xf8, 0x69, 0x80, 0x53, 0x18, 0x13, 0x94, 0xaf, 0x49, 0x84, 0xe4, 0x18, 0xac, 0x41,
	0x1c, 0x93, 0xcd, 0x44, 0x1d, 0x6f, 0x8d, 0x7e, 0x26, 0xf3, 0x2b, 0xa4, 0x0f, 0xf6, 0x9d, 0x88,
	0xa9, 0xc6, 0x7f, 0x88, 0x23, 0x64, 0xf8, 0x77, 0x71, 0x00, 0xf6, 0x18, 0xf5, 0x80, 0x31, 0xb2,
	0xb7, 0x21, 0x96, 0xdb, 0x77, 0x3a, 0xbf, 0x95, 0xca, 0x16, 0xc3, 0x13, 0x70, 0x13, 0x1e, 0xcc,
	0xa4, 0x88, 0x02, 0x7c, 0xa3, 0x73, 0xc1, 0x50, 0x3d, 0xae, 0x8e, 0xe2, 0xdd, 0xb4, 0xce, 0x2f,
	0xef, 0x3f, 0x4c, 0x6f, 0xcc, 0xf9, 0x8c, 0xe1, 0xb7, 0xaf, 0xf9, 0x34, 0x7d, 0x5a, 0x75, 0x9c,
	0xda, 0xf9, 0x19, 0x1d, 0x7d, 0x05, 0x00, 0x00, 0xff, 0xff, 0x96, 0x90, 0xd1, 0x5a, 0x5f, 0x02,
	0x00, 0x00,
}
