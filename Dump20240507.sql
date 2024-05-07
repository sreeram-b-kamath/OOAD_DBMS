-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: feedback
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `dep_id` int NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(20) NOT NULL,
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'HR'),(2,'SFM'),(3,'DEVELOPMENT'),(4,'QA'),(5,'BA'),(6,'L&C');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_firstname` varchar(20) NOT NULL,
  `emp_lastname` varchar(20) NOT NULL,
  `dep_id` int NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `dep_id` (`dep_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `department` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Sreeram','Kamath',3),(2,'Imran','Khan',3),(3,'Joel','Jude',3),(4,'Jean','Paul',1),(5,'Toni','K',1),(6,'Anish','Korah',2),(7,'Edwin','Benny',2),(8,'Evilyn','Peter',4),(9,'Devika','Sabu',4),(10,'Rahul','Nair',5),(11,'Melinda','Melkizedek',5),(12,'Jordan','Ben',6),(13,'Nevin','Joseph',6);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollment` (
  `program_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `attendance` enum('Y','N') NOT NULL DEFAULT 'N',
  `enrollment_date` date NOT NULL,
  KEY `program_id` (`program_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`program_id`) REFERENCES `program` (`program_id`),
  CONSTRAINT `enrollment_ibfk_3` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` VALUES (1,1,'Y','2024-04-18'),(1,2,'Y','2024-04-18'),(1,3,'Y','2024-04-18'),(1,4,'Y','2024-04-18'),(1,5,'Y','2024-04-18'),(1,7,'Y','2024-04-18'),(1,8,'Y','2024-04-18'),(1,11,'Y','2024-04-18'),(1,12,'Y','2024-04-18'),(2,1,'Y','2024-02-12'),(2,3,'Y','2024-02-12'),(2,5,'Y','2024-02-12'),(2,7,'Y','2024-02-12'),(2,8,'N','2024-02-12'),(2,9,'Y','2024-02-12'),(2,13,'N','2024-02-12'),(2,11,'N','2024-02-12'),(3,1,'Y','2023-09-08'),(3,2,'Y','2023-09-08'),(3,3,'Y','2023-09-08'),(3,4,'Y','2023-09-08'),(3,5,'Y','2023-09-08'),(3,6,'Y','2023-09-08'),(4,7,'Y','2023-12-18'),(4,8,'Y','2023-12-18'),(4,9,'Y','2023-12-18'),(4,10,'Y','2023-12-18'),(4,11,'Y','2023-12-18'),(4,12,'Y','2023-12-18'),(4,13,'Y','2023-12-18'),(6,1,'Y','2024-01-30'),(6,5,'Y','2024-01-30'),(6,8,'Y','2024-01-30'),(6,13,'N','2024-01-30'),(7,1,'Y','2023-10-20'),(7,2,'Y','2023-10-20'),(7,3,'Y','2023-10-20'),(8,3,'Y','2023-10-20'),(8,2,'Y','2023-10-20'),(8,1,'Y','2023-10-20');
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `program_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `feedback` varchar(100) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `program_id` (`program_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `program` (`program_id`),
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,1,1,'The program was very interactive and the cxo\'s where very cool people'),(2,1,2,'Very good session'),(3,1,3,'Program was very energetic'),(4,1,4,'Good program'),(6,1,5,'Wasnt very good'),(7,1,7,'Very good to meet cxo\'s'),(8,1,8,'Good People'),(9,2,1,'Very good concert. Sound systems were very awsome'),(10,2,3,'Best concert i have attended'),(11,2,5,'Best concert i have attended in a long time'),(12,2,7,'Coldplay rocks'),(13,2,9,'Not very good concert'),(14,3,1,'Good sadya'),(15,3,2,'Best onam ever'),(16,3,3,'Very enthusiastic members and a very good day'),(17,3,4,'Good experience of malayali culture'),(18,3,5,'Enjoyed the program very well'),(19,3,6,'The vibes and the food were great'),(20,4,7,'Secret santa was jokes'),(21,4,8,'Good celebration program'),(22,4,9,'Best way to celebrate christmas'),(23,4,10,'Bad program. Couldnt enjoy it very much'),(24,4,11,'Bad program'),(25,4,12,'Good program, also got a good gift from secret santa'),(26,4,13,'Temprature control was not good. rest all was excellent'),(27,6,1,'Jordan was excellent'),(28,6,5,'Good class and excellent demonstrations'),(29,6,8,'Very good program'),(30,7,1,'Very good session on ML and AI'),(31,7,2,'Trainer was very interactive and cheerful'),(32,7,3,'Very informative session on new technology. Will help future career a lot'),(33,8,1,'Very good session on web3'),(34,8,2,'Trainer was very interactive and cheerful'),(35,8,3,'Very informative session on new technology. Will help future career a lot'),(43,6,6,'Good program'),(44,10,1,'Good workshop'),(45,11,1,'Good competition'),(46,12,1,'Good program. Great session');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `program_id` int NOT NULL AUTO_INCREMENT,
  `program_name` varchar(40) NOT NULL,
  `program_type` varchar(20) NOT NULL,
  `program_date` date NOT NULL,
  `host_id` int DEFAULT NULL,
  `trainer_id` int DEFAULT NULL,
  PRIMARY KEY (`program_id`),
  KEY `program_type` (`program_type`),
  KEY `trainer_id` (`trainer_id`),
  KEY `host_id` (`host_id`),
  CONSTRAINT `program_ibfk_3` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`),
  CONSTRAINT `program_ibfk_4` FOREIGN KEY (`host_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'Meet with CXO\'s','Leader Connect','2024-04-20',1,NULL),(2,'Coldplay Concert','Entertainment','2024-02-21',3,NULL),(3,'Onam Celebration','Cultural','2023-09-10',2,NULL),(4,'Christmas Celebration','Cultural','2023-12-20',6,NULL),(6,'Maintaining Professional Etiquette','Informational','2024-01-30',8,1),(7,'ML and AI training','Training','2023-10-30',9,2),(8,'WEB 3 Training','Training','2023-11-10',10,3),(9,'Sports Day','Sports','2024-05-01',11,NULL),(10,'Robotics workshop','Informational','2024-04-28',13,7),(11,'Volleyball competition','Sports','2024-05-02',12,8),(12,'Tech fundamentals','Informational','2024-05-03',1,10);
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `trainer_firstname` varchar(20) NOT NULL,
  `trainer_lastname` varchar(20) NOT NULL,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`trainer_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `trainer_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (1,'Jordan','Ben',12),(2,'Sinu','Mathew',NULL),(3,'Darshan','Sajeev',NULL),(7,'Uvaiz','Sha',NULL),(8,'Jobin','Joseph',NULL),(9,'Fardeen','Gandhi',NULL),(10,'Harikrishnan','V',NULL);
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:10:32
