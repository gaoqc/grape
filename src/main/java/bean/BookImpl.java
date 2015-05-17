package bean;

public class BookImpl implements IBook
{

    @Override
    public void sayHello(String name, int age)
    {
        System.out.println(name+"===="+age);
        
    }

     

}
