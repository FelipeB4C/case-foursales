-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: market
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` binary(16) NOT NULL,
  `status` enum('APROVADO','CANCELADO','PENDENTE') DEFAULT NULL,
  `total_value` decimal(38,2) DEFAULT NULL,
  `consumer_id` binary(16) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf1ckvrrf833siakj5al0yurle` (`consumer_id`),
  CONSTRAINT `FKf1ckvrrf833siakj5al0yurle` FOREIGN KEY (`consumer_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (_binary 'Çı*|\‚Kë\È[iL˘e','PENDENTE',780.00,_binary 'H©´\ÈâSB\‡çæ≠ù\∆\¬%æ','2025-11-12 13:06:35.434634'),(_binary ')\ÓÚ\À\«C|àÚ•\¬\Ÿ˝','APROVADO',1899.98,_binary '\«\ÁÜ\·ÙC_è˛\"\Ó˙s%(','2025-11-12 13:06:35.433638'),(_binary '-Œ§ßµ\’A2ê\◊\„ü\ÿR','APROVADO',431.00,_binary '∏)[K\n†g,µÎ§†','2025-11-12 13:06:35.432637'),(_binary 'g∏u˚AM\0¶\⁄¿\√\ﬁ\—\Ë','PENDENTE',1799.98,_binary '\«\ÁÜ\·ÙC_è˛\"\Ó˙s%(','2025-11-12 13:06:35.431635'),(_binary 'm\»\":˘BÉ\‚aÄ\œ:a','PENDENTE',450.00,_binary 'uóJ?∫5Fù\Î\Ê\nó0õr','2025-11-12 13:06:35.432637'),(_binary 'y≠±T6ÄE\ÈÇKlC\Í~8','APROVADO',199.99,_binary 'H©´\ÈâSB\‡çæ≠ù\∆\¬%æ','2025-11-12 13:06:35.431635'),(_binary 'ØV\ÿÿü¢Jü≠ãGómÅ\ﬁ\\','APROVADO',1230.00,_binary '›¶æ,åBŸÄ5¡0\ƒ\Õ\≈','2025-11-12 13:06:35.430636'),(_binary 'øî¿å\Ï™HÑ∂k\Z±\⁄læ','APROVADO',2115.40,_binary 'uóJ?∫5Fù\Î\Ê\nó0õr','2025-11-12 13:06:35.419640'),(_binary '\›A\«\–\À¸AZ≥îöñ_Ñı\…','PENDENTE',1899.90,_binary '›¶æ,åBŸÄ5¡0\ƒ\Õ\≈','2025-11-12 13:06:35.433638'),(_binary '\Ï‘∏∏\…\ÍB≠¢;bÜUK∫','PENDENTE',999.99,_binary '∏)[K\n†g,µÎ§†','2025-11-12 13:06:35.430636');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-12 10:17:05
