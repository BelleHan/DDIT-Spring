package com.java.module;

public class Multiplex implements CalModule {

	@Override
	public int execute(int a, int b) throws Exception {
		return a*b;
	}

}
