[//]: # ( =====preserve===== start-Introduction ===== )
# Authors

The generation of the repository class is accomplished with a single publisher (with various outlets) and a separate author for the various different types of operations. This directory contains the authors.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`RepositoryAssociationAuthor`](#repository-association-author) | This template contains the authors that are responsible for generating repository methods for maintaining many-to-many (association) relationships between objects. |
| [`RepositoryCacheAuthor`](#repository-cache-author) | Generates code inside the methods of the Repository class to implement in-memory caching. |
| [`RepositoryDeleteAuthor`](#repository-delete-author) | This template contains the authors that are responsible for generating the delete object repository methods. |
| [`RepositoryGetAuthor`](#repository-get-author) | This template contains the authors that are responsible for generating the get object repository methods. |
| [`RepositoryReleaseAuthor`](#repository-release-author) | (NEEDS WORK) This template contains the authors that are responsible for generating repository methods associated with release and version management. |
| [`RepositorySaveAuthor`](#repository-save-author) | This template contains the author that is responsible for generating the save object repository method. |

Each of the template files will be covered in more detail below.

<a name="repository-association-author"></a>
## Repository Association Author

This template contains the authors that are responsible for generating repository methods for maintaining many-to-many (association) relationships between objects.

| |References|
|---|---|
| **Tags** |`internal:many-to-many` |
| **Domains** |`Database` `Model` |

### Authors

#### To Publisher: `org.entitycompiler.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds methods for adding and removing a single association, checking a specific association and getting all associations.|Connect|Author|


<a name="repository-cache-author"></a>
## Repository Cache Author

Generates code inside the methods of the Repository class to implement in-memory caching. The caching code is generated based on information annotated in the `InMemoryCache` domain.

| |References|
|---|---|
| **Tags** |`enable` |
| **Domains** |`InMemoryCache` `Model` |

### Authors

#### To Publisher: `org.entitycompiler.springboot`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `members` | This declares the member variables for the cache objects themselves - one for each relationship involved.|Initial|Author|
| `postSave` | After an object is saved, this will place the newly updated object back in the cache.|Connect|Author|
| `preGet` | Looks for the object in the cache and sets `responseObject` to that if found.|Connect|Author|
| `postGet` | Looks for the object in the cache and sets `responseObject` to that if found.|Connect|Author|


<a name="repository-delete-author"></a>
## Repository Delete Author

This template contains the authors that are responsible for generating the delete object repository methods.

| |References|
|---|---|
| **Domains** |`Database` |

### Authors

#### To Publisher: `org.entitycompiler.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds delete by parent relationship method.|Connect|Author|


<a name="repository-get-author"></a>
## Repository Get Author

This template contains the authors that are responsible for generating the get object repository methods.

| |References|
|---|---|
| **Tags** |`release:lock` `sort:desc` `sort:asc` |
| **Domains** |`Model` `Database` |

### Publishers

#### `org.entitycompiler.springboot.repository.get`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `preGet` | This is right **before** the object is fetched from the repository by its ID (in variable `id`).|
| `postGet` | This is right **after** the object was fetched from the repository by its ID (object in variable `object`).|


### Authors

#### To Publisher: `org.entitycompiler.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds many get methods from get by ID to getting lists by parent relationships.|Connect|Author|


<a name="repository-release-author"></a>
## Repository Release Author

(NEEDS WORK) This template contains the authors that are responsible for generating repository methods associated with release and version management.

| |References|
|---|---|
| **Tags** |`release:lock` `release:version` `release:binder` `release:retired` `release:top` |
| **Domains** |`Database` `Model` |

### Authors

#### To Publisher: `org.entitycompiler.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds method associated with release management that use native database queries to speed up the endpoints that support release management.|Connect|Author|


<a name="repository-save-author"></a>
## Repository Save Author

This template contains the author that is responsible for generating the save object repository method.

### Publishers

#### `org.entitycompiler.springboot.repository.save`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `preSave` | This is right **before** the object (in variable `object`) is saved to the repository.|
| `postSave` | This is right **after** the object is saved to the repository (as variable `savedObject`).|


### Authors

#### To Publisher: `org.entitycompiler.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Simply adds a method to override an inherited save method so that outlets can be added.|Connect|Author|


