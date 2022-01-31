[//]: # ( =====preserve===== start-Introduction ===== )
# DocumentBuilder

The document builder feature has the ability to generate a document based on data from the database and based one how you add tags to the entity model in the `DocumentBuilder` domain.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

The following templates only contain functions.

|Template|Description|
|---|---|
| [`MarkdownDocumentBuilderFunctions`](#markdown-document-builder-functions) | The purpose of this template is to generate a function that will create a markdown document from contents of your database based on how you tag your model in the DocumentBuilder domain. |

Each of the template files will be covered in more detail below.

<a name="markdown-document-builder-functions"></a>
## Markdown Document Builder Functions

Markdown is an easy way to create documents with some rich elements such as heading levels, tables, code blocks, etc. If your application is such that you can assemble a Markdown document from fields of your data objects, this template makes it easy to generate code that will extract the data and structure it into a markdown document.

| |References|
|---|---|
| **Tags** |`untitled` `section:prefix` `if:multiple` `section:number` `section:title` |
| **Domains** |`DocumentBuilder` `Utils` `Model` `Service` `JSONDTO` |

### Functions

#### Build Markdown Doc Section

```
buildMarkdownDocSection(entity) -> (domainEntitiesToAutowire)
```

This is the main function of the template that generates the code needed to construct the markdown document. It is intended to create methods that reside in the service classes of our microservice. It models the structure of based on the structure of your entity model.

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity from which to generate Markdown.|

##### Outputs

|Name|Description|
|---|---|
|`domainEntitiesToAutowire`|The created function may need require that the containing class autowire other service classes, so this provides a list of domain entities that reporesent those service classes.|


