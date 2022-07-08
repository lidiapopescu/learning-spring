  
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