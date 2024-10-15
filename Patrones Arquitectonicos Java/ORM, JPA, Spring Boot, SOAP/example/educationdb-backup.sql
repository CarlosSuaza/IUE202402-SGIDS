CREATE DATABASE  IF NOT EXISTS `educationdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `educationdb`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: educationdb
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` varchar(36) NOT NULL DEFAULT (uuid()),
  `titulo` varchar(255) NOT NULL,
  `descripcion` mediumtext NOT NULL,
  `nivel` int NOT NULL,
  `profesorId` varchar(15) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `profesorId` (`profesorId`),
  CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`profesorId`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES ('ba847a1b-7a94-11ef-a488-088fc3750094','Introducción a la Programación','Curso básico para aprender los fundamentos de la programación.',1,'1',1),('ba847db9-7a94-11ef-a488-088fc3750094','Desarrollo Web Avanzado','Curso avanzado de desarrollo web con tecnologías modernas.',3,'2',1),('ba847ee3-7a94-11ef-a488-088fc3750094','Bases de Datos','Conceptos y manejo de bases de datos relacionales y no relacionales.',2,'3',1),('ba847f99-7a94-11ef-a488-088fc3750094','Inteligencia Artificial','Introducción a los conceptos y técnicas de la inteligencia artificial.',3,'4',1),('ba84804b-7a94-11ef-a488-088fc3750094','Algoritmos y Estructuras de Datos','Estudio de algoritmos y estructuras de datos fundamentales.',2,'5',1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id` varchar(15) NOT NULL,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES ('1','Juan','Pérez','juan@email.com','5551234567',1),('10','Sofía','Vargas','sofia@email.com','5556789012',1),('2','María','Gómez','maria@email.com','5559876543',1),('3','Carlos','López','carlos@email.com','5552345678',1),('4','Ana','Martínez','ana@email.com','5557654321',1),('5','Luis','Ramírez','luis@email.com','5553456789',1),('6','Carmen','Torres','carmen@email.com','5558765432',1),('7','José','Hernández','jose@email.com','5554567890',1),('8','Lucía','Jiménez','lucia@email.com','5559871234',1),('9','Diego','Castillo','diego@email.com','5555432109',1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_curso`
--

DROP TABLE IF EXISTS `estudiante_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante_curso` (
  `estudianteId` varchar(15) NOT NULL,
  `cursoId` varchar(36) NOT NULL,
  PRIMARY KEY (`estudianteId`,`cursoId`),
  KEY `cursoId` (`cursoId`),
  CONSTRAINT `estudiante_curso_ibfk_1` FOREIGN KEY (`estudianteId`) REFERENCES `estudiante` (`id`),
  CONSTRAINT `estudiante_curso_ibfk_2` FOREIGN KEY (`cursoId`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_curso`
--

LOCK TABLES `estudiante_curso` WRITE;
/*!40000 ALTER TABLE `estudiante_curso` DISABLE KEYS */;
INSERT INTO `estudiante_curso` VALUES ('1','ba847a1b-7a94-11ef-a488-088fc3750094'),('2','ba847a1b-7a94-11ef-a488-088fc3750094'),('3','ba847a1b-7a94-11ef-a488-088fc3750094'),('4','ba847a1b-7a94-11ef-a488-088fc3750094'),('5','ba847a1b-7a94-11ef-a488-088fc3750094'),('1','ba847db9-7a94-11ef-a488-088fc3750094'),('6','ba847db9-7a94-11ef-a488-088fc3750094'),('7','ba847db9-7a94-11ef-a488-088fc3750094'),('8','ba847db9-7a94-11ef-a488-088fc3750094'),('10','ba847ee3-7a94-11ef-a488-088fc3750094'),('2','ba847ee3-7a94-11ef-a488-088fc3750094'),('4','ba847ee3-7a94-11ef-a488-088fc3750094'),('9','ba847ee3-7a94-11ef-a488-088fc3750094'),('3','ba847f99-7a94-11ef-a488-088fc3750094'),('5','ba847f99-7a94-11ef-a488-088fc3750094'),('6','ba847f99-7a94-11ef-a488-088fc3750094'),('10','ba84804b-7a94-11ef-a488-088fc3750094'),('7','ba84804b-7a94-11ef-a488-088fc3750094'),('8','ba84804b-7a94-11ef-a488-088fc3750094'),('9','ba84804b-7a94-11ef-a488-088fc3750094');
/*!40000 ALTER TABLE `estudiante_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id` varchar(15) NOT NULL,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES ('1','Raúl','González','raul@email.com','5553211234',1),('2','Patricia','Mendoza','patricia@email.com','5556549871',1),('3','Alberto','Santos','alberto@email.com','5557894561',1),('4','Marta','López','marta@email.com','5551237890',1),('5','David','Pérez','david@email.com','5554561230',1);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'educationdb'
--

--
-- Dumping routines for database 'educationdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-14 20:01:51
