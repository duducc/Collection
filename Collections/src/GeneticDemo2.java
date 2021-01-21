import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 */
public class GeneticDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(new LenComparator());//在这里传入一个比较器对象
        ts.add("abcd");
        ts.add("cc");
        ts.add("cha");
        ts.add("aaa");
        ts.add("z");
        ts.add("hahaha");
        Iterator<String> it =  ts.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);//会排序输出
        }
    }

}


//按照排序输出 自定义一个比较器
//在api文档当中 COmparator<T>  这个里面写的是T  T和E是无所谓的  type 类型 就是一个变量名
//会发现 上面是T  下面的方法中也是T  方法compare方法中的参数也是T  所以在Comparator中添加泛型之后就不需要强转了       这个时候方法中的Object 就可以写 String了  如第一个方法
//因为人家不是在comparator<String>中指定了T吗  那么在方法compare中是不是也跟着T  那么传一个具体参数String  那么compare是不是也跟着叫String  这就是泛型  你指定泛型了
//Comparable<T>  这个是不是也有泛型  这个时候你会发现终于避免了强转麻烦  你知道我们在写HashSet 的时候是不是覆盖了方法 一个叫做 hashcode 一个叫equals  这个equals  里边   你复写的是Object中的equals  但是Object 没有泛型
//那个必须得转换 转换之前呢 还要判断他是不是这种类型  那个必须要转换
//原来我们需要自定一个对象的话 我们需要定义一个hashcode 和equals  同时还需要实现Comparator接口  是不是让学生具备默认的比较性  用不用不一定  反正是我给你写上了  这样的话  既可以存放到 Hashset当中又可以 存放到TreeSet当中
// 光描述一个对象就是说  有  hashcode   equals    compare   还有一个toString()

//此Demo说明了泛型在比较器当中的应用  而且代码越来越简单 而且要安全很多
class  LenComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));//若想倒序把他们倒个个就好了
        if(num==0){
            return o2.compareTo(o1);
        }

        return num;
    }

   /* @Override
    public int compare(Object o1, Object o2) {
        //String s1 =  (String)01;
        //String s2 =  (String)02;
        return 0;
    }*/


}
