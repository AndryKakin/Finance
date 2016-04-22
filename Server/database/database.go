package database

import (
	"github.com/HouzuoGuo/tiedot/db"
)

var PriceStoreName = "Price"
var MainDBPath = "DB\\"

func GetDbPriceStore() *db.Col {
	mydb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(PriceStoreName)
}

func CreateIndex(index string, store *db.Col) {

	existIndexes := store.AllIndexes()

	for i := 0; i < len(existIndexes); i++ {
		for j := 0; j < len(existIndexes[i]); j++ {
			if existIndexes[i][j] == index {
				return
			}
		}
	}

	err := store.Index([]string{index})

	if err != nil {
		panic(err)
	}
}

func CreateStore(storeName string, db *db.DB) {
	allStores := db.AllCols()
	for i := 0; i < len(allStores); i++ {
		if allStores[i] == storeName {
			return
		}
	}
	err := db.Create(storeName)

	if err != nil {
		panic(err)
	}
}
