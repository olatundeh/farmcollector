# farmcollector
FarmCollector is a Spring Boot application designed to collect and manage agricultural data for farms. It allows farmers to record planting and harvesting information for each field and crop. The application generates reports on expected versus actual product yields for individual farms and crop types.<br /> 

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

**Usage**<br />
Start the Spring Boot application.
Use the provided API endpoints to create, retrieve, update, and delete farm, field, crop, planted, and harvested data.
Access reports through the web interface.

**API Endpoints**<br />
PlantedData Endpoints:<br />
POST /plantedData<br />
GET /plantedData<br />
GET /plantedData/{id}<br />
PUT /plantedData/{id}<br />
DELETE /plantedData/{id}<br />

HarvestedData Endpoints:
POST /harvestedData<br />
GET /harvestedData<br />
GET /harvestedData/{id}<br />
PUT /harvestedData/{id}<br />
DELETE /harvestedData/{id}<br />

**Reports:**
GET /reports/farm/{farmId}/{season}<br />
GET /reports/crop/{cropId}/{season}<br />
Reports
Farm and crop reports are accessible through the web interface.

**Technologies:**
Spring Boot
Java 17
Spring Data JPA
H2 Database (in-memory, can be replaced)
Thymeleaf
