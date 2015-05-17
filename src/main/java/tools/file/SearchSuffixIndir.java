package tools.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchSuffixIndir
{

    /**
     * 灏嗙粰瀹氱洰褰曚笅鐨勫強瀛愮洰褰曚笅鐨� 鎵�鏈夌殑缁欏畾鍚庣紑鍚嶇殑鏂囦欢璺緞鎵撳嵃鍒颁竴涓枃浠朵腑銆� 娣卞害閬嶅巻璇ョ埗鐩綍锛屽皢绗﹀悎鏉′欢鐨勬枃浠惰矾寰勫瓨鍒伴泦鍚堜腑銆傦紙杩涜杩囨护锛夈�� 鍐嶅皢闆嗗悎鍐欏埌鏂囦欢涓��
     */
    public static void main(String[] args)
    {

        String dir = "E:/ocsnew";
        int size = 0;
        for (File file : searchDir(dir,  ".svn"))
        {
            System.out.println(file.getAbsolutePath());
            size++;
        }
        System.out.println("total size:" + size);

    }

    public static List<File> searchDir(String searchDir, final String targetDirName)
    {
        File dir = new File(searchDir);
        FilenameFilter filenameFilter = new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                if (dir.isDirectory() && name.equals(targetDirName))
                {
                    return true;
                }
                return false;

            }
        };
        ArrayList<File> list = new ArrayList<File>();

        writeToList(dir, filenameFilter, list);
        return list;
    }

    /**
     * 查找文件
     */
    public static List<File> searchFiles(String searchDir, final String prefix, final String suffix)
    {
        File dir = new File(searchDir);
        FilenameFilter filenameFilter = new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                if (notEmpty(prefix) && notEmpty(suffix))
                {
                    return name.startsWith(prefix) && name.endsWith(suffix);
                }
                else if (notEmpty(prefix))
                {
                    return name.startsWith(prefix);
                }
                return name.endsWith(suffix);

            }
        };
        ArrayList<File> list = new ArrayList<File>();

        writeToList(dir, filenameFilter, list);
        return list;
    }

    private static boolean notEmpty(String str)
    {
        return null != str && !str.trim().equals("");
    }

    private static void writeTofile(ArrayList<File> al, File file)
    {
        BufferedWriter bw = null;
        try
        {
            bw = new BufferedWriter(new FileWriter(file));

            for (File f : al)
            {
                new String();
                // bw.write(String.valueOf(f.length()));
                bw.write(f.getAbsolutePath());
                bw.newLine();
                bw.flush();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("鍐欏叆澶辫触锛�");
        }
        finally
        {
            if (bw != null)
                try
                {
                    bw.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException("鍏抽棴澶辫触锛�");
                }
        }

    }

    private static void writeToList(File dir, FilenameFilter searchSuffix, ArrayList<File> al)
    {

        File[] files = dir.listFiles();
        for (File f : files)
        {
            if (f.isDirectory())
            {
                // 閫掑綊浜嗐��
                writeToList(f, searchSuffix, al);
            }
            else
            {
                if (searchSuffix.accept(dir, f.getName()))
                {
                    al.add(f);
                }
            }
        }
    }

}
