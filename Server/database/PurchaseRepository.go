package database

import (
	"encoding/json"
	"fmt"

	"github.com/HouzuoGuo/tiedot/db"
)

type PurchaseItemDB struct {
	Id          int64
	Name        string
	Description string
	Code        string
	Bitmap      []byte
}

var purchaseStoreName = "Purchase"

func getDbPurchaseStore() *db.Col {
	mydb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(purchaseStoreName)
}

func InitializeCurrencies() {
	mydb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}
	CreateStore(purchaseStoreName, mydb)
	purchaseStore := mydb.Use(purchaseStoreName)

	defer mydb.Close()
}
