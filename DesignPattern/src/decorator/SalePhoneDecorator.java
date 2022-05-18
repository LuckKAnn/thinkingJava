package decorator;

public abstract class SalePhoneDecorator implements SalePhone {

    SalePhone salePhone;

    @Override
    public void sale() {

        System.out.println("增加积分功能");
        salePhone.sale();
        System.out.println("增加评价功能");
    }
}
