package tools.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialiUtil
{

    public static byte[] objToByte(Object obj)
    {

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try
        {
            ObjectOutputStream outStream = new ObjectOutputStream(byteStream);
            outStream.writeObject(obj);
            outStream.flush();
            outStream.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return byteStream.toByteArray();
    }

    public static List<? extends Object> byteToObject(byte[] bs)
    {
        try
        {
            List<Object> list = new ArrayList<Object>();
            ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bs));
             list.add(inputStream.readObject());
//             list.add(inputStream.readObject());
            return  list;

        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {

            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args)
    {

    }

}
