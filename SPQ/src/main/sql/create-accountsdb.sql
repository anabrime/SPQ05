CREATE DATABASE RestaurantAdvisorDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON RestaurantAdvisorDB.*
           TO spq@'%'
           IDENTIFIED BY 'spq';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON RestaurantAdvisorDB.*
           TO spq@localhost
           IDENTIFIED BY 'spq';