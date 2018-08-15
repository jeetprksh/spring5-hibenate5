# spring5-hibenate5

A startup RESTful project for Spring 5 and Hibernate 5 integration without any XML configuration, using MySQL server as its database.

## Database scripts

Following SQL script can be used to create and populate the MySQL database with test data.

```
create table if not exists `users` (
  `id`		int not null auto_increment,
  `firstName`	varchar(20),
  `lastName`	varchar(20),
  `age`		int,
  primary key (`id`)
);
insert into `users` values (1, "john", "doe", 29);
```

For further details head to the related [blog post](https://jeetprksh.com/post/no-xml-spring-and-hibernate-integration/).