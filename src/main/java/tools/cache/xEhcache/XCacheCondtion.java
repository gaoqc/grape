package tools.cache.xEhcache;

public class XCacheCondtion
{
    private XField field;
    private Object value;
 



    private XOperator operator;

    public XCacheCondtion(XField field, Object val, XOperator operator)
    {
        this.field = field;
        this.value = val;
        this.operator = operator;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Object getValue()
    {
        return value;
    }

    public XField getField()
    {
        return field;
    }

    public void setField(XField field)
    {
        this.field = field;
    }

    public XOperator getOperator()
    {
        return operator;
    }

    public void setOperator(XOperator operator)
    {
        this.operator = operator;
    }
}
