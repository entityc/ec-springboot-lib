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

The easiest way to get started is to install a sample project. This can be done using the Entity Compiler's `setup` command. To do this you first need to have the Entity Compiler installed. See 

On a command line run the following command:

```zsh
ec setup github:entityc/ec-springboot-lib:production/setups/BasicWebApp
```

This will start the process of installing a basic spring boot application. It will prompt you to enter information about the microservice it is setting up. Many of the prompts have default values:

```
INFO: Fetching setup: github:entityc/ec-springboot-lib:production/setups/BasicWebApp
INFO: Downloading file: setups/BasicWebApp.edl production
Enter project directory name [BasicWebApp]: 
INFO: Downloading file: setups/BasicWebAppSetupTemplate.eml production
INFO: Downloading file: setups/MakeRunECScriptTemplate.eml production
Enter the name of the application [MyApp]: 
Enter optional URL prefix for the application (e.g., my/app): 
Enter the base Java package for all installed/generated source files: org.entityc.sample.app
Enter an entity name to get things started [Widget]: 
Would you like to include Protobuf support (y/n)? [n]: 
```

After the prompts it will download and configure the Entity Compiler to build a sample Spring Boot based microservice.

The next step is to run the entity compiler for the project:

```zsh
cd BasicWebApp
./runec.sh
```

This will create the actual Spring Boot project using just a starter entity. 

If you run `ls` you will now see a script called `build.sh`. Run this script:

```zsh
./build.sh
```

This compile the project.

Before bring up the microservice you will need to setup a postgres database.

...

## Licensing

All projects of the EntityC Organization are under the BSD 3-clause License.

See [LICENSE.md](LICENSE.md) for details.

## Contributing

Contributors are welcome. Before contributing please read the following [Contributing Guidelines](CONTRIBUTING.md).

## Code of Conduct

The Code of Conduct governs how we behave in public or in private whenever the project will be judged by our actions.
We expect it to be honored by everyone who contributes to this project.

See [Code of Conduct](CODE_OF_CONDUCT.md) for details.
