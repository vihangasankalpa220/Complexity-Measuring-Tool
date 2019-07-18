/*
 * Scanner is used for parsing tokens from the contents of the stream 
 * while BufferedReader just reads the stream and does not do any special parsing.
 */
package com.codeingrams.client;

import java.io.IOException;
import com.codeingrams.analyzer.AnalyzerImpl;
import com.codeingrams.analyzer.IAnalyzer;
import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.IConf;

class Main {
	public static void main(String[] args) {
		
		//Load configurations
		IConf conf = new ConfImpl("./config.properties");
		System.out.println(conf.loadConfig("host"));
		
		//load input file
		String INPUTFILE = conf.loadConfig("INPUTFILE");
		
		//load output file
		String OUTPUTFILE = conf.loadConfig("OUTPUTFILE");
		
		//load analyser
		IAnalyzer analyzer = new AnalyzerImpl();
		try {
			analyzer.run(INPUTFILE.toString());
		} catch (IOException e) {
			System.out.println(e);;
		}
		
	}
}
