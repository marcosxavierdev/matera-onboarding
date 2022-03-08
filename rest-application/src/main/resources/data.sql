DROP TABLE IF EXISTS example;

CREATE TABLE example (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  message VARCHAR(250) NOT NULL
);

INSERT INTO example (message) VALUES ('Hello World!');

INSERT INTO marital_status (status) VALUES ('Solteiro');
INSERT INTO marital_status (status) VALUES ('Casado');

INSERT INTO telephone_type (type) VALUES ('Trabalho');
INSERT INTO telephone_type (type) VALUES ('Mobile');

INSERT INTO identity_document_type (type) VALUES ('RG');
INSERT INTO identity_document_type (type) VALUES ('CNH');

INSERT INTO client (cpf, birthday, Ind_special_client, name, marital_status_id) VALUES ('123', '1985-06-05', true, 'marcos', 2);
INSERT INTO client (cpf, birthday, Ind_special_client, name, marital_status_id) VALUES ('987', '2000-06-05', false, 'Carol', 1);

INSERT INTO address (street_name, district, city, state, zip_code, complement, number, client_id) VALUES ('rua abc', 'extremo sul', 'eunapolis', 'bahia', 45820000, 'none', 1, 1);
INSERT INTO address (street_name, district, city, state, zip_code, complement, number, client_id) VALUES ('rua zwx', 'capital', 'salvador', 'bahia', 4000000, 'none', 250, 1);
INSERT INTO address (street_name, district, city, state, zip_code, complement, number, client_id) VALUES ('rua 456', 'capital', 'manaus', 'amazonas', 1500000, 'none', 154, 2);

INSERT INTO telephone (number, ddd, client_id, telephone_type_id ) VALUES ('0000000000', '73', 1,  1);
INSERT INTO telephone (number, ddd, client_id, telephone_type_id ) VALUES ('9999999999', '73', 1,  2);
INSERT INTO telephone (number, ddd, client_id, telephone_type_id ) VALUES ('8888888888', '73', 2,  1);

INSERT INTO identity_document (sequence, client_id, identity_document_type_id) VALUES ('22222', 1, 1);
INSERT INTO identity_document (sequence, client_id, identity_document_type_id) VALUES ('11111', 1, 2);
INSERT INTO identity_document (sequence, client_id, identity_document_type_id) VALUES ('33333', 2, 2);