-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 16 Kwi 2016, 13:41
-- Wersja serwera: 5.5.47-0ubuntu0.14.04.1
-- Wersja PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `orienteering`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `acomodations`
--

CREATE TABLE IF NOT EXISTS `acomodations` (
  `idacomodation` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `places` int(11) DEFAULT NULL,
  PRIMARY KEY (`idacomodation`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `acomodations`
--

INSERT INTO `acomodations` (`idacomodation`, `adress`, `name`, `description`, `places`) VALUES
(1, 'Miasto ul. Uliczka 12', 'Schronisko', 'Schronisko młodzieżowe', 30),
(2, 'Maisto ul. Ulica 34', 'Szkoła', 'Nocleg na sali gimnastycznej, wymagane śpiwory', 50);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `acomodation_avaliabilities`
--

CREATE TABLE IF NOT EXISTS `acomodation_avaliabilities` (
  `idreservations_options` int(11) NOT NULL AUTO_INCREMENT,
  `acomodationid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`idreservations_options`),
  KEY `fk_acomodation_avaliabilities_1_idx` (`acomodationid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `acomodation_avaliabilities`
--

INSERT INTO `acomodation_avaliabilities` (`idreservations_options`, `acomodationid`, `date`, `price`) VALUES
(1, 1, '2016-07-01', 35),
(2, 2, '2016-07-01', 10);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `acomodation_reservations`
--

CREATE TABLE IF NOT EXISTS `acomodation_reservations` (
  `idacomodation_reservations` int(11) NOT NULL AUTO_INCREMENT,
  `acomodation_option` int(11) NOT NULL,
  `competitor` int(11) NOT NULL,
  PRIMARY KEY (`idacomodation_reservations`),
  KEY `fk_acomodation_reservations_1_idx` (`acomodation_option`),
  KEY `fk_acomodation_reservations_2_idx` (`competitor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `acomodation_reservations`
--

INSERT INTO `acomodation_reservations` (`idacomodation_reservations`, `acomodation_option`, `competitor`) VALUES
(1, 1, 1),
(2, 2, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `idcategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `categories`
--

INSERT INTO `categories` (`idcategory`, `name`) VALUES
(1, 'Man'),
(2, 'Woman');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `caterings`
--

CREATE TABLE IF NOT EXISTS `caterings` (
  `idacatering` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idacatering`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `caterings`
--

INSERT INTO `caterings` (`idacatering`, `adress`, `name`, `description`) VALUES
(1, 'Misto ul. Ulica 12', 'Bar u Mariana', 'Całkiem spoko bar'),
(2, 'Maisto ul. Ulica 35', 'SP 2', 'Stołówka SP nr 2');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `catering_avaliabilities`
--

CREATE TABLE IF NOT EXISTS `catering_avaliabilities` (
  `idreservations_options` int(11) NOT NULL AUTO_INCREMENT,
  `cateringid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `meal_time` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`idreservations_options`),
  KEY `fk_catering_avaliabilities_1_idx` (`cateringid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `catering_avaliabilities`
--

INSERT INTO `catering_avaliabilities` (`idreservations_options`, `cateringid`, `date`, `meal_time`, `description`, `price`) VALUES
(1, 1, '2016-07-01', 'kolacja', 'Pizza', 15),
(2, 2, '2016-07-01', 'obiad', 'tradycyjny schabowy z ziemniakami i kapustą', 12);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `catering_reservations`
--

CREATE TABLE IF NOT EXISTS `catering_reservations` (
  `idcatering_reservations` int(11) NOT NULL AUTO_INCREMENT,
  `cateriing_option` int(11) NOT NULL,
  `competitor` int(11) NOT NULL,
  PRIMARY KEY (`idcatering_reservations`),
  KEY `fk_catering_reservations_1_idx` (`cateriing_option`),
  KEY `fk_catering_reservations_2_idx` (`competitor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Zrzut danych tabeli `catering_reservations`
--

INSERT INTO `catering_reservations` (`idcatering_reservations`, `cateriing_option`, `competitor`) VALUES
(1, 1, 1),
(2, 1, 3),
(3, 2, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `clubs`
--

CREATE TABLE IF NOT EXISTS `clubs` (
  `idclub` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `agent_name` varchar(45) DEFAULT NULL,
  `agent_surname` varchar(45) DEFAULT NULL,
  `club_number` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idclub`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Zrzut danych tabeli `clubs`
--

INSERT INTO `clubs` (`idclub`, `name`, `address`, `agent_name`, `agent_surname`, `club_number`, `phone_number`) VALUES
(0, 'ADMINI', NULL, NULL, NULL, NULL, NULL),
(1, 'Jan Kowalski', 'Wiocha 123', 'Jan', 'Kowalski', NULL, '123-456-789'),
(2, 'SKS ', 'Miasteczko ul. Wiosenna 45', 'Piotr', 'Nowak', 'WOJ123', '987-654-321');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `competiton_info`
--

CREATE TABLE IF NOT EXISTS `competiton_info` (
  `idcompetiton_info` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `begin` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `entry_fee` float DEFAULT NULL,
  `overdue_entry_fee` float DEFAULT NULL,
  `chip_borrow_fee` float DEFAULT NULL,
  `chip_lost_fee` float DEFAULT NULL,
  `aplication_deadline` date DEFAULT NULL,
  `aplication_start` date DEFAULT NULL,
  PRIMARY KEY (`idcompetiton_info`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Zrzut danych tabeli `competiton_info`
--

INSERT INTO `competiton_info` (`idcompetiton_info`, `description`, `name`, `address`, `begin`, `end`, `entry_fee`, `overdue_entry_fee`, `chip_borrow_fee`, `chip_lost_fee`, `aplication_deadline`, `aplication_start`) VALUES
(1, 'Testowe zawody', 'Bieg na orientacje', 'Miasto ul. Ulica 23', '2016-07-01', '2016-07-03', 100, 200, 50, 250, '2016-04-23', '2016-06-30');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `competitors`
--

CREATE TABLE IF NOT EXISTS `competitors` (
  `idcompetitor` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `licence_number` varchar(5) DEFAULT NULL,
  `chip_number` int(11) DEFAULT NULL,
  `idclub` int(11) NOT NULL,
  `birth_year` int(11) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcompetitor`),
  UNIQUE KEY `chip_number_UNIQUE` (`chip_number`),
  KEY `fk_competitors_2_idx` (`category`),
  KEY `fk_competitors_1_idx` (`idclub`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Zrzut danych tabeli `competitors`
--

INSERT INTO `competitors` (`idcompetitor`, `name`, `surname`, `licence_number`, `chip_number`, `idclub`, `birth_year`, `gender`, `category`) VALUES
(1, 'Jan', 'Kowalski', 'LIC01', 123456789, 1, 1980, 'M', 1),
(2, 'Anna', 'Nowak', 'LIC02', 2147483647, 2, 1995, 'F', 2),
(3, 'Katarzyna', 'Jakaśtam', 'LIC04', 123453223, 2, 1993, 'F', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `idclub` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `idclub` (`idclub`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`iduser`, `email`, `password`, `type`, `idclub`) VALUES
(1, 'admin@zawody.pl', 'admin1', 'admin', 0),
(2, 'jankowalski@wp.pl', 'janeczek1', 'ind', 1),
(10, 'agent@sks.pl', 'agent1', 'agent', 2);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `acomodation_avaliabilities`
--
ALTER TABLE `acomodation_avaliabilities`
  ADD CONSTRAINT `fk_acomodation_avaliabilities_1` FOREIGN KEY (`acomodationid`) REFERENCES `acomodations` (`idacomodation`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `acomodation_reservations`
--
ALTER TABLE `acomodation_reservations`
  ADD CONSTRAINT `fk_acomodation_reservations_1` FOREIGN KEY (`acomodation_option`) REFERENCES `acomodation_avaliabilities` (`idreservations_options`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_acomodation_reservations_2` FOREIGN KEY (`competitor`) REFERENCES `competitors` (`idcompetitor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `catering_avaliabilities`
--
ALTER TABLE `catering_avaliabilities`
  ADD CONSTRAINT `fk_catering_avaliabilities_1` FOREIGN KEY (`cateringid`) REFERENCES `caterings` (`idacatering`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `catering_reservations`
--
ALTER TABLE `catering_reservations`
  ADD CONSTRAINT `fk_catering_reservations_1` FOREIGN KEY (`cateriing_option`) REFERENCES `catering_avaliabilities` (`idreservations_options`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_catering_reservations_2` FOREIGN KEY (`competitor`) REFERENCES `competitors` (`idcompetitor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `competitors`
--
ALTER TABLE `competitors`
  ADD CONSTRAINT `fk_competitors_1` FOREIGN KEY (`idclub`) REFERENCES `clubs` (`idclub`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_competitors_2` FOREIGN KEY (`category`) REFERENCES `categories` (`idcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`idclub`) REFERENCES `clubs` (`idclub`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
