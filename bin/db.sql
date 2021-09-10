
DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `ques_id` int NOT NULL AUTO_INCREMENT,
  `ans` int NOT NULL,
  `chose` int NOT NULL,
  `optiona` varchar(255) DEFAULT NULL,
  `optionb` varchar(255) DEFAULT NULL,
  `optionc` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ques_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `questions`
--


INSERT INTO `questions` VALUES (1,3,-1,'echo \"Hello World\"','printf(\"Hello World\")','System.out.println(\"Hello World\")','What is a correct syntax to output \"Hello World\" in Java?'),(2,2,-1,'True','False','Partially True','Java is short for \"JavaScript.\"'),(3,2,-1,'# This is a comment','// This is a comment','/* This is a comment','How do you insert COMMENTS in Java code?'),(4,1,-1,'String','Char','Both','Which data type is used to create a variable that should store text?'),(5,3,-1,'num x = 5','float x = 5','int x = 5','How do you create a variable with the numeric value 5?'),(6,2,-1,'num x = 2.8','float x = 2.8','int x = 2.8','How do you create a variable with the floating number 2.8?'),(7,2,-1,'getSize()','length()','size()','Which method can be used to find the length of a string?'),(8,3,-1,'&&','.add()','+','Which operator is used to add together two values?'),(9,2,-1,'True','False','Maybe','The value of a string variable can be surrounded by single quotes.'),(10,3,-1,'><','&|','==','Which operator can be used to compare two values?');


--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `role`
--


INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_USER'),(3,'ROLE_USER'),(4,'ROLE_USER'),(5,'ROLE_USER');

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `total_correct` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES (18,'SG_JAVA10_HieuNM0210','nmhieu.fit@gmail.com','$2a$10$zwcnyzXLFMPEL0q62Jsy0OeGKp/Ft.38tOQFUJqjFH.qL/NJR9l3G',0);

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` VALUES (18,5);

