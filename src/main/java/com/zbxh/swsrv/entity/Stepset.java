package com.zbxh.swsrv.entity;

/**
 * ���ý��ȱ����
 * @author likun 
 *2018-11-1
 */
public class Stepset {

	/**
	 * ��ҵ
	 */
	private String vaction;
	
	/**
	 * רҵ
	 */
	private String profession;
	
	/**
	 * �������
	 */
	private String softName;
	
	/**
	 * �����
	 */
	private int filedName;
	
	/**
	 * �׶�
	 */
	private String phases;
	
	/**
	 * ������
	 */
	private String principal;
	
	/**
	 * Ψһid
	 */
	private String pguid;

	public Stepset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stepset(String vaction, String profession, String softName, int filedName, String phases, String principal,
			String pguid) {
		super();
		this.vaction = vaction;
		this.profession = profession;
		this.softName = softName;
		this.filedName = filedName;
		this.phases = phases;
		this.principal = principal;
		this.pguid = pguid;
	}

	public String getVaction() {
		return vaction;
	}

	public void setVaction(String vaction) {
		this.vaction = vaction;
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

	public int getFiledName() {
		return filedName;
	}

	public void setFiledName(int filedName) {
		this.filedName = filedName;
	}

	public String getPhases() {
		return phases;
	}

	public void setPhases(String phases) {
		this.phases = phases;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPguid() {
		return pguid;
	}

	public void setPguid(String pguid) {
		this.pguid = pguid;
	}

	@Override
	public String toString() {
		return "Stepset [vaction=" + vaction + ", profession=" + profession + ", softName=" + softName + ", filedName="
				+ filedName + ", phases=" + phases + ", principal=" + principal + ", pguid=" + pguid + "]";
	}
	
	
	

}
