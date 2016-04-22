package main

import (
	"Finance/Server/database"
	"Finance/Server/services/currencies"
	"Finance/Server/services/products"
	"fmt"
	"os"

	"github.com/HouzuoGuo/tiedot/db"
)

var MainDBPath = "DB\\"
var productStoreName = "Product"

func InitializeDB() {
	fmt.Println("Initialize DB Begin")
	myDb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)

	}
	fmt.Println("Create product store")
	database.CreateStore(productStoreName, myDb)

	productStore := myDb.Use(productStoreName)

	fmt.Println("Create index in product store")
	database.CreateIndex("Id", productStore)

	fmt.Println("Initialize currency")
	database.InitializeCurrencies()

	defer myDb.Close()
	fmt.Println("Initialize DB End")
}

func ExitIfUserEnterExit() {
	var input string
	for {
		fmt.Scanln(&input)
		if input == "exit" {
			fmt.Println("Exit")
			os.Exit(0)
		}
	}
}

func main() {
	InitializeDB()

	go products.GoProductService()
	go currencies.GoCurrencyService()

	fmt.Println("Please enter to end...")
	ExitIfUserEnterExit()
}
