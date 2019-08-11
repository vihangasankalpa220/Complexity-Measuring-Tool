package com.codeingrams.measurements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.IConf;

public class CtcImpl {

    HashMap<String,Integer> tokens;
    double weight;
    Pattern TOKEN;
    int weightedValue;
    
	//Load configurations
	IConf conf = new ConfImpl("./config.properties");
	//load input file
	String TOCKENFILE = conf.loadConfig("TOKENS_CTC");
	String CODEBLOCK = conf.loadConfig("INPUTFILE");
			
	public double checkCtcScore( String path){
		tokens = new HashMap<String,Integer>();
		String line = "";
		this.weight = 0;
		this.weightedValue=0;
		//handle no  file
        if (path==null) {
            System.out.println("Error: No filename provided");
            System.exit(-1);
        }
        
		//get tokens
	    try(BufferedReader br = new BufferedReader(new FileReader(TOCKENFILE))) {
	        
	    	//gather tokens into the hashMap
	        while ((line = br.readLine()) != null) {
	        	tokens.put(line.split(",")[0],Integer.parseInt(line.split(",")[1]));
	        }
	        
	        //release buffer reader
	        if(br != null)
	        	br.close();
	        
	    } catch (Exception e) {
	    	System.out.println("Couldn't parse "+ e.getMessage());
		}
	    
	  
        
		try {
        	//read file using buffer reader as the fastest method
            BufferedReader br2 = new BufferedReader(new FileReader(CODEBLOCK));
            Pattern TOKEN1      = Pattern.compile("for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)");
            /* Display token values using Iterator*/
  	      	Set set = tokens.entrySet();
  	      	Iterator iterator = set.iterator();
  	      	
            //update counters
            for (String line2; (line2 = br2.readLine()) != null; ) {
            	
            	while(iterator.hasNext()) {
   	   	         Map.Entry mentry = (Map.Entry)iterator.next();
   	   	         Pattern TOKEN      = Pattern.compile(String.valueOf(mentry.getKey()));
   	   	         weightedValue = (int) mentry.getValue();
   	   	         weight   += countTokens(line2, TOKEN)*weightedValue;
   	   	         
   	   	         //debug mode
	   	         if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
	   	        	 System.out.println(" Check : "+TOKEN+" Weight: "+ weightedValue);
      	      	}
            }
            
            if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
           	 System.out.println("\n Complexity due to Type Of Controll Structure: "+weight);
            
            //release buffer reader
            if(br2 != null)
            	br2.close();
            
        } catch (Exception e) {
        	//handle exceptions 
            System.out.println("Couldn't parse " + e.getMessage());
            System.exit(-1);
        }
	    
	    return this.weight;
	}
	
	//count occurrences 
	private int countTokens(String line, Pattern pattern) {
        int count = 0;
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            ++count;
        }
        return count;
	}
	
}
