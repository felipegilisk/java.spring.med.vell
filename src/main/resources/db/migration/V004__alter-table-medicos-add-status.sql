alter table vollmed_api.medicos add status tinyint not null;
update vollmed_api.medicos set status = 1;