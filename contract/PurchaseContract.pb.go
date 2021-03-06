// Code generated by protoc-gen-go.
// source: PurchaseContract.proto
// DO NOT EDIT!

/*
Package purchases is a generated protocol buffer package.

It is generated from these files:
	PurchaseContract.proto

It has these top-level messages:
	PuchaseItem
	Purchase
	PurchasesResponse
	ResultResponse
	GetAllRequest
*/
package purchases

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

type PuchaseItem struct {
	FkProductId int64   `protobuf:"varint,1,opt,name=FkProductId" json:"FkProductId,omitempty"`
	FullPrice   float32 `protobuf:"fixed32,2,opt,name=FullPrice" json:"FullPrice,omitempty"`
	Count       float32 `protobuf:"fixed32,3,opt,name=Count" json:"Count,omitempty"`
}

func (m *PuchaseItem) Reset()                    { *m = PuchaseItem{} }
func (m *PuchaseItem) String() string            { return proto.CompactTextString(m) }
func (*PuchaseItem) ProtoMessage()               {}
func (*PuchaseItem) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

type Purchase struct {
	Id         int64          `protobuf:"varint,1,opt,name=Id" json:"Id,omitempty"`
	FkCurrency int64          `protobuf:"varint,2,opt,name=FkCurrency" json:"FkCurrency,omitempty"`
	DateTime   string         `protobuf:"bytes,3,opt,name=DateTime" json:"DateTime,omitempty"`
	Purchases  []*PuchaseItem `protobuf:"bytes,4,rep,name=Purchases" json:"Purchases,omitempty"`
}

func (m *Purchase) Reset()                    { *m = Purchase{} }
func (m *Purchase) String() string            { return proto.CompactTextString(m) }
func (*Purchase) ProtoMessage()               {}
func (*Purchase) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

func (m *Purchase) GetPurchases() []*PuchaseItem {
	if m != nil {
		return m.Purchases
	}
	return nil
}

type PurchasesResponse struct {
	Purchases []*Purchase `protobuf:"bytes,1,rep,name=Purchases" json:"Purchases,omitempty"`
}

func (m *PurchasesResponse) Reset()                    { *m = PurchasesResponse{} }
func (m *PurchasesResponse) String() string            { return proto.CompactTextString(m) }
func (*PurchasesResponse) ProtoMessage()               {}
func (*PurchasesResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *PurchasesResponse) GetPurchases() []*Purchase {
	if m != nil {
		return m.Purchases
	}
	return nil
}

type ResultResponse struct {
	Status Status `protobuf:"varint,1,opt,name=Status,enum=purchases.Status" json:"Status,omitempty"`
}

func (m *ResultResponse) Reset()                    { *m = ResultResponse{} }
func (m *ResultResponse) String() string            { return proto.CompactTextString(m) }
func (*ResultResponse) ProtoMessage()               {}
func (*ResultResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{3} }

type GetAllRequest struct {
}

func (m *GetAllRequest) Reset()                    { *m = GetAllRequest{} }
func (m *GetAllRequest) String() string            { return proto.CompactTextString(m) }
func (*GetAllRequest) ProtoMessage()               {}
func (*GetAllRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{4} }

func init() {
	proto.RegisterType((*PuchaseItem)(nil), "purchases.PuchaseItem")
	proto.RegisterType((*Purchase)(nil), "purchases.Purchase")
	proto.RegisterType((*PurchasesResponse)(nil), "purchases.PurchasesResponse")
	proto.RegisterType((*ResultResponse)(nil), "purchases.ResultResponse")
	proto.RegisterType((*GetAllRequest)(nil), "purchases.GetAllRequest")
	proto.RegisterEnum("purchases.Status", Status_name, Status_value)
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// Client API for PurchaseService service

type PurchaseServiceClient interface {
	Add(ctx context.Context, in *Purchase, opts ...grpc.CallOption) (*ResultResponse, error)
	Update(ctx context.Context, in *Purchase, opts ...grpc.CallOption) (*ResultResponse, error)
	Delete(ctx context.Context, in *Purchase, opts ...grpc.CallOption) (*ResultResponse, error)
	GetAll(ctx context.Context, in *GetAllRequest, opts ...grpc.CallOption) (*PurchasesResponse, error)
}

type purchaseServiceClient struct {
	cc *grpc.ClientConn
}

func NewPurchaseServiceClient(cc *grpc.ClientConn) PurchaseServiceClient {
	return &purchaseServiceClient{cc}
}

func (c *purchaseServiceClient) Add(ctx context.Context, in *Purchase, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/purchases.PurchaseService/Add", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *purchaseServiceClient) Update(ctx context.Context, in *Purchase, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/purchases.PurchaseService/Update", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *purchaseServiceClient) Delete(ctx context.Context, in *Purchase, opts ...grpc.CallOption) (*ResultResponse, error) {
	out := new(ResultResponse)
	err := grpc.Invoke(ctx, "/purchases.PurchaseService/Delete", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *purchaseServiceClient) GetAll(ctx context.Context, in *GetAllRequest, opts ...grpc.CallOption) (*PurchasesResponse, error) {
	out := new(PurchasesResponse)
	err := grpc.Invoke(ctx, "/purchases.PurchaseService/GetAll", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for PurchaseService service

type PurchaseServiceServer interface {
	Add(context.Context, *Purchase) (*ResultResponse, error)
	Update(context.Context, *Purchase) (*ResultResponse, error)
	Delete(context.Context, *Purchase) (*ResultResponse, error)
	GetAll(context.Context, *GetAllRequest) (*PurchasesResponse, error)
}

func RegisterPurchaseServiceServer(s *grpc.Server, srv PurchaseServiceServer) {
	s.RegisterService(&_PurchaseService_serviceDesc, srv)
}

func _PurchaseService_Add_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Purchase)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PurchaseServiceServer).Add(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _PurchaseService_Update_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Purchase)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PurchaseServiceServer).Update(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _PurchaseService_Delete_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(Purchase)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PurchaseServiceServer).Delete(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func _PurchaseService_GetAll_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(GetAllRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(PurchaseServiceServer).GetAll(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

var _PurchaseService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "purchases.PurchaseService",
	HandlerType: (*PurchaseServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Add",
			Handler:    _PurchaseService_Add_Handler,
		},
		{
			MethodName: "Update",
			Handler:    _PurchaseService_Update_Handler,
		},
		{
			MethodName: "Delete",
			Handler:    _PurchaseService_Delete_Handler,
		},
		{
			MethodName: "GetAll",
			Handler:    _PurchaseService_GetAll_Handler,
		},
	},
	Streams: []grpc.StreamDesc{},
}

var fileDescriptor0 = []byte{
	// 383 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x9c, 0x92, 0x4d, 0xcf, 0xd2, 0x40,
	0x10, 0xc7, 0x9f, 0xb6, 0xda, 0x3c, 0x1d, 0x02, 0x94, 0x25, 0x21, 0x85, 0x70, 0xc0, 0x1e, 0x0c,
	0x7a, 0xe8, 0x01, 0x0e, 0x26, 0x7a, 0x30, 0xbc, 0xa4, 0x48, 0x62, 0x62, 0x03, 0x1a, 0x13, 0x6f,
	0xa5, 0x1d, 0xb1, 0x61, 0xe9, 0xd6, 0x7d, 0x31, 0xfa, 0x05, 0xfc, 0x20, 0x1e, 0xfd, 0x94, 0x96,
	0x62, 0x4b, 0x49, 0x38, 0x71, 0xdb, 0x99, 0x9d, 0xdf, 0xcc, 0x7f, 0x26, 0x7f, 0xe8, 0x05, 0x8a,
	0x47, 0xdf, 0x42, 0x81, 0x0b, 0x96, 0x4a, 0x1e, 0x46, 0xd2, 0xcb, 0x38, 0x93, 0x8c, 0x58, 0xd9,
	0xff, 0xbc, 0x70, 0x97, 0xd0, 0x08, 0x54, 0xf1, 0x5e, 0x4b, 0x3c, 0x92, 0x2e, 0x34, 0xfc, 0x43,
	0xc0, 0x59, 0xac, 0x22, 0xb9, 0x8e, 0x1d, 0x6d, 0xa4, 0x8d, 0x0d, 0xd2, 0x01, 0xcb, 0x57, 0x94,
	0x06, 0x3c, 0x89, 0xd0, 0xd1, 0xf3, 0x94, 0x4e, 0x9a, 0xf0, 0x74, 0xc1, 0x54, 0x2a, 0x1d, 0xe3,
	0x14, 0xba, 0x7b, 0x78, 0x2c, 0x47, 0x11, 0x00, 0xbd, 0x22, 0xf3, 0xc0, 0x3f, 0x2c, 0x14, 0xe7,
	0x98, 0x46, 0xbf, 0x0a, 0xd4, 0x20, 0x36, 0x3c, 0x2e, 0x43, 0x89, 0x1f, 0x93, 0x23, 0x16, 0xb4,
	0x45, 0x5e, 0x80, 0x55, 0xd2, 0xc2, 0x79, 0x32, 0x32, 0xc6, 0x8d, 0x49, 0xcf, 0xab, 0x24, 0x7a,
	0x35, 0x7d, 0xee, 0x1b, 0xe8, 0x54, 0xa5, 0x1b, 0x14, 0x19, 0x4b, 0xf3, 0x89, 0xcf, 0xeb, 0xbc,
	0x56, 0xf0, 0xdd, 0x2b, 0xfe, 0xfc, 0x72, 0xa7, 0xd0, 0xca, 0x19, 0x45, 0x65, 0x45, 0x3e, 0x03,
	0x73, 0x2b, 0x43, 0xa9, 0x44, 0xa1, 0xb7, 0x35, 0xe9, 0xd4, 0xb0, 0xf3, 0x87, 0xdb, 0x86, 0xe6,
	0x0a, 0xe5, 0x8c, 0xd2, 0x0d, 0x7e, 0x57, 0x28, 0xe4, 0xcb, 0x61, 0xc9, 0x10, 0x13, 0xf4, 0x0f,
	0x07, 0xfb, 0x21, 0x5f, 0xd2, 0xf4, 0xc3, 0x84, 0x62, 0x6c, 0x6b, 0x93, 0xdf, 0x3a, 0xb4, 0xcb,
	0x81, 0x5b, 0xe4, 0x3f, 0xf2, 0x93, 0x91, 0x57, 0x60, 0xcc, 0xe2, 0x98, 0xdc, 0xd2, 0x34, 0xe8,
	0xd7, 0x92, 0xd7, 0xe2, 0xdc, 0x07, 0xf2, 0x1a, 0xcc, 0x4f, 0x59, 0x9c, 0x1f, 0xeb, 0x3e, 0x76,
	0x89, 0x14, 0xef, 0x62, 0xe7, 0x60, 0x9e, 0x77, 0x26, 0x4e, 0xad, 0xec, 0xea, 0x0c, 0x83, 0xe1,
	0x8d, 0xae, 0xe2, 0xd2, 0x63, 0xfe, 0x16, 0xec, 0x84, 0x79, 0x7b, 0x9e, 0x45, 0x1e, 0xfe, 0x0c,
	0x8f, 0x19, 0x45, 0xf1, 0xe5, 0xe2, 0xbb, 0x3f, 0xba, 0xf1, 0xee, 0xfd, 0xe7, 0xbf, 0x7a, 0x7f,
	0xc5, 0xd8, 0x9e, 0xa2, 0x17, 0x9c, 0x7c, 0xb9, 0x53, 0x5f, 0x2f, 0x4d, 0x77, 0x66, 0xe1, 0xd5,
	0xe9, 0xbf, 0x00, 0x00, 0x00, 0xff, 0xff, 0xb3, 0x77, 0x46, 0xc9, 0xc5, 0x02, 0x00, 0x00,
}
