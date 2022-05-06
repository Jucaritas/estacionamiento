CREATE DATABASE IF NOT EXISTS `glimon`;
USE `glimon`;


CREATE TABLE IF NOT EXISTS `nva_cve_tipo_persona` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;


DELETE FROM `nva_cve_tipo_persona`;
INSERT INTO `nva_cve_tipo_persona` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(4400, 1, 9999999999, 3400, 1, 1000, 0, 0);


CREATE TABLE IF NOT EXISTS `registro_visitas` (
  `id_visita` int(11) NOT NULL AUTO_INCREMENT,
  `cve_placa` varchar(10) DEFAULT NULL,
  `fecha_ingreso` timestamp NULL DEFAULT NULL,
  `fecha_salida` timestamp NULL DEFAULT NULL,
  `tarifa` int(11) DEFAULT NULL,
  `estatus` int(2) DEFAULT NULL,
  `minutos` int(11) DEFAULT NULL,
  `costo_visita` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_visita`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `registro_visitas`;

INSERT INTO `registro_visitas` (`id_visita`, `cve_placa`, `fecha_ingreso`, `fecha_salida`, `tarifa`, `estatus`, `minutos`, `costo_visita`) VALUES
	(1, 'DFZ123P', '2022-05-06 09:56:04', '2022-05-06 10:09:10', 0, 70, 13, 0),
	(2, 'DFZ123A', '2022-05-06 10:10:38', '2022-05-06 10:12:03', 3, 70, 1, 3);

CREATE TABLE IF NOT EXISTS `tipo_cliente` (
  `id_tipo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `cve_placa` varchar(10) NOT NULL,
  `tipo_vehiculo` int(2) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DELETE FROM `tipo_cliente`;

INSERT INTO `tipo_cliente` (`id_tipo_cliente`, `cve_placa`, `tipo_vehiculo`, `fecha_registro`) VALUES
	(1, 'DFZ123P', 3400, '2022-05-05 22:18:08');

CREATE TABLE IF NOT EXISTS `tipo_vehiculo` (
  `id_tipo_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `cve_tipo_vehiculo` int(11) NOT NULL,
  `desc_tipo_vehiculo` varchar(40) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT NULL,
  `estatus` int(2) NOT NULL,
  `tarifa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DELETE FROM `tipo_vehiculo`;
INSERT INTO `tipo_vehiculo` (`id_tipo_vehiculo`, `cve_tipo_vehiculo`, `desc_tipo_vehiculo`, `fecha_registro`, `estatus`, `tarifa`) VALUES
	(1, 3400, 'Vehiculo Oficial', '2022-05-05 20:38:00', 20, 0),
	(2, 3401, 'Residente', '2022-05-05 20:39:20', 20, 1);

CREATE OR REPLACE SEQUENCE nva_cve_persona
start with 1000
minvalue 1
maxvalue 9999999999 
increment by 1

select nextval(desarrollo.nva_cve_persona)

CREATE OR REPLACE SEQUENCE nva_cve_tipo_persona
start with 3400
minvalue 1
maxvalue 9999999999 
increment by 1

select nextval(desarrollo.nva_cve_persona)