[//]: # ( =====preserve===== start-Introduction ===== )
# Authors

The generation of the service class is accomplished with a single publisher (with various outlets) and a separate author for the various different types of operations. This directory contains the authors.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`ServiceBaseAuthor`](#service-base-author) | The authors in this template add a baseline of template code to the service publisher. |
| [`ServiceCRUDAuthors`](#service-crud-authors) | This template simply imports the CRUD authors that are basic to the application. |
| [`ServiceCacheAuthor`](#service-cache-author) | Generates code inside the methods of the Service class to implement in-memory caching. |
| [`ServiceCreateAuthor`](#service-create-author) | This template contains the author that is responsible for generating the create object service methods. |
| [`ServiceDeleteAuthor`](#service-delete-author) | This template contains the author that is responsible for generating the delete object service methods. |
| [`ServiceGetAuthor`](#service-get-author) | This template contains the authors that are responsible for generating the get object service methods. |
| [`ServiceUpdateAuthor`](#service-update-author) | The update author adds an update and a save method at the service level for updating objects of an entity. |

Each of the template files will be covered in more detail below.

<a name="service-base-author"></a>
## Service Base Author

The authors in this template add a baseline of template code to the service publisher.

| |References|
|---|---|
| **Domains** |`Repository` `Model` `JSONDTO` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |
| [`SourceHeaders`](../../doc) |  |

### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `commentHeader` | Standard source header.|Initial|Author|
| `entityLoopTop` | Defines some useful template variables for other authors of the service class.|Initial|Publisher|
| `members` | Adds java imports for model and dto classes.|Initial|Author|
| `constructor` | Adds infrastructure to allow easy auto wiring of external resources via the constructor.|Initial|Publisher|
| `constructor` | Auto wiring repository object since that should be commonly used within this publisher.|Connect|Author|


<a name="service-crud-authors"></a>
## Service CRUD Authors

This template simply imports the CRUD authors that are basic to the application.

| |References|
|---|---|
| **Domains** |`Repository` `Model` `Service` `JSONDTO` `ProtobufDTO` `Security` `DTOMapper` |

### Imported Templates

| Name | Description |
|---|---|
| `ServiceCreateAuthor` | This template contains the author that is responsible for generating the create object service methods. |
| `ServiceDeleteAuthor` | This template contains the author that is responsible for generating the delete object service methods. |
| `ServiceGetAuthor` | This template contains the authors that are responsible for generating the get object service methods. |
| `ServiceMappingAuthor` |  |
| `ServiceUpdateAuthor` | The update author adds an update and a save method at the service level for updating objects of an entity. |

<a name="service-cache-author"></a>
## Service Cache Author

Generates code inside the methods of the Service class to implement in-memory caching. The caching code is generated based on information annotated in the Service domain.

| |References|
|---|---|
| **Tags** |`enable` |
| **Domains** |`InMemoryCache` `Model` |

### Authors

#### To Publisher: `org.entityc.springboot`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `members` | This declares the member variables for the cache objects themselves - one for each relationship involved.|Initial|Author|
| `saved` | After an object is saved, this will place the newly updated object back in the cache.|Connect|Author|
| `init` | Initializes some variables used in later outlets..|Connect|Author|
| `preGet` | Looks for the object in the cache and sets `responseObject` to that if found.|Connect|Author|


### Functions

#### Add Cache Def

```
addCacheDef(name, key, valueClass, definition)
```

##### Inputs

|Name|Description|
|---|---|
|`name`||
|`key`||
|`valueClass`||
|`definition`||



<a name="service-create-author"></a>
## Service Create Author

This template contains the author that is responsible for generating the create object service methods. **Create**

 The create method is called by create endpoints implemented in the controller class. This method in turn calls a create method in the repository class however before that it will assign a UUID primary key. This is also where it places some of the in-memory caching code. It will also set relationships associated with the logged in (principle) user.

| |References|
|---|---|
| **Tags** |`internal:many-to-many` |
| **Domains** |`Repository` `Model` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |
| [`ServiceFunctions`](..) |  |

### Publishers

#### `org.entityc.springboot.service.create`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `saved` | The object, in variable `savedObject`, has just be created and saved to persistent storage by the simple create object service method.|
| `saved` | The object, in variable `savedObject`, has just be created and saved to persistent storage by the create object by parent service method.|


### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | *no description*|Connect|Author|
| `methods` | **Create With Parent** A create method is generated where the ID of a parent object is specified. This in turn calls a create method in the repository class however before that it will assign a UUID primary key. It will also set relationships associated with the logged in (principle) user.|Connect|Author|
| `methods` | **Associate To** This method allows the association between two entities that have a many-to-many relationship to be created.|Connect|Author|


<a name="service-delete-author"></a>
## Service Delete Author

This template contains the author that is responsible for generating the delete object service methods.

| |References|
|---|---|
| **Tags** |`release:lock` `release:binder` |
| **Domains** |`Repository` `Model` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |

### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | **Delete by Parent** Creates a method that can delete all objects for a specified parent object. `void delete`*entity*`By`*parent*`Id();`|Connect|Author|
| `methods` | **Delete by ID** Creates a method that can delete a single object by its ID.|Connect|Author|


<a name="service-get-author"></a>
## Service Get Author

This template contains the authors that are responsible for generating the get object service methods. This includes methods for getting not just a single object but lists of objects.

| |References|
|---|---|
| **Tags** |`noproto` `release:lock` `release:top` |
| **Domains** |`Repository` `Model` `Service` `JSONDTO` `ProtobufDTO` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |

### Publishers

#### `org.entityc.springboot.service.get`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `init` | Used by authors that may want to initialize some variables before using the other outlets.|
| `parentRelationship` | *no description*|
| `methods` | Good place to put get methods.|


### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | *no description*|Connect|Author|


### Functions

#### Make Get List by Relationship Method

```
makeGetListByRelationshipMethod(responseDomain, entity, relationship, getFlavor)
```

This function generates a method to get a list of objects relative to some specified relationship.

##### Inputs

|Name|Description|
|---|---|
|`responseDomain`|The domain associated with the response object (e.g, Model, JSONDTO, etc.).|
|`entity`|The entity to which this method is synthesized.|
|`relationship`|The relationship to which the results are relative.|
|`getFlavor`|The repository get method can have a flavor such as Locked so this can be set to use that flavor.|



#### Make Get List by Attribute Method

```
makeGetListByAttributeMethod(responseDomain, entity, attribute)
```

This function generates a method to get a list of objects relative to some specified attribute.

##### Inputs

|Name|Description|
|---|---|
|`responseDomain`|The domain associated with the response object (e.g, Model, JSONDTO, etc.).|
|`entity`|The entity to which this method is synthesized.|
|`attribute`|The attribute to which the results are relative.|



#### Get Response Vars for Domain

```
GetResponseVarsForDomain(entity, responseDomain) -> (responseClassName, responseInMethodName, cacheVariableName)
```

This is used by many of the other functions in this template to create variables based on a response domain.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity the variables are based on.|
|`responseDomain`|The response domain. Currently Model, JSONDTO and ProtobufDTO are supported.|

##### Outputs

|Name|Description|
|---|---|
|`responseClassName`|The Java class name corresponding to the response object.|
|`responseInMethodName`|When creating method names that correspond to the response domain, this value should be used.|
|`cacheVariableName`|If a cache is defined, this would be the name of the cache.|


#### Make Get by Id Service Method

```
makeGetByIdServiceMethod(responseDomain, entity, useCache, useSingleCache)
```

##### Inputs

|Name|Description|
|---|---|
|`responseDomain`||
|`entity`||
|`useCache`||
|`useSingleCache`||



<a name="service-update-author"></a>
## Service Update Author

The update author adds an update and a save method at the service level for updating objects of an entity. The save method has many outlets where you can insert code that needs to run when objects for an entity are being saved to the repository.

| |References|
|---|---|
| **Domains** |`Model` `Service` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |
| [`ServiceFunctions`](..) |  |

### Publishers

#### `org.entityc.springboot.service.update`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `aboveSave` | This is just above the save method for an entity object update.|
| `saveTop` | This is just inside the save method for an update but before the object is saved to the repository. You have the opportunity to look at or modify the model `object` variable before it is saved.|
| `saved` | This is just after the object is saved to the repository. The variable is called `savedObject`.|


### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | *no description*|Connect|Author|


