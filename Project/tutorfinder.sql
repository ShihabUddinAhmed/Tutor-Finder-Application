-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 07:05 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tutorfinder`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `ACCOUNT_ID` int(10) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `ACCOUNT_TYPE` varchar(13) NOT NULL,
  `STUDENT_ID` int(8) DEFAULT NULL,
  `FREELANCER_ID` int(8) DEFAULT NULL,
  `INSTITUTION_ID` int(8) DEFAULT NULL,
  `PROFESSIONAL_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ACCOUNT_TYPE`, `STUDENT_ID`, `FREELANCER_ID`, `INSTITUTION_ID`, `PROFESSIONAL_ID`) VALUES
(10000001, 'fahimfaiyaz286@gmail.com', 'Fahim286', 'student', 3, NULL, NULL, NULL),
(10000002, 'abujarrahman58@yahoo.com', 'ABUjarRAHMAN', 'student', 8, NULL, NULL, NULL),
(10000003, 'amatunnoor5@gmail.com', 'AmatunTanha', 'student', 14, NULL, NULL, NULL),
(10000004, 'erfan@gmail.com', 'ErFanAhmed', 'student', 10, NULL, NULL, NULL),
(10000005, 'shihabahmed8957@gmail.com', 'ShihabAhmed', 'student', 1, NULL, NULL, NULL),
(10000006, 'anjumramisa@gmail.com', 'RAmisaanjUM', 'student', 2, NULL, NULL, NULL),
(10000007, 'naimrahman@gmail.com', 'naimURrahman', 'student', 4, NULL, NULL, NULL),
(10000008, 'karim98@gmail.com', 'Karimhasan', 'student', 5, NULL, NULL, NULL),
(10000009, 'hasanmahmud@yahoo.com', 'hasanMAHMUD', 'student', 6, NULL, NULL, NULL),
(10000010, 'rahimuahmed7@hotmail.com', 'RAHIMuddin', 'student', 7, NULL, NULL, NULL),
(10000011, 'jim1958@gmail.com', 'jimSAR', 'student', 9, NULL, NULL, NULL),
(10000012, 'imdadul@gmail.com', 'IMDADULhasan', 'student', 11, NULL, NULL, NULL),
(10000013, 'mariaoishi78@gmail.com', 'MAriaHakim', 'student', 12, NULL, NULL, NULL),
(10000014, 'kamaluddin45@gmail.com', 'KAMALUDDIN', 'student', 13, NULL, NULL, NULL),
(10000015, 'rokeyaakter12@gmail.com', 'RokeyarokeyA', 'student', 15, NULL, NULL, NULL),
(10000016, 'Azadhosen@outlook.com', 'azadHOSEN', 'freelancer', NULL, 5001, NULL, NULL),
(10000017, 'sarkarprince8@gmail.com', 'SARKARprince', 'freelancer', NULL, 5002, NULL, NULL),
(10000018, 'bhattacharjeealinda@gmail.com', 'AlindaBHAtta', 'freelancer', NULL, 5003, NULL, NULL),
(10000019, 'dassajib@outlook.com', 'SajibDas', 'freelancer', NULL, 5004, NULL, NULL),
(10000020, 'tanzimazahir02@gmail.com', 'Tanzimazahir98', 'freelancer', NULL, 5005, NULL, NULL),
(10000021, 'jamilahsan@yahoo.com', 'JaMALahsan', 'freelancer', NULL, 5006, NULL, NULL),
(10000022, 'fahimrahman54@gmail.com', 'FAhimRAhman', 'freelancer', NULL, 5007, NULL, NULL),
(10000023, 'henamojumdar@gmail.com', 'maJUMdar', 'freelancer', NULL, 5008, NULL, NULL),
(10000024, 'farihanusrat@yahoo.com', 'fariHA96', 'freelancer', NULL, 5009, NULL, NULL),
(10000025, 'fariyaislam@gmail.com', 'FARiya45', 'freelancer', NULL, 5010, NULL, NULL),
(10000026, 'surindarbarua@outlook.com', 'SURINDARbarua', 'freelancer', NULL, 5011, NULL, NULL),
(10000027, 'hossainmahmud5@gmail.com', 'MAHMUDhossain', 'freelancer', NULL, 5012, NULL, NULL),
(10000028, 'tamannarahman@gmail.com', 'Tamanna56', 'freelancer', NULL, 5013, NULL, NULL),
(10000029, 'shaylaakter56@gmail.com', 'SHAYlaAKTer', 'freelancer', NULL, 5014, NULL, NULL),
(10000030, 'ashikislam56@gmail.com', 'ASHIkislam', 'freelancer', NULL, 5015, NULL, NULL),
(10000031, 'joteeislam@yahoo.com', 'JOTEE56islam', 'freelancer', NULL, 5016, NULL, NULL),
(10000032, 'info@udvash.com', 'UDvash45', 'institution', NULL, NULL, 1880, NULL),
(10000033, 'querysymoom@gmail.com', 'simoomCoach', 'institution', NULL, NULL, 1881, NULL),
(10000034, 'infocac@gmail.com', 'careAcaCENTER', 'institution', NULL, NULL, 1882, NULL),
(10000035, 'monosheeinformation@gmail.com', 'MONOSSHEcoach', 'institution', NULL, NULL, 1883, NULL),
(10000036, 'infoiqracoach@yahoo.com', 'IQraCoach', 'institution', NULL, NULL, 1884, NULL),
(10000037, 'sikderarian@gmail.com', 'SIKderARIAN', 'professional', NULL, NULL, NULL, 3001),
(10000038, 'mumtahinna98@gmail.com', 'MUMtaHINA45', 'professional', NULL, NULL, NULL, 3002),
(10000039, 'jahidaaktertamu@gmail.com', 'jahidaAKTER', 'professional', NULL, NULL, NULL, 3003),
(10000040, 'fahimahmed65', 'fahimAHMED', 'professional', NULL, NULL, NULL, 3004);

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `ADDRESS_ID` int(8) NOT NULL,
  `CITY` varchar(20) NOT NULL,
  `STATE` varchar(20) NOT NULL,
  `COUNTRY` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`ADDRESS_ID`, `CITY`, `STATE`, `COUNTRY`) VALUES
(1001, 'BANASREE', 'DHAKA', 'BANGLADESH'),
(1002, 'MOTIJHEEL', 'DHAKA', 'BANGLADESH'),
(1003, 'RAMPURA', 'DHAKA', 'BANGLADESH'),
(1004, 'BADDA', 'DHAKA', 'BANGLADESH'),
(1005, 'GULSHAN', 'DHAKA', 'BANGLADESH'),
(1006, 'BANANI', 'DHAKA', 'BANGLADESH'),
(1007, 'AGARGAON', 'DHAKA', 'BANGLADESH'),
(1008, 'BASSABOO', 'DHAKA', 'BANGLADESH'),
(1009, 'KHILGAON', 'DHAKA', 'BANGLADESH'),
(1010, 'UTTARA', 'DHAKA', 'BANGLADESH'),
(1011, 'OLD DHAKA', 'DHAKA', 'BANGLADESH'),
(1012, 'BASHUNDHARA', 'DHAKA', 'BANGLADESH'),
(1013, 'SHAHJADPUR', 'DHAKA', 'BANGLADESH'),
(1014, 'NOTUN BAZAR', 'DHAKA', 'BANGLADESH'),
(1015, 'ANDORKILLA', 'CHITTAGONG', 'BANGLADESH'),
(1016, 'MADARTEK', 'DHAKA', 'BANGLADESH'),
(1017, 'AGRABAD', 'CHITTAGONG', 'BANGLADESH');

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `ADMINISTRATOR _ID` varchar(10) NOT NULL,
  `ADMINISTRATOR _NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `PHONE_NUMBER` varchar(14) NOT NULL,
  `ADDRESS_ID` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`ADMINISTRATOR _ID`, `ADMINISTRATOR _NAME`, `PASSWORD`, `PHONE_NUMBER`, `ADDRESS_ID`) VALUES
('18389603', 'SHIHAB AHMED', 'ADMINISTRATORacc', '+8801956191022', 1001);

-- --------------------------------------------------------

--
-- Table structure for table `association_stu_fre`
--

CREATE TABLE `association_stu_fre` (
  `STUDENT_ID` int(8) NOT NULL,
  `FREELANCER_ID` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `association_stu_fre`
--

INSERT INTO `association_stu_fre` (`STUDENT_ID`, `FREELANCER_ID`) VALUES
(5, 5003),
(4, 5002),
(4, 5001),
(10, 5003),
(1, 5011),
(3, 5011),
(1, 5012),
(3, 5012),
(11, 5013),
(11, 5014),
(6, 5015),
(13, 5016),
(13, 5015),
(9, 5006),
(8, 5009),
(12, 5010),
(12, 5009),
(2, 5011),
(14, 5011);

-- --------------------------------------------------------

--
-- Table structure for table `freelancer`
--

CREATE TABLE `freelancer` (
  `FREELANCER_ID` int(8) NOT NULL,
  `FREELANCER_NAME` varchar(30) NOT NULL,
  `PHONE_NUMBER` varchar(14) NOT NULL,
  `QUALIFICATION` varchar(15) NOT NULL,
  `PREFERRED_SUBJECT` varchar(20) NOT NULL,
  `REFERRED_CLASS` varchar(10) NOT NULL,
  `ADDRESS_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `freelancer`
--

INSERT INTO `freelancer` (`FREELANCER_ID`, `FREELANCER_NAME`, `PHONE_NUMBER`, `QUALIFICATION`, `PREFERRED_SUBJECT`, `REFERRED_CLASS`, `ADDRESS_ID`) VALUES
(5001, 'AZAD HOSEN', '+8801545879642', 'MSC CSE', 'ICT', '11-12', 1006),
(5002, 'SARKAR PRINCE', '+8801758985555', 'BSC EEE', 'PHYSICS', '11-12', 1001),
(5003, 'ALINDA BHATTACHARJEE', '+8801533965371', 'BSC CIVIL', 'PHYSICS', '9-10', 1008),
(5004, 'SAJIB DAS', '+8801954789624', 'BSC MARINE', 'CHEMISTRY', '9-10', 1008),
(5005, 'TANZIMA ZAHIR AURTHY', '+8801947858799', 'HSC', 'BANGLA', '9-10', 1008),
(5006, 'JAMIL AHSAN', '+8801545652585', 'MSC EEE', 'CHEMISTRY ', '11-12', 1002),
(5007, 'FAHIM RAHMAN', '+8801356487921', 'B. HON\'S', 'BANGLA ', '9-10', 1014),
(5008, 'HENA MOJUMDAR', '+8801355664422', 'MBA FINANCE', 'FINANCE', '11-12', 1010),
(5009, 'NUSRAT FARIHA', '+8801954621587', 'BSC NAME', 'CHEMISTRY', '11-12', 1010),
(5010, 'FARIYA ISLAM', '+8801645879875', 'B. HON\'S', 'ENGLISH ', '11-12', 1009),
(5011, 'SURINDAR BARUA', '+8801456487925', 'PHD', 'PHYSICS', 'UNDERGRADE', 1012),
(5012, 'HOSSAIN MAHMUD', '+8801445688584', 'MASTERS', 'CHEMISTRY', 'UNDERGRADE', 1003),
(5013, 'TAMANNA RAHMAN', '+8801956874852', 'PHD', 'ECONOMICS', 'POSTGRADE', 1013),
(5014, 'SHAYLA AKTER', '+8801756452541', 'MSC CS', 'PROGRAMMING', 'POSTGRADE', 1005),
(5015, 'ASHIK ISLAM', '+8801352689742', 'HSC', 'SCIENCE', '6-8', 1011),
(5016, 'JOTEE ISLAM', '+8801754789632', 'SSC', 'ENGLISH', '6-8', 1008);

-- --------------------------------------------------------

--
-- Table structure for table `institution`
--

CREATE TABLE `institution` (
  `INSTITUTION_ID` int(8) NOT NULL,
  `INSTITUTION_NAME` varchar(30) NOT NULL,
  `PHONE_NUMBER` varchar(14) NOT NULL,
  `ADDRESS_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `institution`
--

INSERT INTO `institution` (`INSTITUTION_ID`, `INSTITUTION_NAME`, `PHONE_NUMBER`, `ADDRESS_ID`) VALUES
(1880, 'UDVASH ACADEMIC EDUCARE', '+880994758', 1002),
(1881, 'SIMOOM COACHING CENTER', '+8801785879547', 1009),
(1882, 'CARE ACADEMIC CENTER', '+88029945784', 1008),
(1883, 'MONOSSHE COACHING ', '+8801995477757', 1001),
(1884, 'IQRA COACHING CENTER', '+8801755545545', 1007);

-- --------------------------------------------------------

--
-- Table structure for table `offerings`
--

CREATE TABLE `offerings` (
  `OFFER_ID` int(8) NOT NULL,
  `PREFERRED_SUBJECT` varchar(20) NOT NULL,
  `SALARY` int(8) NOT NULL,
  `STATUS` varchar(8) NOT NULL DEFAULT 'PENDING',
  `STUDENT_ID` int(8) DEFAULT NULL,
  `INSTITUTION_ID` int(8) DEFAULT NULL,
  `FREELANCER_ID` int(8) DEFAULT NULL,
  `PROFESSIONAL_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `offerings`
--

INSERT INTO `offerings` (`OFFER_ID`, `PREFERRED_SUBJECT`, `SALARY`, `STATUS`, `STUDENT_ID`, `INSTITUTION_ID`, `FREELANCER_ID`, `PROFESSIONAL_ID`) VALUES
(2001, 'MATHEMATICS', 20000, 'PENDING', NULL, 1880, NULL, 3002),
(2002, 'ICT', 2000, 'ACCEPTED', 4, NULL, 5001, NULL),
(2003, 'PHYSICS', 4000, 'PENDING', 8, NULL, 5003, NULL),
(2004, 'CHEMISTRY', 3000, 'PENDING', 5, NULL, 5004, NULL),
(2005, 'CHEMISTRY', 3000, 'ACCEPTED', 1, NULL, 5012, NULL),
(2006, 'PHYSICS', 3500, 'ACCEPTED', 1, NULL, 5011, NULL),
(2007, 'PHYSICS', 3000, 'ACCEPTED', 2, NULL, 5011, NULL),
(2008, 'PHYSICS', 4500, 'ACCEPTED', 3, NULL, 5011, NULL),
(2009, 'CHEMISTRY', 3500, 'ACCEPTED', 3, NULL, 5012, NULL),
(2010, 'PHYSICS', 3500, 'ACCEPTED', 4, NULL, 5002, NULL),
(2011, 'PHYSICS', 3000, 'ACCEPTED', 5, NULL, 5003, NULL),
(2012, 'SCIENCE', 2000, 'ACCEPTED', 6, NULL, 5015, NULL),
(2013, 'CHEMISTRY', 3000, 'ACCEPTED', 8, NULL, 5009, NULL),
(2014, 'CHEMISTRY', 4000, 'ACCEPTED', 9, NULL, 5006, NULL),
(2015, 'PHYSICS', 4000, 'ACCEPTED', 10, NULL, 5003, NULL),
(2016, 'ECONOMICS', 5000, 'ACCEPTED', 11, NULL, 5013, NULL),
(2017, 'PROGRAMMING', 6000, 'ACCEPTED', 11, NULL, 5014, NULL),
(2018, 'CHEMISTRY', 3000, 'ACCEPTED', 12, NULL, 5009, NULL),
(2019, 'ENGLISH', 2500, 'ACCEPTED', 12, NULL, 5010, NULL),
(2020, 'SCIENCE', 2000, 'ACCEPTED', 13, NULL, 5015, NULL),
(2021, 'ENGLISH', 2000, 'ACCEPTED', 13, NULL, 5016, NULL),
(2022, 'PHYSICS', 5000, 'ACCEPTED', 14, NULL, 5011, NULL),
(2023, 'PHYSICS', 15000, 'ACCEPTED', NULL, 1884, NULL, 3001),
(2024, 'ACCOUNTING ', 10000, 'ACCEPTED', NULL, 1883, NULL, 3004),
(2034, 'ECONOMICS', 20000, 'PENDING', NULL, 1883, NULL, 3003);

-- --------------------------------------------------------

--
-- Table structure for table `professional`
--

CREATE TABLE `professional` (
  `PROFESSIONAL_ID` int(8) NOT NULL,
  `PROFESSIONAL_NAME` varchar(30) NOT NULL,
  `PHONE_NUMBER` varchar(14) NOT NULL,
  `QUALIFICATION` varchar(15) NOT NULL,
  `PREFERRED_SUBJECT` varchar(20) NOT NULL,
  `INSTITUTION_ID` int(8) DEFAULT NULL,
  `ADDRESS_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `professional`
--

INSERT INTO `professional` (`PROFESSIONAL_ID`, `PROFESSIONAL_NAME`, `PHONE_NUMBER`, `QUALIFICATION`, `PREFERRED_SUBJECT`, `INSTITUTION_ID`, `ADDRESS_ID`) VALUES
(3001, 'SIKDER ARIAN', '+8801457895874', 'M. ED', 'PHYSICS', 1884, 1004),
(3002, 'MUMTAHINA AKTER', '+8801758586498', 'B. HON\'S', 'MATHEMATICS', NULL, 1012),
(3003, 'JAHIDA AKTER', '+8801565457585', 'MASTERS', 'ECONOMICS', NULL, 1005),
(3004, 'FAHIM AHMED', '+8801654588321', 'B. HON\'S', 'ACCOUNTING ', 1883, 1011);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `STUDENT_ID` int(8) NOT NULL,
  `STUDENT_NAME` varchar(30) NOT NULL,
  `CLASS` varchar(10) NOT NULL,
  `PHONE_NUMBER` varchar(14) NOT NULL,
  `ADDRESS_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`STUDENT_ID`, `STUDENT_NAME`, `CLASS`, `PHONE_NUMBER`, `ADDRESS_ID`) VALUES
(1, 'MD. SHIHAB UDDIN AHMED', 'UNDERGRADE', '+8801956191022', 1010),
(2, 'RAMISA ANJUM OISHEE', 'UNDERGRADE', '+8801456987423', 1009),
(3, 'A.A.M FAIYAZ RAHMAN', 'UNDERGRADE', '+8801316006600', 1007),
(4, 'NAIMUR RAHMAN', '11-12', '+8801525874693', 1004),
(5, 'KARIM HASAN', '9-10', '+8801964875230', 1002),
(6, 'HASAN MAHMUD', '6-8', '+8801854795855', 1006),
(7, 'RAHIM UDDIN AHMED', '9-10', '+8801635698421', 1002),
(8, 'ABU JAR RAHMAN', '11-12', '+8801687942314', 1005),
(9, 'JIM SAROWER', '11-12', '+8801658885555', 1006),
(10, 'ERFAN AHMED', '9-10', '+8801725874699', 1001),
(11, 'HASAN IMDADUL', 'POSTGRADE', '+8801914788859', 1005),
(12, 'MARIA HAKIM OISHI', '11-12', '+8801933995014', 1010),
(13, 'MD. KAMAL UDDIN', '6-8', '+8801658795462', 1010),
(14, 'AMATUN NOOR TANHA', 'UNDERGRADE', '+8801525455255', 1001),
(15, 'ROKEYA AKTER', '1-5', '+8801425845699', 1006);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ACCOUNT_ID`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`),
  ADD KEY `FREELANCER_ID` (`FREELANCER_ID`),
  ADD KEY `INSTITUTION_ID` (`INSTITUTION_ID`),
  ADD KEY `PROFESSIONAL_ID` (`PROFESSIONAL_ID`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ADDRESS_ID`);

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`ADMINISTRATOR _ID`,`PHONE_NUMBER`),
  ADD UNIQUE KEY `PASSWORD` (`PASSWORD`),
  ADD KEY `ADDRESS_ID` (`ADDRESS_ID`);

--
-- Indexes for table `association_stu_fre`
--
ALTER TABLE `association_stu_fre`
  ADD KEY `STUDENT_ID` (`STUDENT_ID`),
  ADD KEY `FREELANCER_ID` (`FREELANCER_ID`);

--
-- Indexes for table `freelancer`
--
ALTER TABLE `freelancer`
  ADD PRIMARY KEY (`FREELANCER_ID`,`PHONE_NUMBER`),
  ADD KEY `ADDRESS_ID` (`ADDRESS_ID`);

--
-- Indexes for table `institution`
--
ALTER TABLE `institution`
  ADD PRIMARY KEY (`INSTITUTION_ID`,`PHONE_NUMBER`),
  ADD KEY `ADDRESS_ID` (`ADDRESS_ID`);

--
-- Indexes for table `offerings`
--
ALTER TABLE `offerings`
  ADD PRIMARY KEY (`OFFER_ID`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`),
  ADD KEY `INSTITUTION_ID` (`INSTITUTION_ID`),
  ADD KEY `FREELANCER_ID` (`FREELANCER_ID`),
  ADD KEY `PROFESSIONAL_ID` (`PROFESSIONAL_ID`);

--
-- Indexes for table `professional`
--
ALTER TABLE `professional`
  ADD PRIMARY KEY (`PROFESSIONAL_ID`,`PHONE_NUMBER`),
  ADD KEY `INSTITUTION_ID` (`INSTITUTION_ID`),
  ADD KEY `ADDRESSE_ID` (`ADDRESS_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`STUDENT_ID`,`PHONE_NUMBER`),
  ADD KEY `ADDRESS_ID` (`ADDRESS_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `ACCOUNT_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000056;

--
-- AUTO_INCREMENT for table `freelancer`
--
ALTER TABLE `freelancer`
  MODIFY `FREELANCER_ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5018;

--
-- AUTO_INCREMENT for table `institution`
--
ALTER TABLE `institution`
  MODIFY `INSTITUTION_ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1886;

--
-- AUTO_INCREMENT for table `offerings`
--
ALTER TABLE `offerings`
  MODIFY `OFFER_ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2038;

--
-- AUTO_INCREMENT for table `professional`
--
ALTER TABLE `professional`
  MODIFY `PROFESSIONAL_ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3007;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `STUDENT_ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`FREELANCER_ID`) REFERENCES `freelancer` (`FREELANCER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`PROFESSIONAL_ID`) REFERENCES `professional` (`PROFESSIONAL_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `account_ibfk_4` FOREIGN KEY (`INSTITUTION_ID`) REFERENCES `institution` (`INSTITUTION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `association_stu_fre`
--
ALTER TABLE `association_stu_fre`
  ADD CONSTRAINT `association_stu_fre_ibfk_1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `association_stu_fre_ibfk_2` FOREIGN KEY (`FREELANCER_ID`) REFERENCES `freelancer` (`FREELANCER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `freelancer`
--
ALTER TABLE `freelancer`
  ADD CONSTRAINT `freelancer_ibfk_1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `institution`
--
ALTER TABLE `institution`
  ADD CONSTRAINT `institution_ibfk_1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`);

--
-- Constraints for table `offerings`
--
ALTER TABLE `offerings`
  ADD CONSTRAINT `offerings_ibfk_1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `offerings_ibfk_2` FOREIGN KEY (`INSTITUTION_ID`) REFERENCES `institution` (`INSTITUTION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `offerings_ibfk_3` FOREIGN KEY (`FREELANCER_ID`) REFERENCES `freelancer` (`FREELANCER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `offerings_ibfk_4` FOREIGN KEY (`PROFESSIONAL_ID`) REFERENCES `professional` (`PROFESSIONAL_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `professional`
--
ALTER TABLE `professional`
  ADD CONSTRAINT `professional_ibfk_1` FOREIGN KEY (`INSTITUTION_ID`) REFERENCES `institution` (`INSTITUTION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `professional_ibfk_2` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `F1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
