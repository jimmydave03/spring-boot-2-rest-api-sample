# spring-boot-2-rest-api-sample

Spring boot 2 rest api sample with basic crud operation. Here we are creating below 5 operations.

1) POST   : /student    : Save student into database.
2) GET    : /student    : Get list of all saved students.
3) GET    : /student/1  : Get single student by student id.
4) PUT    : /student/1  : Update student object.
5) DELETE : /student/1  : Delete student from database.

To run the application.

mvn spring-boot:run

Default port is 8080. But you can change by adding below line in application.properties file. 

server.port=8096

In this example we are using H2 db as datasource. If you want to use Mysql then put below config in properties file.

spring.jpa.database=default
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.datasource.jdbcUrl = jdbc:mysql://localhost:3306/StudentDB?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=false
spring.datasource.username = root
spring.datasource.password = root

Enjoy coding!!
