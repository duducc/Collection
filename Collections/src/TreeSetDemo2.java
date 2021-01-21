import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 当元素自身不具备比较性，或者具备的比较性不是所需要的
 * 这时需要往容器自身具备比较性
 * 就定义了一个比较器，将比较器对象作为参数传递给TreeSet集合的构造函数
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new Student4("lisi02",22));
        ts.add(new Student4("lisi007",20));
        ts.add(new Student4("lisi09",19));
        ts.add(new Student4("lisi06",18));

        Iterator it = ts.iterator();
        while(it.hasNext()){
            Student4  stu  = (Student4) it.next();
            System.out.println(stu.getName() + "..." + stu.getAge());
        }
    }


}


class Student4 implements Comparable{
    private  String name;
    private int age;

    public Student4(String name, int age) {
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
        if(!(o instanceof  Student4)){
            throw  new RuntimeException("不是学生对象");
        }
        Student4 s = (Student4)o;//人家要的结果是不是正数负数和0啊  那么紧跟着怎么判断
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
//自定义比较器
class MyCompare implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Student4  s1  =(Student4) o1;
        Student4  s2  =(Student4) o2;
        return  s1.getName().compareTo(s2.getName());//这里是字符串的比较器

    }
}