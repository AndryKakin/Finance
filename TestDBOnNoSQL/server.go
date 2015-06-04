package main

import (
	"fmt"
	"net/http"
	"os"
	"strconv"
	"encoding/json"
	
	"code.google.com/p/go.net/websocket"
)

type Product struct {
    Id 			int
    Name 		string
    Description string
    Bitmap      []byte
}

func ListenProductManage(ws *websocket.Conn) {
	fmt.Println("Echoing")

	var reply string
	error := websocket.Message.Receive(ws, &reply)
	checkError(error)
	
	var backResult Product
	error = json.Unmarshal([]byte(reply),&backResult)
	checkError(error)
	
	fmt.Println("Received back from client:")
	fmt.Println("Id          : " + strconv.Itoa(backResult.Id))
	fmt.Println("Name        : " + backResult.Name)
	fmt.Println("Description : " + backResult.Description)
	fmt.Println(reply)
	
}

func ServerGo() {
	fmt.Println("Web server start...");
	http.Handle("/Products", websocket.Handler(ListenProductManage))
	err := http.ListenAndServe(":6464", nil)
	checkError(err)
}

func checkError(err error) {
	if err != nil {
		fmt.Println("Fatal error ", err.Error())
		os.Exit(1)
	}
}