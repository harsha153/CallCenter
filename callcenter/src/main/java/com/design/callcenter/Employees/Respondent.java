package com.design.callcenter.Employees;

import com.design.callcenter.call.Call;
import com.design.callcenter.callRouter.CallRoute;
import com.design.callcenter.constants.CallStatus;
import com.design.callcenter.constants.Levels;

public class Respondent extends Employee{
	public Respondent()
	{
		rank=Levels.respondent;
	}
	@Override
	public void receiveCall(Call call) {
		System.out.println("handle call");
		
	}

	@Override
	public void callCompleted(Call call) {
		
		call.setStatus(CallStatus.completed);
		CallRoute.Notify_call_completed(call);
		
	}

	@Override
	public void escalateCall(Call call) {
		System.out.println("Escalate call");
        call.setRank(Levels.manager);
        
		CallRoute.Escalate_Call(call);
	}

}
