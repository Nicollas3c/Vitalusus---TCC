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
-- Tabela Canal
CREATE TABLE Canal(
	id				INT				IDENTITY,
	visualizacoes	INT				NOT NULL,
	nome			VARCHAR(100)	NOT NULL,

	PRIMARY KEY (id)
)
GO
-- Tabela Videoaula
CREATE TABLE Videoaula(
	id				INT				IDENTITY,
	link			VARCHAR(2048)	NOT NULL,
	descricao		VARCHAR(255)	NOT NULL,
	titulo			VARCHAR(100)	NOT NULL,
	likes			INT				NOT NULL,
	deslikes		INT				NOT NULL,
	
	PRIMARY KEY(id)
)
GO
-- Tabela Banco 
CREATE TABLE Banco(
	id				INT				IDENTITY,

	PRIMARY KEY(id)
)
GO
-- Tabela Aluno
CREATE TABLE Aluno
(
	id			INT					IDENTITY,
	dataNasc	SMALLDATETIME		NOT NULL,
	altura		DECIMAL				NOT NULL,
	peso		DECIMAL				NOT NULL,
	usuario_id	INT					NOT NULL,

	FOREIGN KEY(usuario_id) REFERENCES Usuario (id),
	PRIMARY KEY(id)
)
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

-- Tabela Treinador
CREATE TABLE Treinador
(
	id	            INT			  IDENTITY,
	cref			INT			  NOT NULL,
	dataNasc		SMALLDATETIME NOT NULL,
	usuario_id		INT			  NOT NULL,
	videoaula_id	INT			  NOT NULL,
	canal_id		INT			  NOT NULL,
	banco_id		INT           NOT NULL,

	FOREIGN KEY (canal_id) REFERENCES Canal(id),
	PRIMARY KEY (id)
)
GO

-- Tabela Evolucao
CREATE TABLE Evolucao(
	id				INT				IDENTITY,
	imc				DECIMAL			NOT NULL,
	met_basal		DECIMAL			NOT NULL,
	peso_atual		DECIMAL			NOT NULL,
	altura_atual	DECIMAL			NOT NULL,
	aluno_id		INT				NOT NULL,

	PRIMARY KEY(id),
	FOREIGN KEY(aluno_id) REFERENCES Aluno(id)
)
GO
-- Tabela Aluno_segue_canal
CREATE TABLE Aluno_segue_canal(
	seguidor_id		INT				NOT NULL,
	canal_id		INT				NOT NULL,

	FOREIGN KEY(seguidor_id) REFERENCES Aluno(id),
	FOREIGN KEY(canal_id) REFERENCES Canal(id)
)

SELECT * FROM Usuario
SELECT * FROM Canal
SELECT * FROM Videoaula
SELECT * FROM Aluno
SELECT * FROM Administrador
SELECT * FROM Treinador
SELECT * FROM Evolucao
SELECT * FROM Aluno_segue_canal
 



