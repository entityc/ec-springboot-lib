[//]: # ( =====preserve===== start-Introduction ===== )
# Keycloak

The keycloak security implementation relies on an external keycloak server
to provide all the authentication and authorization.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`SecurityTemplate`](#security-template) | This template builds code associated with keycloak based user authentication. |

Each of the template files will be covered in more detail below.

<a name="security-template"></a>
## Security Template

This template builds code associated with keycloak based user authentication. It uses tags placed on domain entities and attributes to enable and guide code generation.

| |References|
|---|---|
| **Tags** |`role` `access:object:level` `access:write:user` `user` `login:password` |
| **Domains** |`Repository` `Model` `Database` `JSONDTO` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`AuthorizationAuthor`](../standalone) | This author template adds methods to service and repository classes relating to the the authorization of object access. |
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


