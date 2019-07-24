/*
 * System logger implementation
 */
package com.codeingrams.logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.IConf;

public class LoggerImpl implements ILogger{
	
	private IConf conf ;
	private FileWriter fw;
	private String filename;
	
	//logger constructor
	public LoggerImpl(String loggerMode){
		//load properties
		conf = new ConfImpl("./config.properties");
		
		try
		{
		    switch((loggerMode).toUpperCase()) {
				case "ANALYZER" :
					filename= conf.loadConfig("ANALYZER-LOG");
				    fw = new FileWriter(filename,true);
			        if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
			        	System.out.println("analyzerLogger started");
					break;
				case "CONFIG" :
					filename= conf.loadConfig("CONFIG-LOG");
				    fw = new FileWriter(filename,true);
			        if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
			        	System.out.println("configLogger started");
					break;
				case "SYSTEM" :
					filename= conf.loadConfig("SYSTEM-LOG");
				    fw = new FileWriter(filename,true);
			        if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
			        	System.out.println("systemLogger started");
					break;
				default:
					filename= conf.loadConfig("SYSTEM-LOG");
				    fw = new FileWriter(filename,true);
			        if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
			        	System.out.println("systemLogger started");
		    }
		    
		}
		catch(IOException ioe) {
			if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
				System.err.println("IOException: " + ioe.getMessage());
		}
		 catch (Exception e) {
				System.out.println("LoggerImpl->log: Exception "+e);
			}
	}
	
	//logger method
	public void log(String string) {
	    try { 
	    	//if writer fails
	    	if(fw==null) {
	    		filename= conf.loadConfig("SYSTEM-LOG").toString();
		    	fw = new FileWriter(filename,true);
		    	if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
		        	System.out.println("Default logger started");
	    	}
	    	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	    	Date date = new Date(System.currentTimeMillis());
	    	fw.write(formatter.format(date)+" : "+string+"\n");
	    	fw.close();
	    } catch (SecurityException e) {  
	    	System.out.println("Log->log: Security Exception"+e);
	    } catch (FileNotFoundException e) { 
	    	System.out.println("LoggerImpl->log file not found: "+e);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Log->log: Unsupported Encoding "+e);
		} catch (IOException e) {
			System.out.println("Log->log: I/O Exception "+e);
		}
	    catch (Exception e) {
			System.out.println("Log->log: Exception "+e);
		}
	    if(conf.loadConfig("DEBUG_MODE").equalsIgnoreCase("true"))
        	System.out.println("Logger stoped");
	}
}
