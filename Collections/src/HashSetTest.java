import java.util.HashSet;
import java.util.Iterator;

/**
 * 往hashSet集合中存入自定义对象
 * 姓名和年龄相同为同一个人，重复元素
 *
 *   HashSet 是如何保证元素的唯一性的呢
 *   是通过元素的两个方法hashco 和equals
 *   如果元素的Hashcode值相同，才会判断equeals是否为true
 *   如果元素的hashcode值不同，不会调用equals     注意  对于判断元素是否存在以及删除等操作  添加都一样  以来的方法是 元素的hashcode 和equals  方法
 *                                                  先判断hashcode  在判断equals  如果这个时候new person2（"a4"，13）  一算哈希值 a4里面有没有  没有 所以 就不在比（读）equals了
 *
 *                                                  所以到这里你就知道了 Arraylist判断元素是否存在  还有删除元素 只依赖equals   这个原因全在数据结构上  数据结构不同 它依赖的方法也不一样
 *
 *                                                  Arraylist依赖的是equals  而hashset先依赖hashcode    再依赖equals  绝对有区别  你想判断元素 删除元素 都必须判断哈希值 这就是哈希表的特点
 *
 *
 *    那么我们建立一个比较有针对性的哈希值   是不是更高效一些   没有必要每次调用equals  好麻烦 特别慢  这就是我么说的hashset保证元素唯一性的依据
 *    那么说到这里我们就知道了   我们在定义一个对象 是不是要复写 hashcode 和equals  有可能要存放到 hashset集合当中
 *    你不复写有没有 有 而这个有  是不是都根据地址来判断的 地址值都不一样  所以坑定是挂的  所以你描述一个事物往集合里面存的时候就要复写这两个方法
 *
 *    而复写 的连个方法 是集合底层自己调用的
 *
 *
 *    在person2类中的hashcode   方法中一般可以再name.hashcode（）+age*37   age后面乘一个值  因为可能他们+出来的值是一样的     但是记住不能超出int范围
 *
 *    一般重复元素存进来了  就是这两个方法出问题了      也不要把equals中的参数类型改为person 编译可以  也可以运行      但是这是复写了吗  没复写
 *
 */

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new Person2("a1",11));
        hs.add(new Person2("a2",12));
        hs.add(new Person2("a3",13));
        //hs.add(new Person2("a2",12));
        //hs.add(new Person2("a4",14));

        sop(hs.contains(new Person2("a1",11)));   //true  通过这个可以看出什么呢  前三个无非是往里面添加对象   当第四个  是不是就是这个对象  想判断这个对象是不是在集合中存在的时候
        //那么他先判断的是谁  先判断的是哈希值   发现a2  12  的值是相同的   然后又比了一次equals  发现为真 然后就判断这个对象是在哈希表里面存在的
         hs.remove(new Person2("a3",13));//会发现他也比了一次哈希值  同样又比了一次equals


        //当前  我们往HashSet中添加集合是存在重复对象的    应为我们定义为用姓名同年龄为同一个对象    那么是不是必然要判断元素是否相同
        Iterator it = hs.iterator();
        while (it.hasNext()){
            Person2 p = (Person2) it.next();
            sop(p.getName()+"::"+p.getAge());

        }
    }
    public static  void sop (Object obj){
        System.out.println(obj);
    }


}
class Person2{
    private  String name;
    private  int age;

    Person2(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return  name;
    }
    public int getAge(){
        return  age;
    }

    //往里面存的时候  是不是先比较的是地址
    // 现在往里面存的4个对象都是new出来的  是不是都有自己独立的哈希值   都不一样  他们是不是就在哈希表  有了四个位置存储啊  都存进去了 还要再读equals吗  不用了
    //现在就要覆盖person2Hashcode方法   建立Person2对象自己的哈希值  那怎么建立哈希值呢  你的判断条件是什么  我就依据条件来生成哈希值 就是靠谱的
    public int hashCode(){
        System.out.println(this.name + "......hashCode  算一次哈希值");
        //return 60;
        return  name.hashCode()+age;
    }
     //是不是equals运行了   为什么运行了  应为
    //首先a1是不是存进来了  a1的地址是3c吧  是的   在哈希表中就有一位置存了一个对象这个对象就是a1,11
    //竟跟着a2 是不是进来了  它做了什么事情呢  它先算了自己哈希值  掉了自己的hashcode方法  它hashcode是不是也是3c
    //然后那着3c进来之后发现有一个值  地址一样的  这个时候他会做什么事情呢  他和a1的姓名和地址比了一下  这一比是不是不一样
    //所以就存进来了怎么存进来的呢   还是在3c的地址之上  顺延了一个球  就是a2，12
    //a2存完了之后  这个时候a3进来了  和a2比了一次 比完了之后是不是和a1比了一次  和a1  a2  比了之后地址还一样
    //比完之后  发现  a3的名称是不是不一样  所以a3还有位置  继续顺延了一个球 叫 a3 13
    //这个时候   进来了一个a2   它和a3比了一次   又和a2比了一次  为什么没有和a1比  因为他和a2一比是不是就找到相同的了  地址值一样并且equals相同
    //最后这个a2  就没有存进来  因为它认为哈希表里面已经有元素了 他就不往里面存了  所以发现在集合的结果中是不是只有3个元素  是保证唯一性了



    //a3和a2  哈希值不一样了  为什么还要在比一次equals呢  他们两地址值不一样是不是就可以了呀  接下来我们希望按照条件来设定哈希值
    //name设置hashCode值怎么设呢  name是不是有自己的hashCode方法   字符串是不是已经实现了 hashCode方法  字符串没有都有自己的哈希值  再个谁   +age

    //  运行法先  a1。。。。。hashCode   a2。。。。。hashCode   a3。。。。。hashCode   是不是a1  a2  a3 算过一次存里面去了  读equasl了吗  没有 为什么
    //因为他们是不是都有自己独立的哈希值   然后在存一个重复  算完前3个哈希值 就是调用了HashCode方法  算完之后到重复对象的时候是不是又算来一次哈希值    然后在比了一次 equals

    //重写equals
    public boolean equals(Object obj){
        if(!(obj instanceof  Person2)){
            return  false;
        }
        Person2 p = (Person2)obj;
        //如果这句话被打印  就说明equals被调用
        System.out.println(this.name+"...equals..."+p.name);
        return  this.name.equals(p.name)&&this.age==p.age;
    }
}
