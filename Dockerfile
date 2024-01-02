FROM openjdk:17

EXPOSE 8080

COPY target/RotasVanApi-0.0.1-SNAPSHOT.jar RotasVanApi.jar
ENTRYPOINT ["java","-jar","/RotasVanApi.jar"]

# Gerar jar pulando testes: mvn package -DskipTests 