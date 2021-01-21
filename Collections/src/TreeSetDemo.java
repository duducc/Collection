import java.util.Iterator;
import java.util.TreeSet;

/**
 * Set:无序，不可以重复元素。
 *   |--HashSet： 数据结构是哈希表，线程是非同步的
 *                保证元素唯一性的原理：判断元素的hashco值是否相同
 *                如果相同，还会继续判断元素的equals方法，是否为true
 *         Hashset是无序的有些不爽  那能不能搞点顺序呢  就出来了另外一个子类  来弥补不足
 *   |--TreeSet：可以对set集合中的元素进行排序
 *               底层数据结构是二叉树
 *               保证元素唯一性的依据
 *               compareTo方法return 0   判断删除  包含  走的都是compareTo  但凡返回是0的话元素都是相同的  否则都不相同
 *               TreeSet排序的第一种方式：让元素自身具备比较性 元素需要实现Compareable接口 覆盖compareTo方法
 *               这种方式也称为元素的自然顺序，或者叫做默认顺序   就是元素一定义完  他就具备比较性  像字符串也是  一被定义出来以后  它是不是已经具备了按照字典顺序排序的方式
 *
 *
 *   需求：
 *   往TreeSet集合中存储自定义对象学生
 *   想按照学生的年龄进行排序    记住，排序时，当主要条件相同时，一定要判断一下次要条件   假如这里面有重复元素呢  运行后发现  没有被添加到集合里面因为  姓名年龄都一样   没有进去 因为他被视为一个重复元素了
 *   例 :  下面的1234行代码  然后发现 编译没有问题   一运行  发现报了一个异常 叫做 ClassCastException  类型转换异常    无法从student转换到java。lang。Comparable  这是个什么东西
 *         开始找发现在第2行代码位置出的问题    注释掉234行发现可以运行没有问题  第1行代码是不是执行了 添加进去了  然后打开一个 是不是挂了 报异常了   在这里5行代码目前打印的是对象  没有获取他具体的
 *         属性值   然后在jdk中找到Comparable  发现是一个接口  有好多的子类  到这里我们就要思考为什么 存一个就没事 但是存第二个的时候就出问题了呢
 *         TreeSet 集合是不是可以排序 但是按照什么排   他知道吗（可是按照什么方式排  你给他说过吗） 你想按照年龄排 他不知道啊  为什么不知道  因为你那个学生对象根本就不具备比较性  那怎么排呢
 *         所以怎么办呢 所以java说  你必须要你的元素具备比较性  你往TreeSet 里面存元素  他是不是要帮你排序  你并没有把你要排序的方式告诉他  他没法帮你办这件事  所以TreeSet的要求是往里面存的元素
 *         必须具备比较性  但是我怎么具备比较性呢 TreeSet说去找一接口去  你只要实现了他 你就具备了比较性  你具备了比较性 我就能使用这个比较性 因为我是不是预先使用这接口中的方法  是不是  多态
 *         你只要都符合我的规则  我就能帮你排序  所以 正如jdk文档中所提到的Comparable接口的出现强行对实现它的每个类的对象进行整体排序  这种排序被称为类的自然排序  类的compareto方法被称为它的自然比较方法
 *         就是让实现了comparable接口的对象都具备比较性  而这种比较性 一般被称为类的自然顺序  这接口里面就有一个方法compaeTo（T  o）方法  返回int类型的值
 *         这个的方法中这样解释 ：比较此对象与指定对象的顺序 指定对象是不是 这个o啊 此对象是谁 是不是调这个方法的this  因为你知道如果学生它具备比较性的话  学生对象和另外一个学生对象比是不是就可以了
 *         所以学生怎么办   所以要实现Comparable     //该接口强制让学生具备比较性    就是刚才说的你没有比较的可能  我怎么拿你比去呢
 *
 *         在Student对象类里面实现了compareTo 方法之后往ts treeSet先存进去了3个元素发现  最后运行发现他们排序了 19  20 22
 *         现在往里面继续存了一个相同对象   这个时候 返回0  根据接口规则  这个时候他比较了之后是此对象等于指定对象所以就没有存进去
 *         这个时候 我们需要的是相同对象也就说不仅年龄相同姓名也要相同   那在compareto方法中继续要判断一下姓名也要相同才是同一个对象
 *         当主要条件相同 按照次要条件排
 *
 *          TreeSet的第二种排序方法
 *           当元素自身不具备比较性时，或者具备的比较性不是所需要的。
 *           这时就需要让集合自身具备比较性
 *           在集合初始化时  ，就有了比较方式  构造函数
 *
 */

public class TreeSetDemo {
    public static void main(String[] args) {
        //操作没有变化就是操作删除了
        TreeSet ts = new TreeSet();
        //ts.add("cba");
        //ts.add("abcd");
        //ts.add("aaa");
        //ts.add("bca");

        //下面存储自定义对象
        ts.add(new Student3("lisi02",22));//1
        ts.add(new Student3("lisi007",20));//2
        ts.add(new Student3("lisi09",19));//3
        ts.add(new Student3("lisi08",19));//7
        //ts.add(new Student3("lisi01",40));//4


        Iterator it = ts.iterator();
        while (it.hasNext()){
            System.out.println(it.next());//5 结果为 aaa  abcd   bca  cba  它看上去是没有顺序 但仔细发现他是不是有自己的特定顺序   首字母是不是排了  a a  b c   不管你是按照什么添加的
                                          //  但是发现这是什么顺序  是不是自然顺序 按照字母表排序  例如  添加了一个 Dbca  是不是发现排在了第一位  因为 D的顺序值是不是比较小   a是不是97啊
        }
    }
}
class Student3 implements Comparable{
    private  String name;
    private int age;

    public Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(Object o) {//你要比什么我不知道 那用Object接收么
        if(!(o instanceof  Student3)){
            throw  new RuntimeException("不是学生对象");
        }
        Student3 s = (Student3)o;//人家要的结果是不是正数负数和0啊  那么紧跟着怎么判断
        System.out.println(this.name + "****compareto******" + s.name);
        if(this.age>s.age){//是不是此对象大于指定对象

            return 10000;//只要是正数  写1就行  方便
        }
        if(this.age==s.age){
            //在这里String类也已经实现了compareto方法
            return   this.name.compareTo(s.name);//在这里它比完了返回的也是正数负数和零   如果if条件相同的时候     此行代码返回的是一个正数的话是不是按照姓名排序了呀
                                                 //如果排序了 第7行代码就在上面  因为是按照升序排序的  lisi08  lisi09
        }

        return -1;
    }
}
