USE master IF EXISTS(select * from sys.databases where name='bd_vitalusus') 
DROP DATABASE bd_vitalusus2h
GO 
-- CRIAR UM BANCO DE DADOS
CREATE DATABASE bd_vitalusus2h
GO
-- ACESSAR O BANCO DE DADOS
USE bd_vitalusus2h
GO

-- Tabela Usuario
CREATE TABLE Usuario
( 
   id            INT			IDENTITY,
   nome          VARCHAR(100)	NOT NULL,
   email         VARCHAR(100)	UNIQUE NOT NULL,
   senha         VARCHAR(100)	NOT NULL,
   nivelAcesso   VARCHAR(10)    NULL, -- ADMIN ou USER
   foto			 VARBINARY(MAX) NULL,
   dataCadastro	 SMALLDATETIME	NOT NULL,
   statusUsuario VARCHAR(20)    NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA
   PRIMARY KEY (id)
)
GO
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Fulano da Silva', 'fulano@email.com.br', 'MTIzNDU2Nzg=', 'ADMIN', NULL, GETDATE(), 'ATIVO')
GO

-- Tabela Aluno
CREATE TABLE Aluno
(
	id			INT				IDENTITY,
	dataNasc	SMALLDATETIME	NOT NULL,
	altura		DECIMAL			NOT NULL,
	peso		DECIMAL			NOT NULL,
	usuario_id	INT				NOT NULL,

	FOREIGN KEY(usuario_id) REFERENCES Usuario (id),
	PRIMARY KEY(id)
)
GO
INSERT Aluno (altura) VALUES (1.32)
GO

-- Tabela administrador
CREATE TABLE Administrador
(
	id			 INT		    IDENTITY,
	usuario_id	 INT			NOT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario (id)
)
GO
INSERT Administrador (usuario_id) VALUES(1)

CREATE TABLE Treinador
(
	id	            INT			  IDENTITY,
	cref			INT			  NOT NULL,
	dataNasc		SMALLDATETIME NOT NULL,
	usuario_id		INT			  NOT NULL,
	videoaula_id	INT			  NOT NULL,
	canal_id		INT			  NOT NULL,
	banco_id		INT           NOT NULL,

	PRIMARY KEY (id)
)
GO
INSERT Treinador(cref, dataNasc, usuario_id, videoaula_id, canal_id, banco_id) 
VALUES (132432, GETDATE(), 2, 2, 2, 2)
GO

SELECT * FROM Usuario
SELECT * FROM Aluno
SELECT * FROM Administrador
SELECT * FROM Treinador




