[//]: # ( =====preserve===== start-Introduction ===== )
# System

These templates are associated with the system or application as a whole.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`Microservice`](#microservice) | Generates the core microservice. |
| [`SpringBootApplicationPublisher`](#spring-boot-application-publisher) | This template generates the Spring Boot Application class used to start the application running. |

Each of the template files will be covered in more detail below.

<a name="microservice"></a>
## Microservice

Generates the following microservice classes: Model, DTO, Mapper, Repository, and Service. The database code generation can be done using the builtin Postgres transform.

| |References|
|---|---|
| **Domains** |`InMemoryCache` `Service` `Security` `Controller` `DTOMapper` `Exception` `Repository` `Utils` `Model` `Database` `JSONDTO` `ProtobufDTO` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`ControllerPublisher`](../controller) | This generates a controller class that has many normal CRUD operations along with asset upload operations. |
| [`DtoTemplate`](../dto) | This template generates the DTO classes for all entites in your space. |
| [`ExceptionTemplate`](../exception) | This template installs exception classes used to trigger the return status codes for REST endpoints. |
| [`MapperTemplate`](../mapper) | Generates code associated with mapping data from a JSON DTO to a Model and vice versa. |
| [`ModelTemplate`](../model) | This template builds what are called Model classes. |
| [`RepositoryPublisher`](../repository) | Generates code that interfaces model classes with the database. |
| [`ServicePublisher`](../service) | Generates the Spring Boot Service classes for all entities in your project space. |
| `SpringBootApplicationPublisher` | This template generates the Spring Boot Application class used to start the application running. |
| [`UtilsTemplate`](../util) |  |

<a name="spring-boot-application-publisher"></a>
## Spring Boot Application Publisher

This template generates the Spring Boot Application class used to start the application running.

### Publishers

#### `springboot.application`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `main` | This outlet is just inside the `main()` method of the class right before starting up the application.|


