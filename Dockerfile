# =========================
# STAGE 1 - BUILD
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia apenas o pom para cachear dependências
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Copia o código e compila
COPY src ./src
RUN mvn -q -DskipTests package


# =========================
# STAGE 2 - RUNTIME
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/user-management-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
