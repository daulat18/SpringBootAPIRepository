
Application start order:
1)ApiApplication.java (Eureka server)
2)DepartmentApplication.java
3)UserMicroserviceApplication.java
4)GatewayApplication.java  (Cloud gateway)

UService:

1)RestTemplate to communicate department fetch depart based on user id.
GET:
http://127.0.0.1:8081/api/users/userwithdept/1

2)Add New USer
POST:
http://127.0.0.1:8081/api/users

GateWay:for user service:http://localhost:8761/
EUreka service/server url
http://127.0.0.1:8080/api/users/


Body:{"id":2,"firstName":"Daulat","lastName":"Bachhav","email":"db@gmail.com","departmentId":"18"}

2)Test department service:
GET
http://127.0.0.1:8082/department/api/18

POST:
http://127.0.0.1:8082/department/api/
Body:{"id":21,"departmentName":"Computer","departmentAddress":"Pune","departmentCode":"19"}