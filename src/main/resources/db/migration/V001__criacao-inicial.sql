CREATE table tbl_neighborhoods (
	id bigint not null auto_increment,
    name varchar(60) not null,
    
primary key (id)
) engine=InnoDB default charset=utf8;


CREATE table tbl_drugstores (
		id bigint not null auto_increment,
        foundation_date datetime(6) not null, 
        flg_round_the_clock bit not null, 
        name varchar(255),
        id_neighborhood bigint not null,
        primary key (id)
) engine=InnoDB default charset=utf8;