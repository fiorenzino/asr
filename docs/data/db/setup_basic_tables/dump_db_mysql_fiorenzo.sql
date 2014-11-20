-- MySQL dump 10.13  Distrib 5.6.16, for osx10.7 (x86_64)
--
-- Host: localhost    Database: asr
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `Applicazione`
--

DROP TABLE IF EXISTS `Applicazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Applicazione` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Applicazione`
--

LOCK TABLES `Applicazione` WRITE;
/*!40000 ALTER TABLE `Applicazione` DISABLE KEYS */;
INSERT INTO `Applicazione` VALUES (1,'Cup Regionale','CUP'),(2,'AA','AA'),(3,'Laboratorio Analisi','LA'),(4,'Nuovo Cup','NC'),(5,'Pronto Soccorso','PS'),(6,'Win Dialisys','WD'),(7,'ARS Passiva Extra','ARSPE'),(8,'ARS Attività Extra','ARSAE'),(9,'ARS Residenti Extra','ARSRE');
/*!40000 ALTER TABLE `Applicazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Configurazione`
--

DROP TABLE IF EXISTS `Configurazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Configurazione` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `folder` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `orderBy` int(11) NOT NULL,
  `postfisso` varchar(255) DEFAULT NULL,
  `tipologiaFlusso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Configurazione`
--

LOCK TABLES `Configurazione` WRITE;
/*!40000 ALTER TABLE `Configurazione` DISABLE KEYS */;
INSERT INTO `Configurazione` VALUES (1,'/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/','A1',4,'*-a1.txt','A1'),(2,'/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/','A2',5,'*-a2.txt','A2'),(3,'/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/','C1',1,'*-c1.txt','C1'),(4,'/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/','C2',2,'*-c2.txt','C2'),(5,'/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/','C2R',3,'*-c2r.txt','C2R'),(6,'/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/','A2R',6,'*-a2r.txt','A2R');
/*!40000 ALTER TABLE `Configurazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-19 13:23:27
