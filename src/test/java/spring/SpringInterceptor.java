package spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import tools.print.TLogger;

public class SpringInterceptor implements MethodInterceptor
{
    private static TLogger logger =new TLogger(SpringInterceptor.class);

    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        logger.info(invocation.getMethod().getName()+"    begin");
      
        Object obj= invocation.proceed();
        logger.info(invocation.getMethod().getName()+"   end");
        return  obj;
    }

}
