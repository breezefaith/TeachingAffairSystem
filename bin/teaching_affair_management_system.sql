-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2017-06-30 04:06:01
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `teaching_affair_management_system`
--

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE `course` (
  `course_no` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `course_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `course_academy` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_category` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`course_no`, `course_name`, `course_academy`, `course_category`) VALUES
('c1', '高等数学', '理学院', '必修'),
('c2', '大学物理', '理学院', '必修'),
('c3', 'C语言', '计算机学院', '必修'),
('c4', '数据库', '计算机学院', '选修');

-- --------------------------------------------------------

--
-- 表的结构 `current_semester`
--

CREATE TABLE `current_semester` (
  `current_semeste_id` int(11) NOT NULL,
  `semester_no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `current_semester`
--

INSERT INTO `current_semester` (`current_semeste_id`, `semester_no`) VALUES
(0, 1);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `current_semester_schdule_view`
-- (See below for the actual view)
--
CREATE TABLE `current_semester_schdule_view` (
`semester_no` int(11)
,`semester_name` varchar(30)
,`course_no` varchar(20)
,`course_name` varchar(20)
,`teacher_no` varchar(20)
,`teacher_name` varchar(20)
,`start_week` int(2)
,`end_week` int(2)
,`day` char(2)
,`start_class_no` int(11)
,`end_class_no` int(11)
);

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE `manager` (
  `manager_no` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`manager_no`, `username`, `password`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3'),
(2, 'root', '63a9f0ea7bb98050796b649e85481845'),
(3, 'system', '54b53072540eeeb8f8e9343e71f28176'),
(4, 'test', '21218cca77804d2ba1922c33e0151105');

-- --------------------------------------------------------

--
-- 表的结构 `schedule`
--

CREATE TABLE `schedule` (
  `class_no` int(11) NOT NULL,
  `start_class_time` time NOT NULL,
  `end_class_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `schedule`
--

INSERT INTO `schedule` (`class_no`, `start_class_time`, `end_class_time`) VALUES
(1, '08:00:00', '08:45:00'),
(2, '08:50:00', '09:35:00'),
(3, '09:50:00', '10:35:00'),
(4, '10:40:00', '11:25:00'),
(5, '11:30:00', '12:15:00'),
(6, '13:45:00', '14:30:00'),
(7, '14:35:00', '15:20:00'),
(8, '15:35:00', '14:20:00'),
(9, '16:25:00', '17:10:00'),
(10, '18:30:00', '19:15:00'),
(11, '19:25:00', '20:10:00'),
(12, '20:20:00', '21:05:00');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `selected_course_view`
-- (See below for the actual view)
--
CREATE TABLE `selected_course_view` (
`course_no` varchar(20)
,`course_name` varchar(20)
,`course_academy` varchar(30)
,`course_category` varchar(30)
,`teacher_no` varchar(20)
,`teacher_name` varchar(20)
,`teacher_academy` varchar(30)
,`teacher_title` varchar(30)
,`teacher_email` varchar(30)
,`semester_no` int(11)
,`semester_name` varchar(30)
,`start_week` int(2)
,`end_week` int(2)
,`is_current_semester` int(1)
);

-- --------------------------------------------------------

--
-- 表的结构 `select_course`
--

CREATE TABLE `select_course` (
  `select_course_no` int(11) NOT NULL,
  `student_no` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `semester_course_no` int(11) DEFAULT NULL,
  `score` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `select_course`
--

INSERT INTO `select_course` (`select_course_no`, `student_no`, `semester_course_no`, `score`) VALUES
(1, 's1', 1, 99),
(2, 's2', 1, 91),
(4, 's1', 2, NULL),
(6, 's2', 2, NULL),
(14, 's1', 3, NULL),
(15, 's1', 8, NULL);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `select_course_result_view`
-- (See below for the actual view)
--
CREATE TABLE `select_course_result_view` (
`student_no` varchar(20)
,`student_name` varchar(20)
,`student_academy` varchar(30)
,`student_major` varchar(30)
,`student_class` int(11)
,`teacher_no` varchar(20)
,`teacher_name` varchar(20)
,`teacher_academy` varchar(30)
,`teacher_title` varchar(30)
,`teacher_email` varchar(30)
,`course_no` varchar(20)
,`course_name` varchar(20)
,`course_academy` varchar(30)
,`course_category` varchar(30)
,`start_week` int(2)
,`end_week` int(2)
,`semester_no` int(11)
,`semester_name` varchar(30)
,`score` int(3)
);

-- --------------------------------------------------------

--
-- 表的结构 `semester`
--

CREATE TABLE `semester` (
  `semester_no` int(11) NOT NULL,
  `semester_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `semester`
--

INSERT INTO `semester` (`semester_no`, `semester_name`, `start_date`, `end_date`) VALUES
(1, '2016-2017第2学期', '2017-01-24', '2017-01-05'),
(2, '2017-2018第1学期', '2017-09-03', '2018-01-22'),
(3, '2017-2018第二学期', '2017-01-29', '2018-01-30');

-- --------------------------------------------------------

--
-- 表的结构 `semester_course`
--

CREATE TABLE `semester_course` (
  `semester_course_no` int(11) NOT NULL,
  `semester_no` int(11) DEFAULT NULL,
  `course_no` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_no` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `start_week` int(2) NOT NULL,
  `end_week` int(2) NOT NULL,
  `expect_num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `semester_course`
--

INSERT INTO `semester_course` (`semester_course_no`, `semester_no`, `course_no`, `teacher_no`, `start_week`, `end_week`, `expect_num`) VALUES
(1, 1, 'c1', 't1', 1, 18, 70),
(2, 2, 'c2', 't2', 1, 10, 30),
(3, 1, 'c3', 't2', 1, 18, 70),
(5, 2, 'c3', 't3', 1, 10, 70),
(7, 1, 'c2', 't4', 1, 18, 70),
(8, 1, 'c4', 't3', 1, 18, 70),
(10, 2, 'c1', 't4', 1, 18, 70),
(11, 2, 'c4', 't5', 1, 19, 70);

-- --------------------------------------------------------

--
-- 表的结构 `semester_course_shedule`
--

CREATE TABLE `semester_course_shedule` (
  `semester_course_no` int(11) NOT NULL,
  `day` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `start_class_no` int(11) NOT NULL,
  `end_class_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `semester_course_shedule`
--

INSERT INTO `semester_course_shedule` (`semester_course_no`, `day`, `start_class_no`, `end_class_no`) VALUES
(1, '一', 1, 2),
(1, '五', 3, 5);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `semester_course_view`
-- (See below for the actual view)
--
CREATE TABLE `semester_course_view` (
`semester_no` int(11)
,`semester_name` varchar(30)
,`start_date` date
,`end_date` date
,`course_no` varchar(20)
,`course_name` varchar(20)
,`course_academy` varchar(30)
,`course_category` varchar(30)
,`teacher_no` varchar(20)
,`teacher_name` varchar(20)
,`teacher_academy` varchar(30)
,`teacher_title` varchar(30)
,`teacher_email` varchar(30)
,`start_week` int(2)
,`end_week` int(2)
,`expect_num` int(11)
,`actual_num` bigint(21)
);

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `student_no` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `student_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_academy` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_major` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_class` int(11) DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT '888888'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`student_no`, `student_name`, `sex`, `student_academy`, `student_major`, `student_class`, `password`) VALUES
('s1', '王五', '男', '计算机学院', '软件工程', 9, '96e79218965eb72c92a549dd5a330112'),
('s2', '赵六', '女', '理学院', '应用物理', 1, '21218cca77804d2ba1922c33e0151105'),
('s3', '何七', '男', '自动化', '测控', 4, '21218cca77804d2ba1922c33e0151105'),
('s6', '赵四', '女', '自动化', '测控', 4, '21218cca77804d2ba1922c33e0151105');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `system_user_view`
-- (See below for the actual view)
--
CREATE TABLE `system_user_view` (
`username` varchar(20)
,`password` varchar(40)
,`identity` varchar(7)
);

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `teacher_no` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `teacher_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_academy` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_title` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT '888888'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`teacher_no`, `teacher_name`, `sex`, `teacher_academy`, `teacher_title`, `teacher_email`, `password`) VALUES
('t1', '应志领', '女', '理学院', '副教授', 'yingzhiling@njupt.edu.cn', '21218cca77804d2ba1922c33e0151105'),
('t2', '李四', '男', '计算机', '教授', 'lisisili@163.com', '21218cca77804d2ba1922c33e0151105'),
('t3', '金仙力', '男', '计算机', '副教授', 'jinxianli@njupt.edu.cn', '21218cca77804d2ba1922c33e0151105'),
('t4', '戴华', '男', '计算机', '副教授', 'daihua@njupt.edu.cn', '21218cca77804d2ba1922c33e0151105'),
('t5', '陈云芳', '男', '计算机', '教授', '', '96e79218965eb72c92a549dd5a330112'),
('t6', '王子元', '男', '计算机', '副教授', '', '21218cca77804d2ba1922c33e0151105');

-- --------------------------------------------------------

--
-- 表的结构 `test`
--

CREATE TABLE `test` (
  `a` char(1) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 视图结构 `current_semester_schdule_view`
--
DROP TABLE IF EXISTS `current_semester_schdule_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `current_semester_schdule_view`  AS  select `semester`.`semester_no` AS `semester_no`,`semester`.`semester_name` AS `semester_name`,`semester_course`.`course_no` AS `course_no`,`course`.`course_name` AS `course_name`,`semester_course`.`teacher_no` AS `teacher_no`,`teacher`.`teacher_name` AS `teacher_name`,`semester_course`.`start_week` AS `start_week`,`semester_course`.`end_week` AS `end_week`,`semester_course_shedule`.`day` AS `day`,`semester_course_shedule`.`start_class_no` AS `start_class_no`,`semester_course_shedule`.`end_class_no` AS `end_class_no` from (((((`semester` join `course`) join `semester_course`) join `teacher`) join `semester_course_shedule`) join `current_semester`) where ((`semester_course`.`semester_no` = `semester`.`semester_no`) and (`semester`.`semester_no` = `current_semester`.`semester_no`) and (`teacher`.`teacher_no` = `semester_course`.`teacher_no`) and (`course`.`course_no` = `semester_course`.`course_no`)) group by `semester_course`.`semester_course_no`,`semester_course_shedule`.`day` ;

-- --------------------------------------------------------

--
-- 视图结构 `selected_course_view`
--
DROP TABLE IF EXISTS `selected_course_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `selected_course_view`  AS  select `course`.`course_no` AS `course_no`,`course`.`course_name` AS `course_name`,`course`.`course_academy` AS `course_academy`,`course`.`course_category` AS `course_category`,`teacher`.`teacher_no` AS `teacher_no`,`teacher`.`teacher_name` AS `teacher_name`,`teacher`.`teacher_academy` AS `teacher_academy`,`teacher`.`teacher_title` AS `teacher_title`,`teacher`.`teacher_email` AS `teacher_email`,`semester_course`.`semester_no` AS `semester_no`,`semester`.`semester_name` AS `semester_name`,`semester_course`.`start_week` AS `start_week`,`semester_course`.`end_week` AS `end_week`,(`current_semester`.`semester_no` = `semester`.`semester_no`) AS `is_current_semester` from ((((`course` join `semester_course`) join `teacher`) join `semester`) join `current_semester`) where ((`course`.`course_no` = `semester_course`.`course_no`) and (`teacher`.`teacher_no` = `semester_course`.`teacher_no`) and (`semester`.`semester_no` = `semester_course`.`semester_no`)) ;

-- --------------------------------------------------------

--
-- 视图结构 `select_course_result_view`
--
DROP TABLE IF EXISTS `select_course_result_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `select_course_result_view`  AS  select `student`.`student_no` AS `student_no`,`student`.`student_name` AS `student_name`,`student`.`student_academy` AS `student_academy`,`student`.`student_major` AS `student_major`,`student`.`student_class` AS `student_class`,`teacher`.`teacher_no` AS `teacher_no`,`teacher`.`teacher_name` AS `teacher_name`,`teacher`.`teacher_academy` AS `teacher_academy`,`teacher`.`teacher_title` AS `teacher_title`,`teacher`.`teacher_email` AS `teacher_email`,`course`.`course_no` AS `course_no`,`course`.`course_name` AS `course_name`,`course`.`course_academy` AS `course_academy`,`course`.`course_category` AS `course_category`,`semester_course`.`start_week` AS `start_week`,`semester_course`.`end_week` AS `end_week`,`semester`.`semester_no` AS `semester_no`,`semester`.`semester_name` AS `semester_name`,`select_course`.`score` AS `score` from (((((`student` join `semester_course`) join `semester`) join `select_course`) join `course`) join `teacher`) where ((`student`.`student_no` = `select_course`.`student_no`) and (`course`.`course_no` = `semester_course`.`course_no`) and (`semester`.`semester_no` = `semester_course`.`semester_no`) and (`teacher`.`teacher_no` = `semester_course`.`teacher_no`) and (`select_course`.`semester_course_no` = `semester_course`.`semester_course_no`)) ;

-- --------------------------------------------------------

--
-- 视图结构 `semester_course_view`
--
DROP TABLE IF EXISTS `semester_course_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `semester_course_view`  AS  select `semester`.`semester_no` AS `semester_no`,`semester`.`semester_name` AS `semester_name`,`semester`.`start_date` AS `start_date`,`semester`.`end_date` AS `end_date`,`course`.`course_no` AS `course_no`,`course`.`course_name` AS `course_name`,`course`.`course_academy` AS `course_academy`,`course`.`course_category` AS `course_category`,`teacher`.`teacher_no` AS `teacher_no`,`teacher`.`teacher_name` AS `teacher_name`,`teacher`.`teacher_academy` AS `teacher_academy`,`teacher`.`teacher_title` AS `teacher_title`,`teacher`.`teacher_email` AS `teacher_email`,`semester_course`.`start_week` AS `start_week`,`semester_course`.`end_week` AS `end_week`,`semester_course`.`expect_num` AS `expect_num`,count(0) AS `actual_num` from ((((`course` join `semester_course`) join `semester`) join `teacher`) join `select_course`) where ((`course`.`course_no` = `semester_course`.`course_no`) and (`semester_course`.`semester_no` = `semester`.`semester_no`) and (`teacher`.`teacher_no` = `semester_course`.`teacher_no`)) group by `semester_course`.`semester_course_no` ;

-- --------------------------------------------------------

--
-- 视图结构 `system_user_view`
--
DROP TABLE IF EXISTS `system_user_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `system_user_view`  AS  select `manager`.`username` AS `username`,`manager`.`password` AS `password`,'manager' AS `identity` from `manager` union select `teacher`.`teacher_no` AS `teacher_no`,`teacher`.`password` AS `password`,'teacher' AS `teacher` from `teacher` union select `student`.`student_no` AS `student_no`,`student`.`password` AS `password`,'student' AS `student` from `student` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_no`);

--
-- Indexes for table `current_semester`
--
ALTER TABLE `current_semester`
  ADD PRIMARY KEY (`current_semeste_id`),
  ADD KEY `FKg2kt3ib3qydeivuqgj3jrvi6f` (`semester_no`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`manager_no`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`class_no`);

--
-- Indexes for table `select_course`
--
ALTER TABLE `select_course`
  ADD PRIMARY KEY (`select_course_no`),
  ADD KEY `FKb7w1y4yqxaxp5wnvos5tk7814` (`semester_course_no`),
  ADD KEY `FKsj0c3nq41aggvibwwao2a5eqo` (`student_no`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`semester_no`);

--
-- Indexes for table `semester_course`
--
ALTER TABLE `semester_course`
  ADD PRIMARY KEY (`semester_course_no`),
  ADD KEY `FKocbks5mtwxnh2m2bwpjsoy77o` (`course_no`),
  ADD KEY `FKd8ba9liw99599b73thl87sojc` (`teacher_no`),
  ADD KEY `FKoe9sdutocopur5trr7v53vn13` (`semester_no`);

--
-- Indexes for table `semester_course_shedule`
--
ALTER TABLE `semester_course_shedule`
  ADD PRIMARY KEY (`semester_course_no`,`day`),
  ADD KEY `FK6c1jnge2eo33qfg664bbn9xqb` (`start_class_no`),
  ADD KEY `FK3lywnwdcqgpfixt6v6bdblh1w` (`end_class_no`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_no`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_no`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `manager`
--
ALTER TABLE `manager`
  MODIFY `manager_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `schedule`
--
ALTER TABLE `schedule`
  MODIFY `class_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- 使用表AUTO_INCREMENT `select_course`
--
ALTER TABLE `select_course`
  MODIFY `select_course_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- 使用表AUTO_INCREMENT `semester`
--
ALTER TABLE `semester`
  MODIFY `semester_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用表AUTO_INCREMENT `semester_course`
--
ALTER TABLE `semester_course`
  MODIFY `semester_course_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- 限制导出的表
--

--
-- 限制表 `current_semester`
--
ALTER TABLE `current_semester`
  ADD CONSTRAINT `current_semester_ibfk_1` FOREIGN KEY (`semester_no`) REFERENCES `semester` (`semester_no`) ON DELETE SET NULL,
  ADD CONSTRAINT `FKg2kt3ib3qydeivuqgj3jrvi6f` FOREIGN KEY (`semester_no`) REFERENCES `semester` (`semester_no`);

--
-- 限制表 `select_course`
--
ALTER TABLE `select_course`
  ADD CONSTRAINT `FKb7w1y4yqxaxp5wnvos5tk7814` FOREIGN KEY (`semester_course_no`) REFERENCES `semester_course` (`semester_course_no`),
  ADD CONSTRAINT `FKsj0c3nq41aggvibwwao2a5eqo` FOREIGN KEY (`student_no`) REFERENCES `student` (`student_no`),
  ADD CONSTRAINT `select_course_ibfk_1` FOREIGN KEY (`student_no`) REFERENCES `student` (`student_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `select_course_ibfk_2` FOREIGN KEY (`semester_course_no`) REFERENCES `semester_course` (`semester_course_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `semester_course`
--
ALTER TABLE `semester_course`
  ADD CONSTRAINT `FKd8ba9liw99599b73thl87sojc` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`),
  ADD CONSTRAINT `FKocbks5mtwxnh2m2bwpjsoy77o` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`),
  ADD CONSTRAINT `FKoe9sdutocopur5trr7v53vn13` FOREIGN KEY (`semester_no`) REFERENCES `semester` (`semester_no`),
  ADD CONSTRAINT `semester_course_ibfk_1` FOREIGN KEY (`semester_no`) REFERENCES `semester` (`semester_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `semester_course_ibfk_2` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `semester_course_ibfk_3` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `semester_course_shedule`
--
ALTER TABLE `semester_course_shedule`
  ADD CONSTRAINT `FK3lywnwdcqgpfixt6v6bdblh1w` FOREIGN KEY (`end_class_no`) REFERENCES `schedule` (`class_no`),
  ADD CONSTRAINT `FK6c1jnge2eo33qfg664bbn9xqb` FOREIGN KEY (`start_class_no`) REFERENCES `schedule` (`class_no`),
  ADD CONSTRAINT `FKemru3rs09jm4ptkcbhmygnupd` FOREIGN KEY (`semester_course_no`) REFERENCES `semester_course` (`semester_course_no`),
  ADD CONSTRAINT `semester_course_shedule_ibfk_1` FOREIGN KEY (`start_class_no`) REFERENCES `schedule` (`class_no`),
  ADD CONSTRAINT `semester_course_shedule_ibfk_2` FOREIGN KEY (`end_class_no`) REFERENCES `schedule` (`class_no`),
  ADD CONSTRAINT `semester_course_shedule_ibfk_3` FOREIGN KEY (`semester_course_no`) REFERENCES `semester_course` (`semester_course_no`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
