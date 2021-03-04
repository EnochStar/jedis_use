import service.MyThread;

/**
 * @author EnochStar
 * @title: Main
 * @projectName jedis_use
 * @description: TODO
 * @date 2021/3/4 16:23
 */
public class Main{
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("001",10);
        myThread1.start();
        MyThread myThread2 = new MyThread("002",30);
        myThread2.start();
    }
}