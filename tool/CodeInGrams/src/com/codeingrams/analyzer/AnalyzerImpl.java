/*
 * Analyzer Implementation
 */
package com.codeingrams.analyzer;
import java.io.*;
import java.util.regex.*;

public class AnalyzerImpl implements IAnalyzer{
		
		///variables
	  	int vowelCount       = 0;
	  	int consonantCount   = 0;
	    int punctuationCount = 0;
	    int whitespaceCount  = 0;
	    int digitCount       = 0;
	    int uppercaseCount   = 0;
	    int lowercaseCount   = 0;
	    int wordCount        = 0;
	    int charCount        = 0;
	    int lineCount        = 0;
      
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
/*
	        Pattern FOR      = Pattern.compile("[aeiouAEIOU]");
	        Pattern WHILE  = Pattern.compile("[bcdfghjklmnpqrstuvwxyzBCDFGHJKLMNOPQRSTUVWXYZ]");
	        Pattern punctuation = Pattern.compile("\\p{Punct}");
	        Pattern whitespace  = Pattern.compile("\\p{Space}");
	        Pattern digits      = Pattern.compile("\\p{Digit}");
	        Pattern uppercase   = Pattern.compile("\\p{Upper}");
	        Pattern lowercase   = Pattern.compile("\\p{Lower}");
	        Pattern words       = Pattern.compile("\\w+");
	        Pattern characters  = Pattern.compile(".");
*/
	        Pattern FOR      = Pattern.compile("for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)");
	        Pattern WHILE  = Pattern.compile("while\\s*\\([^)]*\\)");
	        Pattern punctuation = Pattern.compile(".*&&.*");
	        Pattern whitespace  = Pattern.compile(".*||.*");
	        Pattern digits      = Pattern.compile(".*&.*");
	        Pattern uppercase   = Pattern.compile(".*|.*");
	        Pattern lowercase   = Pattern.compile(".*for.*");
	        Pattern words       = Pattern.compile(".*for.*");
	        Pattern characters  = Pattern.compile(".*for.*");
	        
	        
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
	                vowelCount       += count(line, FOR);
	                consonantCount   += count(line, WHILE);
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
	        
	        //output
	        System.out.println(" Analysis of file: " + path);
	        System.out.println(" #Lines:      "  + lineCount);
	        System.out.println(" characters:  "  + charCount);
	        System.out.println(" words:       "  + wordCount);
	        System.out.println(" uppercase:   "  + uppercaseCount);
	        System.out.println(" lowercase:   "  + lowercaseCount);
	        System.out.println(" WHILE:  "  + consonantCount);
	        System.out.println(" FOR:      "  + vowelCount);
	        System.out.println(" digits:      "  + digitCount);
	        System.out.println(" punctuation: "  + punctuationCount);
	        System.out.println(" whitespace:  "  + whitespaceCount);
	    }
	
}
