# Photo Service

## About
Photo Service is a technical showcase for a position I applied for with Lean Techniques.

## Development
Be sure to have the following installed:  
* Java 8 (or greater)
* Maven
* Lombok

## Building

### Prerequisites
Be sure to have the following installed:  
* Java 8 (or greater)
* Maven

## Execute a Build
Run the following command from the project's root directory:
```sh
mvn clean install -DskipTests
```

## Running the tests
Run the following command from the project's root directory:
```sh
mvn clean test
```

## Execution
After successfully building the project, an executable `.jar` file should be available at `target/photoalbum-0.0.1-SNAPSHOT-jar-with-dependencies.jar` in the project directory.

Execute the jar by running:
```sh
java -jar photoalbum-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

**Usage**
```sh
Usage: photoalbum [albumId]

	[albumId] - (Optional) A numeric value to specify which photos (by album id) should be retrieved. 
```

**Examples**
```sh
$ java -jar target/photoalbum-0.0.1-SNAPSHOT-jar-with-dependencies.jar

[1] accusamus beatae ad facilis cum similique qui sunt
[2] reprehenderit est deserunt velit ipsam
[3] officia porro iure quia iusto qui ipsa ut modi
...
```

```sh
$ java -jar target/photoalbum-0.0.1-SNAPSHOT-jar-with-dependencies.jar 3

[101] incidunt alias vel enim
[102] eaque iste corporis tempora vero distinctio consequuntur nisi nesciunt
[103] et eius nisi in ut reprehenderit labore eum
...
```