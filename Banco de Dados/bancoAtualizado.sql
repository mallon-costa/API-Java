CREATE DATABASE  IF NOT EXISTS `agencia_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agencia_db`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agencia_db
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `hospedagem`
--

DROP TABLE IF EXISTS `hospedagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospedagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(100) DEFAULT NULL,
  `data_entrada` date NOT NULL,
  `data_saida` date NOT NULL,
  `numero_quartos` int DEFAULT NULL,
  `quantidade_pessoas` int DEFAULT NULL,
  `valor` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospedagem`
--

LOCK TABLES `hospedagem` WRITE;
/*!40000 ALTER TABLE `hospedagem` DISABLE KEYS */;
INSERT INTO `hospedagem` VALUES (3,'Belo Horizonte','2022-04-11','2022-06-07',1,2,NULL),(5,'Tucurui','2052-03-10','2023-04-15',40,5,NULL),(6,'Belém','2052-03-10','2023-04-15',40,5,NULL),(7,'São Luis','2022-05-29','2022-06-06',2,4,NULL),(8,'Cuiabá','2020-03-23','2020-04-10',3,7,NULL),(9,'Orlando','2022-05-31','2022-06-08',2,4,800);
/*!40000 ALTER TABLE `hospedagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numeroCartao` int DEFAULT NULL,
  `codSeguranca` int DEFAULT NULL,
  `quantParcelas` int DEFAULT NULL,
  `valor` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,123456,154596,2,30);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passagem`
--

DROP TABLE IF EXISTS `passagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `origem` varchar(100) DEFAULT NULL,
  `destino` varchar(100) DEFAULT NULL,
  `data_ida` date NOT NULL,
  `data_volta` date NOT NULL,
  `valor_passagem` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passagem`
--

LOCK TABLES `passagem` WRITE;
/*!40000 ALTER TABLE `passagem` DISABLE KEYS */;
INSERT INTO `passagem` VALUES (12,'Recife','Fortaleza','2020-04-11','2020-04-14',720.00),(13,'Novo Repartimento','Parauapebas','2020-04-11','2020-04-14',250.00),(14,'Montes Altos','Araguaina','2020-04-11','2020-04-14',720.00),(15,'Goaiania','Araguaina','2020-04-11','2020-04-14',720.00),(16,'Rio Branco','Palmas','2019-03-11','2020-04-14',720.00),(17,'Macapá','Porto Alegre','2019-03-11','2019-04-14',720.00),(18,'Curitiba','Maceió','2022-05-29','2022-06-02',720.00),(19,'Rio de Janeiro','Foz do Iguaçu','2022-05-30','2022-05-31',740.00),(20,'Santana do Araguaia','Montes Claros','2022-05-24','2022-06-02',740.00);
/*!40000 ALTER TABLE `passagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `senha` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Carla Sagan','carl@gmail.com','031589745',NULL,NULL,NULL),(4,'Manoel Malon','malon@gmail.com','546123',NULL,NULL,NULL),(5,'Henrique Viana','henrique@gmail.com','23164565792','98715632110',20,NULL),(6,'alaim','alaim@unifesspa.edu.br','9499126538','2135465521',22,NULL),(7,'joao','joao@unifesspa.edu.br','12356451','54561378',36,NULL),(8,'Silva','silva@unifesspa.edu.br','9499126538','2135465521',45,NULL),(9,'matheus','matheus@gmail.com','123156','561235456',51,NULL),(10,'','','','',NULL,NULL),(25,'josé','jose@email.com','123491','12456745615',65,NULL),(37,'unifesspa','unifesspa@gmail.com','2123265792','9871875120',8,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01 11:06:38
