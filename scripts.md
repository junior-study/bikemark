# Scripts
Here, I memo scripts that I have used during development.

## MySQL

### Run MySQL Container
```
docker run --name ndb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass -d mysql:5.7
```

This cmdlet will create MySQL instance so that you can connect to a database with:
* database: testdb
* username: root
* password: admin007!
* post: 3306

### Getting into the MySQL container
```
docker exec -it ndb bash
```

Then you will see the containers bash as a root user.

### Connect to a database

```
mysql -u root -p testdb
```

## application.properties

### Datasource
```
spring.datasource.username=root
spring.datasource.password=admin007!
spring.datasource.url=jdbc:postgresql://localhost:3306/testdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Hibernate
```
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.format_sql=true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### Test Database
```
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
```