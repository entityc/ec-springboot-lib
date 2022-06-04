[//]: # ( =====preserve===== start-Introduction ===== )
# Localization

This directory contains all templates associated with localization.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`LocalizationAuthor`](#localization-author) | This template generates localization code in the application based on tagging in the Localization (if any). |

Each of the template files will be covered in more detail below.

<a name="localization-author"></a>
## Localization Author

This template generates localization code in the application based on tagging in the Localization (if any). The template uses authors to publish to various publisher templates such as for the service, repository, etc. classes.



| |References|
|---|---|
| **Tags** |`content:text` `login:username` `user:modified` `language:preferred` `language` `content:localized` `user` `content` |
| **Domains** |`Model` `Service` `JSONDTO` `Localization` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`AutoWired`](../util) | Helps to generate constructor based @Autowired code. |

### Authors

#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds method to get the localized content object in the user's preferred language.  Also adds method to get the localized text in the user's preferred language. These are only added to the service class of the localized content entity.|Connect|Author|


#### To Publisher: `org.entityc.springboot.service`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | Adds a method to create a content ojbect along with a localized content object in a specified language.|Connect|Author|


#### To Publisher: `org.entityc.springboot.service.mapping`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `dtoFromModelTop` | If this is the content entity, add code to copy the content text in user's preferred language into the virtual attribute that holds the preferred language text.|Connect|Author|
| `dtoFromModelMiddle` | For each of the virtual attributes that should contain text in the user's preferred language, copy the text from its associated content relationship object.|Connect|Author|


#### To Publisher: `org.entityc.springboot.repository`



This author publishes to the following outlets:

| Outlet | Description | Phase | Scope |
|---|---|---|---|
| `methods` | *no description*|Connect|Author|


