package tools.cache.xEhcache;
/**
 * 条件运算符
 * <li>=  等于</li>
 * <li>>  大于</li>
 * <li><  小于</li>
 * <li>>= 大于等于</li>
 * <li><= 小于等于</li>
 * <li>!= 不等于</li>
 * <li>^= 匹配字符串头</li>
 * <li>$= 匹配字符串尾</li>
 * <li>*= 匹配字符串任意位置</li>
 * <li>in in</li>
 * <li>[] BETWEEN</li>
 */
public enum XOperator
{
    EQUALS("="), GREAT(">"), LESS("<"), GREAT_EQUALS(">="), LESS_EQUALS("<="), MATCH_ANY("*="), MATCH_START("^="), MATCH_END("$="), IN(
            "in"), NOT_IN("not in"), NOT_EQUALS("<>"), BETWEEN_L_L("[]"), IS_NULL("=NULL"), IS_NOT_NULL("!=NULL");

    XOperator(String key)
    {
        this.key = key;
    }
    private String key;

    public String getKey()
    {
        return key;
    }

    //
    public static XOperator valueOfKey(String key)
    {
        for (XOperator o : XOperator.values())
        {
            if (o.key.equals(key))
            {
                return o;
            }
        }
        if ("!=".equals(key))
        {
            return XOperator.NOT_EQUALS;
        }
        return null;
    }

}
