import java.util.ArrayList;
import java.util.Iterator;

/**
 *去除ArrayList集合中的元素
 */


public class ArrayListTest1 {

    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        al.add("java01");
        al.add("java02");
        al.add("java01");
        al.add("java02");
        al.add("java01");
        al.add("java03");


        /**
         *
         *  迭代器的问题   有人会说直接next()两次不行吗   当集合中的元素是偶数的时候 是可以出来的  当注释掉最后一个的时候就出抛出没有这个元素异常
         *
         *  一定要记住： 在循环当中next()  就只写一次   原则是取一次 判断一次
         *
         *  在迭代时 循环中next调用一次  就要hashnext() 判断一次
         *
         */
        Iterator it = al.iterator();
        while (it.hasNext()){
            sop (it.next()+"....."+it.next());

        }

        /*sop(al);
        al = singleElement(al);
        sop(al);*/
    }





   public  static ArrayList singleElement(ArrayList al)
   {
       //定义一个临时容器
       ArrayList  newAl = new ArrayList();

      Iterator it =  al.iterator();

      while (it.hasNext()){
          Object  obj = it.next();

          if (!newAl.contains(obj)){
              newAl.add(obj);
          }

      }
      return newAl;
   }

   public static void sop (Object obj){
       System.out.println(obj);
   }



}
