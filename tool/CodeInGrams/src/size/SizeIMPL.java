package size;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SizeIMPL  implements ISize {

	
	String line; 
	
	// Initializing counters 
	int countWord = 0; 
	int sentenceCount = 0; 
	int characterCount = 0; 
	int paragraphCount = 1; 
	int whitespaceCount = 0; 
	int arithcount=0;
	int manicount=0;
	int rcount=0;
	int keycount=0;
	int bitcount=0;
	
	



			@Override
			public void count(String path) throws IOException {
				
				File file = new File("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\input\\codeBlock.txt"); 
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
						String[] wordList = line.split("\\s+"); 
						
						countWord += wordList.length; 
						whitespaceCount += countWord -1; 
						
						// [!?.:]+ is the sentence delimiter in java 
						String[] sentenceList = line.split("[!?.:]+"); 
						
						sentenceCount += sentenceList.length; 
						
						if(line.contains("endl") || line.contains("etc.") || line.equals("\n"))
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
					
					
					if(line.contains("void")|| line.contains("double") || line.contains("int") || line.contains("float") || line.contains("String") || line.contains("printf") || line.contains("println") || line.contains("cout") || line.contains("cin") || line.contains("if") || line.contains("for") || line.contains("while") || line.contains("do-while") || line.contains("switch") || line.contains("case"))
					{
						keycount++;
					}
					
					if(line.contains("|") || line.contains("^") || line.contains("~") || line.contains("<<") || line.contains(">>")  )
						bitcount++;
					} 
				}
				System.out.println("Total word count = " + countWord); 
				System.out.println("Total number of sentences = " + sentenceCount); 
				System.out.println("Total number of characters = " + characterCount); 
				System.out.println("Number of paragraphs = " + paragraphCount); 
				System.out.println("Total number of whitespaces = " + whitespaceCount); 
				System.out.println("Total number of arithmetical operators = " + arithcount);
				System.out.println("Total number of manipulators = " + manicount);
				System.out.println("Total number of relational operators = " + rcount);
				System.out.println("Total number of Keywords = " + keycount);
				System.out.println("Total number of Bitwise Operators = " + bitcount);
				
			} 
			
		
	
	
	
}
	
