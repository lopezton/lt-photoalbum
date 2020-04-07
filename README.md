# Photo Service

## About
Photo Service is a technical showcase for a position I applied for with Lean Techniques.

The application consumes a restful webservice and displays it's content to the console.

## Development
Be sure to have the following installed:
* Eclipse
  * Feel free to use whichever IDE you'd like. Instructions below will assume you are using Eclipse.
* JDK 13

## Building

### Prerequisites
Be sure to have the following installed:  
* JDK 13

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
After successfully building the project, an executable `.jar` file should be available at `target/photo-album.jar` in the project directory.

Execute the jar by running:
```sh
java -jar target/photo-album.jar
```

**Usage**  
```sh
Usage: photo-album [ALBUM_ID] [OPTION]...
Get photo information.

[ALBUM_ID]
    An integer value representing which album to retrieve.

[OPTION]

    -v, --verbose               See more content.
```

**Examples**  
```sh
$ java -jar target/photo-album.jar
...
[4998] qui quo cumque distinctio aut voluptas
[4999] in voluptate sit officia non nesciunt quis
[5000] error quasi sunt cupiditate voluptate ea odit beatae
```

```sh
$ java -jar target/photo-album.jar 1
...
[48] ut esse id
[49] quasi quae est modi quis quam in impedit
[50] et inventore quae ut tempore eius voluptatum
```