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
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` binary(16) NOT NULL,
  `price_at_order` decimal(38,2) NOT NULL,
  `quantity` int NOT NULL,
  `order_id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  KEY `FKocimc7dtr037rh4ls4l95nlfi` (`product_id`),
  CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKocimc7dtr037rh4ls4l95nlfi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (_binary 'ΩHé\ÏBùég/X∂%\ÁF',999.99,1,_binary ')\ÓÚ\À\«C|àÚ•\¬\Ÿ˝',_binary 'ÒA\’LâìK∏à1\Â!Ü?n'),(_binary '·£°†lFÅì2í\“ózR',215.50,2,_binary '-Œ§ßµ\’A2ê\◊\„ü\ÿR',_binary '$,RfFFO?ùq°Ù\»¡'),(_binary '+@^z\÷\ÌO?æ›ûá¡g†',1899.90,1,_binary 'øî¿å\Ï™HÑ∂k\Z±\⁄læ',_binary 'Û\—\’PLŸ£±7âë\‘'),(_binary 'S|WÒ?¡D¢ô@PÉ\Z',199.99,1,_binary 'y≠±T6ÄE\ÈÇKlC\Í~8',_binary 'Øı˙ÏÑµK~ÄXH•:uò\À'),(_binary 'Yp;Ç!K\„¨YØÉ\◊;W',780.00,1,_binary 'ØV\ÿÿü¢Jü≠ãGómÅ\ﬁ\\',_binary 'ò¸JÙÉnC∏ô\Z¨U2ÿ¨'),(_binary 'l˛DRíÆCù¶âäº\Ô\Õ&≥',450.00,1,_binary 'ØV\ÿÿü¢Jü≠ãGómÅ\ﬁ\\',_binary '\Z0@ë\·Oqàsçò\Ã˚'),(_binary 'Ñw∞&\'C3¶≤êrΩá\„\√',899.99,2,_binary 'g∏u˚AM\0¶\⁄¿\√\ﬁ\—\Ë',_binary 'Q“¢\◊l%HÆY\Îpº(Mˇ'),(_binary '©z\ÕS¶ªF\ÌΩ˝ô#\Í_å',1899.90,1,_binary '\›A\«\–\À¸AZ≥îöñ_Ñı\…',_binary 'Û\—\’PLŸ£±7âë\‘'),(_binary '¡^òÆ∏M2≥(.˚yY',999.99,1,_binary '\Ï‘∏∏\…\ÍB≠¢;bÜUK∫',_binary 'ÒA\’LâìK∏à1\Â!Ü?n'),(_binary '⁄ñHCuAz≥*_7\≈\Èß',450.00,1,_binary 'm\»\":˘BÉ\‚aÄ\œ:a',_binary '\Z0@ë\·Oqàsçò\Ã˚'),(_binary '\·éP\ÂM5üL<-{,',780.00,1,_binary 'Çı*|\‚Kë\È[iL˘e',_binary 'ò¸JÙÉnC∏ô\Z¨U2ÿ¨'),(_binary '\Ï´wÒ\“\Ó@q¶B\≈\‰ 5@\ﬁ',215.50,1,_binary 'øî¿å\Ï™HÑ∂k\Z±\⁄læ',_binary '$,RfFFO?ùq°Ù\»¡'),(_binary 'Ò%it≥ØA–ø#üäìñ¢',899.99,1,_binary ')\ÓÚ\À\«C|àÚ•\¬\Ÿ˝',_binary 'Q“¢\◊l%HÆY\Îpº(Mˇ');
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
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
