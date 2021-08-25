# Using embedded mongo for unit/integration testing in spring boot application

Just adding the following dependency to your spring boot application will replace the actual mongodb server with an embedded server:

```xml
<dependency>
    <groupId>de.flapdoodle.embed</groupId>
    <artifactId>de.flapdoodle.embed.mongo</artifactId>
    <scope>test</scope>
</dependency>
```

Two tests:

1. MongodbTestDemoApplicationTests.java
    - tests by mocking MongoRepository
2. MongoTemplateTests.java
    - tests by autowiring MongoTemplate

When you are running `mvn test` command, make sure to stop your mongodb server, as the tests use embedded mongodb server.
