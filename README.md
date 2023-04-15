# Basic banking API

## How to run the app

Just run the app with your favorite IDE. You can reach the app at `localhost:8080`

## API details

- Make a deposit or withdrawal :
```
POST /operations
Body:
{
    "accountNumber": 123,
    "amount": 100,
    "operationType": "DEPOSIT" / "WITHDRAWAL"
}

Output:
{
    "id": "3c9834ff-78fb-46eb-b4ea-2eefa830de64",
    "amount": 10.0,
    "type": "DEPOSIT",
    "balance": 40.0,
    "createdDate": "2023-04-15T15:35:37.745704900Z"
}
```

- Get operation history :
```
GET /operations/123

Output:
[
    {
        "id": "3c9834ff-78fb-46eb-b4ea-2eefa830de64",
        "amount": 10.0,
        "type": "DEPOSIT",
        "balance": 40.0,
        "createdDate": "2023-04-15T15:35:37.745704900Z"
    },
    {
        "id": "5a29ed2a-4758-4a8f-806e-68f3b094a95d",
        "amount": 10.0,
        "type": "DEPOSIT",
        "balance": 30.0,
        "createdDate": "2023-04-15T15:35:37.339174300Z"
    }
]
```
