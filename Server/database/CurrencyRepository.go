package database

import (
	"encoding/json"
	"fmt"

	"github.com/HouzuoGuo/tiedot/db"
)

type CurrencyDB struct {
	Code string
}

const (
	currencyCode = "Code"
)

const (
	rubCurrency = "RUB"
)

const (
	usdCurrency = "USD"
)

var currencyStoreName = "Currency"

func getDbCurrencyStore() *db.Col {
	mydb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(currencyStoreName)
}

func insertRubCurrency(store *db.Col) {
	haveItem := false

	store.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var currency CurrencyDB
		err := json.Unmarshal(docContent, &currency)
		if err != nil {
			panic(err)
		}

		if currency.Code == rubCurrency {
			haveItem = true
			return false
		} else {
			return true // move on to the next document OR
		}
	})

	if !haveItem {
		docID, err := store.Insert(map[string]interface{}{currencyCode: rubCurrency})
		if err != nil {
			panic(err)
		}
		fmt.Println("Create currency Id: %v  %v", docID, rubCurrency)
	}
	fmt.Println("Currency %v created early", rubCurrency)
}

func insertUsdCurrency(store *db.Col) {
	haveItem := false

	store.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var currency CurrencyDB
		err := json.Unmarshal(docContent, &currency)
		if err != nil {
			panic(err)
		}

		if currency.Code == usdCurrency {
			haveItem = true
			return false
		} else {
			return true // move on to the next document OR
		}
	})

	if !haveItem {
		docID, err := store.Insert(map[string]interface{}{currencyCode: usdCurrency})
		if err != nil {
			panic(err)
		}
		fmt.Println("Create currency Id: %v  %v", docID, usdCurrency)
	}
	fmt.Println("Currency %v created early", usdCurrency)
}

func InitializeCurrencies() {
	mydb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}
	CreateStore(currencyStoreName, mydb)
	currencyStore := mydb.Use(currencyStoreName)

	insertRubCurrency(currencyStore)
	insertUsdCurrency(currencyStore)

	defer mydb.Close()
}

func GetCurrencies() []*CurrencyDB {
	curencyStore := getDbCurrencyStore()
	currencies := make([]*CurrencyDB, 0)
	curencyStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var currency CurrencyDB
		err := json.Unmarshal(docContent, &currency)
		if err != nil {
			panic(err)
		}
		currencies = append(currencies, &currency)
		fmt.Println("Id: v% Code: %v", id, currency.Code)
		return true
	})
	return currencies
}
