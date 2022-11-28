FROM amazoncorretto:17-alpine3.16-jdk

ENV JAVA_ENABLE_DEBUG=${JAVA_ENABLE_DEBUG}

COPY build/libs/myscrap-*-SNAPSHOT.jar myscrap.jar
COPY entrypoint.sh .

RUN addgroup --system --gid 1001 appuser && \
    adduser --system --ingroup appuser --uid 1001 appuser

RUN chown appuser:appuser myscrap.jar
RUN chmod 500 myscrap.jar
RUN chmod +x entrypoint.sh

EXPOSE 8080

USER 1001

CMD ["./entrypoint.sh"]
