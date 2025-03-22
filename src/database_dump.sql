-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: student_management
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'John Doe','johndoe@example.com','1234567890','admin123'),(2,'Alice Smith','alice.smith@example.com','0987654321','securepass'),(5,'Yashindi','yashindi@1234.com','0752318810','yashi666'),(6,'Raduni','raduni@example.com','0713179186','radu1234'),(7,'John Admin','john.admin@example.com','555-123456','securepassword123'),(18,'Bob Johnson','bob.johnson@example.com','345-678-9012','bob123'),(19,'Charlie Brown','charlie.brown@example.com','456-789-0123','charlie123'),(20,'David White','david.white@example.com','567-890-1234','david123'),(21,'Eve Black','eve.black@example.com','678-901-2345','eve123'),(22,'Frank Green','frank.green@example.com','789-012-3456','frank123'),(23,'Grace Lee','grace.lee@example.com','890-123-4567','grace123'),(24,'Hannah Miller','hannah.miller@example.com','901-234-5678','hannah123'),(25,'Ian Davis','ian.davis@example.com','012-345-6789','ian123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL,
  `department` varchar(100) NOT NULL,
  `prerequisites` varchar(255) DEFAULT NULL,
  `max_enrollment` int NOT NULL,
  `course_title` varchar(255) NOT NULL,
  `credits` int NOT NULL,
  `details` text,
  `credit_hours` int NOT NULL DEFAULT '3',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Java Programming','Computer Science',NULL,50,'',0,NULL,3),(2,'Database Systems','Computer Science','Java Programming',40,'',0,NULL,3),(3,'Data Structures','Computer Science','Java Programming',45,'',0,NULL,3),(4,'Calculus','Mathematics',NULL,60,'',0,NULL,3),(5,'Introduction to Programming','Computer Science',NULL,50,'',0,NULL,3),(6,'Database Management Systems','Computer Science','Introduction to Programming',40,'',0,NULL,3),(7,'Data Structures and Algorithms','Computer Science','Introduction to Programming',35,'',0,NULL,3),(8,'Operating Systems','Computer Science','Data Structures and Algorithms',40,'',0,NULL,3),(9,'Software Engineering','Computer Science','Database Management Systems',30,'',0,NULL,3),(10,'Computer Networks','Information Technology','Operating Systems',45,'',0,NULL,3),(11,'Web Development','Information Technology','Introduction to Programming',50,'',0,NULL,3),(12,'Cyber Security','Information Technology','Computer Networks',40,'',0,NULL,3),(13,'Machine Learning','Computer Science','Data Structures and Algorithms',30,'',0,NULL,3),(14,'Cloud Computing','Information Technology','Computer Networks',35,'',0,NULL,3),(15,'Introduction to Java','Computer Science',NULL,50,'',0,NULL,3),(16,'Database Management Systems','Information Technology','Introduction to SQL',40,'',0,NULL,3),(17,'Software Engineering','Computer Science','Introduction to Java',60,'',0,NULL,3),(18,'Operating Systems','Computer Science','Computer Architecture',45,'',0,NULL,3),(19,'Web Development','Information Technology','HTML & CSS',55,'',0,NULL,3),(20,'Data Structures & Algorithms','Computer Science','Introduction to Java',50,'',0,NULL,3),(21,'Artificial Intelligence','Computer Science','Linear Algebra',35,'',0,NULL,3),(22,'Java Basics','Computer Science',NULL,50,'',0,NULL,3),(23,'Database Management','IT','SQL Basics',40,'',0,NULL,3),(101,'Java Programming','Computer Science','None',50,'Introduction to Java',3,'This course covers the basics of Java programming, OOP, and data structures.',3),(102,'Database Management','Information Technology','None',40,'SQL & MySQL Basics',4,'Learn how to create, manage, and optimize databases using SQL and MySQL.',3),(103,'Web Development','Software Engineering','Basic Programming',45,'Frontend & Backend Web Development',3,'Covers HTML, CSS, JavaScript, and backend frameworks for web development.',3);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `enrollment_id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `semester` varchar(20) NOT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `enrollment_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`enrollment_id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `enrollments_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE,
  CONSTRAINT `enrollments_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `faculty_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `department` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  PRIMARY KEY (`faculty_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Dr. Sarah Johnson','Computer Science','sarah.johnson@example.com','9876543210'),(2,'Prof. Michael Brown','Mathematics','michael.brown@example.com','8765432109');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `program_of_study` varchar(100) NOT NULL,
  `year_of_study` int NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  `program` varchar(100) NOT NULL,
  `year` int NOT NULL,
  `contact_info` varchar(255) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Yashindi Jayawardhana','2001-05-10','Female','Software Engineering',2,'yashindi@example.com','0771234567','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','BSc Software Engineering',2025,'Colombo, Sri Lanka'),(2,'Dineth Fernando','2002-03-25','Male','Data Science',1,'dineth@example.com','0774567890','5efc2b017da4f7736d192a74dde5891369e0685d4d38f2a455b6fcdab282df9c','BSc Data Science',2026,'Kandy, Sri Lanka'),(3,'Nethmi Perera','2001-07-10','Female','Cyber Security',2,'nethmi@example.com','0776543210','0ecf0285c52337d198723ffcb06c19313d1790be40acb6c6887e1810e5ada879','BSc Cyber Security',2025,'Kurunegala, Sri Lanka'),(4,'Kasun Silva','2003-01-20','Male','Computer Science',1,'kasun@example.com','0773456789','b59c7f2550fb4ae999a451bf90575e8a7b42d287c08bdef0efa2009e948b90fe','BSc Computer Science',2027,'Matara, Sri Lanka'),(5,'Sachini Wickramasinghe','2000-12-30','Female','Software Engineering',3,'sachini@example.com','0761122334','37333d4320480275ee682bb87d4d989dc606cda5517311f6d0a7a955d9854139','BSc Software Engineering',2024,'Negombo, Sri Lanka'),(6,'Ravindu Jayasooriya','2002-06-15','Male','Information Systems',2,'ravindu@example.com','0755566778','ef0616155c802a1e3d97ff9f62020030b48a4fd67f4abf1a079afb1a4b025e7a','BSc Information Systems',2025,'Badulla, Sri Lanka'),(7,'Amaya Karunaratne','2001-04-18','Female','Artificial Intelligence',3,'amaya@example.com','0749988776','6a2d14d0b84edd88556cf08f2591013053531ba563cd3e11965c53cafa4d6634','BSc Artificial Intelligence',2024,'Kegalle, Sri Lanka'),(8,'Supun Ranasinghe','2003-09-08','Male','Software Engineering',1,'supun@example.com','0781122334','103bad80ffabf4c9e2ae86fdc969c658c16ebf595e49ec1e3a450c20c097d827','BSc Software Engineering',2026,'Puttalam, Sri Lanka'),(9,'Tharushi De Silva','2002-11-11','Female','Business Analytics',2,'tharushi@example.com','0778877665','aa505e9cf378b62d672caf2cdef6503aa4c62e8889b263dfc4e5ba717ce6ce62','BSc Business Analytics',2025,'Gampaha, Sri Lanka'),(10,'Dilshan Senanayake','2000-05-05','Male','Cyber Security',3,'dilshan@example.com','0765544332','a80bcfa21f7ea70f12dd7ca72d0ae2af335a0c3e8b8b8c1c0a765cf30f336df6','BSc Cyber Security',2024,'Colombo, Sri Lanka'),(11,'Lakmini Hettiarachchi','2001-08-22','Female','Data Science',2,'lakmini@example.com','0756677889','505211fc12032afb97e5a32e122a8d63d0dc3a742968e2704136c287910f130d','BSc Data Science',2025,'Hambantota, Sri Lanka'),(12,'Sahan Madushanka','2003-02-14','Male','IT Management',1,'sahan@example.com','0783344556','29837570878c628501edf8c414ffedf21bba0b34c60af47dd7ab1ecf0f7b9b4b','BSc IT Management',2026,'Ratnapura, Sri Lanka'),(13,'Chathurika Jayawardena','2002-10-03','Female','Software Engineering',2,'chathurika@example.com','0772233445','2a510694c23c361cf87361aa3a5bc0ce95dbf0cb76741d11da4697b63c8baad5','BSc Software Engineering',2025,'Anuradhapura, Sri Lanka'),(14,'Vihanga Peris','2001-06-17','Male','Computer Science',3,'vihanga@example.com','0744455667','532c2ffe9d8e164063b28320b08c055e941a948d981b68d3a4f1d6ead9b40808','BSc Computer Science',2024,'Jaffna, Sri Lanka');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-22 19:16:12
