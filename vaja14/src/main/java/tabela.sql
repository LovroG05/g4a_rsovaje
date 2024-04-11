CREATE TABLE `rezultati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `igra` varchar(100) NOT NULL,
  `igralec` varchar(100) NOT NULL,
  `zacetek` timestamp NOT NULL DEFAULT current_timestamp(),
  `konec` timestamp NOT NULL DEFAULT current_timestamp(),
  `rezultat` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci
