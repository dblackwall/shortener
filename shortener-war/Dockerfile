FROM tomcat:8-jre8

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh

COPY ./target/shortener-war-0.1-SNAPSHOT.war /usr/local/tomcat/webapps/shortener-war-0.1-SNAPSHOT.war
COPY ./target/tomcat/lib/postgresql-42.2.9.jar /usr/local/tomcat/lib/postgresql-42.2.9.jar
COPY context.xml /usr/local/tomcat/conf/context.xml

CMD ["catalina.sh", "run"]  
