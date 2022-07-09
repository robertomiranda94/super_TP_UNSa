-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: super
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'bebidas'),(2,'lacteos'),(3,'carnes'),(4,'verduleria'),(5,'perfumeria');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(40) NOT NULL,
  `STOCK` int(15) NOT NULL,
  `FECHA_VENCIMIENTO` varchar(100) NOT NULL,
  `ID_CATEGORIA` int(4) NOT NULL,
  `PRECIO` double NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_categorias` (`ID_CATEGORIA`),
  CONSTRAINT `fk_categorias` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'gaseosa',100,'2024-06-01',1,100),(2,'agua',100,'2024-06-01',1,50),(3,'alcohol',100,'2024-06-01',1,80),(4,'leche',100,'2024-06-01',2,150),(5,'yogurt',100,'2024-06-01',2,150),(6,'queso',100,'2024-06-01',2,170),(7,'manteca',100,'2024-06-01',2,100),(8,'dulce de leche',100,'2024-06-01',2,150),(9,'carne vacuna',100,'2024-06-01',3,300),(10,'carne de cerdo',100,'2024-06-01',3,240),(11,'pescado',100,'2024-06-01',3,200),(12,'mariscos',100,'2024-06-01',3,100),(13,'tomate',100,'2024-06-01',4,50),(14,'cebolla',100,'2024-06-01',4,60),(15,'banana',100,'2024-06-01',4,80),(16,'mandarina',100,'2024-06-01',4,120),(17,'dove men',100,'2024-06-01',5,150),(18,'rexona',100,'2024-06-01',5,160),(19,'kevin',100,'2024-06-01',5,200),(20,'nivea',100,'2024-06-01',5,150);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodeusuario`
--

DROP TABLE IF EXISTS `tipodeusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodeusuario` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `NOMBRETIPO` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(80) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodeusuario`
--

LOCK TABLES `tipodeusuario` WRITE;
/*!40000 ALTER TABLE `tipodeusuario` DISABLE KEYS */;
INSERT INTO `tipodeusuario` VALUES (1,'cliente','usuario externo'),(2,'admin','usuario interno');
/*!40000 ALTER TABLE `tipodeusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(40) NOT NULL,
  `APELLIDO` varchar(40) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `CONTRASENIA` varchar(15) NOT NULL,
  `TIENETARJETA` tinyint(1) NOT NULL,
  `ID_TIPODEUSUARIO` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_tipousuario` (`ID_TIPODEUSUARIO`),
  CONSTRAINT `fk_tipousuario` FOREIGN KEY (`ID_TIPODEUSUARIO`) REFERENCES `tipodeusuario` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (17,'admin','admin','admin@admin.com','admin',0,2),(18,'lucas','arias','lucas','1234',0,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `FECHA` varchar(50) NOT NULL,
  `DETALLE` varchar(300) NOT NULL,
  `TOTAL` double NOT NULL,
  `ID_USUARIO` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_usuario` (`ID_USUARIO`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'super'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-09 12:31:36
