package com.hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class MorePizza {

	public static class ListAndSum {
		List<Integer> maxOrderedPizzasIndex;
		int maxSum;

		public ListAndSum(List<Integer> maxOrderedPizzasIndex, int maxSum) {
			super();
			this.maxOrderedPizzasIndex = maxOrderedPizzasIndex;
			this.maxSum = maxSum;
		}

	}

	public List<Integer> morePizzas(int maxSlices, int types, List<Integer> pizzaSlices) {

		return selectMaxSlices(pizzaSlices, 0, maxSlices, types, 0).maxOrderedPizzasIndex;

	}

	public ListAndSum selectMaxSlices(List<Integer> pizzaSlices, int startIdx, int pendingSlices, int types,
			int sumOfSelectedSlices) {
		if (pendingSlices == 0 || startIdx == types) {
			return null;
		}
		int maxSumOfSlices = Integer.MIN_VALUE;
		List<Integer> maxOrderedPizzasIndex = null;
		for (int i = startIdx; i < pizzaSlices.size(); i++) {
			int tmpSum = sumOfSelectedSlices;
			List<Integer> orderedPizzasIndex = new ArrayList<>();
			if (sumOfSelectedSlices + pizzaSlices.get(i) <= pendingSlices) {
				orderedPizzasIndex.add(i);
				sumOfSelectedSlices = sumOfSelectedSlices + pizzaSlices.get(i);
				ListAndSum listAndSum = selectMaxSlices(pizzaSlices, i + 1, pendingSlices, types, sumOfSelectedSlices);
				if (listAndSum != null && listAndSum.maxOrderedPizzasIndex != null) {
					orderedPizzasIndex.addAll(listAndSum.maxOrderedPizzasIndex);
					sumOfSelectedSlices = listAndSum.maxSum;
				}
			}

			if (sumOfSelectedSlices > maxSumOfSlices) {
				maxSumOfSlices = sumOfSelectedSlices;
				maxOrderedPizzasIndex = orderedPizzasIndex;
			}
			sumOfSelectedSlices = tmpSum;

		}
		return new ListAndSum(maxOrderedPizzasIndex, maxSumOfSlices);

	}

	@Test
	public void test() throws IOException {
		String inputFile = "a_example.in";
		List<Integer> expected = new ArrayList<>(Arrays.asList(0, 2, 3));
		String outputFile = "a_example.out";

		ReadTestAndWrite(inputFile, expected, outputFile);

	}

	@Test
	public void test3() throws FileNotFoundException, IOException {
		String inputFile = "a_example.in";
		List<Integer> expected = new ArrayList<>(Arrays.asList(0, 2, 3));
		String outputFile = "a_example.out";

		ReadTestAndWrite(inputFile, expected, outputFile);
	}

	private void ReadTestAndWrite(String inputFile, List<Integer> expected, String outputFile)
			throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\hmnsh\\Documents\\eclipse workspaces\\workspace1_poc\\InterviewBit\\src\\com\\hashcode\\"
						+ inputFile));
		String line1 = br.readLine();
		String line2 = br.readLine();
		String[] line1Arr = line1.split(" ");
		int maxAllowedSlices = Integer.parseInt(line1Arr[0]);
		int pizzasTypes = Integer.parseInt(line1Arr[1]);

		// int[] pizzaSlices = { 2, 5, 6, 8 };
		List<Integer> pizzaSlices = Arrays.asList(line2.split(" ")).stream().map(Integer::parseInt)
				.collect(Collectors.toList());
		List<Integer> result = morePizzas(maxAllowedSlices, pizzasTypes, pizzaSlices);
		if (expected != null) {
			Assert.assertEquals(expected, result);
		}
		String resStr = String.join(" ", result.stream().map(a -> Integer.toString(a)).collect(Collectors.toList()));

		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"C:\\Users\\hmnsh\\Documents\\eclipse workspaces\\workspace1_poc\\InterviewBit\\src\\com\\hashcode\\"
						+ outputFile));
		bw.write(Integer.toString(result.size()));
		bw.newLine();
		bw.write(resStr);
		bw.close();
		br.close();
	}

	@Test
	public void test1() {
		List<Integer> pizzaSlices = new ArrayList<>(Arrays.asList(6, 8));
		List<Integer> expected = new ArrayList<>(Arrays.asList(1));
		Assert.assertEquals(expected, morePizzas(9, 2, pizzaSlices));
	}

	@Test
	public void test2() {
		List<Integer> pizzaSlices = new ArrayList<>(Arrays.asList(4, 14, 15, 18, 29, 32, 36, 82, 95, 95));
		List<Integer> expected = new ArrayList<>(Arrays.asList(1));
		Assert.assertEquals(expected, morePizzas(100, 10, pizzaSlices));
	}

}
