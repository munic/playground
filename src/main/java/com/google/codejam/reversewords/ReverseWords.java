package com.google.codejam.reversewords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * https://code.google.com/codejam/contest/351101/dashboard#s=p1
 *
 */
public class ReverseWords {

	public static void main(String[] args){
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			int numberOfTestCases = Integer.parseInt(br.readLine());
			for (int i = 0; i < numberOfTestCases; i++) {
				String currentRow = br.readLine();
				StringTokenizer tokenizer = new StringTokenizer(currentRow);
				String result =  "";
				while (tokenizer.hasMoreTokens()) {
					result = tokenizer.nextToken() + " " + result;
				}
				System.out.println(String.format("Case #%d: %s", i + 1, result));
				if (i == numberOfTestCases - 1) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
