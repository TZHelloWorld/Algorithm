import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StudyMain {
    public static void main(String[] args) {

        // java提供的stack类有问题，推荐使用双端队列来模拟 Deque
        Stack<String> stack = new Stack<>();

        stack.push("123"); // 入栈
        stack.pop(); // 出栈
        stack.empty(); // 判断栈是否为空
//        stack.peek();// 查看栈顶元素数据


        // 对于队列：；Java中虽然有Queue接口 ，但并没有给出队列的实现类，而LinkedList实现了Queue接口。
        //要使用offer()来加入元素，使用poll()来获取并删除元素，可以通过返回值判断成与否。
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1); // 入队
        queue.offer(2);
        queue.offer(3);

        queue.poll();// 出队列
        queue.isEmpty(); // 判断队列是否为空


        int[] array = new int[20]; // 初始化一个数组
        Arrays.fill(array, -1); // 将数组数据全部填充为-1

        StringBuilder sb = new StringBuilder("hello world");
        String str = sb.toString();


        List<String> list = new ArrayList<String>();


        //对于jdk1.7的concurrenthashmap的安全性，是通过synchronized加在segment数组上来保证的，
        // 也就是我们常说的段锁，对于一个段加锁之后，这个段上其他的节点就不能被操作了，但是一个段上加锁之后，并不影响其他段的操作，所以就在安全的环境下大大提高了并发性。
        // Segment是Reentrant的子类，

        // jdk1.8 线程安全，加上了一层segment数组，以及使用了synchronized和CAS机制
        // 主要是操作的时候加上了锁的影响，在添加数据的时候会先对指定的节点加上Synchronized锁，然后在进行CAS方式插入数据，
        // 因为Synchronized锁的是数组中的一个几点而不是整个数组，所以并发也很高，初始的大小为16，阈值也是0.75。
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();



    }

}
