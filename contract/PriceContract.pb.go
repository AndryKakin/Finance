// Code generated by protoc-gen-go.
// source: PriceContract.proto
// DO NOT EDIT!

/*
Package prices is a generated protocol buffer package.

It is generated from these files:
	PriceContract.proto

It has these top-level messages:
	Price
	PricesResponse
	ResultResponse
	GetAllRequest
*/
package prices

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

type Price struct {
	Id         int64   `protobuf:"varint,1,opt,name=Id" json:"Id,omitempty"`
	FkProduct  int64   `protobuf:"varint,2,opt,name=FkProduct" json:"FkProduct,omitempty"`
	FkPurchase int64   `protobuf:"varint,3,opt,name=FkPurchase" json:"FkPurchase,omitempty"`
	Price      float64 `protobuf:"fixed64,5,opt,name=Price" json:"Price,omitempty"`
}

func (m *Price) Reset()                    { *m = Price{} }
func (m *Price) String() string            { return proto.CompactTextString(m) }
func (*Price) ProtoMessage()               {}
func (*Price) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

type PricesResponse struct {
	Prices []*Price `protobuf:"bytes,1,rep,name=Prices" json:"Prices,omitempty"`
}

func (m *PricesResponse) Reset()                    { *m = PricesResponse{} }
func (m *PricesResponse) String() string            { return proto.CompactTextString(m) }
func (*PricesResponse) ProtoMessage()               {}
func (*PricesResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

func (m *PricesResponse) GetPrices() []*Price {
	if m != nil {
		return m.Prices
	}
	return nil
}

type ResultResponse struct {
	Status Status `protobuf:"varint,1,opt,name=Status,enum=prices.Status" json:"Status,omitempty"`
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
	proto.RegisterType((*Price)(nil), "prices.Price")
	proto.RegisterType((*PricesResponse)(nil), "prices.PricesResponse")
	proto.RegisterType((*ResultResponse)(nil), "prices.ResultResponse")
	proto.RegisterType((*GetAllRequest)(nil), "prices.GetAllRequest")
	proto.RegisterEnum("prices.Status", Status_name, Status_value)
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// Client API for PriceService service

type PriceServiceClient interface {
	Add(ctx context.Context, in *Price, opts ...grpc.CallOption) (*ResultResponse, error)
	Update(ctx context.Context, in *Price, opts ...grpc.CallOption) (*ResultResponse, error)
	Delete(ctx context.Context, in *Price, opts ...grpc.CallOption) (*ResultResponse, error)
	GetAll(ctx context.Context, in *GetAllRequest, opts ...grpc.CallOption) (*PricesResponse, error)
}

type priceServiceClient struct {
	cc *grpc.ClientConn
}

func NewPriceServiceClient(cc *grpc.ClientConn) PriceServiceClient {
	return &priceServiceClient{cc}
}

func (c *priceServiceClient) Add(ctx context.Context, in *Price, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/prices.PriceService/Add", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *priceServiceClient) Update(ctx context.Context, in *Price, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/prices.PriceService/Update", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *priceServiceClient) Delete(ctx context.Context, in *Price, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/prices.PriceService/Delete", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *priceServiceClient) GetAll(ctx context.Context, in *GetAllRequest, opts ...grpc.CallOption) (*PricesResponse, error) {
	out := new(PricesResponse)
	err := grpc.Invoke(ctx, "/prices.PriceService/GetAll", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for PriceService service

type PriceServiceServer interface {
	Add(context.Context, *Price) (*ResultResponse, error)
	Update(context.Context, *Price) (*ResultResponse, error)
	Delete(context.Context, *Price) (*ResultResponse, error)
	GetAll(context.Context, *GetAllRequest) (*PricesResponse, error)
}

func RegisterPriceServiceServer(s *grpc.Server, srv PriceServiceServer) {
	s.RegisterService(&_PriceService_serviceDesc, srv)
}

func _PriceService_Add_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Price)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PriceServiceServer).Add(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _PriceService_Update_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Price)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PriceServiceServer).Update(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _PriceService_Delete_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Price)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PriceServiceServer).Delete(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _PriceService_GetAll_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(GetAllRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PriceServiceServer).GetAll(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

var _PriceService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "prices.PriceService",
	HandlerType: (*PriceServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Add",
			Handler:    _PriceService_Add_Handler,
		},
		{
			MethodName: "Update",
			Handler:    _PriceService_Update_Handler,
		},
		{
			MethodName: "Delete",
			Handler:    _PriceService_Delete_Handler,
		},
		{
			MethodName: "GetAll",
			Handler:    _PriceService_GetAll_Handler,
		},
	},
	Streams: []grpc.StreamDesc{},
}

var fileDescriptor0 = []byte{
	// 321 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x94, 0x92, 0xcf, 0x4e, 0xc2, 0x40,
	0x10, 0xc6, 0x69, 0x1b, 0x36, 0x71, 0x94, 0x8a, 0x6b, 0x24, 0x8d, 0x51, 0x63, 0x7a, 0x22, 0x1e,
	0xaa, 0xe2, 0x89, 0x23, 0x6a, 0x40, 0x12, 0x13, 0x09, 0xc4, 0x98, 0x78, 0x2b, 0xed, 0x88, 0x84,
	0x95, 0x5d, 0xf7, 0x8f, 0xf1, 0x79, 0x3c, 0xfa, 0x52, 0xbe, 0x8a, 0xcb, 0x96, 0x6a, 0x7a, 0xe4,
	0x38, 0xdf, 0xcc, 0x6f, 0xe6, 0x9b, 0x9d, 0x85, 0xfd, 0x91, 0x9c, 0x67, 0x78, 0xc3, 0x97, 0x5a,
	0xa6, 0x99, 0x4e, 0x84, 0xe4, 0x9a, 0x53, 0x22, 0x56, 0xa2, 0x8a, 0x87, 0x50, 0x77, 0x69, 0x0a,
	0xe0, 0x0f, 0xf3, 0xc8, 0x3b, 0xf5, 0xda, 0x01, 0xdd, 0x83, 0xad, 0xfe, 0x62, 0x24, 0x79, 0x6e,
	0x32, 0x1d, 0xf9, 0x4e, 0xb2, 0x79, 0x2b, 0x19, 0x99, 0xbd, 0xa6, 0x0a, 0xa3, 0xc0, 0x69, 0x8d,
	0x35, 0x1b, 0xd5, 0x6d, 0xe8, 0xc5, 0xe7, 0x10, 0xba, 0x50, 0x8d, 0x51, 0x09, 0xbe, 0x54, 0x48,
	0x8f, 0x81, 0x14, 0x8a, 0xed, 0x1b, 0xb4, 0xb7, 0x3b, 0x8d, 0xa4, 0x98, 0x9a, 0x38, 0x35, 0xbe,
	0x80, 0xd0, 0x96, 0x1a, 0xa6, 0xff, 0x80, 0x13, 0x20, 0x13, 0x9d, 0x6a, 0xa3, 0x9c, 0x91, 0xb0,
	0x13, 0x96, 0x40, 0xa1, 0xc6, 0xbb, 0xd0, 0x18, 0xa0, 0xee, 0x31, 0x36, 0xc6, 0x77, 0x83, 0x4a,
	0x9f, 0x1d, 0x95, 0x00, 0x25, 0xe0, 0x3f, 0x2c, 0x9a, 0x35, 0xeb, 0x93, 0xf4, 0xd3, 0x39, 0xc3,
	0xbc, 0xe9, 0x75, 0x7e, 0x3c, 0xd8, 0x71, 0xa3, 0x26, 0x28, 0x3f, 0x56, 0x4b, 0x26, 0x10, 0xf4,
	0xf2, 0x9c, 0x56, 0x7d, 0x1c, 0xb6, 0xca, 0xb0, 0xea, 0x26, 0xae, 0xd1, 0x4b, 0x20, 0x8f, 0x22,
	0x4f, 0x35, 0x6e, 0x84, 0xdc, 0x22, 0xc3, 0x4d, 0x90, 0x2e, 0x90, 0x62, 0x2b, 0x7a, 0x50, 0xd6,
	0x54, 0xb6, 0xfc, 0x47, 0xab, 0xef, 0x1b, 0xd7, 0xae, 0xbb, 0xd0, 0x9c, 0xf3, 0x64, 0x26, 0x45,
	0x96, 0xe0, 0x67, 0xfa, 0x26, 0x18, 0xaa, 0xe7, 0xf5, 0x69, 0xbf, 0xfc, 0xe0, 0xee, 0xfe, 0xe9,
	0xdb, 0x6f, 0x0d, 0x38, 0x9f, 0x31, 0xb4, 0xac, 0xbd, 0xfb, 0xd4, 0xbc, 0xac, 0x7b, 0x4d, 0x89,
	0xfb, 0x08, 0x57, 0xbf, 0x01, 0x00, 0x00, 0xff, 0xff, 0xc5, 0xee, 0x77, 0xba, 0x1f, 0x02, 0x00,
	0x00,
}
