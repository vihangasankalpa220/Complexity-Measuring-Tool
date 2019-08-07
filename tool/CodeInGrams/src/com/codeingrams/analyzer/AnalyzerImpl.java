/*
 * Analyzer Implementation
 */
package com.codeingrams.analyzer;
import java.io.*;
import java.util.regex.*;

import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.CreateProperties;
import com.codeingrams.conf.IConf;
import com.codeingrams.logger.ILogger;
import com.codeingrams.logger.LoggerImpl;
import com.codeingrams.measurements.CncImpl;

public class AnalyzerImpl implements IAnalyzer{
		
		///variables
	  	int forCount       = 0;
	  	int whileCount   = 0;
	    int punctuationCount = 0;
	    int whitespaceCount  = 0;
	    int digitCount       = 0;
	    int uppercaseCount   = 0;
	    int lowercaseCount   = 0;
	    int wordCount        = 0;
	    int charCount        = 0;
	    int lineCount        = 0;
	    IConf conf;
	    CreateProperties c;
	    String INPUTFILE;
	    String OUTPUTFILE;
	    ILogger ANALYSERLOGER;
	    ILogger CONFIGLOGER;
	    ILogger SYSTEMLOGER;
      
	    public AnalyzerImpl(){
			//create properties file TODO: Uncomment after deployment
			c = new CreateProperties();
			c.setProperties();
			
			//Load configurations
			conf = new ConfImpl("./config.properties");
			
			//load input file
			INPUTFILE = conf.loadConfig("INPUTFILE");
			
			//load output file
			OUTPUTFILE = conf.loadConfig("OUTPUTFILE");
			
			//ANALYSER CONFIG SYSTEM loggers init
			ANALYSERLOGER = new LoggerImpl("ANALYZER");
			CONFIGLOGER = new LoggerImpl("CONFIG");
			SYSTEMLOGER = new LoggerImpl("SYSTEM");
	    }
	    
		//count occurrences 
	    private int count(String line, Pattern pattern) {
	        int count = 0;
	        Matcher matcher = pattern.matcher(line);
	        while (matcher.find()) {
	            ++count;
	        }
	        return count;
	    }

	    //run regex resolution
	    public void run(String path) throws IOException {

	        Pattern FOR      = Pattern.compile("for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)");
	        Pattern WHILE  = Pattern.compile("while\\s*\\([^)]*\\)");
	        
	        //Complexity by nesting
			CncImpl cnc = new CncImpl();
			
	        //handle no  file
	        if (path==null) {
	            System.out.println("Error: No filename provided");
	            System.exit(-1);
	        }

	        try {
	        	//read file using buffer reader as the fastest method
	            BufferedReader br = new BufferedReader(new FileReader(path));
	            //update counters
	            for (String line; (line = br.readLine()) != null; ) {
	                ++lineCount;
	                forCount       += count(line, FOR);
	                whileCount   += count(line, WHILE);
	            }
	            //release buffer reader
	            if(br != null)
                	br.close();
	            
	        } catch (Exception e) {
	        	//handle exceptions 
	            System.out.println("Couldn't parse " + path + "\n" + e.getMessage());
	            System.exit(-1);
	        }
	        
	        //output
	        System.out.println(" Analysis of file \t: " + path);
	        System.out.println(" LOC\t\t\t:"  + lineCount);
	        System.out.println(" WHILE\t\t \t:"  + whileCount);
	        System.out.println(" FOR\t\t\t:"  + forCount);
	        System.out.println(" Nesting level depth\t:"+cnc.maxDepth(INPUTFILE.toString()));
	    }
	
}
