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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` binary(16) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `in_stock` int DEFAULT NULL,
  `last_updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (_binary '\Z0@ë\·Oqàsçò\Ã˚','PERIF√âRICO','2025-11-12 13:06:35.386630','Switch Red, layout ABNT2, com ilumina√ß√£o customiz√°vel.',120,'2025-11-12 13:06:35.386630','Teclado Mec√¢nico RGB',450.00),(_binary '$,RfFFO?ùq°Ù\»¡','PERIF√âRICO','2025-11-12 13:06:35.386630','Design ergon√¥mico, 16000 DPI, bateria de longa dura√ß√£o.',85,'2025-11-12 13:06:35.386630','Mouse sem Fio',215.50),(_binary 'Q“¢\◊l%HÆY\Îpº(Mˇ','HARDWARE','2025-11-12 13:06:35.387632','Processador AMD 8 n√∫cleos',10,'2025-11-12 13:06:35.387632','Processador AMD 1800X',899.99),(_binary 'ò¸JÙÉnC∏ô\Z¨U2ÿ¨','PERIF√âRICO','2025-11-12 13:06:35.386630','√Åudio 7.1 surround, microfone com cancelamento de ru√≠do.',60,'2025-11-12 13:06:35.386630','Headset Pro X',780.00),(_binary 'Øı˙ÏÑµK~ÄXH•:uò\À','PERIF√âRICO','2025-11-12 13:06:35.387632','Lente de vidro, 1080p a 30fps, ideal para streaming.',150,'2025-11-12 13:06:35.387632','Webcam Full HD',199.99),(_binary 'ÒA\’LâìK∏à1\Â!Ü?n','CADEIRA','2025-11-12 13:06:35.387632','Cadeira gamer X PRO',5,'2025-11-12 13:06:35.387632','Cadeira gamer',999.99),(_binary 'Û\—\’PLŸ£±7âë\‘','MONITOR','2025-11-12 13:06:35.371642','Monitor de alta performance com 144Hz e painel IPS.',50,'2025-11-12 13:06:35.371642','Monitor Gamer 27\'',1899.90);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
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
