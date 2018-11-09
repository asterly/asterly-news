package com.zbxh.swsrv.entity;

/**
 * 原因表
 * @author Administrator
 *	2018-11-3
 */
public class Cause {
	

	
	private String pguid;
	private String cause;
	
	/**
	 * 原因备用
	 */
	private String causeReserve;
	private int isdelete;
	public String getPguid() {
		return pguid;
	}
	public void setPguid(String pguid) {
		this.pguid = pguid;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getCauseReserve() {
		return causeReserve;
	}
	public void setCauseReserve(String causeReserve) {
		this.causeReserve = causeReserve;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public Cause() {
		super();
		
	}
	public Cause(String pguid, String cause, String causeReserve, int isdelete) {
		super();
		this.pguid = pguid;
		this.cause = cause;
		this.causeReserve = causeReserve;
		this.isdelete = isdelete;
	}
	
	

}
