import java.util.ArrayList;
import java.util.Iterator;

/**
 *将自定义对象作为元素存储到ArrayList 并去除重复元素
 * 比如 : 存人对象,同姓名同年龄  视为同一个人，为重复元素
 *
 * 思路：
 * 1，对人描述  ，将数据封装进入对象
 * 2  定义容器，将人存入
 * 3   取出
 */



 class ArrayListTest2 {
    public  static void sop (Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new Person("lisi01",30));
        al.add(new Person("lisi02",32));
        //al.add(new Person("lisi02",32));
        al.add(new Person("lisi03",33));
        //al.add(new Person("lisi04",35));
        //al.add(new Person("lisi04",35));

        al = singleElement(al);//用这个方法去除之后 发现重复元素还是存在
        //这里涉及到一个问题  ArrayList 他知道你判断相同的条件吗  不知道  我们虽说按照姓名年龄判断 但是他不知道
        //那么他是怎么判断的  他只判断你王里面存的对象是否相同  而判断对象是否相同 用的是哪个方法  equals()  所有对象都具备的方法
        // 所以要记住 在ArrayList中判断元素是否相同用的是equals()方法  他在使用对象的equal 在和另外一个对象进行比较  返回为真 视为相同  返回为假 视为不相同
        //那么问题就来了  在Person中有没有 equals方法   有  是因为它继承自 Object的equals  而 Object中的equals比较的是地址值
        //而地址值当中 这六个对象 是不是都一样  所以都不相同  在这里我们应该告诉他用我们的方法进行比较
        //需要重写equals    在这里面我们判断什么是不是姓名和年龄  应为往里面传的是Person  就被提升了  需要向下转型

        //判断元素是否相同 我们在这里用的是集合的contains()方法  而这个方法的底层原理就是equals
        //记住一个结论 List集合判断元素是否相同 ，依据的是元素的equals方法 其他的集合和这个不一样
        //是怎样运行的呢 你调用了一次contains  它在里边调用一次equals
        //现在明白了这个问题之后   很多问题可以搞清楚了
        //先注释掉equals  往集合中添加 4个元素 然后想把第三个元素给删除了  怎么做呢  al.remove(new Person("lisi03",33))
        //返回为false  应为它想删除一个元素 他先在里面找一下有没有  怎么判断的有没有 就是equals  但是现在调用Object  解开注释之后 就返回true  就干掉元素了
        //所以 remove 底层用的也是equals   而数据结果不同依赖的方法是不一样的  arraylist  linklist 依赖的都是equals  无论是包含还是删除


        Iterator it = al.iterator();
        // 这里边有两个问题
        // 1.第一次next 打印 lisi01  第二个next打印 llsi02的age  这个问题不要再犯
        // 2.编译不会通过  他会报找不到getName()  不认识   类 Object不认识
        // 往里边存的时候 al.add(Object obj)  只有他可以接收任意对象   你把Person往里边一传
        // 是不是这个样子的  Object obj = new Person("lisi01",30);  是不是提升了
        //那么next 往会返的时候  是不是Object  是的   Object  里面有  getName方法吗  多态编译失败
        //
        while(it.hasNext()){
                Object obj = it.next();//因为迭代器不知道里面装什么元素 返回的都是Object
                Person  p = (Person) obj;//若想要子类对象中特有方法  就需要向下转型
               // sop(it.next().getName()+"::"+it.next().getAge());
              sop(p.getName()+"::"+p.getAge());
        }
    }
    //去除ArrayListj集合中的重复元素
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

}
class  Person {

    private  String name;
    private  int age;

    Person(String name,int age){
        this.name=name;
        this.age = age;
    }
    public boolean equals(Object obj){//Person 的equals()

       if (!(obj instanceof Person)){//若严谨一些这里直接抛异常
           return false;
       }
       Person p = (Person)obj;
        System.out.println(this.name + "....." + p.name);
        return this.name.equals(p.name)&&this.age==p.age;//这里的equals是字符串的equals是判断字符串是否相等
    }
    public String getName(){
        return  name;
    }
    public int getAge(){
        return  age;
    }


}


