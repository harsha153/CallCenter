package com.design.callcenter.call;

import com.design.callcenter.Employees.Employee;
import com.design.callcenter.constants.Levels;

public class Call {

	private String callerName;
	private String rank;
	private int emp_Id;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCallerName() {
		return callerName;
	}
	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getEmployee() {
		return emp_Id;
	}
	public void setEmployee(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public Call()
	{
		rank=Levels.respondent;
	}
	
}
