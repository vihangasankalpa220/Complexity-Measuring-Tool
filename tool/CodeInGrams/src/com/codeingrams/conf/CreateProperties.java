package com.codeingrams.conf;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class CreateProperties {
	
	public void setProperties(){
		File configFile = new File("./config.properties");
        
		try {
		    Properties props = new Properties();
		    props.setProperty("host","localhost");
		    props.setProperty("INPUTFILE","./input/codeBlock.txt");
		    props.setProperty("OUTPUTFILE-Ci","./input/result-Ci.txt");
		    props.setProperty("OUTPUTFILE-Cn","./input/result-Cn.txt");
		    props.setProperty("OUTPUTFILE-Cp","./input/result-Cp.txt");
		    props.setProperty("OUTPUTFILE-Cr","./input/result-Cr.txt");
		    props.setProperty("OUTPUTFILE-Cs","./input/result-Cs.txt");
		    props.setProperty("OUTPUTFILE-Ctc","./input/result-Ctc.txt");
		    props.setProperty("SYSTEM-LOG","./logs/system.error.log");
		    props.setProperty("CONFIG-LOG","./logs/config.error.log");
		    props.setProperty("ANALYZER-LOG","./logs/analyzer.error.log");
		    props.setProperty("DEBUG_MODE","true");
		    props.setProperty("TOKENS_CTC","./tokens/tokens-Ctc.txt");
		    props.setProperty("TOKENS_CS","./tokens/tokens-Cs.txt");
		    props.setProperty("TOKENS_CNC","./tokens/tokens-Cnc.txt");
		    props.setProperty("TOKENS_ALL","./tokens/tokens-all.txt");
		    props.setProperty("TOKENS_CP","./tokens/tokens-Cp.txt");
	        
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, "SYSTEM SETTINGS - CodeInGrams");
		    writer.close();
		    System.out.println("Configuration File Created!");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
}
