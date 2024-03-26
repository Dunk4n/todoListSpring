# TodoListSpring

_A simple Todo list application with an API built using Spring Boot_

## Installation:

create a file `.env` at the root of the project with:
```sh
MYSQLDB_USER=todo_list_user
MYSQLDB_DATABASE=todo_list_db
MYSQLDB_PASSWORD=123456
MYSQLDB_ROOT_PASSWORD=root
MYSQLDB_DOCKER_PORT=3306
```

## Usage:
run the project
* `docker compose up`
* go to `http://localhost:9000`

stop the project
* `docker compose down -v`
