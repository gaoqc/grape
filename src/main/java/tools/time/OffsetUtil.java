package  tools.time;

import java.util.Calendar;
import java.util.Date;
import tools.date.DateUtil;

/**
 * 专门用于处理日期偏移量的工具类
 * 偏移量的周期类型主要分自然周期（比如自然天，自然周，自然月等）和动态周期(比如动态天，动态周等)
 * 自然周期是指从指定周期的初始时间开始算起，动态周期则是直接偏移指定的周期量.
 * 比如当前是2012-01-05 06:01:01
 * 偏移2个自然天，则是2012-01-07 00:00:00;偏移2个动态天，则是2012-01-07 06:01:01
 * 偏移2个自然月，则是2012-03-01 00:00:00;偏移2个动态月，则是2012-03-05 06:01:01
 * 偏移2个自然年，则是2014-01-01 00:00:00;偏移2个动态年，则是2014-01-05 06:01:01
 * @Company: Asiainfo-Linkage Technologies(China),Inc. Hangzhou
 * @Author wuyj
 * @Date 2012-6-15
 */
public class OffsetUtil {
     /**
     * 偏移秒
     * 秒偏移N
     * 比如当前是2012-01-05 06:01:01,移2秒，则是2012-01-05 06:01:03
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetSecond(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, amount);
        return calendar.getTime();

    }
    /**
     * 偏移小时
     * 小时偏移N
     * 比如当前是2012-01-05 06:01:01,移2个小时，则是2012-01-05 06:03:01
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetHour(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, amount);
        return calendar.getTime();

    }
    
    /**
     * 偏移动态天
     * 日期直接偏移N天
     * 比如当前是2012-01-05 06:01:01,移2个动态天，则是2012-01-07 06:01:01
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetDay(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        return calendar.getTime();
    }
    
    /**
     * 偏移自然天
     * 日期直接偏移N天，并且把时间设置为0
     * 比如当前是2012-01-05 06:01:01,偏移2个自然天，则是2012-01-07 00:00:00
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetNtrlDay(Date date, int amount){
        date = offsetDay(date,amount);
        return DateUtil.dayBegin(date);//把时间都置为00:00:00
    }
    
    /**
     * 偏移动态周
     * 周直接偏移N周
     * 比如当前是2012-01-05 06:01:01(周四),偏移2个动态周(即下下周)，则是2012-01-19 06:01:01(周四)
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetWeek(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, amount);
        return calendar.getTime();
    }
    
    /**
     * 偏移自然周，适用于第一天是星期日的场景
     * 直接偏移N周，并且把星期置为第一天（星期日）,时间设置为0
     * 比如当前是2012-01-05 06:01:01(周四),偏移2个自然周(即下下周)，则是2012-01-16 00:00:00(周日)
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetNtrlWeekOfSun(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, amount);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return DateUtil.dayBegin(calendar.getTime());//把时间都置为00:00:00
    }
    /**
     * 偏移自然周，适用于第一天是星期一的场景
     * 直接偏移N周，并且把星期置为第一天（星期一）,时间设置为0
     * 比如当前是2012-01-05 06:01:01(周四),偏移2个自然周(即下下周)，则是2012-01-17 00:00:00(周一)
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetNtrlWeekOfMon(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, amount);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return DateUtil.dayBegin(calendar.getTime());//把时间都置为00:00:00
    }
    
    
    /**
     * 偏移动态月
     * 月份直接偏移N月
     * 比如当前是2012-01-05 06:01:01,偏移2个动态月，则是2012-03-05 06:01:01
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetMonth(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        return calendar.getTime();
    }
    /**
     * 偏移自然月
     * 月份直接偏移N月,日期设置为第一天，时间设置为0
     * 比如当前是2012-01-05 06:01:01,偏移2个自然月，则是2012-03-01 00:00:00
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetNtrlMonth(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//把日期设置为1号
        return DateUtil.dayBegin(calendar.getTime());//把时间都置为00:00:00
    }
    
    /**
     * 偏移动态年
     * 年份直接偏移N年
     * 比如当前是2012-01-05 06:01:01,偏移2个动态年，则是2014-01-05 06:01:01
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetYear(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, amount);
        return calendar.getTime();
    }
    /**
     * 偏移自然年
     * 年份直接偏移N年,月份设为第一个月，日期设为第一天，时间设置为0
     * 比如当前是2012-01-05 06:01:01,偏移2个自然年，则是2014-01-01 00:00:00
     * @param date
     * @param amount
     * @return
     */
    public static Date offsetNtrlYear(Date date,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, amount);
        calendar.set(Calendar.MONTH, 0);//把月份设置为第一个月
        calendar.set(Calendar.DAY_OF_MONTH, 1);//把日期设置为第一天
        return DateUtil.dayBegin(calendar.getTime());//把时间都置为00:00:00
    }
    /**
     *   时间偏移
     * @param cutOffType 偏移类型:年 月 日 时 分 秒
     * @param cutOffNum 偏移数量
     * @param pos  需要偏移的时间
     * 
     * @return
     */
    public static Date offDate(int cutOffType, int cutOffNum, Date pos)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pos);
        cal.add(cutOffType, cutOffNum);
        return cal.getTime();
    }
    /**
     * 获取指定时间的首月，如 1.1   2.1  3.1 4.1  5.1
     * @param date
     * @return
     */
    public static Date offFirstDateAtMonth(Date date)
    {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        // time.getMaximum(field)
        time.set(Calendar.DATE, time.getActualMinimum(Calendar.DAY_OF_MONTH));
        return time.getTime();
    }
    
    /**
     * 次月1号
     * 
     * @author gao 2013-5-15
     * @param date
     * @return
     */
    public static Date offNextMothOffirstDate(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    
    
    public static void main(String[] args){
        Date date = DateUtil.toDate("2014/11/10 00:00:01");
        System.out.println(DateUtil.toString(DateUtil.dayEnd(offsetDay(date,30)),null));
//      Date date1 = offsetDay(date,2);
//      Date date2 = offsetNtrlDay(date,2);
//      Date date3 = offsetMonth(date,2);
//      Date date4 = offsetNtrlMonth(date,2);
//      Date date5 = offsetYear(date,2);
//      Date date6 = offsetNtrlYear(date,2);
//      Date date7 = offsetWeek(date,2);
//      Date date8 = offsetNtrlWeekOfSun(date,2);
//      Date date9 = offsetNtrlWeekOfMon(date,2);
//      
//      System.out.println("origDay : "+IMSUtil.formatDate(date));
//      System.out.println("offsetDay : "+IMSUtil.formatDate(date1));
//      System.out.println("offsetNtrlDay : "+IMSUtil.formatDate(date2));
//      System.out.println("offsetMonth : "+IMSUtil.formatDate(date3));
//      System.out.println("offsetNtrlMonth : "+IMSUtil.formatDate(date4));
//      System.out.println("offsetYear : "+IMSUtil.formatDate(date5));
//      System.out.println("offsetNtrlYear : "+IMSUtil.formatDate(date6));
//      
//      System.out.println("offsetWeek : "+IMSUtil.formatDate(date7));
//      System.out.println("offsetNtrlWeekOfSun : "+IMSUtil.formatDate(date8));
//      System.out.println("offsetNtrlWeekOfMon : "+IMSUtil.formatDate(date9));
    }
    
}
