FROM maven:latest

WORKDIR /app
COPY . /app

RUN mvn clean

CMD ["mvn", "clean", "test"]
