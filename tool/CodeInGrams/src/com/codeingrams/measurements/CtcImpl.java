package com.codeingrams.measurements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.IConf;

public class CtcImpl {

	private int count = 0;
    private int score = 0;
    
	//Load configurations
	IConf conf = new ConfImpl("./config.properties");
	//load input file
	String TOCKENFILE = conf.loadConfig("TOKENS_CTC");
			
	public int checkCtcScore(){ 
	    
	    List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(TOCKENFILE))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	            content.get(count);
	            count++;
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return count;
	}
	
}
