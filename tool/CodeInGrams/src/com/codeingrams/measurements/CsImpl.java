package com.codeingrams.measurements;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codeingrams.size.ISize;

//Complexity - Size
public class CsImpl implements ISize{

	String line; 
	
	// Initializing counters 
	int countWord = 0; 
	int sentenceCount = 0; 
	int characterCount = 0; 
	int paragraphCount = 1;
	int arithcount=0;
	int manicount=0;
	int rcount=0;
	int keycount=0;
	int bitcount=0;
	int cons=0;
	int total=0;
	int  countNumber = 0;
	String numRegex   = ".*[0-9].*";
	int clcount=0;
	int mcount=0;
	int whitespaceCount  = 0;
	int lineCount        = 0;
	int miscellenouse=0;
	int commaCount = 0;	
	int logicscount=0;

	//count occurrences 
    	private int countOption2(String line, Pattern pattern) {
	        int count = 0;
	        Matcher matcher = pattern.matcher(line);
	        while (matcher.find()) {
	            ++count;
	        }
	        return count;
    	}
    
			@Override
			public void count(String path) throws IOException {
				//regex pattern for white spaces
				Pattern whitespace  = Pattern.compile("\\p{Space}");
				Pattern words       = Pattern.compile("\\w+");
				Pattern logical     = Pattern.compile("(\\&&|\\!)");
				try {
		        	//read file using buffer reader as the fastest method
		            BufferedReader br = new BufferedReader(new FileReader(path));
		            //update counters
		            for (String line; (line = br.readLine()) != null; ) {
		                ++lineCount;
		                whitespaceCount  += countOption2(line, whitespace);
		                countWord  += countOption2(line, words);
		                logicscount +=countOption2(line,logical);
		              
		            }
		            //release buffer reader
		            if(br != null)
	                	br.close();
		            
		        } catch (Exception e) {
		        	//handle exceptions 
		            System.out.println("Couldn't parse " + path + "\n" + e.getMessage());
		            System.exit(-1);
		        }
				
				try {
				File file = new File(path); 
				FileInputStream fileStream = new FileInputStream(file); 
				InputStreamReader input = new InputStreamReader(fileStream); 
				BufferedReader reader = new BufferedReader(input); 
		
				
				// Reading line by line from the 
				// file until a null is returned 
				while((line = reader.readLine()) != null) 
				{ 
			
					if(line.equals("")) 
					{ 
						paragraphCount++; 
					} 
					if(!(line.equals(""))) 
					{ 
						
						characterCount += line.length(); 
						
						// \\s+ is the space delimiter in java 
						//String[] wordList = line.split("\\s"); 
						
						//countWord += wordList.length; 
						//whitespaceCount += countWord -1; 
						
						// [!?.:]+ is the sentence delimiter in java 
						String[] sentenceList = line.split("[!?.:]+"); 
						
						sentenceCount += sentenceList.length; 
						
						if(line.contains("endl") || line.equals("\n"))
						{
							manicount++;
						}
						
						if(line.contains("++") || line.contains("+") || line.contains("-") || line.contains("*")  || line.contains("%") || line.contains("--") || line.equals("/"))
						{
							arithcount++;
						}
					
						if(line.contains("==") || line.contains("!=")|| line.equals(">") ||  line.equals("<")  || line.contains(">=") || line.contains("<="))
						{
							rcount++;
						}
					
					
						if(line.contains("void")|| line.contains("double") || line.contains("int") || line.contains("float") || line.contains("String") || line.contains("printf") || line.contains("println") || line.contains("cout") || line.contains("cin") || line.contains("if") || line.contains("for") || line.contains("while")   || line.contains("switch") || line.contains("case"))
						{
							keycount++;
						}
						
						if(line.contains("|") || line.contains("^") || line.contains("~") || line.contains("<<") || line.contains(">>")  )
							bitcount++;
						}
						 
				
						
						if(line.contains("new") || line.contains("delete") || line.contains("throws"))
								{
							cons++;
								}
						//numbers counts

					    if (line.matches(numRegex)) {
					    	countNumber++;
					    }
					  
					    ///class 
						if(line.contains("public") && line.contains("class") || line.contains("class") && line.contains("extends") || line.contains("class") && line.contains("implements"))
						{
							clcount++;
						}
						
						
						if(line.contains("class") && line.contains(":")){
							
							//For multiple inheritance..
							//Getting the count of commas used to separate the multiple parent classes
							
							if(line.contains(",")) {
								commaCount = line.length() - line.replace(",", "").length();
								clcount = commaCount + 1;
							}
							
							//For single inherited classes
							
							else {
								clcount++;
							
							}
							
							clcount++;
						}
						
					
						//methods
						if(line.contains("public") && line.contains("void") || line.contains("void")  || line.contains("public") && line.contains("int")   || line.contains("public") && line.contains("float")  || line.contains("public") && line.contains("double") || line.contains("public") && line.contains("String"))
						{
							mcount++;
						}
						
						
					if(line.contains("::")) {
						miscellenouse++;
					}
					
					else if(line.contains(":")) {
						//////////////////
						miscellenouse=	miscellenouse;
					}
						
						///miscellenouse
						
						if(line.contains(",") || line.contains("->") || line.contains(".")) {
							miscellenouse++;
						}
						
						//logicaloperators
						if(line.contains("||")) {
							logicscount++;
						}
						
					
						
						
				            total=arithcount*1+rcount*1+bitcount*1+keycount*1+cons*2+countNumber*1+clcount*1+mcount*1+miscellenouse*1+logicscount*1;
				          	      
					
				            
				            
				}
		
				
				
				System.out.println("Total word count = " + countWord); 
				System.out.println("Total line count = " + lineCount); 
				System.out.println("Total number of sentences = " + sentenceCount); 
				System.out.println("Total number of characters = " + characterCount); 
				System.out.println("Number of paragraphs = " + paragraphCount); 
				System.out.println("Total number of whitespaces = " + whitespaceCount); 
				System.out.println("Total number of arithmetical operators = " + arithcount);
				System.out.println("Total number of manipulators = " + manicount);
				System.out.println("Total number of relational operators = " + rcount);
				System.out.println("Total number of Keywords = " + keycount);
				System.out.println("Total number of Bitwise Operators = " + bitcount);
				System.out.println("Total number of Constants = " + cons);
				System.out.println("Total number of Numerical Values = " + countNumber);
				System.out.println("Total number of classes = " + clcount);
				System.out.println("Total number of methods = " + mcount);
				
				System.out.println("Total number of miscellenouse = " + miscellenouse);
				System.out.println("Total logical count = " + logicscount);
				System.out.println("=============================================================================");
				System.out.println("Total Complexity Value (Cs) = " + total);
				System.out.println("=============================================================================");
			}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}	
			} 
			
	
}

