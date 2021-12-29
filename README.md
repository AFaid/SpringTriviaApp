# SpringTriviaApp
A trivia web application created for the purposes of learning Spring, Springboot, SpringMVC and Spring Data JPA

# Running/Installation Instructions
SpringTriviaApp is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line (it should work just as well with Java 8, 11 or 17):

```
git clone https://github.com/AFaid/SpringTriviaApp
cd SpringTriviaApp
./mvnw package
java -jar target/*.jar
```

You can then access web app here: http://localhost:8080/

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

# Warnings
- The application communicates with a free to use API to retrieve the questions which may on rare occassion temporarily crash or reject the request.
- The details of the application have not been completely flushed out as this application was done as a learning project mostly so there are some bugs to be found.
