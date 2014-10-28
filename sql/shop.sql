-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.39 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for shop
CREATE DATABASE IF NOT EXISTS `shop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `shop`;


-- Dumping structure for table shop.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL,
  `postal_code` varchar(5) NOT NULL,
  `street` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.address: ~20 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`id`, `city`, `postal_code`, `street`) VALUES
	(35, 'dfg', '657', 'sdf'),
	(36, 'ghj', '234', 'fgh'),
	(37, 'sdf', '4354', 'dfds'),
	(38, 'fdgdg', '567', 'dfgdfg'),
	(45, 'dfgf', '4565', 'dfgfd'),
	(46, 'xcv', 'xcv', 'xcvc'),
	(47, 'dffg', '678', 'vbcvb'),
	(48, 'Nevermore', '666', 'Dark Mountain'),
	(49, 'delete', '34634', 'hidden mountain'),
	(51, 'dfgfg', '0565', 'fsdgdf'),
	(52, 'dfgfg', '0565', 'fsdgdf'),
	(53, 'dfgfg', '0565', 'fsdgdf'),
	(54, 'dfgfg', '0565', 'fsdgdf'),
	(55, 'dfgfg', '0565', 'fsdgdf'),
	(56, 'dfgfg', '0565', 'fsdgdf'),
	(57, 'dfgfg', '4353', 'dfgdfg'),
	(58, 'sdffd', '3455', 'sdfdfsd'),
	(59, 'fdtgdf', '3455', 'dfgdfg'),
	(60, 'dfgg', '45453', 'fdgfdg'),
	(63, 'sdfdsf', '43534', 'sdfsdfs');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- Dumping structure for table shop.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.category: ~8 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`) VALUES
	(1, 'Sepatu'),
	(2, 'Buku Pendidikan'),
	(6, 'Elektronik'),
	(23, 'Buku Cerita'),
	(25, 'Rak Buku'),
	(26, 'Smartphone'),
	(27, 'Notebook'),
	(28, 'Smart Watch');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Dumping structure for table shop.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` datetime NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `home_phone` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `mobile_phone` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `gender` char(1) NOT NULL,
  `salutation` varchar(10) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address_id` (`address_id`),
  KEY `FK24217FDE887C4000` (`address_id`),
  CONSTRAINT `FK24217FDE887C4000` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.customer: ~20 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `birth_date`, `email`, `first_name`, `home_phone`, `last_name`, `mobile_phone`, `password`, `address_id`, `gender`, `salutation`, `status`) VALUES
	(26, '1993-01-07 00:01:00', 'sdfsd', 'zxcfcgbdf', '567', 'zxcx', '546', 'fgh', 35, 'P', 'Mr', 'ACTIVE'),
	(27, '1994-01-07 00:02:00', 'dfsf', 'zxcv', '345', 'sdf', '435', '07868', 36, 'P', 'Mr', 'ACTIVE'),
	(28, '1994-01-07 00:01:00', 'sdfsd', 'qweqwe', '234', 'dsf', '234', 'sdf', 37, 'P', 'Mr', 'ACTIVE'),
	(29, '1994-01-07 00:02:00', 'gfgh', 'erttyt', '546546', 'tyty', '4565', 'df', 38, 'P', 'Mr', 'ACTIVE'),
	(30, '1994-02-07 00:00:00', 'rtrtert', 'sdfdsf', '345', 'sdfdsd', '435', 'hgfdg', 45, 'P', 'Mr', 'ACTIVE'),
	(31, '1993-01-07 07:02:00', 'dfgfdg', 'zxcdzxsd', '5465', 'xcv', '456', 'cxvcxv', 46, 'P', 'Mr', 'ACTIVE'),
	(32, '1993-02-07 07:00:00', 'xcv', 'asdf', '56', 'fgh', '567', 'dfgfg', 47, 'P', 'Mr', 'ACTIVE'),
	(33, '1993-02-07 07:00:00', 'jutsu@capcom.com', 'Satsui', '666', 'No Hadou', '666', 'asdfghjkl', 48, 'P', 'Mr', 'ACTIVE'),
	(34, '1994-02-07 07:00:00', 'goukendojo@capcom.com', 'Ryu', '555', 'Hadouken', '5555', 'sdfsdfsdf', 49, 'P', 'Mr', 'ACTIVE'),
	(35, '1994-02-07 07:00:00', 'hfghfgh@fghfdhg.com', 'ghfgh', '56456', 'fghfgh', '45656', 'sdgfsdgdfg', 51, 'P', 'Mr', 'ACTIVE'),
	(36, '1994-02-07 07:00:00', 'hfghfgh@fghfdhg.com', 'zxc', '56456', 'fghfgh', '45656', 'sdgfsdgdfg', 52, 'P', 'Mr', 'ACTIVE'),
	(37, '1994-02-07 07:00:00', 'hfghfgh@fghfdhg.com', 'zxcvbvb', '56456', 'fghfgh', '45656', 'sdgfsdgdfg', 53, 'P', 'Mr', 'ACTIVE'),
	(38, '1994-02-07 07:00:00', 'hfghfgh@fghfdhg.com', 'qwerty', '56456', 'fghfgh', '45656', 'sdgfsdgdfg', 54, 'P', 'Mr', 'ACTIVE'),
	(39, '1994-02-07 07:00:00', 'hfghfgh@fghfdhg.com', 'zxcvbvb', '56456', 'fghfgh', '45656', 'sdgfsdgdfg', 55, 'P', 'Mr', 'ACTIVE'),
	(40, '1993-02-07 07:00:00', 'hfghfgh@fghfdhg.com', 'qwerty2', '56456', 'zxcv', '45656', 'sdgfsdgdfg', 56, 'P', 'Mr', 'ACTIVE'),
	(41, '1993-02-07 07:00:00', 'sdfsfd@dgdf.com', 'dfsf', '34545', 'sdf', '43545', 'asdasd', 57, 'P', 'Mr', 'ACTIVE'),
	(42, '1993-02-07 07:00:00', 'dfgg@fdf.com', 'dfgdfg', '6576', 'vbnb', '657', 'gfgdfgdfg', 58, 'P', 'Mr', 'ACTIVE'),
	(43, '1993-02-07 07:00:00', 'sdfsdf@cdvds.com', 'dfsgdf', '43545', 'dfgdfg', '343', 'sdfsdfsdf', 59, 'P', 'Mr', 'ACTIVE'),
	(44, '1993-02-07 07:00:00', 'sdfsdf@cdvds.com', 'dfcgfg', '456', 'dfgfdg', '54', 'dsffsdfs', 60, 'W', 'Mr', 'ACTIVE'),
	(45, '1993-02-07 07:00:00', 'dfgdfgd@dsfsdf.com', 'dumbledore', '54765', 'dfgdfg', '567567', 'sdfsdfsd', 63, 'P', 'Mr', 'ACTIVE');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- Dumping structure for table shop.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contract_length` int(11) DEFAULT NULL,
  `insurance` decimal(19,2) DEFAULT NULL,
  `employee_type` varchar(1) DEFAULT NULL,
  `work_hour` int(11) DEFAULT NULL,
  `rate_per_hour` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.employee: ~2 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `name`, `contract_length`, `insurance`, `employee_type`, `work_hour`, `rate_per_hour`) VALUES
	(3, 'goku', NULL, NULL, 'T', 5, NULL),
	(4, 'gohan', NULL, NULL, 'F', NULL, 50000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- Dumping structure for table shop.mahasiswa
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `nim` varchar(5) NOT NULL,
  `nama_depan` varchar(50) NOT NULL,
  `nama_belakang` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table shop.mahasiswa: ~2 rows (approximately)
/*!40000 ALTER TABLE `mahasiswa` DISABLE KEYS */;
INSERT INTO `mahasiswa` (`nim`, `nama_depan`, `nama_belakang`, `alamat`, `tanggal_lahir`, `tempat_lahir`) VALUES
	('002', 'Muhammad', 'Zorro', 'Pondok sangar samping rumah yonkou', '2014-10-08', 'Eastblue'),
	('12345', 'Andi', 'Malik', 'Rumah', '1989-09-09', 'Kota');
/*!40000 ALTER TABLE `mahasiswa` ENABLE KEYS */;


-- Dumping structure for table shop.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `total_amount` decimal(19,2) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `payment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC3DF62E5DC4492F4` (`customer_id`),
  KEY `FK_orders_payment_method` (`payment_id`),
  CONSTRAINT `FK_orders_payment_method` FOREIGN KEY (`payment_id`) REFERENCES `payment_method` (`id`),
  CONSTRAINT `FKC3DF62E5DC4492F4` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.orders: ~30 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `date`, `total_amount`, `customer_id`, `payment_id`) VALUES
	(1, '2014-10-08 13:48:08', 400000.00, NULL, NULL),
	(4, '2014-10-08 14:33:54', 250000.00, NULL, NULL),
	(5, '2014-10-09 14:53:15', 250000.00, NULL, NULL),
	(6, '2014-10-09 15:20:04', 250000.00, NULL, NULL),
	(16, '2014-10-10 11:18:12', 3000000.00, NULL, NULL),
	(17, '2014-10-10 11:20:34', 4000000.00, NULL, NULL),
	(18, '2014-10-10 11:21:58', 4000000.00, NULL, NULL),
	(21, '2014-10-10 13:49:45', 6000000.00, NULL, NULL),
	(22, '2014-10-10 13:50:43', 8000000.00, NULL, NULL),
	(23, '2014-10-10 14:37:34', 900000.00, NULL, NULL),
	(24, '2014-10-11 10:45:39', 0.00, NULL, NULL),
	(25, '2014-10-11 10:46:39', 0.00, NULL, NULL),
	(26, '2014-10-11 10:50:33', 0.00, NULL, NULL),
	(27, '2014-10-11 10:51:00', 0.00, NULL, NULL),
	(28, '2014-10-11 10:51:59', 0.00, NULL, NULL),
	(29, '2014-10-11 10:53:23', 0.00, NULL, NULL),
	(30, '2014-10-11 10:55:31', 0.00, NULL, NULL),
	(31, '2014-10-11 10:58:43', 0.00, NULL, NULL),
	(32, '2014-10-11 11:00:30', 0.00, NULL, NULL),
	(33, '2014-10-11 11:05:24', 0.00, NULL, NULL),
	(34, '2014-10-11 11:06:20', 0.00, NULL, NULL),
	(35, '2014-10-11 11:08:04', 0.00, NULL, NULL),
	(36, '2014-10-11 12:02:43', 0.00, NULL, NULL),
	(37, '2014-10-11 13:48:02', 0.00, NULL, NULL),
	(38, '2014-10-11 13:58:43', 3000000.00, NULL, NULL),
	(39, '2014-10-11 14:01:05', 3900000.00, NULL, NULL),
	(40, '2014-10-28 14:53:30', 1800000.00, 33, NULL),
	(41, '2014-10-28 14:55:03', 2270000.00, 33, NULL),
	(42, '2014-10-28 15:06:58', 6060000.00, 33, NULL),
	(43, '2014-10-28 15:12:47', 6060000.00, 33, NULL),
	(44, '2014-10-28 16:06:47', 1000000.00, 33, NULL),
	(45, '2014-10-28 16:17:42', 2060000.00, 33, NULL),
	(46, '2014-10-28 16:18:04', 30000.00, 33, NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


-- Dumping structure for table shop.order_detail
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `price` decimal(18,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK23AE5A62BAD74340` (`order_id`),
  KEY `FK23AE5A62D3005A20` (`product_id`),
  CONSTRAINT `FK23AE5A62BAD74340` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK23AE5A62D3005A20` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.order_detail: ~19 rows (approximately)
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`id`, `order_id`, `price`, `quantity`, `product_id`) VALUES
	(20, 21, 3000000.00, 2, 31),
	(22, 23, 450000.00, 2, 32),
	(27, 33, 3000000.00, 1, 31),
	(28, 34, 3000000.00, 4, 31),
	(29, 35, 3000000.00, 4, 31),
	(30, 36, 450000.00, 1, 32),
	(31, 36, 3000000.00, 2, 34),
	(32, 37, 3000000.00, 2, 34),
	(33, 38, 3000000.00, 1, 34),
	(34, 39, 3000000.00, 1, 34),
	(35, 39, 450000.00, 2, 32),
	(37, 40, 450000.00, 4, 32),
	(38, 41, 450000.00, 4, 32),
	(39, 41, 10000.00, 2, 35),
	(40, 41, 450000.00, 1, 32),
	(41, 42, 3000000.00, 2, 31),
	(42, 42, 30000.00, 2, 53),
	(43, 43, 3000000.00, 2, 31),
	(44, 43, 30000.00, 2, 53),
	(45, 44, 500000.00, 2, 33),
	(46, 45, 500000.00, 2, 37),
	(47, 45, 500000.00, 2, 33),
	(48, 45, 20000.00, 3, 38),
	(49, 46, 10000.00, 3, 35);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;


-- Dumping structure for table shop.payment_method
CREATE TABLE IF NOT EXISTS `payment_method` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.payment_method: ~6 rows (approximately)
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` (`id`, `name`) VALUES
	(1, 'Transfer via ATM'),
	(2, 'Transfer via Bluetooth'),
	(3, 'Ngutang modal ganteng'),
	(29, 'via Merpati Balap Jantan'),
	(30, 'via telepati'),
	(31, 'via teleport');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;


-- Dumping structure for table shop.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(18,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8DCCEF806DFEF4` (`category_id`),
  KEY `FKED8DCCEFA1722434` (`supplier_id`),
  CONSTRAINT `FKED8DCCEF806DFEF4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKED8DCCEFA1722434` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.product: ~17 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `description`, `name`, `price`, `stock`, `category_id`, `supplier_id`) VALUES
	(31, 'an iPad Mini', 'iPad Mini', 3000000.00, 20, 26, 1),
	(32, 'Anti shit', 'Swallow e-watch', 450000.00, 100, 28, 4),
	(33, 'Like an Iphone', 'Xiaomi mi3', 500000.00, 100, 26, 1),
	(34, 'the', 'Mizu', 3000000.00, 50, 26, 3),
	(35, 'zxxzc', 'Piero', 10000.00, 100, 1, 2),
	(36, 'bukan kw tampur', 'Adidas', 100000.00, 50, 1, 4),
	(37, 'Grade Ori', 'Nike', 500000.00, 100, 1, 8),
	(38, 'Buku Cerita Horor', 'Hantu Bohongan', 20000.00, 100, 23, 8),
	(39, 'Buku Cerita Mistis', 'Hantu Beneran', 40000.00, 100, 23, 8),
	(40, 'Kekerasan', 'GTA Jababeka city', 20000.00, 100, 2, 8),
	(45, 'Laptop sebesar keset', 'Platinum', 10000000.00, 100, 27, 5),
	(47, 'Radio yang punya button', 'Radio Button', 50000.00, 50, 6, 8),
	(49, 'google', 'Nexus 5', 200000.00, 100, 26, 7),
	(50, 'Novel worst seller', 'Harry Boker The prince of caravan', 50000.00, 50, 2, 8),
	(51, 'Novel, better than the first book', 'Harry Boker The Deathly Aloha', 65000.00, 50, 2, 8),
	(52, 'Novel, a sad story of a single witch', 'Harry Boker Forever Alone', 50000.00, 50, 2, 8),
	(53, 'Rak buku egois', 'Booker selfish', 30000.00, 50, 25, 8);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Dumping structure for table shop.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table shop.supplier: ~8 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `name`) VALUES
	(1, 'Apple'),
	(2, 'Lenovo'),
	(3, 'Samsung'),
	(4, 'PT. Swallow Jaya Abadi'),
	(5, 'Microsoft'),
	(6, 'Xiaomi'),
	(7, 'LG'),
	(8, 'PT. Apa Saja');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- Dumping structure for table shop.supplier_category
CREATE TABLE IF NOT EXISTS `supplier_category` (
  `supplier_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`supplier_id`,`category_id`),
  KEY `FKCB7A3A11806DFEF4` (`category_id`),
  KEY `FKCB7A3A11A1722434` (`supplier_id`),
  CONSTRAINT `FKCB7A3A11806DFEF4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKCB7A3A11A1722434` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table shop.supplier_category: ~6 rows (approximately)
/*!40000 ALTER TABLE `supplier_category` DISABLE KEYS */;
INSERT INTO `supplier_category` (`supplier_id`, `category_id`) VALUES
	(1, 26),
	(2, 26),
	(3, 26),
	(1, 27),
	(2, 27),
	(4, 28);
/*!40000 ALTER TABLE `supplier_category` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
