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
	GetAllRequest
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
	Id          int32  `protobuf:"varint,1,opt,name=Id" json:"Id,omitempty"`
	Name        string `protobuf:"bytes,2,opt,name=Name" json:"Name,omitempty"`
	Description string `protobuf:"bytes,3,opt,name=Description" json:"Description,omitempty"`
	Bitmap      []byte `protobuf:"bytes,4,opt,name=Bitmap,proto3" json:"Bitmap,omitempty"`
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

type GetAllRequest struct {
}

func (m *GetAllRequest) Reset()                    { *m = GetAllRequest{} }
func (m *GetAllRequest) String() string            { return proto.CompactTextString(m) }
func (*GetAllRequest) ProtoMessage()               {}
func (*GetAllRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{3} }

func init() {
	proto.RegisterType((*Product)(nil), "products.Product")
	proto.RegisterType((*ProductsResponse)(nil), "products.ProductsResponse")
	proto.RegisterType((*ResultResponse)(nil), "products.ResultResponse")
	proto.RegisterType((*GetAllRequest)(nil), "products.GetAllRequest")
	proto.RegisterEnum("products.Status", Status_name, Status_value)
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// Client API for ProductService service

type ProductServiceClient interface {
	AddProduct(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error)
	UpdateProduct(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error)
	DeleteProduct(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error)
	GetAll(ctx context.Context, in *GetAllRequest, opts ...grpc.CallOption) (*ProductsResponse, error)
}

type productServiceClient struct {
	cc *grpc.ClientConn
}

func NewProductServiceClient(cc *grpc.ClientConn) ProductServiceClient {
	return &productServiceClient{cc}
}

func (c *productServiceClient) AddProduct(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/AddProduct", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *productServiceClient) UpdateProduct(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/UpdateProduct", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *productServiceClient) DeleteProduct(ctx context.Context, in *Product, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/DeleteProduct", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *productServiceClient) GetAll(ctx context.Context, in *GetAllRequest, opts ...grpc.CallOption) (*ProductsResponse, error) {
	out := new(ProductsResponse)
	err := grpc.Invoke(ctx, "/products.ProductService/GetAll", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for ProductService service

type ProductServiceServer interface {
	AddProduct(context.Context, *Product) (*ResultResponse, error)
	UpdateProduct(context.Context, *Product) (*ResultResponse, error)
	DeleteProduct(context.Context, *Product) (*ResultResponse, error)
	GetAll(context.Context, *GetAllRequest) (*ProductsResponse, error)
}

func RegisterProductServiceServer(s *grpc.Server, srv ProductServiceServer) {
	s.RegisterService(&_ProductService_serviceDesc, srv)
}

func _ProductService_AddProduct_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Product)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).AddProduct(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _ProductService_UpdateProduct_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Product)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).UpdateProduct(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _ProductService_DeleteProduct_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Product)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(ProductServiceServer).DeleteProduct(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _ProductService_GetAll_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(GetAllRequest)
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
			MethodName: "AddProduct",
			Handler:    _ProductService_AddProduct_Handler,
		},
		{
			MethodName: "UpdateProduct",
			Handler:    _ProductService_UpdateProduct_Handler,
		},
		{
			MethodName: "DeleteProduct",
			Handler:    _ProductService_DeleteProduct_Handler,
		},
		{
			MethodName: "GetAll",
			Handler:    _ProductService_GetAll_Handler,
		},
	},
	Streams: []grpc.StreamDesc{},
}

var fileDescriptor0 = []byte{
	// 334 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x9c, 0x92, 0xc1, 0x4e, 0xfa, 0x40,
	0x10, 0xc6, 0xa1, 0xf0, 0xef, 0x1f, 0x07, 0xa8, 0x75, 0x8d, 0xb1, 0x21, 0x1e, 0x48, 0xbd, 0x10,
	0x0f, 0x3d, 0xd4, 0x83, 0x07, 0xa3, 0x06, 0x24, 0x82, 0x89, 0x51, 0x03, 0x31, 0x26, 0xde, 0x96,
	0x76, 0x24, 0x8d, 0x0b, 0xbb, 0x76, 0xa7, 0xc6, 0xa7, 0xf0, 0x21, 0x3c, 0xfa, 0x94, 0x56, 0x68,
	0x69, 0x08, 0x37, 0x8e, 0xf3, 0xed, 0xfc, 0xbe, 0x99, 0x6f, 0x33, 0x70, 0xf0, 0x18, 0xcb, 0x30,
	0x09, 0xe8, 0x5a, 0xce, 0x29, 0xe6, 0x01, 0x79, 0x2a, 0x96, 0x24, 0x59, 0x4d, 0x2d, 0x65, 0xed,
	0x0e, 0xe1, 0x7f, 0xd6, 0xc2, 0x00, 0x8c, 0xdb, 0xd0, 0x29, 0xb7, 0xcb, 0x9d, 0x7f, 0xac, 0x01,
	0xd5, 0x7b, 0x3e, 0x43, 0xc7, 0x48, 0xab, 0x1d, 0xb6, 0x0f, 0xf5, 0x3e, 0xea, 0x20, 0x8e, 0x14,
	0x45, 0x72, 0xee, 0x54, 0x16, 0xa2, 0x05, 0x66, 0x2f, 0xa2, 0x19, 0x57, 0x4e, 0x35, 0xad, 0x1b,
	0xee, 0x19, 0xd8, 0x99, 0x93, 0x1e, 0xa1, 0x56, 0x72, 0xae, 0x91, 0x1d, 0x43, 0x2d, 0xd7, 0x52,
	0xe3, 0x4a, 0xa7, 0xee, 0xef, 0x79, 0xf9, 0x68, 0x2f, 0x7b, 0x71, 0x7d, 0xb0, 0x52, 0x20, 0x11,
	0xb4, 0xc2, 0xda, 0x60, 0x8e, 0x89, 0x53, 0xa2, 0x17, 0xdb, 0x58, 0xbe, 0x5d, 0x40, 0x4b, 0xdd,
	0xdd, 0x85, 0xe6, 0x00, 0xa9, 0x2b, 0xc4, 0x08, 0xdf, 0x13, 0xd4, 0x74, 0x72, 0x94, 0x23, 0xcc,
	0x04, 0xe3, 0xe1, 0xcd, 0x2e, 0xa5, 0x71, 0xcc, 0x1b, 0x1e, 0x09, 0x0c, 0xed, 0xb2, 0xff, 0x65,
	0x80, 0x95, 0x8d, 0x1b, 0x63, 0xfc, 0x11, 0x05, 0xc8, 0xce, 0x01, 0xba, 0x61, 0x98, 0x67, 0xdf,
	0x5c, 0xab, 0xe5, 0x14, 0xd2, 0xfa, 0x7a, 0x6e, 0x89, 0x5d, 0x42, 0xf3, 0x49, 0x85, 0x9c, 0x70,
	0x7b, 0xbe, 0x8f, 0x02, 0xb7, 0xe6, 0xaf, 0xc0, 0x5c, 0xc6, 0x67, 0x87, 0x45, 0xd7, 0xda, 0x87,
	0xb4, 0x5a, 0x1b, 0x8e, 0xba, 0x30, 0xe8, 0x5d, 0x80, 0x1d, 0x49, 0x6f, 0x1a, 0xab, 0xc0, 0xc3,
	0x4f, 0x3e, 0x53, 0x02, 0xf5, 0xcb, 0xea, 0x28, 0xbe, 0x8d, 0xca, 0xf0, 0xee, 0xf9, 0xc7, 0x70,
	0x06, 0x52, 0x4e, 0x05, 0xfe, 0xf1, 0x24, 0x27, 0xc9, 0xeb, 0xca, 0x68, 0x62, 0x2e, 0xce, 0xe8,
	0xf4, 0x37, 0x00, 0x00, 0xff, 0xff, 0xf6, 0x92, 0xa3, 0x57, 0x5f, 0x02, 0x00, 0x00,
}
