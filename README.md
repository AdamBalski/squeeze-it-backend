# (Squeeze it) makes links small again

### To run with squeeze-it-frontend change @CrossOrigin's 'origins' attribute to `{"http://localhost:80", "http://localhost"}`. You have to tweak 'squeeze-it-frontend' a little, but how to do that is said in its README.md.


### To build
```shell
mvn clean verify
```

### To run
Open a `*.jar` file in target directory


### To make a docker image (after 'To build')
```shell
docker build -t squeeze-it-backend:latest -t squeeze-it-backend:{{VERSION}} .
```
When running not in path where the 'Dockerfile' is then change '.' to 'path/to/Dockerfile'.
I recommend VERSION to be the same as in pom.xml (`<version>` markup which should be directly inside of `<project>` markup)


### To run the docker image
```shell
docker run -d --name squeeze-it-backend -p {{PORT}}:8080 squeeze-it-backend
```
PORT is a port you want to access api by, for example when running on the docker image on localhost and running on port 8080, then you can access api by 'localhost:8080/path'.