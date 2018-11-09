package com.zbxh.swsrv.entity;

/**
 * ¹¦ÄÜ±í
 * @author Administrator
 *
 */
public class Function {

	private String pguid;
	private String vocation;
	private String profession;
	private String softName;
	private String function;
	private String funReserve;
	private int isdelete;
	public String getPguid() {
		return pguid;
	}
	public void setPguid(String pguid) {
		this.pguid = pguid;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getSoftName() {
		return softName;
	}
	public void setSoftName(String softName) {
		this.softName = softName;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getFunReserve() {
		return funReserve;
	}
	public void setFunReserve(String funReserve) {
		this.funReserve = funReserve;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	@Override
	public String toString() {
		return "Function [pguid=" + pguid + ", vocation=" + vocation + ", profession=" + profession + ", softName="
				+ softName + ", function=" + function + ", funReserve=" + funReserve + ", isdelete=" + isdelete + "]";
	}
	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Function(String pguid, String vocation, String profession, String softName, String function,
			String funReserve, int isdelete) {
		super();
		this.pguid = pguid;
		this.vocation = vocation;
		this.profession = profession;
		this.softName = softName;
		this.function = function;
		this.funReserve = funReserve;
		this.isdelete = isdelete;
	}
	
	

}
