curl -X POST localhost:8080/api/persons -d "{\"name\":\"Andres\",\"lastName\":\"Guzman\",\"age\":40,\"homeDirection\":\"SD\"}" -H "Content-Type: application/json"

curl localhost:8080/api/persons/1 | python -m json.tool

psql -d dbName -U user -W password