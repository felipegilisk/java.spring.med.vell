alter table vollmed_api.medicos
add column id_especialidade int after especialidade;

update vollmed_api.medicos
SET id_especialidade = CAST(especialidade as UNSIGNED);

alter table vollmed_api.especialidade
rename vollmed_api.especialidades;

alter table vollmed_api.especialidades
add status tinyint not null;

update vollmed_api.especialidades set status = 1;