package com.zbxh.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.DocumentHelper;
import org.apache.commons.lang.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
//import org.dom4j.Node;

import com.zbxh.databean.DoUnitData;
import com.zbxh.databean.JdData;

public class XMLToJson {
	public static String scSql(String sql) {
		String result = "[\"";
		sswServices service = new sswServices("ExecuteSql");
		String sss = service.getByPost("sql=" + sql);
		sss = StringEscapeUtils.unescapeXml(sss);
		String s1 = "<int xmlns=\"http://zbxhupdata.com/webservices/\">";
		int i1 = sss.indexOf(s1);
		if (i1 >= 0) {
			sss = sss.substring(i1 + s1.length());
		}

		String s2 = "</int>";
		int pos = sss.indexOf(s2);
		if (pos >= 0) {
			sss = sss.substring(0, pos);
		}
		result += sss;
		result += "\"]";
		return result;
	}

	public static String QueryDataSql(String sql) {
		String result = "[";

		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			Document document = DocumentHelper.parseText(sss);
			Element root = document.getRootElement();
			List<Element> list = root.elements("Table");
			for (Element element : list) {
				result += element.element("COUNT_x0028__x002A__x0029_").getTextTrim();

			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public static String Qdata(String sql, String id) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("编码").getTextTrim(); // +"<span
																			// color=\"red\">"
																			// </span>
					result += "\",\"" + element.element("名称").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata1(String sql, String id) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					// if(element.element("所属单位").getTextTrim().equals(id)){
					result += "[\"" + element.element("ID").getTextTrim(); // +"<span
																			// color=\"red\">"
																			// </span>
					result += "\",\"" + element.element("NAME").getTextTrim() + "\"";
					result += "],";
					// }
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata2(String sql, String id) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					// if(element.element("所属单位").getTextTrim().equals(id)){
					result += "[\"" + element.element("PERSONID").getTextTrim(); // +"<span
																					// color=\"red\">"
																					// </span>
					result += "\",\"" + element.element("姓名").getTextTrim() + "\"";
					result += "],";
					// }
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询行业的编号，
	public static String QueryHYNum(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "\"" + element.element("HYCODE").getTextTrim() + "\"";
				}
			}
			// result=result.substring(0, result.length()-1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询专业的编号
	public static String QueryZYNum(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "\"" + element.element("ZYCODE").getTextTrim() + "\""; // +"<span
																						// color=\"red\">"
																						// </span>
				}
			}
			// result=result.substring(0, result.length()-1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String QuerySoftNum(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("软件名称");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "";
						}
					}
				}

			}

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 读取软件名称
	public static String QuerySoftName(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("软件名称");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}

			}

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 读取项目名称
	public static String QuerySoftProName(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("项目名称");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}
			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 读取软件编号
	public static String QuerySoftBianHao(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("软件编号");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}
			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 读取端类别
	public static String QueryDuanLb(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("端类别");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}
			}

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 读取问题类型，加载选项

	public static String QueryWtlx(String sql) {
		String result = "[\"请选择\",";
		String result1 = "[[\"无选项\",";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("问题类型");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\",";
						} else {
							result += "\"0\"";
						}
					}
				}
			}
			result = result.substring(0, result.length() - 1);

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// cha查询行业
	public static String QueryDataHy(String sql) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("HYCODE").getTextTrim();
					result += "\",\"" + element.element("HYNAME").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询专业
	public static String QueryDataZy(String sql) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("ZYCODE").getTextTrim();
					result += "\",\"" + element.element("ZYNAME").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询ruanjian 软件使用级别，根据软件注册是的级别查询
	public static String Queryunitlevel(String sql) {
		String result = "请选择,";
		String result1 = "无选项,";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += element.element("使用级别").getTextTrim();
				}
			}

			result = result.substring(0, result.length() - 1);
			String[] arrsq = result.split(",");
			String sq2 = "";
			for (int i = 0; i < arrsq.length; i++) {
				sq2 += "\"" + arrsq[i] + "\",";
			}
			result = "[" + sq2.substring(0, sq2.length() - 1) + "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询使用级别
	public static String QueryDataLevel(String sql) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("LEVELCODE").getTextTrim();
					result += "\",\"" + element.element("LEVELNAME").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata3(String sql) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {

					result += "[\"" + element.element("NID").getTextTrim(); // +"<span
																			// color=\"red\">"
																			// </span>
					result += "\",\"" + element.element("名称").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata4(String sql, String id) {
		String result = "[[\"请选择\",\"请选择\"],";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("软件编号").getTextTrim(); // +"<span
																				// color=\"red\">"
																				// </span>
					result += "\",\"" + element.element("软件名称").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 表格部分
	// 表格1部分
	public static String QdataRegist(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		int i;
		String arr[] = { "服务端", "客户端" };
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				i = 1;
				Element element1 = null;
				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}

					id += "\"" + i + "\",";

					element1 = element.element("行业");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("专业");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("软件名称");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("使用级别");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("端类别");
					if (element1 != null) {
						id5 += "\"";
						id5 += arr[Integer.parseInt(element1.getTextTrim())] + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("WEB项目名");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}
					element1 = element.element("软件说明");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}

					i++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);

				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id7 = id7.replaceAll("\\\\", "\\\\\\\\");
				pguid += "],";

				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "]";
				result += pguid + id + id1 + id2 + id3 + id4 + id5 + id6 + id7 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 表格2
	public static String QdataIntall(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		int i;
		String arr[] = { "请选择", "总公司", "路局", "电务段", "车间", "班组", "个人" };
		String arr2[] = { "请选择", "总公司", "路局", "通信段", "车间", "班组", "个人" };
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				i = 1;
				Element element1 = null;
				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}

					id += "\"" + i + "\",";
					element1 = element.element("安装单位名称");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("安装单位级别");
					if (element1 != null) {
						id2 += "\"";
						if (element.element("专业").getTextTrim().equals("信号")) {
							id2 += arr[Integer.parseInt(element1.getTextTrim())] + "\",";
						}
						if (element.element("专业").getTextTrim().equals("通信")) {
							id2 += arr2[Integer.parseInt(element1.getTextTrim())] + "\",";
						}

					} else {
						id2 += "\"\",";
					}

					element1 = element.element("上级单位名称");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("软件名称");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("安装版本号");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("安装服务器IP");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("安装服务器端口");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}

					element1 = element.element("服务端代理程序路径");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("安装日期");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}

					element1 = element.element("安装人");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}

					element1 = element.element("备注");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}

					i++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);

				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id11 = id11.substring(0, id11.length() - 1);
				id11 = id11.replaceAll("\\\\", "\\\\\\\\");

				pguid += "],";

				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "]";
				result += pguid + id + id1 + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + id10 + id11 + "]";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 表格3
	public static String QdataProQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		String id12 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("单位");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("上级单位");//原来下级单位八月十一日修改
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("部门");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("人员");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("联系电话");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("软件系统");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("提出时间");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("问题类型");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}
					element1 = element.element("是否解决");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("解决时间");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}
					element1 = element.element("问题描述");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}
					element1 = element.element("备注");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}
					element1 = element.element("截图");
					if (element1 != null) {
						id12 += "\"";
						id12 += element1.getTextTrim() + "\",";
					} else {
						id12 += "\"\",";
					}
					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id10 = id10.replaceAll("\\\\", "\\\\\\\\");
				id11 = id11.substring(0, id11.length() - 1);
				id11 = id11.replaceAll("\\\\", "\\\\\\\\");
				id12 = id12.substring(0, id12.length() - 1);
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "],";
				id12 += "]";

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + id10 + id11 + id12
						+ "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 软件问题表格数据
	public static String QdataProQuery1(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String wtnum = "[";
		String id5 = "[";
		String tcr = "[";// 提出人
		String fsbb = "[";// 发生版本
		String jjsj = "[";// 解决时间
		String jjbb = "[";// 解决版本
		String wtlxfslx="[";//wtlxfslx分类（问题类型分数类型）
		String gn="[";//功能
		String id4 = "[";//问题描述
		String fsyy = "[";//发生原因
		String cxyfk = "[";//程序员反馈
		String gsyj = "[";//公司意见
		String yjwcsj = "[";//预计完成时间
		String jjbf = "[";//解决办法
		String lxdh = "[";//联系电话
		
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\""+ element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("问题编号");
					if (element1 != null) {
						wtnum += "\""+ element1.getTextTrim() + "\",";
					} else {
						wtnum += "\"\",";
					}
					element1 = element.element("单位");
					if (element1 != null) {
						id += "\""+ element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}
					element1 = element.element("上级单位");//原来下级单位八月十一日修改
					if (element1 != null) {
						id1 += "\""+ element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("部门");
					if (element1 != null) {
						id2 += "\""+ element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					// .......八月二号........提出人
					element1 = element.element("人员");
					if (element1 != null) {
						tcr += "\""+ element1.getTextTrim() + "\",";
					} else {
						tcr += "\"\",";
					}

					element1 = element.element("提出时间");
					if (element1 != null) {
						id3 += "\""+ element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}
					// .......八月二号........提出版本
					element1 = element.element("发生版本");
					if (element1 != null) {
						fsbb += "\""+ element1.getTextTrim() + "\",";
					} else {
						fsbb += "\"\",";
					}
					// .......八月二号.......解决时间.
					element1 = element.element("解决时间");
					if (element1 != null) {
						jjsj += "\""+ element1.getTextTrim() + "\",";
					} else {
						jjsj += "\"\",";
					}
					// .......八月二号.......解决时间.
					element1 = element.element("解决版本");
					if (element1 != null) {
						jjbb += "\"" + element1.getTextTrim() + "\",";
					} else {
						jjbb += "\"\",";
					}
					// .......八月二号.......分类（问题类型分数类型）
					element1 = element.element("问题类型分属类型");
					if (element1 != null) {
						wtlxfslx += "\"" + element1.getTextTrim() + "\",";
					} else {
						wtlxfslx += "\"\",";
					}
					// .......八月二号.......分类（问题类型分数类型）
					element1 = element.element("功能");
					if (element1 != null) {
						gn += "\"" + element1.getTextTrim() + "\",";
					} else {
						gn += "\"\",";
					}

					element1 = element.element("问题描述");
					if (element1 != null) {
						id4 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					// .......八月二号.......发生原因
					element1 = element.element("发生原因");
					if (element1 != null) {
						fsyy += "\"" + element1.getTextTrim() + "\",";
					} else {
						fsyy += "\"\",";
					}
					// .......八月二号.......程序员反馈
					element1 = element.element("程序员反馈");
					if (element1 != null) {
						cxyfk += "\"" + element1.getTextTrim() + "\",";
					} else {
						cxyfk += "\"\",";
					}
					// .......八月三号.......程序员反馈
					element1 = element.element("公司意见");
					if (element1 != null) {
						gsyj += "\"" + element1.getTextTrim() + "\",";
					} else {
						gsyj += "\"\",";
					}
					// .......八月三号.......预计完成时间
					element1 = element.element("预计完成时间");
					if (element1 != null) {
						yjwcsj += "\"" + element1.getTextTrim() + "\",";
					} else {
						yjwcsj += "\"\",";
					}
					// .......八月三号.......解决办法
					element1 = element.element("解决办法");
					if (element1 != null) {
						jjbf += "\"" + element1.getTextTrim() + "\",";
					} else {
						jjbf += "\"\",";
					}
					// .......八月三号.......联系电话
					element1 = element.element("联系电话");
					if (element1 != null) {
						lxdh += "\"" + element1.getTextTrim() + "\",";
					} else {
						lxdh += "\"\",";
					}

					element1 = element.element("备注");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				wtnum = wtnum.substring(0, wtnum.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				tcr = tcr.substring(0, tcr.length() - 1);// 提出人
				id3 = id3.substring(0, id3.length() - 1);
				fsbb = fsbb.substring(0, fsbb.length() - 1);// 发生版本
				jjsj = jjsj.substring(0, jjsj.length() - 1);// 解决时间
				jjbb = jjbb.substring(0, jjbb.length() - 1);// 解决版本
				wtlxfslx = wtlxfslx.substring(0, wtlxfslx.length() - 1);// 解决版本
				gn = gn.substring(0, gn.length() - 1);// 功能
				id4 = id4.substring(0, id4.length() - 1);
				id4 = id4.replaceAll("\\\\", "\\\\\\\\");
				fsyy = fsyy.substring(0, fsyy.length() - 1);// 发生原因
				cxyfk = cxyfk.substring(0, cxyfk.length() - 1);// 程序员反馈
				gsyj = gsyj.substring(0, gsyj.length() - 1);// 公司意见
				yjwcsj = yjwcsj.substring(0, yjwcsj.length() - 1);// 预计完成时间
				jjbf = jjbf.substring(0, jjbf.length() - 1);// 解决办法
				lxdh = lxdh.substring(0, lxdh.length() - 1);// 联系电话
				id5 = id5.substring(0, id5.length() - 1);//备注
				id5 = id5.replaceAll("\\\\", "\\\\\\\\");
				pguid += "],";
				i += "],";
				wtnum+="],";
				id += "],";
				id1 += "],";
				id2 += "],";
				tcr += "],";
				id3 += "],";
				fsbb += "],";
				jjsj += "],";
				jjbb += "],";
				wtlxfslx+="],";
				gn+="],";
				id4 += "],";
				fsyy+="],";
				cxyfk+="],";
				gsyj+="],";
				yjwcsj+="],";
				jjbf+="],";
				lxdh+="],";
				id5 += "]";
				result += pguid + i+wtnum + id1 + id + id2 + tcr + id3 + fsbb +jjsj+jjbb+wtlxfslx+ gn+id4+fsyy+cxyfk+gsyj +yjwcsj+jjbf+lxdh+ id5 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 工程安装显示------------可删除  没用了  9月2日 记
	public static String QdataProQuerygc1(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("单位");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("上级单位");//原来下级单位八月十一日修改
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("软件系统");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("提出时间");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("问题描述");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("备注");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id4 = id4.replaceAll("\\\\", "\\\\\\\\");
				id5 = id5.substring(0, id5.length() - 1);
				id5 = id5.replaceAll("\\\\", "\\\\\\\\");
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "]";

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 工程安装全部信息查询
	public static String QdataProQuerygc(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";

		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("单位");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("上级单位");//原来下级单位八月十一日修改
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("软件系统");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("提出时间");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("问题类型");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("是否解决");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("解决时间");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("问题描述");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}
					element1 = element.element("备注");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("截图");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}

					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id7 = id7.replaceAll("\\\\", "\\\\\\\\");
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);

				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "]";

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public static String jdsxQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String id1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "]";
				result += id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 进度实施查询表头
	public static String tableQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String id1 = "[";
		String id2 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("阶段名称");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("负责人");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id1 += "]";
				id2 += "]";
				result += id1 + "," + id2 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 进度实施查询表格数据
	public static String tabledataQuery(String sql, String sqjieduanname) {

		List<JdData> JdData1 = new ArrayList<>();
		JdData1.clear();
		int jiequ = sqjieduanname.indexOf("],[");
		if (jiequ < 0) {
			return "[]";
		}
		sqjieduanname = sqjieduanname.substring(0, jiequ);
		sqjieduanname = sqjieduanname.replace("[", "");
		sqjieduanname = sqjieduanname.replace("]", "");
		String[] array = sqjieduanname.split(",");
		String[] arrayname = { "一阶段", "二阶段", "三阶段", "四阶段", "五阶段", "六阶段", "七阶段", "八阶段", "九阶段", "十阶段" };
		String result = "[";
		String result1 = "[]";

		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					JdData mJdData = new JdData();
					element1 = element.element("单位名称");
					if (element1 != null) {
						mJdData.UnitName = element1.getTextTrim();
					}
					element1 = element.element("上级单位");
					if (element1 != null) {
						mJdData.UpUnitName = element1.getTextTrim();
					}
					element1 = element.element("PGUID");
					if (element1 != null) {
						mJdData.Pguid = element1.getTextTrim();
					}
					for (int i = 0; i < array.length; i++) {
						array[i] = arrayname[i];
						element1 = element.element(array[i]);
						if (element1 != null) {
							mJdData.JdStr[i] = element1.getTextTrim();
						}
					}
					element1 = element.element("单位级别");
					if (element1 != null) {
						mJdData.Type = element1.getTextTrim();
					}
					element1 = element.element("进度备注");
					if (element1 != null) {
						mJdData.jdBeizhu = element1.getTextTrim();
						mJdData.jdBeizhu = mJdData.jdBeizhu.replaceAll("\\\\", "\\\\\\\\");
					}
					JdData1.add(mJdData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (JdData1.size() == 0) {
			return "[]";
		}
		DoUnitData mDoUnitData = new DoUnitData(JdData1);
		String json = mDoUnitData.doMyjieduanvalue(array.length);
		return json;
	}

	// 查询阶段定义信息
	public static String jieduanQuery(String sql) {

		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String arr[] = { "请选择", "第一阶段", "第二阶段", "第三阶段", "第四阶段", "第五阶段", "第六阶段", "第七阶段", "第八阶段", "第九阶段", "第十阶段" };
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("字段名称");
					if (element1 != null) {
						id += "\"" + arr[Integer.parseInt(element1.getTextTrim())] + "\",";
					} else {
						id += "\"\",";
					}
					element1 = element.element("阶段名称");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("负责人");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					ii++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "]";
				result += pguid + i + id + id1 + id2 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 工程实施查询所有加载表格
	public static String impTableQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		List<JdData> JdData1 = new ArrayList<>();
		JdData1.clear();
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					JdData mJdData = new JdData();
					element1 = element.element("PGUID");
					if (element1 != null) {
						mJdData.Pguid = element1.getTextTrim();
					}
					element1 = element.element("单位名称");
					if (element1 != null) {
						mJdData.UnitName = element1.getTextTrim();
					}
					element1 = element.element("施工计划");
					if (element1 != null) {
						mJdData.Sgplay = element1.getTextTrim();
					}
					element1 = element.element("联系人");
					if (element1 != null) {
						mJdData.Sgtellphone = element1.getTextTrim();
					}
					element1 = element.element("公司负责人");
					if (element1 != null) {
						mJdData.Gstellphone = element1.getTextTrim();
					}
					element1 = element.element("工程备注");
					if (element1 != null) {
						mJdData.Beizhu = element1.getTextTrim();
						mJdData.Beizhu = mJdData.Beizhu.replaceAll("\\\\", "\\\\\\\\");
					}
					element1 = element.element("上级单位");
					if (element1 != null) {
						mJdData.UpUnitName = element1.getTextTrim();
					}
					element1 = element.element("单位级别");
					if (element1 != null) {
						mJdData.Type = element1.getTextTrim();
					}
					JdData1.add(mJdData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (JdData1.size() == 0) {
			return "[]";
		}
		DoUnitData mDoUnitData = new DoUnitData(JdData1);
		String json = mDoUnitData.doMyUnitName();
		return json;
	}

	// gongshis工程实施单位名称查询
	public static String implementQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String id1 = "[\"请选择\",";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("单位名称");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "]";
				result += id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 工程实施修改查询内容
	public static String impTableQuerych(String sql) {
		String result = "[";
		String result1 = "[]";
		String i = "[";
		int ii = 1;
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String pguid = "[";

		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					ii++;
					element1 = element.element("单位名称");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("施工计划");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					element1 = element.element("联系人");
					if (element1 != null) {
						id3 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}
					element1 = element.element("公司负责人");
					if (element1 != null) {
						id4 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("工程备注");
					if (element1 != null) {
						id5 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}
					element1 = element.element("单位级别");
					if (element1 != null) {
						id6 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}
					element1 = element.element("上级单位");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id5 = id5.replaceAll("\\\\", "\\\\\\\\");
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				/*
				 * id1 += "]"; id2 += "]"; id3 += "]"; id4 += "]"; id5 += "]";
				 * id6 += "]"; id7 += "]"; pguid += "]"; i += "]";
				 */
				result += pguid + "]," + i + "]," + id1 + "]," + id2 + "]," + id3 + "]," + id4 + "]," + id5 + "]," + id6
						+ "]," + id7 + "]]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 用户表

	public static String QdataUser(String sql) {
		String result = "[";
		String result1 = "[[\"无选项\",\"无选项\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				String element1 = null;
				for (Element element : list) {
					result += "[\"" + element.element("USERID").getTextTrim();
					result += "\",\"" + element.element("部门").getTextTrim() + "\"";
					result += ",\"" + element.element("用户名").getTextTrim() + "\"";
					result += ",\"" + element.element("密码").getTextTrim() + "\"";
					element1 = element.element("权限").getTextTrim();
					if (element1 != null) {
						result += ",\"" + element1 + "\"";
					} else {
						result += ",\"\"";
					}
					result += ",\"" + element.element("是否编辑").getTextTrim() + "\"";

					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//

	public static String QdataUserTable(String sql) {
		String result = "[";
		String result1 = "[]";
		/* String pguid="["; */
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					i += "\"" + ii + "\",";
					element1 = element.element("USERID");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("部门");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("用户名");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("密码");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("权限");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("是否编辑");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}
					ii++;

				}

				/* pguid=pguid.substring(0, pguid.length()-1); */
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);

				/* pguid+="],"; */
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "]";

				result += id + i + id1 + id2 + id3 + id4 + id5 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 问题修改前数据查询加载

	public static String QdataCHQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		//String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		String id12 = "[";
		String id13 = "[";
		
	
		String id14 = "[";
		String id15 = "[";
		String id16 = "[";
		String id17 = "[";
		String id18 = "[";
		String id19 = "[";
		String id20 = "[";
     
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("单位");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("上级单位");//原来下级单位八月十一日修改
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("部门");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("人员");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("联系电话");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("软件系统");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("提出时间");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					/*element1 = element.element("问题类型");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}*/
					element1 = element.element("问题描述");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("行业");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}
					element1 = element.element("专业");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}
					element1 = element.element("截图");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}
					element1 = element.element("备注");
					if (element1 != null) {
						id12 += "\"";
						id12 += element1.getTextTrim() + "\",";
					} else {
						id12 += "\"\",";
					}
					element1 = element.element("问题类型分属类型");
					if (element1 != null) {
						id13 += "\"";
						id13 += element1.getTextTrim() + "\",";
					} else {
						id13 += "\"\",";
					}
					
					//八月五号添加
					element1 = element.element("发生版本");
					if (element1 != null) {
						id14 += "\"";
						id14 += element1.getTextTrim() + "\",";
					} else {
						id14 += "\"\",";
					}
					element1 = element.element("功能");
					if (element1 != null) {
						id15 += "\"";
						id15 += element1.getTextTrim() + "\",";
					} else {
						id15 += "\"\",";
					}
					element1 = element.element("发生原因");
					if (element1 != null) {
						id16 += "\"";
						id16 += element1.getTextTrim() + "\",";
					} else {
						id16 += "\"\",";
					}
					element1 = element.element("程序员反馈");
					if (element1 != null) {
						id17 += "\"";
						id17 += element1.getTextTrim() + "\",";
					} else {
						id17 += "\"\",";
					}
					element1 = element.element("公司意见");
					if (element1 != null) {
						id18 += "\"";
						id18 += element1.getTextTrim() + "\",";
					} else {
						id18 += "\"\",";
					}
					element1 = element.element("修改计划");
					if (element1 != null) {
						id19 += "\"";
						id19 += element1.getTextTrim() + "\",";
					} else {
						id19 += "\"\",";
					}
					element1 = element.element("解决办法");
					if (element1 != null) {
						id20 += "\"";
						id20 += element1.getTextTrim() + "\",";
					} else {
						id20 += "\"\",";
					}
					
					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				//id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id11 = id11.substring(0, id11.length() - 1);
				id12 = id12.substring(0, id12.length() - 1);
				id12 = id12.replaceAll("\\\\", "\\\\\\\\");
				id13 = id13.substring(0, id13.length() - 1);
				
				id14 = id14.substring(0, id14.length() - 1);
				id15 = id15.substring(0, id15.length() - 1);
				id16 = id16.substring(0, id16.length() - 1);
				id17 = id17.substring(0, id17.length() - 1);
				id18 = id18.substring(0, id18.length() - 1);
				id19 = id19.substring(0, id19.length() - 1);
				id20 = id20.substring(0, id20.length() - 1);
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
			//	id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "],";
				id12 += "],";
				
				id13 += "],";
				id14 += "],";
				id15 += "],";
				id16 += "],";
				id17 += "],";
				id18 += "],";
				id19 += "],";
				id20 += "]";
				

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + id6 +  id8 + id9 + id10 + id11 + id12
						+ id13+ id14 +id15 +id16 +id17+id18 +id19 +id20 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 安装记录修改
	public static String QdataCHQuery2(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		String id12 = "[";
		String id13 = "[";
		int i;
		String arr[] = { "请选择", "总公司", "路局", "电务段", "车间", "班组", "个人" };
		String arr2[] = { "请选择", "总公司", "路局", "通信段", "车间", "班组", "个人" };
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				i = 1;
				Element element1 = null;
				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}

					id += "\"" + i + "\",";
					element1 = element.element("安装单位名称");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("安装单位级别");
					if (element1 != null) {
						id2 += "\"";
						if (element.element("专业").getTextTrim().equals("信号")) {
							id2 += arr[Integer.parseInt(element1.getTextTrim())] + "\",";
						}
						if (element.element("专业").getTextTrim().equals("通信")) {
							id2 += arr2[Integer.parseInt(element1.getTextTrim())] + "\",";
						}
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("上级单位名称");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("软件名称");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("安装版本号");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("安装服务器IP");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("安装服务器端口");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}

					element1 = element.element("服务端代理程序路径");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("安装日期");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}

					element1 = element.element("安装人");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}

					element1 = element.element("备注");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}
					element1 = element.element("行业");
					if (element1 != null) {
						id12 += "\"";
						id12 += element1.getTextTrim() + "\",";
					} else {
						id12 += "\"\",";
					}
					element1 = element.element("专业");
					if (element1 != null) {
						id13 += "\"";
						id13 += element1.getTextTrim() + "\",";
					} else {
						id13 += "\"\",";
					}

					i++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id11 = id11.substring(0, id11.length() - 1);
				id11 = id11.replaceAll("\\\\", "\\\\\\\\");
				id12 = id12.substring(0, id12.length() - 1);
				id13 = id13.substring(0, id13.length() - 1);

				pguid += "],";

				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "],";
				id12 += "],";
				id13 += "]";
				result += pguid + id + id1 + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + id10 + id11 + id12 + id13
						+ "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// pguid查询
	public static String implementPGUIDQuery(String sql) {
		String result = "";
		String result1 = "[]";
		String id1 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						id1 += "";
						id1 += element1.getTextTrim() + ",";
					} else {
						id1 += ",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "";
				result += id1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 通过上级单位名称Pguid查询查询单位名称
	public static String QueryDataUpUnitName(String sql) {
		String result = "[";
		String result1 = "[[]";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("单位名称").getTextTrim() + "\"]";
				}
			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String QdataDepartmentTable(String sql) {
		String result = "[";
		String result1 = "[]";
		/* String pguid="["; */
		String i = "[";
		String pguid = "[";
		String id1 = "[";

		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {
					i += "\"" + ii + "\",";
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					element1 = element.element("部门名称");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					ii++;
				}
				i = i.substring(0, i.length() - 1);
				pguid = pguid.substring(0, pguid.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				i += "],";
				pguid += "],";
				id1 += "]";
				result += pguid + i + id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ....................................问题管理.......................................
	public static String QuestitionQuery(String sql) {
		String result = "[";
		String result1 = "[[\"无选项\"]]";
		String id1 = "[\"请选择\",";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("判断级别");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "]";
				result += id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ..........................................用户表排序.....................................
	public static String QdataDepartmentshowindex(String sql) {
		String result = "";
		String result1 = "[]";
		String showindex = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {
					element1 = element.element("SHOWINDEX");
					if (element1 != null) {

						showindex += element1.getTextTrim() + "";
					} else {
						showindex += "";
					}

				}

				result = showindex;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String BarAndPieQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\":[";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\"normal\":{\"formatter\" : \"function(v) { let text = v.name  return  text.length < 4 ? text: `${text.slice(0,4)}\\n${text.slice(4)}` }\"}},\"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 = "\"\"";
					}
					element1 = element.element("问题类型分属类型");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 = "\"\",";
						legend += "\"  \",";
					}
					series += "{\"barMaxWidth\":\"60\",\"name\": " + id2 + ",\"type\": \"bar\", \"data\" :[" + id1
							+ "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String BarAndPiechildQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\"normal\":{\"formatter\" : \"function(v) { let text = v.name  return  text.length < 3 ? text: `${text.slice(0,3)}\\n${text.slice(3)}` }\"}}, \"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 = "";
					}
					element1 = element.element("发生原因");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 = "\" \"";
						legend += "\" \",";
					}
					series += "{\"barMaxWidth\":\"60\",\"name\": " + id2
							+ ",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + id1 + "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String BarAndPiechildunitQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 = "\" \"";
					}
					element1 = element.element("判断级别");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 = "\" \"";
						legend += "\"\",";
					}
					series += "{\" barMaxWidth\":\"60\",\"name\": " + id2
							+ ",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + id1 + "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 主图的显示

	public static String BarAndPieSoftNameQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("软件系统");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					/*
					 * int s=list.size()-1,; if(s==v){ series +=
					 * "{\"barCategoryGap\": \"0\",\"barMaxWidth\":\"60\",\"name\": "
					 * + id2 + ",\"type\": \"bar\", \"data\" :[" + id1 + "]},";
					 * }else{ series += "{\"barMaxWidth\":\"60\",\"name\": " +
					 * id2 + ",\"type\": \"bar\", \"data\" :[" + id1 + "]},";
					 * 
					 * } v++;
					 */

					series += "{\"barMaxWidth\":\"60\",\"name\": " + id2
							+ ",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + id1 + "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// --------------主图显示------------------------------------------
	public static String BarAndPieCESHI(String sql, String a) {
		String[] arr = { "工程安装", "软件问题", "系统运行问题", "用户使用", "用户需求" };
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String oldtype = "";
		String xAxisdata = "\"xAxisdata\":[ " + a + "]";// X轴值
		a = a.replace("\"", "");
		String[] arr2 = a.split(",");
		// String[] arr2 = { "软件升级", "天天", "测试软件", "电务调度子系统", "软件升级系统", "软件服务",
		// "故障上报系统" };
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		String[] arr3 = null;
		String[] arr5 = null;
		String arr4 = "";
		String seriesdata = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = element1.getTextTrim();
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("软件系统");
					if (element1 != null) {
						id2 = element1.getTextTrim();
					} else {
						id2 += "\"\",";
					}
					element1 = element.element("问题类型分属类型");
					if (element1 != null) {
						id3 = element1.getTextTrim();
					} else {
						id3 += "\"\",";
					}
					if (!id3.equals(oldtype)) {
						if (arr3 != null) {
							legend += "\"" + oldtype + "\",";
							seriesdata = "";
							for (int i = 0; i < arr3.length; i++) {
								seriesdata += "\"" + arr3[i] + "\",";
							}
							seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
							arr4 += seriesdata + "s";
						}
						arr3 = new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0" };
						oldtype = id3;
					}
					// d对数组进行赋值 ，
					for (int j = 0; j < arr2.length; j++) {
						if (arr2[j].equals(id2)) {
							arr3[j] = id1;
						}
					}
					pieseries += "{\"value\" : \"" + id1 + "\",\"name\" :\"" + id2 + "\"},";
				}
				if (arr3 != null) {
					legend += "\"" + oldtype + "\",";
					seriesdata = "";
					for (int i = 0; i < arr3.length; i++) {
						seriesdata += "\"" + arr3[i] + "\",";
					}
					seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
					arr4 += seriesdata;
					arr5 = arr4.split("s");
				}
				
				for (int i = 0; i < arr.length; i++) {
					series += "{\"barMaxWidth\":\"60\",\"name\":\"" + arr[i]
							+ "\",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + arr5[i] + "]},";
					System.out.println("arr    ...      "+arr[i]);
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + xAxisdata + "," + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ----------------------四个子页面主图显示---------------------------------------------
	public static String ChildBarAndPieCESHI(String sql, String a, String b) {
		// String[] arr = { "工程安装", "软件问题", "用户使用", "用户需求" };
		b = b.replace("\"", "");
		String[] arr = b.split(",");
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String oldtype = "";
		String xAxisdata = "\"xAxisdata\":[ " + a + "]";// X轴值
		a = a.replace("\"", "");
		String[] arr2 = a.split(",");
		// String[] arr2 = { "软件升级", "天天", "测试软件", "电务调度子系统", "软件升级系统", "软件服务",
		// "故障上报系统" };
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		String[] arr3 = null;
		String[] arr5 = null;
		String arr4 = "";
		String seriesdata = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = element1.getTextTrim();
					} else {
						id1 = "";
					}
					element1 = element.element("软件系统");
					if (element1 != null) {
						id2 = element1.getTextTrim();
					} else {
						id2 = "  ";
					}
					element1 = element.element("发生原因");
					if (element1 != null) {
						id3 = element1.getTextTrim();
					} else {
						id3 = "  ";
					}
					//oldtype="";
					if (!id3.equals(oldtype)) {
						if (arr3 != null) {
							legend += "\"" + oldtype + "\",";
							System.out.println(legend);
							seriesdata = "";
							for (int i = 0; i < arr3.length; i++) {
								seriesdata += "\"" + arr3[i] + "\",";
							}
							seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
							arr4 += seriesdata + "s";
						}
						arr3 = new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" , "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
						oldtype = id3;
					}
					// d对数组进行赋值 ，
					for (int j = 0; j < arr2.length; j++) {
						if (arr2[j].equals(id2)) {
							arr3[j] = id1;
						}
					}
					pieseries += "{\"value\" : \"" + id1 + "\",\"name\" :\"" + id2 + "\"},";
				}
				
				if (arr3 != null) {
					if(oldtype.equals("")){
						legend +=   oldtype ;
					}else{
						legend += "\"" + oldtype + "\",";
					}
					
					
					seriesdata = "";
					for (int i = 0; i < arr3.length; i++) {
						seriesdata += "\"" + arr3[i] + "\",";
					}
					seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
					arr4 += seriesdata;
					arr5 = arr4.split("s");
				}
				System.out.println("arr legent"+arr.length);
				for (int i = 0; i < arr.length; i++) {
					series += "{\"barMaxWidth\":\"60\",\"name\":\"" + arr[i]
							+ "\",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + arr5[i] + "]},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + xAxisdata + "," + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String ChildSoftUnitBarAndPie(String sql, String a, String b) {
		b = b.replace("\"", "");
		String[] arr = b.split(",");
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String oldtype = "";
		String xAxisdata = "\"xAxisdata\":[ " + a + "]";// X轴值
		a = a.replace("\"", "");
		String[] arr2 = a.split(",");
		// String[] arr2 = { "软件升级", "天天", "测试软件", "电务调度子系统", "软件升级系统", "软件服务",
		// "故障上报系统" };
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"访问来源\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		String[] arr3 = null;
		String[] arr5 = null;
		String arr4 = "";
		String seriesdata = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = element1.getTextTrim();
					} else {
						id1 = "  ";
					}
					element1 = element.element("判断级别");
					if (element1 != null) {
						id2 = element1.getTextTrim();
					} else {
						id2 = "  ";
					}
					element1 = element.element("发生原因");
					if (element1 != null) {
						id3 = element1.getTextTrim();
					} else {
						id3 = "  ";
					}
					if (!id3.equals(oldtype)) {
						if (arr3 != null) {
							legend += "\"" + oldtype + "\",";
							System.out.println(legend);
							seriesdata = "";
							for (int i = 0; i < arr3.length; i++) {
								seriesdata += "\"" + arr3[i] + "\",";
							}
							seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
							arr4 += seriesdata + "s";
						}
						arr3 = new String[] {
								"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
								"0", "0", "0", "0", "0" };
						oldtype = id3;
					}
					// d对数组进行赋值 ，
					for (int j = 0; j < arr2.length; j++) {
						if (arr2[j].equals(id2)) {
							arr3[j] = id1;
						}
					}
					pieseries += "{\"value\" : \"" + id1 + "\",\"name\" :\"" + id2 + "\"},";
				}
				if (arr3 != null) {
					if(oldtype.equals("")){
						legend +=   oldtype ;
					}else{
						legend += "\"" + oldtype + "\",";
					}
					seriesdata = "";
					for (int i = 0; i < arr3.length; i++) {
						seriesdata += "\"" + arr3[i] + "\",";
					}
					seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
					arr4 += seriesdata;
					arr5 = arr4.split("s");
				}
				for (int i = 0; i < arr.length; i++) {
					series += "{\"barMaxWidth\":\"60\",\"name\":\"" + arr[i]
							+ "\", \"stack\": \"搜索引擎\",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + arr5[i] + "]},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + xAxisdata + "," + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询图表是查询问题子类型方法
	public static String getQuestion(String sql) {
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				id2 = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("发生原因");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"  \",";
					}
				}
				id2 = id2.substring(0, id2.length() - 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id2;
	}

	// -----xin新添加的处理总图的legend,x坐标轴的显示，用于赋值
	public static String getLegendUnit(String sql) {
		String result = "";
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("软件系统");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
				}
				id2 = id2.substring(0, id2.length() - 1);
				id2 += "";
				result += id2 + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getSoftUnit(String sql) {
		String result = "";
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("判断级别");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\" \",";
					}
				}
				id2 = id2.substring(0, id2.length() - 1);
				id2 += "";
				result += id2 + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 添加软件功能设置的查询数据-----------七月三十一号添加----------------------------

	public static String functionQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id1 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";

					element1 = element.element("功能");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					ii++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				pguid += "],";
				i += "],";
				id1 += "]";
				result += pguid + i + id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 七月三十一号添加 ........原因设置的查询
	
	public static String CauseWtlx(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id1 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";

					element1 = element.element("原因");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					ii++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				pguid += "],";
				i += "],";
				id1 += "]";
				result += pguid + i + id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//八月九号下午添加  ==---------  从单位字典表查询单位级别,应用于问题编号的组成
	public static String  getDWjb(String sql) {
		String result = "";
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("单位级别");
					if (element1 != null) {
						if(element1.getTextTrim().equals("总公司")){
							id2 = "a";
						}
						if(element1.getTextTrim().equals("路局")){
							id2 = "b";
						}
						if(element1.getTextTrim().equals("段")||element1.getTextTrim().equals("支线公司")){
							id2 = "c";
						}
						
					} else {
						id2 += "\"\",";
					}
				}
				result += id2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
