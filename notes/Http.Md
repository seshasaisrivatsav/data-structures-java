## HTTP

- Request:  Messages sent by the client or Web browser
- Response: Messages sent by the server as an answer 
- TCP: Transmission Control Protocol - Lets 2 hosts connect and exchange data streams
- IP: Internet Protocol
- TLS: Transport Layer Security a.k.a SSL = protocol used by aps to communicate across network with security.
      - Both TLS and SSL are client/server protocos that ensure communication privacy

### Requests
### Methods
- Connect
- Delete
- Trace
- Options
- PUT
- PATCH
- GET
- POST 
- DELETE

#### Put v/s Post
The difference between PUT and POST is that PUT is idempotent:
 calling it once or several times successively has the same effect (that is no side effect), where successive
  identical POST may have additional effects, like passing an order several times.
### Headers

#### Cache-control
- header specifies directives for caching mechanism in requests and response
```
Cache-Control: no-store | no-cache
```
- no-store - doesn't cache
- no-cache - cache will send request to origin server for validation before releasing cached copy

### Status Codes


### Parsing data


### Cache
https://developer.mozilla.org/en-US/docs/Web/HTTP/Caching
- shared cache - ISP
- private cache - browser
- proxy cache
- gateway cache
- CDN
- reverse proxy cache

# java

## DTO: Data Transfer Object
- Used to transfer the data between classes and modules of your application. 
- DTO should only contain private fields for your data, getters, setters and constructors. 
- It is not recommended to add business logic methods to such classes, but it is OK to add some util methods.

## DAO: Data Access Object
- Encapsulate logic for retrieving, saving and updating data in storage]
- Table centric. DAOs match tables 

### DTO v/s DAO
```java

interface PersonDTO {
    String getName();
    void setName(String name);
    //.....
}
// DAO Table Centric
interface PersonDAO {
    PersonDTO findById(long id);
    void save(PersonDTO person);
    //.....
}


```
## Jackson Object Mapper
- `jackson-databind` dependency will also transitively add the following libraries to the classpath:
    -  jackson-annotations
    -  jackson-core
## DTO v/s DAO