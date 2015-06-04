package main

import (
	"github.com/HouzuoGuo/tiedot/db"
	"fmt"
	"os"
)

var MainDBPath = "DB\\"
var productStoreName = "Product"

func InitializeDB() {
	myDb, err := db.OpenDB(MainDBPath)
	
	if err != nil {
		panic(err)
	}
	
	createStore(productStoreName,myDb)
	
	productStore := myDb.Use(productStoreName)
	
	createIndex("Id",productStore)
	
	productStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		fmt.Println("Document", id, "is", string(docContent))
		return true  // move on to the next document OR
		return false // do not move on to the next document
	})
	
	
	defer myDb.Close()
}

func ExitIfUserEnterExit() {
	var input string
	for {
		fmt.Scanln(&input)
		if input == "exit" {
			fmt.Println("Exit");
			os.Exit(0);
		}
	}	
}

func main () {
	InitializeDB()
	
	go ServerGo()
	
	ExitIfUserEnterExit()
}