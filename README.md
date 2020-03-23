# Spring Boot Server for API calls to Mongo Collections

# Swagger

> You can access both the API's on Swagger
```
http://localhost:8080/swagger-ui.html
```

## Run [In stock folder]

```
// Run mongoDB [DB from before][Flask]
mongod --dbpath ~/path/to/mphase/database

// Install Java 1.8 SDK and Maven 3.5.4
// To run server
 mvn spring-boot:run
```

## APIs

### GET

> Input : Page Number (page), Page Size (size), From Date (min), To Date (max)

> Output : Stocks according to input

* **URL**
  
  ```
  /stock?page=<number>&size=<number>&min=<dd-MMMM-yyyy>&max=<dd-MMMM-yyyy>
  ```

* **Method:**

  ```
  GET
  ```

* **Query Params**
  
  ```
  ?page=<number>&size=<number>&min=<dd-MMMM-yyyy>&max=<dd-MMMM-yyyy>
  ```

* **Success Response:**
  * ***Code:*** 200
* **Error Response:**
  * ***Code:*** 400 BAD REQUEST
* **Sample Call:**
  
  ```
  curl http://localhost:8080/stock?page=2&size=10&min=12-January-2020&max=16-January-2020
  ```

* **Sample Response:**
  ```
    [
      {
        date: "16-January-2020",
        openPrice: 105.05,
        highPrice: 106,
        lowPrice: 103.5,
        closePrice: 104.05,
        wap: 104.89035,
        deliverableQuantity: 99739,
        spreadHighLow: 2.5,
        spreadCloseOpen: -1,
        deliToTraded: 42.16,
        noOfTrades: 5746,
        noOfShares: 236554,
        totalTurnover: 24812232
      },
      {
        date: "15-January-2020",
        openPrice: 1,
        highPrice: 2,
        lowPrice: 3,
        closePrice: 48,
        wap: 104.24278,
        deliverableQuantity: 68019,
        spreadHighLow: 1.7,
        spreadCloseOpen: -0.6,
        deliToTraded: 31.49,
        noOfTrades: 5487,
        noOfShares: 216007,
        totalTurnover: 22517171
      },
      {
        date: "14-January-2020",
        openPrice: 104.15,
        highPrice: 106,
        lowPrice: 103.2,
        closePrice: 104.85,
        wap: 104.55748,
        deliverableQuantity: 101382,
        spreadHighLow: 2.8,
        spreadCloseOpen: 0.7,
        deliToTraded: 23.29,
        noOfTrades: 9323,
        noOfShares: 435297,
        totalTurnover: 45513556
      },
      {
        date: "13-January-2020",
        openPrice: 106.55,
        highPrice: 106.55,
        lowPrice: 103.7,
        closePrice: 104.15,
        wap: 104.518135,
        deliverableQuantity: 93246,
        spreadHighLow: 2.85,
        spreadCloseOpen: -2.4,
        deliToTraded: 34.46,
        noOfTrades: 3725,
        noOfShares: 270587,
        totalTurnover: 28281248
      }
    ]
  ```
  
  ### PUT

> Input : Stock JSON with updated price (open, close, high, low)

> Output : New stock JSON

* **URL**
  
  ```
  /stock
  ```

* **Method:**

  ```
  PUT
  ```
  
* **Success Response:**
  * ***Code:*** 200
* **Error Response:**
  * ***Code:*** 400 BAD REQUEST
* **Sample Call:**
  
  ```
  curl -X POST -H "Content-Type: application/json" -d '{ \
        "date": "15-January-2020", \
        "openPrice": 1, \
        "highPrice": 2, \
        "lowPrice": 3,  \
        "closePrice": 48, \
        "wap": 104.24278, \
        "deliverableQuantity": 68019, \
        "spreadHighLow": 1.7, \
        "spreadCloseOpen": -0.6,  \
        "deliToTraded": 31.49,  \
        "noOfTrades": 5487, \
        "noOfShares": 216007, \
        "totalTurnover": 22517171}' http://localhost:8080/stock
  ```

* **Sample Response:**
  ```
    {
      date: "15-January-2020",
      openPrice: 1,
      highPrice: 2,
      lowPrice: 3,
      closePrice: 48,
      wap: 104.24278,
      deliverableQuantity: 68019,
      spreadHighLow: 1.7,
      spreadCloseOpen: -0.6,
      deliToTraded: 31.49,
      noOfTrades: 5487,
      noOfShares: 216007,
      totalTurnover: 22517171
    }
  ```
