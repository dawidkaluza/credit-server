FROM openjdk:8-alpine
ENV SPRING_DATASOURCE_URL="jdbc:postgresql://credit-server-db:5432/product"
ENV SPRING_DATASOURCE_USERNAME=developer
ENV SPRING_DATASOURCE_PASSWORD=developer
ENV SPRING_JPA_DATABASE_PLATFORM="org.hibernate.dialect.PostgreSQLDialect"
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
COPY target/product-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
