import java.util.HashSet;
import java.util.Iterator;

/**
 * |--Set :  元素是无序的（存入和取出的顺序不一定一致），元素不可以重复。
 * |--HashSet  底层结构是哈希表  什么是哈希表  是按照哈希值来存的  万一哈希值一样呢
 * |--TreeSet
 *  Set集合的功能和Collection是一致的   Set 是不是不用再学了  对的   set没有角标
 *  重点关注子类对象
 */



class  Demo3{
  public int HashCode(){
      return 60;
  }
}


public class HashSetDemo {

    public static void sop(Object obj){
        System.out.println(obj);
    }

   /* public static void main(String[] args) {
      Demo d1 = new Demo();
      Demo d2 = new Demo();
      sop(d1);
      sop(d2);

        //如果现在重写了Object的Hashcode方法 将他设置为返回的哈希值为相同的  实际是Windows系统底层调用的一个hash算法算出来的    那么当存第一个之后再存入第二个的时候他们的地址就一样了
        // 这个时候怎么办呢  要记住在Hash表里面当值一样的时候他还有一种计算算法  当不一样的时候你有你的位置 我有我的位置  咱两不是一个元素 如果咱两一样的话还要做一个判断  咱两元素对象元素是否相同
        //就是说咱两位置一样了吧  然后在判断一下咱两是不是同一个对象  用的什么方法  equals    这个时候发现  位置是一样的   不一样 怎么办   在这里当元素进了哈希表以后呢  它会在该地址下顺延  都在同一个地址上
        // 串下来的      比如又存一个元素 地址不一样    先和之前的元素碰一下  发现不一样然后我单独放一个位置  先看哈希值   在比较是不是同一个对象  这个就是哈希表  HashSet  就是一个哈希表



    }*/
   public static void main(String[] args) {
       HashSet hs = new HashSet();
       hs.add("java01");
       hs.add("java02");
       hs.add("java03");
       hs.add("java04");
       //set集合取出只有一种方式  应为它是不是和那Collection一样啊  那就是迭代器遍历
       Iterator it = hs.iterator();
       while (it.hasNext()){
           sop(it.next());
       }
      //验证set集合的元素不可重复
       //  在添加一个相同元素  hs.add("java01");   返回的结果还是 java01 java02 java03 java04
       //为什么Add方法返回的是BOOLEAN类型的  可以执行以下代码
       //sop(hs.add("java01"));
       //sop(hs.add("java01"));  会发现第一次add  返回true 第二次是false    应为当第二个java01在往里面存的时候发现他们的地址值是一样的 判断内容呢 对象是不是也一样 是   他两是同一个元素 不存了
       //所以添加失败就为假

   }

}
