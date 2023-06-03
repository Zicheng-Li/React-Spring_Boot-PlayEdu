# React-Spring_Boot-PlayEdu
This is an open source project, originally sourced from PlayEdu. All modifications and translations are my own.  This project is released under the Apache 2.0 license, same as the original project.

# Overview
PlayEdu is an educational platform designed for enterprises and schools to conduct teaching activities. This project adopts a front-end and back-end separation design, where the front end utilizes React 18 and the back end is built with SpringBoot 3.

## Tech Stack

- Frontend: React 18, Node.js
- Backend: Java 17, SpringBoot 3
- Database: MySQL
- Other Technologies: Docker, MinIO, Redis, Hibernate, Maven, etc.

## Project Demo

Frontend Interface: 
![Frontend Interface](Put your image link here)

Backend Interface: 
![Backend Interface](Put your image link here)


## Quick Local Deployment

1. Download the source code.

2. Create a `playedu` database in MySQL and import all sql files in the `/playedu/databases/` directory.

3. Modify the MySQL service configuration in `application.yml`.

4. Set up MinIO (make sure Docker is installed before this step):

    ```bash
    docker run -p 9000:9000 -p 50000:50000 -d --name playedu-minio \
    -e "MINIO_ACCESS_KEY=username" \
    -e "MINIO_SECRET_KEY=password" \
    minio/minio server --console-address ":50000" /data
    ```

    After successful installation, you can access the MinIO management service at http://localhost/:50000. Username: username, password: password.
    After logging in, select Buckets, click the Create Bucket button, and then change the Access policy to public. Finally, remember to modify the MinIO service configuration in `application.yml`.

5. Install Redis (make sure Docker is installed):

    ```bash
    docker run -d -p 6379:6379 --name playedu-redis redis:latest
    ```

    Don't forget to modify the Redis service configuration in `application.yml`.

6. Deploy the frontend:

    - Download the source code from [for frontend](https://github.com/Zicheng-Li/PlayEdu-frontend).
    - Make sure Node.js and yarn are installed locally.
    - Run the following commands:

        ```bash
        cd playedu-backend && yarn
        cp .env.example .env.local
        nano .env.local  # Add VITE_APP_URL=http://127.0.0.1:9898
        yarn dev
        ```

    - Default account: admin@playedu.xyz, password: playedu

7. Deploy the backend:

    - Download the source code [for backend](https://github.com/Zicheng-Li/PlayEdu-backend.git).
    - Make sure Node.js and yarn are installed locally.
    - Run the following commands:

        ```bash
        cd playedu-backend && yarn
        cp .env.example .env.local
        nano .env.local  # Add VITE_APP_URL=http://127.0.0.1:9898
        yarn dev
        ```
