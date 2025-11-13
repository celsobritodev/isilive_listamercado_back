-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: db_listamercado
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_itemlista`
--

DROP TABLE IF EXISTS `tbl_itemlista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_itemlista` (
  `num_seq` int NOT NULL AUTO_INCREMENT,
  `quantidade` double DEFAULT NULL,
  `preco_total` double DEFAULT NULL,
  `concluido` int DEFAULT NULL,
  `tbl_lista_id_lista` int NOT NULL,
  `tbl_produto_id_produto` int NOT NULL,
  PRIMARY KEY (`num_seq`),
  KEY `fk_tbl_itemlista_tbl_lista_idx` (`tbl_lista_id_lista`),
  KEY `fk_tbl_itemlista_tbl_produto1_idx` (`tbl_produto_id_produto`),
  CONSTRAINT `fk_tbl_itemlista_tbl_lista` FOREIGN KEY (`tbl_lista_id_lista`) REFERENCES `tbl_lista` (`id_lista`),
  CONSTRAINT `fk_tbl_itemlista_tbl_produto1` FOREIGN KEY (`tbl_produto_id_produto`) REFERENCES `tbl_produto` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_itemlista`
--

LOCK TABLES `tbl_itemlista` WRITE;
/*!40000 ALTER TABLE `tbl_itemlista` DISABLE KEYS */;
INSERT INTO `tbl_itemlista` VALUES (4,2,5,0,24,1),(5,1,8,0,24,16),(6,7,15,0,24,13),(7,7,7,1,42,14),(8,2,10,0,42,21),(9,1,5,0,42,22);
/*!40000 ALTER TABLE `tbl_itemlista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-13  7:28:12
