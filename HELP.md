# Run application on startup


## Start postgres docker

```bash
docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres:11.8
```

## Run all tests

```bash
mvn clean verify -Dspring.profiles.active=it  
```