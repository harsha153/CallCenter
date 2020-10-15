package com.design.callcenter.callRouter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.design.callcenter.Employees.Employee;
import com.design.callcenter.call.Call;
import com.design.callcenter.constants.Levels;

//assuming 50 respondents ,50 managers,50 directors
//assume each call initially has level 1
public class CallRoute {

// stacks contain id's of respondents,managers and director who havent assignd any calls
	private static Stack<Integer> stackRs; //
	private static Stack<Integer> stackMn;
	private static Stack<Integer> stackDr;

	private static HashMap<Integer, Employee> id_Emp;// id to employee mapping
	private static Queue<Call> q;

	public static void initialize(Stack<Integer> st1, Stack<Integer> st2, Stack<Integer> st3,
			HashMap<Integer, Employee> mp) {
		stackRs = st1;
		stackMn = st2;
		stackDr = st3;
		id_Emp = mp;
		q = new LinkedList<>();
	}

	public void dispatch_call(Call call) {

		if (!stackRs.empty()) {
			int i = stackRs.pop();
			call.setEmployee(i);
			call.setRank(Levels.respondent);
		} else {
			if (!stackMn.empty()) {
				int i = stackMn.pop();
				call.setEmployee(i);
				call.setRank(Levels.manager);
			} else {
				if (!stackDr.empty()) {
					int i = stackDr.pop();
					call.setEmployee(i);
					call.setRank(Levels.director);
				} else {
					q.add(call);
				}
			}
		}
	}

	public static void Notify_call_completed(Call call) {
		switch (call.getRank()) {

		case Levels.respondent:
			stackRs.push(call.getEmployee());
			break;
		case Levels.manager:
			stackMn.push(call.getEmployee());
			break;
		case Levels.director:
			stackDr.push(call.getEmployee());
			break;
		}
	}

	public static void Escalate_Call(Call call) {

		/*
		 * based on call level ,call will be escalated.If call is level respondent ,it
		 * will check in stack whether any free managers are available and if they are
		 * not available then it will be escalated to director. After escalating to
		 * director employee will be freed and his id will be pushed into stack;
		 */
		int id;
		id = -1;
		if (call == null)
			return;

		switch (call.getRank()) {
		case Levels.manager:
			stackRs.push(call.getEmployee());
			break;
		case Levels.director:
			stackMn.push(call.getEmployee());
			break;
		}
		call.setEmployee(-1);

		if (call.getRank() == Levels.manager && !stackMn.isEmpty())
			id = stackMn.pop();
		else if ((call.getRank() == Levels.manager || call.getRank() == Levels.director) && !stackDr.isEmpty()) {
			id = stackDr.pop();
			call.setRank(Levels.director);
		} else
			q.add(call);

		if (id != -1) {
			call.setEmployee(id);
			Employee e = id_Emp.get(id);
			e.receiveCall(call);
		}

	}

	public void dispatch_queuedCall_to_freeEmployees() {
		// dispatch from queue and add it to the available freed employees
	}

}
