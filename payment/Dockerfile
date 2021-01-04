FROM openjdk:15
COPY target/payment*.jar /opt/payment.jar
WORKDIR /opt
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "payment.jar"]