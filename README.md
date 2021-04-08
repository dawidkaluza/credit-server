# Overview

Credit server is a simple multi-module project written in distributed architecture where every service is in its own 'dockerized' module.

I've used Docker to pack modules in containers.
Apart from services, also database is in its own container.

This web application provides very simple system to store history of clients' credits, more details are in a [practice example](#check-it-out).

# Used technologies

- Java 8
- PostgreSQL 10
- H2 database
- Docker
- Spring Boot, Spring Web, Spring Data
- Junit 5
- Spring Cloud Contract
- Fabric8 Docker maven plugin

# Check it out

If you have necessary Maven and Docker on your PC, you can check this application on your own.

1. Copy project via git clone

`git clone ....`

2. Open terminal in the dir where you cloned the project and run this simple maven command:

`mvn clean install docker:build docker:run`

Then all services, databases etc. will get ready to work.

3. When all containers will be finally launched, send a request to create a new credit, for example:

### Request
```
POST /credit
Content-Type: application/json

{
  "credit": {
    "creditName": "TV credit"
  },
  "customer": {
    "firstName": "Dawid",
    "surname": "Kałuża",
    "pesel": "12345678900"
  },
  "product": {
    "name": "TV",
    "value": 1200
  }
}
```
All fields above are necessary, but you can change them as you wish.

### Response
```
Content-Type: application/json

{
  "creditId": 1
}
```
Credit id is just a number of the created credit.

4. You can get all created credits via similar GET request:

#### Request
```
GET /credit
Content-Type: application/json
```

#### Response
```
Content-Type: application/json

[
  {
    "credit": {
      "creditName": "TV credit"
    },
    "customer": {
      "firstName": "Dawid",
      "surname": "Kałuża",
      "pesel": "12345678900"
    },
    "product": {
      "name": "TV",
      "value": 1200
    }
  }
]
```

In general, that's all. Very simple, but that's my first modularization via docker, anyway I think the whole project doesn't look so bad ^^