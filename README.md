#Star Wars Character Service

This is the completed working demo from DataStax Accelerate 2019

## bin directory
* Requires https://github.com/fpmoles/demo-utilities
`setup.sh` copies the creds.zip to the active project and imports the schema and data to the database 
_Note: This is setup for my demo structure, you will need to adjust to your uses_

## Usage
1. Requires https://github.com/fpmoles/spring-boot-starter-dse to be installed
2. Requires JDK 1.8
3. Requires MVN
4. Requires creds.zip from Constellation to be downloaded to /src/main/resources

* execute `mvn clean package` in source directory
* execute `java -jar ./target/starwars-character-service-1.0.0-SNAPSHOT.jar` or run main method via IDE
