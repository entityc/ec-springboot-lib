[//]: # ( =====preserve===== start-Introduction ===== )
# Security

This directory contains templates and Java source code associated with security.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`SecurityTemplate`](#security-template) | This template builds code associated with user authentication. |

The following templates only contain functions.

|Template|Description|
|---|---|
| [`SecurityFunctions`](#security-functions) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

Each of the template files will be covered in more detail below.

<a name="security-functions"></a>
## Security Functions

Contains functions for finding the logged in user entity, roles, and other useful functions.

| |References|
|---|---|
| **Tags** |`role` `role:default` `login:username` `access:object:level` `object:access:entity` `login:password` `user` `object:access:write` `object:access:read` |
| **Domains** |`Security` |

### Functions

#### Find User Entity

```
findUserEntity(space) -> (userEntity, usernameAttribute, passwordAttribute)
```

Finds the entity in the specified space that has is tagged `user` in the Security domian and returns its username and password attributes. The username attribute must be tagged with `login:username` and the password attribute with `login:password` - both in the Securty domain.

##### Inputs

|Name|Description|
|---|---|
|`space`|The specified space.|

##### Outputs

|Name|Description|
|---|---|
|`userEntity`|The user entity that represents logged in users of the system. This entity should be tagged with `user`.|
|`usernameAttribute`|The attribute of this entity that is tagged with `login:username`.|
|`passwordAttribute`|The attribute of this entity that is tagged with `login:password`.|


#### Pre Authorize Entity

```
preAuthorizeEntity(entity, accessType)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`||
|`accessType`||



#### Attributes of Role Item

```
attributesOfRoleItem(entity, roleItem, accessType) -> (attributeList)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`||
|`roleItem`||
|`accessType`||

##### Outputs

|Name|Description|
|---|---|
|`attributeList`||


#### Attribute Role Items

```
attributeRoleItems(attribute, accessType) -> (rolesItemList)
```

##### Inputs

|Name|Description|
|---|---|
|`attribute`||
|`accessType`||

##### Outputs

|Name|Description|
|---|---|
|`rolesItemList`||


#### Write Access Attributes

```
writeAccessAttributes(entity) -> (attributeList)
```

Gets all the attributes of the specified entity that have any tags that start with `access:write`.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity.|

##### Outputs

|Name|Description|
|---|---|
|`attributeList`|The attributes that have at least one tag starting with `access:write`.|


#### Roles Contains

```
rolesContains(entity, accessType, rolesArrayName) -> (hasRoles, rolesExpr)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`||
|`accessType`||
|`rolesArrayName`||

##### Outputs

|Name|Description|
|---|---|
|`hasRoles`||
|`rolesExpr`||


#### Check Object Level Access

```
checkObjectLevelAccess(entity) -> (objectLevelAccess, accessEntity, readAttribute, writeAttribute)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`||

##### Outputs

|Name|Description|
|---|---|
|`objectLevelAccess`||
|`accessEntity`||
|`readAttribute`||
|`writeAttribute`||


#### Get User Entity Attributes

```
getUserEntityAttributes(userEntity) -> (usernameAttribute, passwordAttribute)
```

Gets the username and password attributes of the specified user entity. The username attribute must be tagged with `login:username` and the password attribute with `login:password`.

##### Inputs

|Name|Description|
|---|---|
|`userEntity`|The user entity that represents logged in users of the system. This entity should be tagged with `user`.|

##### Outputs

|Name|Description|
|---|---|
|`usernameAttribute`|The attribute of this entity that is tagged with `login:username`.|
|`passwordAttribute`|The attribute of this entity that is tagged with `login:password`.|


#### Check Object Level Access From Access Entity

```
checkObjectLevelAccessFromAccessEntity(entity) -> (objectLevelAccess, parentEntity, readAttribute, writeAttribute)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`||

##### Outputs

|Name|Description|
|---|---|
|`objectLevelAccess`||
|`parentEntity`||
|`readAttribute`||
|`writeAttribute`||


#### Role Items

```
roleItems(entity, accessType) -> (rolesItemList)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`||
|`accessType`||

##### Outputs

|Name|Description|
|---|---|
|`rolesItemList`||


#### Attribute Roles Contains

```
attributeRolesContains(attribute, accessType, rolesArrayName) -> (hasRoles, rolesExpr)
```

##### Inputs

|Name|Description|
|---|---|
|`attribute`||
|`accessType`||
|`rolesArrayName`||

##### Outputs

|Name|Description|
|---|---|
|`hasRoles`||
|`rolesExpr`||


#### Find Role Enum

```
findRoleEnum(space) -> (roleEnum, defaultEnumItem)
```

Finds and returns the enum that is tagged with `role` in the Security domain. It also returns the default role (enum item tagged with `role:default` in the Security domain).

##### Inputs

|Name|Description|
|---|---|
|`space`|The specified space.|

##### Outputs

|Name|Description|
|---|---|
|`roleEnum`|The returned enum presenting the security roles of the application.|
|`defaultEnumItem`|The default role to be assigned to a new user.|


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
| `AuthorizationAuthor` |  |
| `SecurityFunctions` | Contains functions for finding the logged in user entity, roles, and other useful functions. |

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


