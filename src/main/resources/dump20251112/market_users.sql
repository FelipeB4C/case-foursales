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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` binary(16) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (_binary '∏)[K\n†g,µÎ§†','$2a$10$YcupddIbnCvYtKV0mXUIEeQH13ynIUXMXRmhDTy/hDbnPxvW6zpEK','USER','ana.silva'),(_binary 'H©´\ÈâSB\‡çæ≠ù\∆\¬%æ','$2a$10$YcupddIbnCvYtKV0mXUIEeQH13ynIUXMXRmhDTy/hDbnPxvW6zpEK','USER','diego.fernandes'),(_binary 'uóJ?∫5Fù\Î\Ê\nó0õr','$2a$10$YcupddIbnCvYtKV0mXUIEeQH13ynIUXMXRmhDTy/hDbnPxvW6zpEK','USER','normal.user'),(_binary 'ç|^ìSCBπˇ¸Æ{M$X','$2a$10$OD/Z3iB3ngRrgOLRdCZBgOo6ioULmXbrd01niQlw.CHiXVwsU7ks.','ADMIN','admin.user'),(_binary '\«\ÁÜ\·ÙC_è˛\"\Ó˙s%(','$2a$10$YcupddIbnCvYtKV0mXUIEeQH13ynIUXMXRmhDTy/hDbnPxvW6zpEK','USER','carla.dias'),(_binary '›¶æ,åBŸÄ5¡0\ƒ\Õ\≈','$2a$10$YcupddIbnCvYtKV0mXUIEeQH13ynIUXMXRmhDTy/hDbnPxvW6zpEK','USER','bruno.costa');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
