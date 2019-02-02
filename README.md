# Get Started

#### READ ME FIRST
* This is created earlier on. To merge this project with other spring related projects. 
* or to refactor this project so that it illustrates some unique features of spring
* so that we either delete the project or rename it after refactoring

#### TODO
* Continue to simplify and comment on build.gradle

#### How to Import this project into IDE
* Use IntelliJ to "New -> Project from existing source"
* Click build.gradle of the project and click ok
* Tick "Use auto-import / Create separate module per source set / Use default gradle wrapper" options, click ok
* IntelliJ may take a while to parse and process buid.gradle file
* In the Project tool window, right-click the project directory and from the drop-down list select Add Framework Support.
* Tick "Groovy" and click ok to add groovy framework support.

#### How to run this application

* Reference [Gradle Command Line](https://docs.gradle.org/current/userguide/gradle_command_line.html)

* Basic gradle command format: gradlew [options] [tasks]
  * -Pprop=value    //set a project property 'prop' of the root project to 'value'
  * -Dprop=value    //set a system property of the JVM, however in this case setting in gradle.properties are preferred. Read more [here](https://docs.gradle.org/current/userguide/build_environment.html#sec:gradle_properties_and_system_properties) -D is a java JRE command switch to set the system property too

* Working Commands Option 1 (Faster, for development)
  * ```gradelw clean build bootRun -Dycm.command=say_hello```

* Working Commands Option 2 (Preferred, for SIT/PROD-time invocation)
  * ```gradelw clean build```
  * ```java -jar build\libs\hello-springboot-exec.jar --ycm.command=say_hello```
  * Note that by default SpringApplication will convert any command line option arguments (starting with ‘--’) to a property and add it to the Spring Environment and make it part of the property source. Read more [here](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)

#### Test the Spring Boot with different profiles

We will test the following four profiles: default, SIT, China, SIT+China

* ```gradlew bootRun -Dycm.command=say_hello```
```
2017-12-08 16:38:29.556  WARN 5896 --- [           main] com.ycm.HelloSpringBootCommand           : environment notification: default environment
2017-12-08 16:38:29.558  INFO 5896 --- [           main] com.ycm.HelloSpringBootCommand           : db url is jdbc:mysql://localhost:5432/dbinstance
2017-12-08 16:38:29.560  INFO 5896 --- [           main] com.ycm.HelloSpringBootCommand           : db username is foo
2017-12-08 16:38:29.560  INFO 5896 --- [           main] com.ycm.HelloSpringBootCommand           : db password is bar
2017-12-08 16:38:29.560  INFO 5896 --- [           main] com.ycm.HelloSpringBootCommand           : the payment method is cash
2017-12-08 16:38:29.560  INFO 5896 --- [           main] com.ycm.HelloSpringBootCommand           : exiting the application...
```
* ```gradlew bootRun -Dycm.command=say_hello -Dspring.profiles.active=SIT```
```
2017-12-08 16:39:24.168  WARN 12452 --- [           main] com.ycm.HelloSpringBootCommand           : environment notification: SIT environment
2017-12-08 16:39:24.172  INFO 12452 --- [           main] com.ycm.HelloSpringBootCommand           : db url is jdbc:postgresql:/sithost:5432/dbinstance
2017-12-08 16:39:24.172  INFO 12452 --- [           main] com.ycm.HelloSpringBootCommand           : db username is situser
2017-12-08 16:39:24.174  INFO 12452 --- [           main] com.ycm.HelloSpringBootCommand           : db password is sitpassword
2017-12-08 16:39:24.176  INFO 12452 --- [           main] com.ycm.HelloSpringBootCommand           : the payment method is cash
2017-12-08 16:39:24.176  INFO 12452 --- [           main] com.ycm.HelloSpringBootCommand           : exiting the application...
```
* ```gradlew bootRun -Dycm.command=say_hello -Dspring.profiles.active=China```
```
2017-12-08 16:40:41.513  WARN 6560 --- [           main] com.ycm.HelloSpringBootCommand           : environment notification: default environment
2017-12-08 16:40:41.517  INFO 6560 --- [           main] com.ycm.HelloSpringBootCommand           : db url is jdbc:mysql://localhost:5432/dbinstance
2017-12-08 16:40:41.517  INFO 6560 --- [           main] com.ycm.HelloSpringBootCommand           : db username is foo
2017-12-08 16:40:41.519  INFO 6560 --- [           main] com.ycm.HelloSpringBootCommand           : db password is bar
2017-12-08 16:40:41.519  INFO 6560 --- [           main] com.ycm.HelloSpringBootCommand           : the payment method is alipay
2017-12-08 16:40:41.519  INFO 6560 --- [           main] com.ycm.HelloSpringBootCommand           : exiting the application...
```
* ```gradlew bootRun -Dycm.command=say_hello -Dspring.profiles.active=SIT,China```
```
2017-12-08 16:42:14.642  WARN 10920 --- [           main] com.ycm.HelloSpringBootCommand           : environment notification: SIT environment
2017-12-08 16:42:14.645  INFO 10920 --- [           main] com.ycm.HelloSpringBootCommand           : db url is jdbc:postgresql:/sithost:5432/dbinstance
2017-12-08 16:42:14.645  INFO 10920 --- [           main] com.ycm.HelloSpringBootCommand           : db username is situser
2017-12-08 16:42:14.647  INFO 10920 --- [           main] com.ycm.HelloSpringBootCommand           : db password is sitpassword
2017-12-08 16:42:14.647  INFO 10920 --- [           main] com.ycm.HelloSpringBootCommand           : the payment method is alipay
2017-12-08 16:42:14.647  INFO 10920 --- [           main] com.ycm.HelloSpringBootCommand           : exiting the application...
```
* ```gradlew bootRun -Dycm.command=say_hello -Dspring.profiles.active=SIT,China,US```
```
2017-12-08 16:45:51.638  WARN 13832 --- [           main] com.ycm.HelloSpringBootCommand           : environment notification: SIT environment
2017-12-08 16:45:51.641  INFO 13832 --- [           main] com.ycm.HelloSpringBootCommand           : db url is jdbc:postgresql:/sithost:5432/dbinstance
2017-12-08 16:45:51.641  INFO 13832 --- [           main] com.ycm.HelloSpringBootCommand           : db username is situser
2017-12-08 16:45:51.643  INFO 13832 --- [           main] com.ycm.HelloSpringBootCommand           : db password is sitpassword
2017-12-08 16:45:51.643  INFO 13832 --- [           main] com.ycm.HelloSpringBootCommand           : the payment method is paypal
2017-12-08 16:45:51.644  INFO 13832 --- [           main] com.ycm.HelloSpringBootCommand           : exiting the application...
```
