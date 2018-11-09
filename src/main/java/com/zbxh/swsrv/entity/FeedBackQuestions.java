package com.zbxh.swsrv.entity;

/**
 * ��������
 * @author Administrator
 * 2018-11-1
 * ����
 *
 */
public class FeedBackQuestions {
	/**
	 * ��������Ψһid
	 */
	private String id;
	
	/**
	 * ��ҵ
	 */
	private String Vocation;
	
	/**
	 * רҵ
	 */
	private String profession;
	
	/**
	 * ����
	 */
	private String question;
	
	/**
	 * ��������
	 */
	private String typeClassify;
	
	/**
	 * ���� ��ע
	 */
	private String remark;
	
	/**
	 * ��������
	 */
	private String depict;
	
	/**
	 * ͼƬ����
	 */
	private String picture;
	
	/**
	 * ��λ
	 */
	private String units;
	
	/**
	 * �ϼ���λ
	 */
	private String parentUnits;
	
	/**
	 * ��λ����
	 */
	private String unitsDepartment;
	
	/**
	 * ְԱ
	 */
	private String unitsStaffs;
	
	/**
	 * ��¼��
	 */
	private String unitsStaff;
	
	/**
	 * ��ϵ�绰
	 */
	private String staffTel;
	
	/**
	 * �������ʱ��
	 */
	private String putDate;
	
	/**
	 * �����Ƿ���
	 */
	private String isSolve;
	
	/**
	 * ����
	 */
	private String fuction;
	
	/**
	 * ������ʱ��
	 */
	private String solveDate;
	
	/**
	 * ����ԭ��
	 */
	private String cause;
	
	/**
	 * ����Ա����
	 */
	private String feedback;
	
	/**
	 * ��˾���
	 */
	private String opinion;
	
	/**
	 * ��˾�ƻ�
	 */
	private String companPplan;
	
	/**
	 * ����������
	 */
	private String solveMethod;
	
	/**
	 * �������汾
	 */
	private String solveVersion;
	
	/**
	 * ���ⷢ���汾
	 */
	private String version;
	
	/**
	 * ������
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
