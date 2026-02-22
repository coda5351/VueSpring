# VueSpring Project

This repository holds the source code for the **VueSpring** application, a full-stack project combining a Spring Boot backend with a Vue.js frontend with basic JWT authentication.

## Structure

```
Entry.java                  # simple Java entry script
V1__create_entries_table.sql # initial database migration
spring/                     # backend application
  ├─ pom.xml                # Maven configuration
  ├─ src/main/java/com/vuespring # Java sources
  │  ├─ config/             # configuration classes
  │  ├─ controller/         # REST controllers
  │  ├─ dto/                # data transfer objects
  │  ├─ exception/          # custom exceptions
  │  ├─ handler/            # exception handlers
  │  ├─ model/              # JPA entity definitions
  │  ├─ repository/         # Spring Data repositories
  │  ├─ security/           # security config
  │  ├─ service/            # business logic services
  │  └─ util/               # utility classes
  └─ src/main/resources/    # application resources
      ├─ application*.properties
      └─ db/migration/      # Flyway migrations

vue/                        # frontend application (Vue 3 + Vite)
  ├─ package.json           # npm configuration
  ├─ vite.config.ts         # Vite build config
  ├─ src/                   # frontend source code
  │   ├─ components/        # reusable components (e.g. DataTable)
  │   ├─ pages/             # route-level views
  │   ├─ router.ts          # Vue Router setup
  │   ├─ store.ts           # Pinia store (or Vuex)
  │   └─ utils/             # helper utilities
  └─ public/                # static assets

```

## Getting Started

### Backend

1. Navigate to `spring/` and run with Maven:
   ```bash
   mvn spring-boot:run
   ```
2. The application uses Flyway for database migrations; the SQL files in `spring/src/main/resources/db/migration` are executed automatically.
3. `application-dev.properties` should contain these items

```
# Development Profile

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/vuespring
spring.datasource.username=<username>
spring.datasource.password=<password>

# JPA Configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080

# Static Resources
spring.web.resources.cache.period=0

# CORS
cors.allowed-origins=http://localhost:5173,http://localhost:8080

# JWT Configuration (5 minutes for development)
app.jwt.expiration.days=0
app.jwt.expiration.hours=10
app.jwt.expiration.minutes=0
```
4. `application-prod.properties` should contain these items

```
# Production Profile

# Database Configuration
# These should be set via environment variables in production
spring.datasource.url=${DATABASE_URL:jdbc:postgresql://host.docker.internal:5432/vuespring}
spring.datasource.username=${DATABASE_USERNAME:<username>}
spring.datasource.password=${DATABASE_PASSWORD:<password>}

# JPA Configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false

# Server Configuration
server.port=${PORT:8080}

# Static Resources
spring.web.resources.cache.period=3600

# CORS
cors.allowed-origins=${CORS_ALLOWED_ORIGINS:http://localhost}

# JWT Configuration (24 hours for production)
app.jwt.expiration.days=1
app.jwt.expiration.hours=0
app.jwt.expiration.minutes=0
```

### Frontend

1. Change to the `vue/` directory:
   ```bash
   cd vue
   npm install
   npm run dev
   ```
2. The development server runs on the default Vite port (5173); frontend calls the backend via configured API endpoints.

## Database

- Initial schema defined in `V1__create_entries_table.sql` (and duplicated under the Spring resources). Update migrations there when changing DB structure.

## Additional Details

- A `spring/docker-compose.yml` and `Dockerfile` exist for containerized setups.
- The frontend uses scoped CSS occasionally with `:deep()` for deep selectors.

## Notes

The core application is under `spring/` and `vue/`.

Feel free to extend this README with setup instructions, architectural diagrams, and deployment guides as the project evolves.
