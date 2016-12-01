-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 01 Août 2015 à 17:51
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `domotique`
--
CREATE DATABASE IF NOT EXISTS `domotique` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `domotique`;

-- --------------------------------------------------------

--
-- Structure de la table `climatiseur`
--

CREATE TABLE IF NOT EXISTS `climatiseur` (
  `id_climatiseur` int(11) NOT NULL AUTO_INCREMENT,
  `id_rm` int(11) NOT NULL,
  `etat_clima` int(1) NOT NULL,
  `niveau_clima` int(11) NOT NULL,
  `mode_clima` int(11) NOT NULL,
  `type_clima` varchar(255) NOT NULL,
  `id_model` int(11) NOT NULL COMMENT 'le model de l''équipement',
  `pin_clima` int(2) NOT NULL,
  PRIMARY KEY (`id_climatiseur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `climatiseur`
--

INSERT INTO `climatiseur` (`id_climatiseur`, `id_rm`, `etat_clima`, `niveau_clima`, `mode_clima`, `type_clima`, `id_model`, `pin_clima`) VALUES
(1, 1, 1, 30, 0, 'GALANZ', 1, 5),
(2, 2, 0, 16, 0, 'SAMSUNG', 2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `droits_utu`
--

CREATE TABLE IF NOT EXISTS `droits_utu` (
  `id_droit` int(11) NOT NULL AUTO_INCREMENT,
  `id_maison` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_rm` int(11) NOT NULL,
  `id_rfid` varchar(255) NOT NULL,
  PRIMARY KEY (`id_droit`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `droits_utu`
--

INSERT INTO `droits_utu` (`id_droit`, `id_maison`, `id_user`, `id_rm`, `id_rfid`) VALUES
(1, 1, 1, 1, 'R12H28hhhhhh'),
(2, 1, 1, 2, 'R12H28hhhhhh');

-- --------------------------------------------------------

--
-- Structure de la table `lampe`
--

CREATE TABLE IF NOT EXISTS `lampe` (
  `id_lampe` int(11) NOT NULL AUTO_INCREMENT,
  `id_rm` int(11) NOT NULL,
  `etat_lampe` int(11) NOT NULL COMMENT 'il peut apartient 3 niveau soit 0 soit1 soit 2 soit 3 ',
  `auto_lampe` int(11) NOT NULL,
  `pin_lampe` int(10) NOT NULL,
  PRIMARY KEY (`id_lampe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `lampe`
--

INSERT INTO `lampe` (`id_lampe`, `id_rm`, `etat_lampe`, `auto_lampe`, `pin_lampe`) VALUES
(1, 1, 1, 1, 4),
(2, 2, 1, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `letter`
--

CREATE TABLE IF NOT EXISTS `letter` (
  `id_letter` int(11) NOT NULL AUTO_INCREMENT,
  `date_letter` varchar(255) NOT NULL,
  `heure_letter` varchar(255) NOT NULL,
  `status_letter` int(1) NOT NULL COMMENT 'soit 1 ou 0 visible/non',
  `id_maison` int(11) NOT NULL,
  PRIMARY KEY (`id_letter`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `letter`
--

INSERT INTO `letter` (`id_letter`, `date_letter`, `heure_letter`, `status_letter`, `id_maison`) VALUES
(1, '12/12/2014', '08:22', 1, 1),
(2, '17-12-2014', '21:43', 1, 0),
(3, '17-12-2014', '21:43', 1, 1),
(4, '17-12-2014', '21:43', 1, 1),
(5, '17-12-2014', '21:44', 1, 1),
(6, '17-12-2014', '21:45', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `maison`
--

CREATE TABLE IF NOT EXISTS `maison` (
  `id_maison` int(11) NOT NULL AUTO_INCREMENT,
  `adr_maison` varchar(255) NOT NULL,
  `latitude_maison` varchar(255) NOT NULL,
  `longitude_maison` varchar(255) NOT NULL,
  `tel_maison` varchar(255) NOT NULL,
  `ip_maison` varchar(255) NOT NULL,
  PRIMARY KEY (`id_maison`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `maison`
--

INSERT INTO `maison` (`id_maison`, `adr_maison`, `latitude_maison`, `longitude_maison`, `tel_maison`, `ip_maison`) VALUES
(1, 'Route Mahdia km6.5 Avenue Ali bach Hamba ', '31.296', '12.142569', '74891580', '192.168.1.1');

-- --------------------------------------------------------

--
-- Structure de la table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `id_rm` int(11) NOT NULL AUTO_INCREMENT,
  `id_maison` int(11) NOT NULL,
  `des_rm` varchar(50) NOT NULL,
  `temp_rm` int(11) NOT NULL,
  `himu_rm` int(11) NOT NULL,
  PRIMARY KEY (`id_rm`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `rooms`
--

INSERT INTO `rooms` (`id_rm`, `id_maison`, `des_rm`, `temp_rm`, `himu_rm`) VALUES
(1, 1, 'cuisine', 32, 80),
(2, 1, 'Chambre 1', 32, 56),
(3, 1, 'Salon', 32, 56),
(8, 1, 'p3', 32, 56);

-- --------------------------------------------------------

--
-- Structure de la table `shutter`
--

CREATE TABLE IF NOT EXISTS `shutter` (
  `id_shutter` int(11) NOT NULL AUTO_INCREMENT,
  `id_rm` int(11) NOT NULL,
  `etat` int(1) NOT NULL,
  `pin_shutter` int(2) NOT NULL,
  PRIMARY KEY (`id_shutter`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `shutter`
--

INSERT INTO `shutter` (`id_shutter`, `id_rm`, `etat`, `pin_shutter`) VALUES
(1, 1, 1, 7),
(2, 2, 0, 8);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_usr` int(11) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(255) NOT NULL,
  `prenom_user` varchar(255) NOT NULL,
  `email_user` varchar(255) NOT NULL,
  `mdp_user` varchar(255) NOT NULL,
  `tel_user` varchar(255) NOT NULL,
  `date_naissance_user` varchar(255) NOT NULL,
  `pic_user` varchar(255) NOT NULL,
  `etat_user` int(2) NOT NULL,
  PRIMARY KEY (`id_usr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id_usr`, `nom_user`, `prenom_user`, `email_user`, `mdp_user`, `tel_user`, `date_naissance_user`, `pic_user`, `etat_user`) VALUES
(1, 'Magdich', 'Amin', 'magdichamine@gmail.com', '1234', '22397210', '25/11/1990', 'http://', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
