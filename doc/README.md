[//]: # ( =====preserve===== start-Introduction ===== )
# Doc

Contains templates that generate various documentation for a server.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`APIDocs`](#api-docs) | Generates documentation for the REST APIs of this microservice. |
| [`Confluence`](#confluence) | Generates documentation in a Confluence format that can be imported into Confluence. |
| [`DatamodelDocs`](#datamodel-docs) | Generates documentation for the datamodel of this microservice. |
| [`ModuleDocs`](#module-docs) | Generates documentation for the entity modules in a space. |
| [`ServerDocumentation`](#server-documentation) | Generates various documentation about the generated source files. |

Each of the template files will be covered in more detail below.

<a name="api-docs"></a>
## API Docs

This template generates documentation for the REST APIs of this microservice.

| |References|
|---|---|
| **Tags** |`asset:collection` `asset:file` `asset` |
| **Domains** |`Model` `JSONDTO` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`AssetMarkdownFunctions`](../controller/markdown) |  |
| [`CreateMarkdownFunctions`](../controller/markdown) | Functions that generate create (POST) endpoints. |
| [`GetMarkdownFunctions`](../controller/markdown) | Functions that generate markdown documentation about GET endpoints. |
| [`UpdateMarkdownFunctions`](../controller/markdown) | Functions that generate update (PUT) endpoints. |

<a name="confluence"></a>
## Confluence

This template generates documentation in a Confluence format that can be imported into Confluence.

| |References|
|---|---|
| **Tags** |`asset` |
| **Domains** |`Model` `JSONDTO` `APIPath` |

<a name="datamodel-docs"></a>
## Datamodel Docs

This template generates documentation for the datamodel of this microservice.

| |References|
|---|---|
| **Domains** |`Model` `JSONDTO` |

<a name="module-docs"></a>
## Module Docs

This template first generates a basic README for a space, then a simple README for each module which links to its data model and API documentation.

<a name="server-documentation"></a>
## Server Documentation

| |References|
|---|---|
| **Domains** |`Model` `JSONDTO` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| `APIDocs` | Generates documentation for the REST APIs of this microservice. |
| `DatamodelDocs` | Generates documentation for the datamodel of this microservice. |
| `ModuleDocs` | Generates documentation for the entity modules in a space. |

