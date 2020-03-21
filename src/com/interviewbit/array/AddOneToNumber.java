package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class AddOneToNumber {
	
	public List<Integer> plusOne(List<Integer> A) {
		int over=0;
		for (int i = A.size()-1; i > -1; i--) {
			int add=0;
			if(i==A.size()-1) {
				add=1;
			}
			int updatedVal=A.get(i)+add+over;
			over=0;
			if(updatedVal>9) {
				updatedVal=0;
				over=1;
			}
			A.set(i, updatedVal);
		}
		ArrayList<Integer> updatedArray=new ArrayList<>();
		if(over>0) {
			updatedArray.add(over);
		}
		updatedArray.addAll(A);
		while(updatedArray.get(0)==0) {
			updatedArray.remove(0);
		}
		return updatedArray;
    }
	
	
	@Test
	public void test() {
		
		Assert.assertEquals(Arrays.asList(6, 0, 6, 4, 8, 8, 2 ), plusOne(Arrays.asList(0, 6, 0, 6, 4, 8, 8, 1 )));
		Assert.assertEquals(Arrays.asList(3, 7, 6, 4, 0, 5, 5, 6 ), plusOne(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5))); 
		Assert.assertEquals(Arrays.asList(1,2,4), plusOne(Arrays.asList(1,2,3)));
		Assert.assertEquals(Arrays.asList(1, 0, 0, 0, 0, 0 ), plusOne(Arrays.asList(9, 9, 9, 9, 9)));
		
		
	}

}
