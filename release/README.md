[//]: # ( =====preserve===== start-Introduction ===== )
# Release

These templates are associated with generating code for release management.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

The following templates only contain functions.

|Template|Description|
|---|---|
| [`ReleaseFunctions`](#release-functions) | This template has functions specific for detecting and extracting information about a release management structure. |

Each of the template files will be covered in more detail below.

<a name="release-functions"></a>
## Release Functions


When your application involves release and version management of some entity, this template has functions that can be useful. The template is centered around the support of a particular structure of entities that have specific relationships between eachother.

The entities involved in the pattern shown below are as follows:

| Entity | Description |
|:------:|-------------|
| O  | **Object** - This is the main entity you are trying to manage in terms of versioning and release management. For instance, lets say your entity is called Widget. This would be the non-versioned Widget.|
| V  | **Version** - This represents a entity that tracks versions of the O entity. It would have attributes that need to be under version control. In our example, this would be a version of a Widget so might be named WidgetVersion.|
| VR | **Version Release** - This entity binds our O and V entities to a release. So  |
| R  | **Release** - This represents a release of one or more O,V pairs. |
| P  | **Parent** - This is an *optional* entity that defines a context for the R entity (as a parent entity to it). |


```
    +-------+    +-------+      +--------+        +-------+          +-------+
    |   P   +---<|   R   +-----<|   VR   |>-------+   V   |>---------+   O   |>--+
    +----+--+    +-------+      +--------+        +-------+          +----+--+   |
         |                            Y                                   |      |
         |                            +-----------------------------------+      |
         +-----------------------------------------------------------------------+
Tag->           release:top    release:binder    release:version    release:object

```

These functions help support the detection of this pattern not just in terms of the tags but also the relationships between the entities.


| |References|
|---|---|
| **Tags** |`release:version` `release:binder` `release:object` `release:top` |

### Functions

#### Get Release Binder Relationships

```
getReleaseBinderRelationships(versionReleaseEntity) -> (results)
```

Given a version release (VR) entity, this locates and returns the release (R), object (O) and version (V) entities.

##### Inputs

|Name|Description|
|---|---|
|`versionReleaseEntity`|The version release (VR) entity.|

##### Outputs

|Name|Description|
|---|---|
|`results`|Returns an array with [R, O, V] if it finds them, otherwise it returns an empty array and logs messages about what it couldn't find.|


#### Has Relationship With Entity Tagged

```
hasRelationshipWithEntityTagged(fromEntity, tag) -> (result)
```

Given an entity, this looks for all other entities that the provided entity has a relationship and if at least one is found to be tagged with the provided tag it returns true. If none are found it returns false.

##### Inputs

|Name|Description|
|---|---|
|`fromEntity`|The entity from which the tagged entity has a relationship.|
|`tag`|The tag.|

##### Outputs

|Name|Description|
|---|---|
|`result`|Returns true if any entities tagged with provided tag are found. Otherwise returns false.|


#### Look for Version Release Structure

```
lookForVersionReleaseStructure(versionReleaseEntity) -> (results)
```

Given a version release (VR) entity, this will try to locate the version (V) and object (O) entities of the structure.

##### Inputs

|Name|Description|
|---|---|
|`versionReleaseEntity`|The version release (VR) where it starts its search.|

##### Outputs

|Name|Description|
|---|---|
|`results`|It returns an array with [VR, O, V] if it finds the O and V, otherwise just returns [VR].|


#### Look for Release Structure

```
lookForReleaseStructure(topReleaseEntity) -> (results)
```

Given the top release (R) entity, it attempts to locate all the version release (VR) entities - with their associated O and V entities - and gathers these in an array. So what is returned will be an array of [VR,O,V] arrays.

##### Inputs

|Name|Description|
|---|---|
|`topReleaseEntity`|The top release (R) entity.|

##### Outputs

|Name|Description|
|---|---|
|`results`|Returns an array for each [VR, O, V] set it finds that have a relationship with the specified R entity.|


