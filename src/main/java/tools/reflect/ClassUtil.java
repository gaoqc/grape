package tools.reflect;

import java.text.ParseException;
import java.util.Date;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

public class ClassUtil
{
    public static int compare(Object obj1, Object obj2, Class clz) throws ParseException
    {
        if (obj1 == obj2)
        {
            return 0;
        }
        if (obj1 != null && obj2 != null)
        {

            if (clz == Integer.class)
            {
                return Ints.compare(Integer.parseInt(obj1.toString()), Integer.parseInt(obj2.toString()));

            }
            else if (clz == Long.class)
            {
                return Longs.compare(Long.parseLong(obj1.toString()), Long.parseLong(obj2.toString()));
            }
            else if (clz == Double.class)
            {
                return Doubles.compare(Double.parseDouble(obj1.toString()), Double.parseDouble(obj2.toString()));
            }
            else if (clz == Boolean.class)
            {
                return Booleans.compare(Boolean.parseBoolean(obj1.toString()), Boolean.parseBoolean(obj2.toString()));
            }
            else if (clz == Byte.class)
            {
                return Byte.valueOf(obj1.toString()).compareTo(Byte.valueOf(obj2.toString()));
            }
            // else if (clz == Character.class)
            // {
            // return Character.(obj1.toString()).compareTo(Character.valueOf(obj2.toString()));
            // }
            else if (clz == Float.class)
            {
                return Float.valueOf(obj1.toString()).compareTo(Float.valueOf(obj2.toString()));
            }
            else if (clz == Date.class)
            {
                
                return ((Date)obj1).compareTo((Date)obj2);
            }
            else
            {
                throw new IllegalArgumentException("unSupport:" + clz.getSimpleName());
            }
        }
        else
        {
            return 0;
        }
    }
}
