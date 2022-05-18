package bridge;

/**
 * @FileName: TestBridge
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 16:51
 */
public class TestBridge {
    /**
     * - 因为销售渠道有多种拓展，手机也有多种拓展，如果通过集成的方式来做，那会比较麻烦，使用桥接模式，想到于在手机类和销售渠道之间架起桥梁，而不是对每个销售渠道的实现类架起独立的桥梁。
     * - 桥接发生在系统设计期间。分离具有多维度的属性（分离能够引起类变化的属性）。桥接模式可以减少实现类的数量。
     *   - **如果不用桥接的方式的话，假如有三种手机类，那么需要对应实现六种类，就是类A线下，类A线上。但是如果用了这种桥接模式，类的数量就是五个，而不是六个。**
     * @param args
     */
    public static void main(String[] args) {
        MIPhone miPhone = new MIPhone(new OfflineStrategy());
        miPhone.BuyPhone();
    }
}
