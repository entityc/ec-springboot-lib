[//]: # ( =====preserve===== start-Introduction ===== )
# Protobuf

The templates in this directory are authors for the `ControllerProtobufPublisher` template.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`CreateAuthor`](#create-author) | This contains an author that generates create endpoint methods for a controller class based on protobuf requests and responses. |
| [`GetAuthor`](#get-author) | This contains an author that generates various get endpoint methods for a controller class based on protobuf requests and responses. |
| [`UpdateAuthor`](#update-author) | This contains an author that generates update endpoint methods for a controller class based on protobuf requests and responses. |

Each of the template files will be covered in more detail below.

<a name="create-author"></a>
## Create Author

This contains an author that generates create endpoint methods for a controller class based on protobuf requests and responses.

| |References|
|---|---|
| **Domains** |`ProtobufDTO` |

### Publishers

#### `org.entityc.springboot.controller.create`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entityc.springboot.controller.protobuf`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | *no description*|Connect|Author|


<a name="get-author"></a>
## Get Author

This contains an author that generates various get endpoint methods for a controller class based on protobuf requests and responses.

| |References|
|---|---|
| **Domains** |`Model` `ProtobufDTO` `Security` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entityc.springboot.controller.getListByRelationship`

Get List by Relationship Endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


#### `org.entityc.springboot.controller.getList`

Get List endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|
| `parameters` | This is where you want to include request parameters on the get<Model>List endpoint.|
| `declarations` | This is where you want to include variable declarations.|


#### `org.entityc.springboot.controller.getById`

Get by ID endpoint

The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entityc.springboot.controller.protobuf`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds get endpoints to the controller class for its entity.|Connect|Author|


<a name="update-author"></a>
## Update Author

This contains an author that generates update endpoint methods for a controller class based on protobuf requests and responses.

| |References|
|---|---|
| **Domains** |`Model` `ProtobufDTO` |

### Publishers

#### `org.entityc.springboot.controller.update`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `annotation` | Resides just above the method declaration in the annocation area.|


### Authors

#### To Publisher: `org.entityc.springboot.controller.protobuf`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | *no description*|Connect|Author|


