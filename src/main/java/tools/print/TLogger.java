/**
 *
 */
package tools.print;

import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bean.Children;
import bean.Person;
import tools.string.StringUtil;
import tools.time.TimeUtil;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;
import static java.lang.System.out;

/**
 * @Description:
 * @Company: Asiainfo-Linkage Technologies(China),Inc. Hangzhou
 * @Author gaoqc5
 * @Date 2013-10-31
 */
public class TLogger
{
    private String prefix = "====>";
    // private String suffix="<";
    private Logger logger;

    public TLogger(Class<?> clz, String prefix)
    {
        logger = org.slf4j.LoggerFactory.getLogger(clz);
        this.prefix = prefix;
    }

    public TLogger(Class<?> clz)
    {
        logger = org.slf4j.LoggerFactory.getLogger(clz);
    }

    /**
     * 打印debug级别日志
     * 
     * @param msgArr:多个日志信息
     */
    public void debug(long start, Object... msgArr)
    {

        logger.debug(concat(prefix, concat(msgArr), buildCostTime(start)));

    }

    public void debug(Object... msgArr)
    {

        logger.debug(concat(prefix, concat(msgArr)));

    }

    /**
     * 多个参数组成字符串
     */
    private static String concat(Object... args)
    {
        return StringUtil.concat(args);
    }

    private String buildCostTime(long start)
    {
        StringBuffer sb = new StringBuffer(" ,cost time[ms]:");
        sb.append(System.currentTimeMillis() - start);
        return sb.toString();
    }

    // public void info(long start, Object... msgArr)
    // {
    //
    // logger.info(concat(prefix, concat(msgArr),buildCostTime(start)));
    //
    // }
    /**
     * 打印info级别日志
     */
    public void info(Object... msgArr)
    {
        if (msgArr.length == 0)
        {
            return;
        }
        if (msgArr[0] instanceof Long)
        {

            logger.info(concat(prefix, concat(msgArr), buildCostTime(Long.valueOf(msgArr[0].toString()))));
        }
        else
        {
            logger.info(concat(prefix, concat(msgArr)));
        }
    }

    public void trace(long start, Object... msgArr)
    {

        logger.trace(concat(msgArr) + buildCostTime(start));
    }

    public void trace(Object... msgArr)
    {
        logger.trace(concat(msgArr));
    }

    public void warn(Object... msgArr)
    {
        logger.warn(concat(msgArr));
    }

    public void warn(long start, Object... msgArr)
    {
        logger.warn(concat(msgArr) + buildCostTime(start));
    }

    /**
     * 打印error级别日志
     */
    public void error(Object... msgArr)
    {
        logger.error(concat(prefix, msgArr));
    }

    public static void main(String[] args)
    {
        p(Person.class.isAssignableFrom(Children.class));
       p(String.class.isAssignableFrom(Person.class));
     
    }
    private static void p(Object obj){
        out.println(obj);
    }

    private void get()
    {
        URL url = Loader.getClassLoaderOfObject(this).getResource("logbak.xml");
        System.out.println(url.toString());
    }

}
