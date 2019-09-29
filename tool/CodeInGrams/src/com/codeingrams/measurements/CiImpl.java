package com.codeingrams.measurements;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.codeingrams.inheritance.Iinheritance;

import java.io.FileInputStream;



import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.codeingrams.inheritance.Iinheritance;

import java.io.FileInputStream;



public class CiImpl implements Iinheritance {
	
	String line;
	
	//Initializing counters 
	
	int ancestorClassCount = 0; //Counter for ancestor classes
	int childClassCount = 0; 	//Counter for child classes
	int commaCount = 0;			//Counter for identifying multiple inheritance in C++ code 
	
	int CCi;	//Complexity of a class due to its inheritance 
	int Ci; 	//Complexity of a program statement of a class due to inheritance
	
	int defComplexity = 2; //complexity for object class in java
	int totalInheritComplexity = 0; //total Complexity
	
	String whiteSpace= "\\p{Space}";
	
	String[] invalidStringVariables = {"class", "else"};

	@Override
	public int count(String path) throws IOException {
		
		File file = new File(path); 
		FileInputStream fileStream = new FileInputStream(file); 
		InputStreamReader input = new InputStreamReader(fileStream); 
		BufferedReader reader = new BufferedReader(input);
		
		//Reading line by line from the file until a null is returned
		
				while((line = reader.readLine()) != null) 
				{		
						//Calculating number of ancestor class count in java code
						if(line.contains("class") && !(line.contains("extends"))){
						
							CCi = defComplexity;
						
						}
						
						//Calculating number of ancestor class count in java code
						if(line.contains("class") && line.contains("extends")){
							
							ancestorClassCount++;
							childClassCount++;
							
							//Calculating Complexity of a class due to its inheritance
							CCi = (ancestorClassCount * defComplexity) + 1;
									
							//Calculating Complexity of a program statement of a class due to inheritance 
							Ci = CCi;
							
							
						}
						
						//Multiple inheritance in java interfaces
						if(line.contains("class") && line.contains("implements")){
							
							if(line.contains(",")) {
								commaCount = line.length() - line.replace(",", "").length();
								ancestorClassCount = commaCount + 1;
								
								CCi = ancestorClassCount + 1;
							}
						}
						
						
						
						//Calculating number of ancestor class count in C++ code
						if(line.contains("class") && line.contains(":")){
							
							//For multiple inheritance..
							//Getting the count of commas used to separate the multiple parent classes
							
							if(line.contains(",")) {
								commaCount = line.length() - line.replace(",", "").length();
								ancestorClassCount = commaCount + 1;
								
								CCi = ancestorClassCount + 1;
							}
							
							//For single inherited classes
							
							else {
								ancestorClassCount++;
							}
							
							childClassCount++;
						}
						
						totalInheritComplexity = totalInheritComplexity + CCi;
						
						System.out.format("||line content : \t"+line+"||");
			            System.out.format("line complexity  \t"+CCi+"||");
			            System.out.println(""); 
			            System.out.println("===================================================================================================================================================================");
			            try{
			            Database.setData("insert into codeinherite(lineNo,InheritanceComplexity) values('" + line + "','" + CCi +  "') ");
                                //      Database.setData(" UPDATE codesize SET codesize.InheritanceComplexity=(SELECT codeinherite.InheritanceComplexity  FROM codeinherite WHERE  codeinherite.lineNo=codesize.lineNo); ");
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
				}
		
				System.out.println("Total Complexity Due to inheritance = " + totalInheritComplexity);
				System.out.println("===================================================================================================================================================================");
	return 	CCi;
	}

}
