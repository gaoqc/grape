package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import tools.print.TLogger;

public class JDKProxy implements InvocationHandler
{
    private static final  TLogger logger =new TLogger(JDKProxy.class); 
    private Object target = null;

    public Object proxy(Object target)
    {
        this.target =target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        
        logger.info(method.getName()+"   begin");
        logger.info("proxy:::"+method);
      
        Object obj=method.invoke(target, args);
        logger.info(method.getName()+"   end");
        return obj;
    }
    public static void main(String[] args)
    {
//        Hello hello =new Hello();
        JDKProxy proxy=new JDKProxy();
        
//        hello = (Hello) proxy.proxy(hello);
//        logger.info(hello.hello());
      
        IWhat what=new WhatImpl();
        what=(IWhat)proxy.proxy(what);
        what.sayWhat("ok,okok");
        
        
        
    }

}
