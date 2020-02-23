package algorithm.位计算;

/**
 * @author zhangyanqi
 * @since 1.0 2020-02-23
 */
public class Test {


    public static void main(String[] args) {

        //java 中 一个int 4 byte   >> 与 << 都是算数操作，最高位为符号位，不参与移动

        int i = 100;
        System.out.println(i << 1);
        System.out.println(i >> 1);

        int b = -100;
        System.out.println(b << 1);
        System.out.println(b >> 1);


        System.out.println(2147483647 << 1);
    }
}
