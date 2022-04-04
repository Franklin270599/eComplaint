package com.model;

public class Complaint {
//Attributes accessed by the Complaint POJO class
	private int cId;
	private String name;
	private Long acctno;
	private String compType;
	private String description;
	private String status;
	private String priority;
	
	@Override
	public String toString() {
		return "Complaint [cId=" + cId + ", name=" + name + ", acctno=" + acctno + ", compType=" + compType
				+ ", description=" + description + ", status=" + status + ", priority=" + priority + "]";
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAcctno() {
		return acctno;
	}
	public void setAcctno(Long acctno) {
		this.acctno = acctno;
	}
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
