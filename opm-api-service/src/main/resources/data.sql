--CREATE DATABASE IF NOT EXISTS marvel;
CREATE TABLE IF NOT EXISTS AUDIT(id INT PRIMARY KEY, path VARCHAR(800), fecha TIME, hora TIME);
--INSERT INTO AUDIT (id, path,hora ) VALUES (1, '', null);
