FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY build/libs/agendador-tarefas.jar agendador-tarefas.jar
EXPOSE 9092
CMD ["java", "-jar", "agendador-tarefas.jar"]