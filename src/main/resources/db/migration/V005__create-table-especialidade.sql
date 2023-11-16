create table vollmed_api.especialidade (
    id bigint not null auto_increment,
    nome varchar(30) not null,
    descricao varchar(100) null,

    primary key(id)
);
update vollmed_api.medicos set status = 1;