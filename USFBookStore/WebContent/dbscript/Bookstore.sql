CREATE DATABASE 'Bookstore';
USE Bookstore;

/*Você vai utilizar o cliente para o SGBD*/
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `book_id_UNIQUE` (`book_id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1


CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `quantity`int(11) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY  `client_id_UNIQUE` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1


create table `contract` (
     contract_id integer not null AUTO_INCREMENT,
     client_id integer not null,
     book_id integer not null,
     CONSTRAINT FK_ContractBook FOREIGN KEY (`book_id`) REFERENCES book(book_id),
     CONSTRAINT FK_ControctClient FOREIGN KEY (`client_id`) REFERENCES client(client_id),
     primary key (`contract_id`, `client_id`,`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1