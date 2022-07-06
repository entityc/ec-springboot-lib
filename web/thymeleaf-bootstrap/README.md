[//]: # ( =====preserve===== start-Introduction ===== )
# Thymeleaf-bootstrap

This directory contains all the files associated with generating web interfaces.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`LocalizedMessagesTemplate`](#localized-messages-template) | This template simply generates the `Messages_en.properties` file for each of the entity and attribute titles. |

The following templates only contain functions.

|Template|Description|
|---|---|
| [`WebPageFunctions`](#web-page-functions) | Contains a set of functions that produce web page code that is in common with the different types of pages. |

Each of the template files will be covered in more detail below.

<a name="localized-messages-template"></a>
## Localized Messages Template

This template simply generates the `Messages_en.properties` file for each of the entity and attribute titles.

| |References|
|---|---|
| **Tags** |`lang:en` |
| **Domains** |`StaticLocalization` |

<a name="web-page-functions"></a>
## Web Page Functions

Contains a set of functions that produce web page code that is in common with the different types of pages.

| |References|
|---|---|
| **Tags** |`role` `user:principle` `headline:number` `user:created` `required` `content` `headline:title` `breadcrumb:title` `user:modified` `canAccess` `breadcrumb:number` `headline:prefix` `breadcrumb:prefix` |
| **Domains** |`AdminUI` `Localization` `Security` |

### Functions

#### Headline Expression

```
headlineExpression(entity, dtoEntity) -> (thExpression)
```

This generates a Thymeleaf expression used for constructing a Headline string based on attribute values. The expression will try to construct the headline as follows: *header* *number*: *title*.  The entity title will be used as the *header* if it is tagged with `headline:prefix`. An attribute tagged with `headline:number` will be used for the *number* (if found). Finally an attribute tagged with `headline:title` will be used as the *title* (if found).

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity associated with the headline.|
|`dtoEntity`|The JSONDTO domain entity.|

##### Outputs

|Name|Description|
|---|---|
|`thExpression`|The produced Thymeleaf expression.|


#### Can Access Admin Expr

```
canAccessAdminExpr(rolesArrayName, space) -> (rolesExpr)
```

##### Inputs

|Name|Description|
|---|---|
|`rolesArrayName`||
|`space`||

##### Outputs

|Name|Description|
|---|---|
|`rolesExpr`||


#### Required Editable Fields

```
requiredEditableFields(entity) -> (attributes, relationships)
```

For a specified entity this function finds all editable attributes and one-to-many relationships. It excludes relationships to the principle user since those will automatically set (e.g., createdByUser) and also excludes the relationship to its parent entity as that is also automatically set.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The specified entity.|

##### Outputs

|Name|Description|
|---|---|
|`attributes`|The attributes that are editable.|
|`relationships`|The relationships that are editable.|


#### Common Body Navbar

```
commonBodyNavbar(backURL, title, excludeLogout, projectBaseApiPath)
```

Supplies code for the top navigation bar.

##### Inputs

|Name|Description|
|---|---|
|`backURL`|The URL for the back button.|
|`title`|The title to put on the navigation bar.|
|`excludeLogout`|For screens where the user is logged out, setting this will exclude the entire user menu.|
|`projectBaseApiPath`||



#### Check If Attribute Is Editable

```
checkIfAttributeIsEditable(attribute) -> (editable)
```

Checks to see if the attribute is considered editable. Basically it is editable as long as it is not a creation or modification date.

##### Inputs

|Name|Description|
|---|---|
|`attribute`|The attribute to check.|

##### Outputs

|Name|Description|
|---|---|
|`editable`|True if editable, false otherwise.|


#### Get Content Relationship for Virtual Attribute

```
getContentRelationshipForVirtualAttribute(attribute, space) -> (foundRelationship)
```

For virtual attributes that are tagged with `content` = *relationshipName* it will return the relationship.

##### Inputs

|Name|Description|
|---|---|
|`attribute`|The virtual attribute.|
|`space`||

##### Outputs

|Name|Description|
|---|---|
|`foundRelationship`|The relationship associated with the attribute tagging.|


#### Check If Attribute Is Required

```
checkIfAttributeIsRequired(attribute) -> (required)
```

Checks to see if the attribute is required to be set by the admin when creating a new object.

##### Inputs

|Name|Description|
|---|---|
|`attribute`|The attribute to check.|

##### Outputs

|Name|Description|
|---|---|
|`required`|True if required, false otherwise.|


#### Breadcrumb Expression

```
breadcrumbExpression(entity, dtoEntity) -> (thExpression)
```

This generates a Thymeleaf expression used for constructing a breadcrumb item string based on attribute values. The expression will try to construct the breadcrumb item as follows: *header* *number*: *title*.  The entity title will be used as the *header* if it is tagged with `breadcrumb:prefix`. An attribute tagged with `breadcrumb:number` will be used for the *number* (if found). Finally an attribute tagged with `breadcrumb:title` will be used as the *title* (if found).

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity associated with the headline.|
|`dtoEntity`|The JSONDTO domain entity.|

##### Outputs

|Name|Description|
|---|---|
|`thExpression`|The produced Thymeleaf expression.|


#### Common Head

```
commonHead(title)
```

Supplies code for the <head> section of the web page for meta and stylesheets.

##### Inputs

|Name|Description|
|---|---|
|`title`|The web page title.|



#### Common Body Scripts

```
commonBodyScripts()
```

Provides code that can be placed at the bottom of the <body> to define scripts.




