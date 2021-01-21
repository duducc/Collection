

//这里面操作的类型是不是不确定   传什么就是什么呗
class Demo<T>{
    //在这里显示(show方法）什么不知道
    public void show(T t){

        System.out.println("show:"+t);
    }
    public  void print(T t){
        System.out.println("print:"+t);

    }

    /*public void show(String s){

    }

    public  void print(Integer i){

    }*/

}
class Demo2{
    //你这里的T算啥啊  这T定义过吗 没有 你随便写个T出来  没有T中类型   会编译失败  怎么定义呢 把泛型定义在方法上 其实很简单   可以这样写 public <T> void show(T t)
    public <T> void show(T t){
        System.out.println("show:"+t);
    }
    public <Q> void print(Q q){//都想成T 没有关系 都是只在对应方法上有效 为了区分换成
        System.out.println("print:"+q);
    }
    //在main方法中运行之后是不是都可以打印了   泛型定义在方法上 你是不是往里面传什么类型 他就操作什么类型  如下：
    //Demo2 demo2 = new Demo2();
    //demo2.show("haha");
    //demo2.show(new Integer(4));
    //demo2.print("heihie");

    //如果你的类产生的对象 类型一明确 这些方法都跟着走的话 是不是定义在类上最方便  集合是不是就是这么回事  是 集合就是  Arraylist 类型只要类型一明确  是不是他  添加 删除方法  是不是操作都是同一类型  迭代的时候也就是的
    //
}
/**
 * 泛型方法
 * 泛型除了可以定义在类上 还可以定义在方法上
 *
 * 前面不是有个方法  public void  setObject(QQ q)  QQ  这不是的吗？  答案是这不是的
 */
public class GenericDemo4 {

    public static void main(String[] args) {
        //开始操作  你要操作什么  假如  我要操作String
        Demo<String>   d1 = new Demo<String>();
        d1.show("haha");
        d1.print("hehe");
        //假如这里我不想打印字符串  随你便

        //如 下例  会发现编译都不通过
        //d.show(new Integer(4));
        //d.print(9);

        Demo<Integer>   d = new Demo<Integer>();
        d.show(new Integer(4)); //是不是有自动装箱 所以 一下两个都可以
        d.print(9);

        //这个时候可能会觉得  这个有啥啊
        //但是在以前我们定义方法的时候是不是要明确定义参数类型啊  如show(String s)   print(Integer i)  现在是不是一个搞定了  传什么都行

        //但是现在 我想
        //d.show(new Integer(4));//1
        //d.print("haha");//2
        //在这里发现编译失败了  因为你在NEW 对象的时候 已经明确类型Integer了  那么这个对象在操作他的方法时  它的这些方法 全都Integer 所以d.show 1 的时候 上面的T已经是Integer了
        //这个时候如果我想打印执行 2  重新创建对象 重新打印  但是你若又想 show 一下 4 是不是又不行了  这就是泛型类的一个稍微的局限性
        //因为泛型类的占位符 T 一确定里面的方法参数类型什么的是不是全部就固定了  只要你对象一建立 要操作类型就确定了
        //但是现在我又想show打印Integer  pring打印 String  怎么做呢
        //为了不同方法可以操作不同类型 而且类型还不确定  那么可以将泛型定义在方法上



    }
}
