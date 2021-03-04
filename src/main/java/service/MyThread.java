package service;

/**
 * @author EnochStar
 * @title: MyThread
 * @projectName jedis_use
 * @description: TODO
 * @date 2021/3/4 16:23
 */
public class MyThread extends Thread{
    Service sc;

    public MyThread(String id,int num) {
        sc = new Service(id,num);
    }

    @Override
    public void run() {
        while (true) {
            sc.service();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
