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
-- INSERT INTO Usuario (nombre) VALUES ('Mayaka');
-- INSERT INTO Usuario (nombre) VALUES ('Andrea');
-- INSERT INTO Usuario (nombre) VALUES ('Matsuri');
-- INSERT INTO Usuario (nombre) VALUES ('Victorique');
-- INSERT INTO Usuario (nombre) VALUES ('Nadeko');

-- ------------------------------------------------------------------------------------------------
-- Tabla nivel
-- -------------------------------------------------------------------------------------------------
INSERT INTO Nivel (archivo, nombre) VALUES ('LAS_PALABRAS_AGUDAS.pdf', 'Palabras Agudas');
INSERT INTO Nivel (archivo, nombre) VALUES ('LAS_PALABRAS_GRAVES.pdf', 'Palabras Graves');
INSERT INTO Nivel (archivo, nombre) VALUES ('LAS_PALABRAS_ESDRUJULAS.pdf', 'Palabras Esdrújulas');
INSERT INTO Nivel (archivo, nombre) VALUES ('LAS_PALABRAS_SOBRESDRUJULAS.pdf', 'Palabras Sobresdrújulas');
INSERT INTO Nivel (archivo, nombre) VALUES ('PREFIJOS.pdf', 'Prefijos');
INSERT INTO Nivel (archivo, nombre) VALUES ('SUFIJOS.pdf', 'Sufijos');
INSERT INTO Nivel (archivo, nombre) VALUES ('SUPERLATIVOS.pdf', 'Superlativos');
INSERT INTO Nivel (archivo, nombre) VALUES ('USO_B_V.pdf', 'Uso de la letra B y V');
INSERT INTO Nivel (archivo, nombre) VALUES ('USO_C_S_Z.pdf', 'Uso de la letra C, S y Z');
INSERT INTO Nivel (archivo, nombre) VALUES ('USO_G_J.pdf', 'Uso de la letra G y J');
INSERT INTO Nivel (archivo, nombre) VALUES ('USO_H.pdf', 'Uso de la letra H');
INSERT INTO Nivel (archivo, nombre) VALUES ('USO_X.pdf', 'Uso de la letra X');

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
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ladrón', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Colibrí', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Fatal', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Bongó', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Pizarrón', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Canción', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Buscapiés', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Maíz', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Reloj', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Cinturón', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Avión', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Interés', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'País', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Capaz', 1, 1);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Virtud', 1, 1);

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

-- ----------------------------------------------
-- Nivel 2
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Lápiz', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ortografía', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Día', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ángel', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Hábil', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Adulto', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Débil', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Línea', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'María', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Difícil', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Azúcar', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Pesca', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Estéril', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Biología', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Éter', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Tráiler', 1, 2);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Problema', 1, 2);

INSERT INTO Opcion (palabra, idPregunta) VALUES ('Lapiz', 21);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Lápiz', 21);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 21);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Agoniá', 22);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Agonia', 22);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 22);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ortografíá', 23);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ortografía', 23);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 23);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Día', 24);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Dia', 24);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 24);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Caractér', 25);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Caracter', 25);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 25);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ángel', 26);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Angel', 26);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 26);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Hábil', 27);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Habil', 27);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 27);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Adúlto', 28);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Adulto', 28);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 28);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Débil', 29);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Debíl', 29);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 29);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Linea', 30);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Línea', 30);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 30);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('María', 31);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Maria', 31);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 31);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Dificil', 32);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Difícil', 32);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 32);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Azucar', 33);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Azúcar', 33);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 33);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pesca', 34);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pésca', 34);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 34);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Estéril', 35);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Esteril', 35);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 35);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Biologia', 36);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Biología', 36);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 36);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Éter', 37);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Eter', 37);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 37);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Volumén', 38);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Volúmen', 38);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 38);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Tráiler', 39);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Trailer', 39);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 39);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Problema', 40);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Probléma', 40);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 40);

-- ----------------------------------------------
-- Nivel 3
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Idolo', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Término', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Cárceles', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Gráfica', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Adjetivo', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Heterogéneo', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Década', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Cólera', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Delante', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Bóveda', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Tristeza', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Cálculo', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Centímetro', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Pirámide', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Rectángulo', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Presidente', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Geométrica', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Matemática', 1, 3);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Didáctico', 1, 3);

INSERT INTO Opcion (palabra, idPregunta) VALUES ('Heroe ', 41);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Heróe', 41);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 41);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ídolo', 42);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Idolo', 42);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 42);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Término', 43);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Térmíno', 43);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 43);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Carceles', 44);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cárceles', 44);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 44);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Gráfica', 45);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Grafíca', 45);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 45);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Adjetivo', 46);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Adjétivo', 46);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 46);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Heterógeneo', 47);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Heterogéneo', 47);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 47);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Decada', 48);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Década', 48);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 48);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Colera', 49);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cólera', 49);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 49);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Délante', 50);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Delante', 50);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 50);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Bóvéda', 51);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Bóveda', 51);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 51);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Tristeza', 52);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Trísteza', 52);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 52);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Calcúlo', 53);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cálculo', 53);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 53);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Centímetro', 54);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Centimetro', 54);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 54);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Píramide', 55);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pirámide', 55);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 55);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Rectángulo', 56);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Rectangulo', 56);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 56);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Presidente', 57);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Presídente', 57);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 57);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Geómetrica', 58);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Geométrica', 58);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 58);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Matemática', 59);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Matématica', 59);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 59);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Didáctico', 60);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Didactico', 60);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 60);

-- ----------------------------------------------
-- Nivel 4
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ábremelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Agítamelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Apágamelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Apréndetelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Cocínaselo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Estúdiatelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Infórmaselo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Juégatela', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Júntamelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Júramelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Piénsatelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Píntaselo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Pruébatelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ruégamelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Quítamelo', 1, 4);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra escrita correctamente', '', 'Ninguna', 1, 4);

INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ábremelo', 61);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Abrémelo', 61);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 61);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Agitamelo', 62);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Agítamelo', 62);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 62);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Apagamelo', 63);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Apágamelo', 63);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 63);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Apréndetelo', 64);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Aprendételo', 64);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 64);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cedemelo', 65);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cédémelo', 65);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 65);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cocínaselo', 66);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cocinaselo', 66);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 66);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cómánselo', 67);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cománselo', 67);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 67);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Comenteselo', 68);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Cómenteselo', 68);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 68);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Estúdiatelo', 69);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Estudiatelo', 69);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 69);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Infórmaselo', 70);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Informaselo', 70);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 70);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Juegatela', 71);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Juégatela', 71);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 71);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Júntamelo', 72);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Júntámelo', 72);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 72);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Júrámelo', 73);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Júramelo', 73);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 73);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Llévatélo', 74);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Llévátelo', 74);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 74);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Piensatelo', 75);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Piénsatelo', 75);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 75);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Píntaselo', 76);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Píntaseló', 76);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 76);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pruebatelo', 77);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Pruébatelo', 77);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 77);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ruégamelo', 78);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ruegamelo', 78);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 78);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Quitamelo', 79);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Quítamelo', 79);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 79);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Véndémelo', 80);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Védemeló', 80);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Ninguna', 80);

-- ----------------------------------------------
-- Nivel 5
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Dígaselo a __', 'él', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Pásame __ libro', 'el', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '__ sabes lo que dices', 'Tú', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Aquí está __ maleta', 'tu', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Ésta es __ casa', 'mi', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Esto es para __', 'mí', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Debes llegar a la nota __', 'mi', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '¿Quieres tomar __?', 'té', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '__ quiero mucho', 'Te', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '__ que eres prudente', 'Sé', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'No __ lo digas', 'se', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Me voy __ viaje', 'de', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '__ lo que corresponda', 'Dé', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '__ llegas tarde, no te esperaremos', 'Si', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Dijo para __ mismo', 'sí', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', '__, lo aseguro', 'si', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Te fui a ver, ___ no te encontré', 'mas', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Quiero ___', 'más', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'El presidente crítica que ___ no hay arrestos', 'aún', 1, 5);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione la palabra que corresponda', 'Cuando sacaron las armas, ___ los más valientes se retiraron', 'aun', 1, 5);

INSERT INTO Opcion (palabra, idPregunta) VALUES ('Él', 81);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('El', 81);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Él', 82);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('El', 82);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Tú', 83);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Tu', 83);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Tú', 84);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Tu', 84);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mí', 85);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mi', 85);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mí', 86);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mi', 86);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mí', 87);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mi', 87);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Té', 88);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Te', 88);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Té', 89);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Te', 89);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Sé', 90);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Se', 90);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Sé', 91);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Se', 91);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Dé', 92);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('De', 92);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Dé', 93);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('De', 93);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Sí', 94);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Si', 94);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Sí', 95);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Si', 95);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Sí', 96);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Si', 96);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Más', 97);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mas', 97);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Más', 98);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Mas', 98);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Aún', 99);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Aun', 99);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Aún', 100);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Aun', 100);

-- ----------------------------------------------
-- Nivel 6
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Antesala', 'Ante', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Despedazar', 'Des', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Tostador', 'Dor', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Ingeniero', 'Ero', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Antisocial', 'Anti', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Domador', 'Dor', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Automóvil', 'Auto', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Adicción', 'Ción', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Inframundo', 'Infra', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Monoplano', 'Mono', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Verdad', 'Dad', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Amigdalitis', 'Itis', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Sobrefunda', 'Sobre', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Antropomorfo', 'Morfo', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Perecedero', 'Dero', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Frescura', 'Ura', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Atletismo', 'Ismo', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Intratable', 'Intra', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Proactiva', 'Pro', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Omnívoro', 'Omní', 2, 6);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe el prefijo o sufijo utilizado', 'Rebaja', 'Re', 2, 6);

-- ----------------------------------------------
-- Nivel 7
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Karla es la mejor de mis amigas', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Eres el peor de todos', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'El pastel esta riquísimo', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'La Mona Lisa es la pintura más bella', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Juan es muy bajo', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Antonio se conforma con muy poco', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Albert Einstein fue una persona muy inteligente', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'El mejor proyecto entregado, fue el de Cristian', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Las tortugas son animales muy capaces para sobrevivir', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Sé el mejor de todos', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'No seas el más molesto de mis conocidos', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Juan se preparó mejor que los demás', 'Relativo', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Perdió la vida muy rápidamente', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Tiene muchísima facilidad para bailar', 'Absoluto', 1, 7);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Seleccione el tipo de superlativo utilizado', 'Se alejó de los escenarios por ser muy bella', 'Absoluto', 1, 7);

INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 122);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 122);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 123);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 123);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 124);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 124);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 125);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 125);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 126);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 126);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 127);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 127);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 128);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 128);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 129);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 129);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 130);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 130);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 131);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 131);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 132);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 132);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 133);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 133);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 134);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 134);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 135);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 135);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 136);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 136);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Absoluto', 137);
INSERT INTO Opcion (palabra, idPregunta) VALUES ('Relativo', 137);

-- ----------------------------------------------
-- Nivel 8
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El doctor preparó un jarabe noci_o', 'nocivo', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El gerente no pre_ió que el sábado era día festivo', 'previó', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El di_ujo era muy detallado', 'dibujo', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El anuncio fue bre_e y conciso', 'breve', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'Las respuestas eran e_identes y sencillas', 'evidentes', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'Los bom_eros ayudaron a ese gatito', 'bomberos', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'Los payasos del circo también son equili_ristas', 'equilibristas', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El nuevo presidente es muy negati_o', 'negativo', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El po_re no encontró un lugar para descansar', 'pobre', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'La ardilla no estaba en su am_iente natural', 'ambiente', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'La _atalla fue perdida a manos del imperio enemigo', 'batalla', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El entrenador tuvo un comportamiento antideporti_o', 'antideportivo', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El ado_ado estaba muy delicioso', 'adobado', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El perfume tiene un olor a u_a', 'uva', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'El ácido es muy corrosi_o', 'corrosivo', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'Las _aterías alcalinas son muy utilizadas en los controles remotos', 'baterías', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'La em_otelladora vende unicamente refrescos', 'embotelladora', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'La am_ulancia se llevó a los heridos al hospital', 'ambulancia', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'La pre_enta de juegos es un negocio muy rentable', 'preventa', 2, 8);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando b o v según corresponda', 'Van a derri_ar el edificio viejo', 'derribar', 2, 8);

-- ----------------------------------------------
-- Nivel 9
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La declaración que dió el acusado fue clara y con_isa', 'concisa', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'No tuvo nada que ver con el su_eso', 'suceso', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Fue una gran ha_aña la que logró', 'hazaña', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Fue una maldi_ión la que cayó sobre el equipo de búsqueda', 'maldición', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La puerta corredi_a se trabó por una piedra', 'corrediza', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La limpie_a no fue realizada correctamente', 'limpieza', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'El bar es exclu_ivo para mujeres', 'exclusivo', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La ta_ita de té estaba deliciosa', 'tacita', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'El tiempo o_ioso puede dañar la mente', 'ocioso', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Le dió un vista_o antes de que se perdiera en el horizonte', 'vistazo', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'El novio era muy celo_so y por eso terminaron', 'celoso', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La amiga fue muy ofen_iva con lo que dijo', 'ofensiva', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'El policía actuó con peri_ia y logró la captura', 'pericia', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Quisiera cono_er a esa persona', 'conocer', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La comida estuvo carí_ima', 'carísima', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Yo no pertene_co a ese grupo', 'pertenezco', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Le dió una gran pere_a terminar el enunciado', 'pereza', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'El se_go de especificación afecto al modelo definido', 'sesgo', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'La timide_ le afectó al hablarle a el', 'timidez', 2, 9);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando c, s o z según corresponda', 'Existe mas individuali_mo en estos tiempos', 'individualismo', 2, 9);

-- ----------------------------------------------
-- Nivel 10
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El cuadra_ésimo aniversario de la tragedia no fue recordado', 'cuadragésimo', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'Una gran virtud es saber dar el e_emplo', 'ejemplo', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El ju_o de uva es delicioso para la cena', 'jugo', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El de_enerado se aprovechó de la situación', 'degenerado', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'No se permite el voto a extran_eros', 'extranjeros', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El tra_e para mi boda ya esta listo', 'traje', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'Yo predi_e el fin del mundo', 'predije', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'La di_italización de datos va en buen camino', 'digitalización', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El ancla_e al dique otorga mayor seguridad al barco', 'anclaje', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El libertina_e es una de las causas de enojo para los padres de familia', 'libertinaje', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'Las personas a_nósticas desconocen la existencia de dioses', 'agnósticas', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El agua oxi_enada tiende a decolorar el pelo', 'oxigenada', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'La beren_ena envuelta en huevo es un platillo nutritivo', 'berenjena', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El _esto que recibí fue de mi agrado', 'gesto', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'La _eolo_ía es el estudio de la tierra', 'geología', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'Hemos estudiado esa ima_en por más de dos horas', 'imagen', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El programa para leer los _eroglíficos ha pasado la prueba', 'jeroglíficos', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El _erente de mercadeo alabó la creatividad de sus colaboradores', 'gerente', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El deter_ente arruino mi ropa', 'detergente', 2, 10);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando g o j según corresponda', 'El aborda_e se realizo sin éxito, ¡hay que abortar la misión!', 'abordaje', 2, 10);

-- ----------------------------------------------
-- Nivel 11
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'La comida grasosa te puede volver _ipertenso', 'hipertenso', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'El jugador sufrió de una _ernia discal', 'hernia', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'El _omo neanderthalensis es nuestro pariente humano mas cercano extinto', 'homo', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'La _arteria pasa la sangre oxigenada, desde el corazón hacia el cuerpo', 'arteria', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'El sistema está en des_uso por falta de mantenimiento', 'desuso', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'Mis amigos no pueden dejar de tomar alco_ol', 'alcohol', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'El reduccionismo es a menudo considerado el opuesto del _olismo', 'holismo', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'Espero que se la _aya pasado de maravilla', 'haya', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'Ellos _iban de viaje a las bahamas', 'iban', 2, 11);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra h según corresponda', 'Hay una pequeña _olgura en la unión del tornillo y la rosca', 'holgura', 2, 11);

-- ----------------------------------------------
-- Nivel 12
-- ----------------------------------------------
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'La feria es e_pecial', 'especial', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'La bomba e_plotó de manera maravillosa', 'explotó', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'El E_preso de Oriente es un servicio de tren de larga distancia', 'Expreso', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'Fue e_pléndido lo que hiciste con la computadora', 'espléndido', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'El maestro Tabares, dueño del _ilófono, ha caído en coma', 'xilófono', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'La _enofobia es un mal innecesario', 'xenofobia', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'E_primí las naranjas y los limones para hacer un delicioso jugo', 'Exprimí', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'Se realizó una actividad e_tracurricular', 'extracurricular', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'La e_cusa que presentó, no es válida', 'excusa', 2, 12);
INSERT INTO Pregunta (enunciado, pregunta, respuesta, idTipoPregunta, idNivel) VALUES ('Escribe la palabra colocando la letra x o alguna otra letra, según corresponda', 'Se fueron a e_plorar al bosque prohibido', 'explorar', 2, 12);

-- ------------------------------------------------------------------------------------------------
-- Tabla UsuarioNivel
-- ------------------------------------------------------------------------------------------------
-- INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (1, 1);
-- INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (2, 1);
-- INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (3, 1);
-- INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (4, 1);
-- INSERT INTO UsuarioNivel (idUsuario, idNivel) VALUES (5, 1);
