-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2015 a las 17:17:04
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdhcradiologia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ct_epss`
--

CREATE TABLE IF NOT EXISTS `ct_epss` (
`cod_eps` int(11) NOT NULL,
  `nombre_eps` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ct_epss`
--

INSERT INTO `ct_epss` (`cod_eps`, `nombre_eps`) VALUES
(1, 'Colsanitas'),
(2, 'NuevaEPS'),


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ct_rhs`
--

CREATE TABLE IF NOT EXISTS `ct_rhs` (
`id_rh` int(11) NOT NULL,
  `nombre_rh` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ct_rhs`
--

INSERT INTO `ct_rhs` (`id_rh`, `nombre_rh`) VALUES
(1, 'B+'),
(2, 'O+');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ct_tiposdocumentos`
--

CREATE TABLE IF NOT EXISTS `ct_tiposdocumentos` (
`id_tipodocumento` int(11) NOT NULL,
  `iniciales_tipodocumento` varchar(2) NOT NULL,
  `tipo_documento` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ct_tiposdocumentos`
--

INSERT INTO `ct_tiposdocumentos` (`id_tipodocumento`, `iniciales_tipodocumento`, `tipo_documento`) VALUES
(1, 'CC', 'Cédula de ciudadania'),
(2, 'CE', 'Cedula de extrangeria'),
(3, 'RC', 'Registro civil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ct_tipos_datos_contactos`
--

CREATE TABLE IF NOT EXISTS `ct_tipos_datos_contactos` (
`id_tipo_dato_contacto` int(11) NOT NULL,
  `tipo_dato_contacto` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ct_tipos_datos_contactos`
--

INSERT INTO `ct_tipos_datos_contactos` (`id_tipo_dato_contacto`, `tipo_dato_contacto`) VALUES
(1, 'Direccion'),
(2, 'Celular'),
(3, 'Telefono');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ct_tipos_diagnosticos`
--

CREATE TABLE IF NOT EXISTS `ct_tipos_diagnosticos` (
`id_tipo_diagnostico` int(11) NOT NULL,
  `tipo_diagnostico` varchar(70) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ct_tipos_diagnosticos`
--

INSERT INTO `ct_tipos_diagnosticos` (`id_tipo_diagnostico`, `tipo_diagnostico`) VALUES
(1, 'Especifico'),
(2, 'General');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ct_tipos_imagenes`
--

CREATE TABLE IF NOT EXISTS `ct_tipos_imagenes` (
`id_tipo_imagen` int(11) NOT NULL,
  `tipo_imagen` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ct_tipos_imagenes`
--

INSERT INTO `ct_tipos_imagenes` (`id_tipo_imagen`, `tipo_imagen`) VALUES
(1, 'tomografía'),
(2, 'resonancia magnética');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_datos_contacto`
--

CREATE TABLE IF NOT EXISTS `tb_datos_contacto` (
`id_dato_contacto` int(11) NOT NULL,
  `persona_dato_contacto` int(11) DEFAULT NULL,
  `eps_dato_contacto` int(11) DEFAULT NULL,
  `dato_contacto` varchar(50) DEFAULT NULL,
  `tipo_dato_contacto` int(11) NOT NULL,
  `prioridad_dato_contacto` smallint(6) DEFAULT '1',
  `vigencia_dato_contacto` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_datos_contacto`
--

INSERT INTO `tb_datos_contacto` (`id_dato_contacto`, `persona_dato_contacto`, `eps_dato_contacto`, `dato_contacto`, `tipo_dato_contacto`, `prioridad_dato_contacto`, `vigencia_dato_contacto`) VALUES
(2, 1, NULL, '564556', 1, 1, 1),
(3, NULL, 1, '56094322', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_imagenes`
--

CREATE TABLE IF NOT EXISTS `tb_imagenes` (
`id_imagen` int(11) NOT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  `fecha_imagen` datetime NOT NULL,
  `orden_medica_imagen` int(11) NOT NULL,
  `diagnostico_imagen` varchar(255) DEFAULT NULL,
  `tipo_diagnostico_imagen` int(11) NOT NULL,
  `tipo_imagen` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_imagenes`
--

INSERT INTO `tb_imagenes` (`id_imagen`, `imagen`, `fecha_imagen`, `orden_medica_imagen`, `diagnostico_imagen`, `tipo_diagnostico_imagen`, `tipo_imagen`) VALUES
(2, 'C://Imagenes', '2014-12-21 00:00:00', 1, 'fractura', 1, 1),
(3, 'C://Imagenes', '2015-04-01 00:00:00', 1, 'Revision', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_ordenes_medicas`
--

CREATE TABLE IF NOT EXISTS `tb_ordenes_medicas` (
`id_orden_medica` int(11) NOT NULL,
  `medico_orden_medica` int(11) NOT NULL,
  `paciente_orden_medica` int(11) NOT NULL,
  `fecha_orden_medica` datetime NOT NULL,
  `observaciones_orden_medica` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_ordenes_medicas`
--

INSERT INTO `tb_ordenes_medicas` (`id_orden_medica`, `medico_orden_medica`, `paciente_orden_medica`, `fecha_orden_medica`, `observaciones_orden_medica`) VALUES
(1, 1, 1, '2015-04-01 00:00:00', NULL),
(2, 1, 1, '2014-12-21 00:00:00', 'Observacion'),
(3, 1, 1, '2014-08-11 00:00:00', 'Observaciones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_personas`
--

CREATE TABLE IF NOT EXISTS `tb_personas` (
`cod_persona` int(11) NOT NULL,
  `tip_doc_persona` int(11) NOT NULL,
  `num_doc_persona` varchar(12) NOT NULL,
  `prim_nombre_persona` varchar(25) NOT NULL,
  `seg_nombre_persona` varchar(25) DEFAULT NULL,
  `prim_apellido_persona` varchar(25) NOT NULL,
  `seg_apellido_persona` varchar(25) DEFAULT NULL,
  `femenino_persona` bit(1) NOT NULL,
  `medico_persona` bit(1) DEFAULT NULL,
  `especialidad_medica_persona` varchar(50) DEFAULT NULL,
  `fech_nacimiento_persona` datetime NOT NULL,
  `rh_persona` int(11) NOT NULL,
  `eps_persona` int(11) NOT NULL,
  `observaciones_persona` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_personas`
--

INSERT INTO `tb_personas` (`cod_persona`, `tip_doc_persona`, `num_doc_persona`, `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`, `femenino_persona`, `medico_persona`, `especialidad_medica_persona`, `fech_nacimiento_persona`, `rh_persona`, `eps_persona`, `observaciones_persona`) VALUES
(1, 1, '56090909', 'Luz', 'Sol', 'Lopez', 'Guarin', b'0', b'1', '', '1985-04-22 00:00:00', 1, 1, ''),
(2, 1, '563443', 'Ana', 'Sol', 'Lopera', 'Lopez', b'0', b'1', '', '1985-04-21 00:00:00', 1, 1, ''),
(3, 1, '45563', 'Jacinto', 'Cenovio', 'Linares', 'Garcia', b'0', b'0', 'Especialidad', '0000-00-00 00:00:00', 1, 1, ''),
(4, 1, '65455', 'Lola', '', 'Drones', 'Buenos', b'0', b'1', NULL, '1985-04-21 00:00:00', 1, 1, ''),
(5, 1, '65456788', 'Maria', '', 'Jimenes', '', b'0', b'1', NULL, '0000-00-00 00:00:00', 1, 1, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ct_epss`
--
ALTER TABLE `ct_epss`
 ADD PRIMARY KEY (`cod_eps`);

--
-- Indices de la tabla `ct_rhs`
--
ALTER TABLE `ct_rhs`
 ADD PRIMARY KEY (`id_rh`);

--
-- Indices de la tabla `ct_tiposdocumentos`
--
ALTER TABLE `ct_tiposdocumentos`
 ADD PRIMARY KEY (`id_tipodocumento`);

--
-- Indices de la tabla `ct_tipos_datos_contactos`
--
ALTER TABLE `ct_tipos_datos_contactos`
 ADD PRIMARY KEY (`id_tipo_dato_contacto`);

--
-- Indices de la tabla `ct_tipos_diagnosticos`
--
ALTER TABLE `ct_tipos_diagnosticos`
 ADD PRIMARY KEY (`id_tipo_diagnostico`);

--
-- Indices de la tabla `ct_tipos_imagenes`
--
ALTER TABLE `ct_tipos_imagenes`
 ADD PRIMARY KEY (`id_tipo_imagen`);

--
-- Indices de la tabla `tb_datos_contacto`
--
ALTER TABLE `tb_datos_contacto`
 ADD PRIMARY KEY (`id_dato_contacto`), ADD KEY `tipo_dato_contacto` (`tipo_dato_contacto`), ADD KEY `persona_dato_contacto` (`persona_dato_contacto`), ADD KEY `eps_dato_contacto` (`eps_dato_contacto`);

--
-- Indices de la tabla `tb_imagenes`
--
ALTER TABLE `tb_imagenes`
 ADD PRIMARY KEY (`id_imagen`), ADD KEY `tipo_diagnostico_imagen` (`tipo_diagnostico_imagen`), ADD KEY `tipo_imagen` (`tipo_imagen`), ADD KEY `orden_medica_imagen` (`orden_medica_imagen`);

--
-- Indices de la tabla `tb_ordenes_medicas`
--
ALTER TABLE `tb_ordenes_medicas`
 ADD PRIMARY KEY (`id_orden_medica`), ADD KEY `paciente_orden_medica` (`paciente_orden_medica`), ADD KEY `medico_orden_medica` (`medico_orden_medica`);

--
-- Indices de la tabla `tb_personas`
--
ALTER TABLE `tb_personas`
 ADD PRIMARY KEY (`cod_persona`), ADD KEY `rh_persona` (`rh_persona`), ADD KEY `tip_doc_persona` (`tip_doc_persona`), ADD KEY `eps_persona` (`eps_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ct_epss`
--
ALTER TABLE `ct_epss`
MODIFY `cod_eps` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `ct_rhs`
--
ALTER TABLE `ct_rhs`
MODIFY `id_rh` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `ct_tiposdocumentos`
--
ALTER TABLE `ct_tiposdocumentos`
MODIFY `id_tipodocumento` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `ct_tipos_datos_contactos`
--
ALTER TABLE `ct_tipos_datos_contactos`
MODIFY `id_tipo_dato_contacto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `ct_tipos_diagnosticos`
--
ALTER TABLE `ct_tipos_diagnosticos`
MODIFY `id_tipo_diagnostico` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `ct_tipos_imagenes`
--
ALTER TABLE `ct_tipos_imagenes`
MODIFY `id_tipo_imagen` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tb_datos_contacto`
--
ALTER TABLE `tb_datos_contacto`
MODIFY `id_dato_contacto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tb_imagenes`
--
ALTER TABLE `tb_imagenes`
MODIFY `id_imagen` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tb_ordenes_medicas`
--
ALTER TABLE `tb_ordenes_medicas`
MODIFY `id_orden_medica` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tb_personas`
--
ALTER TABLE `tb_personas`
MODIFY `cod_persona` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_datos_contacto`
--
ALTER TABLE `tb_datos_contacto`
ADD CONSTRAINT `FK_tb_datos_contacto_ct_tipo_dato_contacto` FOREIGN KEY (`tipo_dato_contacto`) REFERENCES `ct_tipos_datos_contactos` (`id_tipo_dato_contacto`) ON UPDATE CASCADE,
ADD CONSTRAINT `FK_tb_datos_contacto_tb_personas` FOREIGN KEY (`persona_dato_contacto`) REFERENCES `tb_personas` (`cod_persona`) ON UPDATE CASCADE,
ADD CONSTRAINT `tb_datos_contacto_ibfk_1` FOREIGN KEY (`eps_dato_contacto`) REFERENCES `ct_epss` (`cod_eps`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tb_imagenes`
--
ALTER TABLE `tb_imagenes`
ADD CONSTRAINT `FK_tb_imagenes_ct_tipos_diagnosticos` FOREIGN KEY (`tipo_diagnostico_imagen`) REFERENCES `ct_tipos_diagnosticos` (`id_tipo_diagnostico`) ON UPDATE CASCADE,
ADD CONSTRAINT `FK_tb_imagenes_ct_tipos_imagenes` FOREIGN KEY (`tipo_imagen`) REFERENCES `ct_tipos_imagenes` (`id_tipo_imagen`) ON UPDATE CASCADE,
ADD CONSTRAINT `FK_tb_imagenes_tb_ordenes_medicas` FOREIGN KEY (`orden_medica_imagen`) REFERENCES `tb_ordenes_medicas` (`id_orden_medica`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tb_ordenes_medicas`
--
ALTER TABLE `tb_ordenes_medicas`
ADD CONSTRAINT `FK_tb_ordenes_medicas_tb_personas_medico` FOREIGN KEY (`medico_orden_medica`) REFERENCES `tb_personas` (`cod_persona`) ON UPDATE CASCADE,
ADD CONSTRAINT `FK_tb_ordenes_medicas_tb_personas_paciente` FOREIGN KEY (`paciente_orden_medica`) REFERENCES `tb_personas` (`cod_persona`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tb_personas`
--
ALTER TABLE `tb_personas`
ADD CONSTRAINT `FK_tb_personas_ct_rhs` FOREIGN KEY (`rh_persona`) REFERENCES `ct_rhs` (`id_rh`) ON UPDATE CASCADE,
ADD CONSTRAINT `FK_tb_personas_ct_tiposdocumentos` FOREIGN KEY (`tip_doc_persona`) REFERENCES `ct_tiposdocumentos` (`id_tipodocumento`) ON UPDATE CASCADE,
ADD CONSTRAINT `tb_personas_ibfk_1` FOREIGN KEY (`eps_persona`) REFERENCES `ct_epss` (`cod_eps`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
