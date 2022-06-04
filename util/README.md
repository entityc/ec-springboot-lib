[//]: # ( =====preserve===== start-Introduction ===== )
# Util

The templates and classes here provide some utility functions to the application.

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `[ecStdLibTemplatesLocal]local:../ec-std-lib/templates/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

The following templates only contain functions.

|Template|Description|
|---|---|
| [`AutoWired`](#auto-wired) | Helps to generate constructor based @Autowired code. |

Each of the template files will be covered in more detail below.

<a name="auto-wired"></a>
## Auto Wired

### Functions

#### Add Auto Wired

```
addAutoWired(domainEntity, autoWiredDomainEntities)
```

Helps send up imports and constructor parameters for auto-wired variables to services or repositories.
To use this function you must embed four receivers in your code:

| Receive | Description |
| --- | --- |
| `imports` | Place this where Java import statements are located. |
| `memberDecl` | Place this where member declarations are made inside the containing class. |
| `constructorArgs` | Place this inline with the constructor arguments. |
| `constructorAssigns` | Place this inside the constructor block to perform the necessary assignments.|

For example, the following code might be used in conjunction with this function:

```
$[receive distinct imports]

public class ${className} {

$[receive distinct memberDecl]

    @Autowired
    public ${className}(
$[receive distinct constructorArgs]
    ) {
$[receive distinct constructorAssigns]
    }
$[let autoWiredDomainEntities = @[]@]
```


##### Inputs

|Name|Description|
|---|---|
|`domainEntity`|The domain entity representing what is to be auto wired.|
|`autoWiredDomainEntities`|This is used by this function to keep track of what has already been auto wired. This allows it to eliminate duplicates and helps with code formatting.|



#### Add Auto Wired Class

```
addAutoWiredClass(package, className, autoWiredDomainEntities)
```

Helps send up imports and constructor parameters for auto-wired variables to services or repositories. This is just like `addAutoWired` except that it access just a class name and package name.

##### Inputs

|Name|Description|
|---|---|
|`package`|The package of the class to auto wire.|
|`className`|The name of the class to auto wire.|
|`autoWiredDomainEntities`|This is used by this function to keep track of what has already been auto wired. This allows it to eliminate duplicates and helps with code formatting.|



