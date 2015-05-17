package tools.cache.xEhcache;

import java.util.List;

public interface XCache 
{
   /**
    *   
    * @param key
    * @param t
    * @return
    */
    public void cache(Object key, Object t);

    public void cache(XField field, Object t);

    public <T> List<T > getByConditions(Class<T> clz,XCacheCondtion... cacheCondtions);

    public <T> T getSinle(Class<T> clz,Object key);

}
