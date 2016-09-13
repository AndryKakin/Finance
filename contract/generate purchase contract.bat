REM Purchase service
echo Start generate purchase service
..\..\Library\GRPC\GrpcGeneration\protoc.exe --go_out=plugins=grpc:. PurchaseContract.proto
..\WindowsClient\packages\Google.Protobuf.3.0.0-alpha4\tools\protoc.exe -I ../contract --csharp_out . --grpc_out . --plugin=protoc-gen-grpc=..\WindowsClient\packages\Grpc.Tools.0.7.1\tools\grpc_csharp_plugin.exe ../contract/PurchaseContract.proto
copy "../contract/PurchaseContract.pb.go" "../Server/services/purchases/PurchaseContract.pb.go"
echo Purchase service generated