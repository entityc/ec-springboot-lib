# Entity Compiler Spring Boot Library

## Overview

This collection of templates allow you to quickly build a Spring Boot microservice that serves both a REST API and a web based Admin UI.

At present it can be used to build microservices that have the following features:

* Basic CRUD operations (create, read, update and delete).
* Basic user authentication and authorization.
* Simple Web Admin interface.
* Markdown display and edit.
* Markdown document builder.
* File upload to AWS S3.

> In its current state it should **not** be used for a production microservice. Your contributions are welcome.
> With the help of the Spring Boot community the goal is to reach a point where it can be used for production level
> applications. Until then, it is functional and can certainly serve to build prototype microservices.

### Prerequisites

This library is specifically written for use with the [Entity Compiler](https://github.com/entityc/entity-compiler).
It is recommended to first go through the [Entity Compiler Tutorial](https://github.com/entityc/ec-tutorial) before
trying to understand this library.

### Technologies

The following are the major technologies are used by this library:

| Name | Description| Link |
| ---- | ---------- | ---- |
| Spring Boot | This is an extensive Java-based framework for building microservices. | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) |
| Thymeleaf |The admin console uses Thymeleaf to dynamically create the final HTML for most of the web pages. Thymeleaf has basically two parts, a Java component that provides the data for the construction of the HTML and an HTML file that contains special constructs that help you build the final HTML from data provided by the Java component.|[http://thymeleaf.org](http://thymeleaf.org) |
| Bootstrap | This is a javascript based framework for building web sites. It supports many types of form elements, as well as elements for layout, content, etc.|[https://getbootstrap.com/docs/5.0](https://getbootstrap.com/docs/5.0)|
| InscrybMDE | Markdown editor - "A drop-in JavaScript textarea replacement for writing beautiful and understandable Markdown".|[https://github.com/Inscryb/inscryb-markdown-editor](https://github.com/Inscryb/inscryb-markdown-editor)|
|Marked| Renders markdown text into HTML. This is used to display markdown content on the web page. |[https://marked.js.org](https://marked.js.org)|

## How to Use

With your Entity Compiler project setup, the library is used by declaring it as a `repository` in your project's
`Space` referencing a specific tag, where the tag corresponds to a version of the library.

Your repository declaration may look like:

```
    repository SpringbootTemplates {
        type github
        organization "entityc"
        name "ec-springboot-lib"
        path "templates"
        tag "v0.7.0"
    }
```

You can then import the templates using something like the following:

```
    output ServerCode {
        path "src/main/java"
    }

    templates {
        import from SpringbootTemplates

        template Microservice {
            output primary ServerCode
        }
    }
```

## Licensing

All projects of the EntityC Organization are under the BSD 3-clause License.

See [LICENSE.md](LICENSE.md) for details.

## Contributing

Contributors are welcome. Before contributing please read the following [Contributing Guidelines](CONTRIBUTING.md).

## Code of Conduct

The Code of Conduct governs how we behave in public or in private whenever the project will be judged by our actions.
We expect it to be honored by everyone who contributes to this project.

See [Code of Conduct](CODE_OF_CONDUCT.md) for details.
