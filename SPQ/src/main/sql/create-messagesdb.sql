CREATE DATABASE messagesDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON messagesDB.*
           TO spq@'%'
           IDENTIFIED BY 'spq';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON messagesDB.*
           TO spq@localhost
           IDENTIFIED BY 'spq';