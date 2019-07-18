/*
 * Configuration access interface
 */
package com.codeingrams.conf;

public interface IConf {
	
	//load configuration from conf.properties. Input: conf file apth , conf name
	String loadConfig(String confName);
	
}
