package Products

import (
	"Finance/Server/database"

	"github.com/HouzuoGuo/tiedot/db"
)

var productStoreName = "Product"

type ProductDB struct {
	Id          int64
	Name        string
	Description string
	Code        string
	Bitmap      []byte
}

func GetDbProductStore() *db.Col {
	myDb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}

	return myDb.Use(productStoreName)
}

func Add(productDb *ProductDB) int64 {
	productStore := GetDbProductStore()
	docID, err := productStore.Insert(map[string]interface{}{
		"Name":        productDb.Name,
		"Description": productDb.Description,
		"Bitmap":      productDb.Bitmap})
	if err != nil {
		panic(err)
	}
	return int64(docID)
}
