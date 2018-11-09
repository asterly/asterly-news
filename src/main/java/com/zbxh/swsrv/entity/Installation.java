package com.zbxh.swsrv.entity;

/**
 * ��װ����
 * @author Administrator
 * 2018-11-1
 * ����
 *
 */
public class Installation {
	
	/**
	 * ��ҵ
	 */
	
	private String vaction;
	
	/**
	 * רҵ
	 */
	private String profession;
	
	/**
	 * ��װID
	 * 
	 */
	private String installID;
	
	/**
	 * ��װ��λ����  
	 * 
	 */
	private String unitsName;
	
	/**
	 * ��װ��λ���
	 * 
	 */
	private int unitsClass;
	
	/**
	 * ��װ��λ�ϼ���λ����
	 * 
	 */
	private String unitsParent;
	
	/**
	 * ������
	 * 
	 */
	private String softNO;
	
	/**
	 * �������
	 * 
	 */
	private String softName;
	
	/**
	 * ��װ�汾��
	 * 
	 */
	private String installVersion;
	
	/**
	 * ��װ������IP
	 * 
	 */
	private String serviceIP;
	
	/**
	 * ��װ�������˿ں�
	 * 
	 */
	private int servicePort;
	
	/**
	 * ��װ·��
	 */
	private String serviceDir;
	
	/**
	 * ��������
	 */
	private String intoPwd;
	
	/**
	 * ��װʱ��
	 */
	private String installDate;
	
	/**
	 * ��װ��
	 */
	private String installUser;
	
	/**
	 * ��ע
	 */
	private String remark;
	
	/**
	 * ��װ·��
	 */
	private String pguid;
	
	/**
	 * ��¼����ʱ��
	 */
	private String udtime;
	
	/**
	 * ��¼ͬ��ʱ��
	 */
	private String sytime;
	
	/**
	 * �ϴ����
	 */
	private int mflag;
	
	/**
	 * �Ƿ�ɾ��
	 */
	private int isdelete;

	public Installation(String vaction, String profession, String installID, String unitsName, int unitsClass,
			String unitsParent, String softNO, String softName, String installVersion, String serviceIP,
			int servicePort, String serviceDir, String intoPwd, String installDate, String installUser, String remark,
			String pguid, String udtime, String sytime, int mflag, int isdelete) {
		super();
		this.vaction = vaction;
		this.profession = profession;
		this.installID = installID;
		this.unitsName = unitsName;
		this.unitsClass = unitsClass;
		this.unitsParent = unitsParent;
		this.softNO = softNO;
		this.softName = softName;
		this.installVersion = installVersion;
		this.serviceIP = serviceIP;
		this.servicePort = servicePort;
		this.serviceDir = serviceDir;
		this.intoPwd = intoPwd;
		this.installDate = installDate;
		this.installUser = installUser;
		this.remark = remark;
		this.pguid = pguid;
		this.udtime = udtime;
		this.sytime = sytime;
		this.mflag = mflag;
		this.isdelete = isdelete;
	}

	public Installation() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getInstallID() {
		return installID;
	}

	public void setInstallID(String installID) {
		this.installID = installID;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public int getUnitsClass() {
		return unitsClass;
	}

	public void setUnitsClass(int unitsClass) {
		this.unitsClass = unitsClass;
	}

	public String getUnitsParent() {
		return unitsParent;
	}

	public void setUnitsParent(String unitsParent) {
		this.unitsParent = unitsParent;
	}

	public String getSoftNO() {
		return softNO;
	}

	public void setSoftNO(String softNO) {
		this.softNO = softNO;
	}

	public String getSoftName() {
		return softName;
	}

	public void setSoftName(String softName) {
		this.softName = softName;
	}

	public String getInstallVersion() {
		return installVersion;
	}

	public void setInstallVersion(String installVersion) {
		this.installVersion = installVersion;
	}

	public String getServiceIP() {
		return serviceIP;
	}

	public void setServiceIP(String serviceIP) {
		this.serviceIP = serviceIP;
	}

	public int getServicePort() {
		return servicePort;
	}

	public void setServicePort(int servicePort) {
		this.servicePort = servicePort;
	}

	public String getServiceDir() {
		return serviceDir;
	}

	public void setServiceDir(String serviceDir) {
		this.serviceDir = serviceDir;
	}

	public String getIntoPwd() {
		return intoPwd;
	}

	public void setIntoPwd(String intoPwd) {
		this.intoPwd = intoPwd;
	}

	public String getInstallDate() {
		return installDate;
	}

	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}

	public String getInstallUser() {
		return installUser;
	}

	public void setInstallUser(String installUser) {
		this.installUser = installUser;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPguid() {
		return pguid;
	}

	public void setPguid(String pguid) {
		this.pguid = pguid;
	}

	public String getUdtime() {
		return udtime;
	}

	public void setUdtime(String udtime) {
		this.udtime = udtime;
	}

	public String getSytime() {
		return sytime;
	}

	public void setSytime(String sytime) {
		this.sytime = sytime;
	}

	public int getMflag() {
		return mflag;
	}

	public void setMflag(int mflag) {
		this.mflag = mflag;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "Installation [vaction=" + vaction + ", profession=" + profession + ", installID=" + installID
				+ ", unitsName=" + unitsName + ", unitsClass=" + unitsClass + ", unitsParent=" + unitsParent
				+ ", softNO=" + softNO + ", softName=" + softName + ", installVersion=" + installVersion
				+ ", serviceIP=" + serviceIP + ", servicePort=" + servicePort + ", serviceDir=" + serviceDir
				+ ", intoPwd=" + intoPwd + ", installDate=" + installDate + ", installUser=" + installUser + ", remark="
				+ remark + ", pguid=" + pguid + ", udtime=" + udtime + ", sytime=" + sytime + ", mflag=" + mflag
				+ ", isdelete=" + isdelete + "]";
	}
	
	
	


}
