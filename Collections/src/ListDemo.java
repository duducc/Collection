package collection;

import java.util.ArrayList;
import java.util.Iterator;


/*
 *  Collection
 *    |--List: 元素是有序的，元素可以重复，因为该集合体系有索引
 *    |--Set  元素是无序的     元素不可以重复
 */ 



/**
 * 因为List是抽取出来的一个接口 ，所以它也就定义了 ArrayList   LinkedList   Vector  这个派系中的共性方法
 * @author wc
 *
 */
public class ListDemo {
	
	/*
	 *List 特有方法   凡是可以操作角标的方法都是该体系的特有的方法
	 *
	 *   增   
	 *      add(index,element);
	 *      addAll(index,Collection);
	 *   删   
	 *       remove(index);
	 *   改
	 *       set(index,element);
	 *   查
	 *       get(index);
	 *       subList(from ,to);
	 *       listIterator();
	 *
	 */
	
	
	public static void main(String[] args) {
		//演示列表迭代器
		
       ArrayList<String>  al  = new ArrayList<String>();
		
		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		
		//在迭代过程中，准备添加或者删除元素
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj.equals("java02")) {
				//当方法检测到对象的并发修改，但不允许这种修改时，抛出此异常
				//al.add("java008");
				//将java02的引用从集合中删除了
				it.remove();//运行后的结果为      obj=java01   obj=java02    obj=java03    【java01  java03】  
				//问题在于  不是吧java02删除了吗？  怎么还会打印
				// 答案是 你是不是遍历到java02 了  java02是不是obj的指向了  it.remove() 是不是把这个元素引用从集合中移除了      但是虽然引用从集合中移除了   元素是不是还在内存当中啊  对  
				//元素是不是还在被obj使用啊  所以被打印了  打印没有问题 但是集合中没有了  但最终集合中的元素变不变  变了   是不是少了一个
				sop("obj="+obj);
				
			}
		}
		
		sop(al);
		//现在元素的引用是不是存放在了集合当中，通过集合的方法可以对这些元素操作，这没有问题
		//当我们来了一个 al.iterator()的时候  ，这个时候元素的引用取到迭代器里面去了
		//现在能操作元素的方式是不是有两种啊  要么通过集合的方法操作元素，要么通过迭代器的方法操作元素
		//可是  这个时候你要注意 你这两种方式 是不是操作的同一组元素
	    //所以这里会产生的问题是   迭代器正在迭代取出的操作过程中  你又用到了集合的功能操作这元素的话
		//就有可能产生安全隐患 ，这个叫做并发访问  同时的意思
		//那么如果我在取得过程中，你在往里面添加元素，那么这元素取不取就搞不清楚了
		//你不能做的是对同一组 元素进行多种同时操作，  你不能用集合 又用迭代器 去操作同一组元素  这样有可能引发并发修改异常
		//你在取  我在往里面加   那么你到底取不取呢  是不是搞不清楚  为什么搞不清楚 
		//容器再往里面加元素的时候   是不是加了  当前的3  个    到这句话al.iterator()的时候 容器是不是只知道  容器里面有3个  它只有3个
		//你在加其他的元素 它知道吗  它不知道  那他到底取不取  它不知道  你要再删一个呢   更麻烦了 迭代器本身认为这有 你把它删了   它是不是取不着
		//所以不能这么搞  怎么解决  你要么全用集合的方法 你要么全用迭代器的方法可是我在迭代过程中 我就不能用集合了吧  但是在迭代器集合前面就可以用集合的方法了
		//所以就要用迭代器的方法  
		
		// Iterrator接口 只有 三个方法   没有添加  有局限性
		//  但是列表迭代器       里面有角标 指针  方法比Iterator要多的多  不仅能添加  还可以判断  取出  修改  删除   是list集合特有的迭代器  是Iterator的子接口   只有list集合可以  因为 带角标
	}
	
	
	public  static void method(){
       ArrayList<String>  al  = new ArrayList<String>();
		
		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		sop("原集合是:"+al);
		
		
		//在指定位置添加元素
		al.add(1,"java09");
		
		//删除指定位置的元素
		al.remove(2);
		
		//修改元素
		al.set(2,"java007");
		
		//通过角标获取元素
		sop("获取索引为1的元素:"+al.get(1));
		
		sop("现集合是:"+al);
		
		
		//获取所有元素   操作角标  但凡操作角标的都是数组原理  只要有角标  就能遍历
		for (int i = 0; i <al.size(); i++) {
			System.out.println("al("+i+")="+al.get(i));
		}
		
		//迭代器取出元素
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
             sop("next:"+it.next());			
		}
		
		//通过indexOf获取对象的位置
		sop("index="+al.indexOf("java09"));
		
		//获取从哪到哪的子list
		
		sop("子List="+al.subList(0,2));
		
	}
	
	
	
	
	public static void sop(Object obj){
		
		System.out.println(obj);
	}

}
