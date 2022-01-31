[//]: # ( =====preserve===== start-Introduction ===== )
# Controller

The purpose of the Controller class is to implement the REST endpoints for your API. At this level it is mostly concerned with checking to make sure the input is valid and the user has the necessary permissions to perform what they are requesting. The bulk of the business logic is delegated to Service classes.

[//]: # ( =====preserve===== end-Introduction ===== )

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`ControllerPublisher`](#controller-publisher) | This generates a controller class that has many normal CRUD operations along with asset upload operations. |
| [`ControllerReleaseDeltaTemplate`](#controller-release-delta-template) | This template creates a Controller class that is specifically for a release delta endpoint. |

Each of the template files will be covered in more detail below.

<a name="controller-publisher"></a>
## Controller Publisher

This template is responsible for generating the Controller classes of the micro-service. These classes essentially define endpoints, perform some security/permission checks, then ultimately call methods on Service classes that service the endpoints.

| |References|
|---|---|
| **Tags** |`parent:service` `rest:none` |
| **Domains** |`Model` `Service` `JSONDTO` `Controller` `Security` `APIPath` `DTOMapper` |

### Imported Templates

| Name | Description |
|---|---|
| [`AssetAuthor`](json) | This contains an author that generates code for endpoints that support uploading digital assets. |
| [`AssociationAuthor`](json) | Contains an author used to generate code related to creating associations between objects. |
| [`AutoWired`](../util) | Helps to generate constructor based @Autowired code. |
| [`CreateAuthor`](json) | This contains an author that generates create endpoint methods for a controller class. |
| [`DeleteAuthor`](json) | This contains an author that generates delete endpoint methods for a controller class. |
| [`GetAuthor`](json) | This contains an author that generates various get endpoint methods for a controller class. |
| [`UpdateAuthor`](json) | Contains an author that generates update endpoint methods for a controller class. |

### Publishers

#### `org.entitycompiler.springboot.controller`



The following outlets are offered by this publisher:

| Outlet | Description |
|---|---|
| `members` | Member variables can be placed here.|
| `methods` | Methods can be placed here.|


<a name="controller-release-delta-template"></a>
## Controller Release Delta Template

This template creates a Controller class that is specifically for a release delta endpoint. A release delta is basically the difference between two releases but constructed in such a way that the receiver of the data return can construct a new release from an old release without all of the new release being provided.

| |References|
|---|---|
| **Tags** |`release:delta` |
| **Domains** |`Model` `Service` `JSONDTO` `ProtobufDTO` `Controller` `APIPath` |

### Functions

#### Make Release Delta Controller

```
makeReleaseDeltaController(entity, domain, space, role)
```

##### Inputs

|Name|Description|
|---|---|
|`entity`|The entity that is tagged as the release delta entity.|
|`domain`|The controller domain.|
|`space`|The space of the application.|
|`role`|The role required to create release deltas.|



