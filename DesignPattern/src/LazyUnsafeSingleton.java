/**
 * @FileName: LazyUnsafeSingleton
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/2 11:31
 */
/**
 * 懒汉模式-线程不安全的，适用于单线程
 * 同样是构造方法私有化，提供给外部获得实例的方法，getInstance()方法被调用时创建实例。该方式适用于单线程，因为在多线程的情况下可能会发生线程安全问题，导致创建不同实例的情况发生。可以看下面的演示。
 */
public class LazyUnsafeSingleton{
    private LazyUnsafeSingleton(){
    }
    private static LazyUnsafeSingleton instance;
    public static LazyUnsafeSingleton getInstance(){
        if(instance==null){ //可以出现线程不安全问题
            instance = new LazyUnsafeSingleton();
        }
        return instance;
    }
}