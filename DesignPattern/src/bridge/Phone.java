package bridge;

/**
 * 一个Phone的销售策略可能会有多个类，未来可能拓展出很多的销售方式
 * 可以将销售方式单独的抽离出抽象类，通过组合的方式，组合到Phone当中去。
 */
//抽象化角色
public abstract class Phone {

    SaleStrategy saleStrategy;

    public void setSaleStrategy(SaleStrategy saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public abstract void BuyPhone();

}
