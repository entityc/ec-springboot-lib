[//]: # ( =====preserve===== start-Introduction ===== )
# Security

This directory contains templates and Java source code associated with a standalone implementation of authorization and authentication.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`AuthorizationAuthor`](#authorization-author) | This author template adds methods to service and repository classes relating to the the authorization of object access. |
| [`SecurityTemplate`](#security-template) | This template builds code associated with user authentication. |

Each of the template files will be covered in more detail below.

<a name="authorization-author"></a>
## Authorization Author

This author template adds methods to service and repository classes relating to the the authorization of object access. These methods can be used by an admin panel to know if it has a specific type of access without having to attempt the access.

| |References|
|---|---|
| **Tags** |`role` `access:object:parent` `sort:desc` `sort:asc` `login:username` `access:object:level` `access:write:user` `login:enabled` `user` |
| **Domains** |`Repository` `Model` `Database` `JSONDTO` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../../util) | Helps to generate constructor based @Autowired code. |
| [`SecurityFunctions`](..) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds service functions to check if the logged in user has permissions to edit objects of a certain entity and in the case of the "user" entity, if a specific attribute can be updated.|Connect|Author|


#### To Publisher: `org.entityc.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds a method to find a user by its username.|Connect|Author|


#### To Publisher: `org.entityc.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds a method to find access objects by a parent object and for a specific user.|Connect|Author|


#### To Publisher: `org.entityc.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds a method to get a list objects for which a user has read access.|Connect|Author|


#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds a service method to get a list of objects of this entity for which the logged in user has read access.|Connect|Author|


<a name="security-template"></a>
## Security Template

This template builds code associated with user authentication. It uses tags placed on domain entities and attributes to enable and guide code generation.

| |References|
|---|---|
| **Tags** |`feature:invite` `role` `access:object:level` `invite` `access:write:user` `user` `login:password` |
| **Domains** |`Repository` `Model` `Database` `JSONDTO` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| `AuthorizationAuthor` | This author template adds methods to service and repository classes relating to the the authorization of object access. |
| [`SecurityFunctions`](..) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Authors

#### To Publisher: `org.entityc.springboot.controller`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `insideTop` | Add code at top of update method to basically null out incoming attribute values if the logged in user's role does not let them update those attributes.|Connect|Author|
| `annotation` | Make sure the user has write permission for these methods.|Connect|Author|
| `annotation` | Make sure the user has read permission for these methods.|Connect|Author|


#### To Publisher: `org.entityc.springboot.dto`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Add the adjustUpdateForRoles() method to the DTO class.|Connect|Author|


