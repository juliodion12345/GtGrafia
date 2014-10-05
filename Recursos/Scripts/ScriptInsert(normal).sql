-- ------------------------------------------------------------------------------------------------
-- ScriptInsert.sql
-- Carga de datos inicial
-- 
-- @author Andrea
-- @version 0.1
-- ------------------------------------------------------------------------------------------------

-- ------------------------------------------------------------------------------------------------
-- Tabla Usuario
-- ------------------------------------------------------------------------------------------------

INSERT INTO Usuario (nombre) VALUES ('Mayaka');
INSERT INTO Usuario (nombre) VALUES ('Nagato');
INSERT INTO Usuario (nombre) VALUES ('Matsuri');
INSERT INTO Usuario (nombre) VALUES ('Victorique');
INSERT INTO Usuario (nombre) VALUES ('Nadeko');

-- ------------------------------------------------------------------------------------------------
-- Tabla nivel
-- -------------------------------------------------------------------------------------------------
INSERT INTO Nivel (archivo, nombre) VALUES ('LAS_PALABRAS_AGUDAS.pdf', 'Palabras Agudas');

-- ------------------------------------------------------------------------------------------------
-- Tabla tipo_pregunta
-- ------------------------------------------------------------------------------------------------
INSERT INTO TipoPregunta (descripcion) VALUES ('Seleccion multiple');
INSERT INTO TipoPregunta (descripcion) VALUES ('Escrita');

-- ------------------------------------------------------------------------------------------------
-- Tabla Pregunta y Opcion
-- ------------------------------------------------------------------------------------------------
-- ----------------------------------------------
-- Nivel 1
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Ladrón', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Colibrí', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Fatal', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Bongó', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Pizarrón', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Canción', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Buscapiés', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Maíz', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Reloj', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Cinturón', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Avión', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Interés', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'País', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Capaz', 1, 1);
INSERT INTO Pregunta (enunciado, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que está escrita correctamente', 'Virtud', 1, 1);

INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ladrón', 1);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ladron', 1);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 1);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Colibri', 2);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Colibrí', 2);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 2);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Fatal', 3);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Fatál', 3);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 3);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Intencíon', 4);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Intencion', 4);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 4);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Bongó', 5);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Bongo', 5);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 5);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pizarron', 6);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pizarrón', 6);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 6);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pápel', 7);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Papél', 7);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 7);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cancion', 8);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Canción', 8);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 8);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Dieciseis', 9);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Dieciseís', 9);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 9);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Buscapiés', 10);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Buscapíes', 10);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 10);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Maíz', 11);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Maiz', 11);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 11);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Reloj', 12);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relój', 12);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 12);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cinturon', 13);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cinturón', 13);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 13);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Leon', 14);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Léon', 14);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 14);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Avión', 15);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Avíon', 15);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 15);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Raul', 16);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Rául', 16);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 16);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Interes', 17);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Interés', 17);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 17);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('País', 18);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pais', 18);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 18);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Capaz', 19);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Capáz', 19);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 19);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Virtúd', 20);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Virtud', 20);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 20);

-- ------------------------------------------------------------------------------------------------
-- Tabla UsuarioNivel
-- ------------------------------------------------------------------------------------------------
INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (1, 1);
INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (2, 1);
INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (3, 1);
INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (4, 1);
INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (5, 1);
