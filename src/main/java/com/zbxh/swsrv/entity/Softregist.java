package com.zbxh.swsrv.entity;

/**
 * ���ע���
 * @author Administrator
 *	2018-11-3
 */
public class Softregist {
	
	/**
	 * ������
	 */
	private String softNo;
	
	/**
	 * ��ҵ
	 */
	private String voaction;
	
	/**
	 * רҵ
	 */
	private String profession;
	
	/**
	 * �˿��ڱ�
	 * 0������������
	 * 1���ͻ��������
	 * 2���ͻ���������
	 */
	private int portType;
	
	/**
	 * web��Ŀ��
	 */
	private String webName;
	
	/**
	 * ע��汾
	 */
	private String regVersion;
	
	/**
	 * ���˵��
	 */
	private String explan;
	
	/**
	 * ʹ�ü���
	 */
	private String useClass;
	
	/**
	 * ��¼Ψһid
	 */
	private String pguid;
	
	/**
	 * ��¼����ʱ��
	 */
	private String udTime;
	
	/**
	 * ��¼ͬ��ʱ��
	 */
	private String syTime;
	
	/**
	 * �Ƿ�ɾ�����
	 */
	private int isdelete;
	
	/**
	 * �ļ��ϴ����
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
