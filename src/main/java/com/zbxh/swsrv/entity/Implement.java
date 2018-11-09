package com.zbxh.swsrv.entity;

/**
 * 工程实施表
 * @author Administrator
 *	2018-11-3
 */
public class Implement {

	/**
	 * 行业和专业信息
	 */
	private String voation;
	private String profession;
	private String softName;
	
	/**
	 * 施工单位信息
	 */
	private String unitsName;
	private String unitsParent;
	private int unitsClass;
	
	/**
	 * 施工计划
	 */
	private String plan;
	
	/**
	 * 联系人
	 */
	private String contacts;
	
	/**
	 * 负责人
	 */
	private String principal;
	
	/**
	 * 一阶段-十阶段
	 */
	private String oneStage;
	private String twoStage;
	private String threeStage;
	private String fourStage;
	private String fiveStage;
	private String sixStage;
	private String sevenStage;
	private String eightStage;
	private String nineStage;
	private String tenStage;
	
	/**
	 * 施工备注
	 */
	private String remark;
	
	/**
	 * 进展备注
	 */
	private String evolveRemark;
	
	private String pguid;
	
	/**
	 * 记录更新时间
	 */
	private String udTime;

	public String getVoation() {
		return voation;
	}

	public void setVoation(String voation) {
		this.voation = voation;
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

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getUnitsParent() {
		return unitsParent;
	}

	public void setUnitsParent(String unitsParent) {
		this.unitsParent = unitsParent;
	}

	public int getUnitsClass() {
		return unitsClass;
	}

	public void setUnitsClass(int unitsClass) {
		this.unitsClass = unitsClass;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getOneStage() {
		return oneStage;
	}

	public void setOneStage(String oneStage) {
		this.oneStage = oneStage;
	}

	public String getTwoStage() {
		return twoStage;
	}

	public void setTwoStage(String twoStage) {
		this.twoStage = twoStage;
	}

	public String getThreeStage() {
		return threeStage;
	}

	public void setThreeStage(String threeStage) {
		this.threeStage = threeStage;
	}

	public String getFourStage() {
		return fourStage;
	}

	public void setFourStage(String fourStage) {
		this.fourStage = fourStage;
	}

	public String getFiveStage() {
		return fiveStage;
	}

	public void setFiveStage(String fiveStage) {
		this.fiveStage = fiveStage;
	}

	public String getSixStage() {
		return sixStage;
	}

	public void setSixStage(String sixStage) {
		this.sixStage = sixStage;
	}

	public String getSevenStage() {
		return sevenStage;
	}

	public void setSevenStage(String sevenStage) {
		this.sevenStage = sevenStage;
	}

	public String getEightStage() {
		return eightStage;
	}

	public void setEightStage(String eightStage) {
		this.eightStage = eightStage;
	}

	public String getNineStage() {
		return nineStage;
	}

	public void setNineStage(String nineStage) {
		this.nineStage = nineStage;
	}

	public String getTenStage() {
		return tenStage;
	}

	public void setTenStage(String tenStage) {
		this.tenStage = tenStage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEvolveRemark() {
		return evolveRemark;
	}

	public void setEvolveRemark(String evolveRemark) {
		this.evolveRemark = evolveRemark;
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

	public Implement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Implement [voation=" + voation + ", profession=" + profession + ", softName=" + softName
				+ ", unitsName=" + unitsName + ", unitsParent=" + unitsParent + ", unitsClass=" + unitsClass + ", plan="
				+ plan + ", contacts=" + contacts + ", principal=" + principal + ", oneStage=" + oneStage
				+ ", twoStage=" + twoStage + ", threeStage=" + threeStage + ", fourStage=" + fourStage + ", fiveStage="
				+ fiveStage + ", sixStage=" + sixStage + ", sevenStage=" + sevenStage + ", eightStage=" + eightStage
				+ ", nineStage=" + nineStage + ", tenStage=" + tenStage + ", remark=" + remark + ", evolveRemark="
				+ evolveRemark + ", pguid=" + pguid + ", udTime=" + udTime + "]";
	}
	
	
	
}
