import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型 (广泛的类型 ---  哪里广泛  写Iterator可以不  可以  是不是类型可以变化  也可以存String ) jdk1.5版本以后出现的新特性，用于解决安全问题，是一个安全机制  升级有3部分一个是高效一个是简化书写  一个是安全
 *
 * 在这里可以借鉴数组定义的原则来完成  为什么数组就不会错呢  因为在定义的时候就已经明确类型了  但是在定义集合的时候没有明确  如果在定义集合的时就明确元素类型的话  是不是就没有问题了 这就是泛型的由来
 * 那怎么能在集合定义是指定类型呢  <>  中定义类型  ArrayList<String> al  = new ArrayList<String>();  定义了一个集合 这里面元素是string类型
 *
 *
 * 好处：
 * 1.将运行时期出现问题ClassCastException，转到了编译时期  让运行时期问题问题减少  安全
 * 2.避免了强制转换的麻烦
 *
 * 泛型也强制客观的限定了类型
 *
 * 泛型的格式： 通过<>来定义要操作的引用数据类型  在使用java提供的对象时 什么时候写泛型呢？？
 *
 * 通常在集合框架中很常见
 * 只要见到<>就要定义泛型  例 Collection<E>中的E就代表 elements元素的意思  他没有具体的含义相当于一个变量  形式参数  也就是说你在操作ArrayList集合的时候需要明确一下你要操作元素的类型
 * 那么这样你在ADD()方法当中添加的就是什么类型的具体元素对象
 * 其实<>就是用来接收类型的  当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可
 */
public class GenericDemo {

   public static void main(String[] args) {
      ArrayList al  = new ArrayList();
      al.add("abc01");
      al.add("abc0991");
      al.add("abc014");

      al.add(4);//al.add(new Integer(4));  在这里有一个自动拆装箱动作   但是在这里程序会抛出 类型转换异常   Interator不能转换成String
                //编译的时候没有发生任何问题  运行的时候才产生问题   但是对于客户无法解决这个问题
                //但是如果在编译的时候产生问题  程序员直接解决了  是不是就没有问题了
                //  分析问题发现  是因为往里面存了不同元素产生的        如果往里面全部存成String是不是就不会产生这样的问题
                //在jdk1.5之后  java对这个问题进行了 解决  提出一个新的东西  叫做 泛型
               //在添加泛型之后   在编译的时候就会将这个问题抛出
               //在添加了泛型之后   是不是在it.next()的时候就不用转了   但是发现还是会编译失败  应为 al.iterator()的时候是把集合放在了迭代器中  那么在你迭代器里面装的元素是不是也要明确类型啊
      //因为集合中可以添加很多对象  现在new一个 Interator


      Iterator<String> it = al.iterator();
      while (it.hasNext()){
         String  s = (String) it.next();
         System.out.println(s+":"+s.length());

      }
   }



}
