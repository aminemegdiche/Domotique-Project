-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 23 Mars 2014 à 14:38
-- Version du serveur: 5.5.20-log
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `domotique`
--

-- --------------------------------------------------------

--
-- Structure de la table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `id_rm` int(11) NOT NULL AUTO_INCREMENT,
  `id_usr` int(11) NOT NULL,
  `des_rm` varchar(50) NOT NULL,
  `sh_s` int(11) NOT NULL,
  `th_s` int(11) NOT NULL,
  `li_s` int(11) NOT NULL,
  `sh_v` int(11) NOT NULL,
  `th_v` int(11) NOT NULL,
  `th_m` int(11) NOT NULL,
  `th` int(11) NOT NULL,
  `li_v` int(11) NOT NULL,
  `li_m` int(11) NOT NULL,
  PRIMARY KEY (`id_rm`),
  KEY `id_usr` (`id_usr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `rooms`
--

INSERT INTO `rooms` (`id_rm`, `id_usr`, `des_rm`, `sh_s`, `th_s`, `li_s`, `sh_v`, `th_v`, `th_m`, `th`, `li_v`, `li_m`) VALUES
(1, 1, 'cuisine', 0, 1, 0, 1, 37, 0, 1, 1, 0),
(2, 1, 'p1', 1, 0, 1, 0, 0, 0, 0, 0, 0),
(3, 1, 'Salon', 1, 1, 1, 0, 56, 0, 1, 0, 1),
(8, 1, 'p3', 1, 0, 1, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_usr` int(11) NOT NULL AUTO_INCREMENT,
  `name_lastname` varchar(50) NOT NULL,
  `pin` int(11) NOT NULL,
  PRIMARY KEY (`id_usr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id_usr`, `name_lastname`, `pin`) VALUES
(1, 'abaab', 1111);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
