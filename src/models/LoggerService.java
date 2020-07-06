package models;

import java.util.logging.Level;
import java.util.logging.Logger;


import interceptor.Interceptor;

public class LoggerService 
{
	private static Logger log = Logger.getLogger(Interceptor.class.getName());
	private static LoggerService logger;
	private LoggerService()
	{
		
	}
	public static LoggerService createLogger()
	{
		if(logger == null)
		{
			logger = new LoggerService();
		}
		return logger;
	}
	public void INFO(String msg)
	{
		log.log(Level.INFO, msg);
		System.out.println("TESTING");
		//log.info(msg);
	}
	
}