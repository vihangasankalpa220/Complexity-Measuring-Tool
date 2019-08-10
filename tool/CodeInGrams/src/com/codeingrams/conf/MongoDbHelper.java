package com.codeingrams.conf;


public class MongoDbHelper {
	private String mongoURL;
	IConf conf;
	
	public MongoDbHelper(){
		//Load configurations
		conf = new ConfImpl("./config.properties");
			
		//load input file
		this.mongoURL=conf.loadConfig("MONGO-URL");
	}
	
    public void connect() {
    	
    }
    
    
}
