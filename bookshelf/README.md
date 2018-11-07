# The bookshelf project

The "bookshelf project" purpose is to introduce you to Spring persistence concepts.

## Configuration

In order to run the project you should first configure the connection
properties with the database.

1. Rename `application.properties.sample` under resources to
   `application.properties`

2. Edit `application.properties` and fill in the corresponding details to
   connect to your database

```
spring.datasource.url=jdbc:mysql://localhost:3306/bookshelf
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto=create
```
