package tools.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class FileTool
{

    public static byte[] readFileToBytes(String fileName)
    {

        try
        {
            return Files.toByteArray(new File(fileName));
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    
    

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static String readFileByChars(String fileName)
    {
        try
        {
            return Files.toString(new File(fileName), Charset.defaultCharset());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

   
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<String> readFileLines(String fileName)
    {
        try
        {
            return Files.readLines(new File(fileName), Charset.defaultCharset());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

//    /**
//     * 随机读取文件内容
//     */
//    public static String readFileByRandomAccess(String fileName)
//    {
//        RandomAccessFile randomFile = null;
//        StringBuffer sb = new StringBuffer();
//        try
//        {
//            // System.out.println("随机读取一段文件内容：");
//            // 打开一个随机访问文件流，按只读方式
//            randomFile = new RandomAccessFile(fileName, "r");
//            // 文件长度，字节数
//            long fileLength = randomFile.length();
//            // 读文件的起始位置
//            int beginIndex = (fileLength > 4) ? 4 : 0;
//            // 将读文件的开始位置移到beginIndex位置。
//            randomFile.seek(beginIndex);
//            byte[] bytes = new byte[10];
//            int byteread = 0;
//            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
//            // 将一次读取的字节数赋给byteread
//            while ((byteread = randomFile.read(bytes)) != -1)
//            {
//                sb.append(new String(bytes, 0, byteread));
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            if (randomFile != null)
//            {
//                try
//                {
//                    randomFile.close();
//                }
//                catch (IOException e1)
//                {
//                }
//            }
//        }
//        return sb.toString();
//    }

  

}
