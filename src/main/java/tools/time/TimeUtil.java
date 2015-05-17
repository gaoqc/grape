package tools.time;

import java.io.FileNotFoundException;

public class TimeUtil
{
    public static void sleepSecods(int senconds){
        sleepMilliSeconds(senconds*1000);
    }
    
    public static void sleepMilliSeconds(int milliSenConds){
        try
        {
            Thread.sleep(milliSenConds);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void  a() throws FileNotFoundException,IllegalArgumentException{
        System.out.println("a");
    }
    

}
