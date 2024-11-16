-- MariaDB dump 10.19  Distrib 10.5.19-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: s26766
-- ------------------------------------------------------
-- Server version	10.5.19-MariaDB-0+deb11u2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(20) DEFAULT NULL,
  `nazwisko` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Aleister','Crowley'),(2,'Franz','Kafka'),(3,'Fyodor','Dostoevsky'),(4,'Leo','Tolstoy'),(5,'Jane','Austen'),(6,'Mark','Twain'),(7,'Virginia','Woolf'),(8,'Hermann','Hesse'),(9,'Zbigniew','Nienacki'),(10,'Isabel','Allende'),(11,'George','Orwell'),(12,'Haruki','Murakami'),(13,'Ernest','Hemingway'),(14,'Aldous','Huxley'),(15,'Adam','Mickiewicz'),(16,'Agatha','Christie'),(17,'Albert','Camus'),(18,'Ray','Bradbury'),(19,'Ayn','Rand'),(20,'Hendryk','Sienkiewicz');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `czytelnik`
--

DROP TABLE IF EXISTS `czytelnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `czytelnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(20) DEFAULT NULL,
  `nazwisko` varchar(40) DEFAULT NULL,
  `pesel` char(11) DEFAULT NULL,
  `ilosc_wypozyczen` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pesel` (`pesel`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `czytelnik`
--

LOCK TABLES `czytelnik` WRITE;
/*!40000 ALTER TABLE `czytelnik` DISABLE KEYS */;
INSERT INTO `czytelnik` VALUES (1,'Anna','Kowalska','95010212345',0),(2,'Jan','Nowak','88030523456',0),(3,'Marta','Wiśniewska','73041234567',0),(4,'Piotr','Lewandowski','82060245678',0),(5,'Magdalena','Kaczmarek','91070156789',0),(6,'Krzysztof','Zieliński','69081667890',0),(7,'Ewa','Wójcik','99092578901',0),(8,'Tomasz','Szymański','75030189012',0),(9,'Katarzyna','Dąbrowska','84052090123',0),(10,'Michał','Jankowski','96060701234',0),(11,'Alicja','Mazurek','89080412345',0),(12,'Adam','Witkowski','80091323456',0),(13,'Karolina','Jastrzębska','92092234567',0),(14,'Marcin','Olszewski','70033145678',0),(15,'Dominika','Nowicka','93051056789',0),(16,'Robert','Kubiak','76061967890',0),(17,'Natalia','Kamińska','87082878901',0),(18,'Łukasz','Zając','94050789012',0),(19,'Monika','Piotrowska','78071690123',0),(20,'Grzegorz','Głowacki','91082501234',0),(21,'Jan','Kowalski','86082203333',NULL);
/*!40000 ALTER TABLE `czytelnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egzemplarz`
--

DROP TABLE IF EXISTS `egzemplarz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `egzemplarz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ksiazka_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ksiazka_id` (`ksiazka_id`),
  CONSTRAINT `egzemplarz_ibfk_1` FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazka` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egzemplarz`
--

LOCK TABLES `egzemplarz` WRITE;
/*!40000 ALTER TABLE `egzemplarz` DISABLE KEYS */;
INSERT INTO `egzemplarz` VALUES (82,141),(83,141),(84,141),(85,141),(86,141),(87,141),(88,142),(89,142),(90,142),(91,142),(92,143),(93,143),(94,143),(95,143),(96,143),(97,144),(98,145),(99,145),(100,146),(101,147),(102,147),(103,147),(104,147),(105,147),(106,148),(107,149),(108,150),(109,151),(110,151),(111,151),(112,152),(113,153),(114,154),(115,155),(116,156),(117,157),(118,158),(119,158),(120,159),(121,159),(122,160),(123,160),(124,160),(125,160);
/*!40000 ALTER TABLE `egzemplarz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `k_a`
--

DROP TABLE IF EXISTS `k_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `k_a` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `autor_id` int(11) DEFAULT NULL,
  `ksiazka_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `autor_id` (`autor_id`),
  KEY `ksiazka_id` (`ksiazka_id`),
  CONSTRAINT `k_a_ibfk_1` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`),
  CONSTRAINT `k_a_ibfk_2` FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazka` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `k_a`
--

LOCK TABLES `k_a` WRITE;
/*!40000 ALTER TABLE `k_a` DISABLE KEYS */;
INSERT INTO `k_a` VALUES (41,1,141),(42,2,142),(43,3,143),(44,4,144),(45,5,145),(46,6,146),(47,7,147),(48,8,148),(49,9,149),(50,10,150),(51,11,151),(52,12,152),(53,13,153),(54,14,154),(55,15,155),(56,16,156),(57,17,157),(58,18,158),(59,19,159),(60,20,160);
/*!40000 ALTER TABLE `k_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ksiazka`
--

DROP TABLE IF EXISTS `ksiazka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ksiazka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tytul` varchar(255) DEFAULT NULL,
  `autor_id` int(11) DEFAULT NULL,
  `wydawnictwo_id` int(11) DEFAULT NULL,
  `liczba_stron` int(11) DEFAULT NULL,
  `rok_wydania` year(4) DEFAULT NULL,
  `isbn` char(13) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ksiazka`
--

LOCK TABLES `ksiazka` WRITE;
/*!40000 ALTER TABLE `ksiazka` DISABLE KEYS */;
INSERT INTO `ksiazka` VALUES (141,'Magia w teorii i praktyce',1,1,312,1929,'1181234567890'),(142,'Proces',2,2,280,1925,'2282345678901'),(143,'Zbrodnia i kara',3,3,608,1966,'3383456789012'),(144,'Anna Karenina',4,4,864,1977,'4484567890123'),(145,'Duma i uprzedzenie',5,5,432,1913,'8888678901234'),(146,'Przygody Tomka Sawyera',6,6,288,1976,'6686789012345'),(147,'Mrs Dalloway',7,7,194,1925,'7787890123456'),(148,'Step',8,8,400,1933,'9788901234567'),(149,'Pan Samochodzik',9,9,240,1964,'9789012345678'),(150,'Eva Luna',10,10,432,1987,'1180123456789'),(151,'Rok 1984',11,11,328,1949,'2281234567899'),(152,'Norwegian Wood',12,12,296,1987,'3382345678922'),(153,'Pożegnanie z bronią',13,13,320,1929,'3333456789012'),(154,'Nowy wspaniały świat',14,14,288,1932,'9994567890123'),(155,'Pan Tadeusz',15,15,340,1934,'5585678901234'),(156,'Zabójstwo Rogera Ackroyda',16,16,272,1926,'6666789012345'),(157,'Obcy',17,17,220,1942,'6687890123456'),(158,'Obcy w raju',18,18,336,1950,'7788901234567'),(159,'451 stopni Fahrenheit',19,19,208,1953,'9989012345678'),(160,'Źródło',20,20,960,1943,'3330123456789');
/*!40000 ALTER TABLE `ksiazka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_e`
--

DROP TABLE IF EXISTS `w_e`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_e` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wypozyczenie_id` int(11) DEFAULT NULL,
  `egzemplarz_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `wypozyczenie_id` (`wypozyczenie_id`),
  KEY `egzemplarz_id` (`egzemplarz_id`),
  CONSTRAINT `w_e_ibfk_1` FOREIGN KEY (`wypozyczenie_id`) REFERENCES `wypozyczenie` (`id`),
  CONSTRAINT `w_e_ibfk_2` FOREIGN KEY (`egzemplarz_id`) REFERENCES `egzemplarz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_e`
--

LOCK TABLES `w_e` WRITE;
/*!40000 ALTER TABLE `w_e` DISABLE KEYS */;
INSERT INTO `w_e` VALUES (1,1,82),(2,2,88),(3,3,97),(4,4,98),(5,5,101),(6,6,106),(7,7,107),(8,8,108),(9,9,109),(10,10,110),(11,11,111),(12,12,112),(13,13,113),(14,14,114),(15,15,115),(16,16,116),(17,17,117),(18,18,118),(19,19,119),(20,20,120),(21,21,122),(22,22,83),(23,23,92),(24,24,93),(25,25,94),(26,26,95),(27,27,96);
/*!40000 ALTER TABLE `w_e` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wydawnictwo`
--

DROP TABLE IF EXISTS `wydawnictwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wydawnictwo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wydawnictwo`
--

LOCK TABLES `wydawnictwo` WRITE;
/*!40000 ALTER TABLE `wydawnictwo` DISABLE KEYS */;
INSERT INTO `wydawnictwo` VALUES (1,'Okultura'),(2,'Wydawnictwo Literackie'),(3,'Wydawnictwo Albatros'),(4,'Wydawnictwo Ossolineum'),(5,'Znak'),(6,'Czytelnik'),(7,'Wydawnictwo MG'),(8,'PIW (Państwowy Instytut Wydawniczy)'),(9,'Iskry'),(10,'Muza'),(11,'Amber'),(12,'Czarne'),(13,'Znak Literanova'),(14,'Sonia Draga'),(15,'Czarna Owca'),(16,'Wydawnictwo Literackie'),(17,'W.A.B. / Bellona'),(18,'Prószyński i S-ka'),(19,'Świat Książki'),(20,'Znak Emotikon');
/*!40000 ALTER TABLE `wydawnictwo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wypozyczenie`
--

DROP TABLE IF EXISTS `wypozyczenie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wypozyczenie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `czytelnik_id` int(11) DEFAULT NULL,
  `data_wypozyczenia` date DEFAULT NULL,
  `okres_wypozyczenia` int(11) DEFAULT NULL,
  `data_zwrotu` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `czytelnik_id` (`czytelnik_id`),
  CONSTRAINT `wypozyczenie_ibfk_1` FOREIGN KEY (`czytelnik_id`) REFERENCES `czytelnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wypozyczenie`
--

LOCK TABLES `wypozyczenie` WRITE;
/*!40000 ALTER TABLE `wypozyczenie` DISABLE KEYS */;
INSERT INTO `wypozyczenie` VALUES (1,1,'2023-01-15',17,'2023-02-01'),(2,1,'2023-01-15',55,'2023-03-11'),(3,2,'2023-11-01',44,'2023-12-15'),(4,2,'2023-11-02',39,'2023-12-11'),(5,3,'2023-12-01',14,'2023-12-15'),(6,3,'2023-12-02',9,'2023-12-11'),(7,4,'2023-12-01',14,'2023-12-15'),(8,5,'2023-12-02',9,'2023-12-11'),(9,6,'2023-12-01',10,'2023-12-11'),(10,7,'2023-12-02',13,'2023-12-15'),(11,8,'2023-12-01',NULL,NULL),(12,9,'2023-12-02',NULL,NULL),(13,10,'2023-11-01',44,'2023-12-15'),(14,11,'2023-12-02',7,'2023-12-09'),(15,12,'2023-12-02',7,'2023-12-09'),(16,13,'2023-12-02',7,'2023-12-09'),(17,14,'2023-12-02',7,'2023-12-09'),(18,15,'2023-12-02',16,'2023-12-18'),(19,16,'2023-12-02',16,'2023-12-18'),(20,17,'2023-12-02',16,'2023-12-18'),(21,18,'2023-12-02',16,'2023-12-18'),(22,19,'2023-12-02',16,'2023-12-18'),(23,20,'2023-09-11',NULL,NULL),(24,20,'2023-09-11',NULL,NULL),(25,20,'2023-09-11',NULL,NULL),(26,20,'2023-09-11',NULL,NULL),(27,20,'2023-09-11',NULL,NULL);
/*!40000 ALTER TABLE `wypozyczenie` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`s26766`@`localhost`*/ /*!50003 TRIGGER oblicz_okres_wypozyczenia
BEFORE UPDATE ON wypozyczenie
FOR EACH ROW
BEGIN
    IF NEW.data_zwrotu IS NOT NULL THEN
        SET NEW.okres_wypozyczenia = DATEDIFF(NEW.data_zwrotu, NEW.data_wypozyczenia);
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-18 23:36:46
