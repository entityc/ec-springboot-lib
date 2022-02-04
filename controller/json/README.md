[//]: # ( =====preserve===== start-Introduction ===== )
# Json

This directory contains authors for generating JSON based endpoints.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`AssetAuthor`](#asset-author) | This contains an author that generates code for endpoints that support uploading digital assets. |
| [`AssociationAuthor`](#association-author) | Contains an author used to generate code related to creating associations between objects. |
| [`CreateAuthor`](#create-author) | This contains an author that generates create endpoint methods for a controller class. |
| [`DeleteAuthor`](#delete-author) | This contains an author that generates delete endpoint methods for a controller class. |
| [`GetAuthor`](#get-author) | This contains an author that generates various get endpoint methods for a controller class. |
| [`UpdateAuthor`](#update-author) | Contains an author that generates update endpoint methods for a controller class. |

Each of the template files will be covered in more detail below.

<a name="asset-author"></a>
## Asset Author

This contains an author that generates code for endpoints that support uploading digital assets.

| |References|
|---|---|
| **Tags** |`asset:collection` `asset:file` |
| **Domains** |`Model` `APIPath` |

### Publishers

#### `org.entitycompiler.springboot.controller.assetUpload`

Asset upload endpoints.

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entitycompiler.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds asset upload endpoints to controller.|Connect|Author|


### Functions

#### Asset Upload

```
assetUpload(entity, collectionAttribute, attribute, role, service)
```

This function generates controller code for either a single file upload or a collection of asset files

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity corresponding to the asset.|
|`collectionAttribute`|An optional attribute that corresponds to an asset collection.|
|`attribute`|The attribute that represents a singla asset.|
|`role`|A string representing the role required to conduct this create operation.|
|`service`|The name of the code variable for the object of the Service class that has the delegated create function.|



<a name="association-author"></a>
## Association Author

Contains an author used to generate code related to creating associations between objects.

| |References|
|---|---|
| **Tags** |`internal:many-to-many` |
| **Domains** |`Model` `Security` `APIPath` `DTOMapper` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |
| [`SecurityFunctions`](../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entitycompiler.springboot.controller.associate`

Associate endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entitycompiler.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds an "associatedTo..." endpoint to the controller.|Connect|Author|


<a name="create-author"></a>
## Create Author

This contains an author that generates create endpoint methods for a controller class.

| |References|
|---|---|
| **Domains** |`Security` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`ReleaseFunctions`](../../release) | This template has functions specific for detecting and extracting information about a release management structure. |
| [`SecurityFunctions`](../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entitycompiler.springboot.controller.create`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


#### `org.entitycompiler.springboot.controller.createWithParent`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entitycompiler.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds create endpoints to the controller class for its entity.|Connect|Author|


<a name="delete-author"></a>
## Delete Author

This contains an author that generates delete endpoint methods for a controller class.

| |References|
|---|---|
| **Domains** |`Security` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entitycompiler.springboot.controller.deleteByRelationship`

Delete by Relationship endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


#### `org.entitycompiler.springboot.controller.deleteById`

Delete by ID endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entitycompiler.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds delete endpoints to the controller class for its entity.|Connect|Author|


<a name="get-author"></a>
## Get Author

This contains an author that generates various get endpoint methods for a controller class.

| |References|
|---|---|
| **Tags** |`release:lock` |
| **Domains** |`Model` `JSONDTO` `Security` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entitycompiler.springboot.controller.getByRelationship`

Get List by Relationship Endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


#### `org.entitycompiler.springboot.controller.getList`

Get List endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


#### `org.entitycompiler.springboot.controller.getById`

Get by ID endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entitycompiler.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds get endpoints to the controller class for its entity.|Connect|Author|


<a name="update-author"></a>
## Update Author

Contains an author that generates update endpoint methods for a controller class.

| |References|
|---|---|
| **Tags** |`release:lock` |
| **Domains** |`Model` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entitycompiler.springboot.controller.update`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|
| `insideTop` | This outlet is just inside the update endpoint method, the first code to execute. The request DTO object is called `requestDto`.|


### Authors

#### To Publisher: `org.entitycompiler.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope
|---|---|---|---|
| `methods` | Adds update endpoints to the controller class for its entity.|Connect|Author|

