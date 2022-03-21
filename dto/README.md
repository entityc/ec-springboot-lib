[//]: # ( =====preserve===== start-Introduction ===== )
# Dto

These templates are related to Data Transfer Object classes.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`DtoTemplate`](#dto-template) | This template generates the DTO classes for all entites in your space. |
| [`FormattedTemplate`](#formatted-template) | This template generates the DTO classes for all entites in your space. |

Each of the template files will be covered in more detail below.

<a name="dto-template"></a>
## Dto Template

This template generates the DTO classes for all entites in your space as well as creating a README file for the directory that contains them.

| |References|
|---|---|
| **Tags** |`user` `login:password` |
| **Domains** |`Model` `JSONDTO` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entityc.springboot.dto`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `members` | Member variables can be declared here.|
| `methods` | Methods can be declared here.|


<a name="formatted-template"></a>
## Formatted Template

This template generates the DTO classes for all entites in your space as well as creating a README file for the directory that contains them.

| |References|
|---|---|
| **Tags** |`user` `login:password` |
| **Domains** |`Model` `JSONDTO` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

### Publishers

#### `org.entityc.springboot.dto`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `members` | Member variables can be declared here.|
| `methods` | Methods can be declared here.|


