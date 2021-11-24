package com.java.module;

public class SummationEX extends Summation {

	@Override
	public int execute(int a, int b) throws Exception {
		return super.execute(a, b)+10000;
	}
	
	

}
