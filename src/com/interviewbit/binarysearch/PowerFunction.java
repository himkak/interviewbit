package com.interviewbit.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class PowerFunction {

	public int pow(int x, int n, int d) {
		long res = 0;
		long dl = d;
		double limit=Math.pow(2, 32);
		res = pow(x, n, limit);
		long result= res % dl;
		if(result<0) {
			result= dl+result;
		}
		return (int)result;
	}

	private long pow(long x, long n, double limit) {
		if(n==0) {
			return 1;
		}
		if(x >= limit && n>1) {
			return (int)Math.pow(2, 31);
		}
		if (n % 2 == 1) {
			return x * pow(x, n - 1, limit);
		} else {
			return pow(x*x, n/2, limit);
		}
	}

//	public static void main(String[] args) {
//		int i = (int) Math.pow(2, 31);
//		System.out.println("int:" + i);
//		System.out.println(Math.pow(2, 31));
//	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, pow(2,32,3));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, pow(0,0,1));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(19, pow(-1,1,20));
	}
	
	
	@Test
	public void test4() {
		Assert.assertEquals(20805472, pow(71045970,41535484,64735492));
	}
	
}
