FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/EMPLOYEE_MANAGEMENT_SYSTEM-0.0.1-SNAPSHOT.jar EMPLOYEE_MANAGEMENT_SYSTEM.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","EMPLOYEE_MANAGEMENT_SYSTEM.jar"]