[//]: # ( =====preserve===== start-Introduction ===== )
# Auth

The templates and HTML files here all implement that web authorization (login, signup, etc.).

[//]: # ( =====preserve===== end-Introduction ===== )

> This document was created by template: `local:/../ec-std-lib/templates/document/TemplateMarkdown`

<a name="template-summary"></a>
## Template Summary

|Template|Description|
|---|---|
| [`AuthPageTemplate`](#auth-page-template) | This template generates HTML code associated with user Login and Sign Up. |
| [`LoginSignupWebPageController.java`](#login-signup-web-page-controller.java) | This Java source file with template code implements the controller class for login and signup. |

Each of the template files will be covered in more detail below.

<a name="auth-page-template"></a>
## Auth Page Template

This template generates HTML code associated with user Login and Sign Up.

| |References|
|---|---|
| **Tags** |`feature:invite` `invite` `login:enabled` |
| **Domains** |`WebUserUI` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`SecurityFunctions`](../../../security) | Contains functions for finding the logged in user entity, roles, and other useful functions. |

<a name="login-signup-web-page-controller.java"></a>
## Login Signup Web Page Controller.java

This Java source file with template code implements the controller class for login and signup. Its endpoints will be used by login and signup HTML.

| |References|
|---|---|
| **Tags** |`feature:invite` `code` `role` `role:default` `invite` `name:first` `name:last` |
| **Domains** |`Repository` `AdminUI` `Model` `Service` `JSONDTO` `APIPath` `Localization` `Security` |

### Imported Templates

| Name | Description |
|---|---|
| [`WebPageFunctions`](..) | Contains a set of functions that produce web page code that is in common with the different types of pages. |

