# CoderHack

CoderHack is a RESTful API service using Spring Boot to manage the Leaderboard for a Coding Platform while using MongoDB to persist the data.

## Prerequisites
Before cloning and running this project, ensure you have the following installed on your local machine

1. **Java Development Kit (JDK) 17**: This project is developed using Java 17. You need to have JDK 17 installed.
Download and install the JDK from [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or adopt an OpenJDK variant like Adoptium.
2. **Gradle**
The project uses Gradle (Groovy DSL) for build automation. Ensure you have Gradle installed. Install Gradle by following the instructions on the Gradle website: [Installing Gradle](https://gradle.org/releases/).
3. **MongoDB**
MongoDB is used as the database for this project. Make sure MongoDB is installed and running on port 27017.
To install MongoDB, follow the guide on the MongoDB website: [Install MongoDB](https://www.mongodb.com/download-center/community).
After installation, ensure MongoDB is running. By default, MongoDB listens on port 27017.
4. **Git**
Git is required to clone the project repository.
If you haven't already, [install Git from Git Downloads](https://git-scm.com/download).
5. **IDE** of your choice (ex: IntelliJ, VS Code, Eclipse).
## Cloning the Repository

To clone the project repository, run the following command:

```bash
git clone https://github.com/SahithAlapati/coderHack.git
```
## Usage
Navigate to the project directory
``java
cd <your-repo-name>
```
To run the project, type following command in the project directory
```java
./gradlew clean build
```
## Using the API
Once the application is running, you can make requests to the API endpoints. Here are a few examples:
- **GET /users** - Retrieve a list of all registered users
- **GET /users/{userId}** - Retrieve the details of a specific user
- **POST /users** - Register a new user to the contest
- **PUT /users/{userId}** - Update the score of a specific user
- **DELETE /users/{userId}** - Deregister a specific user from the contest


For detailed API documentation, visit [API Documentation](https://elements.getpostman.com/redirect?entityId=33711622-1b0be232-93b7-43d0-ba48-9cd76e765cf7&entityType=collection).
