FROM openjdk:15
COPY target/account*.jar /opt/account.jar
WORKDIR /opt
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "account.jar"]