# analytics

Analytics is a Spring Boot application that receives POST request from [Andy](https://github.com/cse1110/andy) and stores them in a database for visualizations using [Redash](https://redash.io).

## Docker

### Install

Install [Docker Engine](https://docs.docker.com/engine/install/) and [Docker Compose](https://docs.docker.com/composeinstall/).

Clone the repository.

Make a directory called `postgres-data`.

Create a file called `env` and put following variables.

```
PYTHONUNBUFFERED=0
REDASH_LOG_LEVEL=INFO
REDASH_REDIS_URL=redis://redis:6379/0
POSTGRES_PASSWORD=<your database password>
REDASH_COOKIE_SECRET=<your cookie secret>
REDASH_SECRET_KEY=<your secret key>
REDASH_DATABASE_URL=postgresql://postgres:<your database password>@postgres/postgres
```

Run `docker-compose run --rm server create_db`.

Run `docker-compose run --rm postgres psql -h postgres -U postgres -c "CREATE DATABASE analytics;"`.

### Deploy

Run `docker-compose up -d`.
