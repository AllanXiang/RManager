package com.xzy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Global {
	public static final Map<String, String> provincelist = new HashMap<String, String>() {
		{
			put("110000", "北京"); put("120000", "天津"); put("130000", "河北"); put("140000", "山西"); put("150000", "内蒙古");
			put("210000", "辽宁"); put("220000", "吉林"); put("230000", "黑龙江");
			put("310000", "上海"); put("320000", "江苏"); put("330000", "浙江"); put("340000", "安徽"); put("350000", "福建"); put("360000", "江西"); put("370000", "山东");
			put("410000", "河南"); put("420000", "湖北"); put("430000", "湖南"); 
			put("440000", "广东"); put("450000", "广西"); put("460000", "海南");
			put("500000", "重庆"); put("510000", "四川"); put("520000", "贵州"); put("530000", "云南"); put("540000", "西藏");
			put("610000", "陕西"); put("620000", "甘肃"); put("630000", "青海"); put("640000", "宁夏"); put("650000", "新疆");
		}
	};

	public static final Map<String, String> pinyinmap = new HashMap<String, String>() {
		{
			put("110000", "BJ"); put("120000", "TJ"); put("130000", "HE"); put("140000", "SX"); put("150000", "NM");
			put("210000", "LN"); put("220000", "JL"); put("230000", "HL");
			put("310000", "SH"); put("320000", "JS"); put("330000", "ZJ"); put("340000", "AH"); put("350000", "FJ"); put("360000", "JX"); put("370000", "SD");
			put("410000", "HA"); put("420000", "HB"); put("430000", "HN");
			put("440000", "GD"); put("450000", "GX"); put("460000", "HI");
			put("500000", "CQ"); put("510000", "SC"); put("520000", "GZ"); put("530000", "YN"); put("540000", "XZ");
			put("610000", "SN"); put("620000", "GS"); put("630000", "QH"); put("640000", "NX"); put("650000", "XJ");
		}
	};
	
	public static final Map<Integer, String> searchcondition = new HashMap<Integer, String>(){
		{
			put(0, "正在查询");
			put(1, "成功");
			put(2, "无结果");
			put(3, "无法连接");
			put(4, "数据库存在");
			put(5, "登录失败");
			put(6, "获取页面失败");
			put(7, "页面分析错误");
			put(8, "手工输入完成");
			put(9, "已校正");
		}
	};
	
	public static final List<String> provincecode = new ArrayList<String>(){{
			add("110000"); add("120000"); add("130000"); add("140000"); add("150000");
			add("210000"); add("220000"); add("230000");
			add("310000"); add("320000"); add("330000"); add("340000"); add("350000"); add("360000"); add("370000");
			add("410000"); add("420000"); add("430000"); 
			add("440000"); add("450000"); add("460000");
			add("500000"); add("510000"); add("520000"); add("530000"); add("540000");
			add("610000"); add("620000"); add("630000"); add("640000"); add("650000");
	}};

	public static final Map<String, String> str2code = new HashMap<String, String>() {
		{
			put("北京市", "110000"); put("天津市", "120000"); put("河北省", "130000"); put("山西省", "140000"); put("内蒙古省", "150000");
			put("辽宁省", "210000"); put("吉林省", "220000"); put("黑龙江省", "230000");
			put("上海市", "310000"); put("江苏省", "320000"); put("浙江省", "330000"); put("安徽省", "340000"); put("福建省", "350000"); put("江西省", "360000"); put("山东省", "370000");
			put("河南省", "410000"); put("湖北省", "420000"); put("湖南省", "430000");
			put("广东省", "440000"); put("广西省", "450000"); put("海南省", "460000");
			put("重庆市", "500000"); put("四川省", "510000"); put("贵州省", "520000"); put("云南省", "530000"); put("西藏省", "540000");
			put("陕西省", "610000"); put("甘肃省", "620000"); put("青海省", "630000"); put("宁夏省", "640000"); put("新疆省", "650000");

			put("北京", "110000"); put("天津", "120000"); put("河北", "130000"); put("山西", "140000"); put("内蒙古", "150000");
			put("辽宁", "210000"); put("吉林", "220000"); put("黑龙江", "230000");
			put("上海", "310000"); put("江苏", "320000"); put("浙江", "330000"); put("安徽", "340000"); put("福建", "350000"); put("江西", "360000"); put("山东", "370000");
			put("河南", "410000"); put("湖北", "420000"); put("湖南", "430000");
			put("广东", "440000"); put("广西", "450000"); put("海南", "460000");
			put("重庆", "500000"); put("四川", "510000"); put("贵州", "520000"); put("云南", "530000"); put("西藏", "540000");
			put("陕西", "610000"); put("甘肃", "620000"); put("青海", "630000"); put("宁夏", "640000"); put("新疆", "650000");
		}
	};
}