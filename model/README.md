[//]: # ( =====preserve===== start-Introduction ===== )
# Model

A model class is one which models objects internally on the server. These templates are used to synthesize model classes.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`ModelTemplate`](#model-template) | This template builds what are called Model classes. |

Each of the template files will be covered in more detail below.

<a name="model-template"></a>
## Model Template

This template builds what are called Model classes. A Model class is used to represent objects of an entity that are used internally on the server. They typically match pretty closely to how they are modeled in the database.

 In addition to creating model class files for the entities it also creates source files for the enums.

 The template also generates markdown documentation about the model classes in a README.md file written at the same level as the model class files. This basically creates documentation when viewed with GitHub.

| |References|
|---|---|
| **Tags** |`template` `release` `title` |
| **Domains** |`Model` `Database` |

### Imported Templates

| Name | Description |
|---|---|
| [`SourceHeaders`](../doc) |  |

### Publishers

#### `springboot.model`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `classAnnotations` | Annotations on the entity model class.|


### Functions

#### Build Overrides

```
buildOverrides(modelNamePrefix, databaseNamePrefix, attribute) -> (overrides)
```

In a Springboot Model class, annotations are used to map attribute variables to database columns. These can be a bit complicated when secondary entities are involved as the hierarchy in the model class can be different than at the database level. This function helps in the synthesis of these model variable to column name mappings. This includes both attributes and relationships.

##### Inputs

|Name|Description|
|---|---|
|`modelNamePrefix`||
|`databaseNamePrefix`||
|`attribute`||

##### Outputs

|Name|Description|
|---|---|
|`overrides`||


