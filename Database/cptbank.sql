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
('12345678', 'amyr', 'login', 'client');

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
