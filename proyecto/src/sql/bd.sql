SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP SCHEMA IF EXISTS ProyectoBD;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA ProyectoBD;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON ProyectoBD.* TO 'spq'@'localhost';

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`email`),
  ADD UNIQUE KEY `email` (`email`);
COMMIT;
