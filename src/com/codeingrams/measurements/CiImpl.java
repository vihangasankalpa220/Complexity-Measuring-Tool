package com.codeingrams.measurements;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

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

	@Override
	public void count(String path) throws IOException {
		
		File file = new File(path); 
		FileInputStream fileStream = new FileInputStream(file); 
		InputStreamReader input = new InputStreamReader(fileStream); 
		BufferedReader reader = new BufferedReader(input);
		
		//Reading line by line from the file until a null is returned
		
				while((line = reader.readLine()) != null) 
				{ 
						//Calculating number of ancestor class count in java code
						
						if(line.contains("class") && line.contains("extends")){
							ancestorClassCount++;
							childClassCount++;
						}
						
						//Calculating number of ancestor class count in C++ code
						
						if(line.contains("class") && line.contains(":")){
							
							//For multiple inheritance..
							//Getting the count of commas used to separate the multiple parent classes
							
							if(line.contains(",")) {
								commaCount = line.length() - line.replace(",", "").length();
								ancestorClassCount = commaCount + 1;
							}
							
							//For single inherited classes
							
							else {
								ancestorClassCount++;
							}
							
							childClassCount++;
						}
					
				}
				
		//Calculating Complexity of a class due to its inheritance
		CCi = ancestorClassCount + 1;
				
		//Calculating Complexity of a program statement of a class due to inheritance 
		Ci = CCi;
				
		//Output the values
		System.out.println("Total number of ancestor classes = " + ancestorClassCount); 
		System.out.println("Total number of child classes = " + childClassCount);
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Complexity of a class due to its inheritance (CCi) = " + CCi); 
		System.out.println("Complexity of a program statement of a class due to inheritance (Ci) = " + Ci);
		System.out.println("-----------------------------------------------------------------------------");
		
	}

}
