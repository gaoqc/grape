package bean;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.xml.namespace.QName;
import com.google.common.base.Objects;

public class Children extends Person
{

    public Children()
    {
    }

    private Integer no;
    TicketPrinter worker;

    // private Integer brand;

    // private String temp;
    //
    //
    // public void setTemp(String temp)
    // {
    // this.temp = temp;
    // }
    //
    // public String getTemp()
    // {
    // return temp;
    // }
    //

    public TicketPrinter getWorker()
    {
        return worker;
    }

    public void setWorker(TicketPrinter worker)
    {
        this.worker = worker;
    }

    public Integer getNo()
    {
        return no;
    }

    public void setNo(Integer no)
    {
        this.no = no;
    }

    // public Integer getBrand()
    // {
    // return brand;
    // }
    //
    // public void setBrand(Integer brand)
    // {
    // this.brand = brand;
    // }

    @Override
    public String toString()
    {
        String s = Objects.toStringHelper(Children.class).add("no", no).add("brand", 00)

        .toString();
        if (null != worker)
        {
            s += worker.toString();
        }
        return s + super.toString();
    }

    public static void main(String[] args) 
    {

      Integer x=new Integer(1);
      Integer y=new Integer(2);
 
      System.out.println("x="+x.intValue()+",y="+y.intValue());
      
    }
//    public  static void swap(int a,int b){
//        swap(new Integer(a),new Integer(b));
//    }


    private static void read(String dest) throws FileNotFoundException, IOException, ClassNotFoundException
    {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dest));
         try{
             System.out.println(inputStream.readObject().toString());
             System.out.println(inputStream.readObject().toString());
         }catch (EOFException e) {
            e.printStackTrace();
        }
    
         

          
    }

    private static void write(String dest) throws FileNotFoundException, IOException
    {
        Children p = new Children();// new Children(19137, 7, "高其成", 29, true, "杭州市拱墅区", new Date());
        
        p.setAge(29);
        p.setBirth(new Date());

        Children p2 = new Children();// new Children(19137, 7, "高其成", 29, true, "杭州市拱墅区", new Date());
       
        p2.setAge(30);
        p2.setBirth(new Date());
       
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dest));
        outputStream.writeObject(p);
        outputStream.writeObject(p2);
        outputStream.flush();
        outputStream.close();
    }

}
