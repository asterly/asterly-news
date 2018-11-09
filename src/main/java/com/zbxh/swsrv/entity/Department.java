package com.zbxh.swsrv.entity;

/**
 * 部门表
 * @author 李坤
 *
 */
public class Department {

	/**
	 * 部门名称
	 */
	private String department;
	private int showIndex;
	
	private String pguid;
	private String uptime;
	private int Mflag;
	private int isdelete;
	
	public Department(String department, int showIndex, String pguid, String uptime, int mflag, int isdelete) {
		super();
		this.department = department;
		this.showIndex = showIndex;
		this.pguid = pguid;
		this.uptime = uptime;
		Mflag = mflag;
		this.isdelete = isdelete;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getShowIndex() {
		return showIndex;
	}
	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}
	public String getPguid() {
		return pguid;
	}
	public void setPguid(String pguid) {
		this.pguid = pguid;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public int getMflag() {
		return Mflag;
	}
	public void setMflag(int mflag) {
		Mflag = mflag;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	@Override
	public String toString() {
		return "Department [department=" + department + ", showIndex=" + showIndex + ", pguid=" + pguid + ", uptime="
				+ uptime + ", Mflag=" + Mflag + ", isdelete=" + isdelete + "]";
	}
	
	

}
