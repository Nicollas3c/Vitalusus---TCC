

use master if exists(
	select * from SYS.databases where name = 'bd_vitalusus2h')
	drop database bd_vitalusus2h
	go
	create database bd_vitalusus2h
	go
	use bd_vitalusus2h

	-- drop table Admin
	-- drop table Cliente
	-- drop table Treinador
	-- drop table Evolução
	-- drop table Categoria
	-- drop table Video

	create table Cliente
	(
	id			int				identity,
	nome		varchar(100)	not null,
	email		varchar(100)	not null,
	senha		varchar(50)		not null,
	genero		varchar(9)		not null, -- Masculino ou Feminino
	dataNasc	date			not null,
	tipoPessoa	varchar(9)		not null, -- Admin, Treinador e Aluno
	statusCli	varchar(7)		not null, -- Ativo ou Inativo.		

	primary key(id)
	)

	insert Cliente (
	    senha, 
		email,
	    nome,
	    genero,
		tipoPessoa,
		statusCli,
		dataNasc
		)
	    values (
		'12344343',
		'ottafidela@gmail.com',
		'Otta',
		'feminnino',
		'Cliente',
		'Ativo',
		'12-01-2006'
	)

	create table Treinador(
	 id					int				identity,		
	 cref				char(11)		not null,
	 nome				varchar(100)	not null,
	 genero				varchar(9)		not null, -- Masculino ou Feminino
	 email				varchar(100)	not null,
	 senha				varchar(50)		not null,
	 statusTrei			varchar(7)		not null, -- Ativo ou Inativo.	

	 primary key(id),
	)

	insert Treinador (
	 cref,
	 senha,
	 email,
	 nome, 
	 genero,
	 statusTrei
	) 

	values(
	'Cref123456G',
	'$0uF0rt3',
	'marombinha1234@hotmail.com',
	'João',
	'masculino',
	'Ativo'
	)

	create table Admin(
	id				int						identity,
	nome			varchar(50)			    not null, 
	email			varchar(100)	        not null,
	senha			varchar(100)	        not null,
	codigoAcesso	varchar(15)				not null,
	)

	insert Admin (
	 nome,
	 email,
	 senha,
	 codigoAcesso
	) 
	 
	values(
	'Mônica',
	'monique@gmail.com',
	'd12e2121',
	'D5%DW@#!d5JF22M'
	)

	create table Categoria(
	id			int				identity,
	nome		varchar(100)	not null,
	descricao	varchar(100)	not null,		

	primary key(id)
	)

	insert Categoria (
	 nome,
	 descricao
	) 

	values(
	'Musculação',
	'Exercício que trabalha os músculos.'
	)

	create table Video(
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
	insert Video(
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
	id				int					identity,
	gorduraInicial	decimal(4,2)    	not null,
	gorduraAtual	decimal(4,2)		not null,
	pesoInicial		decimal(4,2)    	not null,
	pesoAtual		decimal(4,2)		not null,
	imc				decimal(5,3)		not null,
	alturaInicial	decimal(4,2)		not null,
	alturaAtual		decimal(4,2)		not null,
	idCliente		int					not null,

	Primary Key(id),
	Foreign Key (idCliente) references Cliente(id)
	)

	select * from Admin
	select * from Cliente
	select * from Categoria
	select * from Evolução
	select * from Treinador
	select * from Video

--	SELECT	ITEM_PEDIDO.ID, 
--		PRODUTO.ID, PRODUTO.NOME, PRODUTO.PRECO,
--		ITEM_PEDIDO.QTD_PROD, ITEM_PEDIDO.SUBTOTAL 
--	FROM 
--	PRODUTO INNER JOIN ITEM_PEDIDO
--	ON PRODUTO.ID = ITEM_PEDIDO.PRODUTO_ID
