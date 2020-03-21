package com.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;

public class GrayCode {

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<String> result = new ArrayList<>();
		String firstElem = "";
		for (int i = 0; i < n; i++) {
			firstElem = firstElem.concat("0");
		}
		result.add(firstElem);
		helper(firstElem, n, result, new ArrayList<>(),0);

		ArrayList<Integer> finalRes = new ArrayList<>();
		for (String res : result) {
			finalRes.add(convertBinToNum(res));
		}

		return finalRes;
	}

	private Integer convertBinToNum(String res) {
		return Integer.parseInt(res, 2);
	}

	private boolean helper(String lastElem, int n, ArrayList<String> result, ArrayList<String> maxResult, int depthCnt) {
		if(depthCnt==Math.pow(n, n)) {
			return true;
		}
		if (result.size() < maxResult.size()) {
			result = maxResult;
			//return true;
		}
		// if()
		//System.out.println("size:" + result.size());

		for (int i = 0; i < n; i++) {
			String tmpLastElem = flipElem(lastElem, i);
			if (diff(tmpLastElem, result.get(result.size() - 1)) == 1 && !result.contains(tmpLastElem)) {
				result.add(tmpLastElem);
				// System.out.println("added:" + tmpLastElem);
				if (!helper(tmpLastElem, n, result, maxResult, depthCnt+1)) {
					// System.out.println("removed:"+result.get(result.size() - 1));
					result.remove(result.size() - 1);
					return false;
				} else {
					return true;
				}
			}

		}
		return true;

	}

	private int diff(String tmpLastElem, String lastElem) {
		int diff = 0;
		for (int i = 0; i < lastElem.length(); i++) {
			if (tmpLastElem.charAt(i) != lastElem.charAt(i)) {
				diff++;
			}

		}
		return diff;
	}

	private String flipElem(String lastElem, int i) {
		char[] le = lastElem.toCharArray();
		char elAtI = le[i];
		if (elAtI == '0') {
			le[i] = '1';
		} else {
			le[i] = '0';
		}
		return String.valueOf(le);
	}
	
	static int num;
	private void grayCodeUtil(ArrayList<Integer> res, int n) 
	{ 
	    // base case when we run out bits to process 
	    // we simply include it in gray code sequence. 
	    if (n == 0) 
	    { 
	        res.add(num); 
	        return; 
	    } 
	  
	    // ignore the bit. 
	    grayCodeUtil(res, n - 1); 
	  
	    // invert the bit. 
	    num = num ^ (1 << (n - 1)); 
	    grayCodeUtil(res, n - 1); 
	} 
	  
	// returns the vector containing the gray  
	// code sequence of n bits. 
	public ArrayList<Integer> grayCodes(int n) 
	{ 
		ArrayList<Integer> res = new ArrayList<Integer>(); 
	  
	    // num is passed by reference to keep 
	    // track of current code. 
	    num = 0; 
	    grayCodeUtil(res, n); 
	  
	    return res; 
	} 

	@Test
	public void test() {
		grayCode(10);

	}

	@Test
	public void test1() {
		grayCodes(3);
	}

}
