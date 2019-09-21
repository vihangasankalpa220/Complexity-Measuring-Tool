/*
 * Scanner is used for parsing tokens from the contents of the stream 
 * while BufferedReader just reads the stream and does not do any special parsing.
 */
package com.codeingrams.client;

import java.awt.image.VolatileImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.codeingrams.analyzer.AnalyzerImpl;
import com.codeingrams.analyzer.IAnalyzer;
import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.CreateProperties;
import com.codeingrams.conf.IConf;
import com.codeingrams.inheritance.Iinheritance;
import com.codeingrams.logger.ILogger;
import com.codeingrams.logger.LoggerImpl;
import com.codeingrams.measurements.CiImpl;
import com.codeingrams.measurements.CncImpl;
import com.codeingrams.measurements.CsImpl;
import com.codeingrams.measurements.TableViewComplexitySize;


import com.codeingrams.size.ISize;

import java.text.ParseException;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

class Main {
	
	public static void main(String[] args) throws ParseException {
		javax.swing.JTable jTable1 = null;
		//runtime counter init
		long startTime = System.nanoTime();
		
		//welcome message
		System.out.print("\r\n" + 
				" __   __   __   ___         __   __              __  \r\n" + 
				"/  ` /  \\ |  \\ |__  | |\\ | / _` |__)  /\\   |\\/| /__` \r\n" + 
				"\\__, \\__/ |__/ |___ | | \\| \\__> |  \\ /~~\\  |  | .__/ \r\n" + 
				"                                                    \r\n" + 
				"===============CODE COMPLEXITY in GRAMS=============== \n \n");
		
		//create properties file 
		CreateProperties c = new CreateProperties();
		c.setProperties();
		
		//Load configurations
		IConf conf = new ConfImpl("./config.properties");
		
		//load input file
		String INPUTFILE = conf.loadConfig("INPUTFILE");
		
		//load output file
		//String OUTPUTFILE = conf.loadConfig("OUTPUTFILE");
		
		//ANALYSER CONFIG SYSTEM loggers init
		ILogger ANALYSERLOGER = new LoggerImpl("ANALYZER");
		ANALYSERLOGER.log("hello");
		//ILogger CONFIGLOGER = new LoggerImpl("CONFIG");
		//ILogger SYSTEMLOGER = new LoggerImpl("SYSTEM");
		
		//load analyzer
		IAnalyzer analyzer = new AnalyzerImpl();
		try {
                   
			analyzer.run(INPUTFILE.toString());
		} catch (IOException e) {
			System.out.println(e);
		}
	
		//Complexity due to inheritance
				Iinheritance cInheritance = new CiImpl();
				System.out.println("========================Complexity Due To Inheritance========================");
				try {
					cInheritance.count(INPUTFILE.toString());
				} catch (IOException e) {
					System.out.println(e);
				}
				System.out.println("=============================================================================");
				
				
				System.out.println("=============================================================================");
				System.out.println("Complexity By Size Operators Count");
				System.out.println("=============================================================================");
				//load analyzer
						ISize size = new CsImpl();
						try {
							size.MeasureSize();
							 VolatileImage msg = null;
				                new TableViewComplexitySize(msg).setVisible(true);		 	
						} catch (IOException e) {
							System.out.println(e);
						}
				
						System.out.println("====================================================");
						System.out.println("Complexity By Size Cs Value Counter");			
						
						
						//Complexity by nesting
						//CpImpl cp = new CpImpl();
						//System.out.println(" Complexity by Size CP : "+cp.maxDepth(INPUTFILE.toString()));
				
						
		
		//-----------------------end of the analyze----------------------------
		long endTime   = System.nanoTime();
		NumberFormat formatter = new DecimalFormat("#0.0");
		System.out.println("================ Analyzed in "+ formatter.format((endTime - startTime) / 1000000000d)+" seconds ===============");
	
		//load UI
		//UI ui = new UI();
		//ui.loadUI();
	}
}
