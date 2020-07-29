# Development and Deployment

## Local Development 

### Start postgres locally
```bash
docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres:11.8
```

### create docker image 
```bash
docker build -t covid-19-india .
```

### Deploy application using docker
Using github [maven workflow](.github/workflows/maven.yml) for the deployment.

### Authenticate server 
*In case you are using private repo, Get the access token from github*
```bash
cat ~/access_token.txt | docker login https://docker.pkg.github.com -u USERNAME --password-stdin # To access private github registry
```