[//]: # ( =====preserve===== start-Introduction ===== )
# Security

There are currently the following types of security implementations you can choose from:

| Implementation | Description |
|----------------|----------|
| `standalone`     | This will build a security framework such that this microservice can stand by itself, where it maintains its own database of users.|
| `keycloak`       | This will build a security framework based on delegating authorization and authentication from an external Keycloak server. This implies that all user information is also externally maintained. |

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

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


