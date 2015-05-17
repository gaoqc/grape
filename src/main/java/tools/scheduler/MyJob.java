package tools.scheduler;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import tools.date.DateUtil;
import tools.time.TimeUtil;


public class MyJob implements Job
{
   

 
 

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
   
//      JobDataMap jobDataMap= context.getMergedJobDataMap();
      System.out.println(DateUtil.toString(DateUtil.nowDate(), DateUtil.DATE_FORMAT_EN_B_YYYYMMDDHHMMSS)+"hello world!");
        
        
    }

}
