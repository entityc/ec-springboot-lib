[//]: # ( =====preserve===== start-Introduction ===== )
# Modal

These files are related to creating various web modal dialogs. These dialogs are used to input different types of data.

> There must be a better way to implement this, as you can see there is a lot of redundant code.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`ModalFunctions`](#modal-functions) | Contains functions used to construct modal dialogs in the admin panel. |

The following templates only contain functions.

|Template|Description|
|---|---|
| [`BooleanEditModalFunctions`](#boolean-edit-modal-functions) | Contains functions for adding a modal dialog for inputing a boolean value (checkbox). |
| [`DateEditModalFunctions`](#date-edit-modal-functions) | Contains functions for adding a modal dialog for inputing a date value. |
| [`EntitySelectModalFunctions`](#entity-select-modal-functions) | Contains functions for adding a modal dialog for selecting an object of a specified entity. |
| [`EnumEditModalFunctions`](#enum-edit-modal-functions) | Contains functions for adding a modal dialog for selecting one of a set of enumerated values or multiple items in the set. |
| [`FileUploadModalFunctions`](#file-upload-modal-functions) | Contains functions for adding a modal dialog that allows a user to select a local file for the purpose of uploading it to the server. |
| [`StringEditModalFunctions`](#string-edit-modal-functions) | Contains functions for adding a modal dialog for inputing a string value. |

Each of the template files will be covered in more detail below.

<a name="boolean-edit-modal-functions"></a>
## Boolean Edit Modal Functions

Contains functions for adding a modal dialog for inputing a boolean value (checkbox).

| |References|
|---|---|
| **Domains** |`APIPath` |

### Functions

#### Insert Boolean Edit Modal Script

```
insertBooleanEditModalScript()
```

Inserts the Javascript portion of the boolean input dialog.




#### Insert Boolean Edit Modal HTML

```
insertBooleanEditModalHTML(adminUrlPrefix, entity, entityDtoClassName)
```

Inserts the HTML code needed to create a boolean input dialog.

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|The entity associated with the boolean being inputted. The specific attribute (field) can be set at runtime.|
|`entityDtoClassName`|This is simply the DTO class name for the entity.|



<a name="date-edit-modal-functions"></a>
## Date Edit Modal Functions

Contains functions for adding a modal dialog for inputing a date value.

| |References|
|---|---|
| **Domains** |`APIPath` |

### Functions

#### Insert Date Edit Modal HTML

```
insertDateEditModalHTML(adminUrlPrefix, entity, entityDtoClassName)
```

Inserts the HTML code needed to create a date input dialog.

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|The entity associated with the date being inputted. The specific attribute (field) can be set at runtime.|
|`entityDtoClassName`|This is simply the DTO class name for the entity.|



#### Insert Date Edit Modal Script

```
insertDateEditModalScript()
```

Inserts the Javascript portion of the date input dialog.




<a name="entity-select-modal-functions"></a>
## Entity Select Modal Functions

Contains functions for adding a modal dialog for selecting an object of a specified entity.

| |References|
|---|---|
| **Tags** |`display:attribute:abbr` |
| **Domains** |`AdminUI` `JSONDTO` `APIPath` |

### Functions

#### Insert Entity Select Modal HTML

```
insertEntitySelectModalHTML(adminUrlPrefix, entity, entityDtoClassName, relationship)
```

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|This is the entity to which the selection is being assigned. The specific relationship should also be passed in this argument list.|
|`entityDtoClassName`|This is simply the DTO class name for the entity.|
|`relationship`|The selection is being performed with respect to a relationship. So the objects being selected from are objects of the relationship's **to** entity.|



#### Insert Entity Select Modal Script

```
insertEntitySelectModalScript(relationship)
```

Inserts the Javascript portion of the entity object select input dialog.

##### Inputs

|Name|Description|
|---|---|
|`relationship`|The selection is being performed with respect to a relationship. So the objects being selected from are objects of the relationship's **to** entity.|



<a name="enum-edit-modal-functions"></a>
## Enum Edit Modal Functions

Contains functions for adding a modal dialog for selecting one of a set of enumerated values or multiple items in the set.

| |References|
|---|---|
| **Tags** |`title` |
| **Domains** |`APIPath` |

### Functions

#### Insert Many Enum Edit Modal HTML

```
insertManyEnumEditModalHTML(adminUrlPrefix, entity, entityDtoClassName, attribute)
```

Inserts the HTML code for a modal dialog that allows the user to select multiple items from the enum.

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|The entity containing the enum attribute.|
|`entityDtoClassName`|The entity's name in the DTO domain (its DTO class name).|
|`attribute`|The attribute that is of the enum type to be used for this modal.|



#### Insert Enum Edit Modal HTML

```
insertEnumEditModalHTML(adminUrlPrefix, entity, entityDtoClassName, attribute)
```

Inserts the HTML code for a modal dialog that allows the user to select just one item in the enum.

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|The entity containing the enum attribute.|
|`entityDtoClassName`|The entity's name in the DTO domain (its DTO class name).|
|`attribute`|The attribute that is of the enum type to be used for this modal.|



#### Insert Enum Edit Modal Script

```
insertEnumEditModalScript(attribute)
```

Inserts the companion Javascript code for the single enum item select modal.

##### Inputs

|Name|Description|
|---|---|
|`attribute`|The attribute that is of the enum type to be used for this modal.|



#### Insert Many Enum Edit Modal Script

```
insertManyEnumEditModalScript(attribute)
```

Inserts the companion Javascript code for the multiple enum item select modal.

##### Inputs

|Name|Description|
|---|---|
|`attribute`|The attribute that is of the enum type to be used for this modal.|



<a name="file-upload-modal-functions"></a>
## File Upload Modal Functions

Contains functions for adding a modal dialog that allows a user to select a local file for the purpose of uploading it to the server.

| |References|
|---|---|
| **Domains** |`APIPath` |

### Functions

#### Insert File Upload Modal HTML

```
insertFileUploadModalHTML(adminUrlPrefix, entity, entityDtoClassName)
```

Inserts the HTML code needed to create a file upload dialog.

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|The entity associated with the file upload. At runtime, the attribute associated with the upload can be set.|
|`entityDtoClassName`|This is simply the DTO class name for the entity.|



#### Insert File Upload Modal Script

```
insertFileUploadModalScript()
```

Inserts the Javascript portion of the file upload dialog.




<a name="modal-functions"></a>
## Modal Functions

Contains functions used to construct modal dialogs in the admin panel.

| |References|
|---|---|
| **Domains** |`AdminUI` `JSONDTO` `APIPath` |

### Imported Templates

| Name | Description |
|---|---|
| `BooleanEditModalFunctions` | Contains functions for adding a modal dialog for inputing a boolean value (checkbox). |
| `DateEditModalFunctions` | Contains functions for adding a modal dialog for inputing a date value. |
| `EntitySelectModalFunctions` | Contains functions for adding a modal dialog for selecting an object of a specified entity. |
| `EnumEditModalFunctions` | Contains functions for adding a modal dialog for selecting one of a set of enumerated values or multiple items in the set. |
| `FileUploadModalFunctions` | Contains functions for adding a modal dialog that allows a user to select a local file for the purpose of uploading it to the server. |
| `StringEditModalFunctions` | Contains functions for adding a modal dialog for inputing a string value. |

<a name="string-edit-modal-functions"></a>
## String Edit Modal Functions

Contains functions for adding a modal dialog for inputing a string value.

| |References|
|---|---|
| **Tags** |`markdown` |
| **Domains** |`APIPath` |

### Functions

#### Insert String Edit Modal HTML

```
insertStringEditModalHTML(adminUrlPrefix, entity, entityDtoClassName)
```

Inserts the HTML code needed to create a string input dialog.

##### Inputs

|Name|Description|
|---|---|
|`adminUrlPrefix`|The admin console's url prefix (e.g., `admin`)|
|`entity`|The entity associated with the string being inputted. The specific attribute (field) can be set at runtime.|
|`entityDtoClassName`|This is simply the DTO class name for the entity.|



#### Insert String Edit Modal Script

```
insertStringEditModalScript(domainEntity)
```

Inserts the Javascript portion of the string input dialog.

##### Inputs

|Name|Description|
|---|---|
|`domainEntity`|This should be the same entity as used for the HTML portion and in the AdminUI domain.|



