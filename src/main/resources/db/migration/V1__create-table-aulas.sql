create table aulas(

    id bigint not null auto_increment,
    titulo varchar(150) not null unique,
    descricao varchar(1000) not null,
    link varchar(100) not null unique,
    imagem varchar(200) not null unique,
    categoria varchar(50) not null,

    primary key(id)

);