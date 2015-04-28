CREATE TABLE ct_tipos_diagnosticos
(
	id_tipo_diagnostico INTEGER NOT NULL AUTO_INCREMENT,
	tipo_diagnostico VARCHAR(70) NOT NULL,
	PRIMARY KEY (id_tipo_diagnostico)
) 
;


CREATE TABLE ct_tipos_imagenes
(
	id_tipo_imagen INTEGER NOT NULL AUTO_INCREMENT,
	tipo_imagen VARCHAR(30) NOT NULL,
	PRIMARY KEY (id_tipo_imagen)
) 
;


CREATE TABLE tb_datos_contacto
(
	id_dato_contacto INTEGER NOT NULL AUTO_INCREMENT,
	persona_dato_contacto INTEGER NOT NULL,
	eps_dato_contacto INTEGER NOT NULL,
	dato_contacto VARCHAR(50),
	tipo_dato_contacto INTEGER NOT NULL,
	prioridad_dato_contacto SMALLINT DEFAULT 1,
	vigencia_dato_contacto BOOL DEFAULT true,
	PRIMARY KEY (id_dato_contacto),
	KEY (tipo_dato_contacto),
	KEY (persona_dato_contacto)
) 
;


CREATE TABLE ct_tiposdocumentos
(
	id_tipodocumento INTEGER NOT NULL AUTO_INCREMENT,
	iniciales_tipodocumento VARCHAR(2) NOT NULL,
	tipo_documento VARCHAR(15) NOT NULL,
	PRIMARY KEY (id_tipodocumento)
) 
;


CREATE TABLE ct_tipos_datos_contactos
(
	id_tipo_dato_contacto INTEGER NOT NULL AUTO_INCREMENT,
	tipo_dato_contacto VARCHAR(10) NOT NULL,
	PRIMARY KEY (id_tipo_dato_contacto)
) 
;


CREATE TABLE ct_rhs
(
	id_rh INTEGER NOT NULL AUTO_INCREMENT,
	nombre_rh VARCHAR(30) NOT NULL,
	PRIMARY KEY (id_rh)
) 
;


CREATE TABLE tb_imagenes
(
	id_imagen INTEGER NOT NULL AUTO_INCREMENT,
	imagen BLOB,
	fecha_imagen DATETIME NOT NULL,
	orden_medica_imagen INTEGER NOT NULL,
	diagnostico_imagen VARCHAR(255),
	tipo_diagnostico_imagen INTEGER NOT NULL,
	tipo_imagen INTEGER NOT NULL,
	PRIMARY KEY (id_imagen),
	KEY (tipo_diagnostico_imagen),
	KEY (tipo_imagen),
	KEY (orden_medica_imagen)
) 
;


CREATE TABLE tb_ordenes_medicas
(
	id_orden_medica INTEGER NOT NULL AUTO_INCREMENT,
	medico_orden_medica INTEGER NOT NULL,
	paciente_orden_medica INTEGER NOT NULL,
	fecha_orden_medica DATETIME NOT NULL,
	observaciones_orden_medica VARCHAR(255),
	PRIMARY KEY (id_orden_medica),
	KEY (paciente_orden_medica),
	KEY (medico_orden_medica)
) 
;


CREATE TABLE tb_personas
(
	cod_persona INTEGER NOT NULL AUTO_INCREMENT,
	tip_doc_persona INTEGER NOT NULL,
	num_doc_persona VARCHAR(12) NOT NULL,
	prim_nombre_persona VARCHAR(25) NOT NULL,
	seg_nombre_persona VARCHAR(25),
	prim_apellido_persona VARCHAR(25) NOT NULL,
	seg_apellido_persona VARCHAR(25),
	femenino_persona BOOL NOT NULL,
	medico_persona BOOL,
	especialidad_medica_persona VARCHAR(50),
	fech_nacimiento_persona DATETIME NOT NULL,
	rh_persona INTEGER NOT NULL,
	eps_persona INTEGER NOT NULL,
	observaciones_persona VARCHAR(255),
	PRIMARY KEY (cod_persona),
	KEY (rh_persona),
	KEY (tip_doc_persona)
) 
;


CREATE TABLE ct_epss
(
	cod_eps INTEGER NOT NULL AUTO_INCREMENT,
	nombre_eps VARCHAR(30) NOT NULL,
	PRIMARY KEY (cod_eps)
) 
;





ALTER TABLE tb_datos_contacto ADD CONSTRAINT FK_tb_datos_contacto_ct_tipo_dato_contacto 
	FOREIGN KEY (tipo_dato_contacto) REFERENCES ct_tipos_datos_contactos (id_tipo_dato_contacto)
	ON UPDATE CASCADE
;

ALTER TABLE tb_datos_contacto ADD CONSTRAINT FK_tb_datos_contacto_tb_personas 
	FOREIGN KEY (persona_dato_contacto) REFERENCES tb_personas (cod_persona)
	ON UPDATE CASCADE
;

ALTER TABLE tb_imagenes ADD CONSTRAINT FK_tb_imagenes_ct_tipos_diagnosticos 
	FOREIGN KEY (tipo_diagnostico_imagen) REFERENCES ct_tipos_diagnosticos (id_tipo_diagnostico)
	ON UPDATE CASCADE
;

ALTER TABLE tb_imagenes ADD CONSTRAINT FK_tb_imagenes_ct_tipos_imagenes 
	FOREIGN KEY (tipo_imagen) REFERENCES ct_tipos_imagenes (id_tipo_imagen)
	ON UPDATE CASCADE
;

ALTER TABLE tb_imagenes ADD CONSTRAINT FK_tb_imagenes_tb_ordenes_medicas 
	FOREIGN KEY (orden_medica_imagen) REFERENCES tb_ordenes_medicas (id_orden_medica)
	ON UPDATE CASCADE
;

ALTER TABLE tb_ordenes_medicas ADD CONSTRAINT FK_tb_ordenes_medicas_tb_personas_paciente 
	FOREIGN KEY (paciente_orden_medica) REFERENCES tb_personas (cod_persona)
	ON UPDATE CASCADE
;

ALTER TABLE tb_ordenes_medicas ADD CONSTRAINT FK_tb_ordenes_medicas_tb_personas_medico 
	FOREIGN KEY (medico_orden_medica) REFERENCES tb_personas (cod_persona)
	ON UPDATE CASCADE
;

ALTER TABLE tb_personas ADD CONSTRAINT FK_tb_personas_ct_rhs 
	FOREIGN KEY (rh_persona) REFERENCES ct_rhs (id_rh)
	ON UPDATE CASCADE
;

ALTER TABLE tb_personas ADD CONSTRAINT FK_tb_personas_ct_tiposdocumentos 
	FOREIGN KEY (tip_doc_persona) REFERENCES ct_tiposdocumentos (id_tipodocumento)
	ON UPDATE CASCADE
;
