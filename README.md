# globex-mobile-gateway

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev

or

quarkus dev
```


# Create Container image
```
./mvnw package

docker build -f src/main/docker/Dockerfile.jvm -t  quay.io/cloud-architecture-workshop/globex-mobile-gateway:<tag> .

docker push quay.io/cloud-architecture-workshop/globex-mobile-gateway:<tag> 
```
# Environment variables needed

GLOBEX_STORE_API_URL

KEYCLOAK_AUTH_SERVER_URL
