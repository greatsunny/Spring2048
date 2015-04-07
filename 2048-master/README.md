![Spring2048](src/main/webapp/public-resources/image/logo.png)

## Introduction

A place of Spring+2048!

Which provides basic login and register processes, score viewing process.

Overall project is built on **Spring**, **Spring MVC**, **Hibernate**, **Maven** and right here on **Github**, hence the following requirements are for your references.

## Requirements

* Java7+
* Spring4+
* Hibernate3.6+
* Bootstrap3.2+
* MySQL5+
* HSQL1.8+
* Tomcat7+

## Project Setup

1. [Lombok](http://projectlombok.org)
  * For eclipse
    1. place the lombok.jar together with the eclipse.ini
    2. open the eclipse.ini and add `-javaagent:lombok.jar` at the end of the file
  * For IntelliJ
    1. add the lombok plugin
  * Add the dependency into the pom.xml
2. Import as a maven project
  * `mvn jetty:run` for the quick development and open the `http://localhost:8555`
  * `mvn package` for the war output and deploy to a Tomcat

## Memory DB

We have 2 users in memory DB right now
* User 1
  * Username: Cloud
  * Password: cloud
* User 2
  * Username: Ben
  * Password: ben

Details please refer to [schema.sql](src/main/resources/spring2048/sql/schema.sql) and [data.sql](src/main/resources/spring2048/sql/data.sql)


## Possible Extension

* To configure a verification code in the sign in/sign up screen to avoid robot registrations.
* To switch to the persistent DB instead of memory DB.
* To enable session management when e.g. session is timeout but game is not over.
* To implement pagination on list score section.

## License

Origin license please see [HERE](LICENSE/LICENSE.txt).