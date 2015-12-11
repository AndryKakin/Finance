package main

import (
	"encoding/json"
	"fmt"
	"os"

	"github.com/HouzuoGuo/tiedot/db"
)

var MainDBPath = "DB\\"
var productStoreName = "Product"

func InitializeDB() {
	myDb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}

	createStore(productStoreName, myDb)

	productStore := myDb.Use(productStoreName)

	createIndex("Id", productStore)

	defer myDb.Close()
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

	go ServerGo()

	ExitIfUserEnterExit()
}
