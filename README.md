# WebSevices_Labb2

## Soda (Oscar)

### endpoints

getall: localhost:8080/sodas

create: localhost:8080/sodas

###

## Fish (Christian)

### endpoints

getall: localhost:8080/fishes

create: localhost:8080/fishes

###

### Run command:

```
docker run -e MONGO_USERNAME:mongoadmin -e MONGO_PASSWORD:secret -e MONGO_HOST=mongodb -e MONGO_PORT=27017 -p 8080:8080 --network mongo-network webservices_labb2:latest
```

```
./mvnw package -Dpackaging=docker-native -Pgraalvm
```

###

## Projektet gjort av:

Oscar Eriksson Stjernfeldt & Christian Löfqvist