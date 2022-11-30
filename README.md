# TODO Project title and some description

# Local setup

## Pre-requisites

* JDK amazoncorretto 17
* Docker

## Commands

### `gradlew bootRun`

Builds source code if necessary and starts spring boot server on `8080` port

### `gradlew bootRun --args='--spring.profiles.active=local'`

- Builds source code if necessary, sets the active profile and starts spring boot server on `8080` port
- Active profile local is for local development
### `gradlew clean build`

Cleans all build files and executes all build, lint, test tasks

### `gradlew test`

Executes project tests


## IntelliJ IDEA

### Set the active profiles:
- Go to "Run" - "Edit Configurations..." - Select "Spring Boot" and expand the arrow - Select "InterviewingApplication" - find field "Active profiles:" and set it to "local" (for local development)

### Import common CodeStyle.xml file for unified code style format

- Go to "File" - "Settings..." - Editor - Code Style - "Gear Icon" - Import - CodeStyle.xml

## Database

### Launching PostgreSQL database with Docker container:

- ###  launch and init db
  `docker-compose up -d`

- ###  recreate db / cleanup
  `docker-compose down -v && docker-compose up -d`


###H2 embedded database

Application is currently using an embedded database H2 for integration tests

