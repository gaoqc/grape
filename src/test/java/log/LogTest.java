package log;

import java.util.concurrent.ExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tools.print.TLogger;
import bean.Address;
import bean.Person;

public class LogTest
{
    private static TLogger logger =new TLogger(LogTest.class);
    public static void main(String[] args) throws ExecutionException
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Address address =(Address) context.getBean("address");
        if(null!=address){
            logger.info(address);
            
        }else{
           logger.info("address is null");
           
        }
      Person gao=(Person)context.getBean("gaoqc");
      if(null!=gao){
          logger.info(gao);
          logger.info("test"+gao.getName());
      }else{
          logger.info("gao if null");
      }
          
        
    }
 

}
