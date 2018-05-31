/*
Navicat MySQL Data Transfer

Source Server         : leif-liu
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : online-student-union-management-system

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2018-06-01 02:53:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL auto_increment,
  `activity_name` varchar(255) NOT NULL,
  `activity_date` varchar(255) NOT NULL,
  `activity_place` varchar(255) NOT NULL,
  `status` int(11) NOT NULL COMMENT '1：未办；2：已办；0：过期',
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', 'asdf', '2018-03-08 04:05', 'asdf', '0', '2018-03-20 20:12:57', '刘镔琛', '2018-03-20 20:12:57', '刘镔琛');
INSERT INTO `activity` VALUES ('2', 'asdf', '2018-03-08 04:05', 'asdf', '0', '2018-03-20 20:12:57', '刘镔琛', '2018-03-20 20:12:57', '刘镔琛');
INSERT INTO `activity` VALUES ('5', 'asdf', '2018-01-01 00:00', 'asdf', '2', '2018-03-20 23:18:05', '刘镔琛', '2018-03-20 23:18:05', '刘镔琛');
INSERT INTO `activity` VALUES ('6', 'gll', '2019-06-12 10:00', 'sh', '0', '2018-03-21 15:53:35', '刘镔琛', '2018-04-28 01:36:44', '刘镔琛');
INSERT INTO `activity` VALUES ('8', 'asdf', '2018-03-06 22:02', 'asdf', '0', '2018-03-22 23:14:23', '刘镔琛', '2018-04-11 21:34:48', '刘镔琛');
INSERT INTO `activity` VALUES ('9', 'q', '2018-03-07 04:04', 'asdf', '0', '2018-03-22 23:17:13', '刘镔琛', '2018-03-24 18:34:13', '刘镔琛');
INSERT INTO `activity` VALUES ('10', 'ASDF', '2018-02-27 03:03', 'ASDF', '2', '2018-03-23 00:15:48', '刘镔琛', '2018-03-23 00:15:48', '刘镔琛');
INSERT INTO `activity` VALUES ('12', 'asdf', '0006-02-22 22:02', 'asdf', '2', '2018-03-23 01:27:03', '刘镔琛', '2018-03-23 12:21:36', '刘镔琛');
INSERT INTO `activity` VALUES ('13', 'qq', '2018-03-07 04:04', 'd', '0', '2018-03-24 18:01:17', '刘镔琛', '2018-03-24 18:01:17', '刘镔琛');
INSERT INTO `activity` VALUES ('14', 'ad', '2018-03-07 03:03', 'fd', '2', '2018-03-24 18:29:14', '刘镔琛', '2018-03-24 18:29:14', '刘镔琛');
INSERT INTO `activity` VALUES ('15', 'q', '2018-03-01 03:03', 'd', '2', '2018-03-24 18:30:48', '刘镔琛', '2018-03-24 18:30:48', '刘镔琛');
INSERT INTO `activity` VALUES ('16', '1', '2018-02-27 11:01', '1', '2', '2018-03-24 18:35:35', '刘镔琛', '2018-03-24 18:35:35', '刘镔琛');
INSERT INTO `activity` VALUES ('17', '2', '0002-03-01 22:02', '2', '0', '2018-03-24 18:35:46', '刘镔琛', '2018-04-29 03:24:09', '刘镔琛');
INSERT INTO `activity` VALUES ('22', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '2018-06-30 07:07', 'ghj', '0', '2018-03-24 18:37:16', '刘镔琛', '2018-03-30 18:56:59', '刘镔琛');
INSERT INTO `activity` VALUES ('24', '官方还是', '2018-03-07 06:05', '湿度调节', '0', '2018-03-25 20:36:25', '刘镔琛', '2018-03-25 20:36:25', '刘镔琛');
INSERT INTO `activity` VALUES ('25', '十六字换行···', '2019-03-08 03:43', '十六字换行···', '0', '2018-03-25 20:49:54', '刘镔琛', '2018-04-28 01:36:44', '刘镔琛');
INSERT INTO `activity` VALUES ('28', '阿斯蒂芬', '2017-03-30 03:03', '阿凡达斯', '2', '2018-03-30 18:58:15', '刘镔琛', '2018-03-30 18:58:15', '刘镔琛');
INSERT INTO `activity` VALUES ('29', 'afds', '2018-02-27 03:03', '啊范德萨斯蒂芬', '2', '2018-03-30 21:47:01', '刘镔琛', '2018-03-30 21:47:01', '刘镔琛');
INSERT INTO `activity` VALUES ('30', 'asdf', '2018-02-27 03:03', 'asdf', '2', '2018-03-30 21:47:30', '刘镔琛', '2018-03-30 21:47:30', '刘镔琛');
INSERT INTO `activity` VALUES ('31', '大设计师李雪婵', '2018-03-30 23:00', '美国加州伯克利', '0', '2018-03-30 23:09:16', '刘镔琛', '2018-04-09 23:09:31', '刘镔琛');
INSERT INTO `activity` VALUES ('32', 'adsf', '2018-04-02 04:04', 'asdf', '0', '2018-04-02 18:06:28', '刘镔琛', '2018-04-02 18:06:28', '刘镔琛');
INSERT INTO `activity` VALUES ('33', 'adsf', '2018-07-21 03:03', 'adsf', '0', '2018-04-02 19:14:48', '刘镔琛', '2018-04-02 21:48:29', '刘镔琛');
INSERT INTO `activity` VALUES ('36', 'test1', '2018-04-15 03:03', 'asdf', '0', '2018-04-09 14:54:21', '刘镔琛', '2018-04-09 14:54:21', '刘镔琛');
INSERT INTO `activity` VALUES ('38', '阿斯蒂芬', '2018-04-21 04:04', 'asdf', '0', '2018-04-08 22:42:53', '刘镔琛', '2018-04-28 02:02:45', '刘镔琛');
INSERT INTO `activity` VALUES ('39', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '0', '2018-04-10 20:17:50', '刘镔琛', '2018-04-28 01:29:43', '刘镔琛');
INSERT INTO `activity` VALUES ('40', '阿斯蒂芬123asdf123ASD', '0035-04-22 04:53', '啊苏打粉', '2', '2018-04-10 20:19:38', '刘镔琛', '2018-04-10 21:28:15', '刘镔琛');
INSERT INTO `activity` VALUES ('41', '阿斯蒂芬123asdf123ASD', '0035-04-22 04:53', '啊苏打粉', '2', '2018-04-10 20:19:38', '刘镔琛', '2018-04-10 21:32:36', '刘镔琛');
INSERT INTO `activity` VALUES ('44', 'adsf', '2019-04-07 03:03', 'adsf', '0', '2018-04-07 22:58:42', '刘镔琛', '2018-04-28 01:31:55', '刘镔琛');
INSERT INTO `activity` VALUES ('45', 'te', '2018-04-20 03:03', 'te', '2', '2018-04-18 14:07:37', '刘镔琛', '2018-04-18 14:07:37', '刘镔琛');
INSERT INTO `activity` VALUES ('46', 'qqqq', '2018-04-08 22:02', 'q', '2', '2018-04-08 20:58:39', '刘镔琛', '2018-04-18 22:41:06', '刘镔琛');
INSERT INTO `activity` VALUES ('47', '阿斯蒂芬', '2018-04-08 03:03', 'asdf', '2', '2018-04-08 22:57:47', '刘镔琛', '2018-04-18 22:55:47', '刘镔琛');
INSERT INTO `activity` VALUES ('48', '活动名称', '2018-04-26 03:03', '活动地点：', '0', '2018-04-09 15:48:35', '刘镔琛', '2018-04-28 01:39:33', '刘镔琛');
INSERT INTO `activity` VALUES ('49', 'asfdas', '2018-04-20 03:03', 'sadf', '0', '2018-04-27 20:31:19', '刘镔琛', '2018-05-18 22:16:45', 'leif');
INSERT INTO `activity` VALUES ('50', 'asdfas', '2018-04-12 03:03', 'asdf', '2', '2018-04-26 00:57:54', '刘镔琛', '2018-04-27 20:32:41', '刘镔琛');
INSERT INTO `activity` VALUES ('51', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '0', '2018-04-28 01:40:04', '刘镔琛', '2018-04-28 01:43:28', '刘镔琛');
INSERT INTO `activity` VALUES ('52', '阿斯蒂芬', '2018-04-21 04:04', 'asdf', '0', '2018-04-28 01:40:31', '刘镔琛', '2018-05-18 22:14:13', 'leif');
INSERT INTO `activity` VALUES ('53', '阿斯蒂芬', '2018-04-21 04:04', 'asdf', '0', '2018-04-28 01:40:39', '刘镔琛', '2018-04-28 02:02:55', '刘镔琛');
INSERT INTO `activity` VALUES ('54', '十六字换行···', '2019-03-08 03:43', '十六字换行···', '0', '2018-04-28 01:41:12', '刘镔琛', '2018-04-28 01:43:28', '刘镔琛');
INSERT INTO `activity` VALUES ('55', '阿斯蒂芬', '2018-05-05 04:04', 'asdf', '0', '2018-04-28 01:41:36', '刘镔琛', '2018-04-28 01:42:57', '刘镔琛');
INSERT INTO `activity` VALUES ('56', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '1', '2018-04-28 01:43:35', '刘镔琛', '2018-04-28 01:43:35', '刘镔琛');
INSERT INTO `activity` VALUES ('57', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '0', '2018-04-28 01:43:42', '刘镔琛', '2018-04-28 01:53:38', '刘镔琛');
INSERT INTO `activity` VALUES ('58', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '1', '2018-04-28 01:43:48', '刘镔琛', '2018-04-28 01:58:59', '刘镔琛');
INSERT INTO `activity` VALUES ('59', '我在这里等你', '2019-06-17 08:00', '体育场', '0', '2018-04-28 01:43:53', '刘镔琛', '2018-05-18 22:07:38', 'leif');
INSERT INTO `activity` VALUES ('61', '我在这里等你', '2019-06-17 08:00', '体育场', '0', '2018-04-28 01:59:49', '刘镔琛', '2018-05-18 22:07:38', 'leif');
INSERT INTO `activity` VALUES ('62', '我在这里等你', '2019-06-17 08:00', '体育场', '1', '2018-04-28 01:59:49', '刘镔琛', '2018-04-28 01:59:49', '刘镔琛');
INSERT INTO `activity` VALUES ('64', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '1', '2018-04-28 02:00:00', '刘镔琛', '2018-04-28 02:00:00', '刘镔琛');
INSERT INTO `activity` VALUES ('65', '阿斯蒂芬', '2018-04-21 04:04', 'asdf', '2', '2018-04-28 02:02:16', '刘镔琛', '2018-04-28 02:02:16', '刘镔琛');
INSERT INTO `activity` VALUES ('66', '阿斯蒂芬', '2018-04-21 04:04', 'asdf', '2', '2018-04-28 02:02:29', '刘镔琛', '2018-04-28 02:02:29', '刘镔琛');
INSERT INTO `activity` VALUES ('67', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '1', '2018-04-28 02:04:47', '刘镔琛', '2018-04-28 02:04:47', '刘镔琛');
INSERT INTO `activity` VALUES ('68', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '1', '2018-04-28 02:04:47', '刘镔琛', '2018-04-28 02:04:47', '刘镔琛');
INSERT INTO `activity` VALUES ('69', 'asdf', '2021-06-15 04:43', 'asdfsadfasdfasdf', '1', '2018-04-28 02:05:08', '刘镔琛', '2018-04-28 02:05:08', '刘镔琛');
INSERT INTO `activity` VALUES ('70', '的萨芬 sd', '2018-04-22 03:03', '说的按时', '0', '2018-04-28 21:26:08', '刘镔琛', '2018-05-18 22:08:04', 'leif');
INSERT INTO `activity` VALUES ('71', 'asdfasdfaasdfasdfasdfasdf', '2018-04-14 03:03', '射点发撒打发斯蒂芬撒地方', '2', '2018-04-27 23:31:50', '刘镔琛', '2018-04-28 22:22:41', '刘镔琛');
INSERT INTO `activity` VALUES ('72', ' 阿萨德发', '3333-04-29 04:04', '啊sdf', '1', '2018-04-28 21:24:43', '刘镔琛', '2018-05-18 22:06:08', 'leif');
INSERT INTO `activity` VALUES ('73', 'asd', '2018-05-06 04:04', ' 阿斯蒂芬', '2', '2018-04-30 16:24:08', '楚子航', '2018-04-30 16:25:53', '刘镔琛');
INSERT INTO `activity` VALUES ('74', 'afds', '2018-04-19 04:04', 'afdsafsdafsdasdfsfdafdas', '2', '2018-04-30 16:26:48', '耿乐乐', '2018-04-30 16:26:54', '耿乐乐');
INSERT INTO `activity` VALUES ('75', 'afds', '2018-05-01 04:04', 'adfs', '0', '2018-05-01 06:53:55', '沧月', '2018-05-18 22:14:13', 'leif');
INSERT INTO `activity` VALUES ('76', 'adsf', '2018-05-19 04:04', 'afds', '2', '2018-05-01 06:54:42', '沧月', '2018-05-01 06:54:47', '沧月');
INSERT INTO `activity` VALUES ('78', 'test1', '2018-05-10 03:03', '阿斯蒂芬', '0', '2018-05-14 07:35:12', '沧月', '2018-05-18 22:06:33', 'leif');
INSERT INTO `activity` VALUES ('79', '团委老师', '3333-05-18 03:03', '团委老师', '1', '2018-05-18 22:05:49', 'leif', '2018-05-18 22:05:49', 'leif');
INSERT INTO `activity` VALUES ('80', 'test1', '2222-05-10 03:03', '阿斯蒂芬', '1', '2018-05-18 22:06:23', 'leif', '2018-05-18 22:06:23', 'leif');
INSERT INTO `activity` VALUES ('81', '我在这里等你发', '2019-06-17 08:00', '体育场', '1', '2018-05-18 22:06:49', 'leif', '2018-05-18 22:06:49', 'leif');
INSERT INTO `activity` VALUES ('82', 'adsf', '2018-05-18 03:03', 'asdf', '2', '2018-05-04 17:11:59', '沧月', '2018-05-18 22:19:08', 'leif');
INSERT INTO `activity` VALUES ('83', '团委老师', '2018-05-18 03:03', '团委老师', '2', '2018-05-18 22:18:02', 'leif', '2018-05-18 22:19:15', 'leif');
INSERT INTO `activity` VALUES ('84', 'plan/information/active/37', '2018-05-16 03:03', 'plan/information/active/37', '2', '2018-05-18 22:22:18', 'leif', '2018-05-18 22:23:24', 'leif');
INSERT INTO `activity` VALUES ('85', '副主席', '2018-05-17 03:03', '副主席', '2', '2018-05-19 19:40:40', '飞蓬', '2018-05-19 19:41:07', '飞蓬');
INSERT INTO `activity` VALUES ('86', '副主席', '2018-05-04 03:03', '副主席', '2', '2018-05-19 19:42:00', '飞蓬', '2018-05-19 19:42:06', '飞蓬');
INSERT INTO `activity` VALUES ('87', '爱的方式', '2018-05-25 03:03', '撒旦法', '2', '2018-05-19 19:39:08', 'leif', '2018-05-19 19:42:25', '沧月');
INSERT INTO `activity` VALUES ('88', '爱的方式', '2018-05-25 03:03', '撒旦法', '2', '2018-05-19 19:39:26', 'leif', '2018-05-19 19:45:19', '飞蓬');
INSERT INTO `activity` VALUES ('89', 'aaa', '2018-04-29 04:04', 'a', '2', '2018-04-07 23:00:04', '刘镔琛', '2018-05-21 21:11:42', '刘镔琛');
INSERT INTO `activity` VALUES ('90', 'afds', '0003-05-16 03:03', '撒旦法', '2', '2018-05-21 21:12:41', '刘镔琛', '2018-05-21 21:12:45', '刘镔琛');
INSERT INTO `activity` VALUES ('91', 'dsaf', '0033-05-10 03:03', 'sadf', '2', '2018-05-19 20:40:38', '零', '2018-05-21 21:14:28', '刘镔琛');
INSERT INTO `activity` VALUES ('92', 'dfs', '2018-05-24 05:05', '阿斯蒂芬', '2', '2018-05-25 20:59:14', '刘镔琛', '2018-05-28 00:31:26', '沧月');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) unsigned zerofill NOT NULL auto_increment,
  `department_name` varchar(255) NOT NULL,
  `introduction` varchar(255) default NULL,
  `people_number` int(11) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('00000000000', '学生会', '《中华全国学生联合会章程》指出，学生会的基本任务包括：遵循和贯彻党的教育方针，组织同学开展各项活动，促进同学全面发展；协助学校建设良好的教学秩序和学习、生活环境；帮助同学解决实际问题；沟通学校党政与广大同学的联系，维护同学正当权益。华北水利水电大学软件学院学生会根据自身情况，秉承为同学全心全意服务的中心思想，以“自我服务、自我管理、自我教育、自我监督”为行动准则，致力于团结各学院学生会，协调学院各项学生工作，倡导广大同学爱国爱校，以服务于同学的成长、成才为宗旨，努力丰富南华学生的课余生活。', '1', '2018-03-20 23:18:05', 'leif', '2018-05-19 20:02:13', '飞蓬');
INSERT INTO `department` VALUES ('00000000001', '主席团', '主席团作为学生会的最高领导和协调机构，直接领导学生会下属行政部门和职能部门。\n负责在全院范围内领导和主持学生会日常工作，依据实际情况以及院党团委的指示精神，从整体上把握学生会工作动态并对各部门工作计划进行统筹、安排、监督以及协调。', '10', '2018-03-20 23:18:05', 'leif', '2018-05-19 19:51:31', '飞蓬');
INSERT INTO `department` VALUES ('00000000002', '秘书处', '主席团直属部门，是为选举下一届学生会主席部长团成员而生的', '1', '2018-03-20 23:18:05', 'leif', '2018-04-30 18:42:25', '刘镔琛');
INSERT INTO `department` VALUES ('00000000003', '办公室', '负责学生会的会务安排、制度管理、考核材料收集及各项工作文件报告撰写等相关事务。\n负责学生会的预算、决算、记账、报账，物资管理等事宜。\n负责检查并监督各班级活动出勤及校园风气建设等情况，面向全院宣传考风考纪，加强学院考风考纪建设，并监督学生干部的工作、学习、纪律、作风等方面的问题。', '14', '2018-03-20 23:18:05', 'leif', '2018-05-27 16:50:55', '刘镔琛');
INSERT INTO `department` VALUES ('00000000004', '提案调研部', '负责收集整理同学们对学校各方面管理的意见和建议，与各基层组织保持紧密联系，把同学们遇到的困难上报学校有关部门，督促相关部门为同学们解决困难，并将结果及时反馈给同学，在日常生活中切实维护同学们的正当权益，是方便同学们参与学校管理的合法渠道。\n负责软件学院学生手册的编辑制作。', '14', '2018-03-20 23:18:05', 'leif', '2018-04-26 14:15:46', '刘镔琛');
INSERT INTO `department` VALUES ('00000000005', '组织部', '负责学生会的档案管理。\n负责协助团委加强全院共青团思想建设及共青团干部的培养和管理，督促检查各年级团总支及各班团支部组织团学工作开展情况，协助团委做好“优秀团员”等评优评先以及“推优”等工作。', '9', '2018-03-20 23:18:05', 'leif', '2018-05-27 16:51:10', '刘镔琛');
INSERT INTO `department` VALUES ('00000000006', '新媒体宣传部', '负责对学院各种活动进行拍照摄影及制作各类海报，为各类活动进行前期、后期宣传，定期举办宣传技能培训，提高同学们宣传工作方面的水平。\n负责及时、有效、全面的进行对内的信息收集、整理和对外的信息发布，为学院各种活动撰写新闻稿，管理和维护官方微信、微博，及时发布院内外各种讯息。', '21', '2018-03-20 23:18:05', 'leif', '2018-05-27 16:51:17', '刘镔琛');
INSERT INTO `department` VALUES ('00000000007', '学习部', '负责全院学生的课堂考勤，每周向学院领导老师汇报各班级出勤情况并上交出勤率。\n负责承担校园学生学术文化建设，根据同学们求知成才的要求，规划和组织学习竞赛、知识讲座等各种学术科技活动，促进浓厚的校园学习氛围的形成。', '15', '2018-03-20 23:18:05', 'leif', '2018-04-28 02:51:01', '刘镔琛');
INSERT INTO `department` VALUES ('00000000008', '创新创业部', '负责营造我院浓郁的学术氛围，倡导优良学风，构建以“学术、文化、科技、创新、创业、就业”为主题的校园文化，推动科技创新创业意识的普及。\n负责以开展科研成果展、创新创业大赛、科技大赛等形式为广大学生提供交流平台，积极探索大学生就业过程中存在的问题，开展有利于提高大学生综合素质和专业技能的活动，改变大学生的就业观念，推动创业意识形成。', '3', '2018-03-20 23:18:05', 'leif', '2018-04-26 01:21:15', '刘镔琛');
INSERT INTO `department` VALUES ('00000000009', '文艺部', '负责计划、组织、协调我院文艺和文化活动，为同学们提供展示艺术才能的舞台，发动和组织同学们参加课余文艺活动，陶冶情操，提高全院学生的艺术修养，并在此过程中发现和培养我院的文艺活跃分子，充分发挥文艺骨干作用，提高同学们文艺欣赏能力，促进健康向上的文化活动发展。', '4', '2018-03-20 23:18:05', 'leif', '2018-04-26 01:21:24', '刘镔琛');
INSERT INTO `department` VALUES ('00000000010', '体育部', '负责组织和管理学生体育活动，配合学校的体育工作，反应同学们的意愿和要求，促进校园体育工作的进步和同学们身体素质的提高，并通过组织很多的趣味性质的体育活动从整体上调动同学们的积极性，同时在工作中不断发现各类体育人才，为我院的体育事业打下坚实的储备。', '3', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `department` VALUES ('00000000011', '生活权益部', '（下设礼仪队）\n负责协助同学们创造良好的寝室安全卫生条件，构建和谐融洽的校园寝室文化，保障同学们在校期间衣食住行等多方面切身权益。\n负责培训、管理学生会礼仪队，专司各种重大活动的礼仪事宜。', '3', '2018-03-20 23:18:05', 'leif', '2018-05-14 13:22:30', '刘镔琛');
INSERT INTO `department` VALUES ('00000000012', '外联部', '负责为学生会和学生活动筹集资金，同时兼有联系各高校院系学生组织，促进彼此之间交流的职能。', '3', '2018-03-20 23:18:05', 'leif', '2018-05-14 13:22:46', '刘镔琛');
INSERT INTO `department` VALUES ('00000000013', '社会实践部', '负责引导大学生走向社会，在校内外组织开展各种社会实践活动，为大家提供接触社会、服务社会的机会。\n负责协助、指导院青年志愿者协会在校内外开展一系列志愿服务活动，组织开展我院社会实践工作。', '3', '2018-03-20 23:18:05', 'leif', '2018-04-26 01:22:05', '刘镔琛');

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL auto_increment,
  `feedback_content` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '阿斯蒂芬', '学习', '2018-05-14 01:10:14');
INSERT INTO `feedback` VALUES ('7', '发大水', '活动', '2018-05-14 02:58:35');
INSERT INTO `feedback` VALUES ('8', '发斯蒂芬', '建议', '2018-05-14 02:58:40');
INSERT INTO `feedback` VALUES ('9', '阿斯蒂芬', '其它', '2018-05-14 02:58:45');
INSERT INTO `feedback` VALUES ('10', '的萨芬', '建议', '2018-05-14 03:04:47');
INSERT INTO `feedback` VALUES ('11', '寝室厕所灯不亮', '生活', '2018-05-28 00:24:36');

-- ----------------------------
-- Table structure for `indexs`
-- ----------------------------
DROP TABLE IF EXISTS `indexs`;
CREATE TABLE `indexs` (
  `id` int(11) NOT NULL auto_increment,
  `indexs_name` varchar(255) NOT NULL,
  `content` text,
  `type` varchar(255) NOT NULL,
  `attachment` varchar(255) default NULL,
  `suffix` varchar(255) default NULL,
  `status` int(11) NOT NULL COMMENT '1：申请；2：通过',
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indexs
-- ----------------------------
INSERT INTO `indexs` VALUES ('3', '华北水利水电大学软件学院学生会招新报名表', '参加面试时请携带两份纸质报名表，祝大家面试顺利！', '通知公告', '华北水利水电大学软件学院学生会招新报名表', '.docx', '2', '2018-05-28 00:18:11', '沧月', '2018-05-28 00:18:22', '沧月');
INSERT INTO `indexs` VALUES ('4', '欢迎“小石器”回家', '        又到了九月开学季，早秋的风似乎还留恋夏天的艳阳，热烈的气氛让天气也显得有些略微燥热起来。而来自全国各地的新生学子们并没有因此懈怠，早早地就来到学院报道，准备迎接属于他们的大学新生活。恰同学少年，风华正茂，书生意气，挥斥方遒。\r\n        在周末的早上六点钟，学生会的干部和志愿者们就已经来到文体中心前进行迎新布置和安排，为确保新生顺利办理各项手续，我院采取一站式服务，新生报到确认、校园卡领取及使用说明、缴费情况确认和住宿通知单领取，一站式服务简化了入学手续，为广大新生报到带来了极大的便利。同时还专设了家长休息处和饮水处，并为学生家长提供接送行李服务。对于贫困新生，我院继续开辟“绿色通道”,通过申请国家助学贷款等方式，帮助新生解决资金困难问题。我院各级学生干部及志愿者积极投入到迎新工作中，各司其职，各尽其力，有条不紊的开展各项工作和活动。\r\n        为了确保新生报道顺利，学院党委副书记刘建厅老师也亲临现场指导，各年辅导员老师也全程陪同作为指引辅助，使迎新工作开展更加的圆满。\r\n        下午为了增进新生和家长对学院的了解，学院组织了家长座谈会，座谈会上向新生及家长们介绍了学院的基本情况，师资力量和专业设置概况，也对新生提出了大学四年生活的希望和要求，希望新生们能够加强自我约束能力，减少对父母的依赖，能够独立的去应对新阶段里的各种事情，从而真正实现从一个懵懂少年到具备时代发展要求的优秀大学生的完美蜕变。\r\n        各位新生来到大学初始之际，老师以及学长学姐用微笑温暖他们，让他们感觉离开家来求学的心并不孤单；用热情感染他们，让他们感受到大学的生活是如此的丰富多彩，活力四射；耐心的帮助他们，让他们能够尽快熟悉学院的一切。愿他们能迅速适应大学生活，开拓属于自己的一片蓝天。', '新闻中心', '640 (2)', '.jpg', '2', '2018-05-28 00:20:45', '沧月', '2018-05-28 00:20:57', '沧月');
INSERT INTO `indexs` VALUES ('5', '新一届华北水利水电大学软件学院学生会学生干部名单公示表', '', '通知公告', '新一届华北水利水电大学软件学院学生会学生干部名单公示表', '.xlsx', '2', '2018-05-31 21:54:19', '刘镔琛', '2018-05-31 21:54:30', '刘镔琛');
INSERT INTO `indexs` VALUES ('6', '华北水利水电大学软件学院学生会', '下设主席团、秘书处、办公室、提案调研部、组织部、新媒体宣传部、学习部、创新创业部、文艺部、体育部、生活权益部、外联部、社会实践部', '组织结构', ' ', ' ', '2', '2018-05-31 21:58:57', '刘镔琛', '2018-05-31 22:40:22', '刘镔琛');
INSERT INTO `indexs` VALUES ('7', '华北水利水电大学软件学院青年志愿者协会', '隶属于华北水利水电大学软件学院学生会', '组织结构', ' ', ' ', '2', '2018-05-31 22:40:54', '刘镔琛', '2018-05-31 22:40:57', '刘镔琛');
INSERT INTO `indexs` VALUES ('8', '华北水利水电大学软件学院演讲与辩论协会', '隶属于华北水利水电大学软件学院学生会', '组织结构', ' ', ' ', '2', '2018-06-01 01:08:56', '刘镔琛', '2018-06-01 01:09:39', '刘镔琛');
INSERT INTO `indexs` VALUES ('9', '华北水利水电大学软件学院心理协会', '隶属于华北水利水电大学软件学院学生会', '组织结构', ' ', ' ', '2', '2018-06-01 01:10:09', '刘镔琛', '2018-06-01 01:10:13', '刘镔琛');

-- ----------------------------
-- Table structure for `minutes`
-- ----------------------------
DROP TABLE IF EXISTS `minutes`;
CREATE TABLE `minutes` (
  `id` int(11) NOT NULL auto_increment,
  `minutes_name` varchar(255) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `start_time` varchar(255) NOT NULL,
  `end_time` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  `host` varchar(255) NOT NULL,
  `attendees` varchar(255) NOT NULL,
  `leaver` varchar(255) default NULL,
  `later` varchar(255) default NULL,
  `absenteeismer` varchar(255) default NULL,
  `content` text NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of minutes
-- ----------------------------
INSERT INTO `minutes` VALUES ('11', 'test', '主席团', '2018-05-08T22:00', '2018-05-08T22:22', 'test', '201419106-刘镔琛', 'test', '201419106-刘镔琛', '', '', 'test', '2018-05-28 02:14:40', '沧月', '2018-05-28 02:14:40', '沧月');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) unsigned zerofill NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('00000000000', '', '2018-05-22 00:11:56', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000001', '1', '2018-04-24 20:15:43', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000002', '阿斯蒂芬', '2018-04-24 20:15:43', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000003', '阿斯蒂芬爱的方式', '2018-04-24 20:16:39', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000004', '阿斯蒂芬爱的方式阿德萨发达省份', '2018-04-24 20:16:57', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000005', '阿斯蒂芬爱的方式阿德萨发达省份阿斯蒂芬', '2018-04-24 20:17:10', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000006', '', '2018-04-24 20:18:40', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000007', '阿斯蒂芬', '2018-04-24 21:49:16', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000008', '阿斯蒂芬', '2018-04-25 14:00:37', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000009', '', '2018-04-25 14:00:44', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000010', '阿斯蒂芬', '2018-04-25 14:00:49', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000011', '夜以继日赶毕设= =\n不想毕业滚回家QAQ', '2018-04-26 00:54:59', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000012', '夜以继日赶毕设= =\n不想毕业滚回家QAQ 阿萨德', '2018-04-28 01:25:31', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000013', '夜以继日赶毕设= =\n不想毕业滚回家QAQ', '2018-04-28 01:25:36', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000014', '1、首页管理（新媒体宣传部）\n2、会议记录（办公室）\n3、问题反馈（提案调研部）', '2018-05-01 07:03:16', '沧月');
INSERT INTO `notice` VALUES ('00000000015', '1、首页管理（新）\n2、会议记录（办）\n3、问题反馈（提）', '2018-05-01 07:06:43', '沧月');
INSERT INTO `notice` VALUES ('00000000016', '1、会议记录（办）\n3、问题反馈（提）\n3、部门成员（组）\n4、首页管理（新）', '2018-05-01 15:38:09', '沧月');
INSERT INTO `notice` VALUES ('00000000017', '1、会议记录（办）\n    2、问题反馈（提）\n3、部门成员（组）\n4、首页管理（新）', '2018-05-06 00:03:59', '沧月');
INSERT INTO `notice` VALUES ('00000000018', '1、会议记录（办）\n2、问题反馈（提）\n3、部门成员（组）\n4、首页管理（新）', '2018-05-06 00:04:10', '沧月');
INSERT INTO `notice` VALUES ('00000000019', '1、会议记录（办）\n2、问题反馈（提）\n3、部门成员（组）\n4、首页管理（新）', '2018-05-11 13:56:50', '沧月');
INSERT INTO `notice` VALUES ('00000000020', '1、会议记录 - 办\n2、问题反馈 - 提\n3、部门成员 - 组\n4、首页管理 - 新', '2018-05-11 13:57:35', '沧月');
INSERT INTO `notice` VALUES ('00000000021', '', '2018-05-14 22:22:42', '陈天乐');
INSERT INTO `notice` VALUES ('00000000022', '1', '2018-05-18 23:42:50', 'leif');
INSERT INTO `notice` VALUES ('00000000023', '2', '2018-05-18 23:42:56', 'leif');
INSERT INTO `notice` VALUES ('00000000024', '3', '2018-05-18 23:43:02', 'leif');
INSERT INTO `notice` VALUES ('00000000025', '4', '2018-05-18 23:43:07', 'leif');
INSERT INTO `notice` VALUES ('00000000026', '5', '2018-05-18 23:43:14', 'leif');
INSERT INTO `notice` VALUES ('00000000027', '6', '2018-05-18 23:43:19', 'leif');
INSERT INTO `notice` VALUES ('00000000028', '7', '2018-05-18 23:43:27', 'leif');
INSERT INTO `notice` VALUES ('00000000029', '8', '2018-05-18 23:43:46', 'leif');
INSERT INTO `notice` VALUES ('00000000030', '9', '2018-05-18 23:43:54', 'leif');
INSERT INTO `notice` VALUES ('00000000031', '10', '2018-05-18 23:44:02', 'leif');
INSERT INTO `notice` VALUES ('00000000032', '11', '2018-05-18 23:44:12', 'leif');
INSERT INTO `notice` VALUES ('00000000033', '12', '2018-05-18 23:44:23', 'leif');
INSERT INTO `notice` VALUES ('00000000034', '13', '2018-05-18 23:44:35', 'leif');
INSERT INTO `notice` VALUES ('00000000035', '14', '2018-05-18 23:45:06', 'leif');
INSERT INTO `notice` VALUES ('00000000036', '', '2018-05-18 23:45:15', 'leif');
INSERT INTO `notice` VALUES ('00000000037', 'asdfasdfsadfasdfsadf', '2018-05-18 23:48:31', 'leif');
INSERT INTO `notice` VALUES ('00000000038', '欢迎软件学院leif团委老师欢迎软件学院leif团委老师欢迎软件学院leif团委老师', '2018-05-18 23:48:49', 'leif');
INSERT INTO `notice` VALUES ('00000000039', '', '2018-05-19 19:04:19', 'leif');
INSERT INTO `notice` VALUES ('00000000040', 'sadf', '2018-05-19 20:39:18', 'leif');
INSERT INTO `notice` VALUES ('00000000041', '', '2018-05-21 17:57:40', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000042', '紧急通知', '2018-05-22 00:10:01', '刘镔琛');
INSERT INTO `notice` VALUES ('00000000043', '', '2018-05-22 00:11:56', '刘镔琛');

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL auto_increment,
  `plan_name` varchar(255) NOT NULL,
  `plan_type` varchar(255) NOT NULL,
  `activity_date` varchar(255) NOT NULL,
  `activity_place` varchar(255) NOT NULL,
  `activity_background` text NOT NULL,
  `activity_purpose` text NOT NULL,
  `activity_theme` varchar(255) NOT NULL,
  `activity_object` varchar(255) NOT NULL,
  `attachment` varchar(255) default NULL,
  `suffix` varchar(255) default NULL,
  `status` int(11) NOT NULL COMMENT '1：申请（部长团）；2：申请（主席团）；3：通过；0：过期',
  `department_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('3', 'aaa', '女生', '2018-04-29 04:04', 'a', 'aa', 'a', 'a', 'a', ' ', ' ', '0', '办公室', '201419106', '2018-04-07 23:00:04', '刘镔琛', '2018-05-28 00:30:53', '沧月');
INSERT INTO `plan` VALUES ('7', '阿斯蒂芬', '生活', '2018-04-08 03:03', 'asdf', 'asdf', 'asdf', 'asdf', 'asdf', ' ', ' ', '0', '主席团', '201419106', '2018-04-08 22:57:47', '刘镔琛', '2018-05-18 22:24:22', 'leif');
INSERT INTO `plan` VALUES ('16', '123', '学习', '2018-04-13 03:03', '123213', '3213123', '123213', '12312', '123', ' ', ' ', '1', '秘书处', '201419106', '2018-04-27 23:33:53', '刘镔琛', '2018-04-27 23:33:53', '123');
INSERT INTO `plan` VALUES ('17', 'asdf', '学习', '2018-04-20 03:03', 'asdfasdfasdfasdfasdfasdf', 'asdfasdf', 'asdfasdfasdf', 'asdfasdfasdfasdfasdf', 'asdfasdfasdfasdf', ' ', ' ', '1', '秘书处', '201419106', '2018-04-27 23:49:42', '刘镔琛', '2018-04-27 23:49:42', '456');
INSERT INTO `plan` VALUES ('18', 'dsfgdsasdfasdfasfd', '学习', '2018-04-04 03:03', 'dsfgdsasdfasdf', 'dsf', 'dsfgdsas', 'dsfgdsasdfasdfasfdasdf', 'dsfgdsasdf', ' ', ' ', '1', '秘书处', '201419106', '2018-04-27 23:56:36', '刘镔琛', '2018-04-27 23:56:36', '456');
INSERT INTO `plan` VALUES ('23', 'afds', '宣传', '2018-05-01 04:04', 'adfs', 'dsa', 'afdsa', 'adsf', 'fds', ' ', ' ', '0', '主席团', '201419100', '2018-05-01 06:53:55', '沧月', '2018-05-18 22:24:08', 'leif');
INSERT INTO `plan` VALUES ('24', 'adsf', '学习', '2018-05-19 04:04', 'afds', 'dafs', 'adsfadsf', 'sfd', 'asfda', ' ', ' ', '0', '主席团', '201419100', '2018-05-01 06:54:42', '沧月', '2018-05-14 07:48:31', '沧月');
INSERT INTO `plan` VALUES ('25', 'adsf', '学习', '2018-05-18 03:03', 'asdf', 'asdf', 'asdf', 'sdf', 'fdas', ' ', ' ', '0', '主席团', '201419100', '2018-05-04 17:11:59', '沧月', '2018-05-18 22:19:38', 'leif');
INSERT INTO `plan` VALUES ('26', 'asfdasf', '体育', '2018-05-25 03:03', '阿萨德', 'asfd', '按时发大水发斯蒂芬', '暗室逢灯', '阿斯蒂芬', ' ', ' ', '0', '主席团', '201419100', '2018-05-14 05:57:54', '沧月', '2018-05-18 22:19:32', 'leif');
INSERT INTO `plan` VALUES ('34', '卡', '女生', '2018-05-17 03:03', '阿萨德发射点发', '撒旦法', 'asdf', '苏打粉', '按时', '201419106-刘镔琛-基于Java的学生团体管理系统', '.docx', '0', '办公室', '201600105', '2018-05-14 17:56:29', '卡特琳娜', '2018-05-19 20:40:03', '零');
INSERT INTO `plan` VALUES ('37', '团委老师', '宣传', '2018-05-03 03:03', '团委老师', '团委老师', '团委老师', '团委老师', '团委老师', '11、学生代理', '.docx', '0', '软件学院', '0', '2018-05-18 22:19:54', 'leif', '2018-05-19 19:40:06', '飞蓬');
INSERT INTO `plan` VALUES ('38', 'plan/information/active/37', '学习', '2018-05-16 03:03', 'plan/information/active/37', 'plan/information/active/37', 'plan/information/active/37', 'plan/information/active/37', 'plan/information/active/37', '8、致谢的一般格式', '.docx', '0', '软件学院', '0', '2018-05-18 22:22:18', 'leif', '2018-05-19 19:24:38', '飞蓬');
INSERT INTO `plan` VALUES ('39', 'plan/information/active/37', '文艺', '0033-05-18 03:03', 'plan/information/active/37', 'plan/information/active/37', 'plan/information/active/37', 'plan/information/active/37', 'plan/information/active/37', ' ', ' ', '0', '软件学院', '0', '2018-05-18 22:23:06', 'leif', '2018-05-18 22:23:13', 'leif');
INSERT INTO `plan` VALUES ('40', 'sadf', '学习', '2018-05-17 03:03', '阿斯蒂芬', '撒旦法撒旦法', '暗室逢灯', '苏打粉', '阿斯蒂芬', ' ', ' ', '0', '软件学院', '0', '2018-05-19 19:02:00', 'leif', '2018-05-19 19:36:10', 'leif');
INSERT INTO `plan` VALUES ('45', '爱的方式', '体育', '2018-05-25 03:03', '撒旦法', '撒旦法', '撒旦法', '阿斯蒂芬', '阿斯蒂芬', ' ', ' ', '0', '软件学院', '0', '2018-05-19 19:39:08', 'leif', '2018-05-19 19:46:41', '飞蓬');
INSERT INTO `plan` VALUES ('46', '爱的方式', '体育', '2018-05-25 03:03', '撒旦法', '撒旦法', '撒旦法', '阿斯蒂芬', '阿斯蒂芬', '20170512_131321', '.jpg', '0', '软件学院', '0', '2018-05-19 19:39:26', 'leif', '2018-05-28 00:30:32', '沧月');
INSERT INTO `plan` VALUES ('47', '副主席', '宣传', '2018-05-17 03:03', '副主席', '副主席', '副主席', '副主席', '副主席', '20170512_131321', '.jpg', '0', '主席团', '201400101', '2018-05-19 19:40:40', '飞蓬', '2018-05-19 19:41:30', '飞蓬');
INSERT INTO `plan` VALUES ('48', '副主席', '学习', '2018-05-04 03:03', '副主席', '副主席', '副主席', '副主席', '副主席', ' ', ' ', '3', '主席团', '201400101', '2018-05-19 19:42:00', '飞蓬', '2018-05-19 19:42:06', '飞蓬');
INSERT INTO `plan` VALUES ('49', '暗室逢灯', '学习', '2018-05-09 03:03', 'asdf撒旦法', '萨芬的asd', '阿萨德sadf', '发斯蒂芬', '阿萨德发fd', '迎新工作活动反馈', '.docx', '2', '主席团', '201400101', '2018-05-19 19:45:42', '飞蓬', '2018-05-19 19:45:42', '飞蓬');
INSERT INTO `plan` VALUES ('50', 'sadf', '女生', '0033-05-24 03:03', '的萨芬', '撒旦法撒旦法sad', '啥大是大非', '的萨芬', '撒旦法阿斯蒂芬', '20170512_131321', '.jpg', '0', '主席团', '201400101', '2018-05-19 19:50:25', '飞蓬', '2018-05-19 19:50:35', '飞蓬');
INSERT INTO `plan` VALUES ('51', 'dsaf', '学习', '0033-05-10 03:03', 'sadf', 'asdf', 'sadf', 'sdaf', 'sadf', ' ', ' ', '3', '办公室', '201500001', '2018-05-19 20:40:38', '零', '2018-05-21 21:14:28', '刘镔琛');
INSERT INTO `plan` VALUES ('52', 'asfd', '学习', '0003-05-17 03:03', '阿斯蒂芬', '艾算法大是大非', '阿斯蒂芬', '撒旦法', '萨芬的', ' ', ' ', '1', '办公室', '201600110', '2018-05-20 00:41:04', '克烈', '2018-05-20 00:41:04', '克烈');
INSERT INTO `plan` VALUES ('53', 'afds', '宣传', '0003-05-16 03:03', '撒旦法', '阿范德萨发大水a', '苏打粉sad', '啊dsaf', '打发爱的色放', '李国佳-周记录2017二本', '.doc', '3', '主席团', '201419106', '2018-05-21 21:12:41', '刘镔琛', '2018-05-25 20:57:51', '刘镔琛');
INSERT INTO `plan` VALUES ('54', 'dfs', '文艺', '2018-05-24 05:05', '阿斯蒂芬', '电风扇撒地方', '撒旦法', '阿萨德', '苏打粉', '基于深度学习的语义标注技术研究1.4', '.docx', '3', '主席团', '201419106', '2018-05-25 20:59:14', '刘镔琛', '2018-05-28 00:31:26', '沧月');
INSERT INTO `plan` VALUES ('55', 'adfs', '宣传', '2018-05-30 03:03', '啊', '阿道夫撒第三方', '撒旦法', 's阿道夫', '暗室逢灯a', ' ', ' ', '0', '办公室', '201500001', '2018-05-27 17:49:22', '零', '2018-05-27 17:49:40', '沧月');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) unsigned zerofill NOT NULL auto_increment,
  `position_name` varchar(255) NOT NULL,
  `people_number` int(11) NOT NULL,
  `permission_id` int(255) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `post_name` (`position_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('00000000000', '团委老师', '1', '0', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000001', '主席', '1', '1', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000002', '第一副书记', '1', '1', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000003', '副主席', '7', '2', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000004', '第二副书记', '1', '2', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000005', '秘书长', '0', '2', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000006', '副秘书长', '0', '2', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000007', '主任', '1', '3', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000008', '部长', '10', '3', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000009', '副主任', '2', '4', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000010', '副部长', '20', '4', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000011', '秘书', '1', '4', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');
INSERT INTO `position` VALUES ('00000000012', '干事', '58', '5', '2018-03-20 23:18:05', 'leif', '2018-03-20 23:18:05', 'leif');

-- ----------------------------
-- Table structure for `recruitment`
-- ----------------------------
DROP TABLE IF EXISTS `recruitment`;
CREATE TABLE `recruitment` (
  `id` int(11) NOT NULL auto_increment,
  `nickname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `birthday` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `classs` varchar(255) NOT NULL,
  `native_place` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `swap` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `qq` varchar(255) default NULL,
  `hobby` text,
  `self_appraisal` text,
  `department_understanding` text,
  `awards_and_achievements` text,
  `status` varchar(255) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitment
-- ----------------------------
INSERT INTO `recruitment` VALUES ('12', 'test', '男', '2018-05-02', 'test', 'test', 'test', '123', '提案调研部', '是', '13175060712', '603529840@qq.com', '', '', '', '', '', '通过', '2018-05-28 14:20:47', 'test', '2018-05-28 14:21:25', '雷姬');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned zerofill NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `birthday` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `classs` varchar(255) NOT NULL,
  `native_place` varchar(255) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `position_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `qq` varchar(255) default NULL,
  `hobby` text,
  `self_appraisal` text,
  `awards_and_achievements` text,
  `leave_number` int(11) NOT NULL,
  `late_number` int(11) NOT NULL,
  `absenteeism_number` int(11) NOT NULL,
  `plan_active_number` int(11) NOT NULL,
  `plan_completed_number` int(11) NOT NULL,
  `plan_overdue_number` int(11) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_time` varchar(255) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `user_post` (`position_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000000000', '0', '123', 'leif', '男', '2014-09-13', '负责教师', '1304', '河南省郑州市', '软件学院', '团委老师', '17637933225', '603529840@qq.com', '6035299840', '', '', '', '0', '0', '0', '0', '0', '6', '2018-03-20 23:18:05', 'leif', '2018-05-18 22:42:21', 'leif');
INSERT INTO `user` VALUES ('00000000001', '201419106', '123', '刘镔琛', '男', '1995-10-22', '软件工程', '2014191班', '河南省濮阳市', '主席团', '主席', '17521030712', '603529840@qq.com', '603529840', '卡特琳娜\n戴安娜\n娑娜\n迦娜\n蕾欧娜', '帅', '河南省三好学生', '1', '0', '0', '3', '2', '2', '2018-03-20 23:18:05', '刘镔琛', '2018-05-18 22:31:28', 'leif');
INSERT INTO `user` VALUES ('00000000002', '201419100', '123', '沧月', '女', '1996-01-01', '软件工程', '2014191班', '河南省濮阳市', '主席团', '第一副书记', '13175060712', '2469004149@qq.com', '2469004149', '冰', '', '', '0', '0', '0', '0', '0', '4', '2018-03-20 23:18:05', '刘镔琛', '2018-05-14 07:55:37', '沧月');
INSERT INTO `user` VALUES ('00000000003', '201400101', '123', '飞蓬', '男', '2018-05-09', '软件工程', '2014001班', '河南省开封市', '主席团', '副主席', '12345678910', '123@qq.com', '123123123', '光', '', '', '0', '0', '0', '1', '1', '2', '2018-03-20 23:18:05', '刘镔琛', '2018-05-01 06:15:59', '1');
INSERT INTO `user` VALUES ('00000000004', '201400102', '123', '夕瑶', '女', '1996-01-01', '汉语国际教育（文化信息技术与传播）', '2014001班', '河南省濮阳市', '主席团', '副主席', '12345678910', '123@qq.com', '123123123', '木', '', '', '0', '0', '0', '3', '0', '0', '2018-03-20 23:18:05', '刘镔琛', '2018-04-29 01:09:16', '夕瑶');
INSERT INTO `user` VALUES ('00000000005', '201400201', '123', '重楼', '男', '1995-11-28', '软件工程', '2014002班', '河南省开封市', '主席团', '副主席', '12345678910', '123@qq.com', '123123', '暗', '', '', '0', '0', '0', '4', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-30 18:15:21', '刘镔琛');
INSERT INTO `user` VALUES ('00000000006', '201400301', '123', '徐长卿', '男', '2018-04-18', '软件工程', '2014003班', '河南省濮阳市', '主席团', '副主席', '12345678910', '123@qq.com', '123123', '土', '', '', '0', '0', '0', '5', '0', '0', '2018-04-19 21:28:14', '刘镔琛', '2018-04-29 01:08:23', '徐长卿');
INSERT INTO `user` VALUES ('00000000007', '201400302', '123', '李逍遥', '男', '2018-04-19', '软件工程', '2014003班', '河南省濮阳市', '主席团', '副主席', '12345678910', '123@qq.com', '123123', '风', '', '', '0', '0', '0', '6', '0', '0', '2018-04-19 22:04:18', '刘镔琛', '2018-04-26 18:45:40', '刘镔琛');
INSERT INTO `user` VALUES ('00000000008', '201400401', '123', '云天河', '男', '2018-04-19', '软件工程', '2014004班', '河南省濮阳市', '主席团', '副主席', '12345678910', '123@qq.com', '123123', '雷', '', '', '0', '0', '0', '0', '0', '0', '2018-04-19 22:18:22', '刘镔琛', '2018-04-29 01:12:29', '云天河');
INSERT INTO `user` VALUES ('00000000009', '201400501', '123', '龙幽', '男', '2018-03-28', '软件工程', '2014005班', '河南省濮阳市', '主席团', '副主席', '12345678910', '123@qq.com', '123123', '金', '', '', '0', '0', '0', '7', '0', '0', '2018-04-19 22:19:06', '刘镔琛', '2018-05-01 06:44:19', '刘镔琛');
INSERT INTO `user` VALUES ('00000000010', '201400502', '123', '龙葵', '女', '2018-03-28', '软件工程', '2014005班', '河南省濮阳市', '主席团', '第二副书记', '12345678910', '123@qq.com', '123123', '水', '', '', '0', '0', '0', '56', '0', '0', '2018-04-19 22:25:36', '刘镔琛', '2018-04-30 18:31:14', '刘镔琛');
INSERT INTO `user` VALUES ('00000000012', '201500001', '123', '零', '女', '2018-04-18', '软件工程', '2015000班', '河南省濮阳市', '办公室', '主任', '12345678910', '123@qq.com', '123123', '言灵·镜瞳', '', '', '0', '0', '0', '0', '1', '1', '2018-04-24 13:31:16', '刘镔琛', '2018-04-29 14:46:44', '刘镔琛');
INSERT INTO `user` VALUES ('00000000013', '201500002', '123', '雷姬', '女', '2018-04-05', '软件工程', '2015000班', '河南省濮阳市', '提案调研部', '部长', '12345678910', '123@qq.com', '123123', '言灵·冬', '', '', '0', '0', '0', '43', '0', '0', '2018-04-28 00:58:24', '刘镔琛', '2018-04-29 01:19:18', '雷姬');
INSERT INTO `user` VALUES ('00000000014', '201500003', '123', '苏恩曦', '女', '2018-04-05', '软件工程', '2015000班', '河南省濮阳市', '组织部', '部长', '12345678910', '123@qq.com', '123123', '言灵·天演', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 00:58:24', '刘镔琛', '2018-04-29 01:22:23', '苏恩曦');
INSERT INTO `user` VALUES ('00000000015', '201500004', '123', '酒德麻衣', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '新媒体宣传部', '部长', '12345678910', '123@qq.com', '123123', '言灵·冥照', '', '', '0', '0', '0', '5', '0', '0', '2018-04-28 00:58:24', '刘镔琛', '2018-05-06 00:43:18', '沧月');
INSERT INTO `user` VALUES ('00000000016', '201500005', '123', '楚子航', '男', '2018-04-05', '软件工程', '2015000班', '河南省濮阳市', '学习部', '部长', '12345678910', '123@qq.com', '123123', '言灵·君焰', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 01:00:47', '刘镔琛', '2018-04-29 01:24:24', '楚子航');
INSERT INTO `user` VALUES ('00000000017', '201500006', '123', '角都', '男', '2018-04-05', '软件工程', '2015000班', '河南省濮阳市', '创新创业部', '部长', '12345678910', '123@qq.com', '123123', '地怨虞', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 01:01:57', '刘镔琛', '2018-04-29 01:27:51', '角都');
INSERT INTO `user` VALUES ('00000000018', '201500007', '123', '飞段', '男', '2018-03-28', '软件工程', '2015000班', '河南省濮阳市', '文艺部', '部长', '12345678910', '123@qq.com', '123123', '不死身', '', '', '0', '0', '0', '54', '0', '0', '2018-04-28 01:01:57', '刘镔琛', '2018-04-30 18:17:08', '刘镔琛');
INSERT INTO `user` VALUES ('00000000019', '201500008', '123', '八月', '女', '2018-03-28', '软件工程', '2015000班', '河南省濮阳市', '体育部', '部长', '12345678910', '123@qq.com', '123123', '读心术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 02:45:03', '刘镔琛', '2018-04-29 01:30:18', '八月');
INSERT INTO `user` VALUES ('00000000020', '201500009', '123', '六月', '女', '2018-03-28', '软件工程', '2015000班', '河南省濮阳市', '生活权益部', '部长', '12345678910', '123@qq.com', '123123', '超声波', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 02:47:17', '刘镔琛', '2018-04-29 01:31:31', '六月');
INSERT INTO `user` VALUES ('00000000021', '201500010', '123', '五月', '男', '2018-03-28', '软件工程', '2015000班', '河南省濮阳市', '外联部', '部长', '12345678910', '123@qq.com', '123123', '肌体石化', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 02:48:07', '刘镔琛', '2018-04-29 01:32:17', '五月');
INSERT INTO `user` VALUES ('00000000022', '201500011', '123', '一月', '女', '2018-03-28', '软件工程', '2015000班', '河南省濮阳市', '社会实践部', '部长', '12345678910', '123@qq.com', '123123', '物体爆炸', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 02:51:01', '刘镔琛', '2018-04-29 01:33:42', '一月');
INSERT INTO `user` VALUES ('00000000023', '201500012', '123', '绝', '男', '2018-04-05', '软件工程', '2015000班', '河南省濮阳市', '秘书处', '秘书', '12345678910', '123@qq.com', '123123', '孢子之术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 04:43:23', '刘镔琛', '2018-04-29 01:35:03', '绝');
INSERT INTO `user` VALUES ('00000000024', '201500013', '123', '小楠', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '办公室', '副主任', '12345678910', '123@qq.com', '123123', '天神道·神之纸之术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-28 04:43:23', '刘镔琛', '2018-04-29 01:36:33', '小楠');
INSERT INTO `user` VALUES ('00000000025', '201500014', '123', '十月', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '办公室', '副主任', '12345678910', '123@qq.com', '123123', '天神道·御火术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:37:05', '十月');
INSERT INTO `user` VALUES ('00000000026', '201500015', '123', '君麻吕', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '提案调研部', '副部长', '12345678910', '123@qq.com', '123123', '修罗道·尸骨脉', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:39:28', '君麻吕');
INSERT INTO `user` VALUES ('00000000027', '201500016', '123', '三月', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '提案调研部', '副部长', '12345678910', '123@qq.com', '123123', '修罗道·御金术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:40:55', '三月');
INSERT INTO `user` VALUES ('00000000028', '201500017', '123', '蝎', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '组织部', '副部长', '12345678910', '123@qq.com', '123123', '地狱道·傀儡之术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:44:43', '蝎');
INSERT INTO `user` VALUES ('00000000029', '201500018', '123', '四月', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '组织部', '副部长', '12345678910', '123@qq.com', '123123', '地狱道·御木术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:45:50', '四月');
INSERT INTO `user` VALUES ('00000000030', '201500019', '123', '鼬', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '新媒体宣传部', '副部长', '12345678910', '123@qq.com', '123123', '人间道·万花筒写轮眼', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:46:44', '鼬');
INSERT INTO `user` VALUES ('00000000031', '201500020', '123', '九月', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '新媒体宣传部', '副部长', '12345678910', '123@qq.com', '123123', '人间道·御光术', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:48:13', '九月');
INSERT INTO `user` VALUES ('00000000032', '201500021', '123', '鬼鲛', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '学习部', '副部长', '12345678910', '123@qq.com', '123123', '饿鬼道·无尾尾兽', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:51:11', '鬼鲛');
INSERT INTO `user` VALUES ('00000000033', '201500022', '123', '七月', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '学习部', '副部长', '12345678910', '123@qq.com', '123123', '饿鬼道·绝对防御', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:51:45', '七月');
INSERT INTO `user` VALUES ('00000000034', '201500023', '123', '迪达拉', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '创新创业部', '副部长', '12345678910', '123@qq.com', '123123', '畜生道·黏土引爆', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:52:38', '迪达拉');
INSERT INTO `user` VALUES ('00000000035', '201500024', '123', '二月', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '创新创业部', '副部长', '12345678910', '123@qq.com', '123123', '畜生道·动物控制', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 15:00:44', '刘镔琛');
INSERT INTO `user` VALUES ('00000000036', '201500025', '123', '伽蓝', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '文艺部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·真实', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-30 18:17:23', '刘镔琛');
INSERT INTO `user` VALUES ('00000000037', '201500026', '123', '梅拉斯邱拉', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '文艺部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·信仰', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:56:58', '梅拉斯邱拉');
INSERT INTO `user` VALUES ('00000000038', '201500027', '123', '六雪尼', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '体育部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·安息', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:57:28', '六雪尼');
INSERT INTO `user` VALUES ('00000000039', '201500028', '123', '多洛录', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '体育部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·忍耐', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:58:19', '多洛录');
INSERT INTO `user` VALUES ('00000000040', '201500029', '123', '弗拉乌德林', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '生活权益部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·无欲', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:58:43', '弗拉乌德林');
INSERT INTO `user` VALUES ('00000000041', '201500030', '123', '古雷伊罗德', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '生活权益部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·不杀', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 01:59:15', '古雷伊罗德');
INSERT INTO `user` VALUES ('00000000042', '201500031', '123', '门斯皮特', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '外联部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·沉默', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-30 18:20:02', '刘镔琛');
INSERT INTO `user` VALUES ('00000000043', '201500032', '123', '戴利爱丽', '女', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '外联部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·纯洁', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 02:00:42', '戴利爱丽');
INSERT INTO `user` VALUES ('00000000044', '201500033', '123', '艾斯塔罗萨', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '社会实践部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·慈爱', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-05-01 00:06:09', '刘镔琛');
INSERT INTO `user` VALUES ('00000000045', '201500034', '123', '杰鲁德利斯', '男', '2018-04-04', '软件工程', '2015000班', '河南省濮阳市', '社会实践部', '副部长', '12345678910', '123@qq.com', '123123', '戒律·背信', '', '', '0', '0', '0', '0', '0', '0', '2018-04-17 21:30:51', '刘镔琛', '2018-04-29 02:01:59', '杰鲁德利斯');
INSERT INTO `user` VALUES ('00000000046', '201600101', '123', '德莱厄斯', '男', '2018-04-04', '诺克萨斯之手', '2016001班', '诺克萨斯', '办公室', '干事', '12345678910', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:20:54', '刘镔琛', '2018-04-29 03:20:54', '刘镔琛');
INSERT INTO `user` VALUES ('00000000047', '201600102', '123', '斯维因', '男', '2018-03-29', '诺克萨斯统领', '2016001班', '诺克萨斯', '办公室', '干事', '12345678910', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:20:58', '刘镔琛', '2018-04-29 03:20:58', '刘镔琛');
INSERT INTO `user` VALUES ('00000000048', '201600103', '123', '厄加特', '男', '2018-03-28', '无畏战车', '2016001班', '诺克萨斯', '办公室', '干事', '12312312311', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:21:00', '刘镔琛', '2018-04-29 03:21:00', '刘镔琛');
INSERT INTO `user` VALUES ('00000000049', '201600104', '123', '赛恩', '男', '2018-04-05', '亡灵战神', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:21:03', '刘镔琛', '2018-04-29 03:21:03', '刘镔琛');
INSERT INTO `user` VALUES ('00000000050', '201600105', '123', '卡特琳娜', '女', '2018-04-19', '不祥之刃', '2016001班', '诺克萨斯', '办公室', '干事', '12345678900', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '1', '2018-04-29 03:21:06', '刘镔琛', '2018-04-29 03:21:06', '刘镔琛');
INSERT INTO `user` VALUES ('00000000051', '201600106', '123', '卡西奥佩娅', '女', '2018-04-05', '魔蛇之拥', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:21:09', '刘镔琛', '2018-04-29 03:21:09', '刘镔琛');
INSERT INTO `user` VALUES ('00000000052', '201600107', '123', '乐芙兰', '女', '2018-03-29', '诡术妖姬', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:21:52', '沧月', '2018-04-29 03:21:52', '沧月');
INSERT INTO `user` VALUES ('00000000053', '201600108', '123', '弗拉基米尔', '男', '2018-04-04', '腥红收割者', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '122321', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:21:58', '沧月', '2018-04-29 03:21:58', '沧月');
INSERT INTO `user` VALUES ('00000000054', '201600109', '123', '泰隆', '男', '2018-04-12', '刀锋之影', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:22:40', '零', '2018-04-29 03:22:40', '零');
INSERT INTO `user` VALUES ('00000000055', '201600110', '123', '克烈', '男', '2018-04-04', '暴怒骑士', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '1', '0', '0', '2018-04-29 03:22:55', '零', '2018-04-29 03:22:55', '零');
INSERT INTO `user` VALUES ('00000000056', '201600111', '123', '锐雯', '女', '2018-04-11', '放逐之刃', '2016001班', '诺克萨斯', '办公室', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:27:09', '刘镔琛', '2018-04-30 18:28:54', '刘镔琛');
INSERT INTO `user` VALUES ('00000000057', '201600201', '123', '嘉文四世', '男', '2018-04-05', '德玛西亚皇子', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:15', '刘镔琛', '2018-04-29 03:33:15', '刘镔琛');
INSERT INTO `user` VALUES ('00000000058', '201600202', '123', '盖伦', '男', '2018-04-12', '德玛西亚之力', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:17', '刘镔琛', '2018-04-29 03:33:17', '刘镔琛');
INSERT INTO `user` VALUES ('00000000059', '201600203', '123', '拉克丝', '女', '2018-04-04', '光辉女郎', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '233123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:22', '刘镔琛', '2018-04-29 03:33:22', '刘镔琛');
INSERT INTO `user` VALUES ('00000000060', '201600204', '123', '加里奥', '男', '2018-04-12', '正义巨像', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '213123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:24', '刘镔琛', '2018-04-29 03:33:24', '刘镔琛');
INSERT INTO `user` VALUES ('00000000061', '201600205', '123', '薇恩', '女', '2018-04-12', '暗夜猎手', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:28', '刘镔琛', '2018-04-29 03:33:28', '刘镔琛');
INSERT INTO `user` VALUES ('00000000062', '201600206', '123', '希瓦娜', '女', '2018-04-05', '龙血武姬', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:30', '刘镔琛', '2018-04-29 03:33:30', '刘镔琛');
INSERT INTO `user` VALUES ('00000000063', '201600207', '123', '菲奥娜', '女', '2018-04-12', '无双剑姬', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:33', '刘镔琛', '2018-04-29 03:33:33', '刘镔琛');
INSERT INTO `user` VALUES ('00000000064', '201600208', '123', '奎因', '女', '2018-04-04', '德玛西亚之翼', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:35', '刘镔琛', '2018-04-29 03:33:35', '刘镔琛');
INSERT INTO `user` VALUES ('00000000065', '201600209', '123', '波比', '女', '2018-04-12', '圣锤之毅', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:37', '刘镔琛', '2018-04-29 03:33:37', '刘镔琛');
INSERT INTO `user` VALUES ('00000000066', '201600210', '123', '娑娜', '女', '2017-12-31', '琴瑟仙女', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '122312', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:43', '刘镔琛', '2018-04-29 03:33:43', '刘镔琛');
INSERT INTO `user` VALUES ('00000000067', '201600211', '123', '卢锡安', '男', '2018-04-05', '圣枪游侠', '2016002班', '德玛西亚', '提案调研部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:45', '刘镔琛', '2018-04-29 03:33:45', '刘镔琛');
INSERT INTO `user` VALUES ('00000000068', '201600401', '123', '凯隐', '男', '2018-04-26', '影流之镰', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:47', '刘镔琛', '2018-04-29 03:33:47', '刘镔琛');
INSERT INTO `user` VALUES ('00000000069', '201600402', '123', '洛', '男', '2018-04-05', '幻翎', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:50', '刘镔琛', '2018-04-29 03:33:50', '刘镔琛');
INSERT INTO `user` VALUES ('00000000070', '201600403', '123', '霞', '女', '2018-04-19', '逆羽', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:33:52', '刘镔琛', '2018-04-29 03:33:52', '刘镔琛');
INSERT INTO `user` VALUES ('00000000071', '201600404', '123', '阿狸', '女', '2018-03-29', '九尾妖狐', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:34', '刘镔琛', '2018-05-04 17:36:01', '沧月');
INSERT INTO `user` VALUES ('00000000072', '201600405', '123', '阿卡丽', '女', '2018-04-12', '暗影之拳', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:36', '刘镔琛', '2018-04-30 18:22:26', '刘镔琛');
INSERT INTO `user` VALUES ('00000000073', '201600406', '123', '艾瑞莉娅', '女', '2018-04-05', '刀锋舞者', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:41', '刘镔琛', '2018-04-29 03:43:41', '刘镔琛');
INSERT INTO `user` VALUES ('00000000074', '201600407', '123', '烬', '男', '2018-04-12', '戏命师', '2016006班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312311', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:43', '刘镔琛', '2018-05-06 00:44:02', '沧月');
INSERT INTO `user` VALUES ('00000000075', '201600408', '123', '亚索', '男', '2018-04-05', '疾风剑豪', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:46', '刘镔琛', '2018-04-29 03:43:46', '刘镔琛');
INSERT INTO `user` VALUES ('00000000076', '201600409', '123', '卡尔玛', '女', '2018-04-12', '天启者', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:48', '刘镔琛', '2018-04-29 03:43:48', '刘镔琛');
INSERT INTO `user` VALUES ('00000000077', '201600410', '123', '凯南', '男', '2018-04-12', '狂暴之心', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312321', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:50', '刘镔琛', '2018-04-29 03:43:50', '刘镔琛');
INSERT INTO `user` VALUES ('00000000078', '201600411', '123', '李青', '男', '2018-04-12', '盲僧', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:52', '刘镔琛', '2018-04-29 03:43:52', '刘镔琛');
INSERT INTO `user` VALUES ('00000000079', '201600412', '123', '易', '男', '2018-04-13', '无极剑圣', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:54', '刘镔琛', '2018-04-29 03:43:54', '刘镔琛');
INSERT INTO `user` VALUES ('00000000080', '201600413', '123', '慎', '男', '2018-04-12', '暮光之眼', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:43:59', '刘镔琛', '2018-04-29 03:43:59', '刘镔琛');
INSERT INTO `user` VALUES ('00000000081', '201600414', '123', '索拉卡', '女', '2018-04-19', '众星之子', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:03', '刘镔琛', '2018-04-29 03:44:03', '刘镔琛');
INSERT INTO `user` VALUES ('00000000082', '201600415', '123', '辛德拉', '女', '2018-04-12', '暗黑元首', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:05', '刘镔琛', '2018-05-06 00:43:53', '沧月');
INSERT INTO `user` VALUES ('00000000083', '201600416', '123', '韦鲁斯', '男', '2018-04-05', '惩戒之箭', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:08', '刘镔琛', '2018-05-19 20:05:21', '飞蓬');
INSERT INTO `user` VALUES ('00000000084', '201600417', '123', '劫', '男', '2018-04-12', '影流之主', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:11', '刘镔琛', '2018-04-29 03:44:11', '刘镔琛');
INSERT INTO `user` VALUES ('00000000085', '201600418', '123', '孙悟空', '男', '2018-04-12', '齐天大圣', '2016004班', '艾欧尼亚', '新媒体宣传部', '干事', '12312312312', '123@qq.com', '213123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:14', '刘镔琛', '2018-04-29 03:44:14', '刘镔琛');
INSERT INTO `user` VALUES ('00000000086', '201600301', '123', '库奇', '男', '2018-04-12', '英勇投弹手', '2016003班', '班德尔城', '组织部', '干事', '12312312321', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:16', '刘镔琛', '2018-04-29 03:44:16', '刘镔琛');
INSERT INTO `user` VALUES ('00000000087', '201600302', '123', '璐璐', '女', '2018-04-05', '仙灵女巫', '2016003班', '班德尔城', '组织部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:20', '刘镔琛', '2018-04-29 03:44:20', '刘镔琛');
INSERT INTO `user` VALUES ('00000000088', '201600303', '123', '兰博', '男', '2018-04-05', '机械公敌', '2016003班', '班德尔城', '组织部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:22', '刘镔琛', '2018-04-29 03:44:22', '刘镔琛');
INSERT INTO `user` VALUES ('00000000089', '201600304', '123', '提莫', '男', '2018-04-12', '迅捷斥候', '2016003班', '班德尔城', '组织部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:24', '刘镔琛', '2018-04-29 03:44:24', '刘镔琛');
INSERT INTO `user` VALUES ('00000000090', '201600305', '123', '崔丝塔娜', '女', '2018-04-12', '麦林炮手', '2016003班', '班德尔城', '组织部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:26', '刘镔琛', '2018-04-29 03:44:26', '刘镔琛');
INSERT INTO `user` VALUES ('00000000091', '201600306', '123', '维迦', '男', '2018-04-12', '邪恶小法师', '2016003班', '班德尔城', '组织部', '干事', '12312312312', '123@qq.com', '123123', '', '', '', '0', '0', '0', '0', '0', '0', '2018-04-29 03:44:28', '刘镔琛', '2018-04-30 18:24:23', '刘镔琛');
INSERT INTO `user` VALUES ('00000000093', '201600501', '123', '艾希', '女', '2018-05-09', '寒冰射手', '2016005班', '弗雷尔卓德', '学习部', '干事', '123123', '123@qq.com', '123132', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:04', '刘镔琛', '2018-05-01 00:47:04', '刘镔琛');
INSERT INTO `user` VALUES ('00000000094', '201600502', '123', '丽桑卓', '女', '2018-05-09', '冰霜女巫', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:07', '刘镔琛', '2018-05-01 00:47:07', '刘镔琛');
INSERT INTO `user` VALUES ('00000000095', '201600503', '123', '瑟庄妮', '女', '2018-05-10', '北地之怒', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:11', '刘镔琛', '2018-05-01 00:47:11', '刘镔琛');
INSERT INTO `user` VALUES ('00000000096', '201600504', '123', '泰达米尔', '男', '2018-05-09', '蛮族之王', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:14', '刘镔琛', '2018-05-01 00:47:14', '刘镔琛');
INSERT INTO `user` VALUES ('00000000097', '201600505', '123', '布隆', '男', '2018-05-03', '弗雷尔卓德之心', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:16', '刘镔琛', '2018-05-01 00:47:16', '刘镔琛');
INSERT INTO `user` VALUES ('00000000098', '201600506', '123', '努努', '男', '2018-05-10', '雪人骑士', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:19', '刘镔琛', '2018-05-01 00:47:19', '刘镔琛');
INSERT INTO `user` VALUES ('00000000099', '201600507', '123', '奥拉夫', '男', '2018-05-01', '狂战士', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:23', '刘镔琛', '2018-05-01 00:47:23', '刘镔琛');
INSERT INTO `user` VALUES ('00000000100', '201600508', '123', '艾尼维亚', '女', '2018-05-03', '冰晶凤凰', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:26', '刘镔琛', '2018-05-01 00:47:26', '刘镔琛');
INSERT INTO `user` VALUES ('00000000101', '201600509', '123', '特朗德尔', '男', '2018-05-15', '巨魔之王', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:28', '刘镔琛', '2018-05-01 00:47:28', '刘镔琛');
INSERT INTO `user` VALUES ('00000000102', '201600510', '123', '乌迪尔', '男', '2018-05-16', '兽灵行者', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:33', '刘镔琛', '2018-05-01 00:47:33', '刘镔琛');
INSERT INTO `user` VALUES ('00000000103', '201600511', '123', '沃利贝尔', '男', '2018-05-24', '雷霆咆哮', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:35', '刘镔琛', '2018-05-01 00:47:35', '刘镔琛');
INSERT INTO `user` VALUES ('00000000104', '201600512', '123', '奥恩', '男', '2018-05-16', '山隐之焰', '2016005班', '弗雷尔卓德', '学习部', '干事', '1', '1', '1', '', '', '', '0', '0', '0', '0', '0', '0', '2018-05-01 00:47:38', '刘镔琛', '2018-05-01 00:47:38', '刘镔琛');
