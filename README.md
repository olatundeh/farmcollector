# farmcollector
FarmCollector is a Spring Boot application designed to collect and manage agricultural data for farms. It allows farmers to record planting and harvesting information for each field and crop. The application generates reports on expected versus actual product yields for individual farms and crop types.
Installation
1. Clone the repository:
Bash
git clone https://github.com/olatundeh/farmcollector.git
2. Set up a Java development environment with JDK 17 or later.
3. Install required dependencies using Maven.
4. Configure database connection properties (replace placeholders with your database credentials):
Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/farmcollector
spring.datasource.username=your_username
spring.datasource.password=your_password
5. Build the project:
Bash
mvn clean install

**Usage**
Start the Spring Boot application.
Use the provided API endpoints to create, retrieve, update, and delete farm, field, crop, planted, and harvested data.
Access reports through the web interface.

**API Endpoints**
PlantedData Endpoints:
POST /plantedData
GET /plantedData
GET /plantedData/{id}
PUT /plantedData/{id}
DELETE /plantedData/{id}

HarvestedData Endpoints:
POST /harvestedData
GET /harvestedData
GET /harvestedData/{id}
PUT /harvestedData/{id}
DELETE /harvestedData/{id}

**Reports:**
GET /reports/farm/{farmId}/{season}
GET /reports/crop/{cropId}/{season}
Reports
Farm and crop reports are accessible through the web interface.

**Technologies:**
Spring Boot
Java 17
Spring Data JPA
H2 Database (in-memory, can be replaced)
Thymeleaf
