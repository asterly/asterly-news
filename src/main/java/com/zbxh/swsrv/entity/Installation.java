package com.zbxh.swsrv.entity;

/**
 * 安装对象
 * @author Administrator
 * 2018-11-1
 * 李坤
 *
 */
public class Installation {
	
	/**
	 * 行业
	 */
	
	private String vaction;
	
	/**
	 * 专业
	 */
	private String profession;
	
	/**
	 * 安装ID
	 * 
	 */
	private String installID;
	
	/**
	 * 安装单位名称  
	 * 
	 */
	private String unitsName;
	
	/**
	 * 安装单位类别
	 * 
	 */
	private int unitsClass;
	
	/**
	 * 安装单位上级单位名称
	 * 
	 */
	private String unitsParent;
	
	/**
	 * 软件编号
	 * 
	 */
	private String softNO;
	
	/**
	 * 软件名称
	 * 
	 */
	private String softName;
	
	/**
	 * 安装版本号
	 * 
	 */
	private String installVersion;
	
	/**
	 * 安装服务器IP
	 * 
	 */
	private String serviceIP;
	
	/**
	 * 安装服务器端口号
	 * 
	 */
	private int servicePort;
	
	/**
	 * 安装路径
	 */
	private String serviceDir;
	
	/**
	 * 接入密码
	 */
	private String intoPwd;
	
	/**
	 * 安装时间
	 */
	private String installDate;
	
	/**
	 * 安装人
	 */
	private String installUser;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 安装路径
	 */
	private String pguid;
	
	/**
	 * 记录更新时间
	 */
	private String udtime;
	
	/**
	 * 记录同步时间
	 */
	private String sytime;
	
	/**
	 * 上传标记
	 */
	private int mflag;
	
	/**
	 * 是否删除
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
