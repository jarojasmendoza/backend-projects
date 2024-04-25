-- Insertar usuarios
INSERT INTO usuario (id, name, email, password, created, modified, last_login, token, active)
VALUES ('aebe29b3-55d9-4561-8409-3651c2210964', 'Juan Rodriguez', 'juan@rodriguez.org', 'hunter2J@1as', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'TOKEN_1', true),
       ('6844a343-ef7d-4005-86eb-be32134ec7ef', 'María López', 'maria@lopez.org', 'claveMaría123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'TOKEN_2', true);

-- Insertar teléfonos
INSERT INTO phone (number, citycode, countrycode, usuario_id)
VALUES ('123456789', '1', '57', 'aebe29b3-55d9-4561-8409-3651c2210964'),
       ('987654321', '2', '57', '6844a343-ef7d-4005-86eb-be32134ec7ef');
