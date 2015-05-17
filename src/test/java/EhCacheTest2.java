import java.util.Set;



public class EhCacheTest2
{
    public static void main(String[] args)
    {
        Set<Object> set=System.getProperties().keySet();
        for(Object obj:set){
            System.out.println(obj.toString()+"="+System.getProperties().get(obj) );
        }
    }

}
