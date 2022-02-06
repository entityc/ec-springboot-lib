[//]: # ( =====preserve===== start-Introduction ===== )
# Service

Service classes contain the business logic for the server application. These templates are used to synthesize the
service classes.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`ServicePublisher`](#service-publisher) | Generates the Spring Boot Service classes for all entities in your project space. |

Each of the template files will be covered in more detail below.

<a name="service-publisher"></a>
## Service Publisher

Generates the Spring Boot Service classes for all entities in your project space. It has a base service class publisher and imports a basic set of authors but can be easily expanded to support many other features.

| |References|
|---|---|
| **Domains** |`Repository` `Model` `Service` `JSONDTO` `Security` `APIPath` `DTOMapper` |

### Imported Templates

| Name | Description |
|---|---|
| [`ServiceBaseAuthor`](authors) | The authors in this template add a baseline of template code to the service publisher. |
| [`ServiceCRUDAuthors`](authors) | This template simply imports the CRUD authors that are basic to the application. |
| [`ServiceUploadAuthor`](authors) |  |

### Publishers

#### `org.entityc.springboot.service`

This publisher ultimately builds the Service classes for the Spring Boot application but it relies on many authors to fill it out with methods required to implement the application.

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `moduleLoopTop` | This is just inside the module foreach. An author could use this to filter out modules, for instance.|
| `entityLoopTop` | This is just inside the entity foreach. An author could use this to filter out entities, for instance.|
| `commentHeader` | This outlet simply allows you to place comments at the top of the source file.|
| `classAnnotation` | This allows an author to add an annotation to the class definition.|
| `members` | This is the top section of the class where member variables typically are placed.|
| `constructor` | The constructor outlet lets you replace the simple constructor with one that supports other functions such as auto wired objects.|
| `methods` | This outlet is where authors place the build of generated code. Some of these authors may also be publishers to give access to specific methods.|


