package main

import (
	"github.com/HouzuoGuo/tiedot/db"
	"fmt"
	"encoding/json"
)

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

func createIndex(index string, store *db.Col) {
	
	existIndexes := store.AllIndexes()
	
	for i := 0; i < len(existIndexes); i++ {
		for j :=0; j < len(existIndexes[i]); j++ {
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

func createStore(storeName string, db *db.DB) {
	allStores := db.AllCols()
	for i := 0; i < len(allStores);i++ {
		if allStores[i] == storeName {
			return
		}
	}
	err := db.Create(storeName)
	
	if err != nil {
		panic(err)
	}	
}