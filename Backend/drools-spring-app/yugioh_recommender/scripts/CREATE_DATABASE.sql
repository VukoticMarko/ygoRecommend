CREATE TABLE `archetype_attribute` (
  `archetypes_id` varchar(36) NOT NULL,
  `attribute` varchar(45) NOT NULL,
  PRIMARY KEY (`archetypes_id`,`attribute`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subs` (
  `id` varchar(36) NOT NULL,
  `sub_type` varchar(45) DEFAULT NULL,
  `difficulty` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `archetypes` (
  `id` varchar(36) NOT NULL,
  `archetype_name` varchar(72) DEFAULT NULL,
  `description` longtext,
  `how_to_play` longtext,
  `main_type_of_deck` varchar(45) DEFAULT NULL,
  `deck_difficulty_int` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `archetype_types_in_deck` (
  `archetypes_id` varchar(36) NOT NULL,
  `types_in_deck` varchar(45) NOT NULL,
  PRIMARY KEY (`archetypes_id`,`types_in_deck`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `archetype_sub_types_in_deck` (
  `archetypes_id` varchar(36) NOT NULL,
  `sub_id` varchar(36) NOT NULL,
  PRIMARY KEY (`archetypes_id`,`sub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `archetype_keywords` (
  `archetypes_id` varchar(36) NOT NULL,
  `keywords` varchar(45) NOT NULL,
  PRIMARY KEY (`archetypes_id`,`keywords`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `archetype_playstyle` (
  `archetypes_id` varchar(36) NOT NULL,
  `playstyle` varchar(45) NOT NULL,
  PRIMARY KEY (`archetypes_id`,`playstyle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `archetype_extra_deck` (
  `archetypes_id` varchar(36) NOT NULL,
  `extra_deck` varchar(45) NOT NULL,
  PRIMARY KEY (`archetypes_id`,`extra_deck`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;