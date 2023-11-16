alter table vollmed_api.pacientes add status tinyint not null;
update vollmed_api.pacientes set status = 1;