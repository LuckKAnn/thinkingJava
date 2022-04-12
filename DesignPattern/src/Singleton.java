import java.io.Serializable;

/**
 * @author : LuckKAnn
 * @date : 16:49 2021/9/17
 * @email: 1546165200@qq.com
 * 用枚举类型进行单例设计
 */
public enum  Singleton {
    INSTANCE;
    public  void  m(){
        System.out.println("执行任务逻辑");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Singleton.INSTANCE.hashCode());
                Singleton.INSTANCE.m();
            },"A").start();
        }
    }
}
