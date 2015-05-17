package tools.match;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

public class ObjectMatcherKit
{
    /**
     * 最优匹配:找出最接近目标的值记录,规则: 1.只要一个字段值不为空且不等,就不匹配. 2.某个字段值不为空且相等,则权重+1 3.取回权重最大的记录即是最接近目标的记录.
     * 
     * @param <T>
     * @param sourcesList
     * @param target
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T matchByObjectVal(List<T> sourcesList, T target)
    {
        T maxT = null;
        try
        {
            Map tarMap = transforMap(target);
            int maxWeight = 0;

            for (T t : sourcesList)
            {
                int currentWeight = calWeight(t, tarMap);
                if ((null == maxT && currentWeight >= 0) || currentWeight >= maxWeight)
                {
                    maxT = t;
                    maxWeight = currentWeight;
                }
            }
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return maxT;
    }

    /**
     * 计算权重:某个字段值不为空且相等,则权重+1 
     * 
     * @param sourceObj
     * @param map
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static Integer calWeight(Object sourceObj, Map<String, Object> map) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException
    {
        int weight = -1;
        for (String fieldName : map.keySet())
        {
            Object val = PropertyUtils.getSimpleProperty(sourceObj, fieldName);
            Object tartVal = map.get(fieldName);
            if (null == val)
            {
                continue;
            }
            if (val.equals(tartVal))
            {
                weight++;
            }
            else
            {
                weight = -1;
                break;
            }
        }
        return weight;
    }
    /**
     * 找出字段值不为空的放入map列表
     * @param obj
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    private static Map<String, Object> transforMap(Object obj) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Field f : obj.getClass().getDeclaredFields())
        {
            map.put(f.getName(), PropertyUtils.getSimpleProperty(obj, f.getName()));
        }
        return map;
    }

}
