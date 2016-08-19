CREATE TABLE `City` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `state` varchar(128) DEFAULT NULL,
  `country` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;

CREATE TABLE `Hotel` (
  `city` int(11) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `zip` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into City (name,state,country) values("San Francisco","CA","US");