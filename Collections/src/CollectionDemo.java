package collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 每个容器向上抽取的顶级接口
 * 常用的两个子接口   
 * List
 * Set
 * @author wc
 *
 */

//为什么会出现这么多的容器呢,因为每一个容器对数据的存储方式都有不同  这个存储方式称之为：数据结构

public class CollectionDemo {
	
   public static void base_method(){
	   //创建一个集合容器，使用Collection的子类.ArrayList
		ArrayList  al  = new ArrayList();
		
		//1.添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		/**
		 * add(Object obj)  1.为什么是object  因为可以存储任意类型对象进来 
		 * 2.集合中存储的都是对象的引用（地址）
		 * Person p = new Person()
		 * ArrayList al = new ArrayList)
		 * al.add(p)
		 * 此时  p 和 al都在栈内存  先有Person()   new ArrayList()  在堆内存
		 * p指向 Person()  并保存内存地址  al指向 new  ArrayList()
		 * al.add(p)  是把Person对象扔进ArrayList里面了吗  不是
		 * 集合中不可能存放的是集合实体   那样集合得有多胖   有新的元素还得挪位置
		 * 存放的都是地址  随时找到你  你不用动
		 * 
		 */
		//打印原集合
		sop("原集合"+al);
		
		//删除元素
		//al.remove("java02");
		//al.clear();//清空集合
		//清空集合
		sop("java03是否存在"+al.contains("java03"));
		sop("集合是否为空？"+al.isEmpty());
		
		//获取个数，集合长度
		sop("size:"+al.size());
		
		//打印改变后的集合
		sop("改变后的集合"+al);
   }
   
   public static void method_2(){
	   ArrayList  al1  = new ArrayList();
	   
		   al1.add("java01");
		   al1.add("java02");
		   al1.add("java03");
		   al1.add("java04");
       ArrayList  al2  = new ArrayList();
		
	       al2.add("java03");
	       al2.add("java04");
	       al2.add("java05");
	       al2.add("java06");
         
         //al1.retainAll(al2);//取交集，al1中只会保留和al2中相同的元素  可以理解为对集合的改变
         al1.removeAll(al2);//干掉一堆元素
         sop("al1"+al1);
         sop("al2"+al2);
   }
   /**
    * 迭代器
    * 其实就是集合的取出元素的方式   没必要刨根问底 问这个词怎么来的 也不要被这个名词吓到
    */
   /**
    * 每个容器它里面都有存和取的方式  而且因为每个容器的数据结构不一样  所以呢他们存取的动作 也有可能实现的方式也不一样  
    * 虽然他们都具备存和取这样的动作  但是应为底层的数据结构不同   存取方式是不同的  具体实现方法不一样
    * 每个集合都具备一个取出的方式 而这个取出的方式呢  它不足以用一个方法来描述 不像添加那么简单  不足以用一个方式（函数）来描述  需要用多个功能来体现   那怎么办
    * 怎么叫 不足以   因为对于取出不止一个动作  他就把取出这个动作 封装成了一个对象
    * 每个容器（集合）都有一个取出的对象   而且应为数据结构不同  每个取出对象中取出的实现方式也不一样，取出的动作 细节都不一样
    * 这个取出就需要被描述一下  怎么描述  通过一个类来完成的  而这个类就定义在集合的内部  为什么   因为元素在集合中  你操作的是元素 
    * 你想直接操作元素  内部类最方便  这个内部类就完成取出动作的定义  每个容器里面都有这个内部类
    * 若以后再产生容器  这个容器也需要定义这些东西   
    * 每个容器再取出的动作中 一般都具有  判断  取出 操作   所以将这些共性抽取   这样 每个容器都是扩展功能
    * 所以他们有自己体系同时 将共性抽取出来  形成一个接口  叫Iterator    而这个对象实在内部实现的  这个对象怎么获取呢
    * 那么这些内部类都符合（抽取）一个规则   该规则是Iterator 
    * 如何获取集合的取出对象呢？
    * 通过一个对外提供的方法  iterator（）；
    * 这个就是取出方式  怎么设计的
    * 以后新出来的集合只要实现这个接口就可以了  这样是不是就统一了取出方式新家集合都不怕 因为他们都用 iterator（） 来取
    * 
    * 在iterator方法中   实际最终返回的就是  new 了  一个相应容器（集合）内部类对象返回
    *  
    */
   public static void method_get(){
	   ArrayList  al  = new ArrayList();
	   
	     al.add("java01");
	     al.add("java02");
	     al.add("java03");
	     al.add("java04");
	     
	     //用集合对象调用 iterator()  返回的是一个Iterator接口
	     
	    //这个方法返回的是Iterator接口的子对象，至于这个子对象是怎么建立出来的  它给分装起来了
	    //接口型引用 只能指向自己的子类对象  这个对象不是被new的而是通过集合当中的方法获取出来的
	     //Iterator it = al.iterator();//获取迭代器，用于取出集合中的元素
	     //while(it.hasNext()){
	    	 //sop(it.next()); 
	     //}
	     for (Iterator it = al.iterator();it.hasNext();) {
			sop(it.next());
		  }
   }
   
   public static void main(String[] args) {
	   
	   method_get();
	   
   }
   
   public static void sop(Object obj){
	   System.out.println(obj);
   }	

}
