package com.codeingrams.measurements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.IConf;

public class CtcImpl {

	private int count = 0;
    private int score = 0;
    private String[] tokens;
    private double weight=0;
    private int lineCount =0;
	//Load configurations
	IConf conf = new ConfImpl("./config.properties");
	//load input file
	String TOCKENFILE = conf.loadConfig("TOKENS_CTC");
			
	public double checkCtcScore( String path){ 
		
		//get tokens
	    try(BufferedReader br = new BufferedReader(new FileReader(TOCKENFILE))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	        	tokens = line.split(",");
	        	count++;
	        }
	        
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(tokens);
	    
	    //------------check tokens and count weight
	    Pattern FOR      = Pattern.compile("for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)");
        Pattern WHILE  = Pattern.compile("while\\s*\\([^)]*\\)");
        Pattern DO  = Pattern.compile("do\\s*\\([^)]*\\)");
        Pattern IF  = Pattern.compile("if\\s*\\([^)]*\\)");
        Pattern SWITCH  = Pattern.compile("swich\\s*\\([^)]*\\)");
        Pattern ELSEIF  = Pattern.compile("else\\sif\\s*\\([^)]*\\)");
        Pattern ELSE  = Pattern.compile("else\\s*\\([^)]*\\)");
		try {
        	//read file using buffer reader as the fastest method
            BufferedReader br = new BufferedReader(new FileReader(path));
            //update counters
            for (String line; (line = br.readLine()) != null; ) {
                ++lineCount;
                weight   += countTokens(line, FOR);
                weight   += countTokens(line, FOR);
                weight   += countTokens(line, WHILE);
                weight   += countTokens(line, ELSE);
                weight   += countTokens(line, ELSEIF);
                weight   += countTokens(line, SWITCH);
                weight   += countTokens(line, IF);
                weight   += countTokens(line, DO);
              
            }
            //release buffer reader
            if(br != null)
            	br.close();
            
        } catch (Exception e) {
        	//handle exceptions 
            System.out.println("Couldn't parse " + path + "\n" + e.getMessage());
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
