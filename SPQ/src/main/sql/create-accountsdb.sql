CREATE DATABASE RestaurantAdvisorDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON RestaurantAdvisorDB.*
           TO root@'%'
           IDENTIFIED BY '';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON RestaurantAdvisorDB.*
           TO root@localhost
           IDENTIFIED BY '';