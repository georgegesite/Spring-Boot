# Read Me First

The following was discovered as part of building this project:

- The original package name 'com.ggesite.expense tracker' is invalid and this project uses 'com.ggesite.expense.tracker' instead.

#Features

- add total daily expense
- categorize monthly expense on category
- select menu for category ->replace text input

CREATE TABLE `expense` (
`id` bigint NOT NULL AUTO_INCREMENT,
`category` varchar(20) DEFAULT NULL,
`expense` varchar(255) DEFAULT NULL,
`amount` bigint DEFAULT NULL,
`created_on` datetime(6) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
