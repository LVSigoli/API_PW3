create table consertos (
                           id bigint not null auto_increment,
                           data_entrada varchar(50) not null,
                           data_saida varchar(50) not null,
                           nome varchar(100) not null,
                           anos_de_experiencia int not null,
                           marca varchar(50) not null,
                           modelo varchar(50) not null,
                           ano varchar(10) not null,
                           primary key(id)
);