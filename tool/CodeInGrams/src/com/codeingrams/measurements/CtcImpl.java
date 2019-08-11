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

	private int count = 0;
    private int score = 0;
    HashMap<String,Integer> tokens;
    private double weight=0;
    private int lineCount =0;
    Pattern TOKEN;
    int weightedValue =0;
    
	//Load configurations
	IConf conf = new ConfImpl("./config.properties");
	//load input file
	String TOCKENFILE = conf.loadConfig("TOKENS_CTC");
			
	public double checkCtcScore( String path){
		tokens = new HashMap<String,Integer>();
		String line = "";
		
		//get tokens
	    try(BufferedReader br = new BufferedReader(new FileReader("./tokens/tockens-Ctc"))) {
	        
	        while ((line = br.readLine()) != null) {
	        	tokens.put(line.split(",")[0],Integer.parseInt(line.split(",")[1]));
	        	count++;
	        }
	        
	    } catch (Exception e) {
	    	System.out.println("Couldn't parse "+ e.getMessage());
		}
	    
		try {
        	//read file using buffer reader as the fastest method
            BufferedReader br2 = new BufferedReader(new FileReader(path));
            /* Display token valus using Iterator*/
  	      	Set set = tokens.entrySet();
  	      	Iterator iterator = set.iterator();
  	      
            while(iterator.hasNext()) {
	   	         Map.Entry mentry = (Map.Entry)iterator.next();
	   	         Pattern TOKEN      = Pattern.compile((String) mentry.getKey());
	   	         int weightedValue = (int) mentry.getValue();
	   	         if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
	   	        	 System.out.println("Check : "+mentry.getKey()+" Weight: "+ mentry.getValue());
	   	         //update counters
	             for (String line2; (line2 = br2.readLine()) != null; ) {
	                 weight   += countTokens(line2, TOKEN)*weightedValue;
	                 if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
	                	 System.out.print(weight);
	             }
   	      	}
            
            //release buffer reader
            if(br2 != null)
            	br2.close();
            
        } catch (Exception e) {
        	//handle exceptions 
            System.out.println("Couldn't parse " + e.getMessage());
            System.exit(-1);
        }
	    
	    return weight;
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
