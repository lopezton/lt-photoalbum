# Photo Service

## About
Photo Service is a technical showcase for a position I applied for with Lean Techniques.

This application is built on [Spring Shell](https://projects.spring.io/spring-shell/).

## Development
Be sure to have the following installed:  
* Java 8 (or greater)
* Lombok

## Building

### Prerequisites
Be sure to have the following installed:  
* Java 8 (or greater)

## Execute a Build
Run the following command from the project's root directory:
```sh
$ ./mvnw clean install -DskipTests
```

## Running the tests
Run the following command from the project's root directory:
```sh
$ ./mvnw clean test
```

## Execution
After successfully building the project, an executable `.jar` file should be available at `target/photoalbum-0.0.1.jar` in the project directory.

Execute the jar by running:
```sh
java -jar target/photoalbum-0.0.1-SNAPSHOT.jar
```

**Usage**
```sh
$ photo-album> help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Photo Commands
        get: Retrieve all photo metadata from the system.
        get-by-album-id: Retrieve all photo metadata from the system.
```
```sh
$ photo-album> get

...
[4998] qui quo cumque distinctio aut voluptas
[4999] in voluptate sit officia non nesciunt quis
[5000] error quasi sunt cupiditate voluptate ea odit beatae
```