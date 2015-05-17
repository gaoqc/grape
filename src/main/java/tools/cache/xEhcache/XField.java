package tools.cache.xEhcache;

public class XField
{
    private Class type;
    private String name;
    private boolean isPk=false;
    
    public XField(String name){
        this.name=name;
    }
 
    public XField(String name,Class type){
        this.name=name;
        this.type=type;
    }
    
    public Class getType()
    {
        return type;
    }
    public void setType(Class type)
    {
        this.type = type;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public boolean isPk()
    {
        return isPk;
    }

    public void setPk(boolean isPk)
    {
        this.isPk = isPk;
    }
    
   
}
