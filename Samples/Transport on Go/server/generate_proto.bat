protoc --go_out=plugins=grpc:. main.proto
protoc -I ../server/ ../server/main.proto --go_out=plugins=grpc:main.proto