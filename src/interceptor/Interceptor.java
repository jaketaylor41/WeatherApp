package interceptor;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import models.LoggerService;


public class Interceptor implements Serializable
{
	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception
	{
	
		System.out.println("IN THE INTERCEPTOR CLASS");
		LoggerService log = LoggerService.createLogger();
		log.INFO("Entering method: " + context.getMethod().getName());
		Object result = context.proceed();
		log.INFO("Exiting method: " + context.getMethod().getName());
		return result;
		
	}
}