package bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import tools.pattern.PatternUtil;
import tools.seq.SequenceUtils;
import tools.time.TimeUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
/**
 * 小票打印机
 * @author gaoqc5
 *
 */
public class TicketPrinter implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static Random random = new Random(60);


    public static void main(String[] args) throws IOException
    {
         

        //打印的模板
        String template =Files.toString(new File("d:/test/template.txt"), Charset.defaultCharset());
        Map<String,String> map=Maps.newHashMap();
        
        //日期天数
        for (String line : Files.readLines(new File("d:/test/bx.txt"), Charset.defaultCharset()))
        {
            
            if(Strings.isNullOrEmpty(line)){
                continue;
            }
            map.put("date", line.split("\\s")[6]);
            map.put("time", getTime());
            map.put("no", getNo());
            map.put("table", getTable());
            map.put("price", getPrice());
            System.out.println(toInstance(map, template));
            System.out.println("");
            System.out.println("");

        }

    }
    private static String toInstance(Map<String,String> map,String template){
        
        return PatternUtil.replace(template, map);
        
        
    }
    @Profiled(tag = "main")
    private static String getTime(){
         String time=SequenceUtils.getSeqInRange(20,18);
        int minute=random.nextInt(60);
        int second=random.nextInt(60);
        if(minute<10){
            time+=":0"+minute;
        }else{
            time+=":"+minute; 
        }
        if(second<10){
            time+=":0"+second;
        }else{
            time+=":"+second;
        }
        TimeUtil.sleepSecods(1);
        return time;
    }
    private static String getPrice(){
        return "30";//SequenceUtils.getSeqInRange(50, 30);
    }
    
    private  static String getNo(){
        return SequenceUtils.getSeq("0", 4);
    }
   private static String getTable(){
       return SequenceUtils.getSeq("0", 3);
   }
    

}
