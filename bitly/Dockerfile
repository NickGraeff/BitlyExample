FROM openjdk:8-jdk-alpine
VOLUME /project
WORKDIR /project
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", \
            "-jar", \
            "target/gs-spring-boot-docker-0.1.0.jar"]