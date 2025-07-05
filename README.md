# Blog Project

This repository contains a simple blog application with a Spring Boot backend and a Next.js frontend.

## Backend

The backend is located in the `server` directory and uses Spring Boot 3, MyBatis-Plus and SQLite. It exposes REST APIs for managing articles, categories, tags, comments and users. JWT is used for authentication.

To run the backend:

```bash
cd server
./gradlew bootRun
```

## Frontend

The frontend is located in the `web` directory and built with Next.js and Ant Design.

Install dependencies and run the development server:

```bash
cd web
npm install
npm run dev
```

The application will fetch articles from the backend running on `http://localhost:8080`.
