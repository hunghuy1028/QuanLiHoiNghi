CREATE DATABASE  IF NOT EXISTS `conference_manager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `conference_manager`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: conference_manager
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `idAccount` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `accountType` int NOT NULL DEFAULT '1' COMMENT '0: admin\\\\\\\\n1: user',
  `isActive` int NOT NULL DEFAULT '1' COMMENT '1: True, 0: False',
  PRIMARY KEY (`idAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=1020 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1001,'Huy Hùng','hung124','87cfe89dd6e63c2ae0a206cecc4c3b64','hung124@gmail.com',1,1),(1004,'Lập','lap123','e10adc3949ba59abbe56e057f20f883e','lap123456@gmail.com',1,0),(1007,'Huy','qhuy123','7edccc29e6a246382634d3bd2cec4362','qhuy123@gmail.com',1,1),(1008,'Admin','admin','0192023a7bbd73250516f069df18b500','admin@gmail.com',0,1),(1009,'Huân','huan123','e811d00acd2a355eb8c66e8204f10860','huan123@gmail.com',1,1),(1010,'Lộc','loc123','3a37bf4ff5938162c0d05dc6684956dd','loc123@gmail.com',1,1),(1011,'Khoa','khoa123','e15c0fbe60ae42e8fcc8f46195c4ce9b','khoa123@gmail.com',1,1),(1012,'Huỳnh','huynh123','43c94d0dfae84c42c4147461fda1b8fa','huynh123@gmail.com',1,1),(1015,'Minh','minh123','ddc83bf88c241349a4211172137545e0','minh123@gmail.com',1,1),(1016,'Long','long123','36ed58c5c14dc2f58eef099585d2a939','long123@gmail.com',1,1),(1019,'Huy Hùng','hung1028','70c82dab02403c68800a04fc2aef21fd','hung1028@gmail.com',1,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conference` (
  `idHoiNghi` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(500) NOT NULL,
  `MoTaNgan` varchar(1000) NOT NULL,
  `MoTaChiTiet` varchar(4000) NOT NULL,
  `HinhAnh` varchar(500) NOT NULL,
  `ThoiGian` datetime NOT NULL,
  `DiaDiem` int NOT NULL,
  `NgThamDu` int NOT NULL,
  PRIMARY KEY (`idHoiNghi`),
  KEY `fk_conference_location_idx` (`DiaDiem`),
  CONSTRAINT `fk_conference_location` FOREIGN KEY (`DiaDiem`) REFERENCES `location` (`idDiaDiem`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conference`
--

LOCK TABLES `conference` WRITE;
/*!40000 ALTER TABLE `conference` DISABLE KEYS */;
INSERT INTO `conference` VALUES (1,'Ngày hội khởi nghiệp 2020','Thúc đẩy tinh thần khởi nghiệp học sinh, sinh viên trên toàn quốc.','Mục tiêu của Ngày hội Khởi nghiệp của Học sinh, sinh viên nhằm thúc đẩy tinh thần sáng tạo, khởi nghiệp của tất cả học sinh, sinh viên, trên toàn quốc. SV-STARTUP cũng nhằm tạo một sân chơi lành mạnh, bổ ích thiết thực, hiệu quả đối với tất cả các học sinh, sinh viên trong cả nước và tạo cơ hội để để cơ sở đào tạo giao lưu, học tập kinh nghiệm triển khai các hoạt động hỗ trợ sinh viên khởi nghiệp, giúp các dự án khởi nghiệp của học sinh, sinh viên kết nối với các doanh nghiệp, các nhà đầu tư.','src/main/resources/Images/conference-1.jpg','2020-07-26 07:30:00',100,230),(2,'Hội nghị khoa học - HCMUS','Trình bày các nghiên cứu khoa học của trường','Định kỳ hai năm một lần, tổ chức Hội nghị Khoa học toàn trường cho tất cả các ngành khoa học, các lĩnh vực nghiên cứu, đào tạo của trường. Đây là diễn đàn để các nhà khoa học của trường  và các đơn vị có quan hệ hợp tác trình bày kết quả nghiên cứu khoa học. Ngoài ra, Hội nghị cũng là dịp để giao lưu, trao đổi tìm ý tưởng, giải pháp cho các vấn đề khoa học và công nghệ, đẩy mạnh hợp tác, hình thành các nghiên cứu liên ngành, liên lĩnh vực trong và ngoài trường','src/main/resources/Images/conference-2.PNG','2020-11-28 07:00:00',101,155),(3,'VIETNAM CEO CONGRESS 2020','Chương trình hỗ trợ doanh nghiệp hậu Covid',' Sau đại dịch thế giới đã đổi khác, nhu cầu xã hội có nhiều thay đổi và đang được hình thành lại. Chuổi cung ứng toàn cầu đang được tái cấu trúc, các dòng chảy thương mại và đầu tư đảo chiều. Tất cả các yêu tố đó đòi hỏi các doanh nghiệp phải nhìn nhận đánh giá chính xác xu hướng thị trường, tốc độ hồi phục, nhu cầu xã hội cũng như xu thế hội nhập toàn cầu trong giai đoạn hậu Covid','src/main/resources/Images/conference-3.PNG','2020-08-08 10:00:00',102,2),(4,'Manager As Coach',' Tạo ra nhiều sự thay đổi, vượt qua những thử thách và vươn đến những thành tựu cao hơn','N.E.W.S® Manager As Coach (MAC)TM là giải pháp đặc biệt, được cấu trúc hợp lý, thực tiễn, có tác động cao, được thiết kế riêng theo từng yêu cầu phát triển lãnh đạo đặc thù của doanh nghiệp. Chương trình huấn luyện 2 ngày giúp nhà quản lý thành công trong việc tạo động lực thúc đẩy, định hướng, dẫn dắt đội ngũ, và đạt thành tựu cao hơn trong phát triển con người và tổ chức vững mạnh.','src/main/resources/Images/conference-4.PNG','2020-08-06 08:30:00',103,150),(22,'Vietnam Educamp 2020','Giáo dục bền vững trong kỷ nguyên số','Giáo dục Việt Nam đang đứng trước nhiều thách thức trên nhiều khía cạnh như yêu cầu về chất lượng từ phía phụ huynh và người học; yêu cầu đáp ứng số lượng của nền dân số trẻ; hay yêu cầu đảm bảo bình đẳng trong cơ hội tiếp cận giáo dục như là một phần của chính sách anh sinh – xã hội…. Đứng trước bối cảnh đó, tất cả các bên liên quan của nền giáo dục, từ nhà nghiên cứu, đến nhà quản lý, giáo viên, phụ huynh hay học sinh… đều đã và đang không ngừng vận động với kỳ vọng tạo ra một nền giáo dục hiệu quả hơn, tốt đẹp hơn.\n\n  Nhằm kiến tạo một cộng đồng chia sẻ học thuật và kinh nghiệm thực tiễn của tất cả các bên liên quan kể trên, cùng chung tay giải quyết từng vấn đề vĩ mô hoặc vi mô của giáo dục hiện nay, “Diễn đàn Giáo dục Việt Nam Educamp 2019: Những viễn cảnh giáo dục mới” đã được tổ chức thành công bởi Trung tâm Phát triển bền vững Giáo dục Phổ thông quốc gia, thuộc Viện Khoa học Giáo dục Việt Nam và CLB Giáo dục mới.\n\n  Tiếp nối sự thành công của diễn đàn 2019, chúng tôi vô cùng hân hoan chào đón diễn đàn Educamp 2020 với chủ đề “Giáo dục bền vững trong kỷ nguyên số”, với sự phối hợp tổ chức của Trung tâm Phát triển bền vững Giáo dục Phổ thông Quốc gia, CLB Giáo dục mới và Trung tâm Nghiên cứu Phát triển Giáo dục EdLab Asia.','src/main/resources/Images/conference-5.jpg','2020-08-20 08:30:00',109,50),(23,'OKR Management Workshop ','Learn - Breakfast - Networking with Special Guest ','In this course, you will get to know the basics of the respective agile method. You will learn to develop your products and services much faster and more efficiently. Furthermore, you will get insights on self-organization and process improvement.\n\n   In our one-day training on Objectives and Key Results (OKRs), we present an approach with which strategic goals can be implemented quickly and measurably and employees can actively participate in shaping the company.\n\n   Not only Google, Zalando and Trivago already work successfully with OKRs. More and more companies are experimenting with the introduction of Objectives and Key Results. This has far-reaching effects not only on existing processes but above all on the culture and should not be taken lightly.\n\n   In order to achieve strategic goals, it is necessary to make them measurable. Therefore, in the one-day training, we will deal with how intangible things can also be made measurable.\n\n   Just because we set goals this does not mean that we will achieve them automatically. In the training, we will thus also take a look at motivational psychology and neuroscience.\n\n   We will also be happy to share our experience in introducing OKRs in companies with you and give you valuable tips that you should bear in mind when introducing OKRs yourself.','src/main/resources/Images/conference-6.jpg','2020-09-01 09:00:00',112,25),(26,'VIETNAM INT\'L CAFE SHOW 2020','The Vietnam Int’l Cafe Show 2020 will take place from Sep. 03rd ~ 05th, 2020','The Vietnam Int’l Cafe Show 2020 will take place from Sep. 03rd ~ 05th, 2020 at Saigon Exhibition and Convention Center (SECC), HCMC, Vietnam. Renowned as a leading exhibition specialized in café and bakery, the show is expected to attract over 250 exhibitors with an aim to form new business opportunities for both local firms and overseas companies.\n\nThe show is co-hosted with signature events including Coffee Talk, Sweet Class and Coffee Training Station that revolving around booming food and beverage trends in Vietnam. We are the only organizer allowed organize Vietnam National Barista & Latte Art Championship (VNBC & VNLAC) in Vietnam - The exclusive national competition, sanctioned by World Coffee Events.','src/main/resources/Images/conference-7.jpg','2020-09-03 19:00:00',116,50);
/*!40000 ALTER TABLE `conference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `idDiaDiem` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(200) NOT NULL,
  `DiaChi` varchar(500) NOT NULL,
  `SucChua` int NOT NULL,
  PRIMARY KEY (`idDiaDiem`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (100,'SVĐ Tôn Đức Thắng','D6, Phường Tân Phong, Tân Hưng, Q7, HCM',500),(101,'Trường ĐH Khoa Học Tự Nhiên','227 Nguyễn Văn Cừ, P4, Q5, TPHCM',200),(102,'Capella Park View','Số 3 Đặng Văn Sâm, P9, Phú Nhuận, TPHCM',300),(103,'Sai Gon Prince Hotel','63 Nguyễn Huệ, Quận 1, thành phố Hồ Chí Minh',150),(109,'Trường PT Lê Hồng Phong','235 Đ. Nguyễn Văn Cừ, Phường 4, Quận 5, Thành phố Hồ Chí Minh',100),(112,'Hard Rock Cafe','39 Le Duan, Quận 1, Thành Phố Hồ Chí Minh',50),(116,'Saigon Exhibition and Convention Center (SECC)','799 Nguyen Van Linh Street, Tan Phu Ward, District 7, Ho Chi Minh City, Quận 7, Thành Phố Hồ Chí Minh',60);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_hoinghi`
--

DROP TABLE IF EXISTS `user_hoinghi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_hoinghi` (
  `idHoiNghi` int NOT NULL,
  `idUser` int NOT NULL,
  `status` int NOT NULL DEFAULT '0' COMMENT '0:false, 1: true',
  PRIMARY KEY (`idHoiNghi`,`idUser`),
  KEY `fk_userhn_account_idx` (`idUser`),
  CONSTRAINT `fk_userhn_account` FOREIGN KEY (`idUser`) REFERENCES `account` (`idAccount`),
  CONSTRAINT `fk_userhn_conference` FOREIGN KEY (`idHoiNghi`) REFERENCES `conference` (`idHoiNghi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_hoinghi`
--

LOCK TABLES `user_hoinghi` WRITE;
/*!40000 ALTER TABLE `user_hoinghi` DISABLE KEYS */;
INSERT INTO `user_hoinghi` VALUES (1,1001,1),(1,1004,1),(1,1007,1),(1,1008,1),(1,1009,1),(1,1010,1),(2,1004,1),(2,1007,1),(2,1011,0),(2,1012,1),(2,1015,1),(2,1016,1),(3,1007,0),(3,1008,0),(4,1001,0),(4,1008,1),(22,1004,0),(23,1001,1),(23,1004,1);
/*!40000 ALTER TABLE `user_hoinghi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-31 18:17:02
