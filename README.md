# (Squeeze it) makes links small again

### To build
```shell
mvn clean verify
```

### To run
Open a `*.jar` file in target directory


### To make docker image (after 'To build')
```shell
docker build -t squeeze-it-backend:latest -t squeeze-it-backend:{{VERSION}} .
```
When running not in path where the 'Dockerfile' is then change '.' to 'path/to/Dockerfile'.
I reccomend VERSION to be the same as in pom.xml (`<version>` markup which should be directly inside of `<project>` markup)


### To run the docker image
```shell
docker run -d --name squeeze-it-backend -p {{PORT}}:8080 squeeze-it-backend
```
PORT is a port you want to access api by, for example when running on the docker image on localhost and running on port 8080, then you can access api by 'localhost:8080/path'.

