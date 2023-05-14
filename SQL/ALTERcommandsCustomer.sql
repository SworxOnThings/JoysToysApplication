/*
ALTER TABLE customer ADD COLUMN username varchar(25),
ADD COLUMN password varchar(25);
*/

--ALTER TABLE customer ALTER COLUMN password TYPE bytea USING password::bytea; 
--UPDATE customer SET password=E'\\x243261243130246558617174424e6f70355a4b7252466753556768424f427847736b4f4d786631516734337047325047507950596a424a6d54326665' WHERE customer_id=1; 

--UPDATE customer SET username='SamIAm', password='abc123' WHERE customer_id=1;
--UPDATE customer SET password='$2a$10$jqbxFhONEIfcAQoHEzV8zeRxYxGvBpR1/splJnS6dhNZFog28Mukq' WHERE customer_id=1;
select * from customer;
