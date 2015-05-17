package bean;

import java.util.List;
import tools.seq.SequenceUtils;
import tools.time.TimeUtil;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class Address
{
    
    private String mainAddress;
    private String secondaryAddress;
    private  int no;
    public Address(){}
    public Address(String mainAddress,String secondaryAddress,int no){
        this.mainAddress=mainAddress;
        this.no=no;
        this.secondaryAddress=secondaryAddress;
    }
    public String getMainAddress()
    {
        return mainAddress;
    }
    public void setMainAddress(String mainAddress)
    {
        this.mainAddress = mainAddress;
    }
    public String getSecondaryAddress()
    {
        return secondaryAddress;
    }
    public void setSecondaryAddress(String secondaryAddress)
    {
        this.secondaryAddress = secondaryAddress;
    }
    public int getNo()
    {
        return no;
    }
    public void setNo(int no)
    {
        this.no = no;
    }
    @Override
    public String toString()
    {
       
        return Objects.toStringHelper(Address.class).omitNullValues().add("main", mainAddress)
        .add("send", secondaryAddress).add("no", no).toString();
    }
    public static void main(String[] args)
    {
//        Address address =new Address();
//        address.setMainAddress("杭州市");
//        address.setSecondaryAddress("拱墅区");
//        System.out.println(address.toString());
//        Properties p=System.getProperties();
//        for(Object key:p.keySet()){
//            System.out.println(key.toString()+"="+p.get(key).toString());
//        }
        List<String> list=Lists.newArrayList("拱墅区","左岸花园","拱北小区","永庆坊","上塘高架");
        while(true){
        int mainNo=Integer.valueOf(SequenceUtils.getSeqInRange( list.size(),0));
        int secondNo=Integer.valueOf(SequenceUtils.getSeqInRange( list.size(),0));
        int no=Integer.valueOf(SequenceUtils.getSeqInRange( 10000,0));
        Address address =new Address(list.get(mainNo), list.get(secondNo), no);
        System.out.println(address.toString());
        TimeUtil.sleepSecods(1);
        }
        
    }
    

}
