FROM openjdk:11-jre-slim

ARG JAR_FILEPATH
ARG JAR_FILENAME
ENV JAR_FILE=${JAR_FILENAME}

ADD ${JAR_FILEPATH}/${JAR_FILENAME} /usr/local/app/${JAR_FILENAME}


RUN echo "java -jar -Dspring.profiles.active=prod /usr/local/app/${JAR_FILE}" > /usr/local/app/entrypoint.sh

ENTRYPOINT ["/bin/bash", "/usr/local/app/entrypoint.sh"]