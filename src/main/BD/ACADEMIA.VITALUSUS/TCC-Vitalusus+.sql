

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
	create table Cliente
	(
	id				int				identity,
	senha			varchar(110)	not null,
	email			varchar(200)	not null,
	nome			varchar(100)	not null,
	imc				decimal(4,2)	null,
	genero			varchar(10)		not null,
	met_basal		decimal(4,2)	null,
	altura			decimal(4,2)	not null,
	cpf				char(11)		not null,
	peso			decimal(4,2)	not null,
	idade			int				not null,
	foto			varbinary(max)	null,
	nivelAcesso		varchar(9)		not null, -- Admin, Cliente e Treinador.
	nivelSeden		int				not null,
    statusCli		varchar(7)		not null, -- Ativo ou Inativo.
	
	tempSent		varchar(100)        null,
	antCirurgicos	varchar(100)		null,
	tratEstetico	varchar(100)		null,
	antAlergicos	varchar(100)		null,
	funcIntestinal	varchar(100)		null,
	praticFisica	varchar(100)		null,
	fumante			varchar(100)		null,
	alimentBalanc	varchar(100)		null,
	liquidosFreq    varchar(100)		null,
	gestante		varchar(100)		null,
	problemOrtop	varchar(100)		null,
	tratMedico		varchar(100)		null,
	ácidoNaPl		varchar(100)		null,
	tratOrtomel		varchar(100)		null,
	cuidDiario		varchar(100)		null,
	portMarcap		varchar(100)		null,
	presenMetais	varchar(100)		null,
	AntOncolo		varchar(100)		null,
	cicloM			varchar(100)		null,
	metodAnticonc   varchar(100)        null,
	varizes			varchar(100)		null,
	lesoes			varchar(100)		null,
	hipertencao		varchar(100)		null,
	epilepsia		varchar(100)		null,

	primary key(id)
	)
	insert Cliente (
	    senha, 
		email,
	    nome,
	    genero,
		altura,
		cpf,
	    peso,
		idade,
		nivelSeden,
		nivelAcesso,
		statusCli
		)
	    values (
		'3U$0u$@F@d@',
		'ottihnha123@yahoo.com.br',
	    'Otta',
	    'feminino',
	    1.78,
		'8874865958',
	    65.50,
		14,
		1,
		'Cliente',
		'Ativo'
		)

	create table Treinador(
	 id			int				identity,		
	 cref		char(11)		not null,
	 senha		varchar(100)    not null,
	 idade      int				not null,
	 email		varchar(100)	not null,
	 nome		varchar(100)	not null,
	 genero		varchar(10)		not null,

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