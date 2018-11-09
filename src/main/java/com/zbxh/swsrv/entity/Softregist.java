package com.zbxh.swsrv.entity;

/**
 * 软件注册表
 * @author Administrator
 *	2018-11-3
 */
public class Softregist {
	
	/**
	 * 软件编号
	 */
	private String softNo;
	
	/**
	 * 行业
	 */
	private String voaction;
	
	/**
	 * 专业
	 */
	private String profession;
	
	/**
	 * 端口内别
	 * 0：服务端软件，
	 * 1：客户端软件，
	 * 2：客户服务端软件
	 */
	private int portType;
	
	/**
	 * web项目名
	 */
	private String webName;
	
	/**
	 * 注册版本
	 */
	private String regVersion;
	
	/**
	 * 软件说明
	 */
	private String explan;
	
	/**
	 * 使用级别
	 */
	private String useClass;
	
	/**
	 * 记录唯一id
	 */
	private String pguid;
	
	/**
	 * 记录更新时间
	 */
	private String udTime;
	
	/**
	 * 记录同步时间
	 */
	private String syTime;
	
	/**
	 * 是否删除标记
	 */
	private int isdelete;
	
	/**
	 * 文件上传标记
	 */
	private int mplag;

	public String getSoftNo() {
		return softNo;
	}

	public void setSoftNo(String softNo) {
		this.softNo = softNo;
	}

	public String getVoaction() {
		return voaction;
	}

	public void setVoaction(String voaction) {
		this.voaction = voaction;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getPortType() {
		return portType;
	}

	public void setPortType(int portType) {
		this.portType = portType;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getRegVersion() {
		return regVersion;
	}

	public void setRegVersion(String regVersion) {
		this.regVersion = regVersion;
	}

	public String getExplan() {
		return explan;
	}

	public void setExplan(String explan) {
		this.explan = explan;
	}

	public String getUseClass() {
		return useClass;
	}

	public void setUseClass(String useClass) {
		this.useClass = useClass;
	}

	public String getPguid() {
		return pguid;
	}

	public void setPguid(String pguid) {
		this.pguid = pguid;
	}

	public String getUdTime() {
		return udTime;
	}

	public void setUdTime(String udTime) {
		this.udTime = udTime;
	}

	public String getSyTime() {
		return syTime;
	}

	public void setSyTime(String syTime) {
		this.syTime = syTime;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public int getMplag() {
		return mplag;
	}

	public void setMplag(int mplag) {
		this.mplag = mplag;
	}

	public Softregist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Softregist(String softNo, String voaction, String profession, int portType, String webName,
			String regVersion, String explan, String useClass, String pguid, String udTime, String syTime, int isdelete,
			int mplag) {
		super();
		this.softNo = softNo;
		this.voaction = voaction;
		this.profession = profession;
		this.portType = portType;
		this.webName = webName;
		this.regVersion = regVersion;
		this.explan = explan;
		this.useClass = useClass;
		this.pguid = pguid;
		this.udTime = udTime;
		this.syTime = syTime;
		this.isdelete = isdelete;
		this.mplag = mplag;
	}

	@Override
	public String toString() {
		return "Softregist [softNo=" + softNo + ", voaction=" + voaction + ", profession=" + profession + ", portType="
				+ portType + ", webName=" + webName + ", regVersion=" + regVersion + ", explan=" + explan
				+ ", useClass=" + useClass + ", pguid=" + pguid + ", udTime=" + udTime + ", syTime=" + syTime
				+ ", isdelete=" + isdelete + ", mplag=" + mplag + "]";
	}
	
	

}
