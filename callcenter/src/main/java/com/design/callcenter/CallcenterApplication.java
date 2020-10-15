package com.design.callcenter;

import java.util.HashMap;
import java.util.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.callcenter.Employees.Director;
import com.design.callcenter.Employees.Employee;
import com.design.callcenter.Employees.Manager;
import com.design.callcenter.Employees.Respondent;
import com.design.callcenter.callRouter.CallRoute;

@SpringBootApplication
public class CallcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallcenterApplication.class, args);
		
		
		Stack<Integer>st1 = new Stack<>();
		Stack<Integer>st2 = new Stack<>();
		Stack<Integer>st3 = new Stack<>();
		HashMap<Integer,Employee>mp = new HashMap<Integer,Employee>();
		
		for(int i=1;i<=50;i++)
		{
			st1.push(i);
			st2.push(i+50);
			st3.push(i+100);
			mp.put(i, new Respondent());
			mp.put(i+50, new Manager());
			mp.put(i+100, new Director());
		}
		
		
	}

}
