import javafx.beans.value.ObservableValueBase;

import java.util.LinkedList;

/**
 * 使用LinkedList模拟一个堆栈或者队列数据结构
 *
 * 堆栈 ：先进后出   如同一个杯子
 * 队列： 先进先出   如同一个水管
 *
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Duilie dl = new Duilie();
        dl.myAdd("java01");
        dl.myAdd("java02");
        dl.myAdd("java03");
        dl.myAdd("java04");
        while (!dl.isNull()){
            System.out.println(dl.myGet());
        }
       //若想 输出结果为 java04 ......  将封装的方法里面的removeFirst改为removeLast
    }


}

/**
 * 为什么要封装   直接用LinkList是可以完成的 但是LinkedList他只有自身含义链表  我们想把它做成和我们项目相关的一些容器
 * 那么我们需要起一些特定名称  来用更方便一些  这时候我们会把它封装进我们的描述当中并对外提供一个更能识别的一个名字 方法
 * javaweb 里面 那些 session  application  呢   里边全用的都是这些集合  全封装起来了 你也不知道 它给提供更有意义的名称  很多见
 */
class Duilie{
    private LinkedList link;
    Duilie() {
        link = new LinkedList();
    }
    public void myAdd(Object obj){
        link.addFirst(obj);
    }
    public Object  myGet(){
       return  link.removeLast();
    }
    public boolean isNull(){
        return  link.isEmpty();
    }
}
