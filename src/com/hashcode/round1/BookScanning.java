package com.hashcode.round1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class BookScanning {

	/*
	 * public static class Result { int noOfLibsScanned; List<LibraryResult>
	 * libResult;
	 * 
	 * }
	 */

	public static class LibraryResult {
		int libId;
		int totalBooksForScanning;
		List<Integer> booksIds;
	}

	public static class Library implements Comparable<Library> {
		int libId;
		int daysToRegister;
		int noOfBooks;
		int noOfBooksPerDay;
		List<Integer> booksIndexes;

		public Library(int libId, int daysToRegister, int noOfBooks, int noOfBooksPerDay, List<Integer> booksIndexes) {
			super();
			this.libId = libId;
			this.daysToRegister = daysToRegister;
			this.noOfBooks = noOfBooks;
			this.noOfBooksPerDay = noOfBooksPerDay;
			this.booksIndexes = booksIndexes;
		}

		@Override
		public int compareTo(Library o) {
			return Integer.compare(o.daysToRegister, this.daysToRegister);
		}

	}

	public void maxScoreForLibrary(int noOfBooks, int noOfLibs, int noOfDays, List<Library> libsDetails,
			List<Integer> scoresOfBooks, BufferedWriter bw) throws IOException {
		// Result res = new Result();
		int noOfLibsToRead = getNoOfLibsToRead(libsDetails, noOfDays);
		bw.write(Integer.toString(noOfLibsToRead));
		getOrderOfLibsToRead(libsDetails, scoresOfBooks, noOfLibsToRead, noOfDays, bw);

		// return null;

	}

	private static class LibScoreFOrSpecificDays implements Comparable<LibScoreFOrSpecificDays> {
		int libId;
		int totalScore;

		@Override
		public int compareTo(LibScoreFOrSpecificDays o) {
			return Integer.compare(o.totalScore, this.totalScore);
		}

		public LibScoreFOrSpecificDays(int libId, int totalScore) {
			super();
			this.libId = libId;
			this.totalScore = totalScore;
		}

	}

	private void getOrderOfLibsToRead(List<Library> libsDetails, List<Integer> scoresOfBooks, int noOfLibsToRead,
			int totalNoOfDays, BufferedWriter bw) throws IOException {
		int startIdx = libsDetails.size() - noOfLibsToRead;
		int maxDaysToIdentifyPriority = libsDetails.get(startIdx).daysToRegister + 1;

		List<LibScoreFOrSpecificDays> orderOfLib = new ArrayList<>();
		Map<Integer, Library> libToIdMap = new HashMap<>();
		for (int i = startIdx; i < libsDetails.size(); i++) {
			int score = getScoreForLibFOrSpecificDays(libsDetails.get(i), maxDaysToIdentifyPriority, scoresOfBooks);
			orderOfLib.add(new LibScoreFOrSpecificDays(libsDetails.get(i).libId, score));
			libToIdMap.put(libsDetails.get(i).libId, libsDetails.get(i));
		}
		Collections.sort(orderOfLib);

		// process lib
		int leftDays = totalNoOfDays;
		for (int i = 0; i < orderOfLib.size(); i++) {
			int libId = orderOfLib.get(i).libId;
			Library lib = libToIdMap.get(libId);
			// System.out.println("processing lib:" + lib.libId);
			 bw.newLine();
			leftDays = leftDays - lib.daysToRegister;
			int noOfFilesCanBeProcessed = leftDays * lib.noOfBooksPerDay;
			noOfFilesCanBeProcessed = noOfFilesCanBeProcessed <= lib.noOfBooks ? noOfFilesCanBeProcessed
					: lib.noOfBooks;
			// System.out.println("noOfFilesCanBeProcessed:" + noOfFilesCanBeProcessed);
			bw.write(Integer.toString(lib.libId) + " " + Integer.toString(noOfFilesCanBeProcessed));

			// indexes of libs to be processed

			Map<Integer, Integer> bookIdToScoreMapping = new HashMap<>();
			for (int j = 0; j < lib.booksIndexes.size(); j++) {
				bookIdToScoreMapping.put(lib.booksIndexes.get(j), scoresOfBooks.get(lib.booksIndexes.get(j)));
			}

			LinkedHashMap<Integer, Integer> bookIdToScoreMappingSorted = bookIdToScoreMapping.entrySet().stream()
					.sorted(Map.Entry.comparingByValue((x, y) -> Integer.compare(y, x))).collect(Collectors
							.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			int k = 0;
			String boolsIds = "";
			for (Entry<Integer, Integer> bookIdToScoreMappingSortedEntry : bookIdToScoreMappingSorted.entrySet()) {
				if (k == noOfFilesCanBeProcessed) {
					break;
				}
				boolsIds = boolsIds.concat(bookIdToScoreMappingSortedEntry.getKey() + " ");
				// System.out.println(bookIdToScoreMappingSortedEntry.getKey());
				k++;
			}
			bw.newLine();
			bw.write(boolsIds.trim());

		}

	}

	private int getScoreForLibFOrSpecificDays(Library libDetails, int noOfDaysToCOnsiderToIdenLibOrder,
			List<Integer> scoresOfBooks) {
		int daysToCOnsider = noOfDaysToCOnsiderToIdenLibOrder - libDetails.daysToRegister;
		int noOfBooksFOrThatDuration = daysToCOnsider * libDetails.noOfBooksPerDay;

		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < libDetails.booksIndexes.size(); i++) {
			scores.add(scoresOfBooks.get(libDetails.booksIndexes.get(i)));
		}
		Collections.sort(scores);
		int totalScore = 0;

		for (int i = 0; i < noOfBooksFOrThatDuration; i++) {
			totalScore = totalScore + scores.get(i);
		}
		return totalScore;
	}

	private int getNoOfLibsToRead(List<Library> libsDetails, int noOfDays) {

		for (int i = 0; i < libsDetails.size(); i++) {
			if (libsDetails.get(i).daysToRegister < noOfDays) {
				return libsDetails.size() - i;
			}
		}
		return 0;
	}

	@Test
	public void test() throws IOException {
//		String inputFile = "a_example.txt";
//		String outputFile = "a_example_output.txt";
		
		String inputFile = "c_incunabula.txt";
		String outputFile = "c_incunabula_output.txt";
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\hmnsh\\Documents\\eclipse workspaces\\workspace1_poc\\InterviewBit\\src\\com\\hashcode\\round1\\"
						+ inputFile));
		String line1 = br.readLine();
		String[] line1Arr = line1.split(" ");
		int noOfBooks = Integer.parseInt(line1Arr[0]);
		int noOfLibs = Integer.parseInt(line1Arr[1]);
		int noOfDays = Integer.parseInt(line1Arr[2]);

		List<Integer> scoresOfBooks = Arrays.asList(br.readLine().split(" ")).stream().map(i -> Integer.parseInt(i))
				.collect(Collectors.toList());

		List<Library> libsDetails = new ArrayList<>();
		for (int j = 0; j < noOfLibs; j++) {
			String[] libDetails = br.readLine().split(" ");

			List<Integer> libBooksIndexes = Arrays.asList(br.readLine().split(" ")).stream()
					.map(i -> Integer.parseInt(i)).collect(Collectors.toList());

			libsDetails.add(new Library(j, Integer.parseInt(libDetails[1]), Integer.parseInt(libDetails[0]),
					Integer.parseInt(libDetails[2]), libBooksIndexes));

		}
		Collections.sort(libsDetails);

		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"C:\\Users\\hmnsh\\Documents\\eclipse workspaces\\workspace1_poc\\InterviewBit\\src\\com\\hashcode\\round1\\"
						+ outputFile));

		maxScoreForLibrary(noOfBooks, noOfLibs, noOfDays, libsDetails, scoresOfBooks, bw);

		bw.close();
		br.close();

	}

}
