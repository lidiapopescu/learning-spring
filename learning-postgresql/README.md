  
## For Postgres command line operations:

  

    % PATH=$PATH:C:\Program Files\PostgreSQL\14\bin
    % export PATH

    % psql -p5433 "postgres"
    % psql -l -U postgres
    % psql -U postgres -p5433 TrainingDB
 <br>
   

    TrainingDB=# create table todotable(id int primary key, title varchar(64), summary varchar(64), description var char(64));
    CREATE TABLE
    TrainingDB=# \dt
    List of relations
    Schema | Name | Type | Owner
    --------+-----------------------+-------+----------
    public | todotable | table | postgres

 <br>

    TrainingDB=# \q # for exit
    TrainingDB=# \? # Know all available psql commands


More available postgresql commands [here](https://www.geeksforgeeks.org/postgresql-psql-commands/)

  ## Maven execute

 [Using Liquibase and your Maven POM File](https://docs.liquibase.com/tools-integrations/maven/using-liquibase-and-maven-pom-file.html)   

    $ mvn help:describe -DgroupId=org.liquibase -DartifactId=liquibase-maven-plugin -Dversion=2.0.1 -Dfull=true

  Run liquibase with maven

    $ mvn liquibase:update

## Gradle execute

    % ./gradlew bootRun





---
**Version 0.0.1**

Liquibase properties class path, etc are defined in both places,
- In maven pom file, starts with

> /db/changelog/db.changelog-master.xml

 and successfully works when build from maven

    $ mvn liquibase:update

- In application.properties

> classpath:db/changelog/db.changelog-master.xml

and successfully works when build from eclipse
TODO: How to configure universal configuration applicable for both ? How to inject values from application.properties into pom.xml ?