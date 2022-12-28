package com.simplilearn.entities;

public class Report {
	/* REPORT CLASS VERIABLES */
	private String classid;
	private String classname;
	/* STUDENT CLASS VERIABLES */
	private String studid;
	private String studfname;
	private String studlname;
	private String studdob;
	private String studadd;
	private String studphone;
	private String stud_class;
	private String studclass;

//private String classname;
	public String getStudclass() {
		return studclass;
	}

	public void setStudclass(String studclass) {
		this.studclass = studclass;
	}

	public String getStud_class() {
		return stud_class;
	}

	public void setStud_class(String stud_class) {
		this.stud_class = stud_class;
	}

	/* TECH_SUB CLASS VERIABLES */
	private String ssubject;
	private String assigntech;
	private String techclass;
	private String techid;

	public String getTechid() {
		return techid;
	}

	public void setTechid(String techid) {
		this.techid = techid;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getStudid() {
		return studid;
	}

	public void setStudid(String studid) {
		this.studid = studid;
	}

	public String getStudfname() {
		return studfname;
	}

	public void setStudfname(String studfname) {
		this.studfname = studfname;
	}

	public String getStudlname() {
		return studlname;
	}

	public void setStudlname(String studlname) {
		this.studlname = studlname;
	}

	public String getStuddob() {
		return studdob;
	}

	public void setStuddob(String studdob) {
		this.studdob = studdob;
	}

	public String getStudadd() {
		return studadd;
	}

	public void setStudadd(String studadd) {
		this.studadd = studadd;
	}

	public String getStudphone() {
		return studphone;
	}

	public void setStudphone(String studphone) {
		this.studphone = studphone;
	}

	public String getTechclass() {
		return techclass;
	}

	public void setTechclass(String techclass) {
		this.techclass = techclass;
	}

	public String getSsubject() {
		return ssubject;
	}

	public void setSsubject(String ssubject) {
		this.ssubject = ssubject;
	}

	public String getAssigntech() {
		return assigntech;
	}

	public void setAssigntech(String assigntech) {
		this.assigntech = assigntech;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}