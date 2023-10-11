

use master if exists(
	select * from SYS.databases where name = 'bd_vitalusus2h')
	drop database bd_vitalusus2h
	go
	create database bd_vitalusus2h
	go
	use bd_vitalusus2h
	
	-- drop table Cliente
	-- drop table Treinador
	-- drop table Evolução
	-- drop table Categoria
	-- drop table Exercicio

	CREATE TABLE Usuario
( 
   id            INT IDENTITY,
   nome          VARCHAR(100)	NOT NULL,
   email         VARCHAR(100)	NOT NULL,
   senha         VARCHAR(100)	NOT NULL,
   nivelAcesso   VARCHAR(10)    NULL, -- ADM, TEC ou USER
   foto		 VARBINARY(MAX) NULL,
   statusUsuario VARCHAR(20)    NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA

   PRIMARY KEY (id)
)

create table Acesso(
id					int				identity,
nivelAcesso			varchar(9)		not null, -- Admin, Cliente e Treinador.

cliente_id			int				null,
treinador_id		int				null,
admin_id			int				null,
foreign key(treinador_id) references Treinador(id),
foreign key(cliente_id) references Cliente(id)
foreign key(admin_id) references Admin(id),
)
	create table Cliente
	(
	id				int				identity,
	senha			varchar(50)	not null,
	email			varchar(100)	not null,
	nome			varchar(100)	not null,
	genero			varchar(10)		not null,
	cpf				char(11)		not null,
	dataNasc			date				not null,
	status		varchar(7)		not null, -- Ativo ou Inativo.
	usuario_id       int				null,
    foreign key(usuario_id) references Usuario(id),
	primary key(id)
	)

	insert Cliente (
	    senha, 
		email,
	    nome,
	    genero,
		cpf,
		nivelAcesso,
		statusCli
		)
	    values (
		12344343,
		'ottafidela@gmail.com',
		'feminnino',
		984398402190-21,
		'Cliente',
		'ativo'
		)
		create table Ficha(
		peso			decimal(4,2)	not null,
		imc				decimal(4,2)	null,
		met_basal		decimal(4,2)	null,
		altura			decimal(4,2)	not null,
		foto			varbinary(max)	null,
		laoudoMedico	varchar(200)	null, 
		)
	create table Treinador(
	 id			int				identity,		
	 cref		char(11)		not null,
	 senha		varchar(100)    not null,
	 idade      int				not null,
	 email		varchar(100)	not null,
	 nome		varchar(100)	not null,
	 genero		varchar(10)		not null,
	 statusTreinador varchar(7)		not null, -- Ativo ou Inativo.
	 
	primary key(id),
	)
	insert Treinador (
	 cref,
	 senha,
	 idade,
	 email,
	 nome, 
	 genero
	) 
	values(
	'Cref123456G',
	'$0uF0rt3',
	37,
	'marombinha1234@hotmail.com',
	'Juliana',
	'masculino'
	)
	create table Admin(
	id		int					identity,
	nome    varchar(50), 
	email	varchar(100)		not null,
	senha	varchar(100)		not null,
	)

	create table Categoria(
	id			int				identity,
	nome		varchar(100)	not null,
	descricao	varchar(100)	not null,		

	primary key(id)
	)

	create table Exercicio(
	id				int				identity,
	urlVideo		varchar(150)	not null,
	nome			varchar(100)	not null,
	descricao		varchar(500)	not null,
	tempo			decimal(4,2)	not null,
	statusExerc		varchar(7)		not null, -- Ativo ou Inativo.
	treinador_id	int				null,
	categoria_id	int				null,

	primary key(id),
	foreign key(treinador_id) references Treinador(id),
	foreign key(categoria_id) references Categoria(id)

	)
	insert Exercicio(
	urlVideo,
	nome,
	descricao,
	tempo,
	statusExerc
	)
	values(
	'https://www.youtube.com/embed/QVAmbJrlyvk?si=3cBiub-NjKpgBDUc',
	'Musculação',
	'10 exercícios essenciais na musculação',
	20.00,
	'Ativo'
	)
	create table Evolução(
	id					int					identity,
	gorduraInicial		decimal(4,2)    	not null,
	gorduraAtual		decimal(4,2)		not null,
	pesoInicial			decimal(4,2)    	not null,
	pesoAtual			decimal(4,2)		not null,
	imc					decimal(5,3)	    not null,
	alturaInicial		decimal(4,2)		not null,
	alturaAtual			decimal(4,2)		not null,
	idCliente			int					not null,

	Primary Key(id),
	Foreign Key (idCliente) references Cliente(id)
	)



	
	select * from Cliente
	select * from Categoria
	select * from Evolução
	select * from Treinador
	select * from Exercicio