package com.design.callcenter.Employees;

import com.design.callcenter.call.Call;

public abstract class Employee {

	protected int age;
	protected String firstName;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String lastName;
	protected String title;
	protected String address;
	protected String gender;
	
	protected String rank;
	
	
	public abstract  void receiveCall(Call call); 
	
	public abstract void callCompleted(Call call);
	
    public abstract void escalateCall(Call call);

	

}