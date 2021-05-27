-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 12 avr. 2021 à 22:26
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cptbank`
--

-- --------------------------------------------------------

--
-- Structure de la table `cheque`
--

CREATE TABLE `cheque` (
  `numch` int(11) NOT NULL,
  `etat` varchar(30) NOT NULL,
  `id` varchar(8) NOT NULL,
  `numcp` int(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cheque`
--

INSERT INTO `cheque` (`numch`, `etat`, `id`, `numcp`, `prenom`, `nom`, `date`) VALUES
(3, 'Terminer', '11112211', 7, 'roua', 'belgacem', '2021-03-01 10:06:17'),
(7, 'Terminer', '56423178', 4, 'yassine', 'Affes', '2021-03-04 13:31:12'),
(14, 'Terminer', '87654321', 9, 'Amyr', 'fezzeni', '2021-03-12 13:59:58');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `id` varchar(8) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `tel` varchar(8) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `date_n` date NOT NULL,
  `pays` varchar(20) NOT NULL,
  `ville` varchar(20) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`prenom`, `nom`, `id`, `mail`, `tel`, `sexe`, `date_n`, `pays`, `ville`, `adresse`, `img`) VALUES
('roua', 'belgacem', '11112211', 'roua@b.com', '55444222', 'femme', '1969-04-05', 'tunis', 'tunis', 'ghazela', ''),
('amyr', 'fezzeni', '12345678', 'mail@mail.com', '54230376', 'homme', '1993-05-15', 'tunis', 'tunnis', 'mannouba', ''),
('yassine', 'Affes', '56423178', 'yassine@affes.fr', '44555222', 'homme', '1997-08-06', 'Tunis', 'tunis', 'ghazela, ariana', '');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` varchar(8) NOT NULL,
  `numcp` int(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `solde` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `numcp`, `prenom`, `nom`, `solde`) VALUES
('56423178', 4, 'yassine', 'Affes', 3200),
('11112211', 7, 'roua', 'belgacem', 3200),
('12345678', 8, 'amyr', 'fezzeni', 5000);

-- --------------------------------------------------------

--
-- Structure de la table `connexion`
--

CREATE TABLE `connexion` (
  `id` varchar(8) NOT NULL,
  `user` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `type` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `connexion`
--

INSERT INTO `connexion` (`id`, `user`, `password`, `type`) VALUES
('', 'admin', 'login', 'boss'),
('12345678', 'amyr', 'login', 'client'),
('12121212', 'mohamed', 'login', 'employes');

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

CREATE TABLE `employes` (
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `id` varchar(8) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `date_n` date NOT NULL,
  `pays` varchar(20) NOT NULL,
  `ville` varchar(20) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `tel` varchar(8) NOT NULL,
  `agence` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employes`
--

INSERT INTO `employes` (`prenom`, `nom`, `id`, `sexe`, `date_n`, `pays`, `ville`, `adresse`, `mail`, `tel`, `agence`) VALUES
('mohamed', 'salah', '12121212', 'homme', '1981-08-15', 'tunis', 'tunis', 'el nasr 2', 'mail@live.fr', '20334455', 'manar 2');

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `numop` int(11) NOT NULL,
  `numcp` varchar(8) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `numcp2` varchar(8) NOT NULL,
  `mentant` float NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`numop`, `numcp`, `prenom`, `nom`, `type`, `numcp2`, `mentant`, `date`) VALUES
(2, '4', 'yassine', 'Affes', 'Depôt', '', 33, '2021-02-25 21:39:37'),
(3, '4', 'yassine', 'Affes', 'Depôt', '', 90, '2021-02-25 21:39:55'),
(4, '4', 'yassine', 'Affes', 'Depôt', '', 500, '2021-02-25 21:40:07'),
(5, '4', 'yassine', 'Affes', 'Retrait', '', 100, '2021-02-25 21:40:15'),
(6, '4', 'yassine', 'Affes', 'Depôt', '', 1500, '2021-02-25 21:46:26'),
(7, '4', 'yassine', 'Affes', 'Depôt', '', 1500, '2021-02-25 21:46:57'),
(8, '7', 'roua', 'belgacem', 'Depôt', '', 1500, '2021-02-25 21:47:37'),
(9, '5', 'amyr', 'fezzeni', 'Depôt', '', 20, '2021-02-25 22:07:11'),
(10, '5', 'amyr', 'fezzeni', 'Retrait', '', 20, '2021-02-25 22:07:17'),
(11, '5', 'amyr', 'fezzeni', 'Depôt', '', 800, '2021-02-25 22:07:47'),
(12, '7', 'roua', 'belgacem', 'Depôt', '', 497, '2021-02-25 22:09:59'),
(13, '7', 'roua', 'belgacem', 'Depôt', '', 1000, '2021-02-25 22:10:15'),
(14, '4', 'yassine', 'Affes', 'Transfert', '7', 200, '2021-02-26 12:24:24'),
(15, '4', 'roua', 'belgacem', 'Transfert', '7', 200, '2021-02-26 12:24:24'),
(16, '5', 'amyr', 'fezzeni', 'Transfert', '6', 200, '2021-02-26 12:26:29'),
(17, '5', 'Amine', 'Mathlouthi', 'Transfert', '6', 200, '2021-02-26 12:26:29'),
(18, '5', 'amyr', 'fezzeni', 'Transfert', '6', 200, '2021-02-26 13:02:10'),
(19, '5', 'amyr', 'fezzeni', 'Transfert', '6', 200, '2021-02-26 13:02:48'),
(20, '5', 'amyr', 'fezzeni', 'Transfert', '6', 200, '2021-02-26 13:03:05'),
(21, '5', 'amyr', 'fezzeni', 'Transfert', '6', 100, '2021-02-26 13:13:50'),
(22, '5', 'amyr', 'fezzeni', 'Transfert', '6', 100, '2021-02-26 13:14:15'),
(23, '5', 'amyr', 'fezzeni', 'Transfert', '6', 200, '2021-02-26 13:16:59'),
(24, '5', 'amyr', 'fezzeni', 'Transfert', '6', 300, '2021-02-26 13:17:24'),
(25, '4', 'yassine', 'Affes', 'Transfert', '5', 800, '2021-02-26 13:36:41'),
(26, '5', 'amyr', 'fezzeni', 'Transfert', '5', 2000, '2021-02-26 13:36:56'),
(27, '5', 'amyr', 'fezzeni', 'Transfert', '4', 400, '2021-02-26 13:37:31'),
(28, '7', 'roua', 'belgacem', 'Transfert', '5', 100, '2021-02-26 13:41:58'),
(29, '5', 'amyr', 'fezzeni', 'Transfert', '7', 500, '2021-02-26 17:41:39'),
(30, '7', 'roua', 'belgacem', 'Depôt', '', 1200, '2021-02-26 17:42:19'),
(31, '4', 'yassine', 'Affes', 'Depôt', '', 600, '2021-02-26 21:49:39'),
(32, '7', 'roua', 'belgacem', 'Transfert', '4', 800, '2021-02-26 21:50:19'),
(33, '6', 'Amine', 'Mathlouthi', 'Retrait', '', 100, '2021-02-26 23:31:46'),
(34, '6', 'Amine', 'Mathlouthi', 'Depôt', '', 1000, '2021-02-26 23:32:05'),
(35, '6', 'Amine', 'Mathlouthi', 'Transfert', '5', 1000, '2021-02-26 23:32:46'),
(36, '4', 'yassine', 'Affes', 'Depôt', '', 200, '2021-02-27 00:39:03'),
(37, '7', 'roua', 'belgacem', 'Transfert', '4', 500, '2021-02-27 00:39:28'),
(38, '7', 'roua', 'belgacem', 'Depôt', '', 500, '2021-02-27 15:57:58'),
(39, '4', 'yassine', 'Affes', 'Transfert', '6', 200, '2021-02-27 15:58:50'),
(40, '8', 'amyr', 'fezzeni', 'Depôt', '', 300, '2021-02-27 22:32:58'),
(41, '8', 'amyr', 'fezzeni', 'Depôt', '', 2400, '2021-02-28 13:48:45'),
(42, '7', 'roua', 'belgacem', 'Transfert', '8', 800, '2021-02-28 13:50:00'),
(43, '8', 'amyr', 'fezzeni', 'Depôt', '', 200, '2021-03-01 19:42:25'),
(44, '8', 'amyr', 'fezzeni', 'Retrait', '', 3000, '2021-03-02 12:47:11'),
(45, '4', 'yassine', 'Affes', 'Transfert', '8', 300, '2021-03-02 12:47:39'),
(46, '10', 'Abdessalam', 'Fezzeni', 'Depôt', '', 500, '2021-03-02 18:25:28'),
(47, '8', 'amyr', 'fezzeni', 'Transfert', '10', 1000, '2021-03-02 18:25:58'),
(48, '8', 'amyr', 'fezzeni', 'Transfert', '4', 300, '2021-03-03 21:24:02'),
(49, '4', 'yassine', 'Affes', 'Transfert', '8', 200, '2021-03-03 21:38:53'),
(50, '8', 'amyr', 'fezzeni', 'Transfert', '4', 200, '2021-03-03 21:40:49'),
(51, '8', 'amyr', 'fezzeni', 'Transfert', '4', 500, '2021-03-03 21:43:26'),
(52, '8', 'amyr', 'fezzeni', 'Transfert', '4', 100, '2021-03-03 21:53:29'),
(53, '8', 'amyr', 'fezzeni', 'Transfert', '4', 20, '2021-03-03 21:53:45'),
(54, '8', 'amyr', 'fezzeni', 'Transfert', '4', 20, '2021-03-03 21:53:49'),
(55, '8', 'amyr', 'fezzeni', 'Transfert', '4', 20, '2021-03-03 21:53:51'),
(56, '8', 'amyr', 'fezzeni', 'Transfert', '4', 20, '2021-03-03 21:53:54'),
(57, '4', 'yassine', 'Affes', 'Transfert', '8', 1980, '2021-03-03 21:56:07'),
(58, '4', 'yassine', 'Affes', 'Transfert', '8', 100, '2021-03-04 13:31:02'),
(59, '8', 'amyr', 'fezzeni', 'Transfert', '4', 400, '2021-03-04 19:17:40'),
(60, '8', 'amyr', 'fezzeni', 'Transfert', '4', 1000, '2021-03-08 16:03:37'),
(61, '8', 'amyr', 'fezzeni', 'Depôt', '', 500, '2021-03-08 16:05:32'),
(62, '9', 'Amyr', 'fezzeni', 'Depôt', '', 500, '2021-03-12 13:56:13'),
(63, '9', 'Amyr', 'fezzeni', 'Retrait', '', 100, '2021-03-12 13:56:26'),
(64, '4', 'yassine', 'Affes', 'Transfert', '9', 1300, '2021-03-12 13:57:10'),
(65, '9', 'Amyr', 'fezzeni', 'Transfert', '4', 200, '2021-03-12 14:00:25');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `numrec` int(11) NOT NULL,
  `id` varchar(8) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `text` text NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`numrec`, `id`, `prenom`, `nom`, `text`, `date`) VALUES
(9, '87654321', 'Amyr', 'fezzeni', 'salut \n', '2021-03-12 14:00:09');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cheque`
--
ALTER TABLE `cheque`
  ADD PRIMARY KEY (`numch`),
  ADD KEY `d` (`id`),
  ADD KEY `f` (`numcp`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prenom` (`prenom`,`nom`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`numcp`),
  ADD KEY `id_2` (`id`),
  ADD KEY `prenom` (`prenom`,`nom`);

--
-- Index pour la table `connexion`
--
ALTER TABLE `connexion`
  ADD PRIMARY KEY (`user`);

--
-- Index pour la table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numop`),
  ADD KEY `numcp` (`numcp`) USING BTREE;

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`numrec`),
  ADD KEY `cx` (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cheque`
--
ALTER TABLE `cheque`
  MODIFY `numch` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `numcp` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `numop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;
--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `numrec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `hhh` FOREIGN KEY (`prenom`) REFERENCES `client` (`prenom`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
