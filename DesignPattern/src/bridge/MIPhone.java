package bridge;

/**
 * @FileName: MIPhone
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 16:47
 */

/**
 * 小米手机
 *
 * 拓展抽抽象化角色
 */
public class MIPhone extends Phone {

    MIPhone(SaleStrategy saleStrategy){
        this.saleStrategy = saleStrategy;
    }

    @Override
    public void BuyPhone() {
        this.saleStrategy.sales();
        System.out.println("获取到小米手机");

    }
}
