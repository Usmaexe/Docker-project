# 1. Utiliser une image officielle Maven avec Eclipse Temurin JDK 23 basé sur Alpine pour la construction
FROM maven:3.9.9-eclipse-temurin-23-alpine AS build

# 2. Définir un répertoire de travail pour la construction de l'application
WORKDIR /app

# 3. Copier uniquement les fichiers nécessaires à la construction de l'application
COPY pom.xml /app/
COPY src /app/src/

# 4. Télécharger les dépendances Maven et construire l'application
RUN mvn clean install -DskipTests

# 5. Créer l'image finale en utilisant Eclipse Temurin JRE 23 basé sur Alpine
FROM eclipse-temurin:23-jre-alpine

# 6. Ajouter un utilisateur non-admin pour des raisons de sécurité
RUN addgroup -S spring && adduser -S spring -G spring

# 7. Définir un répertoire de travail pour l'exécution de l'application
WORKDIR /app

# 8. Copier le fichier JAR construit depuis l'étape précédente
COPY --from=build /app/target/*.jar /app/backend.jar

# 9. Changer les permissions et utiliser l'utilisateur non-admin
RUN chown -R spring:spring /app
USER spring

# 10. Exposer le port de l'application (par défaut 8080)
EXPOSE 8080

# 11. Lancer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "backend.jar"]
