# ALBO - Library Marvel API

Java application that exposes an API and executes a scheduled task to update Marvel hero data.

## Installation

Run the assemble.sh saved in the root of this repo.

```bash
bash assemble.sh
```

## Usage

Run avengers.sh saved in the root of this repository to run the app on the server on port: 80

```bash
bash avengers.sh
```

## Swagger

Use localhost:80 or your exposed domain to access the API documentation

```
http://localhost:80/swagger-ui/index.html
```

## Sync Marvel Data

All days at 00.15 the scheduled task run to search new comics by hero
