/*
 * Configuration access code
 */
package com.codeingrams.conf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfImpl implements IConf {
	private File configFile;
	private String confPath;
	private String confValue;
	
	//constructor
	public ConfImpl(String confPath){
		this.confPath = confPath;
	}
	
	//load configuration from properties
	@Override
	public String loadConfig(String confName) {
		try {
			configFile = new File(confPath);
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    reader.close();
		    confValue = props.getProperty(confName);
		} catch (FileNotFoundException ex) {
		    // file does not exist
			System.out.println("Configuration file does not exist");
			confValue = null;
		} catch (IOException ex1) {
		    // I/O error
			System.out.println("I/O exception occured. "+ex1);
			confValue = null;
		}
		return confValue;
	}
}
