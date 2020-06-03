# Win:G API

## 👨‍💻사용한 기술
- Spring Boot
- MySQL (AWS RDS)

## 무슨 기능?
- Win:G 프로젝트의 유저, 가수, 앨범, 곡, 공연, 결제 정보를 제공합니다.

## applicaion.properties 는 어디에?
- 아래 양식대로 사용했습니다. 빈칸으로 둔 곳은 DB 주소와 계정 정보입니다.

```
spring.jpa.database=mysql
spring.jpa.show-sql=true
spring.datasource.url=빈칸 <-
spring.datasource.username=빈칸 <-
spring.datasource.password=빈칸 <-
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.devtools.add-properties=false
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
logging.level.web=DEBUG
```
