# RegEdit Backend Service

A microservices architecture system with central authentication.
Main components

 1.  RegEdit API gateway service: A Eureka server that will act as a central authentication unit, ZUUL proxy server for redirection.
 2.  RegEdit service: This will act as a eureka client, which receive a request from gateway service.

## Docker compose
You can run the RegEdit Backend Service as Docker containers using docker compose: 
```
[RegEdit_PATH]> docker-compose up
```

## Test the application 
You can test the application and explore the available services, linking to API documentation  by Swagger tools:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) 


## License
RegEdit Service is EUPL-licensed

