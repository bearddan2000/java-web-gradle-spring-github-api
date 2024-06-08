FROM gradle:jdk11

WORKDIR /app

ADD --chown=gradle:gradle bin .

ENTRYPOINT ["gradle"]

CMD ["build", "run"]

# CMD ["build", "test", "run"]
