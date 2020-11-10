# University task
This is the project that satisfy test task from the BotsCrew. 

The main idea - to create console application working with university departments and lectors.

Project was written on `Java 11` and `Spring Boot`, JPA - `Spring Data`, storage - `MySQL`,
 build automation tool - `Maven`.

Technologies used in this project:

- Java 11
- Spring Boot
- Spring Data
- MySQL
- Maven

#### How to work with the project
First all you need to have working MySQL RDBMS. Create schema with name `'university'`. 

Fork the project and import to Intellij IDEA.
In resources directory open file application.properties.
Change user and password to yours.

There's a bean to inject some starter info. It is called automatically, you don't need to call it.

##### There are 6 type of commands:

1. `Who is head of department {department_name}`
2. `Show {department_name} statistics`
3. `Show the average salary for the department {department_name}`
4. `Show count of employee for {department_name}`
5. `Global search by {template}`
6. `Close`

You can enter command one after another. If you want to stop the application just enter `Close`

P.S dont forget to allow auto-import for maven dependencies or import all of them before starting the project.
