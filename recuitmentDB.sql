-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.11.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for recuitmentdb
CREATE DATABASE IF NOT EXISTS `recuitmentdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `recuitmentdb`;

-- Dumping structure for table recuitmentdb.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `id` int(11) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table recuitmentdb.candidate: ~3 rows (approximately)
INSERT INTO `candidate` (`id`, `last_name`, `middle_name`, `first_name`, `dob`, `email`, `address`, `phone`) VALUES
	(1, 'Nhan', 'Thi Thanh', 'Vu', '2004-10-16', 'nhan@gmail.com', '123, 2 Ba Trung', '111-111-111'),
	(2, 'Vu', 'Thanh', 'Tran', '2000-09-16', 'vu@gmail.com', '111, Cong Hoa', '222-222-222'),
	(3, 'Nhanh', 'Tranh', 'Qua', '2003-02-11', 'nanh@gmail.com', '333, Hoang Van Thu', '333-333-333');

-- Dumping structure for table recuitmentdb.candidateskill
CREATE TABLE IF NOT EXISTS `candidateskill` (
  `candidate_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL CHECK (`level` between 1 and 5),
  PRIMARY KEY (`candidate_id`,`skill_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `candidateskill_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `candidateskill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table recuitmentdb.candidateskill: ~8 rows (approximately)
INSERT INTO `candidateskill` (`candidate_id`, `skill_id`, `level`) VALUES
	(1, 2, 3),
	(1, 3, 4),
	(1, 5, 4),
	(2, 1, 5),
	(2, 2, 3),
	(2, 5, 4),
	(3, 4, 4),
	(3, 6, 4);

-- Dumping structure for table recuitmentdb.job
CREATE TABLE IF NOT EXISTS `job` (
  `id` int(11) NOT NULL,
  `description` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table recuitmentdb.job: ~6 rows (approximately)
INSERT INTO `job` (`id`, `description`) VALUES
	(1, 'SE'),
	(2, 'IT'),
	(3, 'BA'),
	(4, 'Tester'),
	(5, 'a'),
	(6, 'b');

-- Dumping structure for table recuitmentdb.jobskill
CREATE TABLE IF NOT EXISTS `jobskill` (
  `job_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `required_level` int(11) DEFAULT NULL CHECK (`required_level` between 1 and 5),
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `jobskill_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `jobskill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table recuitmentdb.jobskill: ~8 rows (approximately)
INSERT INTO `jobskill` (`job_id`, `skill_id`, `required_level`) VALUES
	(1, 2, 3),
	(1, 5, 4),
	(2, 4, 3),
	(2, 6, 4),
	(3, 1, 4),
	(3, 2, 5),
	(4, 3, 3),
	(5, 6, 3);

-- Dumping structure for table recuitmentdb.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `id` int(11) NOT NULL,
  `skill_name` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `field` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table recuitmentdb.skill: ~7 rows (approximately)
INSERT INTO `skill` (`id`, `skill_name`, `description`, `field`) VALUES
	(1, 'English', 'speak well', 'none'),
	(2, 'Business Analys', 'graduate IF, SE with GPA >= 3.5', 'none'),
	(3, 'JUnit, CppUnit', 'for test job', 'none'),
	(4, 'knowledge about server config', 'for IT', 'none'),
	(5, 'java language', 'for SE', 'none'),
	(6, 'diagnose and repair computers', 'for IT more than 2 year exp', NULL),
	(7, 'a', 'a', 'a');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
