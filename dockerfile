FROM java:8

WORKDIR /springMongo
ADD ./target/SpringWithMongo-0.0.1-SNAPSHOT.war /springMongo/SpringWithMongo-0.0.1-SNAPSHOT.war
EXPOSE 8081
CMD java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n,address=8000 -Dspring.data.mongodb.uri=mongodb://mongo/springwithmongo -jar SpringWithMongo-0.0.1-SNAPSHOT.war