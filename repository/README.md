[//]: # ( =====preserve===== start-Introduction ===== )
# Repository

The repository classes are used to transfer data contained in the model classes to and from the database. These templates synthesize the code associated with this.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`RepositoryPublisher`](#repository-publisher) | Generates code that interfaces model classes with the database. |

Each of the template files will be covered in more detail below.

<a name="repository-publisher"></a>
## Repository Publisher

Generates code that interfaces model classes with the database.

| |References|
|---|---|
| **Domains** |`Repository` `InMemoryCache` `Model` `Database` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`ReleaseFunctions`](../release) | This template has functions specific for detecting and extracting information about a release management structure. |
| [`RepositoryAssociationAuthor`](authors) | This template contains the authors that are responsible for generating repository methods for maintaining many-to-many (association) relationships between objects. |
| [`RepositoryCacheAuthor`](authors) | Generates code inside the methods of the Repository class to implement in-memory caching. |
| [`RepositoryDeleteAuthor`](authors) | This template contains the authors that are responsible for generating the delete object repository methods. |
| [`RepositoryGetAuthor`](authors) | This template contains the authors that are responsible for generating the get object repository methods. |
| [`RepositorySaveAuthor`](authors) | This template contains the author that is responsible for generating the save object repository method. |
| [`SecurityFunctions`](../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entityc.springboot.repository`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `veryTop` | This is above all the loops so you can loop through all the entities here if you want.|
| `members` | This is the top section of the class where member variables typically are placed.|
| `methods` | This outlet is where authors place the build of generated code. Some of these authors may also be publishers to give access to specific methods.|


