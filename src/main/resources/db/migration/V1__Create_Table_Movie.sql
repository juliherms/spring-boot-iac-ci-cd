CREATE TABLE `movie` (
    id BIGINT NOT NULL auto_increment,
    description VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO `movie` (`description`) VALUES ('Batman Begins');
INSERT INTO `movie` (`description`) VALUES ('Avengers: Infinity War');