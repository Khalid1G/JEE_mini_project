SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SET SQL_MODE='ALLOW_INVALID_DATES';

CREATE TABLE `User`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(255) NOT NULL,
    `prenom` VARCHAR(255) NOT NULL,
    `role` ENUM('') NOT NULL,
    `tel` VARCHAR(255) NOT NULL,
    `adress` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `avatar` VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `deleted_at` TIMESTAMP NOT NULL,
    PRIMARY KEY `user_id_primary`(`id`)
);

CREATE TABLE `Commandes`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `client_id` BIGINT NOT NULL,
    `immobilier_id` BIGINT NOT NULL,
    `type_commande_` BIGINT NOT NULL,
    `date_debut` DATETIME NULL,
    `date_fin` DATETIME NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `deleted_at` TIMESTAMP NOT NULL,
    PRIMARY KEY `commandes_id_primary`(`id`)
);

CREATE TABLE `Images`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `imageable_owenr_id` BIGINT NOT NULL,
    `path` VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `deleted_at` TIMESTAMP NOT NULL,
    PRIMARY KEY `images_id_primary`(`id`)
);

CREATE TABLE `Immobiliers`(
    `id` BIGINT  NOT NULL AUTO_INCREMENT,
    `adresse` VARCHAR(255) NOT NULL,
    `pay` VARCHAR(255) NOT NULL,
    `ville` VARCHAR(255) NOT NULL,
    `surface` VARCHAR(255) NOT NULL,
    `nbr_etage` INT NOT NULL,
    `type` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `prix` DOUBLE(8, 2) NOT NULL,
    `disponibilite` TINYINT(1) NOT NULL DEFAULT '1',
    `proprietaire_id` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `deleted_at` TIMESTAMP NOT NULL,
    PRIMARY KEY `immobiliers_id_primary`(`id`)
);


ALTER TABLE
    `Commandes` ADD CONSTRAINT `commandes_client_id_foreign` FOREIGN KEY(`client_id`) REFERENCES `User`(`id`);
ALTER TABLE
    `Images` ADD CONSTRAINT `images_imageable_owenr_id_foreign` FOREIGN KEY(`imageable_owenr_id`) REFERENCES `Immobiliers`(`id`);
ALTER TABLE
    `Commandes` ADD CONSTRAINT `commandes_immobilier_id_foreign` FOREIGN KEY(`immobilier_id`) REFERENCES `Immobiliers`(`id`);
ALTER TABLE
    `Immobiliers` ADD CONSTRAINT `immobiliers_proprietaire_id_foreign` FOREIGN KEY(`proprietaire_id`) REFERENCES `User`(`id`);