# Sorting service

first of all, build the application on your local computer

```
mvn clean install
```

run the application with one of the following opportunity

* ```mvn spring-boot:run```
* Running the application in a containarised way

create a docker image

use the following command from project`s root directory

```
docker build --no-cache -t localsortingservice .
```

run the application:

```
docker run --rm -it -p 8080:8080 localsortingservice
```

# example request

postman collection attached: [sortingservice.postman_collection.json](sortingservice.postman_collection.json)

```
curl -s --location --request POST 'http://localhost:8080/sortRequest' --header 'Content-Type: application/json' --data-raw '{
  "sortKeys": [
    "fruits",
    "numbers",
    "languages"
  ],
  "payload": {
    "fruits": [
      "watermelon",
      "apple",
      "pineapple"
    ],
    "numbers": [
      1333,
      4,
      2431,
      7
    ],
    "colors": [
      "green",
      "blue",
      "yellow"
    ],
    "languages": [
      "Hungarian",
      "English",
      "Arabic",
      "German"
    ]
  }
}'
```

# example response
```
{
  "fruits": [
    "apple",
    "pineapple",
    "watermelon"
  ],
  "numbers": [
    4,
    7,
    1333,
    2431
  ],
  "colors": [
    "green",
    "blue",
    "yellow"
  ],
  "languages": [
    "Arabic",
    "English",
    "German",
    "Hungarian"
  ]
}
```


