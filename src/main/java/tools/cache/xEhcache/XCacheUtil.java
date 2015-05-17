//package tools.cache.xEhcache;
//
//import java.lang.reflect.Field;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import net.sf.ehcache.Element;
//import tools.reflect.ClassUtil;
//import tools.reflect.ReflectGetValue;
//import com.google.common.base.Objects;
//
//public class XCacheUtil
//{
//
//    public static <T> List<T> getMatchRecord(Collection<Element> allRecord, XCacheCondtion... cacheCondtions)
//    {
//        List<T> list = new ArrayList<T>();
//        try{
//        for (Element element : allRecord)
//        {
//            if (isMatch(element, cacheCondtions))
//            {
//                list.add((T)element.getObjectValue());
//            }
//        }
//        }catch (Exception e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException(e.toString());
//        }
//        return list;
//    }
//
//    private static boolean isMatch(Element element, XCacheCondtion... cacheCondtions) throws ParseException
//    {
//        Object obj = element.getObjectValue();
//        Map<String, Object> map = getObjectAttrs(obj);
// 
//        for (XCacheCondtion cond : cacheCondtions)
//        {
//            Object val = map.get(cond.getField().getName());
//            if (!isMatch(cond, val))
//            {
//                return false;
//            }
//        }
//      
//        return true;
//    }
//
//    private static Map<String, Object> getObjectAttrs(Object obj)
//    {
//        Map<String, Object> map = null;
//        try
//        {
//            map = ReflectGetValue.getFileValue(obj);
//        }
//        catch (Exception e)
//        {
//            
//            e.printStackTrace();
//        }
//        return map;
//    }
//
//    private static boolean isMatch(XCacheCondtion cond, Object val) throws ParseException
//    {
//        Object expectVal = cond.getValue();
//        switch (cond.getOperator())
//        {
// 
//        case EQUALS:
//            return Objects.equal(expectVal, val);
//        case LESS:
//            return ClassUtil.compare(expectVal, val, expectVal.getClass())>0;
//        case GREAT:
//            return ClassUtil.compare(val, expectVal, expectVal.getClass())>0;
//        case GREAT_EQUALS:
//            return ClassUtil.compare(val, expectVal, expectVal.getClass())>=0;
//        case LESS_EQUALS:
//            return ClassUtil.compare(expectVal, val, expectVal.getClass())>=0;
//
//        default:
//            throw new IllegalArgumentException("unSupport operator:" + cond.getOperator().name());
//        }
//
//    }
//
//    private static boolean oneBiggerTwo(Object obj1, Object obj2,Class clz)
//    {
//         
//        if (obj1 == obj2)
//        {
//            return false;
//        }
//        if (obj1 != null && obj2 != null)
//        {
//
//            return obj1.toString().compareTo(obj2.toString()) > 0;
//
//        }
//        return false;
//    }
//
//    public static Field getField(Class clazz, String fieldName)
//    {
//        Class current = clazz;
//        while (current != null)
//        {
//            try
//            {
//                Field field = current.getDeclaredField(fieldName);
//                return field;
//            }
//            catch (Exception e)
//            {
//            }
//            current = current.getSuperclass();
//        }
//        return null;
//    }
//
//}
