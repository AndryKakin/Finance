..\..\..\..\..\Projects\Library\GRPC\GrpcGeneration\protoc.exe --go_out=plugins=grpc:. ProductContract.proto

..\Client\packages\Google.Protobuf.3.0.0-alpha4\tools\protoc.exe -I ../contract --csharp_out . --grpc_out . --plugin=protoc-gen-grpc=..\Client\packages\Grpc.Tools.0.7.1\tools\grpc_csharp_plugin.exe ../contract/ProductContract.proto

