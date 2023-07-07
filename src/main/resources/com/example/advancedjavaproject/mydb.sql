-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 07 juil. 2023 à 11:14
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mydb`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `idCustomer` int(11) NOT NULL AUTO_INCREMENT,
  `CuName` varchar(255) DEFAULT NULL,
  `CuSurname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`idCustomer`, `CuName`, `CuSurname`) VALUES
(1, 'Alice', 'Johnson'),
(2, 'Bob', 'Williams');

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `idEmployees` int(11) NOT NULL AUTO_INCREMENT,
  `EmName` varchar(255) DEFAULT NULL,
  `EmSurname` varchar(255) DEFAULT NULL,
  `Password_email` varchar(255) NOT NULL,
  PRIMARY KEY (`idEmployees`,`Password_email`),
  KEY `fk_Employees_Password1_idx` (`Password_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employees`
--

INSERT INTO `employees` (`idEmployees`, `EmName`, `EmSurname`, `Password_email`) VALUES
(1, 'John', 'Doe', 'email1@example.com'),
(2, 'Jane', 'Smith', 'email2@example.com');

-- --------------------------------------------------------

--
-- Structure de la table `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `Customer_idCustomer` int(11) NOT NULL,
  KEY `fk_Guest_Customer1_idx` (`Customer_idCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `guest`
--

INSERT INTO `guest` (`Customer_idCustomer`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Structure de la table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `PaPassword_email` varchar(255) NOT NULL,
  `Customer_idCustomer` int(11) NOT NULL,
  PRIMARY KEY (`PaPassword_email`),
  KEY `fk_Member_PaPassword1_idx` (`PaPassword_email`),
  KEY `fk_Member_Customer1_idx` (`Customer_idCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `member`
--

INSERT INTO `member` (`PaPassword_email`, `Customer_idCustomer`) VALUES
('email1@example.com', 1),
('email2@example.com', 2);

-- --------------------------------------------------------

--
-- Structure de la table `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `idMovie` int(11) NOT NULL AUTO_INCREMENT,
  `MoName` varchar(45) DEFAULT NULL,
  `MoTime` int(11) DEFAULT NULL,
  `MoBio` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idMovie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `movie`
--

INSERT INTO `movie` (`idMovie`, `MoName`, `MoTime`, `MoBio`) VALUES
(1, 'Movie 1', 120, 'Description du film 1'),
(2, 'Movie 2', 90, 'Description du film 2');

-- --------------------------------------------------------

--
-- Structure de la table `movieshow`
--

DROP TABLE IF EXISTS `movieshow`;
CREATE TABLE IF NOT EXISTS `movieshow` (
  `idMovieShow` int(11) NOT NULL AUTO_INCREMENT,
  `MSDate` datetime NOT NULL,
  `MSPrice` int(11) NOT NULL,
  `MSReservationNumber` int(11) DEFAULT NULL,
  `Movie_idMovie` int(11) NOT NULL,
  `Room_idRoom` int(11) NOT NULL,
  PRIMARY KEY (`idMovieShow`,`Movie_idMovie`,`Room_idRoom`),
  KEY `fk_MovieShow_Movie1_idx` (`Movie_idMovie`),
  KEY `fk_MovieShow_Room1_idx` (`Room_idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `movieshow`
--

INSERT INTO `movieshow` (`idMovieShow`, `MSDate`, `MSPrice`, `MSReservationNumber`, `Movie_idMovie`, `Room_idRoom`) VALUES
(1, '2023-07-06 15:00:00', 10, NULL, 1, 1),
(2, '2023-07-07 18:30:00', 12, NULL, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `movieshow_managment`
--

DROP TABLE IF EXISTS `movieshow_managment`;
CREATE TABLE IF NOT EXISTS `movieshow_managment` (
  `MovieShow_idMovieShow` int(11) NOT NULL,
  `MovieShow_Movie_idMovie` int(11) NOT NULL,
  `Employees_idEmployees` int(11) NOT NULL,
  PRIMARY KEY (`MovieShow_idMovieShow`,`MovieShow_Movie_idMovie`,`Employees_idEmployees`),
  KEY `fk_MovieShow_has_Employees_Employees1_idx` (`Employees_idEmployees`),
  KEY `fk_MovieShow_has_Employees_MovieShow1_idx` (`MovieShow_idMovieShow`,`MovieShow_Movie_idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `movieshow_managment`
--

INSERT INTO `movieshow_managment` (`MovieShow_idMovieShow`, `MovieShow_Movie_idMovie`, `Employees_idEmployees`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `movieshow_reservation`
--

DROP TABLE IF EXISTS `movieshow_reservation`;
CREATE TABLE IF NOT EXISTS `movieshow_reservation` (
  `MovieShow_idMovieShow` int(11) NOT NULL,
  `MovieShow_Movie_idMovie` int(11) NOT NULL,
  `Customer_idCustomer` int(11) NOT NULL,
  PRIMARY KEY (`MovieShow_idMovieShow`,`MovieShow_Movie_idMovie`,`Customer_idCustomer`),
  KEY `fk_MovieShow_has_Customer_Customer1_idx` (`Customer_idCustomer`),
  KEY `fk_MovieShow_has_Customer_MovieShow1_idx` (`MovieShow_idMovieShow`,`MovieShow_Movie_idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `movieshow_reservation`
--

INSERT INTO `movieshow_reservation` (`MovieShow_idMovieShow`, `MovieShow_Movie_idMovie`, `Customer_idCustomer`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `movie_managment`
--

DROP TABLE IF EXISTS `movie_managment`;
CREATE TABLE IF NOT EXISTS `movie_managment` (
  `Movie_idMovie` int(11) NOT NULL,
  `Employees_idEmployees` int(11) NOT NULL,
  PRIMARY KEY (`Movie_idMovie`,`Employees_idEmployees`),
  KEY `fk_Movie_has_Employees_Employees1_idx` (`Employees_idEmployees`),
  KEY `fk_Movie_has_Employees_Movie1_idx` (`Movie_idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `movie_managment`
--

INSERT INTO `movie_managment` (`Movie_idMovie`, `Employees_idEmployees`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `password`
--

DROP TABLE IF EXISTS `password`;
CREATE TABLE IF NOT EXISTS `password` (
  `email` varchar(255) NOT NULL,
  `PaSecretCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `password`
--

INSERT INTO `password` (`email`, `PaSecretCode`) VALUES
('email1@example.com', 'secret1'),
('email2@example.com', 'secret2');

-- --------------------------------------------------------

--
-- Structure de la table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `idRoom` int(11) NOT NULL,
  `seatsNumber` int(11) NOT NULL,
  `schedule` datetime DEFAULT NULL,
  PRIMARY KEY (`idRoom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `room`
--

INSERT INTO `room` (`idRoom`, `seatsNumber`, `schedule`) VALUES
(1, 100, NULL),
(2, 80, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `fk_Employees_Password1` FOREIGN KEY (`Password_email`) REFERENCES `password` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `guest`
--
ALTER TABLE `guest`
  ADD CONSTRAINT `fk_Guest_Customer1` FOREIGN KEY (`Customer_idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `fk_Member_Customer1` FOREIGN KEY (`Customer_idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Member_PaPassword1` FOREIGN KEY (`PaPassword_email`) REFERENCES `password` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `movieshow`
--
ALTER TABLE `movieshow`
  ADD CONSTRAINT `fk_MovieShow_Movie1` FOREIGN KEY (`Movie_idMovie`) REFERENCES `movie` (`idMovie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_MovieShow_Room1` FOREIGN KEY (`Room_idRoom`) REFERENCES `room` (`idRoom`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `movieshow_managment`
--
ALTER TABLE `movieshow_managment`
  ADD CONSTRAINT `fk_MovieShow_has_Employees_Employees1` FOREIGN KEY (`Employees_idEmployees`) REFERENCES `employees` (`idEmployees`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_MovieShow_has_Employees_MovieShow1` FOREIGN KEY (`MovieShow_idMovieShow`,`MovieShow_Movie_idMovie`) REFERENCES `movieshow` (`idMovieShow`, `Movie_idMovie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `movieshow_reservation`
--
ALTER TABLE `movieshow_reservation`
  ADD CONSTRAINT `fk_MovieShow_has_Customer_Customer1` FOREIGN KEY (`Customer_idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_MovieShow_has_Customer_MovieShow1` FOREIGN KEY (`MovieShow_idMovieShow`,`MovieShow_Movie_idMovie`) REFERENCES `movieshow` (`idMovieShow`, `Movie_idMovie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `movie_managment`
--
ALTER TABLE `movie_managment`
  ADD CONSTRAINT `fk_Movie_has_Employees_Employees1` FOREIGN KEY (`Employees_idEmployees`) REFERENCES `employees` (`idEmployees`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Movie_has_Employees_Movie1` FOREIGN KEY (`Movie_idMovie`) REFERENCES `movie` (`idMovie`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
