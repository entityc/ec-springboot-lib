[//]: # ( =====preserve===== start-Introduction ===== )
# Markdown

This directory contains functions specifically for generating endpoint documentation.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

The following templates only contain functions.

|Template|Description|
|---|---|
| [`CreateMarkdownFunctions`](#create-markdown-functions) | Functions that generate create (POST) endpoints. |
| [`GetMarkdownFunctions`](#get-markdown-functions) | Functions that generate markdown documentation about GET endpoints. |
| [`UpdateMarkdownFunctions`](#update-markdown-functions) | Functions that generate update (PUT) endpoints. |

Each of the template files will be covered in more detail below.

<a name="create-markdown-functions"></a>
## Create Markdown Functions

This contains functions that generate create endpoint methods for a controller class.

| |References|
|---|---|
| **Domains** |`JSONDTO` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| [`ReleaseFunctions`](../../release) | This template has functions specific for detecting and extracting information about a release management structure. |

### Functions

#### Create Markdown

```
createMarkdown(entity, apiUrlPrefix)
```

Generates markdown documentation for the basic create endpoint.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity corresponding to the create endpoint documentation to generate.|
|`apiUrlPrefix`|The start of all admin URLs.|



<a name="get-markdown-functions"></a>
## Get Markdown Functions

Functions that generate markdown documentation about GET endpoints.

| |References|
|---|---|
| **Domains** |`Model` `JSONDTO` `APIPath` |

### Functions

#### Get List by Parent Markdown

```
getListByParentMarkdown(entity, apiUrlPrefix)
```

Generates markdown documentation for the get list by parent endpoint.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity corresponding to the get endpoint documentation to generate.|
|`apiUrlPrefix`|The start of all admin URLs.|



#### Get by Id Markdown

```
getByIdMarkdown(entity, apiUrlPrefix)
```

Generates markdown documentation for the get by ID endpoint.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity corresponding to the get endpoint documentation to generate.|
|`apiUrlPrefix`|The start of all admin URLs.|



<a name="update-markdown-functions"></a>
## Update Markdown Functions

Contains functions that generate update endpoint methods for a controller class.

| |References|
|---|---|
| **Domains** |`JSONDTO` `APIPath` |

### Functions

#### Update Markdown

```
updateMarkdown(entity, apiUrlPrefix)
```

Generates markdown documentation for the basic update endpoint.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity corresponding to the update endpoint documentation to generate.|
|`apiUrlPrefix`|The start of all admin URLs.|



