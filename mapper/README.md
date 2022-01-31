[//]: # ( =====preserve===== start-Introduction ===== )
# Mapper

The mapper classes are responsible for mapping data from one representation to another.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`MapperTemplate`](#mapper-template) | Generates code associated with mapping data from a JSON DTO to a Model and vice versa. |

Each of the template files will be covered in more detail below.

<a name="mapper-template"></a>
## Mapper Template

Generates code associated with mapping data from a JSON DTO to a Model and vice versa.

| |References|
|---|---|
| **Tags** |`login:password` |
| **Domains** |`Model` `JSONDTO` `Security` `DTOMapper` |

### Functions

#### Make Mapper

```
makeMapper(space, domain, entity)
```

##### Inputs

|Name|Description|
|---|---|
|`space`|The application space.|
|`domain`|The mapper domain|
|`entity`|The entity to which to create mepping methods.|



