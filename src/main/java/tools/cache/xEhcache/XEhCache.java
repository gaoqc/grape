//package tools.cache.xEhcache;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.Element;
//
//public class XEhCache implements XCache
//{
//    private final Cache cache;
//
//    public XEhCache(Cache cache)
//    {
//        this.cache = cache;
//    }
//
//    public void cache(Object key, Object t)
//    {
//        cache.put(new Element(key, t));
//
//    }
//
//    public void cache(XField field, Object t)
//    {
//        cache(field.getName(), t);
//
//    }
//
// 
//
//    @SuppressWarnings("unchecked")
//    public <T> T getSinle(Class<T> clz,Object key)
//    {
//        Element ele = cache.get(key);
//        if (null != ele)
//        {
//            Object val=ele.getObjectValue();
//            if(val.getClass().isAssignableFrom(clz) ){
//                return (T)ele.getObjectValue();
//            }
//        }
//        return null;
//
//    }
//
//    public <T> List<T> getByConditions(Class<T> clz, XCacheCondtion... cacheCondtions)
//    {
//         
//      List<T> list = new ArrayList<T>();
//      Map<Object, Element> map = (Map<Object, Element>) cache.getAll(cache.getKeys());
//      if (null == map || map.size() == 0)
//      {
//          return list;
//
//      }
//      return XCacheUtil.getMatchRecord(map.values(), cacheCondtions);
//    }
//
//}
