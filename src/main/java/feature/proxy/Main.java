package feature.proxy;

/**
 * @author zhangyanqi
 * @since 1.0 2019-02-08
 */
public class Main {

    interface I {

        public void hello();
    }

    class Iimpl implements feature.proxy.Main.I {
        public void hello() {
            System.out.println("fuck");
        }
    }

    //jdk


    //cglib
    public static void main(String[] args) {


    }
}
