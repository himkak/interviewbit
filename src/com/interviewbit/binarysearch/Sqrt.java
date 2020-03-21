package com.interviewbit.binarysearch;

import org.junit.Assert;
import org.junit.Test;

//Without using sqrt function
public class Sqrt {
	public int sqrt(int A) {
		if(A==0 || A==1) {
			return A;
		}

		long min = 0;
		long max = A;
		return (int)sqrt(A, min, max);
	}

	public long sqrt(int A, long min, long max) {
		long mid =(min+ max) / 2;
		if(min==max && min*min<A) {
			return min;
		}else if (max - min == 1 && min * min <= A && max * max > A) {
			return min;

		} else if(max - min == 1 && max * max <= A) {
			return max;
		}
		else {
			if(mid*mid==A) {
				return mid;
			}else if ((mid * mid) > A) {
				max = mid -1;
			} else if ((mid * mid) < A) {
				min = mid ;
			}
			return sqrt(A, min, max);
		}
	}

	@Test
	public void test() {
		Assert.assertEquals(3, sqrt(11));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, sqrt(2));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, sqrt(3));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(2, sqrt(4));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(2, sqrt(6));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(3, sqrt(9));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(46340, sqrt(2147483647));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(30127, sqrt(907693136));
	}
}
