CREATE TABLE IF NOT EXISTS todo(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(20) NOT NULL DEFAULT "",
    `description` varchar(500) NOT NULL DEFAULT "",
    `on_date` date NOT NULL,
    `card_color` char(7) DEFAULT "#20d8ee",
    `is_completed` bit DEFAULT false,
    `created_on` timestamp DEFAULT CURRENT_TIMESTAMP,
    `modified_on` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `completed_on` timestamp DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
