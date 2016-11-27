-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: tea_app
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `added_by_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_company_user_idx` (`added_by_user`),
  CONSTRAINT `FK_company_user` FOREIGN KEY (`added_by_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavour`
--

DROP TABLE IF EXISTS `flavour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flavour` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavour`
--

LOCK TABLES `flavour` WRITE;
/*!40000 ALTER TABLE `flavour` DISABLE KEYS */;
/*!40000 ALTER TABLE `flavour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `own_tea`
--

DROP TABLE IF EXISTS `own_tea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `own_tea` (
  `id` int(11) NOT NULL,
  `id_tea` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_own_tea_idx` (`id_tea`),
  KEY `FK_own_user_idx` (`id_user`),
  CONSTRAINT `FK_own_tea` FOREIGN KEY (`id_tea`) REFERENCES `tea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_own_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `own_tea`
--

LOCK TABLES `own_tea` WRITE;
/*!40000 ALTER TABLE `own_tea` DISABLE KEYS */;
/*!40000 ALTER TABLE `own_tea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings_by_user`
--

DROP TABLE IF EXISTS `ratings_by_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_by_user` (
  `id` int(11) NOT NULL,
  `id_tea` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ratings_tea_idx` (`id_tea`),
  KEY `FK_ratings_user_idx` (`id_user`),
  CONSTRAINT `FK_ratings_tea` FOREIGN KEY (`id_tea`) REFERENCES `tea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ratings_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings_by_user`
--

LOCK TABLES `ratings_by_user` WRITE;
/*!40000 ALTER TABLE `ratings_by_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `ratings_by_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea`
--

DROP TABLE IF EXISTS `tea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tea` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `id_tea_type` int(11) NOT NULL,
  `has_caffeine` enum('T','F') DEFAULT NULL,
  `temperature_c` int(11) DEFAULT NULL,
  `infusion_time_s` int(11) DEFAULT NULL,
  `quantity_g` int(11) DEFAULT NULL,
  `quantity_water_ml` int(11) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tea_company_idx` (`id_company`),
  KEY `FK_tea_type_idx` (`id_tea_type`),
  CONSTRAINT `FK_tea_company` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tea_type` FOREIGN KEY (`id_tea_type`) REFERENCES `tea_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea`
--

LOCK TABLES `tea` WRITE;
/*!40000 ALTER TABLE `tea` DISABLE KEYS */;
/*!40000 ALTER TABLE `tea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea_category`
--

DROP TABLE IF EXISTS `tea_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tea_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_category`
--

LOCK TABLES `tea_category` WRITE;
/*!40000 ALTER TABLE `tea_category` DISABLE KEYS */;
INSERT INTO `tea_category` VALUES (4,'Black'),(1,'Green'),(5,'Herbal'),(3,'Oolong'),(2,'White');
/*!40000 ALTER TABLE `tea_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea_flavour`
--

DROP TABLE IF EXISTS `tea_flavour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tea_flavour` (
  `id` int(11) NOT NULL,
  `id_tea` int(11) NOT NULL,
  `id_flavour` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_flavour_idx` (`id_flavour`),
  KEY `FK_tea_flavour_idx` (`id_tea`),
  CONSTRAINT `FK_flavour` FOREIGN KEY (`id_flavour`) REFERENCES `flavour` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tea_flavour` FOREIGN KEY (`id_tea`) REFERENCES `tea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_flavour`
--

LOCK TABLES `tea_flavour` WRITE;
/*!40000 ALTER TABLE `tea_flavour` DISABLE KEYS */;
/*!40000 ALTER TABLE `tea_flavour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea_ingredient`
--

DROP TABLE IF EXISTS `tea_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tea_ingredient` (
  `id` int(11) NOT NULL,
  `id_tea` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tea_ingredients_idx` (`id_ingredient`),
  KEY `FK_tea_idx` (`id_tea`),
  CONSTRAINT `FK_tea_ingredients` FOREIGN KEY (`id_tea`) REFERENCES `tea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_ingredient`
--

LOCK TABLES `tea_ingredient` WRITE;
/*!40000 ALTER TABLE `tea_ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `tea_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea_type`
--

DROP TABLE IF EXISTS `tea_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tea_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `id_category` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `FK_tea_type_category_idx` (`id_category`),
  CONSTRAINT `FK_tea_type_category` FOREIGN KEY (`id_category`) REFERENCES `tea_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea_type`
--

LOCK TABLES `tea_type` WRITE;
/*!40000 ALTER TABLE `tea_type` DISABLE KEYS */;
INSERT INTO `tea_type` VALUES (1,'Green type 1',1);
/*!40000 ALTER TABLE `tea_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email_address` varchar(100) NOT NULL,
  `password` varchar(4100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `want_tea`
--

DROP TABLE IF EXISTS `want_tea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `want_tea` (
  `id` int(11) NOT NULL,
  `id_tea` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_want_tea_idx` (`id_tea`),
  KEY `FK_want_user_idx` (`id_user`),
  CONSTRAINT `FK_want_tea` FOREIGN KEY (`id_tea`) REFERENCES `tea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_want_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `want_tea`
--

LOCK TABLES `want_tea` WRITE;
/*!40000 ALTER TABLE `want_tea` DISABLE KEYS */;
/*!40000 ALTER TABLE `want_tea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-27 14:07:51
