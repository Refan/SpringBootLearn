-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- 主機: localhost
-- 產生時間： 2018 年 05 月 02 日 09:57
-- 伺服器版本: 5.7.20
-- PHP 版本： 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `test`
--

-- --------------------------------------------------------

--
-- 資料表結構 `account`
--

CREATE TABLE `account` (
  `id` int(10) NOT NULL,
  `username` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ac_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `role`, `ac_id`) VALUES
(1, 'admin', 'test', 'S', 1),
(2, 'client', 'test', 'C', 2);

-- --------------------------------------------------------

--
-- 資料表結構 `accountM`
--

CREATE TABLE `accountM` (
  `ac_id` int(11) NOT NULL,
  `userId` varchar(16) COLLATE utf8_unicode_ci NOT NULL COMMENT '關聯財務ID',
  `payPwd` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '支付密碼',
  `count` int(14) NOT NULL DEFAULT '0' COMMENT '平台利潤餘額 '
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='財務帳號表';

--
-- 資料表的匯出資料 `accountM`
--

INSERT INTO `accountM` (`ac_id`, `userId`, `payPwd`, `count`) VALUES
(1, 'M000000014731', 'test', 0),
(2, 'M000000025519', '245', 0);

-- --------------------------------------------------------

--
-- 資料表結構 `logRecord`
--

CREATE TABLE `logRecord` (
  `id` int(10) NOT NULL COMMENT '流水號',
  `tables` text COLLATE utf8_unicode_ci COMMENT '資料表名稱',
  `action` text COLLATE utf8_unicode_ci COMMENT '動作,新增C,讀取R,修改U,刪除D,系統S',
  `valueBefore` text COLLATE utf8_unicode_ci COMMENT '變更前資料，連結',
  `valueAfter` text COLLATE utf8_unicode_ci COMMENT '變更後資料',
  `creater` varchar(16) COLLATE utf8_unicode_ci NOT NULL COMMENT '變更人',
  `createDate` varchar(14) COLLATE utf8_unicode_ci NOT NULL COMMENT '變更時間'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Log紀錄表';

--
-- 資料表的匯出資料 `logRecord`
--

INSERT INTO `logRecord` (`id`, `tables`, `action`, `valueBefore`, `valueAfter`, `creater`, `createDate`) VALUES
(8998, 'account', 'U', 'AccountModel{id=102, userId=\'M000000014731\', level=\'M\', status=1, spName=\'Kiz測試\', eMail=\'kiz7386@gmail.com\', loginPw=\'1qazxsw2\', payPw=\'null\', resetPwdDate=\'null\', resetPwdKey=\'null\', loginIp=\'null\', lastLoginIp=\'\', lastLoginDate=\'\', creater=\'null\', createDate=\'20180221114740\', modifyDate=\'20180221114740\'}', 'AccountModel{id=102, userId=\'M000000014731\', level=\'M\', status=2, spName=\'Kiz測試\', eMail=\'kiz7386@gmail.com\', loginPw=\'1qazxsw2\', payPw=\'null\', resetPwdDate=\'null\', resetPwdKey=\'null\', loginIp=\'null\', lastLoginIp=\'\', lastLoginDate=\'\', creater=\'null\', createDate=\'20180221114740\', modifyDate=\'20180221114748\'}', 'admin', '20180221114748'),
(8999, 'accountM', 'U', 'AccountMModel{userId=\'M000000014731\', payPwd=\'1qazxsw2\', count=0}', 'AccountMModel{userId=\'M000000014731\', payPwd=\'1qazxsw2\', count=0}', 'admin', '20180221114748');

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `accountM`
--
ALTER TABLE `accountM`
  ADD PRIMARY KEY (`ac_id`);

--
-- 資料表索引 `logRecord`
--
ALTER TABLE `logRecord`
  ADD PRIMARY KEY (`id`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `account`
--
ALTER TABLE `account`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用資料表 AUTO_INCREMENT `accountM`
--
ALTER TABLE `accountM`
  MODIFY `ac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用資料表 AUTO_INCREMENT `logRecord`
--
ALTER TABLE `logRecord`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '流水號', AUTO_INCREMENT=9000;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
