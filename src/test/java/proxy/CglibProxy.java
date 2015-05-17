package proxy;

import java.lang.reflect.Method;
import tools.print.TLogger;
import twaver.base.A.E.m;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor
{
    private static final  TLogger logger =new TLogger(CglibProxy.class); 
    private Object target;
    public  Object  getInstance(Object target){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        this.target=target;
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
    {
        logger.info(method.getName()+"   begin   ");
        logger.info("obj  "+obj.getClass().getName());
        logger.info("method "+method);
        logger.info("proxy  "+proxy);
       
       Object returnObj= method.invoke(target, args);//proxy.invokeSuper(obj, args);
        logger.info(method.getName()+"   end");
        return returnObj;
    }
    public static void main(String[] args)
    {
//      Hello hello =new Hello();
        CglibProxy proxy =new CglibProxy();
//        hello = (Hello) proxy.proxy(hello);
//        logger.info(hello.hello());
      
        WhatImpl what=new WhatImpl();
        what=(WhatImpl)proxy.getInstance(what);
        what.sayWhat("ok,okok");
    }

}
