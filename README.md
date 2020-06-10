# directory-service
Directory Service APIs

Directory service has two APIs
--------------------------------------------------------
##### List files in given directory
```ssh
curl http://localhost:8080/listFiles?directoryPath=/home/sreemanth/projects/github/directory-service
```

##### Get file information for given file
```ssh
http://localhost:8080/getFileInformation?fileName=/home/sreemanth/projects/github/directory-service/pom.xml
```
### Development instructions
-----------------------------------

##### Build project

```sh
mvn clean install -DskipTests=true
```

##### Run project 
```sh
java -jar target/directory-service-0.0.1-SNAPSHOT.jar
```

### Assumptions

1. Deployement/Server user has access to underlying file system.
2. java.policy configuration file should have default permissions.

