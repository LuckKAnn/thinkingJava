/**
 * @FileName: HungryStaticConstantSingleton
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/2 11:30
 */
/**
 * 恶汉模式-静态常量，简洁直观
 *
 *

 优点

 由于使用了static关键字，保证了在引用这个变量时，关于这个变量的所有写入操作都完成，所以保证了JVM层面的线程安全。

 缺点

 不能实现懒加载，造成空间浪费。如果一个类比较大，我们在初始化的时就加载了这个类，但是我们长时间没有使用这个类，这就导致了内存空间的浪费。


 */
public class HungryStaticConstantSingleton{
    //构造器私有化
    private HungryStaticConstantSingleton() {
    }
    //静态变量保存实例变量 并提供给外部实例
    public final static HungryStaticConstantSingleton INSTANCE = new HungryStaticConstantSingleton();
}