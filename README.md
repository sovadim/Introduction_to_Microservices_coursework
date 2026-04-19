# Introduction to Microservices coursework

## Running locally

1. Start the databases

From the project root:

```bash
docker compose up -d
```

This starts two PostgreSQL containers:
- `resource-db` on port `5432`
- `song-db` on port `5433`

2. Run the services

**Resource Service** (port 8081):
```bash
./gradlew :resource-service:bootRun
```

**Song Service** (port 8082):
```bash
./gradlew :song-service:bootRun
```

### 3. Stop the databases

```bash
docker compose down
```
