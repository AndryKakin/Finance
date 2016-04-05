REM Products service
echo Start generate product service
..\..\Library\GRPC\GrpcGeneration\protoc.exe --go_out=plugins=grpc:. ProductContract.proto
..\WindowsClient\packages\Google.Protobuf.3.0.0-alpha4\tools\protoc.exe -I ../contract --csharp_out . --grpc_out . --plugin=protoc-gen-grpc=..\WindowsClient\packages\Grpc.Tools.0.7.1\tools\grpc_csharp_plugin.exe ../contract/ProductContract.proto
copy "../contract/ProductContract.pb.go" "../Server/services/products/ProductContract.pb.go"
echo Product service generated.

REM Prices service
echo Start generate price service
..\..\Library\GRPC\GrpcGeneration\protoc.exe --go_out=plugins=grpc:. PriceContract.proto
..\WindowsClient\packages\Google.Protobuf.3.0.0-alpha4\tools\protoc.exe -I ../contract --csharp_out . --grpc_out . --plugin=protoc-gen-grpc=..\WindowsClient\packages\Grpc.Tools.0.7.1\tools\grpc_csharp_plugin.exe ../contract/PriceContract.proto
copy "../contract/PriceContract.pb.go" "../Server/services/prices/PriceContract.pb.go"
echo Price service generated.

REM Purchase service
echo Start generate purchase service
..\..\Library\GRPC\GrpcGeneration\protoc.exe --go_out=plugins=grpc:. PurchaseContract.proto
..\WindowsClient\packages\Google.Protobuf.3.0.0-alpha4\tools\protoc.exe -I ../contract --csharp_out . --grpc_out . --plugin=protoc-gen-grpc=..\WindowsClient\packages\Grpc.Tools.0.7.1\tools\grpc_csharp_plugin.exe ../contract/PurchaseContract.proto
copy "../contract/PurchaseContract.pb.go" "../Server/services/purchases/PurchaseContract.pb.go"
echo Purchase service generated

REM Currency service
echo Start generate currency service
..\..\Library\GRPC\GrpcGeneration\protoc.exe --go_out=plugins=grpc:. CurrencyContract.proto
..\WindowsClient\packages\Google.Protobuf.3.0.0-alpha4\tools\protoc.exe -I ../contract --csharp_out . --grpc_out . --plugin=protoc-gen-grpc=..\WindowsClient\packages\Grpc.Tools.0.7.1\tools\grpc_csharp_plugin.exe ../contract/CurrencyContract.proto
copy "../contract/CurrencyContract.pb.go" "../Server/services/currencies/CurrencyContract.pb.go"
copy "../contract/CurrencyContract.pb.go" "../GoClientForTest/services/currencies/CurrencyContract.pb.go"
echo Currency service generated

echo All is complete.
