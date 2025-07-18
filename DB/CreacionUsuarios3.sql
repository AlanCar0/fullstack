-- user para dev 
CREATE USER user_dev IDENTIFIED BY "Duocsemestre!2025"
DEFAULT TABLESPACE "DATA"
TEMPORARY TABLESPACE "TEMP"
QUOTA UNLIMITED ON USERS;
ALTER USER user_dev QUOTA UNLIMITED ON DATA;
GRANT CREATE SESSION TO user_dev;
GRANT "RESOURCE" TO user_dev;
ALTER USER user_dev DEFAULT ROLE "RESOURCE";
GRANT CREATE SESSION, RESOURCE TO user_dev;

-- user para test
CREATE USER user_test IDENTIFIED BY "Duocsemestre!2025"
DEFAULT TABLESPACE "DATA"
TEMPORARY TABLESPACE "TEMP"
QUOTA UNLIMITED ON USERS;
ALTER USER user_test QUOTA UNLIMITED ON DATA;
GRANT CREATE SESSION TO user_test;
GRANT "RESOURCE" TO user_test;
ALTER USER user_test DEFAULT ROLE "RESOURCE";
GRANT CREATE SESSION, RESOURCE TO user_test;
