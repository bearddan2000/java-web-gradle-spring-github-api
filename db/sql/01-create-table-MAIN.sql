CREATE TABLE `portal`.main (
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	additionId  INT DEFAULT 0,
	keywords VARCHAR(255)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
