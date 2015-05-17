package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tools.time.TimeUtil;

public class SpringTest
{
    public static void main(String[] args) throws InterruptedException
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Address address = (Address) context.getBean("address");
        System.out.println(address);
         while(true){
             TimeUtil.sleepMilliSeconds(1);
         }

    }

}
