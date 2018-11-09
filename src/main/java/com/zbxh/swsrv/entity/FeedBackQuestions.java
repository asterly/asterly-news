package com.zbxh.swsrv.entity;

/**
 * 问题表对象
 * @author Administrator
 * 2018-11-1
 * 李坤
 *
 */
public class FeedBackQuestions {
	/**
	 * 反馈问题唯一id
	 */
	private String id;
	
	/**
	 * 行业
	 */
	private String Vocation;
	
	/**
	 * 专业
	 */
	private String profession;
	
	/**
	 * 问题
	 */
	private String question;
	
	/**
	 * 问题类型
	 */
	private String typeClassify;
	
	/**
	 * 问题 备注
	 */
	private String remark;
	
	/**
	 * 问题描述
	 */
	private String depict;
	
	/**
	 * 图片描述
	 */
	private String picture;
	
	/**
	 * 单位
	 */
	private String units;
	
	/**
	 * 上级单位
	 */
	private String parentUnits;
	
	/**
	 * 单位部门
	 */
	private String unitsDepartment;
	
	/**
	 * 职员
	 */
	private String unitsStaffs;
	
	/**
	 * 记录人
	 */
	private String unitsStaff;
	
	/**
	 * 联系电话
	 */
	private String staffTel;
	
	/**
	 * 问题提出时间
	 */
	private String putDate;
	
	/**
	 * 问题是否解决
	 */
	private String isSolve;
	
	/**
	 * 功能
	 */
	private String fuction;
	
	/**
	 * 问题解决时间
	 */
	private String solveDate;
	
	/**
	 * 发生原因
	 */
	private String cause;
	
	/**
	 * 程序员反馈
	 */
	private String feedback;
	
	/**
	 * 公司意见
	 */
	private String opinion;
	
	/**
	 * 公司计划
	 */
	private String companPplan;
	
	/**
	 * 问题解决方法
	 */
	private String solveMethod;
	
	/**
	 * 问题解决版本
	 */
	private String solveVersion;
	
	/**
	 * 问题发生版本
	 */
	private String version;
	
	/**
	 * 问题编号
	 */
	private String questionNO;

	public FeedBackQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedBackQuestions(String id, String vocation, String profession, String question, String typeClassify,
			String remark, String depict, String picture, String units, String parentUnits, String unitsDepartment,
			String unitsStaffs, String unitsStaff, String staffTel, String putDate, String isSolve, String fuction,
			String solveDate, String cause, String feedback, String opinion, String companPplan, String solveMethod,
			String solveVersion, String version, String questionNO) {
		super();
		this.id = id;
		Vocation = vocation;
		this.profession = profession;
		this.question = question;
		this.typeClassify = typeClassify;
		this.remark = remark;
		this.depict = depict;
		this.picture = picture;
		this.units = units;
		this.parentUnits = parentUnits;
		this.unitsDepartment = unitsDepartment;
		this.unitsStaffs = unitsStaffs;
		this.unitsStaff = unitsStaff;
		this.staffTel = staffTel;
		this.putDate = putDate;
		this.isSolve = isSolve;
		this.fuction = fuction;
		this.solveDate = solveDate;
		this.cause = cause;
		this.feedback = feedback;
		this.opinion = opinion;
		this.companPplan = companPplan;
		this.solveMethod = solveMethod;
		this.solveVersion = solveVersion;
		this.version = version;
		this.questionNO = questionNO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVocation() {
		return Vocation;
	}

	public void setVocation(String vocation) {
		Vocation = vocation;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTypeClassify() {
		return typeClassify;
	}

	public void setTypeClassify(String typeClassify) {
		this.typeClassify = typeClassify;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getParentUnits() {
		return parentUnits;
	}

	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}

	public String getUnitsDepartment() {
		return unitsDepartment;
	}

	public void setUnitsDepartment(String unitsDepartment) {
		this.unitsDepartment = unitsDepartment;
	}

	public String getUnitsStaffs() {
		return unitsStaffs;
	}

	public void setUnitsStaffs(String unitsStaffs) {
		this.unitsStaffs = unitsStaffs;
	}

	public String getUnitsStaff() {
		return unitsStaff;
	}

	public void setUnitsStaff(String unitsStaff) {
		this.unitsStaff = unitsStaff;
	}

	public String getStaffTel() {
		return staffTel;
	}

	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}

	public String getPutDate() {
		return putDate;
	}

	public void setPutDate(String putDate) {
		this.putDate = putDate;
	}

	public String getIsSolve() {
		return isSolve;
	}

	public void setIsSolve(String isSolve) {
		this.isSolve = isSolve;
	}

	public String getFuction() {
		return fuction;
	}

	public void setFuction(String fuction) {
		this.fuction = fuction;
	}

	public String getSolveDate() {
		return solveDate;
	}

	public void setSolveDate(String solveDate) {
		this.solveDate = solveDate;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getCompanPplan() {
		return companPplan;
	}

	public void setCompanPplan(String companPplan) {
		this.companPplan = companPplan;
	}

	public String getSolveMethod() {
		return solveMethod;
	}

	public void setSolveMethod(String solveMethod) {
		this.solveMethod = solveMethod;
	}

	public String getSolveVersion() {
		return solveVersion;
	}

	public void setSolveVersion(String solveVersion) {
		this.solveVersion = solveVersion;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getQuestionNO() {
		return questionNO;
	}

	public void setQuestionNO(String questionNO) {
		this.questionNO = questionNO;
	}

	@Override
	public String toString() {
		return "FeedBackQuestions [id=" + id + ", Vocation=" + Vocation + ", profession=" + profession + ", question="
				+ question + ", typeClassify=" + typeClassify + ", remark=" + remark + ", depict=" + depict
				+ ", picture=" + picture + ", units=" + units + ", parentUnits=" + parentUnits + ", unitsDepartment="
				+ unitsDepartment + ", unitsStaffs=" + unitsStaffs + ", unitsStaff=" + unitsStaff + ", staffTel="
				+ staffTel + ", putDate=" + putDate + ", isSolve=" + isSolve + ", fuction=" + fuction + ", solveDate="
				+ solveDate + ", cause=" + cause + ", feedback=" + feedback + ", opinion=" + opinion + ", companPplan="
				+ companPplan + ", solveMethod=" + solveMethod + ", solveVersion=" + solveVersion + ", version="
				+ version + ", questionNO=" + questionNO + "]";
	}
	
	


}
