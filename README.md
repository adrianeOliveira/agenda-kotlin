# agenda-kotlin

Após iniciar a aplicação é possível realizar os seguintes métodos:

POST
```
curl -X POST -H "Content-Type: application/json" -d '{"name": "Novo Contato","phoneNumber": "123456","active": true,"items": [{"emailAddress": "novo@email.com"}]}' localhost:8080/contacts
```

GET
```
curl -X GET localhost:8080/contacts | jq
curl -X GET localhost:8080/contacts/{contactId} | jq
```