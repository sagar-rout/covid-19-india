## Start postgres docker
```bash
docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres:11.8
```

## create docker image 
```bash
docker build -t covid-19-india .
```

## Deploy application using docker
```bash
docker run -d --network host covid-19-india 
```

## Authenticate server 
*In case you are using private repo*
```bash
cat ~/access_token.txt | docker login https://docker.pkg.github.com -u USERNAME --password-stdin # To access private github registry
```