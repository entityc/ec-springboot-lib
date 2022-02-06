[//]: # ( =====preserve===== start-Introduction ===== )
# Admin

This directory contains templates associated with generating the Admin web console.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`AdminConsole`](#admin-console) | This is the top level template that generates the Admin Console. |
| [`AdminDetailPageTemplate`](#admin-detail-page-template) | This template generates an admin detail page for an entity. |
| [`AdminHomePageTemplate`](#admin-home-page-template) | This template generates the websites Admin Home page. |

Each of the template files will be covered in more detail below.

<a name="admin-console"></a>
## Admin Console

This is the top level template that generates the Admin Console.

| |References|
|---|---|
| **Domains** |`AdminUI` `Model` `StaticLocalization` `Service` `JSONDTO` `model` `Localization` `Security` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| `AdminDetailPageTemplate` | This template generates an admin detail page for an entity. |
| `AdminHomePageTemplate` | This template generates the websites Admin Home page. |
| `AdminNewPageTemplate` |  |

<a name="admin-detail-page-template"></a>
## Admin Detail Page Template

This template generates an admin detail page for an entity. It allows an admin to edit fields of an object and create new objects of child (one-to-many relationship) entities.

| |References|
|---|---|
| **Tags** |`summary` `flatten` `display:attribute` `content:text` `asset:file` `selectable` `markdown` `access:object:level` `detail` `content:localized` `user` `url` |
| **Domains** |`AdminUI` `Model` `StaticLocalization` `Service` `JSONDTO` `Localization` `Security` `APIPath` |

At the very top of the page is the same navigation bar from the home screen. The screen has other features that you can customize.

 ### Breadcrumb Bar

 Just below the top navigation is what is referred to as a "breadcrumb" bar. This bar will allow you to see the depth of screens you have traversed and let you click on a prior level to go back. Each depth (iten on the bar) represents some entity in your model. If a particular entity has a one-to-many relationship with another entity, that represents another level. As the admin goes to deeper levels items are added to the bar.

Each item in this bar is formatted as:

  *header* *number*`:` *title*

Where *header*, *number* and *title* correspond to tags that you place on an entity that can appear in the bar.

| Tag | Description
|---|---|
| `breadcrumb.header` | This is typically placed on an entity. |
| `breadcrumb.number` | This would be placed on a numeric attribute that represents some type of numbering for objects of this entity.|
| `breadcrumb.title` | This should be placed on an attribute that provides a name or title of the object.|

All tags are optional and which tags are used depend on how you want it to look as a breadcrumb item. For some entities, for instance, it may be appropriate to just have a title.

### Headline

Below the breadcrumb bar is what is referred to as a Headline. It has the same three elements as a breadcrumb items:

  *header* *number*`:` *title*

You make an entity's headline be the same as how its breadcrumb item is formatted or you can make it different. The tags for the headline are:

| Tag | Description
|---|---|
| `headline.header` | This is typically placed on an entity. |
| `headline.number` | This would be placed on a numeric attribute that represents some type of numbering for objects of this entity.|
| `headline.title` | This should be placed on an attribute that provides a name or title of the object.|

Although the headline is composed of attributes that are shown and editable below it, it is in bigger font and let's you know what you are editing very clearly.

 ### Object Fields

 The next section of the page shows attributes (fields) of the page object as a table where the first column is the attribute name and the second column is its value. The third column will populate with an "Edit" button for fields that are not a creation or modification date.

 String fields are by default considered just plain text. However, this template also supports a string field that is to contain Markdown. For string fields that you want to contain Markdown, simply tag those attributes in the `AdminUI` domain with `markdown`. Not only will string values for these attributes be displayed as markdown (that is rendered to HTML - with GitHub flavored style) but also will invoke a web based markdown editor when you want to edit the field.

 ### Child Objects

 For each on-to-many relationship this entity has with other entites it can render a table for each in this bottom section. Only the relationships that are tagged with `detail` will be included. The fields of the child entity that are included in the generated table are those attributes that are tagged with `summary`.



### Imported Templates

| Name | Description |
|---|---|
| [`ModalFunctions`](../modal) | Contains functions used to construct modal dialogs in the admin panel. |
| [`SecurityFunctions`](../../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |
| [`WebPageFunctions`](..) | Contains a set of functions that produce web page code that is in common with the different types of pages. |

### Publishers

#### `org.entityc.springboot.web.admin.detail`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `headlineButtonArea` | *no description*|


### Functions

#### Table for Entity

```
tableForEntity(entity, secondaryAttributeStack, dtoVariable, optShowMarkdownIcon)
```

Generates a table row for a single attribute. This is in a function so it can be used for secondary entity attributes.

##### Inputs

|Name|Description|
|---|---|
|`entity`||
|`secondaryAttributeStack`||
|`dtoVariable`||
|`optShowMarkdownIcon`||



#### Gen Attribute If Block

```
genAttributeIfBlock(space, entity, ifClause, domainAttribute, serviceName, secondaryAttributeStack) -> (addedIfBlock)
```

##### Inputs

|Name|Description|
|---|---|
|`space`||
|`entity`||
|`ifClause`||
|`domainAttribute`||
|`serviceName`||
|`secondaryAttributeStack`||

##### Outputs

|Name|Description|
|---|---|
|`addedIfBlock`||


<a name="admin-home-page-template"></a>
## Admin Home Page Template

This template generates the websites Admin Home page. This page contains the entities that are at the top of the entity hierarchy. So for instance, for a Tutorial website it would be a list of tutorials (from some entity like Tutorial). Each object in the list would be a link to a web page that is specific for administering that object. The very top of this page contains a navigation bar that includes a pulldown menu that allows the user to logout.

| |References|
|---|---|
| **Tags** |`summary` `role` `edit` `markdown` `access:object:level` `user` `home` |
| **Domains** |`AdminUI` `Model` `StaticLocalization` `Service` `JSONDTO` `Localization` `Security` `APIPath` |

Options for how it generates the admin home page are specified in the `AdminUI` domain with specific tags.The following features are customizable:

### Define Top Level Entities

In the `AdminUI` domain, just tag the entities you want to be included as top level entities with the tag `home`. If you want the user to be able to add new objects of an entity, also tag the entity with the tag `edit`. This will include an "Add" button and associated functionilty for creating the object. When objects of the top level entities are displayed you can control which fields of the entity are included by tagging the fields with the tag `summary`.

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |
| [`WebPageFunctions`](..) | Contains a set of functions that produce web page code that is in common with the different types of pages. |

### Publishers

#### `org.entityc.springboot.web.admin.home`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `homeMenuButtonArea` | *no description*|
| `entityHomeButtonArea` | *no description*|


