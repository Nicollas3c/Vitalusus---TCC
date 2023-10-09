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

	create table Usuario
	( 
		id				int				identity,
		nome			varchar(100)	not null,
		senha			varchar(30)		not null,
		email			varchar(100)	not null,
		dataNasc		date			not null,
		genero			varchar(10)		not null,   -- Masculino, Feminino e Outro
		nivelAcesso		varchar(1)		not null,	-- CLI = 1 TRE = 2 ADM = 3
		foto			varbinary(max)	null,
		statusUsuario	varchar(7)		not null,	-- Ativo ou Inativo

		primary key (id)
	)
	create table Cliente
	(
		id				int				identity,
		peso			decimal(5,2)	not null,
		imc				decimal(4,2)	null,
		met_basal		decimal(4,2)	null,		-- Ánalisando the choice
		altura			decimal(3,2)	not null,		  
	    statusCli		varchar(7)		not null,	-- Ativo ou Inativo.
		usuario_id      int				null,

		foreign key(usuario_id) references Usuario(id),
		primary key(id)
	)

	insert Cliente 
	(
		peso,
		altura,
		statusCli
		)
	    values (
		999.99,
		9.99,
		'ativo'
	)

	create table Treinador
	(
		id				int				identity,		
		cref			char(11)		not null,
		categoria_id	int				not null,

		primary key(id),

	)
	insert Treinador (
		 cref,
		 categoria_id
	) 
		values(
		'Cref123456G',
		69

	)

	create table Categoria(
		id			int				identity,
		nome		varchar(100)	not null,
		descricao	varchar(100)	not null,		
	
		primary key(id),

	)

	create table Exercicio(
		id				int				identity,
		urlVideo		varchar(150)	not null,
		nome			varchar(100)	not null,
		descricao		varchar(500)	not null,
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
		statusExerc
	)
	values
	(
		'https://www.youtube.com/embed/QVAmbJrlyvk?si=3cBiub-NjKpgBDUc',
		'Musculação',
		'10 exercícios essenciais na musculação',
		'Ativo'
	)
	create table Evolução(
		id					int					identity,
		gorduraAtual		decimal(4,2)		not null,
		pesoAtual			decimal(4,2)		not null,
		imc					decimal(5,3)	    not null,
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