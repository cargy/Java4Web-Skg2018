# Web App Project Skeleton

That's a web app skeleton provided as a suggestion for your second project assignment. 
It's basicaly a Spring Boot project with Web, JPA, etc. that serves the front-end as 
static assets `/resources/static/` and provides the models, repos, controlles for the back-end `/main/java/org/regeneration`.

## Sample book entity implementation

The project creates an H2 in-memory repository and populates some sample data (`LoadDatabase.java`) in the database. 
That's very helpful during developement as data are always re-created upon startup.

There is a sample implementation of the user page (`/pages/user/index.html`) that uses JQuery to retrieve Books 
and display them.

The `BookController` implements a CRUD API that uses the `BookReppository` to manipulate data in the database.

## Running the project

That's a maven Spring Boot application so you can run it like that.

```
$ mvn spring-boot:run
```

After the server is up with the following URL with your browser.

```
http://localhost:8080
```
Login as `user` with password `user`. The user's home page will list some books. Selecting a book should filling the form below.
