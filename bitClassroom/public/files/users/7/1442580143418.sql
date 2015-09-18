-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 01, 2015 at 04:43 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bitRoom`
--

-- --------------------------------------------------------

--
-- Table structure for table `play_evolutions`
--

CREATE TABLE IF NOT EXISTS `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` mediumtext,
  `revert_script` mediumtext,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `play_evolutions`
--

INSERT INTO `play_evolutions` (`id`, `hash`, `applied_at`, `apply_script`, `revert_script`, `state`, `last_problem`) VALUES
(1, '8a27991e04e2cabbba142a1a4f3fb7b245965129', '2015-09-01 14:08:18', 'create table user (\nid                        integer auto_increment not null,\nemail                     varchar(255),\npassword                  varchar(255),\nconstraint pk_user primary key (id))\n;', 'SET FOREIGN_KEY_CHECKS=0;\n\ndrop table user;\n\nSET FOREIGN_KEY_CHECKS=1;', 'applied', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1994 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`) VALUES
(3, 'mail3@mail.com', 'password10'),
(4, 'email4@mail.com', 'e529a9cea4a728eb9c5828b13b22844c'),
(5, 'email4@mail.com', '87e897e3b54a405da144968b2ca19b45'),
(15, 'becir.omerbasic@bitcamp.ba', '45fb4667a0859e577680bf8ae9722be3'),
(23, 'nidal.salkic@bitcamp.ba', '770865305456894ed8d82a4b9a492536'),
(99, 'enver.memic@bitcamp.ba', '923352284767451ab158a387a283df26'),
(1993, 'medina.banjic@bitcamp.ba', 'cef44b46f16ae8ecf664df4266ffdbf9');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `play_evolutions`
--
ALTER TABLE `play_evolutions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1994;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
