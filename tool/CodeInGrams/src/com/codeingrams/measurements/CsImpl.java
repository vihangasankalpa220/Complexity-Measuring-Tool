/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.measurements;

import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.CreateProperties;
import com.codeingrams.conf.IConf;
import com.codeingrams.inheritance.Iinheritance;
import java.awt.image.VolatileImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.codeingrams.size.ISize;

/**
 *
 * @author vihanga
 */
public class CsImpl implements ISize  {
	private javax.swing.JTable jTable1;
    String fileLocation;
    String words;
    String line = null;
     int line_count = 1; 
    List<String> arr = new ArrayList<>();
    int complexity = 0;
    int totalcomplexity = 0;

    String[] arithmetic = {"+", "-", "*", "/", "%", "++", "--"};
    String[] relation = {"==", "!=", ">", "<", ">=", "<="};
    String[] logical = {"&&", "||", "!"};
    String[] bitwise = {"|", "^", "~", "<<", ">>", ">>>", "<<<"};
    String[] misc = {",", "->", ".", "::"};
    String[] assignment = {"+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^="};
    String[] keywords = {"void", "double", "int", "float", "String",
        "printf", "println", "cout", "cin", "if", "for", "while", "do while", "switch", "case", "long"};
    String[] manipulators = {"endl", "\n"};
    String[] syskey = {"System.out.println"};
    String[] invalidStringVariables = {"public", "static", "else", "try", "return", "private", "class"};
    String[] constValueTwoVariables = {"&", "throw", "throws", "new", "delete"};
    String numRegex   = ".*[0-9].*";
    int commaCount = 0;
    String doubleqoute="\"([^\"]*)\"";
   String white= "\\p{Space}";
   int varibles=0;
   //create properties file 
		CreateProperties c = new CreateProperties();
		//c.setProperties();
		
		//Load configurations
		IConf conf = new ConfImpl("./config.properties");
   //load input file
		String INPUTFILE = conf.loadConfig("INPUTFILE");
   
    public void MeasureSize() throws IOException {
Iinheritance cInheritance = new CiImpl();
int CCi=cInheritance.count(INPUTFILE.toString());
        try {

          //  Pattern pattern = Pattern.compile("\"([^\"]*)\"");

            fileLocation = "./input/codeBlock.txt";

            FileReader filereader = new FileReader(fileLocation);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            line = bufferedreader.readLine();
          // Matcher m = pattern.matcher(line);

            while (line != null) {
                complexity = 0;

//                if (m.find()) {
//                    complexity++; //complexity of text inside a pair of double quotes
//                }
                // --------------
                line = line.replaceAll("\\{", " ");
                line = line.replaceAll("\\}", " ");
                line = line.replaceAll("\\(", " ");
                line = line.replaceAll("\\)", " ");
                line = line.replaceAll(";", " ");
                line = line.replaceAll("\"", " ");
                line = line.replaceAll("\\[", " ");
                line = line.replaceAll("\\]", " ");

//                if (line.contains("class")) {
//                    break;
//                }
//                
                StringTokenizer stringToken = new StringTokenizer(line);

                while (stringToken.hasMoreTokens()) {
                    words = stringToken.nextToken();
                    
                    if(words.startsWith("/*") || words.startsWith("*")){
                        break;
                    }
                    
                    
                    if(line.startsWith("System") && line.contains("+")) {
                   	 arr.add(words);
                     complexity++;
                       } 
                   
                    
                    if(line.startsWith("\\")) {
                      	 break;
                       }
                    
                    
                  
                    	
                    	
                    //import statements
                    if(line.startsWith("import")) {
                   	 break;
                    }
                    
                    
                    //comments
                  if(line.contains("//")) {
                    //	break;
                    }
                    
                    //white space
                    if(line.matches(white)) {
                    	arr.remove(words);
                    	complexity=complexity;
                    }
                    
                    
                    //Arrays
                    if(line.contains("[]")) {
                   	 arr.add(words);
                     complexity++;
					}
                  	
                    
                    //const c++ 
                    if(line.contains("#") || line.contains("using") || line.contains("namespace")) {
                   	break;
					}
                    
                    
                   //Numerical value 
                 
                    if (words.matches(numRegex)) {
                    	 arr.add(words);
                    	  complexity++;
				    }
                    
                    
                    
                    //Double Qoutations
                    if (words.matches(doubleqoute)) {
                    	 arr.add(words);
                         complexity++;
				    }
                    
                             
                    
                    // Arithmetic operators
                    for (int i = 0; i < arithmetic.length; i++) {
                        if (arithmetic[i].equals("//")) {
                            break;
                        } else {
                            if (arithmetic[i].equals(words)) {
                                arr.add(words);
                                complexity++;
                            }
                        }
                    }

                    // Relation operators
                    for (int i = 0; i < relation.length; i++) {
                        if (relation[i].equals("//")) {
                            break;
                        } else {
                            if (relation[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // logical operators
                    for (int i = 0; i < logical.length; i++) {
                        if (logical[i].equals("//")) {
                            break;
                        } else {
                            if (logical[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // bitwise operators
                    for (int i = 0; i < bitwise.length; i++) {
                        if (bitwise[i].equals("//")) {
                            break;
                        } else {
                            if (bitwise[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // misc operators
                    for (int i = 0; i < misc.length; i++) {
                        if (misc[i].equals("//")) {
                            break;
                        } else {
                            if (misc[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // assignment operators
                    for (int i = 0; i < assignment.length; i++) {
                        if (assignment[i].equals("//")) {
                            break;
                        } else {
                            if (assignment[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // keywords operators
                    for (int i = 0; i < keywords.length; i++) {
                        if (keywords[i].equals("//")) {
                            break;
                        } else {
                            if (keywords[i].equals(words)) {
                                arr.add(words);
                                complexity++;
                            }
                        }
                        
                    }

                    // manipulators operators
                    for (int i = 0; i < manipulators.length; i++) {
                        if (manipulators[i].equals("//")) {
                            break;
                        } else {
                            if (manipulators[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // invalidStringVariables operators
                    for (int i = 0; i < invalidStringVariables.length; i++) {
                        if (invalidStringVariables[i].equals("//")) {
                            break;
                        } else {
                            if (invalidStringVariables[i].equals(words)) {
                                arr.add(words);
                                complexity = 0;
                            }
                        }
                    }
                    
                   //System class
                    if(line.contains("System.out.println")) {
                        for (int k = 0; k < syskey.length; k++) {
                            if (syskey[k].equals("//")) {
                                break;
                            } else {
                                if (syskey[k].equals(words)) {
                                    arr.add(words);
                                    complexity = complexity + 5;
                                }
                                
                                if (syskey[k].matches(doubleqoute)) {
                               	 arr.add(words);
                                    complexity++;
           				    }
                               
                                
                            }
                        }
                    }
                    
                    
                    
            	
                    

                    // constValueTwoVariables operators
                    for (int i = 0; i < constValueTwoVariables.length; i++) {
                        if (constValueTwoVariables[i].equals("//")) {
                            break;
                        } else {
                            if (constValueTwoVariables[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 2;
                            }
                        }
                    }
				
                    
                    if (!arr.contains(words)) {
                        if (words.equals("//")) {
                           break;
                        } else {
                        // System.out.println(words);
                            complexity = complexity + 1;
                        }
                    }
                    
                if(line.contains("public") && line.contains("class"))    
                {
                	break;
                }
                    
               
                	
				if(line.contains("1") || line.contains("2") || line.contains("3") || line.contains("4") || line.contains("5") || line.contains("6") || line.contains("7") || line.contains("8") || line.contains("9") || line.contains("0"))	
				{
					complexity++;
				}
			
			//	if(line.contains(",")) {
				//	complexity = line.length() - line.replace(",", "").length();
					//	complexity = complexity + 1;
				//	}
                    
                	}
                
                	
        
                totalcomplexity = totalcomplexity + complexity;
                System.out.format("||line number  \t " + line_count+"||");
               System.out.format(" line content : \t"+line+"||");
            //    System.out.format("\t \t \t \t \t \t \t \t \t \t \t \t\t \t \t found \t"+words);
                System.out.format("line complexity  \t"+complexity+"||");
                System.out.println(""); 
               System.out.println("===================================================================================================================================================================");
            try {
              Database.setData("insert into codesize(lineNo,Line,Complexity,InheritanceComplexity) values('" + line_count + "','" + line + "','" + complexity +  "','"+CCi+"') ");
              
               //}
            }catch(Exception e) {
            	//e.printStackTrace();
            }
               line = bufferedreader.readLine();
                line_count++;
             
       
                
            
                //-----------------
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total Size Complexity is: " + totalcomplexity);
        try{
     Database.setData("insert into codecom(total) values('"+totalcomplexity+"') ");
        }catch(Exception e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Successfully Added CodeInGrams Code For the Database");
    }

}
