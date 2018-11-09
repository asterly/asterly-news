package com.zbxh.databean;

import java.util.ArrayList;
import java.util.List;

public class DoUnitData {

	private List<JdData> JdDataList1 = null;
	private List<JdData> JdDataList2 = null;

	public DoUnitData(List<JdData> JdDataList) {
		this.JdDataList1 = JdDataList;
		JdDataList2 = new ArrayList<JdData>();
	}

	public String doMyUnitName() {
		JdData mJdData_1 = getTieZOng();
		if (mJdData_1 != null) {
			JdDataList2.add(mJdData_1);
		}
		// 几个路局
		int c = getTieLujuCounts();
		/*
		 * for (int i = 0; i < c; i++) { JdData mJdData_2 = getTieLuju();
		 * System.out.println(mJdData_2.Pguid); if (mJdData_2 != null) {
		 * JdDataList2.add(mJdData_2); } // 找电务段 List<JdData> dwdList =
		 * getDwd(mJdData_2.Pguid); JdDataList2.addAll(dwdList); }
		 */

		if (c == 0) {
			// 找电务段
			List<JdData> dwdList = getDwd();
			JdDataList2.addAll(dwdList);
			
		} else {
			for (int i = 0; i < c; i++) {
				JdData mJdData_2 = getTieLuju();
				if (mJdData_2 != null) {
					JdDataList2.add(mJdData_2);
				}
				// 找电务段
				List<JdData> dwdList = getDwd(mJdData_2.Pguid);
				JdDataList2.addAll(dwdList);
			}
			List<JdData> dwdList = getDwd();
			JdDataList2.addAll(dwdList);
		}

		String json = "[";
		String i = "[";
		int ii = 1;
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		for (JdData mJdData : JdDataList2) {
			id1 += "\"" + mJdData.Pguid + "\",";
			i += "\"" + ii + "\",";
			id2 += "\"" + mJdData.UnitName + "\",";
			id3 += "\"" + mJdData.Sgplay + "\",";
			id4 += "\"" + mJdData.Sgtellphone + "\",";
			id5 += "\"" + mJdData.Gstellphone + "\",";
			id6 += "\"" + mJdData.Beizhu + "\",";
			id7 += mJdData.Type + ",";
			ii++;
		}
		id1 = id1.substring(0, id1.length() - 1);
		i = i.substring(0, i.length() - 1);
		id2 = id2.substring(0, id2.length() - 1);
		id3 = id3.substring(0, id3.length() - 1);
		id4 = id4.substring(0, id4.length() - 1);
		id5 = id5.substring(0, id5.length() - 1);
		id6 = id6.substring(0, id6.length() - 1);
		id7 = id7.substring(0, id7.length() - 1);
		json += "[" + id1 + "]," + i + "]," + id2 + "]," + id3 + "]," + id4 + "]," + id5 + "]," + id6 + "]],[" + id7
				+ "]]]";
		return json;
	}

	public String doMyjieduanvalue(int length) {
		JdData mJdData_1 = getTieZOng();
		if (mJdData_1 != null) {
			JdDataList2.add(mJdData_1);
		}
		// 几个路局
		int c = getTieLujuCounts();
		if (c == 0) {
			// 找电务段
			System.out.println("找电务段");
			List<JdData> dwdList = getDwd();
			JdDataList2.addAll(dwdList);
		} else {
			for (int i = 0; i < c; i++) {
				JdData mJdData_2 = getTieLuju();
				System.out.println(mJdData_2.Pguid);
				if (mJdData_2 != null) {
					JdDataList2.add(mJdData_2);

				}
				// 找电务段
				List<JdData> dwdList = getDwd(mJdData_2.Pguid);
				JdDataList2.addAll(dwdList);

			}
			List<JdData> dwdList = getDwd();
			JdDataList2.addAll(dwdList);

		}
		/*
		 * //System.out.println("c的值" + c); for (int i = 0; i < c; i++) { JdData
		 * mJdData_2 = getTieLuju(); if (mJdData_2 != null) {
		 * JdDataList2.add(mJdData_2); } // 找电务段 List<JdData> dwdList =
		 * getDwd(mJdData_2.Pguid); JdDataList2.addAll(dwdList); }
		 */
		String json = "[";
		String i = "[";
		int ii = 1;
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String[] tablearray = { "[", "[", "[", "[", "[", "[", "[", "[", "[", "[" };
		for (JdData mJdData : JdDataList2) {
			id1 += "\"" + mJdData.Pguid + "\",";
			i += "\"" + ii + "\",";
			id2 += "\"" + mJdData.UnitName + "\",";
			id3 += "\"" + mJdData.jdBeizhu + "\",";
			id4 += mJdData.Type + ",";
			for (int a = 0; a < mJdData.JdStr.length; a++) {
				// System.out.println("youmeiyoushuju----" + mJdData.JdStr[a]);
				if (mJdData.JdStr[a] != null) {
					tablearray[a] += "\"" + mJdData.JdStr[a] + "\",";
				} else {
					tablearray[a] += "\"\",";
				}
			}
			ii++;
		}
		String tablesArr = "";
		for (int i1 = 0; i1 < length; i1++) {
			tablearray[i1] = tablearray[i1].substring(0, tablearray[i1].length() - 1);
			tablearray[i1] += "],";
			tablesArr += tablearray[i1];
		}
		tablesArr = tablesArr.substring(0, tablesArr.length() - 1);
		id1 = id1.substring(0, id1.length() - 1);
		i = i.substring(0, i.length() - 1);
		id2 = id2.substring(0, id2.length() - 1);
		id3 = id3.substring(0, id3.length() - 1);
		id4 = id4.substring(0, id4.length() - 1);
		// tablesArr=tablesArr.substring(0, tablesArr.length()-1);
		json += id1 + "]," + i + "]," + id2 + "]," + tablesArr + "," + id3 + "]],[" + id4 + "]]";
		return json;
	}

	private JdData getTieZOng() {
		for (JdData mJdData : JdDataList1) {
			if (mJdData.Type.equals("1")) {
				return mJdData;
			}
		}
		return null;
	}

	private int getTieLujuCounts() {
		int c = 0;
		for (JdData mJdData : JdDataList1) {
			if (mJdData.Type.equals("2")) {
				c++;
			}
		}
		return c;
	}

	private List<JdData> getDwd(String lujuName) {
		List<JdData> temp = new ArrayList<>();
		temp.clear();
		for (JdData mJdData : JdDataList1) {
			if (mJdData.Type.equals("3") && mJdData.UpUnitName.equals(lujuName)) {
				temp.add(mJdData);
			}
		}
		return temp;
	}

	private List<JdData> getDwd() {
		List<JdData> temp = new ArrayList<>();
		temp.clear();
		for (JdData mJdData : JdDataList1) {
			if (mJdData.Type.equals("3") && mJdData.UpUnitName.equals("")) {
				temp.add(mJdData);
			}
		}
		return temp;
	}

	private JdData getTieLuju() {
		for (JdData mJdData : JdDataList1) {
			if (mJdData.Type.equals("2") && !isExit(mJdData)) {
				return mJdData;
			}
		}
		return null;
	}

	private boolean isExit(JdData temp) {
		int i = 0;
		for (JdData mJdData : JdDataList2) {
			if (mJdData == null) {
				return true;
			}
			i++;
			if (mJdData.Pguid.equals(temp.Pguid)) {
				return true;
			}
		}
		return false;
	}
}
