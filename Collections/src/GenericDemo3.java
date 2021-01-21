
/*
class Tool{
    private  Worker w;

    public void setWorker(Worker w) {
        this.w = w;
    }
    public Worker getWorker() {
        return w;
    }
}
*/


class Worker{

}
class Student{

}


//泛型后的做法
class Tool{
    private  Object obj;

    public void setObject(Object obj) {
        this.obj = obj;
    }
    public Object getObject() {
        return obj;
    }
}


//泛型后的做法

//假如现在我要定义一个对象用来  设置获取这个对象  具体操作那个对象我也不知道  怎么办
//定义一个参数  对方在操作你工具类的时候 由他来指定他要操作什么对象  由对方来指定要操作什么类型的对象
// 这个时候  我在类上定一个参数 叫做QQ 例 Utils<QQ>
class Utils<QQ>{//这就是泛型类  就是带泛型的类  这样有什么好处
    private QQ q;

    public void setObject(QQ q) {
        this.q = q;
    }

    public QQ getObject() {
        return q;
    }
}

/**
 * 泛型类的出现  避免了强转 将错误转移到了编译时期
 */
public class GenericDemo3 {

    public static void main(String[] args) {

        //泛型后的做法  泛型类的使用

        Utils<Worker>  u  = new Utils<Worker>();//在这里你是不是带着参数 这里要不要   你传就对了

        u.setObject(new Worker());
        Worker W = (Worker) u.getObject();
        //以上代码编译 运行时没有问题的  然后将需要强转添加的(Worker)删除   编译 运行也没有问题  需要强转吗  不用了  若不小心传了一个Student 编译  失败了 直接让问发生在了编译时期
        //这就是泛型类 是不是在上面定义参数类似QQ就完事了
        //什么时候定义泛型类？
        //当勒种要操作的引用数据类型（基本数据不确定 定义不了  只能是引用的）不确定的时候  早期定义Object来完成扩展  现在定义泛型来完成

        //泛型前的做法
        //Tool t = new Tool();
        //t.setWorker(new Worker());
       // t.getWorker();

        //t.setObject(new Worker());
        //Worker w = (Worker)t.getObject();
    }
    //在这里除了描述工人以外还要描述学生   那么是不是也要搞一个描述学生的工具类  在这里new是可以的  如果这个对象new起来比较复杂的话 我们可以通过一些工具来做这些事情  可是
    //你会发现 一个类对应一个工具类是不是好麻烦  怎么做方便  你如果只为设置对象或者获取对象的话  对象不确实 都是获取来的  我是不是可以提高我程序的扩展性  我是不是可以抽取这些对象的共性类型  怎么做
    //先注释掉Toos工具类  这么做    worker  students 都是后期出现的 在不确定的情况下怎么办  可以将tool中对象类型改为Object 引用换为obj  这样是不是觉得通用 学生和worker都通用

    //这个时候在main方法中    需要这么改写方法  先注释方法t.setWorker(new Worker());  t.getWorker();  然后添加方法   t.setObject(new Worker());  Worker w = (Worker)t.getObject(); 然后运行 是没有问题的
    //假如现在我不小心 往里面传的不是new worker() 而是new Student()  编译也没有问题   因为 setObject(Object obj) 方法接收的参数类型是Object  这个时候运行  然后就报了错误 类型转换异常
    //那么这个时候怎么办呢 那就必须自己明确你往里面传的是什么  获取的是什么 需要你主观去判断  类似 tool  以前设计的时候都用来程序扩展  最明显的就是equals  他就是用Object
    //在API文档中jdk1.4之前打开  ArryaList  发现是没有泛型的   接收的参数类型都是Object  所以你往里边存Object  是不是被提升了 因此取出来的也是Object  这个是早期做法  是ok的 但是要强转
    //那有了泛型  类是怎么定义的呢  见  泛型后的做法




}




