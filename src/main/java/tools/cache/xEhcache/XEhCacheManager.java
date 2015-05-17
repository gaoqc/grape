package tools.cache.xEhcache;

import java.util.ArrayList;
import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import net.sf.ehcache.search.expression.Criteria;

public class XEhCacheManager
{
    public static Cache getCache(Class clz)
    {
        return getCacheByObjectClassName(clz);
    }
    public static CacheManager getCacheManager(){
        return  CacheManager.getInstance();
    }

    public static void put(Object key, Object value)
    {
        getCacheByObjectClassName(value.getClass()).put(new Element(key, value));

    }

    public static void putIfAbsent(Object key, Object value)
    {
        getCacheByObjectClassName(value.getClass()).putIfAbsent(new Element(key, value));

    }

    public static Object get(Class<?> clz, Object key)
    {
        Element ele = getCacheByObjectClassName(clz).get(key);
        return getElementVal(ele);

    }

    public static void shutdown()
    {
        CacheManager.getInstance().shutdown();
    }

    public static <T extends Object> List<T> query(Class<? extends Object> clz, Criteria... criterias)
    {
        @SuppressWarnings("rawtypes")
        Cache cache = getCacheByObjectClassName((Class) clz);
        Query query = cache.createQuery();
        for (Criteria criteria : criterias)
        {
            query.addCriteria(criteria);
        }
        Results results = query.includeValues().end().execute();
        List<T> list = new ArrayList<T>();
        for (Result result : results.all())
        {
            list.add((T) result.getValue());
        }
        return list;

    }

    /**
     * @param val
     * @return
     */
    private static Cache getCacheByObjectClassName(Class clz)
    {
        String ClzName = clz.getName();

        Cache cache = CacheManager.getInstance().getCache(ClzName);
        if (null == cache)
        {
            String msg = "can't found Cache by Class name:" + ClzName + ", current cacheName ["
                    + toString(CacheManager.getInstance().getCacheNames()) + "]";

            throw new IllegalArgumentException(msg);
        }
        return cache;
    }

    private static String toString(String[] strs)
    {
        StringBuffer sb = new StringBuffer();
        for (String str : strs)
        {
            sb.append(str + ",");
        }
        return sb.toString();
    }

    private static Object getElementVal(Element ele)
    {
        if (null != ele)
        {
            return ele.getObjectValue();
        }
        return null;
    }

}
