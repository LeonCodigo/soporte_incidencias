CREATE DATABASE db_soporte_incidente;
use db_soporte_incidente;




SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `db-soporte-incidente`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCli` int(10) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(12) NOT NULL,
  `razonS` varchar(40) NOT NULL,
  `nom` varchar(60) NOT NULL,
  `ape` varchar(50) NOT NULL,
  `dire` varchar(60) NOT NULL,
  `cel` varchar(15) NOT NULL,
  `mail` varchar(60) NOT NULL,
  `contrato` varchar(30) NOT NULL,
  `altaCliente` date NOT NULL,
  PRIMARY KEY (`idCli`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCli`, `cuit`, `razonS`, `nom`, `ape`, `dire`, `cel`, `mail`, `contrato`, `altaCliente`) VALUES
(1, '23', 'n', 'b', 'f', 'e', 's', 'g', 'f', '2023-11-19'),
(2, '23', 'we', 'we', 'we', 'we', 'we', 'we', 'we', '2023-11-19'),
(3, '27266384471', 'corralon jujuy', 'noemi', 'maldonado', 'jujuy 123', '3816787878', 'mmmmmmmm@gmail.com', '1', '2023-11-21'),
(4, '27064121303', 'DESPENSA AGU Y MATY', 'ANGELA ', 'CAMACHO', 'AYACUCHO 293', '543814020202', 'DDDDDDDDDDDD@CPM', 'HSDTR', '2023-11-21'),
(5, '20231162259', 'EXPRESO RIVADAVIA', 'NADIA', 'ROJAS', 'BS AS 345', '543815695847', 'DDDDDDDDDDDDDDDD', 'HPLACASEXT', '2023-11-21'),
(6, '20231165593', 'EXPRESO bISONTE', 'JULIAN', 'TELLO', 'PV 2 DEABRIL 123', '381641456925', 'DDDDDDDDDDDDDDD', 'HPLACASEXT', '2023-11-21'),
(7, '207845699875', 'La vaca', 'noelia', 'guzman', 'florida 20', '5438356415265', 'ddddddddddddd', 'SOFWIND', '2023-11-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientecontrato`
--

DROP TABLE IF EXISTS `clientecontrato`;
CREATE TABLE IF NOT EXISTS `clientecontrato` (
  `idCliente` int(11) NOT NULL,
  `idSoporte` int(11) NOT NULL,
  `altaContrato` date NOT NULL,
  PRIMARY KEY (`idCliente`,`idSoporte`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `cuitEmpleado` varchar(15) NOT NULL,
  `nomEmpleado` varchar(40) NOT NULL,
  `apeEmpleado` varchar(40) NOT NULL,
  `direEmpleado` varchar(50) NOT NULL,
  `celEmpleado` varchar(12) NOT NULL,
  `mailEmpleado` varchar(50) NOT NULL,
  `altaEmpleado` date NOT NULL,
  `areaEmpleado` varchar(40) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `cuitEmpleado` (`cuitEmpleado`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `cuitEmpleado`, `nomEmpleado`, `apeEmpleado`, `direEmpleado`, `celEmpleado`, `mailEmpleado`, `altaEmpleado`, `areaEmpleado`) VALUES
(1, '45', 'eeee', 'rrrrrrrrr', 'ttttttttt', 'yyyyyyyy', 'uuuuuuuu', '2023-11-19', 'rrhh'),
(2, '20256398742', 'Ricardo', 'correa', 'san juan 230', '3816747474', 'mail@gmail.com', '2023-11-20', 'rrhh'),
(3, '1', '', '', '', '', '', '2023-11-20', ''),
(4, '2', '', '', '', '', '', '2023-11-20', ''),
(5, '3', '', '', '', '', '', '2023-11-20', ''),
(6, '4', '', '', '', '', '', '2023-11-20', ''),
(7, 'dfdff', 'afdddddd', 'ddddddddddd', 'dddddddddddddddddd', 'eeeee', 'dddddddddddddddd', '2023-11-20', 'tecnico'),
(8, '27266384489', 'sss', 'dddddddddd', 'ssssssssssssssss', 'sdsds', 'sddddddd', '2023-11-20', 'tecnico'),
(9, '27266384489', 'nelida', 'hernandez', 'la rioja 100', '3816407565', 'hdhdhhhdahda.gmai.com', '2023-11-21', 'RRHH');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente`
--

DROP TABLE IF EXISTS `incidente`;
CREATE TABLE IF NOT EXISTS `incidente` (
  `idIncidente` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpleado` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idSoporte` int(11) NOT NULL,
  `idTecnico` int(11) NOT NULL,
  `altaIncidente` date NOT NULL,
  `fechaResolucion` varchar(15) NOT NULL,
  `horaColchon` varchar(15) NOT NULL,
  `estadoIncidente` varchar(15) NOT NULL,
  PRIMARY KEY (`idIncidente`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `incidente`
--

INSERT INTO `incidente` (`idIncidente`, `idEmpleado`, `idCliente`, `idSoporte`, `idTecnico`, `altaIncidente`, `fechaResolucion`, `horaColchon`, `estadoIncidente`) VALUES
(1, 1, 1, 1, 1, '2023-11-20', '', 'sddd', 'dd'),
(2, 3, 4, 2, 2, '2023-11-21', '', '10/25/2023', 'activo'),
(3, 1, 2, 3, 1, '2023-11-21', '25/11/23', '2', 'REPORTADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `soporte`
--

DROP TABLE IF EXISTS `soporte`;
CREATE TABLE IF NOT EXISTS `soporte` (
  `idSoporte` int(11) NOT NULL AUTO_INCREMENT,
  `codSoporte` varchar(12) NOT NULL,
  `tipoSoporte` varchar(20) NOT NULL,
  `desSoporte` varchar(50) NOT NULL,
  `altaSoporte` date NOT NULL,
  `tmpRespSoporte` varchar(20) NOT NULL,
  `complejidadSoporte` varchar(10) NOT NULL,
  `estadoSoporte` varchar(10) NOT NULL,
  PRIMARY KEY (`idSoporte`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `soporte`
--

INSERT INTO `soporte` (`idSoporte`, `codSoporte`, `tipoSoporte`, `desSoporte`, `altaSoporte`, `tmpRespSoporte`, `complejidadSoporte`, `estadoSoporte`) VALUES
(1, '', 'soft', 'instala', '2023-11-20', '6', 'alta', 'dispnible'),
(2, '', 'soft', 'formateo de pc instalacion paqueteoffice', '2023-11-20', '6hs', 'media', 'disponible'),
(3, '', 'hard', 'cambio de placa madher', '2023-11-20', '2hs', 'baja', 'disponible'),
(4, 'HPLACASEXT', 'HARDWARE', 'CAMBIO DE PLACA EXTERNA', '2023-11-21', '2HS', 'BAJA', 'DISPONIBLE'),
(5, 'SINSTRESART', 'SOFT', 'INSTALACION COMPLETA DE SOFT', '2023-11-21', '5HS', 'ALTA', 'DISPONIBLE'),
(6, 'HPLACAINT', 'SOFT', 'CAMBIO DE PLACA SONIDO', '2023-11-21', '4', 'BAJA', 'DISPONIBLE'),
(7, '', '', '', '2023-11-21', '', '', ''),
(8, 'SOFWIND', 'SOFT', 'INSTALACION DEL SO', '2023-11-21', '6', 'BAJA', 'DISPONIBLE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
CREATE TABLE IF NOT EXISTS `tecnico` (
  `idTecnico` int(11) NOT NULL AUTO_INCREMENT,
  `cuitEmpleado` varchar(20) NOT NULL,
  `codSoporte` varchar(15) NOT NULL,
  `tituloTecnico` varchar(40) NOT NULL,
  `dispoTecnico` varchar(20) NOT NULL,
  `altaTecnico` date NOT NULL,
  `estadoTecnico` varchar(10) NOT NULL,
  PRIMARY KEY (`idTecnico`),
  UNIQUE KEY `cuitEmpleado` (`cuitEmpleado`),
  UNIQUE KEY `codSoporte` (`codSoporte`),
  UNIQUE KEY `codSoporte_2` (`codSoporte`),
  KEY `idEmpleado` (`cuitEmpleado`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`idTecnico`, `cuitEmpleado`, `codSoporte`, `tituloTecnico`, `dispoTecnico`, `altaTecnico`, `estadoTecnico`) VALUES
(1, '1', '2', 'ingeniero', 'mar y mier 9 a 22', '2023-11-19', 'activo'),
(2, '2', 'dddd', 'dd', 'ddd', '2023-11-21', 'ddd'),
(3, '45', 'HPLACASEXT', 'ING EN SISTEMAS', 'FULL TIME', '2023-11-21', 'ACTIVO'),
(4, '27266384489', '', 'TECNICO ELECTRICISTA', 'PART TIME', '2023-11-21', 'ACTIVO'),
(5, '3', 'HPLACASEOP', 'ELECTRICISTA', 'PART TIME', '2023-11-21', 'INACTIVO');
COMMIT;


SELECT * FROM tecnico;
SELECT * FROM empleados;


