package com.First_Framework.stepdefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	private int i, j, r = 0;
	@Given("I have {int} and {int}")
	public void i_have_and(int i, int j) {
	    this.i = i;
	    this.j = j;
	}

	@When("I add them")
	public void i_add_them() {
	    r = i+j;
	}

	@Then("Verify if the result is prime")
	public void verify_if_the_result_is_prime() {
	    int count = 1;
	    for(int i = 2; i<r; i++) {
	    	if(r%i==0) {
	    		count++;
	    	}
	    }
	    if(count>2) {
	    	System.out.println(r+ " is NOT prime");
	    }else {
	    	System.out.println(r+ " is prime");
	    }
	}
	
	@Given("I have a number {int}")
	public void acceptOneNumber(int x) {
		
	}

	@Given("I have a name {word}")
	public void acceptString(String s) {
		System.out.println("String: "+s);
	}
	
	@Given("I have <RTO_Codes>")
	public void acceptRTOCodes(DataTable dt) {
		List rtocodes = dt.asList();
		
		for (Object rtoCode : rtocodes) {
			System.out.println(rtoCode);
		}
		
	}
	
	@Given("I have <RTO_Codes> and <State_Name>")
	public void acceptRTOCodesAndStateNames(DataTable dt) {
		Map stateInfo = dt.asMap();
		
		Iterator<Map.Entry> itr = stateInfo.entrySet().iterator();
		while(itr.hasNext()) {
			Entry e = itr.next();
			System.out.println(e.getKey()+"\t"+e.getValue());
		}	
	}
	
	@Given("I have a {word}")
	public void acceptRTOCodes(String rtoCode){
		System.out.println(rtoCode);
	}
	
	@Given("I have a {word} and {word}")
	public void acceptRTOCodesAndStateCodes(String rtoCode, String stateCode) {
		System.out.println(rtoCode+"\t"+stateCode);
	}
}
