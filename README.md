# Basic banking API

## How to run the app

Just run the app with your favorite IDE. You can reach the app at `localhost:8080`

## API details

- Get or create an Account by account number and deposit or withdrawal money on it :
```
POST /accounts/{accountNumber}/operations
Body:
{
    "amount": 100,
    "operationType": "DEPOSIT" / "WITHDRAWAL"
}

Output:
{
    "id": "76d43d4b-5b05-4513-9fb5-92c2fbecd9bc",
    "amount": 100.0,
    "type": "DEPOSIT",
    "balance": 100.0,
    "createdDate": "2023-04-16T16:25:03.703332900Z"
}
```

- Get account operation history :
```
GET /accounts/{accountNumber}/operations

Output:
[
    {
        "id": "aa0eacd1-ad87-400f-b101-5e1cb7bbcf3b",
        "amount": 75.0,
        "type": "WITHDRAWAL",
        "balance": 25.0,
        "createdDate": "2023-04-16T16:25:38.483424Z"
    },
    {
        "id": "76d43d4b-5b05-4513-9fb5-92c2fbecd9bc",
        "amount": 100.0,
        "type": "DEPOSIT",
        "balance": 100.0,
        "createdDate": "2023-04-16T16:25:03.703332900Z"
    }
]
```
