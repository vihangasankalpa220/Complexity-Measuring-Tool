/*
 * Scanner is used for parsing tokens from the contents of the stream 
 * while BufferedReader just reads the stream and does not do any special parsing.
 */
package com.codeingrams.client;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import com.codeingrams.analyzer.AnalyzerImpl;
import com.codeingrams.analyzer.IAnalyzer;
import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.CreateProperties;
import com.codeingrams.conf.IConf;
import com.codeingrams.logger.ILogger;
import com.codeingrams.logger.LoggerImpl;
import com.codeingrams.measurements.CncImpl;

class Main {
	public static void main(String[] args) {
		//runtime counter init
		long startTime = System.nanoTime();
		
		//welcome message
		System.out.print("\r\n" + 
				" __   __   __   ___         __   __              __  \r\n" + 
				"/  ` /  \\ |  \\ |__  | |\\ | / _` |__)  /\\   |\\/| /__` \r\n" + 
				"\\__, \\__/ |__/ |___ | | \\| \\__> |  \\ /~~\\  |  | .__/ \r\n" + 
				"                                                    \r\n" + 
				"===============CODE COMPLEXITY in GRAMS=============== \n \n");
		
		//create properties file TODO: Uncomment after deployment
		CreateProperties c = new CreateProperties();
		c.setProperties();
		
		//Load configurations
		IConf conf = new ConfImpl("./config.properties");
		
		//load input file
		String INPUTFILE = conf.loadConfig("INPUTFILE");
		
		//load output file
		String OUTPUTFILE = conf.loadConfig("OUTPUTFILE");
		
		//ANALYSER CONFIG SYSTEM loggers init
		ILogger ANALYSERLOGER = new LoggerImpl("ANALYZER");
		ANALYSERLOGER.log("hello");
		ILogger CONFIGLOGER = new LoggerImpl("CONFIG");
		ILogger SYSTEMLOGER = new LoggerImpl("SYSTEM");
		
		//load analyzer
		IAnalyzer analyzer = new AnalyzerImpl();
		try {
			analyzer.run(INPUTFILE.toString());
		} catch (IOException e) {
			System.out.println(e);
		}
	
		//Complexity by nesting
		CncImpl cnc = new CncImpl();
		System.out.println(" Nesting level depth: "+cnc.maxDepth(INPUTFILE.toString()));
		
		//-----------------------end of the analyze----------------------------
		long endTime   = System.nanoTime();
		NumberFormat formatter = new DecimalFormat("#0.0");
		System.out.println("================ Analyzed in "+ formatter.format((endTime - startTime) / 1000000000d)+" seconds ===============");
	}
}
