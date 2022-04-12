/**
 * @FileName: PersonSingleton
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/2 11:25
 */
public class PersonSingleton {
    private String age;

    //懒汉、饿汉
    private volatile static PersonSingleton instance;  //饿汉

    //构造器私有，外部不能实例化
    private PersonSingleton() {
        System.out.println("创建了Person");
    }


    //提供给外部的方法
    //1、public static synchronized Person guiguBoss() 锁太大
    //2、双重检查锁+内存可见性（设计模式）
    public static PersonSingleton guiguBoss() {
        //如果没有再去创建
        if (instance == null) {
            synchronized (PersonSingleton.class) {
                if(instance == null){
                    PersonSingleton person = new PersonSingleton();
                    //多线程问题
                    instance = person;
                }
            }
        }
        return instance;
    }
}
