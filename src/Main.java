import java.util.*;
//import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        String input_string = input.next();//接收string类型
        int input_int = input.nextInt();//接收输入int类型

        System.out.println("第一次回车输出：" + input_string);
        System.out.println("第二次回车输出：" + input_int);

        Integer a = -124;
        Integer b = 124;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b);//true,在[-128,127]内创建的Integer对象都是重常量池里面拿的，所以地址指向的是同一个
        System.out.println(c == d);//false
        ArrayList<Integer> int_list = new ArrayList<Integer>();
        int_list.add(1);
        int_list.add(2);
        int_list.add(3);
        int_list.add(4);
        System.out.println(int_list.toString());


        System.out.println(3 * 0.1 == 0.3);

        System.out.println("Hello world!");
    }
}