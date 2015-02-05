package com.xzy.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public final class QueryUtils {

	private static Logger logger = Logger.getLogger(QueryUtils.class);

	private static final Map<String, String> TITLE_MAP = new HashMap<String, String>();
	static
	{
		TITLE_MAP.put("corpBaseNationalInfo", "企业基本信息");
		TITLE_MAP.put("errorMessage", "错误信息");
		TITLE_MAP.put("corpName", "企业名称");
		TITLE_MAP.put("registerNo", "工商注册号");
		TITLE_MAP.put("registDate", "注册日期");
		TITLE_MAP.put("artificialName", "负责人");
		TITLE_MAP.put("status", "企业当前状态");
		TITLE_MAP.put("registFund", "注册资金");
		TITLE_MAP.put("manageRange", "经营范围");
		TITLE_MAP.put("openDate", "开业日期");
		TITLE_MAP.put("manageBeginDate", "经营开始日期");
		TITLE_MAP.put("manageEndDate", "经营截止日期");
		TITLE_MAP.put("corpType", "企业类型");
		TITLE_MAP.put("registerDepartment", "工商登记机关");
		TITLE_MAP.put("registerAddress", "注册地址");
		
		TITLE_MAP.put("nationalCorpShareholderInfo", "企业股东信息");
		TITLE_MAP.put("name", "名称");
		TITLE_MAP.put("type", "股东类型");
		TITLE_MAP.put("certType", "证照类型");
		TITLE_MAP.put("certID", "证照号码");
		TITLE_MAP.put("contributiveType", "出资方式");
		TITLE_MAP.put("contributiveFund", "认缴出资额(万元)");
		
		TITLE_MAP.put("nationalCorpManagementInfo", "企业主要人员信息");
		TITLE_MAP.put("role", "职务");

		TITLE_MAP.put("nationalCorpBranchInfo", "企业分支机构信息");
		TITLE_MAP.put("branchName", "分支机构名称");
		
		TITLE_MAP.put("penaltyInfos", "企业行政处罚信息");
		TITLE_MAP.put("recordNo", "处罚文号");
		TITLE_MAP.put("affair", "违法行为");
		TITLE_MAP.put("panalty", "处罚结果");
		TITLE_MAP.put("execDepartment", "执行机关");
		TITLE_MAP.put("recordDate", "签发日期");

	}
	private static final String XML_STRINGS_PREFIX = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n  <conditions>\n";
	private static final String XML_STRINGS_SUBFIX = "  </conditions>\n";
	private static final String[] CONDITION_STRINGS = new String[] {
			"    <condition queryType=\"90001\">\n",
			"      <item>\n",
			"        <name>registerNo</name>\n",
			"        <value></value>\n",//3
			"      </item>\n",
			"      <item>\n",//5
			"        <name>corpName</name>\n",//6
			"        <value></value>\n",//7
			"      </item>\n",//8
			"      <item>\n",
			"          <name>province</name>\n",
			"          <value></value>\n", //11
			"      </item>\n",
			"      <item>\n",
			"        <name>refID</name>\n",
			"        <value></value>\n",//15
			"      </item>\n",
			"    </condition>\n"};
	
	public static String getConditionString(String regCode, String name, int refID)
	{
		final String VALUE_TEMPLATE_PREFIX = "        <value>";
		final String VALUE_TEMPLATE_SUBFIX = "</value>\n";
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<CONDITION_STRINGS.length; i++) {
			if(name.length()==0 && i>=5 && i<=8)
				continue;
				
			if(i==3) {
				sb.append(VALUE_TEMPLATE_PREFIX);
				sb.append(regCode);
				sb.append(VALUE_TEMPLATE_SUBFIX);
			}
			else if(i==7) {
				sb.append(VALUE_TEMPLATE_PREFIX);
				sb.append(name);
				sb.append(VALUE_TEMPLATE_SUBFIX);
			}
			else if(i==11) {
				sb.append(VALUE_TEMPLATE_PREFIX);
				sb.append(regCode.substring(0, 2));
				sb.append("0000");
				sb.append(VALUE_TEMPLATE_SUBFIX);
			}
			else if(i==15) {
				sb.append(VALUE_TEMPLATE_PREFIX);
				sb.append(refID);
				sb.append(VALUE_TEMPLATE_SUBFIX);
			}			
			else
				sb.append(CONDITION_STRINGS[i]);
		}
		return sb.toString();
	}
	
	public static String getTitleMap(String s)
	{
		String title = TITLE_MAP.get(s);
		if(title!=null)
			return title;
		else
			return s;
	}
	
	public static String tableTitleHTML(String title)
	{
		return "<tr><th bgcolor=#D8D8D8 colspan=\"2\">" +
				title + "</th></tr>\n";
	}
	
	public static String tableItemHTML(String subTitle, String value)
	{
		return "<tr><th>" + subTitle + "</th><td>" +
				value + "</td></tr>\n";
	}
	
	public static String XMLToHTMLTable(String text)
	{
		StringBuilder sb = new StringBuilder();
		try {
			Document document = DocumentHelper.parseText(text);
			Element root = document.getRootElement();
			
			if(root == null)
			{
	            sb.append(tableTitleHTML("Error parsing query result..."));
	            return sb.toString();
			}
			
	        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
	            Element infoE = (Element) i.next();
	            sb.append(tableTitleHTML(getTitleMap(infoE.getName())));
	            
	            String result = infoE.attributeValue("treatResult");
	            if(result.compareTo("1") == 0)
	            {
	            	for ( Iterator i2 = infoE.elementIterator(); i2.hasNext(); ) {
		            	Element itemE = (Element) i2.next();
		            	if(!itemE.getName().equals("item"))
		            		continue;
		            	for ( Iterator i3 = itemE.elementIterator(); i3.hasNext(); ) {
		            		Element subItemE = (Element) i3.next();
		            		sb.append(tableItemHTML(getTitleMap(subItemE.getName()), subItemE.getTextTrim()));
		            	}
	            	}
	            }
	            else
	            {
	            	String subTitle = "查询错误";
	            	String value = (result.compareTo("2") == 0)?
	            			"该内容无结果":infoE.attributeValue("errorMessage");
	            	
            		sb.append(tableItemHTML(subTitle, value));
	            }
	        }
		} catch(DocumentException e){
			logger.error("Error parsing XML: ");
			logger.error(text);
			logger.error("Exception occurs: "+e.toString());
		}
        return sb.toString();
	}

}
