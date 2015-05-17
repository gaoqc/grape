//import java.util.ArrayList;
//import java.util.List;
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;
//import net.sf.ehcache.search.expression.EqualTo;
//import net.sf.ehcache.search.expression.GreaterThanOrEqual;
//import tools.cache.xEhcache.XEhCacheManager;
//import tools.date.DateUtil;
//import bean.Person;
//
//public class EhCacheTest
//{
//    public static void main(String[] args)
//    {
//        for (Person p : instance2())
//        {
//           
//            XEhCacheManager.put(p.getNo(), p);
//        }
//        System.out.println("-------------------");
//        Cache cache=CacheManager.getInstance().getCache("bean.Person");
//       
//        for(Element ele:cache.getAll(cache.getKeys()).values()){
//            System.out.println(ele.getObjectValue().toString());
//        }
//        
//        System.out.println("====================================");
//       List<Person> list=XEhCacheManager.query(Person.class, new EqualTo("name", "x")
//       ,new GreaterThanOrEqual("age", 28)
//       ,               new GreaterThanOrEqual("birth", DateUtil.toDate("1980-02-01 00:00:00"))
//       ,new GreaterThanOrEqual("boy", true));
//       System.out.println("size="+list.size());
//       for(Person p:list){
//         p.setAge(1000);
//       }
//       System.out.println("====================================");
//        list=XEhCacheManager.query(Person.class, new EqualTo("name", "x"),new GreaterThanOrEqual("age", 28),
//               new GreaterThanOrEqual("birth", DateUtil.toDate("1980-02-01 00:00:00"))
//       ,new GreaterThanOrEqual("boy", true));
//       for(Person p:list){
//         System.out.println(p.toString());
//       }
//       
//       
//       XEhCacheManager.shutdown();
//
//    }
//
//    private static List<Person> instance2()
//    {
//        List<Person> list = new ArrayList<Person>();
//        list.add(new Person(10000, 6, "x", 28, true, "广东省", DateUtil.toDate("1986-06-15 00:00:00")));
//        list.add(new Person(10001, 7, "y", 26, true, "浙江省", DateUtil.toDate("1985-01-01 00:00:00")));
//        list.add(new Person(10002, 8, "z", 27, true, "山东省", DateUtil.toDate("1990-01-01 00:00:00")));
//        list.add(new Person(10003, 9, "a", 28, true, "江西省", DateUtil.toDate("2000-01-01 00:00:00")));
//        list.add(new Person(1004, 10, "b", 28, false, "广东省", DateUtil.toDate("1988-01-01 00:00:00")));
//        list.add(new Person(1005, 6, "c", 26, true, "浙江省", DateUtil.toDate("1987-01-01 00:00:00")));
//        list.add(new Person(1006, 5, "x", 25, true, "江西省", DateUtil.toDate("1985-01-01 00:00:00")));
//        list.add(new Person(1007, 10, "y", 50, true, "江西省", DateUtil.toDate("1985-01-01 00:00:00")));
//        list.add(new Person(1008, 8, "b", 25, true, "浙江省", DateUtil.toDate("1990-01-01 00:00:00")));
//        list.add(new Person(1009, 7, "x", 30, true, "广东省", DateUtil.toDate("1980-01-01 00:00:00")));
//        return list;
//
//    }
//
//   
//
//}
