# Utilizza un'immagine base di Java
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro all'interno del container
WORKDIR /app

# Copia il file JAR nella directory di lavoro
COPY target/elasticSearchSpring-0.0.1-SNAPSHOT.jar app.jar

# Imposta la variabile d'ambiente per Spring (opzionale, se hai bisogno di variabili come il profilo attivo)
# ENV SPRING_PROFILES_ACTIVE=prod

# Espone la porta 8080 utilizzata dall'applicazione Spring Boot
EXPOSE 8080

# Comando per eseguire l'applicazione Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

# Opzionale: Se vuoi aggiungere variabili di ambiente per il profilo Spring Boot
ENV SPRING_PROFILES_ACTIVE=prod