package tools.scheduler;

import java.util.Date;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import bean.Person;

public class SchedulerTest
{
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws SchedulerException
    {
        SchedulerFactory sf=new StdSchedulerFactory();
        Scheduler scheduler =sf.getScheduler();
        
        JobDetail  jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("111", "222")
                .usingJobData(getMap()).build();
        Trigger  trigger =TriggerBuilder.newTrigger().startAt(new Date())
//                .forJob(jobDetail.getKey())
                 .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
         
        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
//        scheduler.shutdown(true);
    }
    private static JobDataMap getMap(){
        JobDataMap jobDataMap=new JobDataMap(System.getenv());
        jobDataMap.put("name", "gaoqc");
        jobDataMap.put("p", new Person("gaoqc", 29));
 
        return jobDataMap;
    }

}
