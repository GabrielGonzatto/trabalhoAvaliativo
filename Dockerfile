FROM openjdk:19

ADD target/trabalhoAvaliativo.jar trabalhoAvaliativo.jar

COPY src/main/resources/db.migration/V1__create-tables-oficina.sql /docker-entrypoint-initdb.d/
COPY src/main/resources/db.migration/V2__insert-tables-oficina.sql /docker-entrypoint-initdb.d/

ENTRYPOINT ["java", "-jar","trabalhoAvaliativo.jar"]

EXPOSE 8080