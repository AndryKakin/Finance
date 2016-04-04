package database

import (
	"encoding/json"
	"fmt"

	"github.com/HouzuoGuo/tiedot/db"
)

var PriceStoreName = "Price"
var ProductStoreName = "Product"
var MainDBPath = "DB\\"

func GetDbPriceStore() *db.Col {
	mydb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(PriceStoreName)
}

func GetDbProductStore() *db.Col {
	myDb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}

	return myDb.Use(ProductStoreName)
}

func createProduct() (js map[string]interface{}) {
	doc := fmt.Sprintf(`
{
	"product": {
		"Name": "%s",
		"Description": "%s"
	}
}
`,
		"Bread",
		"Very tasty black bread.")

	if err := json.Unmarshal([]byte(doc), &js); err != nil {
		panic(err)
	}
	return
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
