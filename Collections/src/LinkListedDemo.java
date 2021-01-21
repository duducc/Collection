import java.util.LinkedList;

/**
 *   LinkList:特有方法
 *   addFirst()
 *   addLast()
 *
 *   获取元素  但不删除元素
 *   getFirst()
 *   getLast()
 *
 *   获取元素 但是元素被删除  get只是取  remove  不仅取 还删
 *   removeFirst()  移除并返回此列表的第一个元素
 *   removeLast()  移除并返回此列表的最后一个元素
 *
 *   当此列表为空的时候 增删的时候会抛出 没有这个元素异常
 *   在jdk1.6出现了替代方法
 *   offerFirst();
 *
 *   pollFirst()  获取并移除此列表的第一个元素，如果此列表为空  不抛出异常 而是返回 null  以后用这个  1.6版本  之前的remove
 *
 *   peekFirst()  获取但不移除此列表的第一个元素   之前的get
 *
 */
public class LinkListedDemo {
    public static void main(String[] args) {
        LinkedList link  = new LinkedList();
       /* link.addFirst("java01");
        link.addFirst("java02");
        link.addFirst("java03");
        link.addFirst("java04");*/
       link.addLast("java01");
       link.addLast("java02");
       link.addLast("java03");
       link.addLast("java04");

      /*  sop(link);
        sop(link.getFirst());
        sop(link.getLast());
        sop("测试1："+link.removeFirst());
        sop("测试2："+link.removeFirst());*/

        //运行结果为  java01  java02     因为第一个被删除了  所以第二个为第一个了


        //sop("size="+link.size());
         //获取全部元素  不能 getfirst  取的都是第一个
        while (!link.isEmpty()){
            sop(link.removeFirst());
        }

    }




    public static  void  sop(Object obj){
        System.out.println(obj);
    }



}
