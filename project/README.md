[//]: # ( =====preserve===== start-Introduction ===== )
# POM

For projects that use Maven, this template will generate a `pom.xml` file specifically for a Springboot application.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`ApplicationPropertiesTemplate`](#application-properties-template) | This template generates a properties file for a spring boot application if one does not already exist. |
| [`PomTemplate`](#pom-template) | This template generates a `pom.xml` file that defines your microservice project. |

Each of the template files will be covered in more detail below.

<a name="application-properties-template"></a>
## Application Properties Template

This template generates a properties file for a spring boot application if one does not already exist.

 > In the future it may be capable of merging with an existing application.properties file but for now it only. generates the initial version of the file.

<a name="pom-template"></a>
## Pom Template

This template generates a `pom.xml` file that defines your microservice project. This is where you place all the libraries that you want to download and install into your application. It has an outlet so that features can add their dependencies here.

### Publishers

#### `springboot.pom`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `project` | *no description*|
| `parent` | *no description*|
| `properties` | *no description*|
| `dependencies` | *no description*|
| `profiles` | *no description*|
| `build` | *no description*|
| `plugins` | *no description*|


