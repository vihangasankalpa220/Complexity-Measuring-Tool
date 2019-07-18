/*
 * Scanner is used for parsing tokens from the contents of the stream 
 * while BufferedReader just reads the stream and does not do any special parsing.
 */
package com.codeingrams.client;

import java.io.IOException;
import com.codeingrams.analyzer.AnalyzerImpl;
import com.codeingrams.analyzer.IAnalyzer;

class Main {
	public static void main(String[] args) {
		String FILEPATH = "./input/codeBlock.txt";
		IAnalyzer analyzer = new AnalyzerImpl();
		try {
			analyzer.run(FILEPATH.toString());
		} catch (IOException e) {
			System.out.println(e);;
		}
	}
}
