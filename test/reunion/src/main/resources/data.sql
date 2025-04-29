INSERT INTO reunion (id, asunto, fecha) VALUES (1, 'Progreso personal', '2023-06-01');
INSERT INTO reunion (id, asunto, fecha) VALUES (2, 'Seguimiento equipo', '2023-06-02');
INSERT INTO reunion (id, asunto, fecha) VALUES (3, 'General', '2023-06-03');

INSERT INTO persona (id, nombre, apellidos) VALUES (1, 'Juan', 'Gómez');
INSERT INTO persona (id, nombre, apellidos) VALUES (2, 'Marisa', 'López');
INSERT INTO persona (id, nombre, apellidos) VALUES (3, 'Ana', 'Pérez');
INSERT INTO persona (id, nombre, apellidos) VALUES (4, 'Luz', 'García');
INSERT INTO persona (id, nombre, apellidos) VALUES (5, 'Jose', 'Ruiz');

INSERT INTO asistente (reunion_id, persona_id) VALUES (1, 1);
INSERT INTO asistente (reunion_id, persona_id) VALUES (1, 2);
INSERT INTO asistente (reunion_id, persona_id) VALUES (2, 1);
INSERT INTO asistente (reunion_id, persona_id) VALUES (2, 3);
INSERT INTO asistente (reunion_id, persona_id) VALUES (2, 4);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 1);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 2);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 3);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 4);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 5);


INSERT INTO users (id, username, password, email, role, enabled) VALUES (2001, 'admin', '$2a$12$9SL83YEhhQ.7sgkSceL4LeXKRNIB/IFpw0FpAngEqxZmw/njI808W', 'hola@gmail.com', 'ROLE_ADMIN', 1); 
INSERT INTO users (id, username, password, email, role, enabled) VALUES (2002, 'adrian', '$2a$12$K2oxbcXG5xyijqiV5Ks/8e.Q1KbpdDdPK7WXxX0N2403y2J/NtwA6', 'adios@gmail.com', 'ROLE_USER', 1); 