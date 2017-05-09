
CREATE TABLE `maoyan_city` (
  `id` int(11) NOT NULL COMMENT '\u57ce\u5e02id',
  `name` varchar(16) NOT NULL COMMENT '\u57ce\u5e02\u540d\u79f0',
  `pinyin` varchar(32) NOT NULL COMMENT '\u57ce\u5e02\u62fc\u97f3',
  `online_time` int(11) NOT NULL COMMENT '\u4e0a\u7ebf\u65f6\u95f4',
  `rank` varchar(8) NOT NULL COMMENT '\u6392\u5e8f',
  `open` varchar(8) DEFAULT NULL COMMENT '\u662f\u5426\u652f\u6301',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='\u732b\u773c\u57ce\u5e02';

CREATE TABLE `maoyan_cinema` (
  `id` int(11) NOT NULL COMMENT '\u5f71\u9662id',
  `nm` varchar(32) NOT NULL COMMENT '\u5f71\u9662\u540d\u79f0',
  `addr` varchar(64) NOT NULL COMMENT '\u5f71\u9662\u5730\u5740',
  `lat` double DEFAULT NULL COMMENT '\u7ef4\u5ea6',
  `lng` double DEFAULT NULL COMMENT '\u7ecf\u5ea6',
  `area` varchar(16) DEFAULT NULL COMMENT '\u533a\u57df',
  `deal` int(11) DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  `sell` int(11) DEFAULT NULL,
  `sell_price` double DEFAULT NULL,
  `imax` int(11) DEFAULT NULL,
  `sellmin` int(11) DEFAULT NULL,
  `deal_price` double DEFAULT NULL,
  `follow` int(11) DEFAULT NULL,
  `dis` varchar(64) DEFAULT NULL,
  `preferential` double DEFAULT NULL,
  `ct` varchar(16) DEFAULT NULL,
  `reference_price` double DEFAULT NULL,
  `show_count` int(11) DEFAULT NULL,
  `brd` varchar(64) DEFAULT NULL COMMENT '\u5f71\u57ce\u540d\u79f0',
  `brd_id` int(11) DEFAULT NULL COMMENT '\u5f71\u57ceid',
  `poi_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='\u732b\u773c\u5f71\u9662';


CREATE TABLE `maoyan_movie_show` (
  `show_id` int(11) NOT NULL COMMENT '\u653e\u6620id',
  `show_date` varchar(16) DEFAULT NULL COMMENT '\u653e\u6620\u65e5\u671f',
  `dt` varchar(16) DEFAULT NULL COMMENT '\u653e\u6620\u65e5\u671f',
  `tm` varchar(16) DEFAULT NULL COMMENT '\u5f00\u59cb\u65f6\u95f4',
  `end` varchar(16) DEFAULT NULL COMMENT '\u7ed3\u675f\u65f6\u95f4',
  `preferential` int(11) DEFAULT NULL,
  `sell` int(11) DEFAULT NULL COMMENT '\u662f\u5426\u51fa\u552e',
  `tp` varchar(16) DEFAULT NULL,
  `lang` varchar(16) DEFAULT NULL COMMENT '\u8bed\u8a00',
  `embed` int(11) DEFAULT NULL,
  `gray_desc` varchar(32) DEFAULT NULL,
  `seat_status` int(11) DEFAULT NULL,
  `is_morrow` int(11) DEFAULT NULL,
  `th` varchar(16) DEFAULT NULL,
  `sell_pr_str` varchar(128) DEFAULT NULL,
  `pr_str` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='\u653e\u6620\u4fe1\u606f'
