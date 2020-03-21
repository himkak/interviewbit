package com.interviewbit.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumContiguousSubarray {

	public int maxSubArray(final List<Integer> A) {
		int maxSum = Integer.MIN_VALUE;
		int previousSum = 0;
		for (int i = 0; i < A.size(); i++) {
			if (previousSum < 0) {
				previousSum = 0;
			}
			int currSum = previousSum + A.get(i);
			int currNextSum = Integer.MIN_VALUE;
			if (i < A.size() - 1) {
				currNextSum = currSum + A.get(i + 1);
			}
			if (currSum > maxSum || currNextSum >= maxSum) {
				maxSum = currSum;
				//System.out.println(maxSum);
			} 
			previousSum = currSum;


		}
		return maxSum;
	}

	@Test
	public void test() {
		Assert.assertEquals(-89, maxSubArray(Arrays.asList(-89, -277, -475, -480, -420)));
		
		Assert.assertEquals(217, maxSubArray(Arrays.asList(80, 65, 63, -452, -462, -449, -327, -409,  -418, 63, 77, 77, -197,
				-380)));
		Assert.assertEquals(10, maxSubArray(Arrays.asList(1, 2, 3, 4, -10)));
		Assert.assertEquals(6, maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));

		//
	}

}
