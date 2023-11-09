use master if exists(
	select * from SYS.databases where name = 'bd_vitalusus2h')
	drop database bd_vitalusus2h
	go
	create database bd_vitalusus2h
	go
	use bd_vitalusus2h

	--drop table Categoria
	
	--drop table Administrador

	--drop table Treinador

	--drop table Cliente

	--drop table Evolução
	
	--drop table Video

	--drop table Usuario



	create table Cliente
	(
	id			int				identity,
	peso		decimal(5,2)	not null, --peso do cliente
	altura		decimal(3,2)	not null, --altura do cliente
	telefone	varchar(14)     not null,
	statusCli	varchar(7)		not null, -- Ativo ou Inativo.	

	primary key(id)
	)

	INSERT Cliente (peso,altura,telefone,statusCli) VALUES (20.00, 1.70,'119934809', 'ativo')

	create table Treinador(
	 id					int				identity,		
	 statusTrei			varchar(7)		not null, -- Ativo ou Inativo.
	 primary key(id),
	)
	insert Treinador (statusTrei) values('Ativo')


	create table Administrador(
	id				int						identity,
	codigoAcesso	varchar(15)				not null,
	statusAdm		varchar(7)				not null,
	primary key(id)
	)
	insert Administrador (codigoAcesso, statusAdm) 
	values('D5%DW@#!d5JF22M', 'ativo')


	create table Categoria(
	id			int				identity,
	nome		varchar(100)	not null,
	descricao	varchar(100)	not null,	
	primary key(id)
	)
	insert Categoria (nome,descricao) 
	values('Musculação','Exercício que trabalha os músculos.')


	create table Video(
	id				int				identity,
	urlVideo		varchar(150)	not null,
	nome			varchar(100)	not null,
	descricao		varchar(500)	not null,
	tempo			decimal(4,2)	not null,
	statusExerc		varchar(7)		not null, -- Ativo ou Inativo / O TREINADOR PODE DECIDIR EM PUBLICAR OU NÃO OS VÍDEOS DELE /
	treinador_id	int				null,
	categoria_id	int				null,
	primary key(id),
	foreign key(treinador_id) references Treinador(id),
	foreign key(categoria_id) references Categoria(id)
	)
	insert Video(urlVideo,nome,descricao,tempo,statusExerc, treinador_id, categoria_id)
	values('https://www.youtube.com/embed/QVAmbJrlyvk?si=3cBiub-NjKpgBDUc',
		--NOME DO EXERCICIO
			'Musculação',
		--DESCRIÇÃO DO EXERCÍCIO
			'10 exercícios essenciais na musculação',
		--DURAÇÃO DO VÍDEO
			 20.00, 
		--STATUS DO EXERCÍCIO
			'Ativo',
		--ID DO TREINADOR
				1,
		--ID DA CATEGORIA
				1
			)


	create table Evolucao(
	id				int					identity,
	gorduraInicial	decimal(4,2)    	not null,
	gorduraAtual	decimal(4,2)		not null,
	pesoInicial		decimal(4,2)    	not null,
	pesoAtual		decimal(4,2)		not null,
	imc				decimal(5,3)		not null,
	alturaInicial	decimal(4,2)		not null,
	alturaAtual		decimal(4,2)		not null,
	id_Cliente		int					not null,
	
	Primary Key(id),
	Foreign Key (id_Cliente) references Cliente(id)
	)
	insert Evolucao(gorduraInicial, gorduraAtual, pesoInicial, pesoAtual, imc, alturaInicial, alturaAtual, id_Cliente)
	values(15.00, 5.00, 50.00, 65.00, 54.50, 1.70, 1.72, 1)
	
	

	--TABELA USUÁRIO
	create table Usuario
	(
	id					int				identity,
	genero		varchar(9)		not null, -- Masculino ou Feminino
	nome				varchar(100)	not null,
	email				varchar(100)	not null,
	cref				char(11)		null,
	senha				varchar(50)		not null,
	dataNasc			date			not null,
	tipoPessoa			varchar(9)		not null, -- Admin, Treinador e Aluno
	statusUsu			varchar(7)		not null, -- Ativo ou Inativo.		
	id_treinador		int				not null,
	id_administrador	int				not null,
	id_cliente			int				not null, 

	
	primary key(id),
	foreign key(id_treinador) references Treinador(id),
	foreign key(id_administrador) references Administrador(id),
	foreign key(id_cliente) references Cliente(id)
	)

	select * from Administrador
	select * from Cliente
	select * from Categoria
	select * from Evolucao
	select * from Treinador
	select * from Video
	select * from Usuario