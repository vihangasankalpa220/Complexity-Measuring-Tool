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
import com.codeingrams.measurements.Database;

public class AnalyzerImpl implements IAnalyzer{
		
		///variables
	  	int forCount       = 0;
	  	int whileCount   = 0;
	    int lineCount        = 0;
	    int elseCount   = 0;
	    int elseifCount        = 0;
	    int doCount        = 0;
	    int switchCount   = 0;
	    int ifCount        = 0;
	  	int vowelCount       = 0;
	  	int consonantCount   = 0;
	    int punctuationCount = 0;
	    int whitespaceCount  = 0;
	    int digitCount       = 0;
	    int uppercaseCount   = 0;
	    int lowercaseCount   = 0;
	    int wordCount        = 0;
	    int charCount        = 0;
	 
	  int manic=0;
	  int artc=0;
	    
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
	        Pattern DO  = Pattern.compile("do\\s*\\([^)]*\\)");
	        Pattern IF  = Pattern.compile("if\\s*\\([^)]*\\)");
	        Pattern SWITCH  = Pattern.compile("swich\\s*\\([^)]*\\)");
	        Pattern ELSEIF  = Pattern.compile("else\\sif\\s*\\([^)]*\\)");
	        Pattern ELSE  = Pattern.compile("else\\s*\\([^)]*\\)");
	        Pattern punctuation = Pattern.compile(".*&&.*");
	        Pattern whitespace  = Pattern.compile(".*||.*");
	        Pattern digits      = Pattern.compile(".*&.*");
	        Pattern uppercase   = Pattern.compile(".*|.*");
	        Pattern lowercase   = Pattern.compile(".*for.*");
	        Pattern words       = Pattern.compile(".*for.*");
	        Pattern characters  = Pattern.compile("\\s");
	        
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
	                elseCount       += count(line, ELSE);
	                elseifCount   += count(line, ELSEIF);
	                switchCount       += count(line, SWITCH);
	                ifCount   += count(line, IF);
	                doCount   += count(line, DO);
	                punctuationCount += count(line, punctuation);
	                whitespaceCount  += count(line, whitespace);
	                digitCount       += count(line, digits);
	                uppercaseCount   += count(line, uppercase);
	                lowercaseCount   += count(line, lowercase);
	                wordCount        += count(line, words);
	                charCount        += count(line, characters);
	            }
	            //release buffer reader
	            if(br != null)
                	br.close();
	            
	        } catch (Exception e) {
	        	//handle exceptions 
	            System.out.println("Couldn't parse " + path + "\n" + e.getMessage());
	            System.exit(-1);
	        }
	        
	        System.out.println("========================Complexity due to Nesting Level ========================");
	        System.out.println(" Nesting level depth\t:"+cnc.maxDepth(INPUTFILE.toString()));
	        
	        //output
	        if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true")) {
	        	System.out.println(" Analysis of file \t: " + path);
		        System.out.println(" LOC\t\t\t:"  + lineCount);
		        System.out.println(" WHILE\t\t \t:"  + whileCount);
		        System.out.println(" FOR\t\t\t:"  + forCount);
		        System.out.println(" IF\t\t \t:"  + ifCount);
		        System.out.println(" ELSE IF\t\t:"  + elseifCount);
		        System.out.println(" SWITCH\t\t \t:"  + switchCount);
		        System.out.println(" DO\t\t \t:"  + doCount);
		   
		        System.out.println(" characters:  "  + charCount);
		        System.out.println(" words:       "  + wordCount);
		        System.out.println(" uppercase:   "  + uppercaseCount);
		        System.out.println(" lowercase:   "  + lowercaseCount);
		        System.out.println(" WHILE:  "  + consonantCount);
		        System.out.println(" FOR:      "  + vowelCount);
		        System.out.println(" digits:      "  + digitCount);
		        System.out.println(" punctuation: "  + punctuationCount);
		        System.out.println(" whitespace:  "  + whitespaceCount);
	
		        
		        
		        try {
		              Database.setData("insert into codewhite(whitespace,punctuation,words) values('" + whitespaceCount + "','" + lineCount + "','" + charCount +  "') ");
		              
		               //}
		            }catch(Exception e) {
		            	//e.printStackTrace();
		            }
		        
		        
		     }
	        
	        System.out.println("\n========================Complexity due to the Type Of Controll Structure ========================");
	        
	        //Complexity due to Nesting Level And Type Of Control Structure (filePath, complexity due to size, complexity due to inheritance)
	        System.out.println(" Total Complexity due to Nesting level and Control Structure\t:"+cnc.getCPSduetoNestingLevelAndTypeOfControllStructure(INPUTFILE.toString() , 2.0, 1.0));
	    }
	
}
