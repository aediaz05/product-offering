# Product Offering Service

POC Rest API Using SprintBoot that allow you search product prices using specific filters 

## Status: WIP

**At this point, we're developing or accepting new features or even fixing bugs.**

## How to run
a) If you are using Maven, you can run the application using **mvn spring-boot:run**.
```
mvn spring-boot:run
```

b) You can build the JAR file and run it typing:
```
mvn clean package
java -jar target/product-offering.jar
```

c) You can build a Docker imagen and then run container typing:
```
mvn clean package
mvn dockerfile:build
docker run --name product-offering -p 8080:8080 -d ar.com.mycompany/product-offering:0.0.1-SNAPSHOT
```

## Rest API 
After deploy, you can check the [Rest API Documentation](http://localhost:8080/swagger-ui.html)