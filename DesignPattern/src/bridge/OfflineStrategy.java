package bridge;

/**
 * @FileName: OfflineStrategy
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 16:50
 */
public class OfflineStrategy implements SaleStrategy{
    @Override
    public void sales() {
        System.out.println("通过线上的方式");
    }
}
