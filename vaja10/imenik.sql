-- MariaDB dump 10.19-11.3.2-MariaDB, for Linux (x86_64)
--
-- Host: 10.0.100.100    Database: imenik
-- ------------------------------------------------------
-- Server version	11.3.2-MariaDB-1:11.3.2+maria~ubu2204

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
-- Table structure for table `Kontakt`
--

DROP TABLE IF EXISTS `Kontakt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Kontakt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vrsta_kontakta` varchar(500) DEFAULT NULL,
  `sklic` varchar(500) DEFAULT NULL,
  `oseba_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Kontakt`
--

LOCK TABLES `Kontakt` WRITE;
/*!40000 ALTER TABLE `Kontakt` DISABLE KEYS */;
INSERT INTO `Kontakt` VALUES
(1,'BeboUrl,  http://www.bebo.com/Profile.jsp?MemberId=4859134126\ne-mail,  loli.pop@loli.pop\nmobilni, +386 00 1212 123',NULL,1),
(2,'BeboUrl,  http://www.bebo.com/Profile.jsp?MemberId=4859134665\ne-mail,  pop@gmail.pop\nmobilni, +386 00 2323 321',NULL,1),
(3,'BeboUrl,  http://www.bebo.com/Profile.jsp?MemberId=4859134789\ne-mail,  test@test.pop\nmobilni, +386 00 4545 321',NULL,2);
/*!40000 ALTER TABLE `Kontakt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Oseba`
--

DROP TABLE IF EXISTS `Oseba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Oseba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poljudno_ime` varchar(10) DEFAULT NULL,
  `rezultat` int(20) DEFAULT NULL,
  `st_iger` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Oseba`
--

LOCK TABLES `Oseba` WRITE;
/*!40000 ALTER TABLE `Oseba` DISABLE KEYS */;
INSERT INTO `Oseba` VALUES
(1,'Neža Novak',123,0),
(2,'Luka Kovač',334,145),
(3,'Lana Zupan',34,10),
(4,'Mark Rene',113,44),
(5,'Maja Krajn',455,77);
/*!40000 ALTER TABLE `Oseba` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-28 18:52:24
