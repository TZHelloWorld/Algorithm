package com.Tree;

import java.util.PriorityQueue;

public class heap {
    // 在编程时候，可以考虑使用优先队列来模拟堆，而不需要自己实现
    public static void main(String[] args) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> x - y);

        // public boolean add(E e); //在队尾插入元素，插入失败时抛出异常，并调整堆结构
        //public boolean offer(E e); //在队尾插入元素，插入失败时抛出false，并调整堆结构
        //
        //public E remove(); //获取队头元素并删除，并返回，失败时前者抛出异常，再调整堆结构
        //public E poll(); //获取队头元素并删除，并返回，失败时前者抛出null，再调整堆结构
        //
        //public E element(); //返回队头元素（不删除），失败时前者抛出异常
        //public E peek()；//返回队头元素（不删除），失败时前者抛出null
        //
        //public boolean isEmpty(); //判断队列是否为空
        //public int size(); //获取队列中元素个数
        //public void clear(); //清空队列
        //public boolean contains(Object o); //判断队列中是否包含指定元素（从队头到队尾遍历）
        //public Iterator<E> iterator(); //迭代器

        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            heap.add(100 - i); // 加入
        }

        for (int i = 0; i < 100; i++) {
//            System.out.println(heap.poll()); // 删除
            System.out.println(heap);

        }

    }

}
