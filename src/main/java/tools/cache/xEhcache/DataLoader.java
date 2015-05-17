package tools.cache.xEhcache;

import java.util.List;

public interface DataLoader<T>
{
    public List<T> initData();

    public List<T> loadDataIfabsent();

}
