# Blogging_api

This project is developed on  Spring-Boot framework. The main objective of this Web services application is to provide backend API's to the frontend people to utilize it and make a good interactive Blogging website ,where user can write blogs ,comments on posts and all those good stuffs.


## Tech Stack and Tools
- Java
- Spring Boot Framework
- Spring Data JPA
- Hibernate
- MySQL
- Lombok

## ER- Diagram


## Modules
- Login Module
- User module
- Category module
- Post module
- Photo upload to post module


## User Features:
 - User can register themselves with the application.
 - User can login 
 - Create post Category wise
 - Add image to that particular post
 - Add comments to post
 - Count number of total posts
 - Search post by specific keyword
  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
server.port=8888

#db configururation

spring.datasource.url=jdbc:mysql://localhost:3306/blogging
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root

spring.datasource.password=root

spring.jpa.properties.hibernates=org.hibernate.dialect.MySQL8Dialect



spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

project.image=image/
```
## API Root Endpoint
```
https://localhost:8888/api/post
```



