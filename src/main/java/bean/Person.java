package bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import tools.date.DateUtil;
import tools.file.FileTool;
import tools.serializable.SerialiUtil;
import com.google.common.base.Objects;

public class Person implements Serializable
{
    public Person()
    {
    }

    public Person(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;
    private Date birth;

    private static String staticName;

    private Boolean boy;
    private Address address;

    @Override
    public String toString()
    {
        String to = Objects.toStringHelper(Person.class).add("name", name).add("age", age).add("boy", boy)
                .add("address", address).add("birth", DateUtil.toString(birth, null)).add("staticName", staticName).toString();
        if (null != address)
        {
            to += address.toString();
        }
        return to;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
       MethodInterceptor   interceptor =new MethodInterceptor (){

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
        {
            System.out.println("=====begin=====");
            Object re =proxy.invoke(obj, args);
            System.out.println("=====end=====");
            return re;
        }
       };
       final IBook book =(IBook)invoke(new BookImpl(),interceptor);
 
        
     
       
       
        
        
    }
    private static   Object invoke(Object instance, MethodInterceptor   interceptor){
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(interceptor.getClass());  
        // 回调方法  
        enhancer.setCallback(interceptor);  
        // 创建代理对象  
        return enhancer.create();  
    }

    private static void inTest(String dest) throws IOException, ClassNotFoundException
    {

        List<Object> list = (List<Object>) SerialiUtil.byteToObject(FileTool.readFileToBytes(dest));
        for (Object obj : list)
        {
            System.out.println(obj.toString());
        }

    }

    private static void outTest(String dest) throws IOException
    {
        // Children(int no, int brand, String name, int age, boolean boy, String address, Date birth)
        Children p = new Children();// new Children(19137, 7, "高其成", 29, true, "杭州市拱墅区", new Date());

        p.setAge(29);
        p.setBirth(new Date());
        p.setBoy(true);
        p.setName("高其成");
        p.setNo(19137);
        // p.setBrand(1);
        p.setStaticName("staticName");

        TicketPrinter worker = new TicketPrinter();

        p.setWorker(worker);

        System.out.println(p.toString());
        FileOutputStream outputStream = new FileOutputStream(new File(dest));
        outputStream.write(SerialiUtil.objToByte(p));

        Children p2 = new Children();// new Children(19137, 7, "高其成", 29, true, "杭州市拱墅区", new Date());

        p2.setAge(292);
        p2.setBirth(new Date());
        p2.setBoy(true);
        p2.setName("高其成2");
        p2.setNo(191372);
        System.out.println(p2.toString());
        outputStream.write(SerialiUtil.objToByte(p2));

        outputStream.close();

    }

    public static String getStaticName()
    {
        return staticName;
    }

    public static void setStaticName(String staticName)
    {
        Person.staticName = staticName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Date getBirth()
    {
        return birth;
    }

    public void setBirth(Date birth)
    {
        this.birth = birth;
    }

    public Boolean getBoy()
    {
        return boy;
    }

    public void setBoy(Boolean boy)
    {
        this.boy = boy;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

}
