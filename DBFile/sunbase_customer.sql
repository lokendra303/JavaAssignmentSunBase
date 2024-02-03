CREATE DATABASE  IF NOT EXISTS `sunbase` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sunbase`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: sunbase
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `uuid` varchar(200) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('e065318e-2fdf-4a23-b55e-6403f3a6924b','Lokendra','Kushwah','Agra','lk.kush@gmail.com','89777273','Agra IradatNagar','UP','thapenda'),('test178446f19c194adf97389b1cd3666a18','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test43473a3ac92b4b8181b0b689a90b915d','Test','lastname','test city','vipin.saini@bankit.innn','9870709771','testing address','test state','test street'),('test435b12df78f04ff089b684e42f87caf6','Janes','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test46552341615b460ca5a7dc5e366072c6','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test4d9624d18b954124a1db923cafcf9ca5','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test4dab258085664b61ab5d619cc0512e7a','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test5b1edfeb2c2645f8b9613c7faeb1ddac','test','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test75975ec095054f57b4900c63430631d1','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test7ee53592448c45989af1e3b6b1b921c6','Test','testing','test city','saini587@gmail.com','9787879660','test vip','saharanpur','test street'),('test84101b8cf7a64884b407bfd7ea69d1cb','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test855e8bb96d0040e2ad7277b6cb06e23c','SKY','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test8f5372f295b948c19c179cb6d0d57e83','Janes','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('test9c1818df2a64402b871d465469bb68f0','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('testa7db6029fac24ad39c1d4621cb32b4a1','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('testcec0235c5b34460ba0f88d7087756355','Jane','Doe','Delhi','sam@gmail.com','12345678','H no 2 ','Delhi','Elvnu Street'),('teste5386fea0e4441d395ee747f54aeb567','Jane','Doe','Delhi','sam@gmail.com','12345678','no','Delhi','Elvnu');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-03 12:09:14
