CREATE USER 'sample-user'@'%' IDENTIFIED BY 'password';
GRANT SELECT,INSERT,UPDATE,DELETE,EXECUTE,SHOW VIEW ON sample.* TO 'sample-user'@'%';